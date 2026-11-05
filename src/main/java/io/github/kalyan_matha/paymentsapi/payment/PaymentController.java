package io.github.kalyan_matha.paymentsapi.payment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.kalyan_matha.paymentsapi.payment.dto.CreatePaymentRequest;
import io.github.kalyan_matha.paymentsapi.payment.dto.PaymentResponse;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController 
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    //POST /api/payments -> 201 Created
    @PostMapping
    public ResponseEntity<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest request) {
        PaymentResponse created = paymentService.create(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.id())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    //GET /api/payments/{id} -> 200 OK (404 if not found)
    @GetMapping("/{id}")
    public PaymentResponse getPayment(@PathVariable("id") UUID id){
        return paymentService.get(id);
    }
    
    //GET /api/payments -> 200 OK
    @GetMapping
    public List<PaymentResponse> listPayments() {
        return paymentService.list();
    }
    
}
