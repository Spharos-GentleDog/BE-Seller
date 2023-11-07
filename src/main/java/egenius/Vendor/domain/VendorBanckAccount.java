package egenius.Vendor.domain;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VendorBanckAccount {

    private String bankName; // 은행명
    private String bankAccountNumber; //계좌번호
    private String bankAccountHolder; // 예금주
    private Integer VendorId; // vendor_id

    public static VendorBanckAccount createVendorBankAccount(String bankName, String bankAccountNumber, String bankAccountHolder, Integer VendorId) {
        return VendorBanckAccount.builder()
                .bankName(bankName)
                .bankAccountNumber(bankAccountNumber)
                .bankAccountHolder(bankAccountHolder)
                .VendorId(VendorId)
                .build();
    }

}
