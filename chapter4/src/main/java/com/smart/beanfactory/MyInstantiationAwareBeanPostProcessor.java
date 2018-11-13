package com.smart.beanfactory;
import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.
InstantiationAwareBeanPostProcessorAdapter;
import com.smart.Car;
public class MyInstantiationAwareBeanPostProcessor extends 
InstantiationAwareBeanPostProcessorAdapter{
	
	//接口：在实例化Bean前调用
	public Object postProcessBeforeInstantiation(Class beanClass, String beanName)
		throws BeansException{
		if("car1".equals(beanName)) {
			System.out.println("InstantiationAware BeanPostProcessor.postProcess"
					+ "	BeforeInstantiation");
		}
		return null;
	}
	
	//接口：在实例化Bean后调用
	public boolean postProcessAfterInstantiation(Object bean, String beanName)
		throws BeansException{
		if("car1".equals(beanName)) {
			System.out.println("InstantiationAware BeanPostProcessor.postProcess"
					+ "		AfterInstantiation");
		}
		return true;
	}
	//接口：在设置某个属性时调用
	public PropertyValues postProcessPropertyValues(
		PropertyValues pvs,PropertyDescriptor[] pds, Object bean, String beanName)
		throws BeansException{
		if("car1".equals(beanName)) {
			System.out.println("Instantiation AwareBeanPostProcessor.postProcess"
					+ "PropertyValues");
		}
		return pvs;
	}
}