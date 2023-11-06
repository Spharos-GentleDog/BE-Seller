package egenius.Vendor.application.ports.in.query;

import egenius.Vendor.adaptor.web.request.RequestSignInVendor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInQuery {
    private String vendorEmail;
    private String vendorPassword;

    public static SignInQuery toQuery(RequestSignInVendor requestSignInVendor){
        return SignInQuery.builder()
                .vendorEmail(requestSignInVendor.getVendorEmail())
                .vendorPassword(requestSignInVendor.getVendorPassword())
                .build();
    }
}
