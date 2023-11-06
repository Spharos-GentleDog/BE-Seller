package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FindVendorDto {

    private String vendorEmail;
    private String vendorPassword;
    private String brandName; // 브랜드 이름
    private String brandLogoImageUrl; // 브랜드 로고 이미지 url
    private LocalDateTime deactivate; // 탈퇴 날짜

    public static FindVendorDto formFindVendor(String vendorEmail, String vendorPassword,
                                               String brandName, String brandLogoImageUrl, LocalDateTime deactivate){
        return FindVendorDto.builder()
                .vendorEmail(vendorEmail)
                .vendorPassword(vendorPassword)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .deactivate(deactivate)
                .build();
    }

}
