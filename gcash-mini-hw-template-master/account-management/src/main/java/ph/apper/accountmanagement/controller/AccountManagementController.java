package ph.apper.accountmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ph.apper.accountmanagement.domain.Account;
import ph.apper.accountmanagement.payload.AuthenticateAccount;
import ph.apper.accountmanagement.payload.VerifyAccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("account")
public class AccountManagementController {

    private List<Account> accountList = new ArrayList<>();

    @PostMapping("/verify")
    public ResponseEntity<Object> verifyAccount(@RequestBody VerifyAccount request){
        for (Account account : accountList){
            if(account.getVerificationCode().equalsIgnoreCase(request.getVerificationCode())
                && account.getEmail().equalsIgnoreCase(request.getEmail())){
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid email or verification code.",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Object> authenticateAccount(@RequestBody AuthenticateAccount request){
        for (Account account: accountList){
            if(account.getEmail().equals(request.getEmail()) && account.getPassword().equals(request.getPassword())){
                HashMap<String, UUID> accountInfo = new HashMap<>();
                accountInfo.put("accountId", account.getAccountId());
                return new ResponseEntity<>(accountInfo,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}

