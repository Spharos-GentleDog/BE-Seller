package egenius.Seller.application.ports.out.port;

import egenius.Seller.adaptor.infrstructre.mysql.entity.SellerEntity;
import egenius.Seller.domain.Seller;

import java.util.Optional;


public interface SellerPort {

    Seller signUpSeller(Seller seller);
    String checkEmail(String seller_email);

}
