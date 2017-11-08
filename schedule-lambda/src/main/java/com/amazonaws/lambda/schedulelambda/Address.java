package com.amazonaws.lambda.schedulelambda;

import javax.xml.bind.annotation.XmlElement;

public class Address {
	private String city;
	private String state;
	private int pin;
	public String getCity() {
		return city;
	}
	@XmlElement
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	@XmlElement
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}
	public int getPin() {
		return pin;
	}
	@XmlElement
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
