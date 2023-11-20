package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.GetVendorProductDto;

import java.util.List;

public interface GetVendorProductPort {

    List<GetVendorProductDto> getVendorProduct(String vendorEmail);
}
