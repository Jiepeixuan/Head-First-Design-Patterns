package com.crab.design.patterns.ch02_Observer.weather.Subject;

import com.crab.design.patterns.ch02_Observer.weather.Observer.Observer;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:17
 */

public interface Subject {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
}
