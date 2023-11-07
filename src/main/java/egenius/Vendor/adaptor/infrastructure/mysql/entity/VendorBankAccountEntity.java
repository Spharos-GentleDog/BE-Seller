package egenius.Vendor.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Getter
@Builder
@Table(name = "vendor_bank_account")
public class VendorBankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank_name", nullable = false, length = 20)
    private String bankName; // 은행명

    @Column(name = "bank_account_number", nullable = false, length = 20)
    private String bankAccountNumber; //계좌번호

    @Column(name = "banck_account_holder", nullable = false, length = 10)
    private String bankAccountHolder; // 예금주

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private VendorEntity VendorId; // vendor_id


}
