package egenius.Vendor.application.ports.out.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetVendorProductDto {

    private Long productDetailId;
    private String displayStatus;
    private String  salesStatus;
    private  Integer salesCount;
    private  Integer saveCount;

    public static GetVendorProductDto fromVendorProduct(Long productDetailId, String displayStatus,
                                                        String salesStatus, Integer salesCount, Integer saveCount){
        return GetVendorProductDto.builder()
                .productDetailId(productDetailId)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }
}
