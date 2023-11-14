package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.WithdrawalQuery;

public interface WithdrawalUseCase {

    void withdrawal(WithdrawalQuery withdrawalQuery);

}
