package com.example.accountApplication.Dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
public class UssdAccountDto {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private int pin;

}
