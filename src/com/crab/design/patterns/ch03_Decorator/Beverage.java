package com.crab.design.patterns.ch03_Decorator;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/9 下午2:19
 */

public abstract class Beverage {
    public String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
