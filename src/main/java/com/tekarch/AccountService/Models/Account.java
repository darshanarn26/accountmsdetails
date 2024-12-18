package com.tekarch.AccountService.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
public class Account
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private Long userId;
    private String accountNumber;
    private String accountType;
    private Long balance;
    private String currency;
    private LocalDateTime createdAt = LocalDateTime.now();
}
