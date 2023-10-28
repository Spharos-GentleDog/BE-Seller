package egenius.Seller.application.ports.in;

import egenius.Seller.adaptor.web.request.RequestCheckEmail;
import egenius.Seller.application.ports.out.dto.CheckEmailDto;
import lombok.Builder;
import lombok.Getter;


public interface CheckEmailUseCase {

    CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery);

    @Getter
    @Builder
    class CheckEmailQuery{

        private String sellerEmail;

        public static CheckEmailQuery toQuery(RequestCheckEmail requestEmailCheck){
            return CheckEmailQuery.builder()
                    .sellerEmail(requestEmailCheck.getSellerEmail())
                    .build();
        }
    }
}
