package dev.pustelnikov.dto.card.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardGetRequestDto {
    private String cardId;
    private String cardNumber;
    private String cardExpirationDate;
    private String cardCvv;
    private String cardStatus;
    private String accountId;
}
