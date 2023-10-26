package egenius.Seller.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Getter
@Builder
@Table(name="seller_account")
public class SellerAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank_name", nullable = false, length = 20)
    private String bankName;

    @Column(name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    @Column(name = "owner_name", nullable = false, length = 10)
    private String ownerName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private SellerEntity sellerId;

    public static SellerAccountEntity createSellerAccount (String bankName, String accountNumber,
                                                           String ownerName){
        return SellerAccountEntity.builder()
                .bankName(bankName)
                .accountNumber(accountNumber)
                .ownerName(ownerName)
                .build();
    }


}
