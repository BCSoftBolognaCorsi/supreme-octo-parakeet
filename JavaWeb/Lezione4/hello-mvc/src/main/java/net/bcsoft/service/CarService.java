package net.bcsoft.service;

import org.springframework.stereotype.Service;

import net.bcsoft.model.Car;

@Service
public class CarService {

	public void addModelYear (Car car, Integer year) {
		car.setModel(car.getModel() + " - " + year);
	}
}
