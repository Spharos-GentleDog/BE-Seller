package egenius.Seller.adaptor.infrstructre.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Entity
@Table(name= "sellers")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "seller_email", nullable = false, length = 20)
    private String seller_email;

    @Column(name = "business_number", nullable = false, length = 20)
    private String business_number;

    @Column(name = "seller_pw", nullable = false, length = 20)
    private String seller_pw;

    @Column(name = "mail_order_number", nullable = false, length = 20)
    private String mail_order_number;

    @Column(name = "brand_name", nullable = false, length = 20)
    private String brand_name;

    @Column(name = "brand_logo_img", nullable = false, length = 100)
    private String brand_logo_img;

    @Column(name = "brand_content", length = 150)
    private String brand_content;

    @Column(name = "homepage_url", length = 100)
    private String homepage_url;

    @Column(name = "business_type")
    private Integer business_type;

    @Column(name = "company_name", nullable = false, length = 20)
    private String company_name;

    @Column(name = "company_add", length = 100)
    private String company_add;

    @Column(name = "opened_at", nullable = false )
    private Date opened_at;

    @Column(name = "seller_name", nullable = false, length = 20)
    private String seller_name;

    @Column(name = "call_center_number", nullable = false, length = 20)
    private String call_center_number;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phone_number;

    @Column(name = "seller_status", nullable = false)
    private Integer seller_status;

    @Column(name = "deactivate")
    private Date deactivate;


    public static SellerEntity SignUpSeller(String seller_email, String business_number, String seller_pw, String mail_order_number,
                                            String brand_name, String brand_logo_img, String brand_content, String homepage_url,
                                            Integer business_type, String company_name, String company_add, Date opened_at,String seller_name,
                                            String call_center_number, String phone_number, Integer seller_status) {
        return SellerEntity.builder()
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

}
