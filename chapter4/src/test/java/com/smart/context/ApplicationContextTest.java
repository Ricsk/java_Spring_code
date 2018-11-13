package com.smart.context;
import org.testng.annotations.*;

import com.smart.Car;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

import static org.testng.Assert.*;

public class ApplicationContextTest{
	@Test
	public void getBean() throws Throwable{
		/*
		ApplicationContext ctx1 =
				new ClassPathXmlApplicationContext("com/smart/context/beans.xml");
		ApplicationContext ctx2 = 
				new FileSystemXmlApplicationContext("E:/work_java/chapter4/src/main/resources/com/smart/context/beans.xml");
		Car car1 = ctx1.getBean("car1", Car.class);
		car1.introduce();
		Car car2 = ctx2.getBean("car1", Car.class);
		car2.introduce();
		ApplicationContext cxt3 = 
				new ClassPathXmlApplicationContext(
					new String[]{"com/smart/beans1.xml","com/smart/beans2.xml"});
		
		ApplicationContext cxt4 = 
				new AnnotationConfigApplicationContext(Beans.class);
		Car car3 = cxt4.getBean("car3", Car.class);
		assertNotNull(car3);//断言是否为空
		car3.introduce();
		
		ApplicationContext ctx5 = 
				new GenericGroovyApplicationContext("com/smart/context/groovy-beans.groovy");
		Car car5 = (Car) ctx5.getBean("car5");
		*/
	}
}