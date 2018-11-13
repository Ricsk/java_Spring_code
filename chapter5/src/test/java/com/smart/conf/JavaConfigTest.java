package com.smart.conf;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class JavaConfigTest{
	
	//@Test
	public void javaconf1(){
		ApplicationContext ctx = new
					AnnotationConfigApplicationContext(AppConf.class);
		LogonService logonService = ctx.getBean(LogonService.class);
		logonService.printHello();
	}
	
	//@Test
	public void javaconf2() {
		AnnotationConfigApplicationContext ctx = new
				AnnotationConfigApplicationContext();
		ctx.register(Daoconfig.class);
		ctx.register(ServiceConfig.class);
		ctx.refresh();
		LogonService logonService = ctx.getBean(LogonService.class);
				logonService.printHello();
	}
}