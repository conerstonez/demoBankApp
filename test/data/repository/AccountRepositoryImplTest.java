package data.repository;

import data.model.Account;
import data.model.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static data.model.AccountType.*;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    private AccountRepository ar;
    @BeforeEach void setUp() {
        ar = new AccountRepositoryImpl();
    }

    @Test void saveAccountToDb_countShouldIncrease() {
        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
        account.setAccountNumber("113323223");
        ar.save(account);
        assertEquals(1, ar.findAll().size());
    }

    @Test void deleteAccount_countIsZero() {
        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
        account.setAccountNumber("113323223");
        ar.save(account);
        assertEquals(1, ar.findAll().size());

        ar.delete(account);
        assertEquals(0, ar.findAll().size());
    }

    @Test void findAccountByAccountNumber_returnsAccountObject() {
        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
        account.setAccountNumber("113323223");
        account.setBalance(new BigDecimal(13335555));
        ar.save(account);

        Account account1 = new Account(FIXED_DEPOSIT, new BigDecimal(1142524542646L));
        account1.setAccountNumber("343434662");
        account1.setBalance(new BigDecimal(877585783));
        ar.save(account1);

        assertEquals(2, ar.findAll().size());
        assertEquals(account, ar.findAccount("113323223"));
    }

//    @Test void editAccountDetails_saveUpdatedAccount_countDoesNotIncrease() {
//        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
//        account.setAccountNumber("113323223");
//        ar.save(account);
//        assertEquals(1, ar.findAll().size());
//    }
}