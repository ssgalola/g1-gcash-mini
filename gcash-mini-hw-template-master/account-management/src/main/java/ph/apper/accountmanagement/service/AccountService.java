package ph.apper.accountmanagement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ph.apper.accountmanagement.domain.Account;
import ph.apper.accountmanagement.payload.AccountRequest;
import ph.apper.accountmanagement.payload.GetAccountResponse;
import ph.apper.accountmanagement.payload.NewAccountResponse;
import ph.apper.accountmanagement.util.IdService;
import ph.apper.accountmanagement.util.VerificationService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AccountService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    private final List<Account> accounts = new ArrayList<>();
    private final IdService idService;
    private final VerificationService verificationService;

    public AccountService(IdService idService, VerificationService verificationService){
        this.idService = idService;
        this.verificationService = verificationService;
    }

    public NewAccountResponse addAccount(AccountRequest request){
        UUID accountId = idService.getNextUserId();
        LOGGER.info("New account ID: " + accountId);

        Account account = new Account(accountId);
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setPassword(request.getPassword());
        account.setBalance(new BigDecimal("25000.00"));
        account.setVerified(false);

        String verificationCode = idService.generateCode(6);
        verificationService.addVerificationCode(request.getEmail(), verificationCode);
        accounts.add(account);
        return new NewAccountResponse(verificationCode);

    }

    public void verify(String email){
        verificationService.verifyAccount(email);
        getAccount(email).setVerified(true);
    }

    public Account getAccount(String email){
        return accounts.stream().filter(account -> email.equals(account.getEmail())).findFirst().get();
    }

    public GetAccountResponse getAccountDetails(String accountId){
        return new GetAccountResponse(
                accounts.stream().filter(
                        account -> accountId.equals(account.getAccountId().toString())
                ).findFirst().get()
        );
    }


}
