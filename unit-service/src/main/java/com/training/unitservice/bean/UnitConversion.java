package com.training.unitservice.bean;



public class UnitConversion {
	
	private Long id;
	private String from;
	private String to;
	private Double multiplier;
	private String environment;
	public UnitConversion(Long id, String from, String to, Double multiplier) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.multiplier = multiplier;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Double getMultiplier() {
		return multiplier;
	}
	public void setMultiplier(Double multiplier) {
		this.multiplier = multiplier;
	}
	public String getEnvironment() {
		return environment;
	}
	public void setEnvironment(String environment) {
		this.environment = environment;
	}
	
	

}
