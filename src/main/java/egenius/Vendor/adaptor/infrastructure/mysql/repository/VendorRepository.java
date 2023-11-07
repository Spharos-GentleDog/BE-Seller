package egenius.Vendor.adaptor.infrastructure.mysql.repository;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Long> {
    //이메일 중복체크 및 존재 확인
    Optional<VendorEntity> findByVendorEmail(String vendorEmail);

}
