package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.CheckEmailQuery;
import egenius.Vendor.application.ports.out.dto.CheckEmailDto;


public interface CheckEmailUseCase {

    // domain과 web을 연결 해주는 부분
    // SRP 원칙에 따라 각 기능 별로 다른 usecase를 생성해야 한다.
    // doamin에 맞춰서 정의한다.

    CheckEmailDto checkEmail(CheckEmailQuery checkEmailQuery);

}
