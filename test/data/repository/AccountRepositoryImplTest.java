package data.repository;

import data.model.Account;
import data.model.AccountType;
import dto.request.AccountCreationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static data.model.AccountType.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    private AccountRepository ar;
    private AccountCreationRequest accountCreationRequest;
    @BeforeEach void setUp() {
        ar = new AccountRepositoryImpl();
        accountCreationRequest = new AccountCreationRequest();
    }

    @Test void saveAccountToDb_countShouldIncrease() {
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
//        account.setAccountNumber("113323223");
        ar.save(account);
        assertEquals(1, ar.findAll().size());
    }

    @Test void deleteAccount_countIsZero() {
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
//        account.setAccountNumber("113323223");
        ar.save(account);
        assertEquals(1, ar.findAll().size());

        ar.delete(account);
        assertEquals(0, ar.findAll().size());
    }

    @Test void findAccountByAccountNumber_returnsAccountObject() {
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        ar.save(account);

        AccountCreationRequest accountCreationRequest1 = new AccountCreationRequest();
        accountCreationRequest1.setAccountType(FIXED_DEPOSIT);
        accountCreationRequest1.setBalance(new BigDecimal(1142524542646L));
        Account account1 = new Account(accountCreationRequest1);
        ar.save(account1);

        assertEquals(2, ar.findAll().size());
        assertEquals(account1, ar.findAccount(account1.getAccountNumber()));
    }

//    @Test void editAccountDetails_saveUpdatedAccount_countDoesNotIncrease() {
//        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
//        account.setAccountNumber("113323223");
//        ar.save(account);
//        assertEquals(1, ar.findAll().size());
//    }
}