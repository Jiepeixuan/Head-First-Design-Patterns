package com.crab.design.patterns.ch03_Decorator;

import com.crab.design.patterns.ch03_Decorator.coffee.DarkRoast;
import com.crab.design.patterns.ch03_Decorator.flavorings.Soy;
import com.crab.design.patterns.ch03_Decorator.flavorings.Whip;
import com.crab.design.patterns.ch03_Decorator.coffee.Espresso;
import com.crab.design.patterns.ch03_Decorator.coffee.HouseBlend;
import com.crab.design.patterns.ch03_Decorator.flavorings.Mocha;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:48
 */

class StarbuzzCoffee {
    public static void main(String args[]) {
        //一杯不加任何调料的Espresso
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription()
                + " $" + beverage.cost());

        //加Mocha Whip的DarkRoast
        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()
                + " $" + beverage2.cost());

        //加Soy Mocha Whip的HouseBlend
        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription()
                + " $" + beverage3.cost());
    }
}
