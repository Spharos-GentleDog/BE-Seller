package egenius.Seller.adaptor.infrstructre.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

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

    @Column(name = "sellerEmail", nullable = false, length = 20)
    private String sellerEmail;

    @Column(name = "businessNumber", nullable = false, length = 20)
    private String businessNumber;

    @Column(name = "sellerPw", nullable = false, length = 20)
    private String sellerPw;

    @Column(name = "mailOrderNumber", nullable = false, length = 20)
    private String mailOrderNumber;

    @Column(name = "brandName", nullable = false, length = 20)
    private String brandName;

    @Column(name = "brandLogoImg", nullable = false, length = 100)
    private String brandLogoImg;

    @Column(name = "brandContent", length = 150)
    private String brandContent;

    @Column(name = "homepageUrl", length = 100)
    private String homepageUrl;

    @Column(name = "businessType")
    private Integer businessType;

    @Column(name = "companyName", nullable = false, length = 20)
    private String companyName;

    @Column(name = "companyAdd", length = 100)
    private String companyAdd;

    @Column(name = "openedAt", nullable = false )
    private Date openedAt;

    @Column(name = "sellerName", nullable = false, length = 20)
    private String sellerName;

    @Column(name = "callCenterNumber", nullable = false, length = 20)
    private String callCenterNumber;

    @Column(name = "phoneNumber", nullable = false, length = 20)
    private String phoneNumber;

    @Column(name = "sellerStatus", nullable = false)
    private Integer sellerStatus;

    @Column(name = "deactivate")
    private Date deactivate;


    public static SellerEntity SignUpSeller(String sellerEmail, String businessNumber, String sellerPw, String mailOrderNumber,
                                            String brandName, String brandLogoImg, String brandContent, String homepageUrl,
                                            Integer businessType, String companyName, String companyAdd, Date openedAt,String sellerName,
                                            String callCenterNumber, String phoneNumber, Integer sellerStatus) {
        return SellerEntity.builder()
                .sellerEmail(sellerEmail)
                .businessNumber(businessNumber)
                .sellerPw(sellerPw)
                .mailOrderNumber(mailOrderNumber)
                .brandName(brandName)
                .brandLogoImg(brandLogoImg)
                .brandContent(brandContent)
                .homepageUrl(homepageUrl)
                .businessType(businessType)
                .companyName(companyName)
                .companyAdd(companyAdd)
                .openedAt(openedAt)
                .sellerName(sellerName)
                .callCenterNumber(callCenterNumber)
                .phoneNumber(phoneNumber)
                .sellerStatus(sellerStatus)
                .build();
    }

}
