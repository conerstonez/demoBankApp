package data.repository;

import data.model.Account;

import java.util.HashMap;
import java.util.List;

public interface AccountRepository {
    void save(Account account);
    void delete(Account account);
    Account findAccount(String accountNumber);
    HashMap<String, Account> findAll();
}
