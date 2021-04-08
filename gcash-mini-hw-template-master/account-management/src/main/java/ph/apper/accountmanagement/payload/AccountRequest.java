package ph.apper.accountmanagement.payload;

import lombok.Data;

@Data
public class AccountRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
