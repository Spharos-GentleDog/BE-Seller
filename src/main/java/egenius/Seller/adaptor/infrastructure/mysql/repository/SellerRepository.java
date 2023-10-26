package egenius.Seller.adaptor.infrastructure.mysql.repository;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {
    //이메일 중복 체크
    Optional<SellerEntity> findBySellerEmail(String sellerEmail);

}
