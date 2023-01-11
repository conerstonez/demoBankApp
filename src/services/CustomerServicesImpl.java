package services;

import data.model.Account;
import data.model.Customer;
import data.repository.CustomerRepository;
import data.repository.CustomerRepositoryImpl;
import dto.request.AccountCreationRequest;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;

public class CustomerServicesImpl implements CustomerServices {
    private static CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private AccountServices accountServices = new AccountServicesImpl();

    @Override
    public Customer createCustomer(CustomerCreationRequest customerCreationrequest, AccountCreationRequest accountCreationRequest) {
        Account account = accountServices.createAccount(accountCreationRequest);
        customerCreationrequest.setAccount(account);
        Customer customer = new Customer(customerCreationrequest);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void editCustomerDetails(CustomerCreationRequest customerCreationRequest) {

    }

    @Override
    public void deleteCustomer(String accountNumber) {
        Customer customer = customerRepository.findCustomerByAccountNumber(accountNumber);
        accountServices.removeAccount(accountNumber);
        customerRepository.delete(customer);

    }

    @Override
    public void deleteCustomer(Customer customer) {
        accountServices.removeAccount(customer.getAccount());
        customerRepository.delete(customer);
    }

    @Override
    public Customer viewCustomerDetails(String accountNumber) {
        return customerRepository.findCustomerByAccountNumber(accountNumber);
    }

    @Override
    public void signIn(SignInRequest signInRequest) {
    }

    @Override
    public long count() {
        return customerRepository.count();
    }
}
