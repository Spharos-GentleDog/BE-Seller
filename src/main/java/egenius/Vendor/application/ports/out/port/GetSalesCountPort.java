package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.GetSalesCountDto;
import egenius.Vendor.domain.VendorProduct;

public interface GetSalesCountPort {

    GetSalesCountDto getSalesCount(VendorProduct vendorProduct);
}
