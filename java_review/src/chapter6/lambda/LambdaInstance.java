package chapter6.lambda;

import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class LambdaInstance{
	public static void main(String[] args) throws InterruptedException {
		repeatMessage("XXX", 1000);
		System.out.println("now the text has been destroyed");
		Thread.currentThread().sleep(4000);
	}
	public static void repeatMessage(String text, int delay) {
		ActionListener listener = even ->
		{
			System.out.println(text);
			Toolkit.getDefaultToolkit().beep();
			
		};
		new Timer(1000, listener).start();
	}
	
	public static void countDown(int start, int delay) {
		ActionListener listener = event ->
		{
			//start--;//error lambda can't capture the instance which is not final or effectively final
			System.out.println(start);
		};
		new Timer(1000, listener);
	}
	
	public static void repeat(String text, int delay) {
		for (int i = 0;i <= 2;i++) {
			text = text.concat(""+i);
			ActionListener listener = event ->
			{
				//System.out.println(text);//error , reason is same as countDown
			};
			new Timer(delay, listener);
		}
	}
	
}