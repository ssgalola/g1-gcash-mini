package ph.apper.purchase.domain;

import lombok.Data;

@Data
public class Transfer {
    private String transferID;
    private String senderID;
    private String recipientID;
    private String amount;

    public Transfer(String transferID) {
    }
}
