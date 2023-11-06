package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.SignInDto;
import egenius.Vendor.domain.Vendor;

import java.util.Optional;

public interface SignInPort {

    SignInDto signIn(Vendor vendor);

}
