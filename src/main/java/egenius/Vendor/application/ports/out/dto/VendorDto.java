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
    private String password;
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
    private String vendorStatus;

    public static VendorDto formVendors(String vendorEmail, String businessNumber, String password, String mailOrderNumber,
                                        String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                        String businessType, String companyName, String companyAddress, LocalDate openedAt,
                                        String vendorName, String callCenterNumber, String managerName, String managerPhoneNumber, String vendorStatus){
        return VendorDto.builder()
                .vendorEmail(vendorEmail)
                .businessNumber(businessNumber)
                .password(password)
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
                .vendorStatus(vendorStatus)
                .build();

    }

}
