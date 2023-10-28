package egenius.Seller.domain;

import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SellerAccount {

    private String bankName;
    private String accountNumber;
    private String ownerName;

    public static SellerAccount createSellerAccount(String bankName, String accountNumber, String ownerName){
        return SellerAccount.builder()
                .bankName(bankName)
                .accountNumber(accountNumber)
                .ownerName(ownerName)
                .build();
    }
    public static SellerAccount formSellerAccountEntity(SellerAccountEntity sellerAccountEntity){
        return SellerAccount.builder()
                .bankName(sellerAccountEntity.getBankName())
                .accountNumber(sellerAccountEntity.getAccountNumber())
                .ownerName(sellerAccountEntity.getOwnerName())
                .build();
    }

}
