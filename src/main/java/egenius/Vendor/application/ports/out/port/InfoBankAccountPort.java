package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.InfoBankAccountDto;

public interface InfoBankAccountPort {

        InfoBankAccountDto getBankAccount(String vendorEmail);
}
