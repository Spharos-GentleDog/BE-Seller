package egenius.Vendor.application.ports.in.query;

import egenius.Vendor.adaptor.web.request.RequestCheckEmail;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckEmailQuery{

    private String vendorEmail;

    public static CheckEmailQuery toQuery(RequestCheckEmail requestEmailCheck){
        return CheckEmailQuery.builder()
                .vendorEmail(requestEmailCheck.getVendorEmail())
                .build();
    }
}
