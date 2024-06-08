package com.example.accountApplication.Response;

import lombok.Data;

import java.util.Date;

@Data
public class UssdAccountResponse {
    private String fullName;
    private String phoneNo;
    private int pin;
    private int accountNumber;
    private Double balanceBefore;
    private Double balanceAfter;
    private Double withdrawAmount;
    private Date dateCreated;
}
