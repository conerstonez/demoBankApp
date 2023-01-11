package services;

import data.model.Customer;
import dto.request.AccountCreationRequest;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;

public interface CustomerServices {
    Customer createCustomer(CustomerCreationRequest customerCreationrequest, AccountCreationRequest accountCreationRequest);
    void editCustomerDetails(CustomerCreationRequest customerCreationRequest);
    void deleteCustomer(String accountNumber);
    void deleteCustomer(Customer customer);
    Customer viewCustomerDetails(String accountNumber);
    void signIn(SignInRequest signInRequest);
    long count();
}
