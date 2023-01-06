package services;

import data.model.Account;
import dto.request.AccountCreationRequest;
import dto.request.TransferMoneyRequest;

import java.math.BigDecimal;
import java.util.HashMap;

public interface AccountServices {
    Account createAccount(AccountCreationRequest accountCreationRequest);
    void accountUpgrade();
    Account viewAccountDetails(String accountNumber);
    void withdrawal(Account account, BigDecimal amount);
    void deposit(Account account, BigDecimal amount);
    void transfer(TransferMoneyRequest transferMoneyRequest);
    void removeAccount(Account account);
    void removeAccount(String accountNumber);
    HashMap<String, Account> viewAll();
    BigDecimal checkAccountBalance(Account account);
}

