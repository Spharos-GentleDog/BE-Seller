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
//    private Collection<?> authorities; // 권한
    private String role;

    public static SignInDto formSignIn(String accessToken, String refreshToken, String vendorEmail, String brandName,
                                       String brandLogoImageUrl, String role){
        return SignInDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .vendorEmail(vendorEmail)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .role(role)
                .build();
    }
}
