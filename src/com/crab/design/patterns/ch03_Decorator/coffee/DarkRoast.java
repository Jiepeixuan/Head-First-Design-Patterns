package com.crab.design.patterns.ch03_Decorator.coffee;

import com.crab.design.patterns.ch03_Decorator.Beverage;

/**
 * Description:     被装饰者 咖啡类 DarkRoast
 * Author:          SuperCrab
 * Time:            2018/3/13 上午10:42
 */

public class DarkRoast extends Beverage {

    public DarkRoast(){
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return .99;
    }
}
