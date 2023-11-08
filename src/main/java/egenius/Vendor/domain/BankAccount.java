package egenius.Vendor.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BankAccount {

    // 계좌번호는 암호화 해서 저장해야 한다

    private String bankName; // 은행명
    private String bankAccountNumber; //계좌번호
    private String bankAccountHolder; // 예금주
    private String vendorEmail; // vendor_id

    public static BankAccount createBankAccount(String bankName, String bankAccountNumber, String bankAccountHolder, String vendorEmail) {
        return BankAccount.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountHolder(bankAccountHolder)
                .vendorEmail(vendorEmail)
                .build();
    }

}
