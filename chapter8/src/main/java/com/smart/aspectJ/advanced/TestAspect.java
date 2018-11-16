package com.smart.aspectJ.advanced;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.smart.aspectJ.example.Waiter;

@Aspect
public class TestAspect{
/*	@After("within(com.smart..*) "
			+ " and execution(* greetTo(..))")
	public void greetToFun() {
		System.out.println("--greetToFun() executed!--");
		
	}
	
	@Before(" !target(com.smart.aspectJ.example.NaiveWaiter) "+
			" and execution(* serveTo(..))")
	public void notServeInNaiveWaiter() {
		System.out.println("--notServeInNaiveWaiter() executed!--");
		
	}
	@AfterReturning("target(com.smart.aspectJ.example.Waiter)"+
			" or target(com.smart.aspectJ.basic.Seller)")
	public void waiterOrSeller() {
		System.out.println("--waiterOrSeller() executed!--");
	}*/
/*	@Before("TestNamePointcut.inPkgGreetTo()")
	public void pkGreetTo() {
		System.out.println("--pkgGreetTo() exectued!--");
	}
	@Before("!target(com.smart.aspectJ.example.NaiveWaiter) && TestNamePointcut.inPkgGreetTo()")
	public void pkgGreetToNotNaiveWaiter() {
		System.out.println("--pkgGreetToNotNaiveWaiter() executed!--");
	}*/
/*	@Around("execution(* greetTo(..)) and target(com.smart.aspectJ.example.NaiveWaiter)")
	public void joinPointAccess(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("-----joinPointAccess-----");
		System.out.println("arg[0]:" + pjp.getArgs()[0]);
		System.out.println("signature:" + pjp.getTarget().getClass());
		pjp.proceed();
		System.out.println("-----joinPointAccess-----");
	}*/
/*	@Before("target(com.smart.aspectJ.example.NaiveWaiter) and args(name,num,..)")
	public void bindJoinPointParams(int num, String name) {
		System.out.println("----bindJoinPointParams()-----");
		System.out.println("name:"+name);
		System.out.println("num:"+num);
		System.out.println("----bindJoinPointParams()-----");
	}*/
/*//	@Before("target(waiter)")
	@Before("@within(m)")
//	public void bindProxyObj(Waiter waiter) {
	public void bindTypeAnnoObject(Monitorable m) {
		System.out.println("-----bindProxyObj()-----");
		System.out.println(m.getClass().getName());
		System.out.println("----bindProxyObje()-----");
	}*/
	/*@AfterReturning(value="target(com.smart.aspectJ.basic.SmartSeller)", returning="retVal")
	public void bingReturnValue(int retVal) {
		System.out.println("----bindException()-----");
		System.out.println("returnValue"+retVal);
		System.out.println("-----bindException()-----");
	}*/
	@AfterThrowing(value="target(com.smart.aspectJ.basic.SmartSeller)", throwing="iae")
	public void bindException(IllegalArgumentException iae) {
		System.out.println("-----bindException()-----");
		System.out.println("exception:" + iae.getMessage());
		System.out.println("-----bindException()-----");
	}
}