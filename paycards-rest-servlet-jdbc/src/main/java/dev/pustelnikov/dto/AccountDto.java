package dev.pustelnikov.dto;

import dev.pustelnikov.model.AccountStatus;
import dev.pustelnikov.model.entity.CardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountId;
    private String accountNumber;
    private BigDecimal accountBalance;
    private AccountStatus accountStatus;
    private List<CardEntity> accountCards;
}
