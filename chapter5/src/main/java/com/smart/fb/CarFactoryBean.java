package com.smart.fb;

import org.springframework.beans.factory.FactoryBean;
public class CarFactoryBean implements FactoryBean<Car>{
	
	private String carInfo;
	//接收逗号分隔的属性设置信息
	public String getCarInfo() {
		return this.carInfo;
	}
	
	//实例化Car Bean
	public Car getObject() throws Exception{
		Car car = new Car();
		String[] infos = carInfo.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}
	
	public Class<Car> getObjectType(){
		return Car.class;
	}
	
	public boolean isSingleton() {
		return false;
	}
}