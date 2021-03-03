package com.antony.designpattern.template;

public class RestaurantGinsengImpl extends RestaurantTemplate {

    @Override
    void spotMenu() {
        System.out.println("人参");
    }

    @Override
    void payment() {
        System.out.println("5快");
    }
}