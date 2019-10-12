package com.midsouthfoosball.foosobs;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;

public class TimerWindowJPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblTimerDisplay;
	private int displayWidth = 9;
	private int prefixWidth;
	private int suffixWidth = 3;

	/**
	 * Create the panel.
	 */
	public TimerWindowJPanel(String timeToDisplay, Color backgroundColor) {
		setLayout(new MigLayout("", "[280.00]", "[67.00]"));
		prefixWidth = displayWidth - timeToDisplay.length() - suffixWidth;
		char[] c1 = new char[prefixWidth];
	    Arrays.fill(c1, ' ');
	    char[] c2 = new char[suffixWidth];
	    Arrays.fill(c2, ' ');
		lblTimerDisplay = new JLabel(String.valueOf(c1) + timeToDisplay + String.valueOf(c2));
		lblTimerDisplay.setFont(new Font("Consolas", Font.BOLD, 50));
		lblTimerDisplay.setOpaque(true);
		lblTimerDisplay.setBackground(backgroundColor);
		add(lblTimerDisplay, "cell 0 0,alignx center,aligny baseline");

	}
	
	public void setTimerWindowText(String timeToDisplay) {
		prefixWidth = displayWidth - timeToDisplay.length() - suffixWidth;
		char[] c1 = new char[prefixWidth];
	    Arrays.fill(c1, ' ');
	    char[] c2 = new char[suffixWidth];
	    Arrays.fill(c2, ' ');
		lblTimerDisplay.setText(String.valueOf(c1) + timeToDisplay + String.valueOf(c2));
	}
	
	public void setTimerWindowColor(Color colorToDisplay) {
		lblTimerDisplay.setBackground(colorToDisplay);
	}
}
