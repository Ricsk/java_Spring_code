package com.smart.aspectJ.example;
import com.smart.aspectJ.advanced.Monitorable;
import com.smart.aspectJ.anno.*;
@Monitorable
public class NaiveWaiter implements Waiter{
	public void greetTo(String clientname) {
		System.out.println("NaiveWaiter:greet to " + clientname + "...");
	}
	public void serveTo(String clientname) {
		System.out.println("NaiveWaiter:serving "+ clientname + "...");
	}
	public void smile(String clientName, int times) {
		System.out.println("NaiveWaiter:smile to " + clientName + " " + times + " times...");
	}
}