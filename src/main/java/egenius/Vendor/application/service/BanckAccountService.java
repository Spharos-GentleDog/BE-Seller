package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CreateBankAccountUseCase;
import egenius.Vendor.application.ports.in.query.CreateBankAccountQuery;
import egenius.Vendor.application.ports.out.port.CreateBankAccountPort;
import egenius.Vendor.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BanckAccountService implements CreateBankAccountUseCase {

    private final CreateBankAccountPort createBankAccountPort;

    //계좌 등록
    @Override
    public void createBankAccount(CreateBankAccountQuery createBankAccountQuery) {
        // vendor index를 찾는다.
        // vendor index를 이용하여 계좌를 등록한다.
        BankAccount bankAccount = BankAccount.createBankAccount(
                createBankAccountQuery.getBankName(),
                createBankAccountQuery.getBankAccountNumber(),
                createBankAccountQuery.getBankAccountHolder(),
                createBankAccountQuery.getVendorEmail()
        );
        createBankAccountPort.createBankAccount(bankAccount);



    }

    //계좌 삭제

    //계좌 수정
}
