package chapter5;
import java.lang.Object;
public class ObjectTest{
	public static void main(String[] args) {
		Object obj = new EmployeeBasic();
		EmployeeBasic[] staff = new EmployeeBasic[10];
		obj = staff;
		obj = new int[10];
	}
}