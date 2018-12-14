package chapter6.innerClass;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

public class AnonymousInnerClassTest{
	public static void main(String[] args) {
		TalkingClock3 clock = new TalkingClock3();
		clock.start(1000, true);
		
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

class TalkingClock3{
	public void start(int interval, boolean beep) {
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("At the tone, the time is " + new Date());
				if(beep) {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		};
		Timer t = new Timer(interval, listener);
		t.start();
		
	}
}