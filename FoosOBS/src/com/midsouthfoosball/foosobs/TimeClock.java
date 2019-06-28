package com.midsouthfoosball.foosobs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class TimeClock {
	private int nbrOfSeconds;
	private int timeRemaining;
	private Timer timer;
	
	public TimeClock() {
		ActionListener action = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				timeRemaining--;
System.out.print(timeRemaining + "\r\n");
 				if(timeRemaining < 1) {
					timer.stop();
				}
			}
		};

		timer = new Timer(100, action);
		timer.setInitialDelay(0);
//		timer.start();
	}
	public void resetTimer(int nbrOfSeconds) {
		this.nbrOfSeconds = nbrOfSeconds;
		this.timeRemaining = this.nbrOfSeconds;
		timer.restart();
	}
	public int getTimeRemaining() {
		return timeRemaining;
	}

}
