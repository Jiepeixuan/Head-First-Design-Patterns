package com.crab.design.patterns.ch03_Decorator.coffee;

import com.crab.design.patterns.ch03_Decorator.Beverage;

/**
 * Description:     被装饰者 咖啡类 Decaf
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:44
 */

public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf Coffee";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
