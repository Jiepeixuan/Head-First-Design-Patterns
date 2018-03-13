package com.crab.design.patterns.ch03_Decorator.flavorings;

import com.crab.design.patterns.ch03_Decorator.Beverage;
import com.crab.design.patterns.ch03_Decorator.CondimentDecorator;

/**
 * Description:     装饰类 调料 Whip
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:50
 */

public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    public double cost() {
        return .10 + beverage.cost();
    }
}