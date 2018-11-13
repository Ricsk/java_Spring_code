package com.smart.beanfactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import com.smart.Car;
public class MyBeanPostProcessor implements BeanPostProcessor{
	public Object postProcessBeforeInitialization(Object bean, String beanName)
		throws BeansException{
		if(beanName.equals("car1")) {
			Car car = (Car)bean;
			if(car.getColor() == null) {
				System.out.println("调用BeanPostProcessor.postProcess"
						+ "	BeforeInitialization(), color is empty, default color is black");
				car.setColor("黑色");
				
			}
		}
		return bean;
	}
	
	public Object postProcessAfterInitialization(Object bean, String beanName)
		throws BeansException{
		if(beanName.equals("car1")) {
			Car car = (Car)(bean);
			if(car.getMaxSpeed() >= 200) {
				System.out.println("调用BeanPostProcessor.postProcess"
						+ "AfterInitialization(), modify maxSpeed to 200.");
				car.setMaxSpeed(200);
			}
		}
		return bean;
	}
}	