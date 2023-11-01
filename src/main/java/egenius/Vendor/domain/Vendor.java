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

    private String VendorEmail;
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


    public static Vendor signUpVendor(String VendorEmail, String businessNumber, String vendorPassword, String mailOrderNumber,
                                      String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                      BusinessTypes businessType, String companyName, String companyAddress, LocalDate openedAt,
                                      String VendorName, String callCenterNumber, String vendorPhoneNumber, VendorStatus VendorStatus) {
        return Vendor.builder()
                .VendorEmail(VendorEmail)
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


}
