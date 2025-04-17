package dev.pustelnikov.dto.card;

import dev.pustelnikov.model.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {
    private Long cardId;
    private String cardNumber;
    private LocalDate cardExpirationDate;
    private Integer cardCvv;
    private CardStatus cardStatus;
    private Long accountId;
}
