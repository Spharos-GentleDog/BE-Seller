package egenius.Vendor.adaptor.web.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class RequestCreateBankAccount {

    @NotBlank(message = "은행명은 필수 입니다")
    private String bankName;
    @NotBlank(message = "계좌번호는 필수 입니다")
    private String bankAccountNumber;
    @NotBlank(message = "예금주는 필수 입니다")
    private String bankAccountHolder;
}
