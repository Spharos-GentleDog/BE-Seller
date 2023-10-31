package egenius.Seller.application.service;

import egenius.Seller.application.ports.in.port.CheckEmailUseCase;
import egenius.Seller.application.ports.in.port.SignUpUseCase;
import egenius.Seller.application.ports.in.query.CheckEmailQuery;
import egenius.Seller.application.ports.in.query.SignUpQuery;
import egenius.Seller.application.ports.out.dto.CheckEmailDto;
import egenius.Seller.application.ports.out.dto.SellerDto;
import egenius.Seller.application.ports.out.port.CheckEmailPort;
import egenius.Seller.application.ports.out.port.SellerPort;
import egenius.Seller.domain.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SellerService implements SignUpUseCase, CheckEmailUseCase {

    private final SellerPort sellerPort;
    private final CheckEmailPort checkEmailPort;

    // 빈약한 도메인 모델의 비지니스 로직 구현 => 유스케이스 단에서 비지니스 로직 처리
    // Usecase 구현 : Dto로 데이터 전달, 서비스 로직 수행


    //회원가입 판매자 생성
    @Override
    public SellerDto signUpSeller(SignUpQuery signUpQuery) {
        // todo : Model Mapper 활용하여 리팩토링
        // seller status , businessType
        // -> domain: Enum
        // -> request : String (코드 값 : 0, 1)
        // -> DB : Integer 코드 값
        // web 단 : 코드로 들어온 값을 enum으로 변경 해줘야 한다
        // adaptor 단 : enum을 코드 값으로 변경 해줘야 한다
        SellerDto sellerDto = sellerPort.signUpSeller(Seller.signUpSeller(
                signUpQuery.getSellerEmail(),
                signUpQuery.getBusinessNumber(),
                signUpQuery.getSellerPassword(),
                signUpQuery.getMailOrderNumber(),
                signUpQuery.getBrandName(),
                signUpQuery.getBrandLogoImageUrl(),
                signUpQuery.getBrandContent(),
                signUpQuery.getHomepageUrl(),
                signUpQuery.getBusinessType(),
                signUpQuery.getCompanyName(),
                signUpQuery.getCompanyAddress(),
                signUpQuery.getOpenedAt(),
                signUpQuery.getSellerName(),
                signUpQuery.getCallCenterNumber(),
                signUpQuery.getPhoneNumber(),
                signUpQuery.getSellerStatus()
        ));

        return sellerDto;
    }

    // 이메일 중복 확인
    @Override
    public CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery) {

        CheckEmailDto checkEmailDto = checkEmailPort.checkEmail(checkEmailQuery.getSellerEmail());

        return checkEmailDto;
    }
}
