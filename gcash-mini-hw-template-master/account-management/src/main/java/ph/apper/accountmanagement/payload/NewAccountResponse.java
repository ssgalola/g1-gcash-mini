package ph.apper.accountmanagement.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewAccountResponse {
    public NewAccountResponse(String verificationCode){
        this.verificationCode = verificationCode;
    }
    @JsonProperty(value = "verificationCode")
    private String verificationCode;
}
