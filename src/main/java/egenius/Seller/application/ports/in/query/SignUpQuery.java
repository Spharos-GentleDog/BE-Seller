package egenius.Seller.application.ports.in.query;

import egenius.Seller.adaptor.web.request.RequestSignUpSeller;
import egenius.Seller.domain.enums.BusinessTypes;
import egenius.Seller.domain.enums.SellerStatus;
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
    private String sellerEmail;
    private String businessNumber;
    private String sellerPassword;
    private String mailOrderNumber;
    private String brandName;
    private String brandLogoImageUrl;
    private String brandContent;
    private String homepageUrl;
    private BusinessTypes businessType;
    private String companyName;
    private String companyAddress;
    private LocalDate openedAt;
    private String sellerName;
    private String callCenterNumber;
    private String phoneNumber;
    private SellerStatus sellerStatus;


    public static SignUpQuery toQuery(RequestSignUpSeller requestSignUpSeller){

        // Business Type
        // -> requset : String (코드 값 : 0, 1)
        // -> domain : Enum
        // domain 에 정의된 값으로 변경 필요
        // String -> Integer 변환 ("0" -> 0)
        // Integer -> Enum의 name 값으로 변환 ( 0 -> enum -> 개인)
        BusinessTypes businessTypeEnum = BusinessTypes.ofCodeValue(
                Integer.valueOf(requestSignUpSeller.getBusinessType()));

        log.info("b_type:{}",businessTypeEnum.getNameValue());
        SellerStatus sellerStatusEnum = SellerStatus.READY;

        return SignUpQuery.builder()
                .sellerEmail(requestSignUpSeller.getSellerEmail())
                .businessNumber(requestSignUpSeller.getBusinessNumber())
                .sellerPassword(requestSignUpSeller.getSellerPassword())
                .mailOrderNumber(requestSignUpSeller.getMailOrderNumber())
                .brandName(requestSignUpSeller.getBrandName())
                .brandLogoImageUrl(requestSignUpSeller.getBrandLogoImageUrl())
                .brandContent(requestSignUpSeller.getBrandContent())
                .homepageUrl(requestSignUpSeller.getHomepageUrl())
                .businessType(businessTypeEnum)
                .companyName(requestSignUpSeller.getCompanyName())
                .companyAddress(requestSignUpSeller.getCompanyAddress())
                .openedAt(requestSignUpSeller.getOpenedAt())
                .sellerName(requestSignUpSeller.getSellerName())
                .callCenterNumber(requestSignUpSeller.getCallCenterNumber())
                .phoneNumber(requestSignUpSeller.getPhoneNumber())
                .sellerStatus(sellerStatusEnum)
                .build();
    }
}
