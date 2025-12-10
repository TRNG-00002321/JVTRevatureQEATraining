package com.revature.stubbing.gateway;

import java.math.BigDecimal;
import com.revature.stubbing.model.PaymentResult;
import com.revature.stubbing.model.PaymentDetails;

public interface PaymentGateway {
    PaymentResult charge(BigDecimal amount, PaymentDetails details);
    void refund(String transactionId, BigDecimal amount);
}
