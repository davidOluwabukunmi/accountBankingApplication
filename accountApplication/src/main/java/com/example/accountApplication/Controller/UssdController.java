package com.example.accountApplication.Controller;

import com.example.accountApplication.Dto.UssdAccountDto;
import com.example.accountApplication.Response.UssdAccountResponse;
import com.example.accountApplication.Service.UssdAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Ussd/")
@RequiredArgsConstructor
public class UssdController {
    public final UssdAccountService ussdAccountService;

    @PostMapping("addAccount")
    public UssdAccountResponse addAccount (@RequestBody UssdAccountDto request){
        return ussdAccountService.addAccount(request);
    }
}

