package egenius.Vendor.adaptor.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestChangeInfo {

    @Email
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "브랜드 로고 이미지 URL을 입력해주세요.")
    private String brandLogoImageUrl;

    private String brandContent;

    private String homepageUrl;

    private String companyAddress;

    @NotBlank(message = "콜센터 번호를 입력해주세요.")
    private String callCenterNumber;

    @NotBlank(message = "담당자 이름을 입력해주세요.")
    private String managerName;

    @NotBlank(message = "담당자 전화번호를 입력해주세요.")
    private String managerPhoneNumber;
}
