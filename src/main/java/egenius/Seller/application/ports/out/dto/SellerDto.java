package egenius.Seller.application.ports.out.dto;

import egenius.Seller.adaptor.infrastructure.mysql.enums.BusinessTypes;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Builder
public class SellerDto {

    private String sellerEmail;
    private String businessNumber;
    private String sellerPw;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImg;
    private String brandContent;
    private String homepageUrl;
    private String businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String sellerName;
    private String callCenterNumber;
    private String phoneNumber;
    private String sellerStatus;

    //Seller Ent
    public static SellerDto formSellers(String sellerEmail, String businessNumber, String sellerPw, String mailOrderNumber,
                                        String brandName, String brandLogoImg, String brandContent, String homepageUrl,
                                        String businessType, String companyName, String companyAddress, LocalDate openedAt,
                                        String sellerName, String callCenterNumber, String phoneNumber, String sellerStatus){
        return SellerDto.builder()
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
                .companyAddress(companyAddress)
                .openedAt(openedAt)
                .sellerName(sellerName)
                .callCenterNumber(callCenterNumber)
                .phoneNumber(phoneNumber)
                .sellerStatus(sellerStatus)
                .build();

    }

}
