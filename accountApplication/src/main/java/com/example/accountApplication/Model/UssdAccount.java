package com.example.accountApplication.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table(name = "ussd_account")
@AllArgsConstructor
@NoArgsConstructor
public class UssdAccount {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "account_id")
    private Long accountId;

    @Basic
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Basic
    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Basic
    @Column(name = "account_number", nullable = false)
    private int accountNumber;

    @Basic
    @Column(name = "pin", nullable = false)
    private int pin;

    @Basic
    @Column(name = "balance_before", nullable = false)
    private Double balancBefore;

    @Basic
    @Column(name = "balance_after", nullable = false)
    private Double balanceAfter;

    @Basic
    @Column(name = "withdraw_amount", nullable = false)
    private Double withdrawAmount;

    @Basic
    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

}
