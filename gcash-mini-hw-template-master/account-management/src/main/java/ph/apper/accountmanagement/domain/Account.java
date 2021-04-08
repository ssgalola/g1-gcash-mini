package ph.apper.accountmanagement.domain;

import lombok.Data;

import java.util.UUID;

@Data
public class Account {
    private UUID accountId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String verificationCode;
}
