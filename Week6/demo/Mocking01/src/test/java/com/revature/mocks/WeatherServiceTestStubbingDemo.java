package com.revature.mocks;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherServiceTestStubbingDemo {

    @Test
    public void testWeatherServiceWithStubbing() {
        WeatherApiClient apiClient = Mockito.mock(WeatherApiClient.class);

        // STUBBING: define what the mock should return
        Mockito.when(apiClient.fetchTemperature("Plano")).thenReturn(35.0);

        WeatherService service = new WeatherService(apiClient);

        String message = service.getWeatherMessage("Plano");
        assertEquals("It is hot in Plano", message);
    }
}
