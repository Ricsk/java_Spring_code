/*package com.smart.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AutoProxyTest{
	@Test
	public void name_auto_test(){
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		Seller seller = (Seller)ctx.getBean("seller");
		waiter.greetTo("John");
		seller.greetTo("TOm");
	}
	
	@Test
	public void Default_auto_test() {
		String configPath = "com/smart/advisor/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		Seller seller = (Seller)ctx.getBean("seller");
		waiter.greetTo("John");
		//seller.greetTo("TOm");
		waiter.serveTo("John");
	}
}*/