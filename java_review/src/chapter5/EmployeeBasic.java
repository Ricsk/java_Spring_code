package chapter5;

import java.time.LocalDate;

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
	   return super.getName().equals(other.getName())
			   && salary == other.salary
			   && hireDay.equals(other.hireDay);
   }
}