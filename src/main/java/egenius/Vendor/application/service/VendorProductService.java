package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.CreateVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.DeleteVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.GetVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.UpdateVendorProductUseCase;
import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;
import egenius.Vendor.application.ports.in.query.DeleteVendorProductQuery;
import egenius.Vendor.application.ports.in.query.GetVendorProductQuery;
import egenius.Vendor.application.ports.in.query.UpdateVendorProductQuery;
import egenius.Vendor.application.ports.out.dto.GetVendorProductDto;
import egenius.Vendor.application.ports.out.port.CreateVendorProductPort;
import egenius.Vendor.application.ports.out.port.DeleteVendorProductPort;
import egenius.Vendor.application.ports.out.port.GetVendorProductPort;
import egenius.Vendor.application.ports.out.port.UpdateVendorProductPort;
import egenius.Vendor.domain.VendorProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorProductService implements CreateVendorProductUseCase , UpdateVendorProductUseCase,
        GetVendorProductUseCase, DeleteVendorProductUseCase {

    private final CreateVendorProductPort createVendorProductPort;
    private final UpdateVendorProductPort updateVendorProductPort;
    private final GetVendorProductPort getVendorProductPort;
    private final DeleteVendorProductPort deleteVendorProductPort;

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

    // 상품 정보 가져오기
    @Override
    public List<GetVendorProductDto> getVendorProduct(GetVendorProductQuery getVendorProductQuery) {
        return getVendorProductPort.getVendorProduct(getVendorProductQuery.getVendorEmail());
    }

    //상품 삭제
    @Override
    public void deleteVendorProduct(DeleteVendorProductQuery deleteVendorProductQuery) {
        deleteVendorProductPort.deleteVendorProduct(
                VendorProduct.deleteVendorProduct(
                        deleteVendorProductQuery.getVendorEmail(),
                        deleteVendorProductQuery.getProductDetailId()
                )
        );
    }


}
