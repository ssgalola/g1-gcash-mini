package ph.apper.purchase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ph.apper.purchase.domain.Account;
import ph.apper.purchase.payload.TransferMoney;
import ph.apper.purchase.payload.TransferMoneyResponse;
import ph.apper.purchase.service.TransferService;

import javax.validation.Valid;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("transfer")
public class TransferController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    private final RestTemplate restTemplate;

    private final TransferService transferService;

    public TransferController(RestTemplate restTemplate, TransferService transferService) {
        this.restTemplate = restTemplate;
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity transfer(@RequestBody TransferMoney request) {
        System.out.println(request);

        Account sender = new Account();
        sender.setID(request.getSenderID());
//        ResponseEntity<Object> senderResponse = restTemplate.getForEntity("http://localhost:8080/account", Object.class);

        Account recipient = new Account();
        recipient.setID(request.getRecipientID());
//        ResponseEntity<Object> recipientResponse = restTemplate.getForEntity("http://localhost:8080/account", Object.class);

//        if (recipientResponse.getStatusCode().is2xxSuccessful() &&
//                senderResponse.getStatusCode().is2xxSuccessful()) {
//            sender.setBalance(String.valueOf(1500 - parseInt(request.getAmount())));
//            recipient.setBalance(String.valueOf(1500 + parseInt(request.getAmount())));
//            System.out.println("Success");
//        }
//        else {
//            System.out.println("Err: " + senderResponse.getStatusCode());
//        }

        sender.setBalance(String.valueOf(1500 - parseInt(request.getAmount())));
        recipient.setBalance(String.valueOf(1500 + parseInt(request.getAmount())));
        System.out.println(sender.getBalance());
        System.out.println(recipient.getBalance());

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<TransferMoneyResponse> add(@Valid @RequestBody TransferMoney request) {
        TransferMoneyResponse response = transferService.add(request);

        return ResponseEntity.ok(response);
    }
}
