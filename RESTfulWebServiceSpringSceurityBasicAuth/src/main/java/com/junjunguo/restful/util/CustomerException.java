package com.junjunguo.restful.util;

import org.springframework.http.HttpStatus;

/**
 * This file is part of RESTfulWebService.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 30/10/2016.
 */
public class CustomerException extends RuntimeException {


    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not initialized, and may
     * subsequently be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the
     * {@link #getMessage()}
     *                method.
     */
    public CustomerException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
