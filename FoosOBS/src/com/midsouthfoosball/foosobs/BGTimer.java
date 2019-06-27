package com.midsouthfoosball.foosobs;

import javax.swing.Timer;

public class BGTimer {

	private Timer tmr;
	private int delaySeconds;

	{
		Timer tmr = new Timer(100,null);
		tmr.start();
	}

	public BGTimer(int delaySeconds) {
		this.delaySeconds = delaySeconds;
		tmr.setDelay(this.delaySeconds);
	}
	public void StartTimer(int delaySeconds) {
		tmr.stop();
		tmr.setDelay(delaySeconds * 10);
		tmr.start();
	}
	public void ResetTimer(int delaySeconds) {
		tmr.setDelay(delaySeconds);
		tmr.setInitialDelay(delaySeconds * 10);
		tmr.restart();
	}
	
}

