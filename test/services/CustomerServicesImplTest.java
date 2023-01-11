package services;

import data.model.Account;
import data.model.AccountType;
import data.model.Customer;
import dto.request.AccountCreationRequest;
import dto.request.CustomerCreationRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static data.model.AccountType.DOMICILIARY;
import static data.model.AccountType.SAVINGS;
import static org.junit.jupiter.api.Assertions.*;

class CustomerServicesImplTest {
    private CustomerServices cs;
    private AccountServices as;
    @BeforeEach void setUp() {
        cs = new CustomerServicesImpl();
        as = new AccountServicesImpl();
    }

    @Test void creationOfCustomer_createsAnAccount_savesCustomerAndAccountToDb() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();

        customerCreationRequest.setFirstName("Laide");
        customerCreationRequest.setPhoneNumber(")9725r");
        customerCreationRequest.setEmail("kkj#@");

        accountCreationRequest.setBalance(new BigDecimal(98989));
        accountCreationRequest.setAccountType(SAVINGS);

        Customer customer = cs.createCustomer(customerCreationRequest, accountCreationRequest);

        assertNotNull(customer.getAccount());
        assertEquals(1, cs.count());
        assertEquals(1, as.viewAll().size());
    }

    @Test void deleteCustomerByCustomerObject_customerRepoIsZero_accountRepoAlsoZero() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();

        customerCreationRequest.setFirstName("Laide");
        customerCreationRequest.setPhoneNumber(")9725r");
        customerCreationRequest.setEmail("kkj#@");

        accountCreationRequest.setBalance(new BigDecimal(98989));
        accountCreationRequest.setAccountType(SAVINGS);

        Customer customer = cs.createCustomer(customerCreationRequest, accountCreationRequest);

        assertNotNull(customer.getAccount());
        assertEquals(1, cs.count());
        assertEquals(1, as.viewAll().size());

        cs.deleteCustomer(customer);
        assertEquals(0, cs.count());
        assertEquals(0, as.viewAll().size());
    }

    @Test void deleteCustomerByAccountNumber_customerRepoIsZero_accountRepoAlsoZero() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();

        customerCreationRequest.setFirstName("Laide");
        customerCreationRequest.setPhoneNumber(")9725r");
        customerCreationRequest.setEmail("kkj#@");

        accountCreationRequest.setBalance(new BigDecimal(98989));
        accountCreationRequest.setAccountType(SAVINGS);

        Customer customer = cs.createCustomer(customerCreationRequest, accountCreationRequest);

        assertNotNull(customer.getAccount());
        assertEquals(1, cs.count());
        assertEquals(1, as.viewAll().size());

        cs.deleteCustomer(customer.getAccount().getAccountNumber());
        assertEquals(0, cs.count());
        assertEquals(0, as.viewAll().size());
    }

    @Test void viewCustomerDetailsTest() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();

        customerCreationRequest.setFirstName("Laide");
        customerCreationRequest.setSurname("Yemi");
        customerCreationRequest.setPhoneNumber(")9725r");
        customerCreationRequest.setEmail("kkj#@");
        customerCreationRequest.setAddress("Ketu");

        accountCreationRequest.setBalance(new BigDecimal(98989));
        accountCreationRequest.setAccountType(SAVINGS);

        Customer customer = cs.createCustomer(customerCreationRequest, accountCreationRequest);
        assertEquals(customer, cs.viewCustomerDetails(customer.getAccount().getAccountNumber()));
    }

}