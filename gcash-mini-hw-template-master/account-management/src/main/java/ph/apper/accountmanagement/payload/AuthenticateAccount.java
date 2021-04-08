package ph.apper.accountmanagement.payload;

import lombok.Data;

@Data
public class AuthenticateAccount {
    private String email;
    private String password;
}
