package egenius.Seller.adaptor.infrastructure.mysql.persistance;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerEntity;
import egenius.Seller.adaptor.infrastructure.mysql.repository.SellerRepository;
import egenius.Seller.application.ports.out.port.SellerPort;
import egenius.Seller.domain.Seller;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class SellerAdaptor implements SellerPort {

    private final SellerRepository sellerRepository;

    // 회원가입
    @Transactional
    @Override
    public Seller signUpSeller(Seller seller) {

        SellerEntity sellerEntity = sellerRepository.save(SellerEntity.signUpSeller(
                seller.getSellerEmail(),
                seller.getBusinessNumber(),
                seller.getSellerPw(),
                seller.getMailOrderNumber(),
                seller.getBrandName(),
                seller.getBrandLogoImg(),
                seller.getBrandContent(),
                seller.getHomepageUrl(),
                seller.getBusinessType(),
                seller.getCompanyName(),
                seller.getCompanyAddress(),
                seller.getOpenedAt(),
                seller.getSellerName(),
                seller.getCallCenterNumber(),
                seller.getPhoneNumber(),
                seller.getSellerStatus()
                ));
        return Seller.formSellerEntity(sellerEntity);
    }

    @Transactional(readOnly = true)
    @Override
    public boolean checkEmail(String sellerEmail) {

        Optional<SellerEntity> sellerEmailEntity = sellerRepository.findBySellerEmail(sellerEmail);

        if(sellerEmailEntity.isPresent()){
            log.info("회원 존재");
            return true;
        }
        log.info("회원 존재하지 않음");
        return false;
    }

}
