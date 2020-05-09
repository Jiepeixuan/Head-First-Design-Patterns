package com.crab.design.patterns.ch04_Factory.pizzafm;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/6/14 下午12:39
 */

class ChicagoStyleCheesePizza extends Pizza{

    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
