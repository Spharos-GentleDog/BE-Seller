package egenius.Vendor.application.ports.in.query;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CreateVendorProductQuery {

    private String vendorEmail; // 판매자 ID
    private Long productDetailId; // 상품 상세 ID

    public static CreateVendorProductQuery toQuery(String vendorEmail, Long productDetailId){
        return CreateVendorProductQuery.builder()
                .vendorEmail(vendorEmail)
                .productDetailId(productDetailId)
                .build();
    }

}
