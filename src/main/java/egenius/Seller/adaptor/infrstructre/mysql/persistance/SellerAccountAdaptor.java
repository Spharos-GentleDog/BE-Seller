package egenius.Seller.adaptor.infrstructre.mysql.persistance;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerAccountEntity;
import egenius.Seller.adaptor.infrstructre.mysql.repository.SellerAccountRepository;
import egenius.Seller.application.ports.out.port.SellerAccountPort;
import egenius.Seller.domain.SellerAccount;
import jakarta.transaction.Transactional;
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
                sellerAccount.getBank_name(),
                sellerAccount.getAccount_number(),
                sellerAccount.getOwner_name()
        ));

        return SellerAccount.formSellerAccountEntity(sellerAccountEntity);
    }
}
