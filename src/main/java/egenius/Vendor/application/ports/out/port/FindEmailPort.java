package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.FindEmailDto;
import egenius.Vendor.domain.Vendor;

public interface FindEmailPort {

    FindEmailDto findEmail(Vendor vendor);
}
