package io.github.kalyan_matha.paymentsapi.payment;

import java.util.UUID;

/**
 * PaymentNotFoundException
 */
public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(UUID id) {
        super("Payment not found with ID: " + id);
    }

}
