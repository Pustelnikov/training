package dev.pustelnikov.service.implementation;

import dev.pustelnikov.service.CardUtilService;
import java.time.LocalDate;
import java.util.Random;

public class CardUtilServiceImpl implements CardUtilService {

    @Override
    public String generateCardNumber() {
        Random random = new Random();
        StringBuilder tempCardNumber;
        String cardNumber;
        tempCardNumber = new StringBuilder();

        tempCardNumber.append("Card");
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            tempCardNumber.append(digit);
        }
        cardNumber = tempCardNumber.toString();
        return cardNumber;
    }

    @Override
    public Integer generateCardCvv() {
        Random random = new Random();
        return random.nextInt(1000);
    }

    @Override
    public LocalDate generateCardExpirationDate() {
        return LocalDate.now().plusYears(3);
    }
}
