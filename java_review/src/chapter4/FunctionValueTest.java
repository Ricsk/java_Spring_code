package chapter4;

/**
 * tests the FuctionValue
 * 2018.12.3
 * @author Ricsk
 */
public class FunctionValueTest{
	public static void stripleValue(double x) {// not work
		x = 3*x;
	}
	public static void tripleSalary(Employee x) {
		x.raiseSalary(200);
	}
	public static void Swap(Employee x, Employee y) {
		Employee temp = x;
		x = y;
		y = temp;
	}
	public static void main(String args[]) {
		//方法参数之基本数据类型
		/*double x = 3.0;
		stripleValue(x);
		System.out.println(x);*/
		//方法参数之对象参数
	/*	Employee harry = new Employee("harry", 100.0, 1990, 1, 1);
		tripleSalary(harry);
		double salary = harry.getSalary();
		System.out.println(salary);*/
		//方法参数之对象参数深入
		Employee A = new Employee("A", 100.0, 1990, 1, 1);
		Employee B = new Employee("B", 100, 1990, 1, 1);
		Swap(A, B);
		System.out.println(A.getName());
		System.out.println(B.getName());
	}
}