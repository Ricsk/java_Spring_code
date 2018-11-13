package com.smart.attr;
import com.smart.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContainBeanTest{
	
	//@Test
	public void parent() {
		ClassPathXmlApplicationContext pFactory = new ClassPathXmlApplicationContext(new String[]{"com/smart/attr/beans1.xml"});
		ApplicationContext factory = new ClassPathXmlApplicationContext(new String[] {"com/smart/attr/beans2.xml"},pFactory);
		Boss boss = (Boss)factory.getBean("boss_attr2");
		assertNotNull(boss);
		boss.getCar().introduce();
	}
	
	//@Test
	public void JLTest() {
		ApplicationContext factory2 = new ClassPathXmlApplicationContext(new String[] {"com/smart/attr/beans3.xml"});
		Boss boss2 = (Boss)factory2.getBean("boss_attr3");
		assertNotNull(boss2);
		boss2.getCar().introduce();
}
}