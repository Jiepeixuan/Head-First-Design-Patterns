package com.crab.design.patterns.ch02_Observer.weather.Observer;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:18
 */

public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
