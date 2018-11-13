/*package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class StaticAdvisorTest{
	@Test
	public void StaticBeforeTest() {
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		Seller seller = (Seller)ctx.getBean("seller");
		waiter.greetTo("John");
		waiter.serveTo("John");
		seller.greetTo("John");
		
		Waiter waiter1 = (Waiter)ctx.getBean("waiter1");
		Seller seller1 = (Seller)ctx.getBean("seller1");
		waiter1.greetTo("Jason");
		waiter1.serveTo("Jason");
		seller1.serveTo("Jason");
	}
}*/