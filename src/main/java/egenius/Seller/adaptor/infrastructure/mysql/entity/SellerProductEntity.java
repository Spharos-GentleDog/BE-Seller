package egenius.Seller.adaptor.infrastructure.mysql.entity;


import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Builder
@Table(name = "seller_product")
public class SellerProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private SellerEntity sellerId;

    @Column(name = "product_id", unique = true, nullable = false)
    private Long productId;

    @Column(name = "display_status", nullable = false)
    private Integer displayStatus;

    @Column(name = "sales_status", nullable = false)
    private Integer salesStatus;

    @Column(name = "sales_count", nullable = false)
    private  Integer salesCount;

    @Column(name = "save_count", nullable = true)
    private  Integer saveCount;
}
