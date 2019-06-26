package com.midsouthfoosball.foosobs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class TimeClock implements ActionListener {
	private float nbrOfSeconds;
	private float timeRemaining;
	private Timer tmr;
	
	{
		Timer tmr = new Timer(10,null);
		tmr.start();
		tmr.stop();
	}

	public float getNbrOfSeconds() {
		return nbrOfSeconds;
	}
	public void setNbrOfSeconds(int nbrOfSeconds) {
		this.nbrOfSeconds = nbrOfSeconds;
	}
	public void StartTimer(int nbrOfSeconds) {
		tmr.stop();
		tmr.setDelay(nbrOfSeconds * 10);
	}
	public void ResetTimer(int nbrOfSeconds) {
		tmr.setDelay(nbrOfSeconds);
		tmr.setInitialDelay(nbrOfSeconds);
		tmr.stop();
		tmr.start();
	}
	public void actionPerformed(ActionEvent tc) {
		timeRemaining--;
		
		if(timeRemaining < 1) {
			tmr.stop();
		}
	}
}
