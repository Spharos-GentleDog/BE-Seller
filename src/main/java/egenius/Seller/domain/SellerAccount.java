package egenius.Seller.domain;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerAccountEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SellerAccount {

    private String bank_name;
    private String account_number;
    private String owner_name;

    public static SellerAccount createSellerAccount(String bank_name, String account_number, String owner_name){
        return SellerAccount.builder()
                .bank_name(bank_name)
                .account_number(account_number)
                .owner_name(owner_name)
                .build();
    }
    public static SellerAccount formSellerAccountEntity(SellerAccountEntity sellerAccountEntity){
        return SellerAccount.builder()
                .bank_name(sellerAccountEntity.getBank_name())
                .account_number(sellerAccountEntity.getAccount_number())
                .owner_name(sellerAccountEntity.getOwner_name())
                .build();
    }

}
