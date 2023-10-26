package egenius.Seller.application.ports.out.dto;

import egenius.Seller.domain.Seller;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

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
    private Integer businessType;
    private String companyName;
    private String companyAddress;
    private Date openedAt;
    private String sellerName;
    private String callCenterNumber;
    private String phoneNumber;

    public static SellerDto formSellers(Seller seller){
        return SellerDto.builder()
                .sellerEmail(seller.getSellerEmail())
                .businessNumber(seller.getBusinessNumber())
                .sellerPw(seller.getSellerPw())
                .mailOrderNumber(seller.getMailOrderNumber())
                .brandName(seller.getBrandName())
                .brandLogoImg(seller.getBrandLogoImg())
                .brandContent(seller.getBrandContent())
                .homepageUrl(seller.getHomepageUrl())
                .businessType(seller.getBusinessType())
                .companyName(seller.getCompanyName())
                .companyAddress(seller.getCompanyAddress())
                .openedAt(seller.getOpenedAt())
                .sellerName(seller.getSellerName())
                .callCenterNumber(seller.getCallCenterNumber())
                .phoneNumber(seller.getPhoneNumber())
                .build();

    }

}
