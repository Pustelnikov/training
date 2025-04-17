package dev.pustelnikov.dto.card.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDeleteRequestDto {
    private String cardId;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardStatus;
    private String accountId;
}
