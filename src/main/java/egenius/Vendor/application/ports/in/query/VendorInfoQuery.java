package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VendorInfoQuery {

    private String email;

    public static VendorInfoQuery toQuery(String email){
        return VendorInfoQuery.builder()
                .email(email)
                .build();
    }
}
