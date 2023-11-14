package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailVerifyQuery {

    private String email;
    private String code;

    public static EmailVerifyQuery toQuery(String email, String code){
        return EmailVerifyQuery.builder()
                .email(email)
                .code(code)
                .build();
    }
}
