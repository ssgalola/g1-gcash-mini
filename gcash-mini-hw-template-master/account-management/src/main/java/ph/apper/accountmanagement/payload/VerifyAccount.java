package ph.apper.accountmanagement.payload;

import lombok.Data;

@Data
public class VerifyAccount {
    private String verificationCode;
    private String email;
}
