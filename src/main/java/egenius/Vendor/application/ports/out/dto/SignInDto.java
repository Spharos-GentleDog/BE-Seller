package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Collection;

@Getter
@Builder
public class SignInDto {

    private String accessToken;
    private String refreshToken;
    private String vendorEmail;
    private String brandName; // 브랜드 이름
    private String brandLogoImageUrl;
    private Collection<?> authorities; // 권한


    public static SignInDto formSignIn(String accessToken, String refreshToken, String vendorEmail, String brandName,
                                       String brandLogoImageUrl, Collection<?> authorities){
        return SignInDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .vendorEmail(vendorEmail)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .authorities(authorities)
                .build();
    }
}
