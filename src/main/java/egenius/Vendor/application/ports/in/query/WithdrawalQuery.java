package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class WithdrawalQuery {

    private String email;

    public static WithdrawalQuery toQuery(String email){
        return WithdrawalQuery.builder()
                .email(email)
                .build();
    }
}
