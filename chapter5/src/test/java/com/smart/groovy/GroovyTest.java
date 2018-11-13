package com.smart.groovy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class GroovyTest{
	@Test
	public void getBeans() {
		//加载Groovy Bean配置文件
		ApplicationContext ctx = new GenericGroovyApplicationContext(""
				+ "classpath:com/smart/groovy/spring-context.groovy");
		
		//加载Bean
		LogonService logonService = ctx.getBean(LogonService.class);
		assertNotNull(logonService);
		logonService.getMailService().printll();
		//加载注解定义的Bean
		//MailService mailService = ctx.getBean(MailService.class);
		//assertNotNull(mailService);
		
		//判断是否注入DbUserDao
		UserDao userDao = ctx.getBean(UserDao.class);
		assertTrue(userDao instanceof DbUserDao);
	}
}