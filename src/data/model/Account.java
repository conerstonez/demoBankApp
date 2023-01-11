package data.model;

import dto.request.AccountCreationRequest;

import java.math.BigDecimal;
import java.security.SecureRandom;

public class Account {
    private AccountType accountType;
    private final String accountNumber;
    private BigDecimal balance;

    public Account(AccountCreationRequest accountCreationRequest){
        this.accountType = accountCreationRequest.getAccountType();
        this.balance = accountCreationRequest.getBalance();
        this.accountNumber = setAccountNumber();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    private static String setAccountNumber() {
        SecureRandom randomNumber = new SecureRandom();
        return "01" + String.valueOf(randomNumber.nextInt(11111111, 99999999));
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
