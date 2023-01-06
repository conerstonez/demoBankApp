package data.model;

import dto.request.AccountCreationRequest;

import java.math.BigDecimal;

public class Account {
    private AccountType accountType;
    private String accountNumber;
    private BigDecimal balance;

    public Account(AccountCreationRequest accountCreationRequest){
        this.accountType = accountCreationRequest.getAccountType();
        this.balance = accountCreationRequest.getBalance();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType=" + accountType +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
