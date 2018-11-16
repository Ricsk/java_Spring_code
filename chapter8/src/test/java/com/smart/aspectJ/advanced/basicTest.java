package com.smart.aspectJ.advanced;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.smart.aspectJ.example.Waiter;
import com.smart.aspectJ.basic.SmartSeller;
import com.smart.aspectJ.example.*;
public class basicTest{
	//@Test
	public void basictest() {
		String configPath = "com/smart/aspectJ/advanced/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter naiveWaiter = (Waiter)ctx.getBean("naiveWaiter");
		Waiter naughtyWaiter = (Waiter)ctx.getBean("naughtyWaiter");
		naiveWaiter.greetTo("Tom");
		SmartSeller seller = (SmartSeller)ctx.getBean("seller");
/*		naiveWaiter.serveTo("Tom");
		((NaiveWaiter)naiveWaiter).smile("Tom", 2);
		naughtyWaiter.greetTo("John");
		naughtyWaiter.serveTo("john");*/
		seller.sell("Beer", "Smith");
		//seller.checkBill(1);
		//seller.checkBill(2);
	}
}