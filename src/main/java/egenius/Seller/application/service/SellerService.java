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
                signUpQuery.getSeller_email(),
                signUpQuery.getBusiness_number(),
                signUpQuery.getSeller_pw(),
                signUpQuery.getMail_order_number(),
                signUpQuery.getBrand_name(),
                signUpQuery.getBrand_logo_img(),
                signUpQuery.getBrand_content(),
                signUpQuery.getHomepage_url(),
                signUpQuery.getBusiness_type(),
                signUpQuery.getCompany_name(),
                signUpQuery.getCompany_add(),
                signUpQuery.getOpened_at(),
                signUpQuery.getSeller_name(),
                signUpQuery.getCall_center_number(),
                signUpQuery.getPhone_number(),
                0
        ));

        return SellerDto.formSellers(seller);
    }

    @Override
    public CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery) {

        String seller_email = sellerPort.checkEmail(checkEmailQuery.getSeller_email());

        return CheckEmailDto.formCheckEmail(seller_email);
    }
}
