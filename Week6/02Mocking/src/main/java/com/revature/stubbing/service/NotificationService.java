package com.revature.stubbing.service;

import com.revature.stubbing.model.Order;

public interface NotificationService {
    void sendOrderConfirmation(Order order);
    void sendShippingUpdate(Order order, String status);
}
