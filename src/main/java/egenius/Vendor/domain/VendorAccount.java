package egenius.Vendor.domain;

import egenius.Vendor.adaptor.infrastructure.mysql.entity.VendorAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class VendorAccount {

    private String bankName;
    private String accountNumber;
    private String ownerName;

    public static VendorAccount createVendorAccount(String bankName, String accountNumber, String ownerName){
        return VendorAccount.builder()
                .bankName(bankName)
                .accountNumber(accountNumber)
                .ownerName(ownerName)
                .build();
    }
    public static VendorAccount formVendorAccountEntity(VendorAccountEntity VendorAccountEntity){
        return VendorAccount.builder()
                .bankName(VendorAccountEntity.getBankName())
                .accountNumber(VendorAccountEntity.getAccountNumber())
                .ownerName(VendorAccountEntity.getOwnerName())
                .build();
    }

}
