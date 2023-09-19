package com.example.accountApplication.Response;

import lombok.Data;

import java.util.Date;

@Data
public class AccountResponse {
    private String fullName;

    private String gender;

    private String email;

    private String residentialAddress;

    private String phoneNo;

    private String nationality;

    private String accountType;

    private int accountNumber;

    private Double balanceBefore;

    private Double balanceAfter;

    private String pin;

    private Double withdrawAmount;

    private Date dateCreated;
}
