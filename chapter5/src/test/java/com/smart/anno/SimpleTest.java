package com.smart.anno;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SimpleTest{
	//@Test
	public void test_pro_pre() {
		ApplicationContext ctx = new 
				ClassPathXmlApplicationContext("com/smart/anno/beans.xml");
		((ClassPathXmlApplicationContext)ctx).destroy();
		
	}
}