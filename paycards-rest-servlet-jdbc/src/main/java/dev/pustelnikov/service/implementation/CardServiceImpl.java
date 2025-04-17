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
import java.time.LocalDate;

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
        Long cardId;
        String cardNumber;
        LocalDate cardExpirationDate;
        CardStatus cardStatus;
        Long accountId;

        String id = cardDeleteRequestDto.getCardId();
        if (id == null || id.isBlank()) {
            cardId = null;
        } else {
            cardId = Long.valueOf(id);
        }

        String number = cardDeleteRequestDto.getCardNumber();
        if (number == null || number.isBlank()) {
            cardNumber = null;
        } else {
            cardNumber = number;
        }

        String expirationDate = cardDeleteRequestDto.getCardExpirationDate();
        if (expirationDate == null || expirationDate.isBlank()) {
            cardExpirationDate = null;
        } else {
            cardExpirationDate = LocalDate.parse(expirationDate);
        }

        String status = cardDeleteRequestDto.getCardStatus();
        if (status == null || status.isBlank()) {
            cardStatus = null;
        } else {
            cardStatus = CardStatus.valueOf(status);
        }

        String accId = cardDeleteRequestDto.getAccountId();
        if (accId == null || accId.isBlank()) {
            accountId = null;
        } else {
            accountId = Long.valueOf(accId);
        }

        CardDeleteDto cardDeleteDto = CardDeleteDto.builder()
                .cardId(cardId)
                .cardNumber(cardNumber)
                .cardExpirationDate(cardExpirationDate)
                .cardStatus(cardStatus)
                .accountId(accountId)
                .build();
        cardDao.deleteCard(cardDeleteDto);
    }

    @Override
    public CardDto getCard(CardGetRequestDto cardGetRequestDto) {
        Long cardId;
        String cardNumber;
        LocalDate cardExpirationDate;
        Integer cardCvv;
        CardStatus cardStatus;
        Long accountId;

        String id = cardGetRequestDto.getCardId();
        if (id == null || id.isBlank()) {
            cardId = null;
        } else {
            cardId = Long.valueOf(id);
        }

        String number = cardGetRequestDto.getCardNumber();
        if (number == null || number.isBlank()) {
            cardNumber = null;
        } else {
            cardNumber = number;
        }

        String expirationDate = cardGetRequestDto.getCardExpirationDate();
        if (expirationDate == null || expirationDate.isBlank()) {
            cardExpirationDate = null;
        } else {
            cardExpirationDate = LocalDate.parse(expirationDate);
        }

        String cvv = cardGetRequestDto.getCardCvv();
        if (cvv == null || cvv.isBlank()) {
            cardCvv = null;
        } else {
            cardCvv = Integer.valueOf(cvv);
        }

        String status = cardGetRequestDto.getCardStatus();
        if (status == null || status.isBlank()) {
            cardStatus = null;
        } else {
            cardStatus = CardStatus.valueOf(status);
        }

        String accId = cardGetRequestDto.getCardId();
        if (accId == null || accId.isBlank()) {
            accountId = null;
        } else {
            accountId = Long.valueOf(accId);
        }

        CardGetDto cardGetDto = CardGetDto.builder()
                .cardId(cardId)
                .cardNumber(cardNumber)
                .cardExpirationDate(cardExpirationDate)
                .cardCvv(cardCvv)
                .cardStatus(cardStatus)
                .accountId(accountId)
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
