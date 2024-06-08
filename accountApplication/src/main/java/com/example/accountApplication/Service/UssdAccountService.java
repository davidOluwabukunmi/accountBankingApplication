package com.example.accountApplication.Service;

import com.example.accountApplication.Dto.AccountDto;
import com.example.accountApplication.Dto.UssdAccountDto;
import com.example.accountApplication.Model.Account;
import com.example.accountApplication.Model.UssdAccount;
import com.example.accountApplication.Repository.UssdAccountRepo;
import com.example.accountApplication.Response.AccountResponse;
import com.example.accountApplication.Response.UssdAccountResponse;
import com.example.accountApplication.Utils.AccountUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UssdAccountService {
    private final UssdAccountRepo ussdAccountRepo;
    private final ModelMapper modelMapper;

    public UssdAccountResponse addAccount (UssdAccountDto request){
       UssdAccount ussdAccount = new UssdAccount();
       ussdAccount.setFullName(request.getFirstName() + " " + request.getLastName());
       ussdAccount.setPhoneNo(request.getPhoneNo());
       ussdAccount.setPin(request.getPin());
       ussdAccount.setBalancBefore(00.0);
       ussdAccount.setBalanceAfter(00.0);
       ussdAccount.setWithdrawAmount(00.0);
       ussdAccount.setAccountNumber(AccountUtils.generateAccountNumber());
       ussdAccount.setDateCreated(new Date());
       ussdAccountRepo.save(ussdAccount);
       return modelMapper.map(ussdAccount, UssdAccountResponse.class);
    }

}
