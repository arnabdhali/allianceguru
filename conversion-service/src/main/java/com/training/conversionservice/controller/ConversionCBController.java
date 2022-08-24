package com.training.conversionservice.controller;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.conversionservice.bean.Result;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;




@RestController
public class ConversionCBController {
	


private Logger logger =LoggerFactory.getLogger(ConversionCBController.class);


@GetMapping("/conversion-service-cb/from/{from}/to/{to}/quantity/{quantity}")
//@Retry(name="cb-api")
//@Retry(name="cb-api",fallbackMethod = "handleFallBack")
//@CircuitBreaker(name="default",fallbackMethod = "handleFallBack")
@RateLimiter(name="default")
public Result getConvertedResult(@PathVariable String from,@PathVariable String to,@PathVariable Integer quantity)
{
	logger.info("Circuit Breaker API used");
	
	Map<String,String> uriVariables=new HashMap<>();
	uriVariables.put("from", from);
	uriVariables.put("to", to);
	//return new Result(1005L, "Meter","Feet", 10, 1.1, 11, "8000");
	ResponseEntity<Result> resultEntity= new RestTemplate().getForEntity("http://localhost:8000/unit-service/from/{from}/to/{to}", Result.class,uriVariables);
	Result body= resultEntity.getBody();
	return new Result(body.getId(),from,to,quantity,body.getMultiplier(),quantity*body.getMultiplier(),body.getEnvironment());
	
//return new Result(1106L, "Meter", "Cm", 10, 10, 100, "Hardcoded");		
}

public Result handleFallBack(Exception ex)
{
	logger.info("Returning Fallback response");
return new Result(1105L, "Meter", "Feet", 10, 3.28, 32.8, "Fallback");
}




}

