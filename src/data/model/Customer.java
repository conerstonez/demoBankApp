package data.model;

import dto.request.CustomerCreationRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Customer {

    private String firstName;
    private String lastName;
    private String surname;
    private String email;
    private String address;
    private String phoneNumber;
    private Date dob;
    private Account account;

    public Customer(CustomerCreationRequest customerCreationRequest) {
        this.firstName = customerCreationRequest.getFirstName();
        this.lastName = customerCreationRequest.getLastName();
        this.surname = customerCreationRequest.getSurname();
        this.email = customerCreationRequest.getEmail();
        this.address = customerCreationRequest.getAddress();
        this.phoneNumber = customerCreationRequest.getPhoneNumber();
        this.dob = customerCreationRequest.getDob();
        this.account = customerCreationRequest.getAccount();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dob=" + dob +
                ", account=" + account +
                '}';
    }
}
