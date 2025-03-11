package com.example.l05_springdataintro.services;

import java.math.BigDecimal;

public interface AccountService {

    void withdrawMoney(BigDecimal amount, Long id);
    void depositMoney(BigDecimal amount, Long id);
}
