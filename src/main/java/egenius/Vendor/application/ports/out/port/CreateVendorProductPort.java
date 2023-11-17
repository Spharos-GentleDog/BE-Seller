package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.domain.VendorProduct;

public interface CreateVendorProductPort {

    void createVendorProduct(VendorProduct vendorProduct);
}
