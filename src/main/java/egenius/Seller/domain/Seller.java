package egenius.Seller.domain;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerEntity;
import egenius.Seller.domain.enums.BusinessTypes;
import egenius.Seller.domain.enums.SellerStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

    private String sellerEmail;
    private String businessNumber;
    private String sellerPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private BusinessTypes businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String sellerName;
    private String callCenterNumber;
    private String phoneNumber;
    private SellerStatus sellerStatus;
    private LocalDateTime deactivate;


    public static Seller signUpSeller(String sellerEmail, String businessNumber, String sellerPassword, String mailOrderNumber,
                                      String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                      BusinessTypes businessType, String companyName, String companyAddress, LocalDate openedAt,
                                      String sellerName, String callCenterNumber, String phoneNumber, SellerStatus sellerStatus) {
        return Seller.builder()
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
