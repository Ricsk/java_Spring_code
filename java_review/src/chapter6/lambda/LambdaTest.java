package chapter6.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class LambdaTest{
	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		//排序lambda
		String[] planets = new String[] {"Mercury", "Venus", "Earth", "Mars",
				"Jupiter", "Saturn", "Uranus", "Neptune"};
		/*System.out.println(Arrays.toString(planets));
		System.out.println("Sorted in dictionary order");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("Sorted by length");
		Comparator<String> comp = (first, second)  -> first.length() - second.length();
		//Arrays.sort(planets, (first, second) -> first.length() - second.length());
		Arrays.sort(planets, comp);
		System.out.println(Arrays.toString(planets));*/
		//定时器lambda
		/*ActionListener listener = (event) -> System.out.println("The time is " + new Date());
		Timer t = new Timer(1000, event ->
			System.out.println("The time is " + new Date())
				);*/
		/*Timer t = new Timer(1000, listener);
		t.start();
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);*/
		
		//函数式接口
		/*ArrayList<String> planets2 = new ArrayList<>(Arrays.asList(planets));
		planets2.removeIf(e -> e.equals( "Earth"));
		System.out.println(Arrays.toString((planets2.toArray())));*/

		//方法引用
		/*Timer t = new Timer(1000, System.out::println);
		t.start();
		Thread.currentThread().sleep(3000);
		t.stop();*/
		/*Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		Arrays.sort(planets, String::compareToIgnoreCase);
		System.out.println(Arrays.toString(planets));*/
		TimedGreeter t = new TimedGreeter();
		t.greet();
	}
	}
class Greeter{
	public void greet(ActionEvent e) {
		System.out.println("Hello, world!");
	}
}

class TimedGreeter extends Greeter{
	public  void greet() throws InterruptedException {
		Timer t = new Timer(1000, super::greet);
		t.start();
		Thread.currentThread().sleep(2000);
		t.stop();
	}
}
