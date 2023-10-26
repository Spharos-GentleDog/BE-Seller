package egenius.Seller.adaptor.infrstructre.mysql.persistance;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerEntity;
import egenius.Seller.adaptor.infrstructre.mysql.repository.SellerRepository;
import egenius.Seller.application.ports.out.port.SellerPort;
import egenius.Seller.domain.Seller;
import jakarta.transaction.Transactional;
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

        SellerEntity sellerEntity = sellerRepository.save(SellerEntity.SignUpSeller(
                seller.getSeller_email(),
                seller.getBusiness_number(),
                seller.getSeller_pw(),
                seller.getMail_order_number(),
                seller.getBrand_name(),
                seller.getBrand_logo_img(),
                seller.getBrand_content(),
                seller.getHomepage_url(),
                seller.getBusiness_type(),
                seller.getCompany_name(),
                seller.getCompany_add(),
                seller.getOpened_at(),
                seller.getSeller_name(),
                seller.getCall_center_number(),
                seller.getPhone_number(),
                seller.getSeller_status()
                ));
        return Seller.formSellerEntity(sellerEntity);
    }

    @Transactional
    @Override
    public boolean checkEmail(String seller_email) {

        Optional<SellerEntity> seller_email_entity = sellerRepository.findBysellerEmail(seller_email);

        if(seller_email_entity.isPresent()){
            log.info("회원 존재");
            return true;
        }
        log.info("회원 존재하지 않음");
        return false;
    }

}
