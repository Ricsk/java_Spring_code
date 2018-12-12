package chapter6.interfaces;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Cloneable{
	private String name;
	private double salary;
	private Date hireDay;
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		this.hireDay = new Date();
	}
	
	public Employee() {
		
	}
	public double getSalary() {
		return salary;
	}

	public String getName() {
		return name;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	public int compareTo(Employee other) {
		return -Double.compare(salary,  other.salary);
	}
	public String toString() {
		return "name : "+ name + "; salary : " + salary + "; hireday : " + hireDay + ".";
	}
	public void setHireDay(int year, int month, int day) {
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
		System.out.println(newHireDay.toString());
		System.out.println(hireDay.toString());
		hireDay.setTime(newHireDay.getTime());
	}
	public Employee clone() throws CloneNotSupportedException{
		Employee cloned = (Employee)super.clone();
		cloned.hireDay = (Date)hireDay.clone();
		return cloned;
	}
}