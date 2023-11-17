package egenius.Vendor.adaptor.infrastructure.mysql.persistance.Adaptors;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorProductEntity;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.DisplayStatusConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.SalesStatusConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorProductRepository;
import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.out.port.CreateVendorProductPort;
import egenius.Vendor.domain.VendorProduct;
import egenius.Vendor.domain.enums.DisplayStatus;
import egenius.Vendor.domain.enums.SalesStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class VendorProductAdaptor implements CreateVendorProductPort {

    private final VendorProductRepository vendorProductRepository;
    private final VendorRepository vendorRepository;
    private final DisplayStatusConverter displayStatusConverter;
    private final SalesStatusConverter salesStatusConverter;

    @Override
    public void createVendorProduct(VendorProduct vendorProduct) {

        log.info("판매자 상품 생성");

        Optional<VendorEntity> vendorEntity = vendorRepository.findByVendorEmail(vendorProduct.getVendorEmail());
        if(vendorEntity.isEmpty()){
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }

        DisplayStatus displayStatus = DisplayStatus.ofNameValue(vendorProduct.getDisplayStatus());
        Integer displayStatusCode = displayStatusConverter.convertToDatabaseColumn(displayStatus);

        SalesStatus salesStatus = SalesStatus.ofNameValue(vendorProduct.getSalesStatus());
        Integer salesStatusCode = salesStatusConverter.convertToDatabaseColumn(salesStatus);

        vendorProductRepository.save(VendorProductEntity.createVendorProductEntity(
                vendorEntity.get(),
                vendorProduct.getProductDetailId(),
                displayStatusCode,
                salesStatusCode,
                vendorProduct.getSalesCount(),
                vendorProduct.getSaveCount()
        ));


    }
}
