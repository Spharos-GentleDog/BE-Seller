package egenius.Seller.application.ports.out.port;

import egenius.Seller.domain.SellerAccount;

public interface SellerAccountPort {

    SellerAccount createSellerAccount(SellerAccount sellerAccount);
}
