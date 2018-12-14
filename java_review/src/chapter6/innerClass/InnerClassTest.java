package chapter6.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Timer;


public class InnerClassTest{
	public static void main(String[] args) throws InterruptedException {
		TalkingClock clock = new TalkingClock(1000, true, 3001);
		clock.start();
		//TalkingClock jabberer = new TalkingClock(1000, true, 3001);
		//TalkingClock.TimePrinter listener = jabberer.new TimePrinter();//ok if TimePrinter is a public class
	
	}
}

class TalkingClock{
	private int interval;
	private boolean beep;
	private int millis;
	
	public TalkingClock(int interval, boolean beep,  int millis) {
		this.interval = interval;
		this.beep = beep;
		this.millis = millis;
	}
	
	public void start() throws InterruptedException {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
		Thread.currentThread().sleep(millis);
		t.stop();
	}
	
	private class TimePrinter implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			System.out.println("At the tone, the time is " + new Date());
			//if(beep)
			if(TalkingClock.this.beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}