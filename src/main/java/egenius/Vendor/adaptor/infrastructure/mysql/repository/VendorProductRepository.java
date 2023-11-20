package egenius.Vendor.adaptor.infrastructure.mysql.repository;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.Vendor.domain.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorProductRepository extends JpaRepository<VendorProductEntity, Long> {

    VendorProductEntity findByProductDetailId(Long productDetailId);
}
