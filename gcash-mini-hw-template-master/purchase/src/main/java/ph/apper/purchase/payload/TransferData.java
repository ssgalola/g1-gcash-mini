package ph.apper.purchase.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransferData {

    @JsonProperty(value = "transfer_id")
    private String transferID;

    private String senderID;

    private String recipientID;

    private String amount;
}
