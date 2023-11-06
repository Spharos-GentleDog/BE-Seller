package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.domain.VendorBanckAccount;

public interface VendorAccountPort {

    VendorBanckAccount createVendorAccount(VendorBanckAccount VendorAccount);
}
