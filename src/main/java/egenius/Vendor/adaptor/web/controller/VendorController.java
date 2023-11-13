package egenius.Vendor.adaptor.web.controller;


import egenius.Vendor.adaptor.web.request.*;
import egenius.Vendor.application.ports.in.port.*;
import egenius.Vendor.application.ports.in.query.*;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;
import egenius.Vendor.global.common.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendor")
@RequiredArgsConstructor
@Slf4j
public class VendorController {

    private final SignUpUseCase signUpUseCase;
    private final CheckEmailUseCase checkEmailUseCase;
    private final SignInUseCase signInUseCase;
    private final EmailAuthUseCase emailAuthUseCase;
    private final EmailVerifyUseCase emailVerifyUseCase;
    private final FindEmailUseCase findEmailUseCase;
    private final WithdrawalUseCase withdrawalUseCase;


    // web에서 request로 데이터 받음
    // 받은 데이터를 usecase로 전달

    //회원가입
    @PostMapping("/signup")
    public BaseResponse<?> signUp(@RequestBody @Valid RequestSignUpVendor requestSignUpVendor){
        log.info("회원가입 정보:{}", requestSignUpVendor);
        System.out.print(requestSignUpVendor.getVendorEmail());
        signUpUseCase.signUpVendor(SignUpQuery.toQuery(requestSignUpVendor));
        return new BaseResponse<>();
    }

    //이메일 중복 체크
    @PostMapping("/check-email")
    public BaseResponse<?> CheckEmail(@RequestBody @Valid RequestCheckEmail requestCheckEmail){
        log.info("이메일 중복체크: {}",requestCheckEmail);
        // Dto에 저장 된 결과 값을 반환
        checkEmailUseCase.checkEmail(CheckEmailQuery.toQuery(requestCheckEmail));
        return new BaseResponse<>();
    }

    //로그인
    @PostMapping("/signin")
    public BaseResponse<?> SignIn(@RequestBody @Valid RequestSignInVendor requestSignInVendor){
        log.info("로그인 정보: {} {}", requestSignInVendor.getPassword(),requestSignInVendor.getVendorEmail());
        return new BaseResponse<>(signInUseCase.signIn(SignInQuery.toQuery(requestSignInVendor)));
    }

    // 이메일 인증메일 발송
    @PostMapping("/email-auth")
    public BaseResponse<?> EmailAuth(@RequestBody @Valid RequestAuthEmail requestAuthEmail){
        log.info("이메일 인증 메일 발송: {}", requestAuthEmail);
        emailAuthUseCase.emailAuth(EmailAuthQuery.toQuery(requestAuthEmail.getEmail()));
        return new BaseResponse<>();
    }

    // 이메일 인증 코드 확인
    @PostMapping("/email-verify")
    public BaseResponse<?> EmailVerify(@RequestBody @Valid RequestVerifyEmail requestVerifyEmail){
        log.info("이메일 인증 코드 확인: {}", requestVerifyEmail);
        emailVerifyUseCase.emailVerify(EmailVerifyQuery.toQuery(
                requestVerifyEmail.getEmail(),
                requestVerifyEmail.getCode()));
        return new BaseResponse<>();
    }

    // 아이디 찾기
    @PostMapping("/find-email")
    public BaseResponse<?> FindEmail(@RequestBody @Valid RequestFindEmail requestFindEmail){
        log.info("아이디 찾기: {}", requestFindEmail);
        return new BaseResponse<>(findEmailUseCase.findEmail(FindEmailQuery.toQuery(
                requestFindEmail.getManagerName(),
                requestFindEmail.getManagerPhoneNumber())));
    }

    //회원 탈퇴
    @PostMapping("/withdrawal")
    public BaseResponse<?> Withdrawal(@RequestBody @Valid RequestWithdrawalVendor requestWithdrawalVendor){
        log.info("회원 탈퇴: {}", requestWithdrawalVendor.getEmail());

        withdrawalUseCase.withdrawal(WithdrawalQuery.toQuery(requestWithdrawalVendor.getEmail()));

        return new BaseResponse<>();
    }
    /*
        API 정의서 나오는 대로 작업 할 것
        //todo: 아이디 찾기

        //todo: 비밀번호 재설정

        // todo : 이메일 인증

        // todo : 로그인
    */



}
