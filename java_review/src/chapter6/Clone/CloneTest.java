package chapter6.Clone;

import chapter6.interfaces.Employee;

public class CloneTest{
	public static void main(String[] args) {
		//Employee original = new Employee("Harry", 50000);
		//Employee copy = original.clone();//error
		//String a = "aa";
		//a = "bb";
		//System.out.println(a);
		
		try {
			Employee original = new Employee("John Q. Public", 50000);
			original.setHireDay(2000, 1, 1);
			Employee copy = original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			System.out.println(original);
			System.out.println(copy);
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}