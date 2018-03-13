package com.crab.design.patterns.ch03_Decorator.coffee;

import com.crab.design.patterns.ch03_Decorator.Beverage;

/**
 * Description:     被装饰者 咖啡类 Espresso
 * Author:          SuperCrab
 * Time:            2018/3/9 下午2:24
 */

public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
