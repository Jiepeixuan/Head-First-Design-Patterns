package com.crab.design.patterns.ch01_Strategy.action.impl;

import com.crab.design.patterns.ch01_Strategy.action.FlyBehavior;

/**
 * Description:     实现会飞的
 * Author:          SuperCrab
 * Time:            2018/3/2 下午2:49
 */

public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
