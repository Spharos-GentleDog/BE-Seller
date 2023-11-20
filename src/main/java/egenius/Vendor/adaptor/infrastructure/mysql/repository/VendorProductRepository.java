package egenius.Vendor.adaptor.infrastructure.mysql.repository;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.Vendor.domain.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorProductRepository extends JpaRepository<VendorProductEntity, Long> {

    VendorProductEntity findByProductDetailId(Long productDetailId);

    List<VendorProductEntity> findAllByVendorId(VendorEntity vendorEntity);
}
