package com.systec.main;


import com.systec.weather.ArrayOfString;
import com.systec.weather.WeatherWS;
import com.systec.weather.WeatherWSSoap;

import java.util.List;

/**
 * Created by wh on 8/29/2017.
 */
public class WebService {

    public static void main(String[] args) throws Exception {
        //创建一个WeatherWS工厂
        WeatherWS factory = new WeatherWS();
        //根据工厂创建一个WeatherWSSoap对象
        WeatherWSSoap weatherWSSoap = factory.getWeatherWSSoap();
        //调用WebService提供的getWeather方法获取南宁市的天气预报情况
        ArrayOfString weatherInfo = weatherWSSoap.getWeather("孝感", null);
        List<String> lstWeatherInfo = weatherInfo.getString();
        //遍历天气预报信息
        for (String string : lstWeatherInfo) {
            System.out.println(string);
            System.out.println("------------------------");
        }
    }

}
