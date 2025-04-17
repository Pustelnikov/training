package dev.pustelnikov.dto.card.request;

import dev.pustelnikov.model.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardUpdateRequestDto {
    private Long cardId;
    private LocalDate cardExpirationDate;
    private CardStatus cardStatus;
}
