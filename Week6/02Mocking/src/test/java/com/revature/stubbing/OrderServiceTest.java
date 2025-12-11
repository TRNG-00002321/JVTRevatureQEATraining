package com.revature.stubbing;

/*

import com.revature.stubbing.gateway.PaymentGateway;
import com.revature.stubbing.model.Product;
import com.revature.stubbing.repository.ProductRepository;
import com.revature.stubbing.service.InventoryService;
import com.revature.stubbing.service.NotificationService;
import com.revature.stubbing.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private ProductRepository productRepository;

    @Mock
    private InventoryService inventoryService;

    @Mock
    private PaymentGateway paymentGateway;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void calculateOrderTotal_multipleProducts_returnsCorrectSum() {
        // Arrange: Stub product lookups
        Product laptop = new Product("LAPTOP", "MacBook Pro", new BigDecimal("1999.99"));
        Product mouse = new Product("MOUSE", "Magic Mouse", new BigDecimal("79.99"));

        when(productRepository.findById("LAPTOP")).thenReturn(Optional.of(laptop));
        when(productRepository.findById("MOUSE")).thenReturn(Optional.of(mouse));

        // Act
        BigDecimal total = orderService.calculateTotal(List.of("LAPTOP", "MOUSE"));

        // Assert
        assertEquals(new BigDecimal("2079.98"), total);
    }
}
 */