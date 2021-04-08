package ph.apper.purchase.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TransferMoney {
    @NotBlank(message = "Sender ID is required")
    private String senderID;

    @NotBlank(message = "Recipient ID is required")
    private String recipientID;

    @NotBlank(message = "Amount is required")
    private String amount;
}