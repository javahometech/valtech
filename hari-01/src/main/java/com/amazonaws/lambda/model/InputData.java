package com.amazonaws.lambda.model;

public class InputData {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "InputData [name=" + name + "]";
	}
}
