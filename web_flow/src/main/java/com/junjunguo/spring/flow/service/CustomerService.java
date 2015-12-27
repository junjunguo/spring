package com.junjunguo.spring.flow.service;

import com.junjunguo.spring.flow.domain.Customer;

public interface CustomerService {
    Customer lookupCustomer(String phoneNumber) throws CustomerNotFoundException;
}