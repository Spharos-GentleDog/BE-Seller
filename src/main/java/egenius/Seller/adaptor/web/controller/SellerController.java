package egenius.Seller.adaptor.web.controller;


import egenius.Seller.adaptor.web.request.RequestCheckEmail;
import egenius.Seller.adaptor.web.request.RequestSignUpSeller;
import egenius.Seller.application.ports.in.CheckEmailUseCase;
import egenius.Seller.application.ports.in.SignUpUseCase;
import egenius.Seller.application.ports.out.dto.CheckEmailDto;
import egenius.Seller.global.common.response.BaseResponse;
import jakarta.validation.Valid;
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
    @PostMapping("/signup")
    public BaseResponse<?> signUp(@RequestBody RequestSignUpSeller requestSignUpSeller){
        log.info("회원가입 정보:{}", requestSignUpSeller);
        signUpUseCase.signUpSeller(SignUpUseCase.SignUpQuery.toQuery(requestSignUpSeller));
        return new BaseResponse<>();
    }

    //이메일 중복 체크
    @PostMapping("/check-email")
    public BaseResponse<?> CheckEmail(@RequestBody @Valid RequestCheckEmail requestCheckEmail){
        log.info("이메일 중복체크: {}",requestCheckEmail);
        // Dto에 저장 된 결과 값을 반환
        return new BaseResponse<CheckEmailDto>(checkEmailUseCase.checkEmail(CheckEmailUseCase.CheckEmailQuery.toQuery(requestCheckEmail)));
    }

    /*
        API 정의서 나오는 대로 작업 할 것
        //todo: 아이디 찾기

        //todo: 비밀번호 재설정

        // todo : 이메일 인증

        // todo : 로그인
    */

    //todo: 계좌 생성

    //todo: 판매자 상태 변경

    //todo : 판매자 상품 목록 생성


}
