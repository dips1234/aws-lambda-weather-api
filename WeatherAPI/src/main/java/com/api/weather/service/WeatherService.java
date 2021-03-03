package com.api.weather.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.api.weather.entity.WeatherEntity;
import com.api.weather.model.WeatherModel;
import com.api.weather.repository.WeatherRepository;

@Service
public class WeatherService {
	@Autowired
	RestTemplate resttemplate;

	@Autowired
	WeatherRepository repository;

	public String insertDetails(String zip) {

		WeatherModel response = resttemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?zip=" + zip
				+ ",us&appid=9de243494c0b295cca9337e1e96b00e2", WeatherModel.class);
		WeatherEntity entity = new WeatherEntity();
		entity.setDate(new Date());
		entity.setTemp(response.getMain().getTemp());
		entity.setZipcode(Integer.parseInt(zip));
		repository.save(entity);
		return "Temparature Information for zipcode " + zip + " is saved successfully";

	}

	public WeatherEntity getWeatherDetails(String zipcode) {

		return repository.findWeatherByZipCode(Integer.parseInt(zipcode));

	}

}
