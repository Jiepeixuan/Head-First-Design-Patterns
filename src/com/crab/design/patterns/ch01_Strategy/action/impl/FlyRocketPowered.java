package com.crab.design.patterns.ch01_Strategy.actionImpl;

import com.crab.design.patterns.ch01_Strategy.FlyBehavior;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/2 下午3:16
 */

public class FlyRocketPowered implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
