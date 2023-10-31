package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.SignUpQuery;
import egenius.Vendor.application.ports.out.dto.VendorDto;

public interface SignUpUseCase {

    // web과 domain을 연결해주는 부분
    // SRP 원칙에 의해 하나의 Usecase는 하나의 기능만 하도록 작성해야 한다 (유지보수성 때문에)

    // domain을 바탕으로 정의된 비지니스 로직의 추상체
    VendorDto signUpVendor(SignUpQuery signUpQuery);

}
