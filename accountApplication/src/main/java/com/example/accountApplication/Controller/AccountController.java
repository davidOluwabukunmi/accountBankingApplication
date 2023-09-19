package com.example.accountApplication.Controller;

import com.example.accountApplication.Dto.AccountDto;
import com.example.accountApplication.Response.AccountResponse;
import com.example.accountApplication.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account/")
@RequiredArgsConstructor
public class AccountController {
    public final AccountService accountService;

    @PostMapping("addUser")
    public AccountResponse addAccount(@RequestBody AccountDto request){
        return accountService.addAccount(request);
    }

    @PostMapping("deposit")
    public AccountResponse depositCash(@RequestParam("phoneNo") String phoneNo, @RequestParam("amount") Double amount){
        return accountService.depositMoney(phoneNo, amount);
    }

    @PostMapping("reDeposit")
    public AccountResponse reDepositMoney(@RequestParam("phoneNo") String phoneNo, @RequestParam("amount") Double amount){
        return accountService.reDepositMoney(phoneNo, amount);
    }

    @PostMapping("withdraw")
    public AccountResponse withdraw (@RequestParam("pin") String pin , @RequestParam("amount") Double amount){
        return accountService.withdraw(pin, amount);
    }

    @GetMapping("balance")
    public Double checkBalance (@RequestParam("phoneNo") String phoneNo){
       return    accountService.checkBalance(phoneNo);
    }


    @DeleteMapping("deleteAccount")
    public String deleteAccount(@RequestParam("id") Long id){
        return accountService.deleteAccount(id);
    }
}
