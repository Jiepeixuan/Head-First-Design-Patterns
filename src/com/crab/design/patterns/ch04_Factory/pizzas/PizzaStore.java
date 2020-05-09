package com.crab.design.patterns.ch04_Factory.pizzas;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/6 上午10:00
 */

public class PizzaStore {

    SimplePizzaFactory factory;

    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type){
        Pizza pizza = null;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
