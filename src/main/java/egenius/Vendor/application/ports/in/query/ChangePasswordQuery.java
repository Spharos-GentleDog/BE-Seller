package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ChangePasswordQuery {

    private String email;
    private String newPassword;

    public static ChangePasswordQuery toQuery(String email, String newPassword){
        return ChangePasswordQuery.builder()
                .email(email)
                .newPassword(newPassword)
                .build();
    }
}
