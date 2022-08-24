package com.training.unitservice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.training.unitservice.bean.UnitConversion;

@Service
public class UnitService {

	private Map<String, UnitConversion> unitMap = new HashMap<>();

	public UnitService() {
		unitMap.put("FEETINCH", new UnitConversion(1001L, "Feet", "Inch", 12.0));
		unitMap.put("METERCM", new UnitConversion(1002L, "Meter", "Cm", 100.0));
		unitMap.put("METERFEET", new UnitConversion(1003L, "Meter", "Feet", 3.28));
		unitMap.put("FEETMETER", new UnitConversion(1004L, "Feet", "Meter", .30));

	}

	public UnitConversion findbyUnit(String from, String to) {
		return unitMap.get(from.toUpperCase() + to.toUpperCase());

	}

}
