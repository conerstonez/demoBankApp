package data.repository;

import data.model.Account;

import java.util.HashMap;
import java.util.Objects;

public class AccountRepositoryImpl implements AccountRepository{
//    private List<Account> accountDb = new ArrayList<>();
    private HashMap<String, Account> accountDb = new HashMap<>();
    @Override
    public void save(Account account) {
//        boolean check = accountDb.containsKey(account.getAccountNumber());
//        if (check) updateAccount(account);
        accountDb.put(account.getAccountNumber(), account);
    }

    private void updateAccount(Account account) {
//        accountDb.replace(account.getAccountNumber(), account);
    }

    @Override
    public void delete(Account account) {
        accountDb.remove(account.getAccountNumber());
    }

    @Override
    public Account findAccount(String accountNumber) {
        for (String number : accountDb.keySet()) {
            if (Objects.equals(accountNumber, number)) return accountDb.get(number);
        }
        return null;
    }

    @Override
    public HashMap<String, Account> findAll() {
        return accountDb;
    }
}
