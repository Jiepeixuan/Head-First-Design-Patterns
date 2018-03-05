package com.crab.design.patterns.ch02_Observer.weather.Observer.impl;

import com.crab.design.patterns.ch02_Observer.weather.Observer.DisplayElement;
import com.crab.design.patterns.ch02_Observer.weather.Observer.Observer;
import com.crab.design.patterns.ch02_Observer.weather.Subject.impl.WeatherData;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:40
 */

public class StatisticsDisplay implements Observer, DisplayElement {

    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }
}
