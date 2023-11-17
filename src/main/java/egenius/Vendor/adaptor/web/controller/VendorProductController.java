package egenius.Vendor.adaptor.web.controller;

import egenius.Vendor.adaptor.web.request.RequestCreateVendorProduct;
import egenius.Vendor.application.ports.in.port.CreateVendorProductUseCase;
import egenius.Vendor.application.ports.in.port.SignUpUseCase;
import egenius.Vendor.application.ports.in.query.CreateVendorProductQuery;
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

}
