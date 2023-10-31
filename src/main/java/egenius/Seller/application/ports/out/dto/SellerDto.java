package egenius.Seller.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class SellerDto {

    // 비지니스 로직 상 결과 값으로 받을 정보
    private String sellerEmail;
    private String businessNumber;
    private String sellerPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
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

    public static SellerDto formSellers(String sellerEmail, String businessNumber, String sellerPassword, String mailOrderNumber,
                                        String brandName, String brandLogoImageUrl, String brandContent, String homepageUrl,
                                        String businessType, String companyName, String companyAddress, LocalDate openedAt,
                                        String sellerName, String callCenterNumber, String phoneNumber, String sellerStatus){
        return SellerDto.builder()
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
