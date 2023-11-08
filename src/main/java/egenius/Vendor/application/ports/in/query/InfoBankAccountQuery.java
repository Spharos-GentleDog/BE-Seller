package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class InfoBankAccountQuery {

    private String vendorEmail;

    public static InfoBankAccountQuery toQuery(String vendorEmail){
        return InfoBankAccountQuery.builder()
                .vendorEmail(vendorEmail)
                .build();
    }
}
