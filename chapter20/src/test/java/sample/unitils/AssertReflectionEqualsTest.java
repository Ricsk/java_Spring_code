package sample.unitils;

import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import com.smart.domain.User;

public class AssertReflectionEqualsTest{
	
	@Test
	public void testReflection() {
		User user1 = new User("tom", "1234");
		User user2 = new User("tom", "1234");
		ReflectionAssert.assertReflectionEquals(user1, user2);
		
		User user = new User("tom", "1234");
		ReflectionAssert.assertPropertyReflectionEquals("userName", "tom", user);
		ReflectionAssert.assertPropertyLenientEquals("lastVisit", null, user);
	}
}