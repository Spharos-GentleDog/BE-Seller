package egenius.Vendor.application.ports.in.port;

import egenius.Vendor.application.ports.in.query.EmailAuthQuery;
import jakarta.mail.MessagingException;

public interface EmailAuthUseCase {

    void emailAuth(EmailAuthQuery emailAuthQuery);
}
