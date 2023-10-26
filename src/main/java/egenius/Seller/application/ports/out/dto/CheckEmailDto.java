package egenius.Seller.application.ports.out.dto;

import egenius.Seller.domain.Seller;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CheckEmailDto {

    private boolean sellerEmail;

    public static CheckEmailDto formCheckEmail(boolean sellerEmail){
        return CheckEmailDto.builder()
                .sellerEmail(sellerEmail)
                .build();
    }
}
