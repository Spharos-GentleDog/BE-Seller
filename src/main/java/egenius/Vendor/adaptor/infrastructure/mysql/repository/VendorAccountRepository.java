package egenius.Vendor.adaptor.infrastructure.mysql.repository;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.BankAccountEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorAccountRepository extends JpaRepository<BankAccountEntity, Integer> {

    BankAccountEntity findByVendorId(VendorEntity vendorEntity);
}
