package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.InfoBankAccountQuery;
import egenius.Vendor.application.ports.out.dto.InfoBankAccountDto;

public interface InfoBankAccountUseCase {

    InfoBankAccountDto getBankAccount(InfoBankAccountQuery infoBankAccountQuery);

}
