package com.crab.design.patterns.ch04_Factory.pizzafm;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/14 下午12:37
 */

class NYStyleCheesePizza extends Pizza{

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
