package egenius.Seller.adaptor.web.controller;


import egenius.Seller.adaptor.web.request.RequestSignUpSeller;
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

    // web에서 request로 데이터 받음
    // 받은 데이터를 usecase로 전달

    //회원가입
    @PostMapping("/register")
    public String signUp(@RequestBody RequestSignUpSeller requestSignUpSeller){
        log.info("회원가입 정보:{}", requestSignUpSeller);
        signUpUseCase.signUpSeller(SignUpUseCase.SignUpQuery.toQuery(requestSignUpSeller));
        return "회원가입";
    }

}
