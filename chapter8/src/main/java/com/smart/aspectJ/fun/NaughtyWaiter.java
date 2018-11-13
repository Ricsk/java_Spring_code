package com.smart.aspectJ.fun;
import com.smart.aspectJ.anno.*;
import com.smart.aspectJ.example.*;
public class NaughtyWaiter implements Waiter{
	@NeedTest
	public void greetTo(String clientname) {
		System.out.println("NaughtyWaiter:greet to " + clientname + "...");
	}
	public void serveTo(String clientname) {
		System.out.println("NaughtyWaiter:serving "+ clientname + "...");
	}
}