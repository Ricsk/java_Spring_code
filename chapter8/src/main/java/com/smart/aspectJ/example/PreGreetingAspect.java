package com.smart.aspectJ.example;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PreGreetingAspect{
	
	@Before("execution(* greetTo(..))")//定义切点和增强类型
	public void beforeGreeting() {
		System.out.println("How are you");
	}
}