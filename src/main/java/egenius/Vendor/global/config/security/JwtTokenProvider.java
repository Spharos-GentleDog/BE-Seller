package egenius.Vendor.global.config.security;

import egenius.Vendor.global.common.exception.BaseException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {

    @Value("${JWT.secret-key}")
    private String secretKey;

    @Value("${jwt.token.refresh-expiration-time}")
    private long refreshExpirationTime;

    private final RedisTemplate<String, String> redisTemplate;

    //토큰 생성
    public String generateToken(UserDetails userDetails) {

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSiginKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //jwt토큰에서 모든 클레임(클레임은 토큰에 담긴 정보 의미 ) 추출한 다음 claimsResolver함수를 처리해 결과 반환
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) throws BaseException {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    // 토큰 생성을 위한 signKey를 생성
    private Key getSiginKey() {
        byte[] key = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(key);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder() // 토큰 파싱
                .setSigningKey(getSiginKey()) // 토큰 생성 시 사용했던 signKey를 사용
                .build()//  토큰 파서 생성
                .parseClaimsJws(token) // 파싱할 토큰
                .getBody(); // 토큰에서 추출한 클레임 반환
    }

    // token에서 email 추출해 내기
    public String ExtractVendorEmail(String token) throws BaseException {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * 6
     * @param token 검증할 토큰
     * @param userDetails 사용자 정보
     * @return jwt토큰 유효성 검사
     * 토큰에서 추출한 UUID가 userDetails에서 가져온 사용자 id가 일치하며
     * 토큰이 만료되지 않은경우 토큰 유효
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String email = ExtractVendorEmail(token);
        //  뽑아온 email과 받은 email가 같고 유효기간이 지나지 않았다면
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    //  만료 비교
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    //  JWT 토큰에서 만료 시간 클레임을 추출하여 반환합니다.
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //  3개로 이루어진 키값을 풀기위한 메소드
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String buildToken(
            Map<String, Objects> extractClaims,
            UserDetails userDetails,
            long expiration

    ) {

        log.info("generateToken {} ", userDetails);
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + expiration))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     *
     * @param userDetails 사용자 정보
     * @return
     * Refresh Token 역활
     */

    public String generateRefreshToken(UserDetails userDetails) {

        String refreshToken = buildToken(Map.of(), userDetails, refreshExpirationTime);
        // redis에 저장
        redisTemplate.opsForValue().set(
                userDetails.getUsername(),
                refreshToken,
                refreshExpirationTime,
                TimeUnit.MILLISECONDS
        );
        log.info("refreshExpirationTime={}",refreshExpirationTime);
        log.info("TimeUnit.MILLISECONDS={}",TimeUnit.MILLISECONDS);

        return refreshToken;
    }


}
