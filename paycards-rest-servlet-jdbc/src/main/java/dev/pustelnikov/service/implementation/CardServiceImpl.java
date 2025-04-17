package dev.pustelnikov.service.implementation;

import dev.pustelnikov.dao.CardDao;
import dev.pustelnikov.dto.card.*;
import dev.pustelnikov.dto.card.dao.CardCreateDto;
import dev.pustelnikov.dto.card.dao.CardDeleteDto;
import dev.pustelnikov.dto.card.dao.CardGetDto;
import dev.pustelnikov.dto.card.dao.CardUpdateDto;
import dev.pustelnikov.dto.card.request.CardDeleteRequestDto;
import dev.pustelnikov.dto.card.request.CardGetRequestDto;
import dev.pustelnikov.dto.card.request.CardUpdateRequestDto;
import dev.pustelnikov.dto.card.request.CardCreateRequestDto;
import dev.pustelnikov.mapper.CardMapper;
import dev.pustelnikov.model.CardStatus;
import dev.pustelnikov.service.CardService;
import dev.pustelnikov.service.CardUtilService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDao cardDao;
    private final CardMapper cardMapper;
    private final CardUtilService cardUtilService;

    @Override
    public void createCard(CardCreateRequestDto cardCreateRequestDto) {
        CardCreateDto card = CardCreateDto.builder()
                .cardNumber(cardUtilService.generateCardNumber())
                .cardExpirationDate(cardUtilService.generateCardExpirationDate())
                .cardCvv(cardUtilService.generateCardCvv())
                .cardStatus(CardStatus.ACTIVE)
                .accountId(cardCreateRequestDto.getAccountId())
                .build();
        cardDao.createCard(card);
    }

    @Override
    public void deleteCard(CardDeleteRequestDto cardDeleteRequestDto) {
        CardDeleteDto cardDeleteDto = CardDeleteDto.builder()
                .cardId(cardDeleteRequestDto.getCardId())
                .cardNumber(cardDeleteRequestDto.getCardNumber())
                .cardExpirationDate(cardDeleteRequestDto.getCardExpirationDate())
                .cardStatus(cardDeleteRequestDto.getCardStatus())
                .accountId(cardDeleteRequestDto.getAccountId())
                .build();
        cardDao.deleteCard(cardDeleteDto);
    }

    @Override
    public CardDto getCard(CardGetRequestDto cardGetRequestDto) {
        CardGetDto cardGetDto = CardGetDto.builder()
                .cardId(cardGetRequestDto.getCardId())
                .cardNumber(cardGetRequestDto.getCardNumber())
                .cardExpirationDate(cardGetRequestDto.getCardExpirationDate())
                .cardCvv(cardGetRequestDto.getCardCvv())
                .cardStatus(cardGetRequestDto.getCardStatus())
                .accountId(cardGetRequestDto.getAccountId())
                .build();
        return cardMapper.mapToDto(cardDao.findCard(cardGetDto));
    }

    @Override
    public void updateCard(CardUpdateRequestDto cardUpdateRequestDto) {
        CardUpdateDto card = CardUpdateDto.builder()
                .cardId(cardUpdateRequestDto.getCardId())
                .cardExpirationDate(cardUpdateRequestDto.getCardExpirationDate())
                .cardStatus(cardUpdateRequestDto.getCardStatus())
                .build();
        cardDao.updateCard(card);
    }
}
