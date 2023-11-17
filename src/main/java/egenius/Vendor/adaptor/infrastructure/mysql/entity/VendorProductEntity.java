package egenius.Vendor.adaptor.infrastructure.mysql.entity;


import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.DisplayStatusConverter;
import egenius.Vendor.adaptor.infrastructure.mysql.persistance.Converter.SalesStatusConverter;
import egenius.Vendor.domain.enums.DisplayStatus;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Builder
@Table(name = "Vendor_product")
public class VendorProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Vendor_id", referencedColumnName = "id")
    private VendorEntity VendorId;

    @Column(name = "product_detail_id", unique = true, nullable = false)
    private Long productDetailId;

    @Column(name = "display_status", nullable = false)
    private Integer displayStatus;

    @Column(name = "sales_status", nullable = false)
    private Integer salesStatus;

    @Column(name = "sales_count", nullable = false)
    private  Integer salesCount;

    @Column(name = "save_count", nullable = true)
    private  Integer saveCount;

    // 상품 생성
    public static VendorProductEntity createVendorProductEntity(VendorEntity vendorEntity, Long productDetailId,
                                                                Integer displayStatus, Integer salesStatus,
                                                                Integer salesCount, Integer saveCount){
        return VendorProductEntity.builder()
                .VendorId(vendorEntity)
                .productDetailId(productDetailId)
                .displayStatus(displayStatus)
                .salesStatus(salesStatus)
                .salesCount(salesCount)
                .saveCount(saveCount)
                .build();
    }

}
