package egenius.Vendor.adaptor.web.request;

import lombok.Getter;

import java.util.List;

@Getter
public class RequestCreateVendorProduct {

    private String vendorEmail; // 판매자 ID
    private Long productDetailId; // 상품 상세 ID
}
