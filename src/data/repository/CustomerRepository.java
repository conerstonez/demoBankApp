package data.repository;

import data.model.Account;
import data.model.Customer;
import dto.request.FindCustomerByNameRequest;

public interface CustomerRepository {
    void save (Customer customer);
    void delete (Customer customer);
    Customer findCustomerByAccountNumber(String accountNumber);
    Customer findCustomerByName(FindCustomerByNameRequest findCustomerByNameRequest);
//    void editCustomerDetails(String customerAccountNumber);
    long count();
}
