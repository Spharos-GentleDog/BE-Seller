package egenius.Vendor.adaptor.web.controller;

import egenius.Vendor.adaptor.web.request.RequestCreateVendorProduct;
import egenius.Vendor.adaptor.web.request.RequestUpdateVendorProduct;
import egenius.Vendor.application.ports.in.port.CreateVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.GetVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.SignUpUseCase;
import egenius.Vendor.application.ports.in.port.UpdateVendorProductUseCase;
import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;
import egenius.Vendor.application.ports.in.query.GetVendorProductQuery;
import egenius.Vendor.application.ports.in.query.UpdateVendorProductQuery;
import egenius.Vendor.global.common.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vendor-product")
@RequiredArgsConstructor
@Slf4j
public class VendorProductController {

    private final CreateVendorProductUseCase createVendorProductUseCase;
    private final UpdateVendorProductUseCase updateVendorProductUseCase;
    private final GetVendorProductUseCase getVendorProductUseCase;

    // 상품 등록
    @PostMapping("/createVendorProduct")
    public BaseResponse<?> createVendorProduct(@RequestBody RequestCreateVendorProduct requestCreateVendorProduct){
        log.info("상품 등록 정보: {}", requestCreateVendorProduct);
        createVendorProductUseCase.createVendorProduct(CreateVendorProductQuery.toQuery(
                requestCreateVendorProduct.getVendorEmail(),
                requestCreateVendorProduct.getProductDetailId()
        ));
        return new BaseResponse<>();
    }

    //재고 변경
    @PostMapping("/updateVendorProduct")
    public BaseResponse<?> updateVendorProduct(@RequestBody RequestUpdateVendorProduct requestUpdateVendorProduct){
        log.info("상품 정보 변경: {}", requestUpdateVendorProduct);
        updateVendorProductUseCase.updateVendorProduct(UpdateVendorProductQuery.toQuery(
                requestUpdateVendorProduct.getVendorEmail(),
                requestUpdateVendorProduct.getProductDetailId(),
                requestUpdateVendorProduct.getDisplayStatus(),
                requestUpdateVendorProduct.getSalesStatus(),
                requestUpdateVendorProduct.getSalesCount(),
                requestUpdateVendorProduct.getSaveCount()
        ));
        return new BaseResponse<>();
    }

    //재고 조회
    @GetMapping("/getVendorProduct")
    public BaseResponse<?> getVendorProduct(@RequestHeader("email") String vendorEmail){
        log.info("상품 조회: {}", vendorEmail);
        return new BaseResponse<>(getVendorProductUseCase.getVendorProduct(
                GetVendorProductQuery.toQuery(vendorEmail)));
    }

}
