package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.VendorInfoQuery;
import egenius.Vendor.application.ports.out.dto.VendorInfoDto;

public interface VendorInfoUseCase {

    VendorInfoDto getVendorInfo(VendorInfoQuery vendorInfoQuery);
}
