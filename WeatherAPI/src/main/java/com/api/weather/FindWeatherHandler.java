package com.api.weather;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.api.weather.entity.WeatherEntity;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
public class FindWeatherHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, WeatherEntity> {

}
