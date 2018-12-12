package sample.testng;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;
import com.smart.domain.User;

public class TestNGExceptionTest{
	private User user;
	@BeforeClass
	public void init() {
		user = null;
	}
	
	@Test(enabled = false, expectedExceptions = NullPointerException.class)
	public void testUser() {
		assertNotNull(user.getUserName());
	}
}