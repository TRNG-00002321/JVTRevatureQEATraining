package com.revature.stubbing.service;

import com.revature.stubbing.model.Order;
import com.revature.stubbing.model.PaymentDetails;

import java.math.BigDecimal;
import java.util.List;

public interface OrderService {
    BigDecimal calculateTotal(List<String> productNames);
    void processPayment(Order order, PaymentDetails details);
    void completeOrder(Order order);
}
