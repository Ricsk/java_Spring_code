package com.smart.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import com.smart.aspectJ.basic.Seller;
import com.smart.aspectJ.basic.SmartSeller;
import com.smart.aspectJ.example.NaiveWaiter;
import com.smart.aspectJ.example.Waiter;

public class schemaTest{
	@Test
	public void schematest() {
		String configPath = "com/smart/schema/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter naiveWaiter = (Waiter)ctx.getBean("naiveWaiter");
		Waiter naughtyWaiter = (Waiter)ctx.getBean("naughtyWaiter");
		Seller seller = (Seller)ctx.getBean("seller");
		/*naiveWaiter.greetTo("Tom");
		naiveWaiter.serveTo("TOm");
		naughtyWaiter.greetTo("John");*/
//		seller.sell("Beer", "Tom");
//		((SmartSeller)seller).checkBill(1);
		naiveWaiter.greetTo("Tom");
		//((Seller)naiveWaiter).sell("Beer", "John");
		((NaiveWaiter)naiveWaiter).smile("John", 2);
	}
}