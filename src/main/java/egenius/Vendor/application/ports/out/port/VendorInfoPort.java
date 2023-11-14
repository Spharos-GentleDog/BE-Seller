package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.VendorInfoDto;
import egenius.Vendor.domain.Vendor;

public interface VendorInfoPort {

    VendorInfoDto getVendorInfo(Vendor vendor);
}
