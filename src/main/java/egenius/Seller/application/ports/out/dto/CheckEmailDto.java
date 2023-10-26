package egenius.Seller.application.ports.out.dto;

import egenius.Seller.domain.Seller;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckEmailDto {

    private String seller_email;

    public static CheckEmailDto formCheckEmail(String seller_email){
        return CheckEmailDto.builder()
                .seller_email(seller_email)
                .build();
    }
}
