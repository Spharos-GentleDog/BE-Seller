package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.EmailVerifyQuery;

public interface EmailVerifyUseCase {

    void emailVerify(EmailVerifyQuery emailVerifyQuery);
}
