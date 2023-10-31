package egenius.Vendor.application.ports.out.port;

import egenius.Vendor.application.ports.out.dto.VendorDto;
import egenius.Vendor.domain.Vendor;


public interface VendorPort {

    //out usecase
    // domain과 DB를 연결 해주는 부분
    // SRP 원칙에 의해 각 기능 마다 다른 uscase를 사용해야한다
    VendorDto signUpVendor(Vendor vendor);

}
