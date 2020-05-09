package com.crab.design.patterns.ch04_Factory.pizzafm;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/14 下午12:41
 */

public abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
