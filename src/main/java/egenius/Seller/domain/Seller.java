package egenius.Seller.domain;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

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
    private Date openedAt;
    private String sellerName;
    private String callCenterNumber;
    private String phoneNumber;
    private String sellerStatus;
    private Date deactivate;


    public static Seller signUpSeller(String sellerEmail, String businessNumber, String sellerPw, String mailOrderNumber,
                                      String brandName, String brandLogoImg, String brandContent, String homepageUrl,
                                      String businessType, String companyName, String companyAddress, Date openedAt,
                                      String sellerName, String callCenterNumber, String phoneNumber, String sellerStatus) {
        return Seller.builder()
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

//    // 이게 왜 여기 있지.......???????????????
//    public static Seller formSellerEntity(SellerEntity sellerEntity){
//        return Seller.builder()
//                .sellerEmail(sellerEntity.getSellerEmail())
//                .businessNumber(sellerEntity.getBusinessNumber())
//                .sellerPw(sellerEntity.getSellerPw())
//                .mailOrderNumber(sellerEntity.getMailOrderNumber())
//                .brandName(sellerEntity.getBrandName())
//                .brandLogoImg(sellerEntity.getBrandLogoImg())
//                .brandContent(sellerEntity.getBrandContent())
//                .homepageUrl(sellerEntity.getHomepageUrl())
//                .businessType(sellerEntity.getBusinessType())
//                .companyName(sellerEntity.getCompanyName())
//                .companyAddress(sellerEntity.getCompanyAddress())
//                .openedAt(sellerEntity.getOpenedAt())
//                .sellerName(sellerEntity.getSellerName())
//                .callCenterNumber(sellerEntity.getCallCenterNumber())
//                .phoneNumber(sellerEntity.getPhoneNumber())
//                .sellerStatus(sellerEntity.getSellerStatus())
//                .build();
//    }


}
