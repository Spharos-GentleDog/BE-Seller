package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInQuery {
    private String VendorEmail;
    private String vendorPassword;
}
