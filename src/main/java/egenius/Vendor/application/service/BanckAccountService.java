package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CreateBankAccountUseCase;
import egenius.Vendor.application.ports.in.port.InfoBankAccountUseCase;
import egenius.Vendor.application.ports.in.query.CreateBankAccountQuery;
import egenius.Vendor.application.ports.in.query.InfoBankAccountQuery;
import egenius.Vendor.application.ports.out.dto.InfoBankAccountDto;
import egenius.Vendor.application.ports.out.port.CreateBankAccountPort;
import egenius.Vendor.application.ports.out.port.InfoBankAccountPort;
import egenius.Vendor.domain.BankAccount;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BanckAccountService implements CreateBankAccountUseCase, InfoBankAccountUseCase {

    private final CreateBankAccountPort createBankAccountPort;
    private final InfoBankAccountPort infoBankAccountPort;

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

    //계좌 조회
    @Override
    public InfoBankAccountDto getBankAccount(InfoBankAccountQuery infoBankAccountQuery) {

        InfoBankAccountDto infoBankAccountDto = infoBankAccountPort.getBankAccount(infoBankAccountQuery.getVendorEmail());


        return InfoBankAccountDto.fromBankAccount(
                infoBankAccountDto.getBankName(),
                infoBankAccountDto.getBankAccountNumber(),
                infoBankAccountDto.getBankAccountHolder()
        );

    }

    //계좌 삭제

    //계좌 수정
}
