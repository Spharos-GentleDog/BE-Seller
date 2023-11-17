package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;

public interface CreateVendorProductUseCase {

    void createVendorProduct(CreateVendorProductQuery createVendorProductQuery);

}
