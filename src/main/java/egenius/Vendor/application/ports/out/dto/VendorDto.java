package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class VendorDto {

    // 비지니스 로직 상 결과 값으로 받을 정보
    private String vendorEmail;
    private String businessNumber;
    private String vendorPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private String businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String vendorName;
    private String callCenterNumber;
    private String vendorPhoneNumber;
    private String vendorStatus;

    public static VendorDto formVendors(String vendorEmail, String businessNumber, String vendorPassword, String mailOrderNumber,
                                        String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                        String businessType, String companyName, String companyAddress, LocalDate openedAt,
                                        String vendorName, String callCenterNumber, String vendorPhoneNumber, String vendorStatus){
        return VendorDto.builder()
                .vendorEmail(vendorEmail)
                .businessNumber(businessNumber)
                .vendorPassword(vendorPassword)
                .mailOrderNumber(mailOrderNumber)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .businessType(businessType)
                .companyName(companyName)
                .companyAddress(companyAddress)
                .openedAt(openedAt)
                .vendorName(vendorName)
                .callCenterNumber(callCenterNumber)
                .vendorPhoneNumber(vendorPhoneNumber)
                .vendorStatus(vendorStatus)
                .build();

    }

}
