package egenius.Seller.adaptor.infrstructre.mysql.repository;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerEntity;
import egenius.Seller.application.ports.out.port.SellerPort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    // 회원가입
    SellerEntity save(SellerEntity sellerEntity);

    //이메일 중복 체크
    Optional<SellerEntity> findBysellerEmail(String seller_email);

}
