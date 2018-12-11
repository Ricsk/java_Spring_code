package chapter5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CopyOfTest{
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		a = (int[])goodCopyOf(a, 10);
		System.out.println(Arrays.toString(a));
		
		String[] b = {"Tom", "Dick", "Harry" };
		b = (String[])goodCopyOf(b,10);
		System.out.println(Arrays.toString(b));
		
		System.out.println("The foolowing call will generate an exception");
		b = (String[])badCopyOf(b,10);
	}
	public static Object[] badCopyOf(Object[] a, int newlength) {
		Class cl = a.getClass();
		System.out.println(cl.toString());
		Object[] newArray = new Object[newlength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newlength));
		return newArray;
	}
	public static Object goodCopyOf(Object a, int newLength) {
		Class cl = a.getClass();
		System.out.println(cl.toString());
		if(!cl.isArray())
			return null;
		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		Object newArray = Array.newInstance(componentType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
	}
}