package com.crab.design.patterns.ch03_Decorator.flavorings;

import com.crab.design.patterns.ch03_Decorator.Beverage;
import com.crab.design.patterns.ch03_Decorator.CondimentDecorator;

/**
 * Description:     装饰类 调料 Milk
 * Author:          SuperCrab
 * Time:            13/03/2018 11:33 AM
 */

public class Milk extends CondimentDecorator {
    Beverage beverage;

    public Milk(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    public double cost() {
        return .10 + beverage.cost();
    }
}