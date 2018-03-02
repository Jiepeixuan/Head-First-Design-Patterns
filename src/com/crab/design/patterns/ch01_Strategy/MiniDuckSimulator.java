package com.crab.design.patterns.ch01_Strategy;

import com.crab.design.patterns.ch01_Strategy.action.impl.FlyRocketPowered;
import com.crab.design.patterns.ch01_Strategy.duck.Duck;
import com.crab.design.patterns.ch01_Strategy.duck.MallardDuck;
import com.crab.design.patterns.ch01_Strategy.duck.ModelDuck;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/2 下午3:08
 */

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.performQuack();
        duck.performFly();


        duck = new ModelDuck();
        duck.performFly();
        duck.setFlyBehavior(new FlyRocketPowered());
        duck.performFly();
    }
}
