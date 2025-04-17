package dev.pustelnikov.controller;

import dev.pustelnikov.converter.JsonConverter;
import dev.pustelnikov.converter.implementation.JsonConverterImpl;
import dev.pustelnikov.dao.CardDao;
import dev.pustelnikov.dao.implementation.CardDaoImpl;
import dev.pustelnikov.datasource.implementation.DataSourceImpl;
import dev.pustelnikov.dto.card.CardDto;
import dev.pustelnikov.dto.card.request.CardDeleteRequestDto;
import dev.pustelnikov.dto.card.request.CardGetRequestDto;
import dev.pustelnikov.dto.card.request.CardCreateRequestDto;
import dev.pustelnikov.dto.card.request.CardUpdateRequestDto;
import dev.pustelnikov.mapper.CardMapper;
import dev.pustelnikov.service.CardService;
import dev.pustelnikov.service.CardUtilService;
import dev.pustelnikov.service.implementation.CardServiceImpl;
import dev.pustelnikov.service.implementation.CardUtilServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cards/*")
public class CardServlet extends HttpServlet {
    private final DataSource dataSource = DataSourceImpl.getInstance();
    private final CardDao cardDao = new CardDaoImpl(dataSource);
    private final CardMapper cardMapper = CardMapper.INSTANCE;
    private final CardUtilService cardUtilService = new CardUtilServiceImpl();
    private final CardService cardService = new CardServiceImpl(cardDao, cardMapper, cardUtilService);
    private final JsonConverter jsonConverter = new JsonConverterImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        CardGetRequestDto cardGetRequestDto = CardGetRequestDto.builder()
                .cardId(request.getParameter("cardId"))
                .cardNumber(request.getParameter("cardNumber"))
                .cardExpirationDate(request.getParameter("cardExpirationDate"))
                .cardCvv(request.getParameter("cardCvv"))
                .cardStatus(request.getParameter("cardStatus"))
                .accountId(request.getParameter("accountId"))
                .build();

        CardDto card = cardService.getCard(cardGetRequestDto);
        response.setContentType("application/json");
        String jsonCard = jsonConverter.convertToJson(card);
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonCard);
        response.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String payload = sb.toString();
        CardCreateRequestDto cardCreateRequestDto = (CardCreateRequestDto) jsonConverter.convertToObject(payload, CardCreateRequestDto.class);
        cardService.createCard(cardCreateRequestDto);
        response.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String payload = sb.toString();
        CardUpdateRequestDto cardUpdateRequestDto = (CardUpdateRequestDto) jsonConverter.convertToObject(payload, CardUpdateRequestDto.class);
        cardService.updateCard(cardUpdateRequestDto);
        response.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CardDeleteRequestDto cardDeleteRequestDto = CardDeleteRequestDto.builder()
                .cardId(request.getParameter("cardId"))
                .cardNumber(request.getParameter("cardNumber"))
                .cardExpirationDate(request.getParameter("cardExpirationDate"))
                .cardStatus(request.getParameter("cardStatus"))
                .accountId(request.getParameter("accountId"))
                .build();

        cardService.deleteCard(cardDeleteRequestDto);
        response.setStatus(200);
    }
}
