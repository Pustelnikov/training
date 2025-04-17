package dev.pustelnikov.dto.card.request;

import dev.pustelnikov.model.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardDeleteRequestDto {
    private Long cardId;
    private String cardNumber;
    private LocalDate cardExpirationDate;
    private CardStatus cardStatus;
    private Long accountId;
}
