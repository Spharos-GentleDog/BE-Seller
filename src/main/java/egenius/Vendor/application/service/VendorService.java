package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CheckEmailUseCase;
import egenius.Vendor.application.ports.in.port.SignUpUseCase;
import egenius.Vendor.application.ports.in.query.CheckEmailQuery;
import egenius.Vendor.application.ports.in.query.SignUpQuery;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;
import egenius.Vendor.application.ports.out.dto.VendorDto;
import egenius.Vendor.application.ports.out.port.CheckEmailPort;
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
public class VendorService implements SignUpUseCase, CheckEmailUseCase {

    private final VendorPort vendorPort;
    private final CheckEmailPort checkEmailPort;

    // 빈약한 도메인 모델의 비지니스 로직 구현 => 유스케이스 단에서 비지니스 로직 처리
    // Usecase 구현 : Dto로 데이터 전달, 서비스 로직 수행


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
}
