package com.smart.aspectJ.example;
import com.smart.aspectJ.anno.*;
public class NaiveWaiter implements Waiter{
	public void greetTo(String clientname) {
		System.out.println("NaiveWaiter:greet to " + clientname + "...");
	}
	public void serveTo(String clientname) {
		System.out.println("NaiveWaiter:serving "+ clientname + "...");
	}
}