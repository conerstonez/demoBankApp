package services;


import data.model.Account;
import data.repository.AccountRepository;
import data.repository.AccountRepositoryImpl;
import dto.request.AccountCreationRequest;
import dto.request.TransferMoneyRequest;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.HashMap;

public class AccountServicesImpl implements AccountServices {
    private static AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public Account createAccount(AccountCreationRequest accountCreationRequest) {
        Account account = new Account(accountCreationRequest);
        accountRepository.save(account);
        return account;
    }

    @Override
    public void accountUpgrade() {
    }

    @Override
    public Account viewAccountDetails(String accountNumber) {
        return accountRepository.findAccount(accountNumber);

    }

    @Override
    public void withdrawal(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().subtract(amount));
    }

    @Override
    public void transfer(TransferMoneyRequest transferMoneyRequest) {
        BigDecimal transferAmount = transferMoneyRequest.getTransferAmount();
        Account creditAccount = transferMoneyRequest.getCreditAccount();
        Account debitAccount = transferMoneyRequest.getDebitAccount();
        deposit(creditAccount, transferAmount);
        withdrawal(debitAccount, transferAmount);
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
    }

    @Override
    public void removeAccount(Account account) {
        accountRepository.delete(account);
    }

    @Override
    public void removeAccount(String accountNumber) {
        Account account = accountRepository.findAccount(accountNumber);
        accountRepository.delete(account);
    }

    @Override
    public HashMap<String, Account> viewAll() {
        return accountRepository.findAll();
    }

    @Override
    public BigDecimal checkAccountBalance(Account account) {
        return accountRepository.findAccount(account.getAccountNumber()).getBalance();
    }
}
