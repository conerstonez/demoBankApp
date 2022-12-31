package data.repository;

import data.model.Account;
import data.model.AccountType;
import data.model.Customer;
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
        Customer customer = new Customer();
        customer.setFirstName("Peter");
        customer.setEmail("@go");
        customer.setAccount(new Account(SAVINGS, new BigDecimal(123344)));
        cr.save(customer);
        assertEquals(1L, cr.count());
    }

    @Test void deleteCustomer_dbCountShouldBeOne() {
        Customer customer = new Customer();
        customer.setFirstName("Peter");
        customer.setEmail("@go");
        customer.setAccount(new Account(DOMICILIARY, new BigDecimal(87879179)));
        cr.save(customer);

        cr.delete(customer);
        assertEquals(0, cr.count());
    }

    @Test void findCustomerByAccountNumber_shouldReturnCustomerDetails() {
        Customer customer = new Customer();
        customer.setFirstName("Peter");
        customer.setEmail("@go");
        Account account = new Account(SAVINGS, new BigDecimal(89223236));
        account.setAccountNumber("11221122");
        customer.setAccount(account);
        cr.save(customer);
        assertEquals(customer, cr.findCustomerByAccountNumber("11221122"));
    }

    @Test void updateCustomerDetails_countDoesNotIncrease() {
        Customer customer = new Customer();
        customer.setFirstName("Peter");
        customer.setEmail("@go");
        customer.setPhoneNumber("23032");
        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
        account.setAccountNumber("11221122");
        customer.setAccount(account);
        cr.save(customer);
        assertEquals(1L, cr.count());

        Customer dCustomer = new Customer();
        dCustomer.setFirstName("lekan");
        dCustomer.setSurname("Irony");
        Account dAccount = new Account(SAVINGS, new BigDecimal(1142524542646L));
        dAccount.setAccountNumber("87878787");
        dCustomer.setAccount(dAccount);
        cr.save(dCustomer);
        assertEquals(2L, cr.count());

        Customer customer1 = cr.findCustomerByAccountNumber("11221122");
        customer1.setLastName("Godwin");
        customer1.setPhoneNumber("454584");
        customer1.getAccount().setAccountType(DOMICILIARY);
        cr.save(customer1);
        assertEquals(2L, cr.count());
    }

    @Test void findCustomerByName_shouldReturnCustomerDetails() {
        Customer dCustomer = new Customer();
        dCustomer.setFirstName("Peter");
        dCustomer.setLastName("Lekan");
        dCustomer.setSurname("Irony");
        Account dAccount = new Account(SAVINGS, new BigDecimal(1142524542646L));
        dAccount.setAccountNumber("87878787");
        dCustomer.setAccount(dAccount);
        cr.save(dCustomer);
        assertEquals(1L, cr.count());

        Customer customer = new Customer();
        customer.setFirstName("Paul");
        customer.setLastName("Danny");
        customer.setSurname("Yaounde");
        customer.setEmail("@go");
        customer.setPhoneNumber("23032");
        Account account = new Account(SAVINGS, new BigDecimal(1142524542646L));
        account.setAccountNumber("11221122");
        customer.setAccount(account);
        cr.save(customer);
        assertEquals(2L, cr.count());

        FindCustomerByNameRequest findCustomerByNameRequest = new FindCustomerByNameRequest();
        findCustomerByNameRequest.setLastName("Danny");
        findCustomerByNameRequest.setSurname("Yaounde");
        findCustomerByNameRequest.setFirstName("Paul");
        assertEquals(customer, cr.findCustomerByName(findCustomerByNameRequest));
    }
}