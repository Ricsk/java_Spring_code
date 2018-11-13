package com.smart.aspectJ.fun;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TestAspect{
	//@AfterReturning("@annotation(com.smart.aspectJ.anno.NeedTest)")
	@AfterReturning("this(com.smart.aspectJ.basic.Seller)")
	public void needTestFun() {
		System.out.println("needTestFun() executed!"); 
	}
}