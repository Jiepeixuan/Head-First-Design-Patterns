package com.crab.design.patterns.ch03_Decorator.coffee;

import com.crab.design.patterns.ch03_Decorator.Beverage;

/**
 * Description:     被装饰者 咖啡类 HouseBlend
 * Author:          SuperCrab
 * Time:            2018/3/9 下午2:28
 */

public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
