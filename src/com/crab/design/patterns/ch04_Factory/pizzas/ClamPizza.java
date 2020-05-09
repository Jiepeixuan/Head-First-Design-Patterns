package com.crab.design.patterns.ch04_Factory.pizzas;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/5 下午6:44
 */

class ClamPizza extends Pizza {
    public ClamPizza() {
        name = "Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
}
