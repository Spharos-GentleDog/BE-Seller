package egenius.Vendor.application.ports.out.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindEmailDto {

    private String email;

    public static FindEmailDto formFindEmail(String email){
        return FindEmailDto.builder()
                .email(email)
                .build();
    }
}
