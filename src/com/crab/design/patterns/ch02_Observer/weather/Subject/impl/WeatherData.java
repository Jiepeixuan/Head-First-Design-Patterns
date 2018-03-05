package com.crab.design.patterns.ch02_Observer.weather.Subject.impl;

import com.crab.design.patterns.ch02_Observer.weather.Observer.Observer;
import com.crab.design.patterns.ch02_Observer.weather.Subject.Subject;

import java.util.ArrayList;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:22
 */

public class WeatherData implements Subject{

    private ArrayList observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData(){
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int i = observers.indexOf(observer);
        if( i >= 0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasure(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
