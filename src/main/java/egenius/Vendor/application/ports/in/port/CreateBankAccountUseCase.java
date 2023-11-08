package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.CreateBankAccountQuery;

public interface CreateBankAccountUseCase {

    void createBankAccount(CreateBankAccountQuery createBankAccountQuery);

}
