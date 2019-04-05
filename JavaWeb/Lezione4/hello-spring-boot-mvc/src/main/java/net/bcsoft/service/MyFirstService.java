package net.bcsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

	@Autowired
	MySecondService service;
	
	public String getDefaultName () {
		StringBuilder sb = new StringBuilder("name ");
		sb.append(service.getSurname());
		return sb.toString();
	}
}
