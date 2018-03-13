package com.crab.design.patterns.ch03_Decorator.flavorings;

import com.crab.design.patterns.ch03_Decorator.Beverage;
import com.crab.design.patterns.ch03_Decorator.CondimentDecorator;

/**
 * Description:     装饰类 调料 Soy
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:49
 */

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        return .15 + beverage.cost();
    }
}