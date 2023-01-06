package services;

import data.model.Customer;
import dto.request.CustomerCreationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesImplTest {
    private CustomerServices cs;
    @BeforeEach void setUp() {
        cs = new CustomerServicesImpl();
    }

    @Test void createCustomer_saveCustomerToDbTest() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Henry");
        customerCreationRequest.setLastName("Paul");
        customerCreationRequest.setSurname("Gray");
        customerCreationRequest.setAddress("Ibadan");
        customerCreationRequest.setPhoneNumber("11221122");
        customerCreationRequest.setEmail("@fnm");
        customerCreationRequest.setDob(new Date(1994, 06, 2));
        Customer customer = cs.createCustomer(customerCreationRequest);
        assertEquals(1, cs.count());
        System.out.println(customer);
    }
}