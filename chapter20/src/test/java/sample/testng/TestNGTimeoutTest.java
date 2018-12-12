package sample.testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import com.smart.domain.User;

public class TestNGTimeoutTest{
	
	private User user;
	@BeforeClass
	public void init() {
		user = new User("admin", "123456");
	}
	
	@Test(enabled = false, timeOut = 10)
	public void testUser() {
		assertNotNull(user);
		assertEquals("admin", user.getUserName());
	}
	
}