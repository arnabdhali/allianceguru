package com.training.conversionservice.controller;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.conversionservice.bean.Result;




@RestController
public class ConversionController {
	
@Autowired
private UnitServiceProxy proxy;


/*
 * @GetMapping("/conversion-service/from/{from}/to/{to}/quantity/{quantity}")
 * public Result getConvertedResult(@PathVariable String from,@PathVariable
 * String to,@PathVariable Integer quantity) { Map<String,String>
 * uriVariables=new HashMap<>(); uriVariables.put("from", from);
 * uriVariables.put("to", to); //return new Result(1005L, "Meter","Feet", 10,
 * 1.1, 11, "8000"); ResponseEntity<Result> resultEntity= new
 * RestTemplate().getForEntity(
 * "http://localhost:8000/unit-service/from/{from}/to/{to}",
 * Result.class,uriVariables); Result body= resultEntity.getBody(); return new
 * Result(body.getId(),from,to,quantity,body.getMultiplier(),quantity*body.
 * getMultiplier(),body.getEnvironment());
 * 
 * }
 */


@GetMapping("/conversion-service/from/{from}/to/{to}/quantity/{quantity}")
public Result getConvertedResultViaFeign(@PathVariable String from,@PathVariable String to,@PathVariable Integer quantity)
{
	System.out.println("Via Feign Client");
	Result body= proxy.getConvertedResult(from, to);
	return new Result(body.getId(),from,to,quantity,body.getMultiplier(),quantity*body.getMultiplier(),body.getEnvironment());
			
}



}

