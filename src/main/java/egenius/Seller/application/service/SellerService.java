package egenius.Seller.application.service;

import egenius.Seller.application.ports.in.CheckEmailUseCase;
import egenius.Seller.application.ports.in.SignUpUseCase;
import egenius.Seller.application.ports.out.dto.CheckEmailDto;
import egenius.Seller.application.ports.out.dto.SellerDto;
import egenius.Seller.application.ports.out.port.SellerPort;
import egenius.Seller.domain.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class SellerService implements SignUpUseCase, CheckEmailUseCase {

    private final SellerPort sellerPort;

    // Usecase 구현 : Dto로 데이터 전달, 서비스 로직 수행

    //회원가입 판매자 생성
    @Override
    public SellerDto signUpSeller(SignUpQuery signUpQuery) {
        // todo : Model Mapper 호라용하여 리팩토링
        Seller seller = sellerPort.signUpSeller(Seller.signUpSeller(
                signUpQuery.getSellerEmail(),
                signUpQuery.getBusinessNumber(),
                signUpQuery.getSellerPw(),
                signUpQuery.getMailOrderNumber(),
                signUpQuery.getBrandName(),
                signUpQuery.getBrandLogoImg(),
                signUpQuery.getBrandContent(),
                signUpQuery.getHomepageUrl(),
                signUpQuery.getBusinessType(),
                signUpQuery.getCompanyName(),
                signUpQuery.getCompanyAddress(),
                signUpQuery.getOpenedAt(),
                signUpQuery.getSellerName(),
                signUpQuery.getCallCenterNumber(),
                signUpQuery.getPhoneNumber(),
                0
        ));

        return SellerDto.formSellers(seller);
    }

    @Override
    public CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery) {

        boolean sellerEmail = sellerPort.checkEmail(checkEmailQuery.getSellerEmail());

        return CheckEmailDto.formCheckEmail(sellerEmail);
    }
}
