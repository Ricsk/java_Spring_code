package com.smart.aspectJ.advanced;

import org.aspectj.lang.annotation.Pointcut;

public class TestNamePointcut{
	@Pointcut("within(com.smart..*)")
	private void inPackage() {}
	
	@Pointcut("execution(* greetTo(..))")
	private void greetTo() {}
	
	@Pointcut("inPackage() and greetTo()")
	protected void inPkgGreetTo() {}
}