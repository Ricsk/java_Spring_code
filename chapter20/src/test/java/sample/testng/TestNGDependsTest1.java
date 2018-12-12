package sample.testng;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test(groups = {"class-groupNO"})
public class TestNGDependsTest1{
	@Test(dependsOnMethods = { "testMethod1", "testMethod2"} )
	public void testMethod3() {
		System.out.println("testMethod3");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
	}
}