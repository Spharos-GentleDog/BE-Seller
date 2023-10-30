package egenius.Seller.adaptor.web.request;

import egenius.Seller.application.ports.in.CheckEmailUseCase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class RequestCheckEmail {

    // input model
    // Web adaptor의 일부분으로 web에서 받아온 데이터의 유효성 검증을 수행 한다
    // 일종의 DTO

    // SRP원칙에 의해 usecase 마다 별도의 input model을 사용해야 한다
    // => 형식은 동일 해도 각 기능마다 유효성 검증이나, 파라미터의 변경이 있을 수 있기 때문

    // controller 단에서 @RequestBody annotantion 과 함께 @Valid annotantion을 함꼐 작성하면
    // RequestBody 로 들어오는 객체에 대해서 검증을 수행한다
    // 검증에 대한 세부 사항은 객체 안에 정의 해야 한다.

    // RequestBody 안의 데이터에 대한 구문상의 유효성 검증을 수행 한다.
    @NotBlank(message = "이메일은 필수 입니다") // null, "", " " 값이 들어올경우 error 처리
    @Email //이메일 형식이 아닌 경우 error 처리
    private String sellerEmail;


}
