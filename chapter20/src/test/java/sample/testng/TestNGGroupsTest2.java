package sample.testng;

import org.testng.annotations.Test;

@Test(groups = {"class-groups"})
public class TestNGGroupsTest2{
	
	@Test(groups = {"group1", "group2"})
	public void testMethod3() {
		System.out.println("method 3 in test 2");
	}
	
    @Test(groups = {"group1", "group2"})
    public void testMethod4() {
    	System.out.println("method 4 in test 2");
    }

    @Test(groups = {"group3"})
    public void testMethod5() {
    	System.out.println("method 5 in test 2");
    }
}