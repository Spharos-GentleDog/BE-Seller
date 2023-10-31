package egenius.Seller.application.ports.in.query;

import egenius.Seller.adaptor.web.request.RequestCheckEmail;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckEmailQuery{

    private String sellerEmail;

    public static CheckEmailQuery toQuery(RequestCheckEmail requestEmailCheck){
        return CheckEmailQuery.builder()
                .sellerEmail(requestEmailCheck.getSellerEmail())
                .build();
    }
}
