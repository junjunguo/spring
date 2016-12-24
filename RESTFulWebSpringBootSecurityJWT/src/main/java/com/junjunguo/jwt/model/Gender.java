package com.junjunguo.jwt.model;

/**
 * This file is part of RESTFulWebSpringBootSecurityJWT.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 23/12/2016.
 */
public enum Gender {
    Female(0),
    Male(1),
    Unknown(5);
    private int value;

    Gender(int value) {
        this.value = value;
    }

    /**
     * @return Female(0), Male(1), Unknown(5);
     */
    public int getValue() {return value;}
}
