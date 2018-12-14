package sample.unitils;

import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import com.smart.domain.User;
public class AssertLenientEqualsTest{
	@Test
	public void testLenientEquals() {
		Integer[] orderList1 = new Integer[] {1, 2, 3};
		Integer[] orderList2 = new Integer[] {3, 2, 1};
		int[] orderList2_1 = new int[] {1, 2, 3};
		int[] orderList2_2 = new int[] {1, 3, 2};
		
		//ReflectionAssert.assertReflectionEquals(orderList1, orderList2, ReflectionComparatorMode.LENIENT_ORDER);
		ReflectionAssert.assertReflectionEquals(orderList2_1, orderList2_2, ReflectionComparatorMode.LENIENT_ORDER);//ok
		ReflectionAssert.assertLenientEquals(orderList1, orderList2);
		
		User user = new User("tom", "1234");
		User user2 = new User("tom", "1234");
		ReflectionAssert.assertLenientEquals(user, user2);
	}
}