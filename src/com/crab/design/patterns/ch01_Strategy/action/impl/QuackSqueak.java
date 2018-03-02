package com.crab.design.patterns.ch01_Strategy.action.impl;

import com.crab.design.patterns.ch01_Strategy.action.QuackBehavior;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/2 下午2:58
 */

public class QuackSqueak implements QuackBehavior {

    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
