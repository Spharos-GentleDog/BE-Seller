package egenius.Seller.adaptor.infrstructre.mysql.entity;


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

    @Column(name = "seller_email", unique = true, nullable = false, length = 20)
    private Integer seller_id;

    @Column(name = "product_id", unique = true, nullable = false)
    private Long product_id;

    @Column(name = "display_status", nullable = false)
    private Integer display_status;

    @Column(name = "sales_status", nullable = false)
    private Integer sales_status;

    @Column(name = "sales_count", nullable = false)
    private  Integer sales_count;

    @Column(name = "save_count", nullable = true)
    private  Integer save_count;
}
