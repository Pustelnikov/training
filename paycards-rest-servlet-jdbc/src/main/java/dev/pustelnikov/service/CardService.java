package dev.pustelnikov.service;

import dev.pustelnikov.dto.card.*;
import dev.pustelnikov.dto.card.request.CardDeleteRequestDto;
import dev.pustelnikov.dto.card.request.CardGetRequestDto;
import dev.pustelnikov.dto.card.request.CardUpdateRequestDto;
import dev.pustelnikov.dto.card.request.CardCreateRequestDto;

public interface CardService {
    void createCard(CardCreateRequestDto cardCreateRequestDto);
    void deleteCard(CardDeleteRequestDto cardDeleteRequestDto);
    CardDto getCard(CardGetRequestDto cardGetRequestDto);
    void updateCard(CardUpdateRequestDto cardUpdateRequestDto);
}
