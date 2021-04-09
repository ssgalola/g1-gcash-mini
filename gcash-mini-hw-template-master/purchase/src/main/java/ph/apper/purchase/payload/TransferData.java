package ph.apper.purchase.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransferData {

    @JsonProperty(value = "transfer_id")
    private String transferID;

    @JsonProperty(value = "sender_id")
    private String senderID;

    @JsonProperty(value = "recipient_id")
    private String recipientID;

    private String amount;
}
