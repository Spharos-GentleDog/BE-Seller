package egenius.Seller.application.ports.out.dto;

import egenius.Seller.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CheckEmailDto {

    private boolean seller_email;

    public static CheckEmailDto formCheckEmail(boolean seller_email){
        return CheckEmailDto.builder()
                .seller_email(seller_email)
                .build();
    }
}
