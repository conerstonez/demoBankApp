package controller;

import data.model.Account;
import dto.request.AccountCreationRequest;
import dto.request.TransferMoneyRequest;
import services.AccountServices;
import services.AccountServicesImpl;

import java.math.BigDecimal;

public class AccountController {
    private AccountServices accountServices = new AccountServicesImpl();

    public String createAccount(AccountCreationRequest accountCreationRequest){
        accountServices.createAccount(accountCreationRequest);
        return "Account Successfully Created";
    }

    public Account getAccount(String accountNumber){
        return accountServices.viewAccountDetails(accountNumber);
    }

    public String makeTransfer(TransferMoneyRequest transferMoneyRequest){
        return null;
    }
     public String makeWithdrawal(BigDecimal withdrawalAmount){
        return null;
     }

     public String makeDeposit(BigDecimal depositAmount){
        return null;
     }

}
