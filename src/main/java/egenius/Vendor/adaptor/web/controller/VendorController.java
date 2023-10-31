package egenius.Vendor.adaptor.web.controller;


import egenius.Vendor.adaptor.web.request.RequestCheckEmail;
import egenius.Vendor.adaptor.web.request.RequestSignUpVendor;
import egenius.Vendor.application.ports.in.port.CheckEmailUseCase;
import egenius.Vendor.application.ports.in.port.SignUpUseCase;
import egenius.Vendor.application.ports.in.query.CheckEmailQuery;
import egenius.Vendor.application.ports.in.query.SignUpQuery;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;
import egenius.Vendor.global.common.response.BaseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Vendor")
@RequiredArgsConstructor
@Slf4j
public class VendorController {

    private final SignUpUseCase signUpUseCase;
    private final CheckEmailUseCase checkEmailUseCase;

    // web에서 request로 데이터 받음
    // 받은 데이터를 usecase로 전달

    //회원가입
    @PostMapping("/signup")
    public BaseResponse<?> signUp(@RequestBody RequestSignUpVendor requestSignUpVendor){
        log.info("회원가입 정보:{}", requestSignUpVendor);
        signUpUseCase.signUpVendor(SignUpQuery.toQuery(requestSignUpVendor));
        return new BaseResponse<>();
    }

    //이메일 중복 체크
    @PostMapping("/check-email")
    public BaseResponse<?> CheckEmail(@RequestBody @Valid RequestCheckEmail requestCheckEmail){
        log.info("이메일 중복체크: {}",requestCheckEmail);
        // Dto에 저장 된 결과 값을 반환
        return new BaseResponse<CheckEmailDto>(checkEmailUseCase.checkEmail(CheckEmailQuery.toQuery(requestCheckEmail)));
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
