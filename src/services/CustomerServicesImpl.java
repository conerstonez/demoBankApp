package services;

import data.model.Customer;
import dto.request.CustomerCreationRequest;
import dto.request.SignInRequest;

public class CustomerServicesImpl implements CustomerServices {

    @Override
    public void createCustomer(CustomerCreationRequest customerCreationrequest) {

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
}
