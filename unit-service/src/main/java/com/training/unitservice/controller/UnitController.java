package com.training.unitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import  com.training.unitservice.bean.Configuration;
import com.training.unitservice.bean.UnitConversion;
import com.training.unitservice.service.UnitService;

@RestController
public class UnitController {
	
	@Autowired
	private Configuration configuration;

	@Autowired
	Environment environment;

	@Autowired
	UnitService unitService;

	@GetMapping("/unit-service/from/{from}/to/{to}")
	public UnitConversion retreiveUnitValue(@PathVariable String from, @PathVariable String to) {
		UnitConversion unitConversion = unitService.findbyUnit(from, to);
		//UnitConversion unitConversion = new UnitConversion(1001L,"Meter","Feet",3.22);
		//UnitConversion unitConversion = new UnitConversion(1002L,configuration.getFrom(),configuration.getTo(),configuration.getMultiplier());
System.out.println(environment.getProperty("local.server.port"));
		if (unitConversion == null)
			throw new RuntimeException("Data not available for " + from + " to  " + to);
		unitConversion.setEnvironment(environment.getProperty("local.server.port"));

		return unitConversion;
	}

}
