package dev.pustelnikov.dto.card.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardCreateRequestDto {
    private Long accountId;
}
