package sample.testng;

import org.testng.annotations.Test;

@Test(groups = {"class-group"})
public class TestNGGroupsTest1{
	
	@Test(groups = {"group1", "group2"})
	public void testMethod1() {
		System.out.println("method 1 in test 1");
	}
	
	@Test(groups = {"group1", "group2"})
	public void testMethod2() {
		System.out.println("method 2 in test 1");
	}
	
	@Test(groups = {"group1"})
	public void testMethod3() {
		System.out.println("method 3 in test 1");
	}
	
	
}