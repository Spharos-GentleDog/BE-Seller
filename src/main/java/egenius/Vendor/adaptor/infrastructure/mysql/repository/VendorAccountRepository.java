package egenius.Vendor.adaptor.infrastructure.mysql.repository;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAccountRepository extends JpaRepository<BankAccountEntity, Integer> {

    //회원가입시 계좌생성 및 저장
    BankAccountEntity save(BankAccountEntity VendorAccountEntity);
}
