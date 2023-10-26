package egenius.Seller.adaptor.infrastructure.mysql.persistance;

import egenius.Seller.adaptor.infrastructure.mysql.repository.SellerAccountRepository;
import egenius.Seller.adaptor.infrastructure.mysql.entity.SellerAccountEntity;
import egenius.Seller.application.ports.out.port.SellerAccountPort;
import egenius.Seller.domain.SellerAccount;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SellerAccountAdaptor implements SellerAccountPort {

    private final SellerAccountRepository sellerAccountRepository;
    @Override
    @Transactional
    public SellerAccount createSellerAccount(SellerAccount sellerAccount) {

        SellerAccountEntity sellerAccountEntity = sellerAccountRepository.save(SellerAccountEntity.createSellerAccount(
                sellerAccount.getBankName(),
                sellerAccount.getAccountNumber(),
                sellerAccount.getOwnerName()
        ));

        return SellerAccount.formSellerAccountEntity(sellerAccountEntity);
    }
}
