package com.example.accountApplication.Service;

import com.example.accountApplication.Dto.AccountDto;
import com.example.accountApplication.Model.Account;
import com.example.accountApplication.Repository.AccountRepo;
import com.example.accountApplication.Response.AccountResponse;
import com.example.accountApplication.Utils.AccountUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.function.DoubleToLongFunction;

@Service
@RequiredArgsConstructor
public class AccountService {
    public final AccountRepo accountRepo;

    public final ModelMapper modelMapper;


    public AccountResponse addAccount (AccountDto request){
        Account account = new Account();
        account.setFullName(request.getFirstName() + " " + request.getLastName());
        account.setGender(request.getGender());
        account.setEmail(request.getEmail());
        account.setNationality(request.getNationality());
        account.setPhoneNo(request.getPhoneNo());
        account.setAccountType(request.getAccountType());
        account.setResidentialAddress(request.getResidentialAddress());
        account.setPin(request.getPin());
        account.setBalanceBefore(00.0);
        account.setBalanceAfter(00.0);
        account.setWithdrawAmount(00.0);
        account.setAccountNumber(AccountUtils.generateAccountNumber());
        account.setDateCreated(new Date());
        accountRepo.save(account);
        return modelMapper.map(account, AccountResponse.class);
    }


    public AccountResponse depositMoney(String phoneNo, Double amount){
        Optional<Account> optionalAccount = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccount.isEmpty()){
            throw new RuntimeException("Account Not Found");
        }else{
            Account account = optionalAccount.get();
            account.setBalanceAfter(account.getBalanceBefore() + amount);
            accountRepo.save(account);
            return modelMapper.map(account,AccountResponse.class);
        }
    }


    public AccountResponse reDepositMoney (String phoneNo, Double amount){
        Optional<Account> optionalAccount = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccount.isEmpty()){
            throw new RuntimeException("Account Not Found");
        }else{
            Account account = optionalAccount.get();
            account.setBalanceBefore(account.getBalanceAfter());
            account.setBalanceAfter(account.getBalanceBefore() + amount);
            accountRepo.save(account);
            return modelMapper.map(account,AccountResponse.class);
        }
    }


    public AccountResponse withdraw (String pin,  Double amount){
        Optional<Account> optionalAccount = accountRepo.findByPin(pin);
        if(optionalAccount.isEmpty()){
            throw new RuntimeException("Account Not Found");
        } else {
            Account account = optionalAccount.get();
            account.setWithdrawAmount(amount);
            account.setBalanceAfter(account.getBalanceAfter() - amount);
            accountRepo.save(account);
            return modelMapper.map(account, AccountResponse.class);
        }
    }


    public Double checkBalance (String phoneNo){
        Optional<Account> optionalAccount = accountRepo.findByPhoneNo(phoneNo);
        if(optionalAccount.isEmpty()){
            throw new RuntimeException("Account Not Found");
        }else{
            Account account = optionalAccount.get();
            Double balance = account.getBalanceAfter();
            return balance;
        }
    }



    public String deleteAccount(Long id){
        Optional<Account> optionalAccount = accountRepo.findById(id);
        if(optionalAccount.isEmpty()){
            throw new RuntimeException("Account not found");
        }else {
            Account account = optionalAccount.get();
            accountRepo.delete(account);
            return "Successfully deleted";
        }
    }
}
