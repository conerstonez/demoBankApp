package dto.request;

import data.model.AccountType;

import java.math.BigDecimal;

public class AccountCreationRequest {
    private AccountType accountType;
    private BigDecimal balance;

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
}
