package com.junjunguo.spring.flow.service;

import com.junjunguo.spring.flow.domain.Order;

public interface PricingEngine {
    public float calculateOrderTotal(Order order);
}
