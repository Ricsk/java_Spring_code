package com.smart.aspectJ.basic;
public class SmartSeller implements Seller{
	public int sell(String goods, String name) {
		System.out.println("SmartSeller: sell " + goods + " to " + name);
		return 100;
	}
	
	public void checkBill(int billId) {
		if(billId == 1) throw new IllegalArgumentException("iae Exception");
		else throw new RuntimeException("re Exception");
	}
}