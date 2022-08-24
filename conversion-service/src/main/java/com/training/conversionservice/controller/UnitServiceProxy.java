package com.training.conversionservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.training.conversionservice.bean.Result;

//@FeignClient(name="unit-service", url="localhost:8000")
@FeignClient(name="unit-service")
public interface UnitServiceProxy {
	
	@GetMapping("/unit-service/from/{from}/to/{to}")
	public Result getConvertedResult(
			@PathVariable String from,
			@PathVariable String to);

}
