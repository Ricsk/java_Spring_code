package chapter6.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;


public class PartInnerClassTest{
	public static void main(String[] args) throws InterruptedException {
		TalkingClock2 tc = new TalkingClock2();
		tc.start(1000, true);
	}
	
	
}
class TalkingClock2{
	//beep should have been final
	public void start(int interval, boolean beep) throws InterruptedException {
		
		class TimePrinter implements ActionListener{
			private int x;
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is " + new Date());
				if(beep)
					Toolkit.getDefaultToolkit().beep();
			}
		}
		
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
		Thread.currentThread().sleep(4001);
		t.stop();
	}
}