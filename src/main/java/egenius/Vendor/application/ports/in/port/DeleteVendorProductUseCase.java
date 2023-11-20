package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.DeleteVendorProductQuery;

public interface DeleteVendorProductUseCase {

    void deleteVendorProduct(DeleteVendorProductQuery deleteVendorProductQuery);
}
