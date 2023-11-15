package egenius.Vendor.application.service;

import egenius.Vendor.adaptor.infrastructure.mysql.repository.VendorRepository;
import egenius.Vendor.application.ports.in.port.EmailAuthUseCase;
import egenius.Vendor.application.ports.in.port.EmailVerifyUseCase;
import egenius.Vendor.application.ports.in.query.EmailAuthQuery;
import egenius.Vendor.application.ports.in.query.EmailVerifyQuery;
import egenius.Vendor.application.ports.out.port.CheckEmailPort;
import egenius.Vendor.global.common.exception.BaseException;
import egenius.Vendor.global.common.response.BaseResponseStatus;
import egenius.Vendor.global.util.RedisUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService implements EmailAuthUseCase, EmailVerifyUseCase {


    private final CheckEmailPort checkEmailPort;
    private final JavaMailSender mailSender;
    private final RedisUtil redisUtil;

    @Value("${spring.mail.username}")
    private String configEmail;

    // 이메일으로 보내는 인증 코드 생성
    public String createdCode() {
        int leftLimit = 48; // number '0'
        int rightLimit = 122; // alphabet 'z'
        int targetStringLength = 6;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <=57 || i >=65) && (i <= 90 || i>= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }


    // 인증 메시지 생성 및 메시지 전송 후 인증 코드를 Redis에 저장
    public MimeMessage createEmailForm(String email) throws MessagingException {

        String authCode = createdCode();
        log.info("authCode is : {}", authCode);
        MimeMessage message = mailSender.createMimeMessage();
        message.addRecipients(MimeMessage.RecipientType.TO, email);
        message.setText("<div style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 540px; height: 600px; border-top: 4px solid {$point_color}; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">\n" +
                        "   <h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">\n" +
                        "      <span style=\"font-size: 15px; margin: 0 0 10px 3px;\">GentleDog</span><br />\n" +
                        "      <span style=\"color: {$point_color};\">메일인증</span> 안내입니다.\n" +
                        "   </h1>\n" +
                        "   <p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">\n" +
                        "      안녕하세요.<br />\n" +
                        "      GentleDog에 가입해 주셔서 진심으로 감사드립니다.<br />\n" +
                        "      아래 <b style=\"color: {$point_color};\">'메일 인증 번호'</b>를 입력하여 메일인증을 완료해 주세요.<br />\n" +
                        "      감사합니다.<br/><br/>" +
                        "   </p>\n" +
                        "   <b style=\" font-size : 40px ; color: {$point_color};\">메일 인증 번호 : "+authCode+"</b>" +
                        "   <br/><br/><br/></p>\n" +
                        "   <div style=\"border-top: 1px solid #DDD; padding: 5px;\">\n" +
                        "      <p style=\"font-size: 13px; line-height: 21px; color: #555;\">\n" +
                        "         만약 인증번호가 정상적으로 보이지않거나 인증이 지속적으로 실패된다면 고객센터로 연락주시면 감사하겠습니다.<br />\n" +
                        "      </p>\n" +
                        "   </div>\n" +
                        "</div>"
                , "UTF-8", "html");
        message.setFrom(configEmail);

        redisUtil.createDataExpire(email, authCode, 60 * 30L);
        return message;
    }

    // 이메일 인증
    @Override
    public void emailAuth(EmailAuthQuery emailAuthQuery) {

        // 이메일이 존재한다면 이미 가입된 유저
        if (checkEmailPort.checkEmail(emailAuthQuery.getEmail()).isVendorEmail()) {
            throw new BaseException(BaseResponseStatus.EMAIL_IS_USED);
        }

        if (redisUtil.existData(emailAuthQuery.getEmail())) {
            redisUtil.deleteData(emailAuthQuery.getEmail());
        }

        MimeMessage emailForm = null;
        try {
            emailForm = createEmailForm(emailAuthQuery.getEmail());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        mailSender.send(emailForm);

    }

    // 이메일 인증 코드 확인
    @Override
    public void emailVerify(EmailVerifyQuery emailVerifyQuery) {

        String codeFoundByEmail = redisUtil.getData(emailVerifyQuery.getEmail());

        if (codeFoundByEmail != null && codeFoundByEmail.equals(emailVerifyQuery.getCode())) {
            redisUtil.deleteData(emailVerifyQuery.getEmail());
        } else if (codeFoundByEmail == null) {
            throw new BaseException(BaseResponseStatus.WRONG_AUTH_CODE);
        } else {
            throw new BaseException(BaseResponseStatus.WRONG_AUTH_CODE);
        }

    }
}
