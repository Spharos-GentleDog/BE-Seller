package egenius.Seller.application.ports.out.port;

import egenius.Seller.application.ports.out.dto.CheckEmailDto;

public interface CheckEmailPort {

    //out usecase
    // domain과 DB를 연결 해주는 부분
    // SRP 원칙에 의해 각 기능 마다 다른 uscase를 사용해야한다
    // SRP 원칙에 따라 sellerPort 와 분리

    CheckEmailDto checkEmail(String sellerEmail);
}
