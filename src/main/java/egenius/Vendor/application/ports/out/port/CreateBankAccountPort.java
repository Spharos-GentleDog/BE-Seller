package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.domain.BankAccount;

public interface CreateBankAccountPort {

    void createBankAccount(BankAccount bankAccount);
}
