package egenius.Vendor.application.ports.in.query;

import egenius.Vendor.adaptor.web.request.RequestSignUpVendor;
import egenius.Vendor.domain.enums.BusinessTypes;
import egenius.Vendor.domain.enums.VendorStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Getter
@Builder
@Slf4j
public class SignUpQuery {

    // input model
    // Web adaptor의 일부분으로 web에서 받아온 데이터의 유효성 검증을 수행 한다
    // 일종의 DTO

    // SRP원칙에 의해 usecase 마다 별도의 input model을 사용해야 한다
    // => 형식은 동일 해도 각 기능마다 유효성 검증이나, 파라미터의 변경이 있을 수 있기 때문

    // web으로 전달 받은 데이터를 domain으로 전달 해주는 Dto
    // 필드 : domain의 data type, request 에서 받는 데이터
    // 메소드 : request 를 받아 domain의 data type으로 변경
    // 외부에서 내부로 들어가는 데이터
    private String vendorEmail;
    private String businessNumber;
    private String vendorPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private BusinessTypes businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String vendorName;
    private String callCenterNumber;
    private String phoneNumber;
    private VendorStatus vendorStatus;


    public static SignUpQuery toQuery(RequestSignUpVendor requestSignUpVendor){

        // Business Type
        // -> requset : String (코드 값 : 0, 1)
        // -> domain : Enum
        // domain 에 정의된 값으로 변경 필요
        // String -> Integer 변환 ("0" -> 0)
        // Integer -> Enum의 name 값으로 변환 ( 0 -> enum -> 개인)
        BusinessTypes businessTypeEnum = BusinessTypes.ofCodeValue(
                Integer.valueOf(requestSignUpVendor.getBusinessType()));

        log.info("b_type:{}",businessTypeEnum.getNameValue());
        VendorStatus VendorStatusEnum = VendorStatus.READY;

        return SignUpQuery.builder()
                .vendorEmail(requestSignUpVendor.getVendorEmail())
                .businessNumber(requestSignUpVendor.getBusinessNumber())
                .vendorPassword(requestSignUpVendor.getVendorPassword())
                .mailOrderNumber(requestSignUpVendor.getMailOrderNumber())
                .brandName(requestSignUpVendor.getBrandName())
                .brandLogoImageUrl(requestSignUpVendor.getBrandLogoImageUrl())
                .brandContent(requestSignUpVendor.getBrandContent())
                .homepageUrl(requestSignUpVendor.getHomepageUrl())
                .businessType(businessTypeEnum)
                .companyName(requestSignUpVendor.getCompanyName())
                .companyAddress(requestSignUpVendor.getCompanyAddress())
                .openedAt(requestSignUpVendor.getOpenedAt())
                .vendorName(requestSignUpVendor.getVendorName())
                .callCenterNumber(requestSignUpVendor.getCallCenterNumber())
                .phoneNumber(requestSignUpVendor.getPhoneNumber())
                .vendorStatus(VendorStatusEnum)
                .build();
    }
}
