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

        public static SignUpQuery toQuery(RequestSignUpSeller requestSignUpSeller){
            return SignUpQuery.builder()
                    .sellerEmail(requestSignUpSeller.getSellerEmail())
                    .businessNumber(requestSignUpSeller.getBusinessNumber())
                    .sellerPw(requestSignUpSeller.getSellerPw())
                    .mailOrderNumber(requestSignUpSeller.getMailOrderNumber())
                    .brandName(requestSignUpSeller.getBrandName())
                    .brandLogoImg(requestSignUpSeller.getBrandLogoImg())
                    .brandContent(requestSignUpSeller.getBrandContent())
                    .homepageUrl(requestSignUpSeller.getHomepageUrl())
                    .businessType(requestSignUpSeller.getBusinessType())
                    .companyName(requestSignUpSeller.getCompanyName())
                    .companyAddress(requestSignUpSeller.getCompanyAddress())
                    .openedAt(requestSignUpSeller.getOpenedAt())
                    .sellerName(requestSignUpSeller.getSellerName())
                    .callCenterNumber(requestSignUpSeller.getCallCenterNumber())
                    .phoneNumber(requestSignUpSeller.getPhoneNumber())
                    .build();
        }
    }

}
