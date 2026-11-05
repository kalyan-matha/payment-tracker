package io.github.kalyan_matha.paymentsapi.payment.dto;

import java.math.BigDecimal;

public record CreatePaymentRequest(
        String payerName,
        BigDecimal amount,
        String currency
) {
    public CreatePaymentRequest {
        if (currency != null) currency = currency.trim().toUpperCase();
    }
}