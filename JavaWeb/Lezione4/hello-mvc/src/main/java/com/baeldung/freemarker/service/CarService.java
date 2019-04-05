package com.baeldung.freemarker.service;

import org.springframework.stereotype.Service;

import com.baeldung.freemarker.model.Car;

@Service
public class CarService {

	public void addModelYear (Car car, Integer year) {
		car.setModel(car.getModel() + " - " + year);
	}
}
