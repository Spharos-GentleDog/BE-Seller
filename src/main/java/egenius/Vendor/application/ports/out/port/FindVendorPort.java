package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.FindVendorDto;
import egenius.Vendor.domain.Vendor;

public interface FindVendorPort {

    Vendor findVendor(String vendorEmail);
}
