package io.github.kalyan_matha.paymentsapi.payment.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreatePaymentRequest(
        @NotBlank @Size(max = 100) String payerName,
        @NotNull @Positive @Digits(integer = 10, fraction = 2) BigDecimal amount,
        @NotBlank @Size(min = 3, max = 3) String currency
) {
    public CreatePaymentRequest {
        if (currency != null) currency = currency.trim().toUpperCase();
    }
}