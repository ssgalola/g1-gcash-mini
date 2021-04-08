package ph.apper.accountmanagement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ph.apper.accountmanagement.domain.Account;
import ph.apper.accountmanagement.payload.AccountRequest;
import ph.apper.accountmanagement.payload.AuthenticateAccount;
import ph.apper.accountmanagement.payload.NewAccountResponse;
import ph.apper.accountmanagement.payload.VerifyAccount;
import ph.apper.accountmanagement.service.AccountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("account")
public class AccountManagementController {
    private static  final Logger LOGGER = LoggerFactory.getLogger(AccountManagementController.class);
    private final AccountService accountService;

    public AccountManagementController(AccountService accountService){
        this.accountService = accountService;
    }
    private List<Account> accountList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Object> createAccount(@RequestBody AccountRequest request){
        LOGGER.info("Create account request received.");
        NewAccountResponse response = accountService.addAccount(request);
        LOGGER.info("Account Created");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("{accountId}")
    public ResponseEntity<Object> getAccount(@PathVariable("accountId") String accountId){
        return new ResponseEntity<>(accountService.getAccountDetails(accountId), HttpStatus.OK);
    }

    @PostMapping("/verify")
    public ResponseEntity<Object> verifyAccount(@RequestBody VerifyAccount request){
        for (Account account : accountList){
            if(account.getVerificationCode().equalsIgnoreCase(request.getVerificationCode())
                && account.getEmail().equalsIgnoreCase(request.getEmail())){
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid email or verification code.", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticateAccount(@RequestBody AuthenticateAccount request){
        for (Account account: accountList){
            if(account.getEmail().equals(request.getEmail()) && account.getPassword().equals(request.getPassword())){
                HashMap<String, UUID> accountInfo = new HashMap<>();
                accountInfo.put("accountId", account.getAccountId());
                return new ResponseEntity<>(accountInfo, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid email or password.", HttpStatus.FORBIDDEN);
    }
}

