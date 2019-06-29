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
//System.out.print(timeRemaining + "\r\n");
 				if(timeRemaining < 1) {
					timeRemaining = 0;
				}
			}
		};

		timer = new Timer(100, action);
		timer.setInitialDelay(0);
	}
	public void resetTimer(int nbrOfSeconds) {
		this.nbrOfSeconds = nbrOfSeconds;
		this.timeRemaining = this.nbrOfSeconds;
		timer.restart();
	}
	public int getTimeRemaining() {
		return timeRemaining;
	}
	public int getNbrOfSeconds() {
		return nbrOfSeconds;
	}
	public void addTimeClockTimerListener(ActionListener alAction) {
		timer.addActionListener(alAction);
	}

}
