package egenius.Seller.application.ports.out.port;

import egenius.Seller.application.ports.out.dto.SellerDto;
import egenius.Seller.domain.Seller;


public interface SellerPort {

    //out usecase
    // domain과 DB를 연결 해주는 부분
    // SRP 원칙에 의해 각 기능 마다 다른 uscase를 사용해야한다
    SellerDto signUpSeller(Seller seller);

}
