package services;

import dto.request.CustomerCreationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesImplTest {
    private CustomerServices cs;
    @BeforeEach void setUp() {
        cs = new CustomerServicesImpl();
    }

    @Test void createCustomer_saveCustomerToDbTest() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        cs.createCustomer(customerCreationRequest);
    }
}