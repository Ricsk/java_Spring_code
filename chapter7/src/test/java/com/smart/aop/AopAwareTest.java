package com.smart.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import org.springframework.context.ApplicationContext;
public class AopAwareTest{
	@Test
	public void autoProxy() {
		String configPath = "com/smart/aop/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.serveTo("John");
		//waiter.greetTo("John");
	}
}