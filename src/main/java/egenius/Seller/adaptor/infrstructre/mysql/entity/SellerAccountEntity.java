package egenius.Seller.adaptor.infrstructre.mysql.entity;

import egenius.Seller.domain.SellerAccount;
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
    private String bank_name;

    @Column(name = "account_number", nullable = false, length = 20)
    private String account_number;

    @Column(name = "owner_name", nullable = false, length = 10)
    private String owner_name;

    @Column(name = "seller_email", unique = true, nullable = false, length = 20)
    private Integer seller_id;

    public static SellerAccountEntity createSellerAccount (String bank_name, String account_number,
                                                           String owner_name){
        return SellerAccountEntity.builder()
                .bank_name(bank_name)
                .account_number(account_number)
                .owner_name(owner_name)
                .build();
    }


}
