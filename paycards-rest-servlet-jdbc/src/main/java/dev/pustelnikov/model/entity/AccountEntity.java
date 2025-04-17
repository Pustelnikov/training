package dev.pustelnikov.model.entity;

import dev.pustelnikov.model.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    private Long accountId;
    private String accountNumber;
    private BigDecimal accountBalance;
    private AccountStatus accountStatus;
    private List<CardEntity> accountCards;
}
