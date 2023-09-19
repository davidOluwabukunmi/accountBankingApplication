package com.example.accountApplication.Utils;

import java.util.Random;

public class AccountUtils {
    public static int generateAccountNumber(){
        Random random = new Random();
        int accountNumber = random.nextInt(900000000)+1000000000;
        return accountNumber;
    }
}
