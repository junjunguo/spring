package com.junjunguo.aop.restaurant;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 */
public class RestaurantServiceImpl implements RestaurantService {

    public void customerService(String name) {
        System.out.println("--------- 姑娘们在招待顾客:" + name);
    }

    public void onlookers(String name) {
        System.out.println(name + ":在围观 ====");
    }
}
