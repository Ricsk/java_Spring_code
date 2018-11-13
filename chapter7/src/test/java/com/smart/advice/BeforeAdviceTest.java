/*package com.smart.advice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.*;
public class BeforeAdviceTest{
	@Test
	public void before() {
		Waiter target = new NaiveWaiter();
		BeforeAdvice advice = new GreetingBeforeAdvice();
		ProxyFactory pf = new ProxyFactory();
		pf.setOptimize(true);
		pf.setTarget(target);
		pf.addAdvice(advice);
		
		Waiter proxy = (Waiter)pf.getProxy();
		proxy.greetTo("John");
		proxy.serveTo("Tom");
		
		String configPath = "com/smart/advice/beans.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
		Waiter waiter = (Waiter)ctx.getBean("waiter");
		waiter.greetTo("John");
		
		ForumService forumService = (ForumService)ctx.getBean("forumService");
		try {
			forumService.removeForum(0);
		}catch(Exception e) {}
		try {
			forumService.updateForum(new Forum());
		}catch(Exception e) {}
	}
}*/