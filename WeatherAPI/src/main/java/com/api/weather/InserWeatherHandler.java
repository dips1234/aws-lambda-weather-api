package com.api.weather;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

public class InserWeatherHandler extends SpringBootRequestHandler<APIGatewayProxyRequestEvent, String> {

}
