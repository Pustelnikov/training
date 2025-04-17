package dev.pustelnikov.service;

import java.time.LocalDate;

public interface CardUtilService {
    String generateCardNumber();
    Integer generateCardCvv();
    LocalDate generateCardExpirationDate();
}
