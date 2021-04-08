package ph.apper.purchase.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.apper.product.controller.ProductController;
import ph.apper.product.exception.ProductNotFoundException;
import ph.apper.product.payload.AddProduct;
import ph.apper.product.payload.AddProductResponse;
import ph.apper.product.payload.GetProductResponse;
import ph.apper.product.payload.ProductData;
import ph.apper.product.service.ProductService;
import ph.apper.purchase.exception.TransferNotFoundException;
import ph.apper.purchase.payload.GetTransferResponse;
import ph.apper.purchase.payload.TransferData;
import ph.apper.purchase.payload.TransferMoney;
import ph.apper.purchase.payload.TransferMoneyResponse;
import ph.apper.purchase.service.TransferService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("transfer")
public class TransferController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferController.class);

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping
    public ResponseEntity<List<TransferData>> getAll() {
        return ResponseEntity.ok(transferService.getAllTransfers());
    }

    @GetMapping("{transferID}")
    public ResponseEntity<GetTransferResponse> getTransfer(@PathVariable("transferID") String transferID) throws TransferNotFoundException, TransferNotFoundException {
        GetTransferResponse response = transferService.getTransfer(transferID);

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<TransferMoneyResponse> add(@Valid @RequestBody TransferMoney request) {
        TransferMoneyResponse response = transferService.add(request);

        return ResponseEntity.ok(response);
    }
}
