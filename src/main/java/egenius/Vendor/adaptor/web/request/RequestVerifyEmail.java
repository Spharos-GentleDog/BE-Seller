package egenius.Vendor.adaptor.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestVerifyEmail {

    @Email
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotBlank(message = "인증번호를 입력해주세요.")
    private String code;
}
