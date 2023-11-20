package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CreateVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.UpdateVendorProductUseCase;
import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;
import egenius.Vendor.application.ports.in.query.UpdateVendorProductQuery;
import egenius.Vendor.application.ports.out.port.CreateVendorProductPort;
import egenius.Vendor.application.ports.out.port.UpdateVendorProductPort;
import egenius.Vendor.domain.VendorProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorProductService implements CreateVendorProductUseCase , UpdateVendorProductUseCase {

    private final CreateVendorProductPort createVendorProductPort;
    private final UpdateVendorProductPort updateVendorProductPort;

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


    @Override
    public void updateVendorProduct(UpdateVendorProductQuery updateVendorProductQuery) {
        log.info("상품 정보 변경 {}", updateVendorProductQuery);

        updateVendorProductPort.updateVendorProduct(
                VendorProduct.updateVendorProduct(
                        updateVendorProductQuery.getVendorEmail(),
                        updateVendorProductQuery.getProductDetailId(),
                        updateVendorProductQuery.getDisplayStatus(),
                        updateVendorProductQuery.getSalesStatus(),
                        updateVendorProductQuery.getSalesCount(),
                        updateVendorProductQuery.getSaveCount()
                )
        );
    }
}
