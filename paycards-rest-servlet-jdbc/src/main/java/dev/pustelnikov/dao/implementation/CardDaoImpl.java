package dev.pustelnikov.dao.implementation;

import dev.pustelnikov.dao.CardDao;
import dev.pustelnikov.dto.card.dao.CardCreateDto;
import dev.pustelnikov.dto.card.dao.CardDeleteDto;
import dev.pustelnikov.dto.card.dao.CardGetDto;
import dev.pustelnikov.dto.card.dao.CardUpdateDto;
import dev.pustelnikov.model.CardStatus;
import dev.pustelnikov.model.entity.CardEntity;
import lombok.RequiredArgsConstructor;
import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;

@RequiredArgsConstructor
public class CardDaoImpl implements CardDao {
    private final DataSource dataSource;

    @Override
    public CardEntity findCard(CardGetDto cardGetDto) {
        Long cardId = cardGetDto.getCardId();
        String cardNumber = cardGetDto.getCardNumber();
        LocalDate cardExpirationDate = cardGetDto.getCardExpirationDate();
        Integer cardCvv = cardGetDto.getCardCvv();
        CardStatus cardStatus = cardGetDto.getCardStatus();
        Long accountId = cardGetDto.getAccountId();

        try {
            Connection connection = dataSource.getConnection();
            StringBuilder query = new StringBuilder("SELECT * FROM cards WHERE 1=1");
            if (cardId != null) {
                query.append(" AND card_id = ?");
            }
            if (cardNumber != null) {
                query.append(" AND card_number = ?");
            }
            if (cardExpirationDate != null) {
                query.append(" AND card_expiration_date = ?");
            }
            if (cardCvv != null) {
                query.append(" AND card_cvv = ?");
            }
            if (cardStatus != null) {
                query.append(" AND card_status = ?");
            }
            if (accountId != null) {
                query.append(" AND accounts_account_id = ?");
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

            int parameterIndex = 1;
            if (cardId != null) {
                preparedStatement.setLong(parameterIndex++, cardId);
            }
            if (cardNumber != null) {
                preparedStatement.setString(parameterIndex++, cardNumber);
            }
            if (cardExpirationDate != null) {
                preparedStatement.setObject(parameterIndex++, cardExpirationDate, Types.DATE);
            }
            if (cardCvv != null) {
                preparedStatement.setInt(parameterIndex++, cardCvv);
            }
            if (cardStatus != null) {
                preparedStatement.setString(parameterIndex++, cardStatus.name());
            }
            if (accountId != null) {
                preparedStatement.setLong(parameterIndex++, accountId);
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            CardEntity cardEntity = null;
            while (resultSet.next()) {
                Long id = resultSet.getLong("card_id");
                String number = resultSet.getString("card_number");
                LocalDate expirationDate = resultSet.getDate("card_expiration_date").toLocalDate();
                Integer cvv = resultSet.getInt("card_cvv");
                CardStatus status = CardStatus.valueOf(resultSet.getString("card_status"));
                Long accId = resultSet.getLong("accounts_account_id");
                cardEntity = new CardEntity(id, number, expirationDate, cvv, status, accId);
            }
            return cardEntity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createCard(CardCreateDto cardCreateDto) {

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("""
                            		INSERT INTO "cards" (card_number, card_expiration_date, card_cvv, card_status, accounts_account_id)
                            		VALUES (?, ?, ?, ?, ?)
                            """);
            preparedStatement.setString(1, cardCreateDto.getCardNumber());
            preparedStatement.setObject(2, cardCreateDto.getCardExpirationDate());
            preparedStatement.setInt(3, cardCreateDto.getCardCvv());
            preparedStatement.setString(4, cardCreateDto.getCardStatus().name());
            preparedStatement.setLong(5, cardCreateDto.getAccountId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCard(CardUpdateDto cardUpdateDto) {
        Long cardId = cardUpdateDto.getCardId();
        LocalDate cardExpirationDate = cardUpdateDto.getCardExpirationDate();
        CardStatus cardStatus = cardUpdateDto.getCardStatus();

        try {
            Connection connection = dataSource.getConnection();
            StringBuilder query = new StringBuilder("UPDATE cards SET");
            if (cardExpirationDate != null) {
                query.append(" card_expiration_date = ?");
            }
            if (cardExpirationDate != null && cardStatus != null) {
                query.append(",");
            }
            if (cardStatus != null) {
                query.append(" card_status = ?");
            }
            query.append(" WHERE card_id = ?");

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

            int parameterIndex = 1;
            if (cardExpirationDate != null) {
                preparedStatement.setObject(parameterIndex++, cardExpirationDate, Types.DATE);
            }
            if (cardStatus != null) {
                preparedStatement.setString(parameterIndex++, cardStatus.name());
            }
            preparedStatement.setLong(parameterIndex++, cardId);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCard(CardDeleteDto cardDeleteDto) {
        Long cardId = cardDeleteDto.getCardId();
        String cardNumber = cardDeleteDto.getCardNumber();
        LocalDate cardExpirationDate = cardDeleteDto.getCardExpirationDate();
        CardStatus cardStatus = cardDeleteDto.getCardStatus();
        Long accountId = cardDeleteDto.getAccountId();

        try {
            Connection connection = dataSource.getConnection();
            StringBuilder query = new StringBuilder("DELETE FROM cards WHERE 1=1");
            if (cardId != null) {
                query.append(" AND card_id = ?");
            }
            if (cardNumber != null) {
                query.append(" AND card_number = ?");
            }
            if (cardExpirationDate != null) {
                query.append(" AND card_expiration_date = ?");
            }
            if (cardStatus != null) {
                query.append(" AND card_status = ?");
            }
            if (accountId != null) {
                query.append(" AND accounts_account_id = ?");
            }

            PreparedStatement preparedStatement = connection.prepareStatement(query.toString());

            int parameterIndex = 1;
            if (cardId != null) {
                preparedStatement.setLong(parameterIndex++, cardId);
            }
            if (cardNumber != null) {
                preparedStatement.setString(parameterIndex++, cardNumber);
            }
            if (cardExpirationDate != null) {
                preparedStatement.setObject(parameterIndex++, cardExpirationDate, Types.DATE);
            }
            if (cardStatus != null) {
                preparedStatement.setString(parameterIndex++, cardStatus.name());
            }
            if (accountId != null) {
                preparedStatement.setLong(parameterIndex++, accountId);
            }

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
