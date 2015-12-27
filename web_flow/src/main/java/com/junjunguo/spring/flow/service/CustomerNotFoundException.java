package com.junjunguo.spring.flow.service;

@SuppressWarnings("serial")
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException() {}

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
