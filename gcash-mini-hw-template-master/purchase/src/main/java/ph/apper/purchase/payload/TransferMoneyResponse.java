package ph.apper.purchase.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransferMoneyResponse {

    public TransferMoneyResponse(String transferID) {
        this.transferID = transferID;
    }

    @JsonProperty("transfer_id")
    private String transferID;
}
