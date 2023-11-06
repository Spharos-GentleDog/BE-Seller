package egenius.Vendor.domain;

import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.VendorStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Vendor {

    // 도메인 로직이 위치하는 곳
    // 도메인과 관련된 데이터 와 규칙이 들어 있어야 한다
    private String vendorEmail;
    private String businessNumber;
    private String vendorPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private BusinessTypes businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String VendorName;
    private String callCenterNumber;
    private String vendorPhoneNumber;
    private VendorStatus VendorStatus;
    private LocalDateTime deactivate;


    public static Vendor signUpVendor(String vendorEmail, String businessNumber, String vendorPassword, String mailOrderNumber,
                                      String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                      BusinessTypes businessType, String companyName, String companyAddress, LocalDate openedAt,
                                      String VendorName, String callCenterNumber, String vendorPhoneNumber, VendorStatus VendorStatus) {
        return Vendor.builder()
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
                .VendorName(VendorName)
                .callCenterNumber(callCenterNumber)
                .vendorPhoneNumber(vendorPhoneNumber)
                .VendorStatus(VendorStatus)
                .build();
    }

    public static Vendor signInVendor(String vendorEmail, String vendorPassword) {
        return Vendor.builder()
                .vendorEmail(vendorEmail)
                .vendorPassword(vendorPassword)
                .build();
    }


}
