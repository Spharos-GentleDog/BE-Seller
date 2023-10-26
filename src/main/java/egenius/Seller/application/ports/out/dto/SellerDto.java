package egenius.Seller.application.ports.out.dto;

import egenius.Seller.domain.Seller;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

@Getter
@Builder
public class SellerDto {

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

    public static SellerDto formSellers(Seller seller){
        return SellerDto.builder()
                .seller_email(seller.getSeller_email())
                .business_number(seller.getBusiness_number())
                .seller_pw(seller.getSeller_pw())
                .mail_order_number(seller.getMail_order_number())
                .brand_name(seller.getBrand_name())
                .brand_logo_img(seller.getBrand_logo_img())
                .brand_content(seller.getBrand_content())
                .homepage_url(seller.getHomepage_url())
                .business_type(seller.getBusiness_type())
                .company_name(seller.getCompany_name())
                .company_add(seller.getCompany_add())
                .opened_at(seller.getOpened_at())
                .seller_name(seller.getSeller_name())
                .call_center_number(seller.getCall_center_number())
                .phone_number(seller.getPhone_number())
                .build();

    }

}
