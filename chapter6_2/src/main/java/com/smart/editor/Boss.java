package com.smart.editor;


public class Boss{
	private String name;
	private Car car;

	
	public void setCar(Car car) {
		System.out.println("execute in setCar");
		this.car = car;
	}
	public void setName(String name) {
		this.name = name;
	}
}