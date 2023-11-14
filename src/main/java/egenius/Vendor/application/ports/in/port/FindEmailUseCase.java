package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.FindEmailQuery;
import egenius.Vendor.application.ports.out.dto.FindEmailDto;

public interface FindEmailUseCase {

    FindEmailDto findEmail(FindEmailQuery findEmailQuery);
}
