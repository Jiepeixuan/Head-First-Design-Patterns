package com.crab.design.patterns.ch01_Strategy.duck;

import com.crab.design.patterns.ch01_Strategy.action.impl.FlyWithWings;
import com.crab.design.patterns.ch01_Strategy.action.impl.Quack;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/2 下午3:03
 */

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
