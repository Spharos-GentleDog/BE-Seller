package egenius.Seller.adaptor.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Getter
public class RequestSignUpSeller {

    // 회원 가입시 Front에서 전달 받는 데이터

    private String seller_email;
    private String business_number;
    private String seller_pw;
    private String mail_order_number;
    private String brand_name;
    private String brand_logo_img;
    private String brand_content;
    private String homepage_url;
    private Integer business_type;
    private String company_name;
    private String company_add;
    private Date opened_at;
    private String seller_name;
    private String call_center_number;
    private String phone_number;

}
