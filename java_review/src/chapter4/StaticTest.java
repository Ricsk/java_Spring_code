package chapter4;
/**
 * tests the static
 * 2018.12.3
 * @author Ricsk
 * @version
 */
import java.text.NumberFormat;


/**
 * A {@code StaticTest} object is work for testing the keyword called "static"
 * we test for static field, static method and factory method
 * @version 1.0
 */
public class StaticTest{
	public static void main(String args[]) {
		//静态域
		/*Employee2 emp2 = new Employee2();
		emp2.setId();
		System.out.println(emp2.getId());
		emp2.setId();
		System.out.println(emp2.getId());*/
		//静态方法
//		System.out.println(Employee2.getNextId());
		//工厂方法
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormatter = NumberFormat.getPercentInstance();
		double x = 0.1;
		System.out.println(currencyFormatter.format(x));
		System.out.println(percentFormatter.format(x));
	}
}


/**
 * A {@code Employee2} object represents a Employee with static field called "nextId"
 * @see EmployeeTest.Employee
 * @see <a href="www.baidu.com"/>
 */
class Employee2{
	/**
	 * the static int field
	 */
	private static int nextId = 1;
	private int id;
	public void setId() {
		this.id = Employee2.nextId;
		Employee2.nextId++;
	}
	/**
	 * get this Employee's id
	 * @return the id of this employee
	 */
	public int getId() {
		return this.id;
	}
	//静态方法
	public static int getNextId() {
		return Employee2.nextId;
	}
	//main
	public static void main(String[] args) {
		Employee2[] e = new Employee2[3];
		for(Employee2 x:e) {
			x = new Employee2();
			x.setId();
		}
		System.out.println(Employee2.getNextId());
	}
}