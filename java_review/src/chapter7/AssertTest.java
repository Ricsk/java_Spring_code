package chapter7;

import java.util.Scanner;

public class AssertTest{
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int x = in.nextInt();
	//	assert x >= 0:"x >=0";
		assert x >= 0;
		System.out.println(x);
	}
}