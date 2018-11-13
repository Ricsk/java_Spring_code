package com.smart.beanfactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.smart.Car;
import org.testng.annotations.*;
import static org.testng.Assert.*;
public class BeanFactoryTest{
	
	@Test
	public void getBean()throws Throwable{
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource res = resolver.getResource("classpath:com/smart/beanfactory/beans.xml");
		System.out.println(res.getURL());
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions(res);
		
		Car car = factory.getBean("car1", Car.class);
		car.introduce();
	}
}