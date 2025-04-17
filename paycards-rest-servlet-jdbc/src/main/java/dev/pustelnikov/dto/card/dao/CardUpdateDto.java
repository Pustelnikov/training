package dev.pustelnikov.dto.card.dao;

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
public class CardUpdateDto {
    private Long cardId;
    private LocalDate cardExpirationDate;
    private CardStatus cardStatus;
}
