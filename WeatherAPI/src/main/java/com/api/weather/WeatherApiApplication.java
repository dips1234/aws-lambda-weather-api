package com.api.weather;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.api.weather.entity.WeatherEntity;
import com.api.weather.service.WeatherService;

@SpringBootApplication
public class WeatherApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApiApplication.class, args);
	}

	@Bean
	public RestTemplate resttemplate() {
		return new RestTemplate();
	}

	@Autowired
	private WeatherService service;

	@Bean
	public Function<APIGatewayProxyRequestEvent, String> insertdetails() {

		return (requestEvent) -> service.insertDetails(requestEvent.getQueryStringParameters().get("zip"));

	}

	@Bean
	public Function<APIGatewayProxyRequestEvent, WeatherEntity> getWeatherByZip() {

		return (requestEvent) -> service.getWeatherDetails(requestEvent.getQueryStringParameters().get("zip"));
	}

}
