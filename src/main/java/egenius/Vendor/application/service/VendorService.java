package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CheckEmailUseCase;
import egenius.Vendor.application.ports.in.port.SignInUseCase;
import egenius.Vendor.application.ports.in.port.SignUpUseCase;
import egenius.Vendor.application.ports.in.query.CheckEmailQuery;
import egenius.Vendor.application.ports.in.query.SignInQuery;
import egenius.Vendor.application.ports.in.query.SignUpQuery;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;
import egenius.Vendor.application.ports.out.dto.SignInDto;
import egenius.Vendor.application.ports.out.dto.VendorDto;
import egenius.Vendor.application.ports.out.port.CheckEmailPort;
import egenius.Vendor.application.ports.out.port.SignInPort;
import egenius.Vendor.application.ports.out.port.VendorPort;
import egenius.Vendor.domain.Vendor;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class VendorService implements SignUpUseCase, CheckEmailUseCase, SignInUseCase {

    // 비지니스 로직이 위치하는 곳
    // 비지니스 로직 : 도메인 모델의 상태를 변경하는 것

    private final VendorPort vendorPort;
    private final CheckEmailPort checkEmailPort;

    // 빈약한 도메인 모델의 비지니스 로직 구현 => 유스케이스 단에서 비지니스 로직 처리
    // Usecase 구현 : 서비스 로직 수행 후 Dto로 데이터 반환

    //회원가입 판매자 생성
    @Override
    public VendorDto signUpVendor(SignUpQuery signUpQuery) {
        // todo : Model Mapper 활용하여 리팩토링
        // Vendor status , businessType
        // -> domain: Enum
        // -> request : String (코드 값 : 0, 1)
        // -> DB : Integer 코드 값
        // web 단 : 코드로 들어온 값을 enum으로 변경 해줘야 한다
        // adaptor 단 : enum을 코드 값으로 변경 해줘야 한다
        VendorDto vendorDto = vendorPort.signUpVendor(Vendor.signUpVendor(
                signUpQuery.getVendorEmail(),
                signUpQuery.getBusinessNumber(),
                signUpQuery.getVendorPassword(),
                signUpQuery.getMailOrderNumber(),
                signUpQuery.getBrandName(),
                signUpQuery.getBrandLogoImageUrl(),
                signUpQuery.getBrandContent(),
                signUpQuery.getHomepageUrl(),
                signUpQuery.getBusinessType(),
                signUpQuery.getCompanyName(),
                signUpQuery.getCompanyAddress(),
                signUpQuery.getOpenedAt(),
                signUpQuery.getVendorName(),
                signUpQuery.getCallCenterNumber(),
                signUpQuery.getVendorPhoneNumber(),
                signUpQuery.getVendorStatus()
        ));

        return vendorDto;
    }

    // 이메일 중복 확인
    @Override
    public CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery) {

        CheckEmailDto checkEmailDto = checkEmailPort.checkEmail(checkEmailQuery.getVendorEmail());
        log.info("이메일 인증 정보 {}",checkEmailDto.isVendorEmail());
        //이미 사용 중인 이메일인 경우 error 반환
        if(checkEmailDto.isVendorEmail()){
            throw new BaseException(BaseResponseStatus.EMAIL_NOT_FOUND);
        }
        return checkEmailDto;
    }

    //판매자 로그인
    @Override
    public SignInDto signIn(SignInQuery signInQuery) {

        // 판매자 회원 정보 조회 (이메일, 패스워드)
        SignInDto signInDto = SignInPort.signIn(Vendor.signInVendor(
                signInQuery.getVendorEmail(),
                signInQuery.getVendorPassword()
        ));
        //회원 정보가 있을 경우 로그인 성공
        if (signInDto.isVendor()){
            // token 발급
            // todo : token 발급 로직 구현

            return signInDto;
        }else {
            //회원 정보가 없을 경우 로그인 실패
            throw new BaseException(BaseResponseStatus.SIGNIN_FAIL);
        }


    }
}
