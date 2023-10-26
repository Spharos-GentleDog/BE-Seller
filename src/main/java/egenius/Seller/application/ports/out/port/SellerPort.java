package egenius.Seller.application.ports.out.port;

import egenius.Seller.domain.Seller;


public interface SellerPort {

    Seller signUpSeller(Seller seller);
    boolean checkEmail(String sellerEmail);

}
