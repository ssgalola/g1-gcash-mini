package ph.apper.accountmanagement.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ph.apper.accountmanagement.domain.Account;

@Data
public class GetAccountResponse {
    public GetAccountResponse(Account account){
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
        this.email = account.getEmail();
        this.balance = account.getBalance().toString();
    }

    @JsonProperty(value="firstName")
    private String firstName;

    @JsonProperty(value="lastName")
    private String lastName;

    @JsonProperty(value="email")
    private String email;

    @JsonProperty(value="balance")
    private String balance;

}
