package egenius.Vendor.adaptor.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
//@ToString
public class RequestSignUpVendor {

    // 회원 가입시 Front에서 전달 받는 데이터

    @Email
    @NotBlank(message = "이메일은 필수 입니다")
    private String vendorEmail;

    @NotBlank(message = "사업자번호는 필수 입니다")
    private String businessNumber;

    @NotBlank(message = "비밀번호는 필수 입니다")
    private String password;

    @NotBlank(message = "통신판매업 신고번호는 필수 입니다")
    private String mailOrderNumber;

    @NotBlank(message = "브랜드명은 필수 입니다")
    private String brandName;

    @NotBlank(message = "브랜드이미지는 필수 입니다")
    private String brandLogoImageUrl;

    private String brandContent;

    private String homepageUrl;

    @NotBlank(message = "사업자 유형은 필수 입니다")
    private String businessType;

    @NotBlank(message = "업체명은 필수 입니다")
    private String companyName;

    private String companyAddress;

//    @NotBlank(message = "개업일자는 필수 입니다")
    private LocalDate openedAt;

    @NotBlank(message = "대표자명은 필수 입니다")
    private String vendorName;

    @NotBlank(message = "대표번호는 필수 입니다")
    private String callCenterNumber;

    @NotBlank(message = "담당자 이름은 필수 입니다")
    private String managerName;

    @NotBlank(message = "연락번호는 필수 입니다")
    private String managerPhoneNumber;

}
