package data.repository;

import data.model.Account;
import data.model.Customer;
import dto.request.FindCustomerByNameRequest;

import java.util.HashMap;
import java.util.Objects;

public class CustomerRepositoryImpl implements CustomerRepository{
//    private List<Customer> customerDb = new ArrayList<>();
    private  HashMap<Account, Customer> customerDb = new HashMap<>();
    @Override
    public void save(Customer customer) {
        customerDb.put(customer.getAccount(), customer);
    }

    @Override
    public void delete(Customer customer) {
        customerDb.remove(customer.getAccount());
    }

    @Override
    public Customer findCustomerByAccountNumber(String accountNumber) {
        for (Account account : customerDb.keySet()) {
            if (Objects.equals(accountNumber, account.getAccountNumber())) return customerDb.get(account);
        }
        return null;
    }

    @Override
    public Customer findCustomerByName(FindCustomerByNameRequest findCustomerByNameRequest) {
        for (Customer customer : customerDb.values()) {
            if (Objects.equals(findCustomerByNameRequest.getFirstName(), customer.getFirstName()) &&
                    Objects.equals(findCustomerByNameRequest.getLastName(), customer.getLastName()) &&
                    Objects.equals(findCustomerByNameRequest.getSurname(), customer.getSurname())) return customer;
        }
        return null;
    }

//    @Override
//    public void editCustomerDetails(String customerAccountNumber) {
//        Customer updatedCustomer = findCustomerByAccountNumber(customerAccountNumber);
//       customerDb
//    }

    @Override
    public long count() {
        return customerDb.size();
    }
}
