package com.crab.design.patterns.ch02_Observer.weather;

import com.crab.design.patterns.ch02_Observer.weather.Observer.impl.CurrentConditionsDisplay;
import com.crab.design.patterns.ch02_Observer.weather.Observer.impl.ForecastDisplay;
import com.crab.design.patterns.ch02_Observer.weather.Observer.impl.HeatIndexDisplay;
import com.crab.design.patterns.ch02_Observer.weather.Observer.impl.StatisticsDisplay;
import com.crab.design.patterns.ch02_Observer.weather.Subject.impl.WeatherData;

/**
 * Description:
 * Author:          SuperCrab
 * Time:            2018/3/5 下午7:33
 */

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasure(80, 65, 30.4f);
        weatherData.setMeasure(82, 70, 29.2f);
        weatherData.setMeasure(78, 90, 29.2f);
    }
}
