package egenius.Seller.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Entity
@Table(name= "sellers")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "seller_email", nullable = false, length = 20)
    private String sellerEmail;

    @Column(name = "business_number", nullable = false, length = 20)
    private String businessNumber;

    @Column(name = "seller_password", nullable = false, length = 20)
    private String sellerPassword;

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

    @Column(name = "seller_name", nullable = false, length = 20)
    private String sellerName;

    @Column(name = "call_center_number", nullable = false, length = 20)
    private String callCenterNumber;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "seller_status", nullable = false, columnDefinition = "tinyint")
    private Integer sellerStatus;

    @Column(name = "deactivate")
    private LocalDateTime deactivate;


    public static SellerEntity signUpSeller(String sellerEmail, String businessNumber, String sellerPassword, String mailOrderNumber,
                                            String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                            Integer businessType, String companyName, String companyAddress, LocalDate openedAt, String sellerName,
                                            String callCenterNumber, String phoneNumber, Integer sellerStatus) {
        return SellerEntity.builder()
                .sellerEmail(sellerEmail)
                .businessNumber(businessNumber)
                .sellerPassword(sellerPassword)
                .mailOrderNumber(mailOrderNumber)
                .brandName(brandName)
                .brandLogoImageUrl(brandLogoImageUrl)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .businessType(businessType)
                .companyName(companyName)
                .companyAddress(companyAddress)
                .openedAt(openedAt)
                .sellerName(sellerName)
                .callCenterNumber(callCenterNumber)
                .phoneNumber(phoneNumber)
                .sellerStatus(sellerStatus)
                .build();
    }

}
