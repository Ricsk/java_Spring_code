package com.smart.aspectJ.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.smart.aspectJ.example.Waiter;

public class DeclaredParentsTest{
	
	//@Test
	public void declareParent(){
		String configPath = "com/smart/aspectJ/basic/beans.xml";
		ApplicationContext  ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		Seller seller = (Seller)waiter;
		seller.sell("Beer", "John");
	}
}