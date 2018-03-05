package com.crab.design.patterns.ch02_Observer.weather.Observer.impl;

import com.crab.design.patterns.ch02_Observer.weather.Observer.DisplayElement;
import com.crab.design.patterns.ch02_Observer.weather.Observer.Observer;
import com.crab.design.patterns.ch02_Observer.weather.Subject.Subject;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:29
 */

public class CurrentConditionsDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humdity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humdity + "% humidity");
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humdity = humidity;
        display();
    }
}
