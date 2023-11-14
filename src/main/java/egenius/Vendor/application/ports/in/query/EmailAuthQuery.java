package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmailAuthQuery {

    private String email;

    public static EmailAuthQuery toQuery(String email){
        return EmailAuthQuery.builder()
                .email(email)
                .build();
    }

}
