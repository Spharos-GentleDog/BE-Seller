package egenius.Seller.adaptor.infrstructre.mysql.repository;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    // 회원가입
    SellerEntity save(SellerEntity sellerEntity);

}
