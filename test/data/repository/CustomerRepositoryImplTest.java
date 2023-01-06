package data.repository;

import data.model.Account;
import data.model.AccountType;
import data.model.Customer;
import dto.request.AccountCreationRequest;
import dto.request.CustomerCreationRequest;
import dto.request.FindCustomerByNameRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static data.model.AccountType.DOMICILIARY;
import static data.model.AccountType.SAVINGS;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {

    private CustomerRepository cr;

    @BeforeEach void setUp() {
        cr = new CustomerRepositoryImpl();
    }

    @Test void saveNewCustomer_DbCountShouldBeOne() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Peter");
        customerCreationRequest.setEmail("@go");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        customerCreationRequest.setAccount(account);
        Customer customer = new Customer(customerCreationRequest);
        cr.save(customer);
        assertEquals(1L, cr.count());
    }

    @Test void deleteCustomer_dbCountShouldBeOne() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Peter");
        customerCreationRequest.setEmail("@go");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        customerCreationRequest.setAccount(account);
        Customer customer = new Customer(customerCreationRequest);
        cr.save(customer);

        cr.delete(customer);
        assertEquals(0, cr.count());
    }

    @Test void findCustomerByAccountNumber_shouldReturnCustomerDetails() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Peter");
        customerCreationRequest.setEmail("@go");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        account.setAccountNumber("3534352681");
        customerCreationRequest.setAccount(account);
        Customer customer = new Customer(customerCreationRequest);
        cr.save(customer);
        System.out.println(customer);
        assertEquals(customer, cr.findCustomerByAccountNumber(account.getAccountNumber()));
    }

    @Test void updateCustomerDetails_countDoesNotIncrease() {
        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Peter");
        customerCreationRequest.setEmail("@go");
        customerCreationRequest.setPhoneNumber("23032");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        account.setAccountNumber("5756337489");
        customerCreationRequest.setAccount(account);
        Customer customer = new Customer(customerCreationRequest);
        cr.save(customer);
        assertEquals(1L, cr.count());

        CustomerCreationRequest dCustomerCreationRequest = new CustomerCreationRequest();
        dCustomerCreationRequest.setFirstName("lekan");
        dCustomerCreationRequest.setSurname("Irony");
        AccountCreationRequest accountCreationRequest1 = new AccountCreationRequest();
        accountCreationRequest1.setAccountType(SAVINGS);
        accountCreationRequest1.setBalance(new BigDecimal(1142524542646L));
        Account account1 = new Account(accountCreationRequest1);
        account1.setAccountNumber("11221425");
        dCustomerCreationRequest.setAccount(account1);
        Customer dCustomer = new Customer(dCustomerCreationRequest);
        cr.save(dCustomer);
        assertEquals(2L, cr.count());

        Customer customer1 = cr.findCustomerByAccountNumber(dCustomer.getAccount().getAccountNumber());
        customer1.setLastName("Godwin");
        customer1.setPhoneNumber("454584");
        customer1.getAccount().setAccountType(DOMICILIARY);
        cr.save(customer1);
        assertEquals(2L, cr.count());
    }

    @Test void findCustomerByName_shouldReturnCustomerDetails() {
        CustomerCreationRequest dCustomerCreationRequest = new CustomerCreationRequest();
        dCustomerCreationRequest.setFirstName("Peter");
        dCustomerCreationRequest.setLastName("Lekan");
        dCustomerCreationRequest.setSurname("Irony");
        AccountCreationRequest accountCreationRequest = new AccountCreationRequest();
        accountCreationRequest.setAccountType(SAVINGS);
        accountCreationRequest.setBalance(new BigDecimal(1142524542646L));
        Account account = new Account(accountCreationRequest);
        account.setAccountNumber("6457287578");
        dCustomerCreationRequest.setAccount(account);
        Customer dCustomer = new Customer(dCustomerCreationRequest);
        cr.save(dCustomer);
        assertEquals(1L, cr.count());

        CustomerCreationRequest customerCreationRequest = new CustomerCreationRequest();
        customerCreationRequest.setFirstName("Paul");
        customerCreationRequest.setLastName("Danny");
        customerCreationRequest.setSurname("Yaounde");
        customerCreationRequest.setEmail("@go");
        customerCreationRequest.setPhoneNumber("23032");
        AccountCreationRequest accountCreationRequest1 = new AccountCreationRequest();
        accountCreationRequest1.setAccountType(SAVINGS);
        accountCreationRequest1.setBalance(new BigDecimal(1142524542646L));
        Account account1 = new Account(accountCreationRequest1);
        account1.setAccountNumber("5729382839");
        customerCreationRequest.setAccount(account1);
        Customer customer = new Customer(customerCreationRequest);
        cr.save(customer);
        assertEquals(2L, cr.count());

        FindCustomerByNameRequest findCustomerByNameRequest = new FindCustomerByNameRequest();
        findCustomerByNameRequest.setLastName("Danny");
        findCustomerByNameRequest.setSurname("Yaounde");
        findCustomerByNameRequest.setFirstName("Paul");
        assertEquals(customer, cr.findCustomerByName(findCustomerByNameRequest));
    }
}