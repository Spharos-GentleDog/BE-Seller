package egenius.Seller.application.ports.in;

import egenius.Seller.adaptor.web.request.RequestSignUpSeller;
import egenius.Seller.application.ports.out.dto.SellerDto;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

public interface SignUpUseCase {

    //request에서 받은 데이터를 Dto로 전달
    // 하나의 Usecase는 하나의 기능만 하도록 작성해야 한다 (유지보수성 때문에)
    SellerDto signUpSeller(SignUpQuery signUpQuery);

    @Getter
    @Builder
    class SignUpQuery{

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

        public static SignUpQuery toQuery(RequestSignUpSeller requestSignUpSeller){
            return SignUpQuery.builder()
                    .seller_email(requestSignUpSeller.getSeller_email())
                    .business_number(requestSignUpSeller.getBusiness_number())
                    .seller_pw(requestSignUpSeller.getSeller_pw())
                    .mail_order_number(requestSignUpSeller.getMail_order_number())
                    .brand_name(requestSignUpSeller.getBrand_name())
                    .brand_logo_img(requestSignUpSeller.getBrand_logo_img())
                    .brand_content(requestSignUpSeller.getBrand_content())
                    .homepage_url(requestSignUpSeller.getHomepage_url())
                    .business_type(requestSignUpSeller.getBusiness_type())
                    .company_name(requestSignUpSeller.getCompany_name())
                    .company_add(requestSignUpSeller.getCompany_add())
                    .opened_at(requestSignUpSeller.getOpened_at())
                    .seller_name(requestSignUpSeller.getSeller_name())
                    .call_center_number(requestSignUpSeller.getCall_center_number())
                    .phone_number(requestSignUpSeller.getPhone_number())
                    .build();
        }
    }

}
