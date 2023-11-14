package egenius.Vendor.adaptor.web.request;

import lombok.Getter;

@Getter
public class RequestChangePassword {

    private String email;
    private String newPassword;

}
