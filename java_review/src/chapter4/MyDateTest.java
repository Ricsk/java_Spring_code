package chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

public class MyDateTest{
	public static void main(String[] args) {
		//基本操作
		/*Date deadline;
		deadline = new Date();
		System.out.println(deadline);
		System.out.println(LocalDate.now());
		LocalDate newYearsEve = LocalDate.of(1992, 12, 31);
		System.out.println(newYearsEve);
		LocalDate aThousandDaysLater = newYearsEve.plusDays(1000);
		System.out.println(aThousandDaysLater);*/
		
		//打印当月日历
		LocalDate today = LocalDate.now();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		today = today.minusDays(day - 1);
		DayOfWeek week = today.getDayOfWeek();
		int weekvalue = week.getValue();
		
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for(int i = 1;i < weekvalue;i++)
			System.out.print("    ");
		while(today.getMonthValue() == month) {
			System.out.printf("%3d", today.getDayOfMonth());
			if(today.getDayOfMonth() == day) 
				System.out.print("*");
			else
				System.out.print(" ");
			today = today.plusDays(1);
			if(today.getDayOfWeek().getValue() == 1) 
				System.out.println();
		}
	}
}