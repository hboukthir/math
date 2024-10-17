package integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.OrderService;
import org.example.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class OrderServiceIntegrationTest {
    @Test
    public void testPlaceOrder() {
        PaymentService paymentService = Mockito.mock(PaymentService.class);
        Mockito.when(paymentService.processPayment("item1", 200)).thenReturn(true);

        OrderService orderService = new OrderService(paymentService);
        boolean result = orderService.placeOrder("item1", 2);
        assertTrue(result);

        Mockito.verify(paymentService).processPayment("item1", 200);
    }
}