package ph.apper.purchase.payload;

import lombok.Data;

@Data
public class GetTransferResponse {
    private String transferID;
    private String senderID;
    private String recipientID;
    private String amount;
}
