package com.crab.design.patterns.ch01_Strategy.actionImpl;

import com.crab.design.patterns.ch01_Strategy.FlyBehavior;

/**
 * Description:     不会飞行的动作
 * Author:          SuperCrab
 * Time:            2018/3/2 下午2:52
 */

public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
