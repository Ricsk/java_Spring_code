package chapter5;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeBasic extends Person
{
   private double salary;
   private LocalDate hireDay;
   public EmployeeBasic(String n, double s, int year, int month, int day)
   {
      super(n);
      salary = s;
      hireDay = LocalDate.of(year, month, day);
   }
   public EmployeeBasic() {
	   
   }
   public EmployeeBasic(String name) {
	   super(name);
   }
   public double getSalary()
   {
      return salary;
   }

   public LocalDate getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   
   public String getDescription() {
	   return String.format("an employee with a salary of $%.2f", salary);
   }
   
   public boolean equals(Object otherObject) {
	   if(this == otherObject) 
		   return true;
	   if(otherObject == null)
		   return false;
	   if(getClass() != otherObject.getClass())
		   return false;
	   EmployeeBasic other = (EmployeeBasic)otherObject;
	   /*return super.getName().equals(other.getName())
			   && salary == other.salary
			   && hireDay.equals(other.hireDay);*/
	   return Objects.equals(super.getName(),  other.getName())
			   && salary == other.salary
			   && Objects.equals(this.hireDay, other.hireDay);
   }
   
   public int hashCode() {
	   /*return 7 * name.hashCode()
			   + 11 * new Double(salary).hashCode()
			   + 13 * hireDay.hashCode();*/
	   
	   /*return 7 * Objects.hashCode(super.getName())
			   + 11 * Double.hashCode(salary)
			   + 13 * Objects.hashCode(hireDay);*/
	   return Objects.hash(super.getName(), salary, hireDay);
   }
   
   public String toString() {
	   return getClass().getName() + "[name=" + super.getName() + ",salary=" + salary + ",hirDay=" + hireDay + "]";
   }
}