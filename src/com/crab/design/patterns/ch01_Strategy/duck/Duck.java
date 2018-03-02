package com.crab.design.patterns.ch01_Strategy.duck;

import com.crab.design.patterns.ch01_Strategy.action.FlyBehavior;
import com.crab.design.patterns.ch01_Strategy.action.QuackBehavior;

/**
 * Description:     Duck类
 * Author:          SuperCrab
 * Time:            2018/3/2 下午2:46
 */

public abstract class Duck {

    protected FlyBehavior flyBehavior;
    protected QuackBehavior quackBehavior;

    public Duck(){

    }

    public abstract void display();

    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuack(){
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("All ducks float, even decoys");
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
