package egenius.Seller.domain;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@Builder
@AllArgsConstructor
public class Seller {

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
    private Integer seller_status;
    private Date deactivate;


    public static Seller signUpSeller(String seller_email, String business_number, String seller_pw, String mail_order_number,
                                      String brand_name, String brand_logo_img, String brand_content, String homepage_url,
                                      Integer business_type, String company_name, String company_add, Date opened_at,
                                      String seller_name, String call_center_number, String phone_number, Integer seller_status) {
        return Seller.builder()
                .seller_email(seller_email)
                .business_number(business_number)
                .seller_pw(seller_pw)
                .mail_order_number(mail_order_number)
                .brand_name(brand_name)
                .brand_logo_img(brand_logo_img)
                .brand_content(brand_content)
                .homepage_url(homepage_url)
                .business_type(business_type)
                .company_name(company_name)
                .company_add(company_add)
                .opened_at(opened_at)
                .seller_name(seller_name)
                .call_center_number(call_center_number)
                .phone_number(phone_number)
                .seller_status(seller_status)
                .build();
    }

    public static Seller formSellerEntity(SellerEntity sellerEntity){
        return Seller.builder()
                .seller_email(sellerEntity.getSellerEmail())
                .business_number(sellerEntity.getBusinessNumber())
                .seller_pw(sellerEntity.getSellerPw())
                .mail_order_number(sellerEntity.getMailOrderNumber())
                .brand_name(sellerEntity.getBrandName())
                .brand_logo_img(sellerEntity.getBrandLogoImg())
                .brand_content(sellerEntity.getBrandContent())
                .homepage_url(sellerEntity.getHomepageUrl())
                .business_type(sellerEntity.getBusinessType())
                .company_name(sellerEntity.getCompanyName())
                .company_add(sellerEntity.getCompanyAdd())
                .opened_at(sellerEntity.getOpenedAt())
                .seller_name(sellerEntity.getSellerName())
                .call_center_number(sellerEntity.getCallCenterNumber())
                .phone_number(sellerEntity.getPhoneNumber())
                .seller_status(sellerEntity.getSellerStatus())
                .build();
    }


}
