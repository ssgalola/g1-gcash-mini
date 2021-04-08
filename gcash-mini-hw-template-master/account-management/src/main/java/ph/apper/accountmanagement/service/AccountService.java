package ph.apper.accountmanagement.service;

import org.springframework.stereotype.Service;
import ph.apper.accountmanagement.payload.AccountRequest;
import ph.apper.accountmanagement.util.IdService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final List<AccountRequest> accountList = new ArrayList<>();


}
