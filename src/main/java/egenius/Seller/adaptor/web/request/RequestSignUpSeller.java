package egenius.Seller.adaptor.web.request;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class RequestSignUpSeller {

    // 회원 가입시 Front에서 전달 받는 데이터

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

}
