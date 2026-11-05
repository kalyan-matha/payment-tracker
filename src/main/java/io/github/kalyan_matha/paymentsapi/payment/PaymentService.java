package io.github.kalyan_matha.paymentsapi.payment;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import io.github.kalyan_matha.paymentsapi.payment.dto.CreatePaymentRequest;
import io.github.kalyan_matha.paymentsapi.payment.dto.PaymentResponse;

@Service 
public class PaymentService {

    final PaymentRepository repository;

    PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public PaymentResponse create(CreatePaymentRequest request) {
        Payment payment = new Payment();
        payment.setPayerName(request.payerName());
        payment.setAmount(request.amount());
        payment.setCurrency(request.currency());
        payment.setStatus(PaymentStatus.PENDING);
        payment.setCreatedAt(Instant.now());

        PaymentResponse response = PaymentResponse.from(repository.save(payment));

        return response;
    }

    public PaymentResponse get(UUID id) {
        return PaymentResponse
                .from(repository.findById(id).orElseThrow(() -> new PaymentNotFoundException(id)));
    }

    public List<PaymentResponse> list() {
        return repository.findAll().stream()
                .map(PaymentResponse::from)
                .toList();
    }
}
