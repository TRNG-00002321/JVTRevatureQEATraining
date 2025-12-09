package com.revature.mocks;

public class WeatherService {

    private WeatherApiClient weatherApiClient;

    public WeatherService(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    public String getWeatherMessage(String city) {
        double temp = weatherApiClient.fetchTemperature(city);
        if (temp > 30) {
            return "It is hot in " + city;
        } else if (temp > 15) {
            return "It is warn in " + city;
        } else {
            return "It is cold in " + city;
        }
    }

    public void refresh(String city) {
        weatherApiClient.fetchTemperature(city);
    }
}
