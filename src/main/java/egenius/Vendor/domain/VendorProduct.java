package egenius.Vendor.domain;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.*;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class VendorProduct {

    private String vendorEmail;
    private Long productDetailId;
    private String displayStatus;
    private String salesStatus;
    private  Integer salesCount;
    private  Integer saveCount;


    // 상품 생성
    public static VendorProduct createVendorProduct(String vendorEmail, Long productDetailId, String displayStatus,
                                                    String salesStatus, Integer salesCount, Integer saveCount) {
        return VendorProduct.builder()
                .vendorEmail(vendorEmail)
                .productDetailId(productDetailId)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }

}
