package com.junjunguo.aop;

import com.junjunguo.aop.restaurant.RestaurantService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * This file is part of simple_aop.
 * <p/>
 * Created by <a href="http://junjunguo.com">GuoJunjun</a> on 17/12/15.
 */
public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        System.out.println("- - - -");
        client.test();



    }

    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");
        RestaurantService bean = context.getBean("restaurantService",RestaurantService.class);
        bean.customerService("yuanzhang");
        bean.onlookers("diaosi");
    }

}
