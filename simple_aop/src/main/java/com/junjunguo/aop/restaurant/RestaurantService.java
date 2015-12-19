package com.junjunguo.aop.restaurant;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 */
public interface RestaurantService {
    void customerService(String name);

    void onlookers(String name);
}
