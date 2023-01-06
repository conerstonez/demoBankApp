package services;

import data.model.Account;
import data.repository.AccountRepository;
import data.repository.AccountRepositoryImpl;
import dto.request.AccountCreationRequest;
import dto.request.TransferMoneyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static data.model.AccountType.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountServicesImplTest {
    private AccountServices as;
    private AccountRepository ar;

    @BeforeEach void setUp() {
        as = new AccountServicesImpl();
        ar = new AccountRepositoryImpl();
    }

    @Test void accountCreationTest() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        as.createAccount(accountCreationRequest);
        assertEquals(1, as.viewAll().size());
    }

    @Test void accountCreationGeneratesAccountNumber() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);
        assertNotNull(account.getAccountNumber());
        assertEquals(1, as.viewAll().size());
    }

    @Test void accountDetailsCanBeViewed_displaysAccountInformation() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);
        assertEquals(1, as.viewAll().size());
        assertSame(account, as.viewAccountDetails(account.getAccountNumber()));
    }

    @Test void removeAccount_accountCountDecreasesByOne() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);
        assertEquals(1, as.viewAll().size());
        as.removeAccount(account);
        assertEquals(0, as.viewAll().size());
    }

    @Test void withdrawalDeductsAccountBalance() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);
        as.withdrawal(account, new BigDecimal(12_000));
        assertEquals(new BigDecimal(11_000), as.checkAccountBalance(account));
    }

    @Test void transferMoney_debitAccountBalanceReduces_creditAccountBalanceIncreases() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);

        AccountCreationRequest accountCreationRequest1 = new AccountCreationRequest();
        accountCreationRequest1.setAccountType(CURRENT);
        accountCreationRequest1.setBalance(new BigDecimal(45_000));
        Account account1 = as.createAccount(accountCreationRequest1);

        TransferMoneyRequest transferMoneyRequest = new TransferMoneyRequest();
        transferMoneyRequest.setTransferAmount(new BigDecimal(11_000));
        transferMoneyRequest.setCreditAccount(account);
        transferMoneyRequest.setDebitAccount(account1);

        as.transfer(transferMoneyRequest);
        assertEquals(new BigDecimal(34_000), as.checkAccountBalance(account1));
        assertEquals(new BigDecimal(34_000), as.checkAccountBalance(account));
    }

    @Test void depositIncreasesAccountBalance() {
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(23_000));
        Account account = as.createAccount(accountCreationRequest);
        as.deposit(account, new BigDecimal(2_000));
        assertEquals(new BigDecimal(25_000), as.checkAccountBalance(account));
    }
}