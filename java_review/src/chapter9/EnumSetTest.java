package chapter9;

import java.util.EnumMap;
import java.util.EnumSet;

import chapter5.EmployeeBasic;

public class EnumSetTest{
	public static void main(String[] args) {
		EnumSet<WeekDay> weekday = EnumSet.range(WeekDay.MONDAY, WeekDay.FRIDAY);
		EnumMap<WeekDay, EmployeeBasic>personInCharge = new EnumMap<>(WeekDay.class);
		personInCharge.put(WeekDay.MONDAY, new EmployeeBasic());
		personInCharge.put(WeekDay.MONDAY, new EmployeeBasic("Lee"));
		personInCharge.forEach((K, V) -> 
				 System.out.println("keys: " + K + " value: " + V));
		
	}
}

enum WeekDay{
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}