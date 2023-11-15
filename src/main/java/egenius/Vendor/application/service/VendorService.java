package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.*;
import egenius.Vendor.application.ports.in.query.*;
import egenius.Vendor.application.ports.out.dto.*;
import egenius.Vendor.application.ports.out.port.*;
import egenius.Vendor.domain.Vendor;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import egenius.Vendor.global.config.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorService implements SignUpUseCase, CheckEmailUseCase, SignInUseCase, FindEmailUseCase,
        WithdrawalUseCase, ChangePasswordUseCase,VendorInfoUseCase,ChangeInfoUseCase {

    // 비지니스 로직이 위치하는 곳
    // 비지니스 로직 : 도메인 모델의 상태를 변경하는 것

    private final VendorPort vendorPort;
    private final CheckEmailPort checkEmailPort;
    private final FindVendorPort findVendorPort;
    private final FindEmailPort findEmailPort;
    private final WithdrawalVendorPort withdrawalVendorPort;
    private final ChangePasswordPort changePasswordPort;
    private final VendorInfoPort VendorInfoPort;
    private final ChangeInfoPort changeInfoPort;

    //JWT 발급
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

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

        // 중복 확인 후 회원가입
        CheckEmailDto checkEmailDto = checkEmailPort.checkEmail(signUpQuery.getVendorEmail());
        if(checkEmailDto.isVendorEmail()){
            throw new BaseException(BaseResponseStatus.EMAIL_IS_USED);
        }

        // 비밀번호 암호화
        String password = new BCryptPasswordEncoder().encode(signUpQuery.getPassword());

        VendorDto vendorDto = vendorPort.signUpVendor(Vendor.signUpVendor(
                signUpQuery.getVendorEmail(),
                signUpQuery.getBusinessNumber(),
                password,
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
                signUpQuery.getManagerName(),
                signUpQuery.getManagerPhoneNumber(),
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
            throw new BaseException(BaseResponseStatus.EMAIL_IS_USED);
        }
        return checkEmailDto;
    }

    //판매자 로그인
    @Override
    public SignInDto signIn(SignInQuery signInQuery) {

        // email로 판매자 조회
        Vendor vendor = findVendorPort.findVendor(signInQuery.getVendorEmail());
        log.info("판매자 정보 {}",vendor.getDeactivate());
        // 탈퇴한 판매자면 로그인 불가
        if(vendor.getDeactivate() != null){
            throw new BaseException(BaseResponseStatus.WITHDRAWAL_VENDOR);
        }

        log.info("{} {}", signInQuery.getVendorEmail(), signInQuery.getPassword());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        log.info("vender {} ", vendor);
        // 비밀번호 확인
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInQuery.getVendorEmail(),
                        signInQuery.getPassword()
                )
        );
        // JWT 토큰 발급
        String jwt = jwtTokenProvider.generateToken(vendor);
        //refresh token 발급
        String refreshToken = jwtTokenProvider.generateRefreshToken(vendor);

        System.out.print("jwt : " + jwt);
        System.out.print("jwt : " + jwt);

        log.info("권한정보{}", vendor.getAuthorities());

        return SignInDto.formSignIn(jwt,
                refreshToken,
                vendor.getVendorEmail(),
                vendor.getBrandName(),
                vendor.getBrandLogoImageUrl(),
                vendor.getAuthorities()
                );
    }

    // 이메일 찾기
    @Override
    public FindEmailDto findEmail(FindEmailQuery findEmailQuery) {

        FindEmailDto findEmailDto = findEmailPort.findEmail(Vendor.findVendorEmail(
                                        findEmailQuery.getManagerName(),
                                        findEmailQuery.getManagerPhoneNumber()
                                ));
        return findEmailDto;
    }

    // 회원 탈퇴
    @Override
    public void withdrawal(WithdrawalQuery withdrawalQuery) {

        withdrawalVendorPort.withdrawalVendor(Vendor.deactivateVendor(
                withdrawalQuery.getEmail(),
                LocalDateTime.now()
        ));

    }

    //비밀번호 변경
    @Override
    public void changePassword(ChangePasswordQuery changePasswordQuery) {

        changePasswordPort.changePassword(Vendor.changePassword(
                changePasswordQuery.getEmail(),
                changePasswordQuery.getNewPassword()
        ));

    }

    @Override
    public VendorInfoDto getVendorInfo(VendorInfoQuery vendorInfoQuery) {

        // email로 판매자 조회
        Vendor vendor = findVendorPort.findVendor(vendorInfoQuery.getEmail());
        log.info("판매자 정보 {}",vendor.getDeactivate());
        // 탈퇴한 판매자면 조회 불가
        if(vendor.getDeactivate() != null){
            throw new BaseException(BaseResponseStatus.WITHDRAWAL_VENDOR);
        }

        VendorInfoDto vendorInfoDto = VendorInfoPort.getVendorInfo(Vendor.getVendorInfo(
                vendorInfoQuery.getEmail()
        ));

        return vendorInfoDto;
    }

    @Override
    public void changeInfo(ChangeInfoQuery changeInfoQuery) {

        changeInfoPort.changeInfo(Vendor.changeInfo(
                changeInfoQuery.getEmail(),
                changeInfoQuery.getBrandLogoImageUrl(),
                changeInfoQuery.getBrandContent(),
                changeInfoQuery.getHomepageUrl(),
                changeInfoQuery.getCompanyAddress(),
                changeInfoQuery.getCallCenterNumber(),
                changeInfoQuery.getManagerName(),
                changeInfoQuery.getManagerPhoneNumber()
        ));

    }
}
