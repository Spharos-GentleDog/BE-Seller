package egenius.Seller.adaptor.web.controller;


import egenius.Seller.adaptor.web.request.RequestCheckEmail;
import egenius.Seller.adaptor.web.request.RequestSignUpSeller;
import egenius.Seller.application.ports.in.CheckEmailUseCase;
import egenius.Seller.application.ports.in.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller")
@RequiredArgsConstructor
@Slf4j
public class SellerController {

    private final SignUpUseCase signUpUseCase;
    private final CheckEmailUseCase checkEmailUseCase;

    // web에서 request로 데이터 받음
    // 받은 데이터를 usecase로 전달

    //회원가입
    @PostMapping("/register")
    public String signUp(@RequestBody RequestSignUpSeller requestSignUpSeller){
        log.info("회원가입 정보:{}", requestSignUpSeller);
        signUpUseCase.signUpSeller(SignUpUseCase.SignUpQuery.toQuery(requestSignUpSeller));
        return "회원가입";
    }

    //이메일 중복 체크
    @PostMapping("/CheckEmail")
    public String CheckEmail(@RequestBody RequestCheckEmail requestCheckEmail){
        log.info("이메일 중복체크: {}",requestCheckEmail);
        checkEmailUseCase.checkEmail(CheckEmailUseCase.CheckEmailQuery.toQuery(requestCheckEmail));
        return "이메일 중복 체크";
    }


    //todo: 비밀번호 재설정

    //todo: 아이디 찾기

    //

}
