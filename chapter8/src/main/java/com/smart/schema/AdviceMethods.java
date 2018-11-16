package com.smart.schema;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceMethods{
	public void preGreeting() {
		System.out.println("--how are you--");
	}
	public void postGreeting() {
		System.out.println("--bybe--");
	}
	public void afterReturning(int retVal) {
		System.out.println("--afterReturning--" + retVal+"...");
	}
	public void aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("--start around--");
		pjp.proceed();
		System.out.println("--end around");
	}
	public void afterThrowingMethod(IllegalArgumentException iae) {
		System.out.println("______throw______");
	}
	public void finalMethod() {
		System.out.println("_____final____");
	}
	public void bindParams(int num, String name) {
		System.out.println("---bindParams()----");
		System.out.println("name: " + name + " num: " + num + "...");
		System.out.println("__bindParams()----");
	}
}