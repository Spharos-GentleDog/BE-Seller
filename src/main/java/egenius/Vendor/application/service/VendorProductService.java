package egenius.Vendor.application.service;

import egenius.Vendor.application.ports.in.port.*;
import egenius.Vendor.application.ports.in.query.*;
import egenius.Vendor.application.ports.out.dto.GetSalesCountDto;
import egenius.Vendor.application.ports.out.dto.GetVendorProductDto;
import egenius.Vendor.application.ports.out.port.*;
import egenius.Vendor.domain.VendorProduct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VendorProductService implements CreateVendorProductUseCase , UpdateVendorProductUseCase,
        GetVendorProductUseCase, DeleteVendorProductUseCase, GetSalesCountUseCase {

    private final CreateVendorProductPort createVendorProductPort;
    private final UpdateVendorProductPort updateVendorProductPort;
    private final GetVendorProductPort getVendorProductPort;
    private final DeleteVendorProductPort deleteVendorProductPort;
    private final GetSalesCountPort getSalesCountPort;

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

    // 상품 정보 가져오기 (판매자 재고 조회)
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

    @Override
    public GetSalesCountDto getSalesCount(GetSalesCountQuery getSalesCountQuery) {

        return getSalesCountPort.getSalesCount(VendorProduct.getSalesCount(
                getSalesCountQuery.getProductDetailId()));
    }

    //장바구니 재고 조회


}
