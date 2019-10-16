/**
Copyright 2019 Hugh Garner
Permission is hereby granted, free of charge, to any person obtaining a copy 
of this software and associated documentation files (the "Software"), to deal 
in the Software without restriction, including without limitation the rights 
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
copies of the Software, and to permit persons to whom the Software is 
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in 
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR 
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR 
OTHER DEALINGS IN THE SOFTWARE.  
**/
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
