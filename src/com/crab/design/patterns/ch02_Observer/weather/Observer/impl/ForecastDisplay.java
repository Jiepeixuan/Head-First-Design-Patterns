package com.crab.design.patterns.ch02_Observer.weather.Observer.impl;

import com.crab.design.patterns.ch02_Observer.weather.Observer.DisplayElement;
import com.crab.design.patterns.ch02_Observer.weather.Observer.Observer;
import com.crab.design.patterns.ch02_Observer.weather.Subject.impl.WeatherData;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:42
 */

public class ForecastDisplay implements Observer, DisplayElement{

    private float currentPressure = 29.92f;
    private float lastPressure;
    private WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.lastPressure = currentPressure;
        this.currentPressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
