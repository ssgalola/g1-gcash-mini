package ph.apper.purchase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ph.apper.purchase.exception.TransferNotFoundException;
import ph.apper.purchase.payload.GetTransferResponse;
import ph.apper.purchase.payload.TransferData;
import ph.apper.purchase.payload.TransferMoney;
import ph.apper.purchase.payload.TransferMoneyResponse;
import ph.apper.purchase.util.IdService;
import ph.apper.purchase.domain.Transfer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class TransferService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ph.apper.purchase.service.TransferService.class);

    private final List<Transfer> transfers = new ArrayList<>();

    private final IdService idService;

    public TransferService(IdService idService) {
        this.idService = idService;
    }

    public TransferMoneyResponse add(TransferMoney request) {

        String transferID = idService.generateCode(6);
        LOGGER.info("Generated transfer ID: {}", transferID);

        Transfer transfer = new Transfer(transferID);
        transfer.setTransferID(transferID);
        transfer.setRecipientID(request.getRecipientID());
        transfer.setAmount(request.getAmount());
        transfers.add(transfer);

        LOGGER.info("Transfer: {}", transfer);

        return new TransferMoneyResponse(transferID);
    }

    public List<TransferData> getAllTransfers() {
        List<TransferData> transferDataList = new ArrayList<>();
        Stream<Transfer> transferStream = transfers.stream();

        transferStream.forEach(transfer -> transferDataList.add(toTransferData(transfer)));

        return transferDataList;
    }

    private Transfer getTransferById(String id) throws TransferNotFoundException {
        return transfers.stream()
                .filter(transfer -> id.equals(transfer.getTransferID()))
                .findFirst()
                .orElseThrow(() -> new TransferNotFoundException("Transfer " + id + " not found"));
    }

    public GetTransferResponse getTransfer(String id) throws TransferNotFoundException {
        Transfer transfer = getTransferById(id);

        GetTransferResponse response = new GetTransferResponse();
        response.setTransferID(transfer.getTransferID());
        response.setSenderID(transfer.getSenderID());
        response.setRecipientID(transfer.getRecipientID());
        response.setAmount(transfer.getAmount());

        return response;
    }

    private TransferData toTransferData (Transfer t) {
        TransferData transferData = new TransferData();
        transferData.setTransferID(t.getTransferID());
        transferData.setSenderID(t.getSenderID());
        transferData.setRecipientID(t.getRecipientID());
        transferData.setAmount(t.getAmount());

        return transferData;
    }
}