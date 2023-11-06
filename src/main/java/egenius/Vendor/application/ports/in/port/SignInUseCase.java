package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.SignInQuery;
import egenius.Vendor.application.ports.out.dto.SignInDto;

public interface SignInUseCase {
    SignInDto signIn(SignInQuery signInQuery);
}
