package egenius.Vendor.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Entity
@Table(name= "Vendors")
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "vendor_email", nullable = false, length = 20)
    private String vendorEmail;

    @Column(name = "business_number", nullable = false, length = 20)
    private String businessNumber;

    @Column(name = "vendor_password", nullable = false, length = 20)
    private String vendorPassword;

    @Column(name = "mail_order_number", nullable = false, length = 20)
    private String mailOrderNumber;

    @Column(name = "brand_name", nullable = false, length = 20)
    private String brandName;

    @Column(name = "brand_logo_image_url", nullable = false, length = 100)
    private String brandLogoImageUrl;

    @Column(name = "brand_content", length = 150)
    private String brandContent;

    @Column(name = "homepage_url", length = 100)
    private String homepageUrl;

    @Column(name = "business_type")
    private Integer businessType;

    @Column(name = "company_name", nullable = false, length = 20)
    private String companyName;

    @Column(name = "company_address", length = 100)
    private String companyAddress;

    @Column(name = "opened_at", nullable = false )
    private LocalDate openedAt;

    @Column(name = "vendor_name", nullable = false, length = 20)
    private String vendorName;

    @Column(name = "call_center_number", nullable = false, length = 20)
    private String callCenterNumber;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "vendor_status", nullable = false, columnDefinition = "tinyint")
    private Integer vendorStatus;

    @Column(name = "deactivate")
    private LocalDateTime deactivate;


    public static VendorEntity signUpVendor(String vendorEmail, String businessNumber, String vendorPassword, String mailOrderNumber,
                                            String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                            Integer businessType, String companyName, String companyAddress, LocalDate openedAt, String vendorName,
                                            String callCenterNumber, String phoneNumber, Integer vendorStatus) {
        return VendorEntity.builder()
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
                .phoneNumber(phoneNumber)
                .vendorStatus(vendorStatus)
                .build();
    }

}
