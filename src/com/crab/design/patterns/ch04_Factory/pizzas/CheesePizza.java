package com.crab.design.patterns.ch04_Factory.pizzas;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/5 下午6:43
 */

class CheesePizza extends Pizza{
    public CheesePizza() {
        name = "Cheese Pizza";
        dough = "Regular Crust";
        sauce = "Marinara Pizza Sauce";
        toppings.add("Fresh Mozzarella");
        toppings.add("Parmesan");
    }
}
