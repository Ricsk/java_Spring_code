/*package com.smart.proxy;
import java.lang.reflect.Proxy;
import org.testng.annotations.*;

public class ForumServiceTest{
	@Test
	public void proxy() {
		ForumService target = new ForumServiceImpl();
		PerformanceHandler handler = new PerformanceHandler(target);
		ForumService proxy = (ForumService) Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				handler
				);
				
		proxy.removeForum(10);
		proxy.removeTopic(1012);
		CglibProxy cglibProxy = new CglibProxy();
		ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
		//forumService.removeForum(10);
		//forumService.removeTopic(1023);
	}
}*/