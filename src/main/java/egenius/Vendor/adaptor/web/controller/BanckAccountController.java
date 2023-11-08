package egenius.Vendor.adaptor.web.controller;

import egenius.Vendor.adaptor.web.request.RequestCreateBankAccount;
import egenius.Vendor.application.ports.in.port.CreateBankAccountUseCase;
import egenius.Vendor.application.ports.in.port.InfoBankAccountUseCase;
import egenius.Vendor.application.ports.in.query.CreateBankAccountQuery;
import egenius.Vendor.application.ports.in.query.InfoBankAccountQuery;
import egenius.Vendor.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/banck-account")
@RequiredArgsConstructor
@Slf4j
public class BanckAccountController {

    private final CreateBankAccountUseCase createBankAccountUseCase;
    private final InfoBankAccountUseCase infoBankAccountUseCase;

    //계좌 등록
    @PostMapping("/createBankAccount")
    public BaseResponse<?> createBankAccount(@RequestBody RequestCreateBankAccount requestCreateBankAccount,
                                             @RequestHeader("Vendor-Email") String vendorEmail){

        createBankAccountUseCase.createBankAccount(CreateBankAccountQuery.toQuery(
                requestCreateBankAccount.getBankName(),
                requestCreateBankAccount.getBankAccountNumber(),
                requestCreateBankAccount.getBankAccountHolder(),
                vendorEmail
        ));

        return new BaseResponse<>();
    }

    //계좌 조회
    @GetMapping("/infoBankAccount")
    public BaseResponse<?> infoBankAccount(@RequestHeader("Vendor-Email") String vendorEmail){

        return new BaseResponse<>(infoBankAccountUseCase.getBankAccount(InfoBankAccountQuery.toQuery(vendorEmail)));
    }

    //계좌 삭제

    //계좌 수정

}
