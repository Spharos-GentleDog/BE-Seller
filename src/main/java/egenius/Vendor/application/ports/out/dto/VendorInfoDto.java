package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class VendorInfoDto {

    private String vendorEmail;
    private String businessNumber;
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
    private String managerName;
    private String managerPhoneNumber;

    public static VendorInfoDto formVendorInfo(String vendorEmail, String businessNumber, String mailOrderNumber,
                                        String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                        String businessType, String companyName, String companyAddress, LocalDate openedAt,
                                        String vendorName, String callCenterNumber, String managerName, String managerPhoneNumber){
        return VendorInfoDto.builder()
                .vendorEmail(vendorEmail)
                .businessNumber(businessNumber)
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
                .managerName(managerName)
                .managerPhoneNumber(managerPhoneNumber)
                .build();

    }
}
