package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CreateVendorProductUseCase;
import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;
import egenius.Vendor.application.ports.out.port.CreateVendorProductPort;
import egenius.Vendor.domain.VendorProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorProductService implements CreateVendorProductUseCase {

    private final CreateVendorProductPort createVendorProductPort;

    @Override
    public void createVendorProduct(CreateVendorProductQuery createVendorProductQuery) {
        log.info("상품 등록 {}", createVendorProductQuery);

        createVendorProductPort.createVendorProduct(
                VendorProduct.createVendorProduct(
                createVendorProductQuery.getVendorEmail(),
                createVendorProductQuery.getProductDetailId(),
                        "진열중지",
                        "판매중지",
                        0,
                        0

        ));

    }
}
