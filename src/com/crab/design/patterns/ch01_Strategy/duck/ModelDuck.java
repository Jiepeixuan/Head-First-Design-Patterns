package com.crab.design.patterns.ch01_Strategy.duck;

import com.crab.design.patterns.ch01_Strategy.action.impl.FlyNoWay;
import com.crab.design.patterns.ch01_Strategy.action.impl.Quack;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/2 下午3:14
 */

public class ModelDuck extends Duck {

    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
