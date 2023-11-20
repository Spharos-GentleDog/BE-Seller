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

    //재고 수정
    public static VendorProduct updateVendorProduct(String vendorEmail, Long productDetailId, String displayStatus,
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

    //재고조회
    public static VendorProduct getVendorProduct(String vendorEmail, Long productDetailId, String displayStatus,
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

    //상품 삭제
    public static VendorProduct deleteVendorProduct(String vendorEmail, Long productDetailId) {
        return VendorProduct.builder()
                .vendorEmail(vendorEmail)
                .productDetailId(productDetailId)
                .build();
    }

    //장바구니 재고 조회
    public static VendorProduct getSalesCount(Long productDetailId) {
        return VendorProduct.builder()
                .productDetailId(productDetailId)
                .build();
    }

}
