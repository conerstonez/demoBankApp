package services;

import data.model.Customer;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;

public interface CustomerServices {
    void createCustomer(CustomerCreationRequest customerCreationrequest);
    void editCustomerDetails(CustomerCreationRequest customerCreationRequest);
    void deleteCustomer(String accountNumber);
    void deleteCustomer(Customer customer);
    Customer viewCustomerDetails(String accountNumber);
    void signIn(SignInRequest signInRequest);
}
