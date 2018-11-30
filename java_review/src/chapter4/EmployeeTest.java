package chapter4;

import java.time.LocalDate;

/**
 * tests the Employee class (from book)
 * 2018.11.30
 * @author Ricsk
 */
public class EmployeeTest{
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee();
		staff[1] = new Employee();
		staff[2] = new Employee();
		
		for(Employee e:staff) {
			System.out.println("name: " + e.getName() + ",salary=" + e.getSalary() + ",hirDay="+e.getHireDay());
		}
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		for(Employee e:staff) {
			e.raiseSalary(5);
		}
		for(Employee e:staff) {
			System.out.println("name: " + e.getName() + ",salary=" + e.getSalary() + ",hirDay="+e.getHireDay());
		}
		
		System.out.println(staff[0].equals(staff[2]));
	}
}
class Employee{
	private String name;
	private double salary;
	private LocalDate hireDay;
	
	public Employee(String name, double s, int year, int month, int day) {
		this.name = name;
		this.salary = s;
		this.hireDay = LocalDate.of(year, month, day);
	}
	
	public Employee() {}
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public LocalDate getHireDay() {
		return hireDay;
	}
	public void raiseSalary(double byPercent) {
		double raise = salary*(1+byPercent/100.0);
		this.salary = raise;
	}
	
	public boolean equals(Employee other) {
		return this.name.equals(other.name);
	}
}