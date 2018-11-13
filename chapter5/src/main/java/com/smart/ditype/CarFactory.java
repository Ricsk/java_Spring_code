package com.smart.ditype;
import com.smart.Car;
public class CarFactory{
	public Car createHongQiCar(){
		Car car=new Car();
		car.setBrand("红旗");
		return car;
		}
	}