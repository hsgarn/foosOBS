package com.midsouthfoosball.foosobs;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class MainJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public final static int ONE_SECOND = 1000;
	private JTextField txtTournamentName;
	private JTextField txtEventName;
	private JTextField txtTeam1;
	private JTextField txtTeam2;
	private JTextField txtGameCount1;
	private JTextField txtGameCount2;
	private JTextField txtScore1;
	private JTextField txtScore2;
	private JTextField txtTimeOut1;
	private JTextField txtTimeOut2;
	private int maxGameCount = 3, maxTimeOut = 2, maxScore = 9;
	JButton btnGameTimer;
	Timer timer;
	JLabel lblTimerDisplay;

	/**
	 * Create the panel.
	 */

	public MainJPanel() {
		setLayout(new MigLayout("", "[71.00][grow][75.00][][71.00][grow][72.00][]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblTournamentName = new JLabel("Tournament:");
		add(lblTournamentName, "flowx,cell 1 0,alignx center");
		
		JLabel lblEvent = new JLabel("Event:");
		add(lblEvent, "cell 5 0,alignx center");
		
		txtTournamentName = new JTextField();
		txtTournamentName.setText("High Pockets Monday Night");
		add(txtTournamentName, "flowy,cell 1 1,growx");
		txtTournamentName.setColumns(10);
		
		JButton btnTournamentNameClear = new JButton("X");
		btnTournamentNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTournamentName.setText(null);
			}
		});
		add(btnTournamentNameClear, "cell 2 1,alignx left");
		
		JSeparator separator = new JSeparator();
		add(separator, "cell 3 1");
		
		txtEventName = new JTextField();
		txtEventName.setText("DYP #1");
		add(txtEventName, "flowx,cell 5 1,growx");
		txtEventName.setColumns(10);
		
		JButton btnTeam2Clear = new JButton("X");
		btnTeam2Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEventName.setText(null);
			}
		});
		add(btnTeam2Clear, "cell 6 1,alignx left");
		
		JLabel lblTeam1 = new JLabel("Team 1:");
		add(lblTeam1, "cell 1 2,alignx center");
		
		JLabel lblTeam2 = new JLabel("Team 2:");
		add(lblTeam2, "cell 5 2,alignx center");
		
		JLabel lblName1 = new JLabel("Name:");
		add(lblName1, "cell 0 3,alignx right");
		
		txtTeam1 = new JTextField();
		add(txtTeam1, "cell 1 3,growx");
		txtTeam1.setColumns(10);
		
		JButton btnTeam1Clear = new JButton("X");
		btnTeam1Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeam1.setText(null);
			}
		});
		add(btnTeam1Clear, "cell 2 3,alignx left,aligny bottom");
		
		JButton btnTeamSwitch = new JButton("<->");
		btnTeamSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtTeam1.getText();
				txtTeam1.setText(txtTeam2.getText());
				txtTeam2.setText(temp1);
			}
		});
		add(btnTeamSwitch, "cell 3 3,alignx center");
		
		JLabel lblName2 = new JLabel("Name:");
		add(lblName2, "cell 4 3,alignx right");
		
		txtTeam2 = new JTextField();
		add(txtTeam2, "flowx,cell 5 3,growx");
		txtTeam2.setColumns(10);
		
		JButton btnEventClear = new JButton("X");
		btnEventClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeam2.setText(null);
			}
		});
		add(btnEventClear, "cell 6 3,alignx left");
		
		JButton btnTeam1NameSwitch = new JButton("<->");
		btnTeam1NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team = txtTeam1.getText();
				int index = team.indexOf("/");
				if (index>-1) {
				String player1 = team.substring(0,index);
				String player2 = team.substring(index+1);
				txtTeam1.setText(player2+"/"+player1);
				}
			}
		});
		add(btnTeam1NameSwitch, "cell 1 4,alignx center");
		
		JButton btnTeam2NameSwitch = new JButton("<->");
		btnTeam2NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team = txtTeam2.getText();
				int index = team.indexOf("/");
				if (index>-1) {
				String player1 = team.substring(0,index);
				String player2 = team.substring(index+1);
				txtTeam2.setText(player2+"/"+player1);
				}
			}
		});
		add(btnTeam2NameSwitch, "cell 5 4,alignx center");
		
		JLabel lblGameCount1 = new JLabel("Game Count");
		add(lblGameCount1, "cell 1 5,alignx center");
		
		JLabel lblGameCount2 = new JLabel("Game Count");
		add(lblGameCount2, "cell 5 5,alignx center");
		
		JButton btnGameCount1Minus = new JButton("-");
		btnGameCount1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1;
				num1=Integer.parseInt(txtGameCount1.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtGameCount1.setText(Integer.toString(num1));
			}
		});
		add(btnGameCount1Minus, "cell 0 6,growx");
		
		txtGameCount1 = new JTextField();
		txtGameCount1.setText("0");
		add(txtGameCount1, "cell 1 6,growx");
		txtGameCount1.setColumns(10);
		
		JButton btnGameCount1Plus = new JButton("+");
		btnGameCount1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtGameCount1.getText());
				num1=num1+1;
				if (num1>maxGameCount) {
					num1 = maxGameCount;
				}
				txtGameCount1.setText(Integer.toString(num1));
			}
		});
		add(btnGameCount1Plus, "cell 2 6,growx");
		
		JButton btnGameCountSwitch = new JButton("<->");
		btnGameCountSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtGameCount1.getText();
				txtGameCount1.setText(txtGameCount2.getText());
				txtGameCount2.setText(temp1);
			}
		});
		add(btnGameCountSwitch, "cell 3 6,alignx center");
		
		JButton btnGameCount2Minus = new JButton("-");
		btnGameCount2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtGameCount2.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtGameCount2.setText(Integer.toString(num1));
			}
		});
		add(btnGameCount2Minus, "cell 4 6,growx");
		
		txtGameCount2 = new JTextField();
		txtGameCount2.setText("0");
		add(txtGameCount2, "cell 5 6,growx");
		txtGameCount2.setColumns(10);
		
		JButton btnGameCount2Plus = new JButton("+");
		btnGameCount2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtGameCount2.getText());
				num1=num1+1;
				if (num1>maxGameCount) {
					num1 = maxGameCount;
				}
				txtGameCount2.setText(Integer.toString(num1));
			}
		});
		add(btnGameCount2Plus, "cell 6 6,growx");
		
		JLabel lblScore1 = new JLabel("Score");
		add(lblScore1, "cell 1 7,alignx center");
		
		JLabel lblScore = new JLabel("Score");
		add(lblScore, "cell 5 7,alignx center");
		
		JButton btnGameScore1Minus = new JButton("-");
		btnGameScore1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtScore1.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtScore1.setText(Integer.toString(num1));
			}
		});
		add(btnGameScore1Minus, "cell 0 8,growx,aligny top");
		
		txtScore1 = new JTextField();
		txtScore1.setText("0");
		add(txtScore1, "cell 1 8,growx");
		txtScore1.setColumns(10);
		
		JButton btnScore1Plus = new JButton("+");
		btnScore1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtScore1.getText());
				num1=num1+1;
				if (num1>maxScore) {
					num1 = maxScore;
				}
				txtScore1.setText(Integer.toString(num1));
			}
		});
		add(btnScore1Plus, "cell 2 8,growx");
		
		JButton btnScoreSwitch = new JButton("<->");
		btnScoreSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtScore1.getText();
				txtScore1.setText(txtScore2.getText());
				txtScore2.setText(temp1);
			}
		});
		add(btnScoreSwitch, "cell 3 8,alignx center");
		
		JButton btnScore2Minus = new JButton("-");
		btnScore2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtScore2.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtScore2.setText(Integer.toString(num1));
			}
		});
		add(btnScore2Minus, "cell 4 8,growx");
		
		txtScore2 = new JTextField();
		txtScore2.setText("0");
		add(txtScore2, "cell 5 8,growx");
		txtScore2.setColumns(10);
		
		JButton btnScore2Plus = new JButton("+");
		btnScore2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtScore2.getText());
				num1=num1+1;
				if (num1>maxScore) {
					num1 = maxScore;
				}
				txtScore2.setText(Integer.toString(num1));
			}
		});
		add(btnScore2Plus, "cell 6 8,growx");
		
		JLabel lblTimeOut1 = new JLabel("TimeOut");
		add(lblTimeOut1, "cell 1 9,alignx center");
		
		JLabel lblTimeout = new JLabel("TimeOut");
		add(lblTimeout, "cell 5 9,alignx center");
		
		JButton btnTimeOut1Minus = new JButton("-");
		btnTimeOut1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num1;
				num1=Integer.parseInt(txtTimeOut1.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtTimeOut1.setText(Integer.toString(num1));
			}
		});
		add(btnTimeOut1Minus, "cell 0 10,growx");
		
		txtTimeOut1 = new JTextField();
		txtTimeOut1.setText("0");
		add(txtTimeOut1, "cell 1 10,growx");
		txtTimeOut1.setColumns(10);
		
		JButton btnTimeOut1Plus = new JButton("+");
		btnTimeOut1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtTimeOut1.getText());
				num1=num1+1;
				if (num1>maxTimeOut) {
					num1 = maxTimeOut;
				}
				txtTimeOut1.setText(Integer.toString(num1));
			}
		});
		add(btnTimeOut1Plus, "cell 2 10,growx");
		
		JButton btnTimeOutSwitch = new JButton("<->");
		btnTimeOutSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtTimeOut1.getText();
				txtTimeOut1.setText(txtTimeOut2.getText());
				txtTimeOut2.setText(temp1);
			}
		});
		add(btnTimeOutSwitch, "cell 3 10,alignx center");
		
		JButton btnTimeOut2Minus = new JButton("-");
		btnTimeOut2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtTimeOut2.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtTimeOut2.setText(Integer.toString(num1));
			}
		});
		add(btnTimeOut2Minus, "cell 4 10,growx,aligny bottom");
		
		txtTimeOut2 = new JTextField();
		txtTimeOut2.setText("0");
		add(txtTimeOut2, "cell 5 10,growx");
		txtTimeOut2.setColumns(10);
		
		JButton btnTimeOut2Plus = new JButton("+");
		btnTimeOut2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1;
				num1=Integer.parseInt(txtTimeOut2.getText());
				num1=num1+1;
				if (num1>maxTimeOut) {
					num1 = maxTimeOut;
				}
				txtTimeOut2.setText(Integer.toString(num1));
			}
		});
		add(btnTimeOut2Plus, "cell 6 10,growx");
		
		JToggleButton tglbtnReset1 = new JToggleButton("Reset");
		add(tglbtnReset1, "cell 0 11,growx");
		
		JLabel lblReset1 = new JLabel("Reset");
		add(lblReset1, "cell 1 11,alignx center");
		
		JToggleButton tglbtnWarn1 = new JToggleButton(" Warn ");
		add(tglbtnWarn1, "cell 2 11,growx");
		
		JToggleButton tglbtnReset2 = new JToggleButton("Reset");
		add(tglbtnReset2, "cell 4 11,growx");
		
		JLabel lblReset2 = new JLabel("Reset");
		add(lblReset2, "cell 5 11,alignx center");
		
		JToggleButton tglbtnWarn2 = new JToggleButton(" Warn ");
		add(tglbtnWarn2, "cell 6 11,growx");

		JButton button = new JButton("<->");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean sel1 = tglbtnReset1.isSelected();
				tglbtnReset1.setSelected(tglbtnReset2.isSelected());
				tglbtnReset2.setSelected(sel1);
				boolean sel2 = tglbtnWarn1.isSelected();
				tglbtnWarn1.setSelected(tglbtnWarn2.isSelected());
				tglbtnWarn2.setSelected(sel2);
			}
		});
		add(button, "cell 3 11,alignx center");
		
		JButton btnResetTimers = new JButton("Reset");
		add(btnResetTimers, "cell 6 12,growx,aligny bottom");
		
		JButton btnResetGameCounts = new JButton("Reset Game Counts");
		btnResetGameCounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGameCount1.setText("0");
				txtGameCount2.setText("0");
			}
		});
		add(btnResetGameCounts, "cell 1 13,growx");
		
		lblTimerDisplay = new JLabel(" 0.0 ");
		lblTimerDisplay.setOpaque(true);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerDisplay.setFont(new Font("Times New Roman", Font.BOLD, 50));
		add(lblTimerDisplay, "cell 2 13 3 4,alignx center,aligny center");
		
		JLabel lblNonPossession = new JLabel("Shot Timer (2 & 3 row)");
		add(lblNonPossession, "cell 5 13,alignx right");
		
		JButton btnPossessionTimer = new JButton("15.0");
		add(btnPossessionTimer, "cell 6 13,growx");
		
		JButton btnResetScores = new JButton("Reset Scores");
		btnResetScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScore1.setText("0");
				txtScore2.setText("0");
			}
		});
		add(btnResetScores, "cell 1 14,growx");
		
		JLabel lblRowPossession = new JLabel("Pass Timer (5 row)");
		add(lblRowPossession, "cell 5 14,alignx right");
		
		JButton btn5RowTimer = new JButton("10.0");
		add(btn5RowTimer, "cell 6 14,growx,aligny bottom");
		
		JButton btnResetTimeOuts = new JButton("Reset Time Outs");
		btnResetTimeOuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTimeOut1.setText("0");
				txtTimeOut2.setText("0");
			}
		});
		add(btnResetTimeOuts, "cell 1 15,growx");
		
		JLabel lblTimeOutTimer = new JLabel("Time Out Timer");
		add(lblTimeOutTimer, "cell 5 15,alignx right");
		
		JButton btnTimeOutTimer = new JButton("30.0");
		add(btnTimeOutTimer, "cell 6 15,growx");
		
		JButton btnResetAll = new JButton("Reset All");
		btnResetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGameCount1.setText("0");
				txtGameCount2.setText("0");
				txtScore1.setText("0");
				txtScore2.setText("0");
				txtTimeOut1.setText("0");
				txtTimeOut2.setText("0");
				tglbtnReset1.setSelected(false);
				tglbtnReset2.setSelected(false);
				tglbtnWarn1.setSelected(false);
				tglbtnWarn2.setSelected(false);
			}
		});
		add(btnResetAll, "cell 1 16,growx");
		
		JLabel lblGameTimer = new JLabel("Game Timer");
		add(lblGameTimer, "cell 5 16,alignx right");
		
		JCheckBox chckbxAutoUpdate = new JCheckBox("");
		add(chckbxAutoUpdate, "cell 0 17,alignx right");
		
		JLabel lblAutoUpdate = new JLabel("Auto Update");
		add(lblAutoUpdate, "cell 1 17");
		
		JCheckBox chckbxAlwaysOnTop = new JCheckBox("");
		add(chckbxAlwaysOnTop, "cell 2 17,alignx right");
		
		JLabel lblAlwaysOnTop = new JLabel("Always On Top");
		add(lblAlwaysOnTop, "cell 3 17");
		
		JLabel lblRecallTimer = new JLabel("Recall Timer");
		add(lblRecallTimer, "cell 5 17,alignx right");
		
		JButton btnRecallTimer = new JButton("10");
		btnRecallTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnRecallTimer, "cell 6 17,growx");
		
		JLabel lblPath = new JLabel("Path");
		add(lblPath, "cell 0 18,alignx trailing");
		
		JFormattedTextField formattedTxtPath = new JFormattedTextField();
		add(formattedTxtPath, "cell 1 18,growx");
		
		JButton btnAllSwitch = new JButton("<->");
		btnAllSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtTeam1.getText();
				txtTeam1.setText(txtTeam2.getText());
				txtTeam2.setText(temp1);
				String temp2 = txtGameCount1.getText();
				txtGameCount1.setText(txtGameCount2.getText());
				txtGameCount2.setText(temp2);
				String temp3 = txtScore1.getText();
				txtScore1.setText(txtScore2.getText());
				txtScore2.setText(temp3);
				String temp4 = txtTimeOut1.getText();
				txtTimeOut1.setText(txtTimeOut2.getText());
				txtTimeOut2.setText(temp4);
				boolean sel1 = tglbtnReset1.isSelected();
				tglbtnReset1.setSelected(tglbtnReset2.isSelected());
				tglbtnReset2.setSelected(sel1);
				boolean sel2 = tglbtnWarn1.isSelected();
				tglbtnWarn1.setSelected(tglbtnWarn2.isSelected());
				tglbtnWarn2.setSelected(sel2);			}
		});
		add(btnAllSwitch, "cell 3 0,alignx center");
		
		btnGameTimer = new JButton("90.0");
		btnGameTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float count = (float) (Double.parseDouble(btnGameTimer.getText()) * 10);
				lblTimerDisplay.setBackground(Color.GREEN);
				TimeClass tc = new TimeClass(count);
				timer = new Timer(100, tc);
				timer.start();
			}
		});
		add(btnGameTimer, "cell 6 16,growx");
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTournamentName.setText(null);
				txtEventName.setText(null);
				txtTeam1.setText(null);
				txtTeam2.setText(null);
				txtGameCount1.setText("0");
				txtGameCount2.setText("0");
				txtScore1.setText("0");
				txtScore2.setText("0");
				txtTimeOut1.setText("0");
				txtTimeOut2.setText("0");
				tglbtnReset1.setSelected(false);
				tglbtnReset2.setSelected(false);
				tglbtnWarn1.setSelected(false);
				tglbtnWarn2.setSelected(false);
			}
		});
		add(btnClearAll, "cell 3 18,growx");
	}
	
	public class TimeClass implements ActionListener {
		float counter;
//		boolean instanceExists = false;
		
		public TimeClass(float counter) {
//			this.instanceExists = true;
			this.counter = counter;
		}
		
		public void actionPerformed(ActionEvent tc) {
			counter--;
			
			if(counter >= 1) {
				//update btntxt
				lblTimerDisplay.setText(" "+Float.toString(counter / 10)+" ");
			} else {
				timer.stop();
				lblTimerDisplay.setText(" 0.0 ");
				lblTimerDisplay.setBackground(new Color(255, 0, 0));
			}
		}
	}

}
