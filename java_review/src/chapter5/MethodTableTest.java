package chapter5;

import java.lang.reflect.Method;

public class MethodTableTest{
	public static void main(String[] args)throws Exception{
		Method square = MethodTableTest.class.getMethod("square", double.class);
		//Method sqrt = Math.class.getMethod("sqrt", double.class);
		MethodTableTest m = new MethodTableTest();
		printTable(1, 10, 10, square, m);
		//printTable(1, 10, 10, sqrt);
	}
	
	public  double square(double x) {
		return x*x;
	}
	
	public static void printTable(double from, double to, int n, Method f, Object obj) {
		System.out.println(f);
		double dx = (to - from)/(n - 1);
		for(double x = from;x <= to;x += dx) {
			try {
				double y = (Double)f.invoke(obj, x);
				System.out.printf("%010.4f | %010.4f\n", x, y);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}