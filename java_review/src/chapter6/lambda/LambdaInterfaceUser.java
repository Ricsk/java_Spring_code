package chapter6.lambda;

import java.util.function.IntConsumer;

public class LambdaInterfaceUser{
	public static void repeat(int n, Runnable action) {
		for(int i = 0;i < n;i++) {
			action.run();
		}
	}
	
	public static void repeat(int n, IntConsumer action) {
		for(int i = 0;i < n;i++)
			action.accept(i);
	}
	public static void main(String[] args) {
		repeat(5, () -> 
			System.out.println("runnable")
				);
		repeat(5, (i) -> System.out.println("Countdown: " + (9 - i)));
	}
}