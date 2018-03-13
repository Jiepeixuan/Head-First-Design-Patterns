package com.crab.design.patterns.ch03_Decorator.flavorings;

import com.crab.design.patterns.ch03_Decorator.CondimentDecorator;
import com.crab.design.patterns.ch03_Decorator.Beverage;

/**
 * Description:     装饰类 调料 Mocha
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:46
 */

public class Mocha extends CondimentDecorator {

    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
