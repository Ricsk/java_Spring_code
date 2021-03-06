package com.smart.aspectJ.fun;
import com.smart.aspectJ.fun.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.smart.aspectJ.basic.*;
import com.smart.aspectJ.example.Waiter;

public class PointcunFunTest{
	//@Test
	public void pointcut(){
		String configPath = "com/smart/aspectJ/fun/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter naiveWaiter = (Waiter) ctx.getBean("naiveWaiter");
		/*Waiter naughtyWaiter = (Waiter) ctx.getBean("naughtyWaiter");
		naiveWaiter.greetTo("John");
		naughtyWaiter.greetTo("Tom");*/
		naiveWaiter.greetTo("John");
		naiveWaiter.serveTo("John");
		Seller s = (Seller)naiveWaiter;
		s.sell("Beer", "John");
	}
}