package com.crab.design.patterns.ch04_Factory.pizzas;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/5 下午6:44
 */

class PepperoniPizza extends Pizza {
    public PepperoniPizza() {
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
}
