package egenius.Seller.adaptor.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
public class RequestSignUpSeller {

    // 회원 가입시 Front에서 전달 받는 데이터

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

}
