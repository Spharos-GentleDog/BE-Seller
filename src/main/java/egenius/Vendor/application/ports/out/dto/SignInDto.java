package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInDto {

    private String accessToken;
    private String refreshToken;
    private String vendorEmail;
    private String brandName; // 브랜드 이름
    private String brandLogoImageUrl; // 브랜드 로고 이미지 url
    private boolean isVendor;

    public static SignInDto formfindVendor(String vendorEmail, String brandName, String brandLogoImageUrl,boolean isVendor){
        return SignInDto.builder()
                .vendorEmail(vendorEmail)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .isVendor(isVendor)
                .build();
    }

    public static SignInDto formSignIn(String accessToken, String refreshToken, String vendorEmail, String brandName, String brandLogoImageUrl, boolean isVendor){
        return SignInDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .vendorEmail(vendorEmail)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .isVendor(isVendor)
                .build();
    }
}
