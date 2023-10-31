package egenius.Seller.application.ports.in.port;

import egenius.Seller.adaptor.web.request.RequestCheckEmail;
import egenius.Seller.application.ports.in.query.CheckEmailQuery;
import egenius.Seller.application.ports.out.dto.CheckEmailDto;
import lombok.Builder;
import lombok.Getter;


public interface CheckEmailUseCase {

    // domain과 web을 연결 해주는 부분
    // SRP 원칙에 따라 각 기능 별로 다른 usecase를 생성해야 한다.
    // doamin에 맞춰서 정의한다.

    CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery);

}
