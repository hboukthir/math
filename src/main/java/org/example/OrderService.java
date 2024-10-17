package org.example;

public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(String item, int quantity) {
        // Logic to place order
        return paymentService.processPayment(item, quantity * 100);
    }
}