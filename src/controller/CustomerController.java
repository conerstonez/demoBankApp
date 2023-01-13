package controller;

import data.model.Customer;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;
import services.CustomerServices;
import services.CustomerServicesImpl;

public class CustomerController {
    private CustomerServices customerServices = new CustomerServicesImpl();

    public String customerSignUp(CustomerCreationRequest signUpRequest) {
        return null;
    }

    public String customerSignIn(SignInRequest signInRequest) {
        return null;
    }

    public Customer getCustomer(String accountNumber) {
        return customerServices.viewCustomerDetails(accountNumber);
    }
}
