package chapter6.interfaces;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EmployeeSortTest{
	public static void main(String[] args) {
		Employee[] staff = new Employee[3];
		
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 36000);
		staff[2] = new Employee("Tony Tester", 37000);
		
		//Arrays.sort(staff);
		Arrays.sort(staff, (first, second) ->
			first.getName() .compareTo(second.getName())
				);
		for(Employee e : staff) {
			System.out.println(e);
		}
		
		/*Comparable x;//ok
		//x = new Comparable();//error
		x = new Employee();//ok
		System.out.println(x instanceof Comparable);*/
		
	}
}

interface Moveable{
	void move(double x, double y);
	default int walk() {//默认方法
		return 1;
	}
	static int run() {//静态方法
		return 2;
	}
}
class Moveables implements Moveable{
	//不用实现默认方法和静态方法
	public void move(double x, double z) {
		walk();
		Moveable.run();
	}
	
}
interface Moveable2{
	void move2(double x);
}
interface Powered extends Moveable, Moveable2{
	double SPEED_LIMIT = 95;
	double milesPerGallon();
}

