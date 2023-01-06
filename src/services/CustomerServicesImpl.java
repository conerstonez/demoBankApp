package services;

import data.model.Customer;
import data.repository.CustomerRepository;
import data.repository.CustomerRepositoryImpl;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;

public class CustomerServicesImpl implements CustomerServices {
    private CustomerRepository customerRepository = new CustomerRepositoryImpl();
    private AccountServices accountServices = new AccountServicesImpl();

    @Override
    public Customer createCustomer(CustomerCreationRequest customerCreationrequest) {
        Customer customer = new Customer(customerCreationrequest);
        customerRepository.save(customer);
        return customer;
    }

    @Override
    public void editCustomerDetails(CustomerCreationRequest customerCreationRequest) {

    }

    @Override
    public void deleteCustomer(String accountNumber) {

    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public Customer viewCustomerDetails(String accountNumber) {
        return null;
    }

    @Override
    public void signIn(SignInRequest signInRequest) {

    }

    @Override
    public long count() {
        return customerRepository.count();
    }


}
