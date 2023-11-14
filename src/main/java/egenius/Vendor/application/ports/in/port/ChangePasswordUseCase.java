package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.ChangePasswordQuery;

public interface ChangePasswordUseCase {

    void changePassword(ChangePasswordQuery changePasswordQuery);
}
