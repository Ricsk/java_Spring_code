package com.smart;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean{
	private String brand;
	private String color;
	private int maxSpeed;
	private double price;
	private BeanFactory beanFactory;
	private String beanName;
	public Car() {
		System.out.println("调用Car()构造函数。");
		
	}
	
	
	public Car(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
	
	public Car(String color, double price,String brand) {
		this.brand = brand;
		this.price = price;
		this.color = color;
	}
	
	public Car(String brand, String color, double price) {
		this.brand=brand;
		this.color=color;
		this.price=price;
	}
	
	public Car(String brand, String color, int maxSpeed) {
		this.brand=brand;
		this.color=color;
		this.maxSpeed=maxSpeed;
	}
	
	public void introduce() {
		System.out.println("brand:"+brand+";color:"
				+ color+";maxSpeed:"
				+ maxSpeed+".");
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
		System.out.println("调用setBrand()设置属性。");
	}
	
	public void setColor(String color) {
		this.color = color;
		System.out.println("调用setColor()设置属性。");
	}
	
	public void setPrice(double price) {
		this.price = price;
		System.out.println("调用setPrice()设置属性。");
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
		System.out.println("调用setMaxSpeed()设置属性。");
	}
	
	//BeanFactoryAwawre接口方法
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException{
		System.out.println("调用BeanFactoryAware.setBeanFactory().");
		this.beanFactory = beanFactory;
	}
	
	//BeanNameAware接口方法
	public void setBeanName(String beanName) {
		System.out.println("调用BeanNameAware.setBeanName().");
		this.beanName = beanName;
	}
	
	//InitializingBean接口方法
	public void afterPropertiesSet() throws Exception{
		System.out.println("调用InitializingBean.afterPropertiesSet().");
		
	}
	
	//DisposableBean接口方法
	public void destroy() throws Exception{
		System.out.println("调用DisposableBean.destroy().");
	}
	
	//通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("调用init-method所指定的myInit(),将maxSpeed设置为240.");
		this.maxSpeed = 240;
	}
	
	//通过<bean>的destroy-method属性指定的销毁方法
	public void myDestroy() {
		System.out.println("调用destroy-method所指定的myDestroy().");
	}

	public String getColor() {
		System.out.println("调用getColor方法");
		return this.color;
	}

	public int getMaxSpeed() {
		System.out.println("调用getMaxSpeed方法");
		return this.maxSpeed;
	}
}