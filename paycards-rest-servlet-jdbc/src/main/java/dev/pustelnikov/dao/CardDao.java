package dev.pustelnikov.dao;

import dev.pustelnikov.dto.card.dao.CardCreateDto;
import dev.pustelnikov.dto.card.dao.CardDeleteDto;
import dev.pustelnikov.dto.card.dao.CardGetDto;
import dev.pustelnikov.dto.card.dao.CardUpdateDto;
import dev.pustelnikov.model.entity.CardEntity;

public interface CardDao {
    CardEntity findCard(CardGetDto cardGetDto);
    void createCard(CardCreateDto cardCreateDto);
    void updateCard(CardUpdateDto cardUpdateDto);
    void deleteCard(CardDeleteDto cardDeleteDto);
}
