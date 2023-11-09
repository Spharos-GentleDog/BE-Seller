package egenius.Vendor.adaptor.infrastructure.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 올바르지 않은 객체 생성을 막아준다
@Getter
@Builder
@Table(name = "vendor_bank_account")
@ToString
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank_name", nullable = false, length = 20)
    private String bankName; // 은행명

    @Column(name = "bank_account_number", nullable = false, length = 100)
    private String bankAccountNumber; //계좌번호 암호화 하여 저장

    @Column(name = "banck_account_holder", nullable = false, length = 10)
    private String bankAccountHolder; // 예금주

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "id")
    private VendorEntity vendorId; // vendor_id

    public static BankAccountEntity createBankAccount(String bankName, String bankAccountNumber, String bankAccountHolder, VendorEntity vendorId) {
        return BankAccountEntity.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountHolder(bankAccountHolder)
                .vendorId(vendorId)
                .build();
    }

}
