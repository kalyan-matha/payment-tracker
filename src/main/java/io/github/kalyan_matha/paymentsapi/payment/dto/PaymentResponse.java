package io.github.kalyan_matha.paymentsapi.payment.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import io.github.kalyan_matha.paymentsapi.payment.Payment;
import io.github.kalyan_matha.paymentsapi.payment.PaymentStatus;

public record PaymentResponse(
        UUID id,
        String payerName,
        BigDecimal amount,
        String currency,
        PaymentStatus status,
        Instant createdAt
) {
    public static PaymentResponse from(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getPayerName(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getStatus(),
                payment.getCreatedAt()
        );
    }
}