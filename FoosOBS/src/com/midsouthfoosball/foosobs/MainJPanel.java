package com.midsouthfoosball.foosobs;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

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
	private JToggleButton tglbtnReset1;
	private JToggleButton tglbtnReset2;
	private JToggleButton tglbtnWarn1;
	private JToggleButton tglbtnWarn2;
	private JFormattedTextField formattedTxtPath;
//	private File configFile = new File("config.properties");
	public Properties configProps;
	private int maxGameCount = 3, maxTimeOut = 2, maxScore = 9;
	private int shotTimerValue = 15, passTimerValue = 10, timeOutTimerValue = 30, gameTimerValue = 90, recallTimerValue = 10;
	private String defaultFilePath = "c:\\temp";
	private JButton btnGameTimer;
	private JButton btnPossessionTimer;
	private JButton btn5RowTimer;
	private JButton btnTimeOutTimer;
	private JButton btnRecallTimer;
	private JLabel lblTimerDisplay;
	private JLabel lblTimerInUse;
	TimeClock timeClock;
	ActionListener alAction;
	OBSInterface obsInterface;
	Settings foosObsSettings;
	JFrame f;
	/**
	 * Create the panel.
	 **/
    public MainJPanel(JFrame f) throws IOException {
    	timeClock = new TimeClock();
		obsInterface = new OBSInterface();
		initProperties();
		foosObsSettings = new Settings(configProps);
		try {
			loadProperties();
		} catch (IOException ex) {
			System.out.print("The config.properties file does not exist, default properties loaded.\r\n");
		}
		foosObsSettings.loadFromConfig(configProps);
		
		setLayout(new MigLayout("", "[90.00][135.00,grow][90.00][][90.00][135.00,grow][90.00]", "[][][][][][][][][][][][][][][][][][][][]"));
		String logoURL = new String("/imgs/MidsouthFoosballLogo4.png");
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(logoURL));
		
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel lblLogo = new JLabel(imageIcon);
		lblLogo.setBackground(Color.BLACK);
		lblLogo.setOpaque(true);
		add(lblLogo, "cell 0 0 1 4");
	
		JLabel lblLogo2 = new JLabel(imageIcon);
		lblLogo2.setBackground(Color.BLACK);
		lblLogo2.setOpaque(true);
		add(lblLogo2, "cell 6 0 1 4");
		
		JLabel lblTournamentName = new JLabel("Tournament:");
		add(lblTournamentName, "flowx,cell 1 0,alignx center");
		
		JLabel lblEvent = new JLabel("Event:");
		add(lblEvent, "cell 5 0,alignx center");
		
		txtTournamentName = new JTextField();
		txtTournamentName.setHorizontalAlignment(SwingConstants.CENTER);
		txtTournamentName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeTournamentName();
			    }
			}
		});
		txtTournamentName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				writeTournamentName();
			}
		});
		txtTournamentName.setText("High Pockets Monday Night");
		add(txtTournamentName, "flowy,cell 1 1,growx");
		txtTournamentName.setColumns(10);
		
		JButton btnTournamentNameClear = new JButton("X");
		btnTournamentNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTournamentName();
			}
		});
		add(btnTournamentNameClear, "cell 2 1,alignx left");
		
		JSeparator separator = new JSeparator();
		add(separator, "flowx,cell 3 1");
		
		txtEventName = new JTextField();
		txtEventName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeEventName();
			    }
			}
		});
		txtEventName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				writeEventName();
			}
		});
		txtEventName.setText("DYP #1");
		add(txtEventName, "flowx,cell 5 1,growx");
		txtEventName.setColumns(10);
		
		JButton btnEventClear = new JButton("X");
		btnEventClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearEventName();
			}
		});
		add(btnEventClear, "cell 4 1,alignx right");
		
		JLabel lblTeam1 = new JLabel("Team 1:");
		add(lblTeam1, "cell 1 3,alignx center");
		
		JLabel lblTeam2 = new JLabel("Team 2:");
		add(lblTeam2, "cell 5 3,alignx center");
		
		JLabel lblName1 = new JLabel("Name");
		add(lblName1, "cell 0 4,alignx right");
		
		txtTeam1 = new JTextField();
		txtTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeTeam1Name();
			    }
			}
		});
		txtTeam1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	writeTeam1Name();
			}
		});
		add(txtTeam1, "cell 1 4,growx");
		txtTeam1.setColumns(10);
		
		JButton btnTeam1Clear = new JButton("X");
		btnTeam1Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTeam1Name();
			}
		});
		add(btnTeam1Clear, "cell 2 4,alignx left,aligny bottom");
		
		JButton btnTeamSwitch = new JButton("<-> [e]");
		btnTeamSwitch.setMnemonic('e');
		btnTeamSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeamNames();
			}
		});
		add(btnTeamSwitch, "cell 3 4,alignx center");
		
		txtTeam2 = new JTextField();
		txtTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeTeam2Name();
			    }
			}
		});
		txtTeam2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	writeTeam2Name();
			}
		});
		
		JButton btnTeam2Clear = new JButton("X");
		btnTeam2Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	clearTeam2Name();
			}
		});
		add(btnTeam2Clear, "cell 4 4,alignx right");
		add(txtTeam2, "flowx,cell 5 4,growx");
		txtTeam2.setColumns(10);
		
		JButton btnTeam1NameSwitch = new JButton("<-> [t]");
		btnTeam1NameSwitch.setMnemonic('t');
		btnTeam1NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeam1Names();
			}
		});
		
		JLabel lblName2 = new JLabel("Name");
		add(lblName2, "cell 6 4,alignx left");
		add(btnTeam1NameSwitch, "cell 1 5,alignx center");
		
		JButton btnTeam2NameSwitch = new JButton("<-> [m]");
		btnTeam2NameSwitch.setMnemonic('m');
		btnTeam2NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeam2Names();
			}
		});
		add(btnTeam2NameSwitch, "cell 5 5,alignx center");
		
		JLabel lblGameCount1 = new JLabel("Game Count");
		add(lblGameCount1, "cell 1 6,alignx center");
		
		JLabel lblGameCount2 = new JLabel("Game Count");
		add(lblGameCount2, "cell 5 6,alignx center");
		
		JButton btnGameCount1Minus = new JButton("-");
		btnGameCount1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decrementGameCount1();
			}
		});
		add(btnGameCount1Minus, "cell 0 7,growx");
		
		txtGameCount1 = new JTextField();
		txtGameCount1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount1.setText("0");
		txtGameCount1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeGameCount1();
			    }
			}
		});
		txtGameCount1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				writeGameCount1();
			}
		});
		add(txtGameCount1, "cell 1 7,growx");
		txtGameCount1.setColumns(10);
		
		JButton btnGameCount1Plus = new JButton("+ [5]");
		btnGameCount1Plus.setMnemonic('5');
		btnGameCount1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementGameCount1();
			}
		});
		add(btnGameCount1Plus, "cell 2 7,growx");
		
		JButton btnGameCountSwitch = new JButton("<->");
		btnGameCountSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchGameCount();
			}
		});
		add(btnGameCountSwitch, "cell 3 7,growx");
		
		JButton btnGameCount2Minus = new JButton("-");
		btnGameCount2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementGameCount2();
			}
		});
		add(btnGameCount2Minus, "cell 4 7,growx");
		
		txtGameCount2 = new JTextField();
		txtGameCount2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount2.setText("0");
		txtGameCount2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeGameCount2();
		    	}
			}
		});
		txtGameCount2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	writeGameCount2();
			}
		});
		add(txtGameCount2, "cell 5 7,growx");
		txtGameCount2.setColumns(10);
		
		JButton btnGameCount2Plus = new JButton("+ [6]");
		btnGameCount2Plus.setMnemonic('6');
		btnGameCount2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementGameCount2();
			}
		});
		add(btnGameCount2Plus, "cell 6 7,growx");
		
		JLabel lblScore1 = new JLabel("Score");
		add(lblScore1, "cell 1 8,alignx center");
		
		JLabel lblScore = new JLabel("Score");
		add(lblScore, "cell 5 8,alignx center");
		
		JButton btnGameScore1Minus = new JButton("-");
		btnGameScore1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementScore1();
			}
		});
		add(btnGameScore1Minus, "cell 0 9,growx,aligny top");
		
		txtScore1 = new JTextField();
		txtScore1.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore1.setText("0");
		txtScore1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeScore1();
		    	}
			}
		});
		txtScore1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	writeScore1();
			}
		});
		add(txtScore1, "cell 1 9,growx");
		txtScore1.setColumns(10);
		
		JButton btnScore1Plus = new JButton("+ [1]");
		btnScore1Plus.setMnemonic('1');
		btnScore1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementScore1();
			}
		});
		add(btnScore1Plus, "cell 2 9,growx");
		
		JButton btnScoreSwitch = new JButton("<->");
		btnScoreSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScore();
			}
		});
		add(btnScoreSwitch, "cell 3 9,growx");
		
		JButton btnScore2Minus = new JButton("-");
		btnScore2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementScore2();
			}
		});
		add(btnScore2Minus, "cell 4 9,growx");
		
		txtScore2 = new JTextField();
		txtScore2.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore2.setText("0");
		txtScore2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeScore2();
			    }
			}
		});
		txtScore2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				writeScore2();
			}
		});
		add(txtScore2, "cell 5 9,growx");
		txtScore2.setColumns(10);
		
		JButton btnScore2Plus = new JButton("+ [2]");
		btnScore2Plus.setMnemonic('2');
		btnScore2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementScore2();
			}
		});
		add(btnScore2Plus, "cell 6 9,growx");
		
		JLabel lblTimeOut1 = new JLabel("TimeOut");
		add(lblTimeOut1, "cell 1 10,alignx center");
		
		JLabel lblTimeout = new JLabel("TimeOut");
		add(lblTimeout, "cell 5 10,alignx center");
		
		JButton btnTimeOut1Minus = new JButton("-");
		btnTimeOut1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				decrementTimeOut1();
			}
		});
		add(btnTimeOut1Minus, "cell 0 11,growx");
		
		txtTimeOut1 = new JTextField();
		txtTimeOut1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut1.setText("0");
		txtTimeOut1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeTimeOut1();
			    }
			}
		});
		txtTimeOut1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				writeTimeOut1();
			}
		});
		add(txtTimeOut1, "cell 1 11,growx");
		txtTimeOut1.setColumns(10);
		
		JButton btnTimeOut1Plus = new JButton("+ [9]");
		btnTimeOut1Plus.setMnemonic('9');
		btnTimeOut1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementTimeOut1();
			}
		});
		add(btnTimeOut1Plus, "cell 2 11,growx");
		
		JButton btnTimeOutSwitch = new JButton("<->");
		btnTimeOutSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTimeOut();
			}
		});
		add(btnTimeOutSwitch, "cell 3 11,growx");
		
		JButton btnTimeOut2Minus = new JButton("-");
		btnTimeOut2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				decrementTimeOut2();
			}
		});
		add(btnTimeOut2Minus, "cell 4 11,growx,aligny bottom");
		
		txtTimeOut2 = new JTextField();
		txtTimeOut2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut2.setText("0");
		txtTimeOut2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	writeTimeOut2();
			    }
			}
		});
		txtTimeOut2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	writeTimeOut2();
			}
		});
		add(txtTimeOut2, "cell 5 11,growx");
		txtTimeOut2.setColumns(10);
		
		JButton btnTimeOut2Plus = new JButton("+ [0]");
		btnTimeOut2Plus.setMnemonic('0');
		btnTimeOut2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incrementTimeOut2();
			}
		});
		add(btnTimeOut2Plus, "cell 6 11,growx");
		
		tglbtnReset1 = new JToggleButton("Reset [z]");
		tglbtnReset1.setMnemonic('z');
		tglbtnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeReset1();
			}
		});
		add(tglbtnReset1, "cell 0 12,growx");
		
		tglbtnWarn1 = new JToggleButton(" Warn [x]");
		tglbtnWarn1.setMnemonic('x');
		tglbtnWarn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeWarn1();
			}
		});
		add(tglbtnWarn1, "cell 2 12,growx");
		
		tglbtnReset2 = new JToggleButton("Reset [,]");
		tglbtnReset2.setMnemonic(',');
		tglbtnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeReset2();
			}
		});
		add(tglbtnReset2, "cell 4 12,growx");
		
		tglbtnWarn2 = new JToggleButton(" Warn [.]");
		tglbtnWarn2.setMnemonic('.');
		tglbtnWarn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeWarn2();
			}
		});
		add(tglbtnWarn2, "cell 6 12,growx");

		JButton btnResetSwitch = new JButton("<->");
		btnResetSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchResetWarn();
			}
		});
		add(btnResetSwitch, "cell 3 12,growx");
		
		JButton btnResetGameCounts = new JButton("Reset Game Counts [7]");
		btnResetGameCounts.setMnemonic('7');
		btnResetGameCounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGameCounts();
			}
		});
		add(btnResetGameCounts, "cell 1 13,growx");
		
		JButton btnResetScores = new JButton("Reset Scores [3]");
		btnResetScores.setMnemonic('3');
		btnResetScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetScores();
			}
		});
		
		lblTimerInUse = new JLabel("Timer Reset");
		lblTimerInUse.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTimerInUse, "cell 3 18,growx");
		
		JButton btnResetTimers = new JButton("Reset Timer [r]");
		btnResetTimers.setMnemonic('r');
		btnResetTimers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTimers();
		}
		});
		add(btnResetTimers, "cell 5 13,growx,aligny bottom");
		add(btnResetScores, "cell 1 14,growx");
		
		JButton btnResetTimeOuts = new JButton("Reset Time Outs [-]");
		btnResetTimeOuts.setMnemonic('-');
		btnResetTimeOuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTimeOuts();
			}
		});
		add(btnResetTimeOuts, "cell 1 15,growx");
		
		JButton btnResetResetWarn = new JButton("Reset Reset/Warn");
		btnResetResetWarn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetResetWarns();
			}
		});
		add(btnResetResetWarn, "cell 1 16,growx");
		
		JButton btnResetAll = new JButton("Reset All [a]");
		btnResetAll.setMnemonic('a');
		btnResetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		add(btnResetAll, "cell 1 17,growx");
		
		JButton btnAllSwitch = new JButton("<---------------------[w]--------------------->");
		btnAllSwitch.setMnemonic('w');
		btnAllSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAll();
			}
		});
		add(btnAllSwitch, "cell 2 13 3 1,growx");
		
		lblTimerDisplay = new JLabel(" 0.0 ");
		lblTimerDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerDisplay.setOpaque(true);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerDisplay.setFont(new Font("Times New Roman", Font.BOLD, 50));
		ActionListener alAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateTimerDisplay();
			}
		};
		timeClock.addTimeClockTimerListener(alAction);
		add(lblTimerDisplay, "cell 2 14 3 4,alignx center,aligny center");
		
		JLabel lblNonPossession = new JLabel("Shot Timer (2 & 3 row)");
		add(lblNonPossession, "cell 5 14,alignx right");
		
		btnPossessionTimer = new JButton(shotTimerValue + " [s]");
		btnPossessionTimer.setMnemonic('s');
		btnPossessionTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPossessionTimer();
			}
		});
		add(btnPossessionTimer, "cell 6 14,growx");
		
		JLabel lblRowPossession = new JLabel("Pass Timer (5 row)");
		add(lblRowPossession, "cell 5 15,alignx right");
		
		btn5RowTimer = new JButton(passTimerValue + " [p]");
		btn5RowTimer.setMnemonic('p');
		btn5RowTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start5RowTimer();
			}
		});
		add(btn5RowTimer, "cell 6 15,growx,aligny bottom");
		
		JLabel lblTimeOutTimer = new JLabel("Time Out Timer");
		add(lblTimeOutTimer, "cell 5 16,alignx right");
		
		btnTimeOutTimer = new JButton(timeOutTimerValue + " [o]");
		btnTimeOutTimer.setMnemonic('o');
		btnTimeOutTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTimeOutTimer();
			}
		});
		add(btnTimeOutTimer, "cell 6 16,growx");
		
		JLabel lblGameTimer = new JLabel("Game Timer");
		add(lblGameTimer, "cell 5 17,alignx right");

		btnGameTimer = new JButton(gameTimerValue + " [g]");
		btnGameTimer.setMnemonic('g');
		btnGameTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameTimer();
			}
		});
		add(btnGameTimer, "cell 6 17,growx");

		JLabel lblRecallTimer = new JLabel("Recall Timer");
		add(lblRecallTimer, "cell 5 18,alignx right");
		
		btnRecallTimer = new JButton(recallTimerValue + " [c]");
		btnRecallTimer.setMnemonic('c');
		btnRecallTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startRecallTimer();
			}
		});
		add(btnRecallTimer, "cell 6 18,growx");
		
		formattedTxtPath = new JFormattedTextField(defaultFilePath);
		formattedTxtPath.setText(configProps.getProperty("datapath"));
		formattedTxtPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
					obsInterface.setFilePath(formattedTxtPath.getText());
			    }
			}
		});
		
		JButton btnSelectPath = new JButton("Select Path");
		btnSelectPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				final JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File(formattedTxtPath.getText()));
				chooser.setDialogTitle("Select directory for path");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				int returnVal = chooser.showOpenDialog(MainJPanel.this);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					if (chooser.getSelectedFile().exists()) {
						formattedTxtPath.setText(chooser.getSelectedFile().getAbsolutePath());
					} else {
						String directoryName = chooser.getSelectedFile().getAbsolutePath();
						
						File directory = new File(directoryName);
						if (! directory.exists()) {
							directory.mkdirs();
						}
						formattedTxtPath.setText(chooser.getSelectedFile().getAbsolutePath());
					}
					obsInterface.setFilePath(formattedTxtPath.getText());
					try {
						saveProperties(foosObsSettings, obsInterface);
					} catch (IOException ex) {
						System.out.print("Error saving properties file: " + ex.getMessage());		
					}
				}
			}
		});
		add(btnSelectPath, "cell 0 19,growx");
		add(formattedTxtPath, "cell 1 19,growx");
		
		JButton btnFetch = new JButton("Fetch Data");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchAll();
			}
		});
		add(btnFetch, "cell 3 19,growx");
		
		JButton btnSetPath = new JButton("Set Path");
		btnSetPath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String directoryName = formattedTxtPath.getText();
				
				File directory = new File(directoryName);
				if (! directory.exists()) {
					System.out.print("does not exist\r\n");
					directory.mkdirs();
				}
				obsInterface.setFilePath(formattedTxtPath.getText());
				try {
					saveProperties(foosObsSettings, obsInterface);
				} catch (IOException ex) {
					System.out.print("Error saving properties file: " + ex.getMessage());		
				}
			}
		});
		add(btnSetPath, "cell 2 19,growx");

		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		add(btnClearAll, "cell 3 0,growx");
		
		JCheckBox chckbxAlwaysOnTop = new JCheckBox("Always On Top");
		chckbxAlwaysOnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				f.setAlwaysOnTop(chckbxAlwaysOnTop.isSelected());
			}
		});
		chckbxAlwaysOnTop.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlwaysOnTop.setSelected(f.isAlwaysOnTop());
		add(chckbxAlwaysOnTop, "cell 5 19,alignx right");
		
		JButton btnSaveAll = new JButton("Save All");
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAll();
			}
		});
		add(btnSaveAll, "cell 4 19,growx");
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame settingsFrame = new JFrame("Foos OBS Settings");
				settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				SettingsJPanel p;
				try {
					settingsFrame.setAlwaysOnTop(true);
					p = new SettingsJPanel(foosObsSettings, settingsFrame);
					p.setPreferredSize(new Dimension(350, 225));

					settingsFrame.getContentPane().add(p);
					settingsFrame.pack();
					settingsFrame.setVisible(true);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSettings.setForeground(Color.BLACK);
		btnSettings.setBackground(new Color(0, 255, 255));
		btnSettings.setBounds(92, 100, 125, 23);
		add(btnSettings, "cell 6 19,growx");
    }

    private void initProperties() throws IOException {
		Properties defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("datapath", "c:" + File.separator + "temp");
		defaultProps.setProperty("PointsToWin", "5");
		defaultProps.setProperty("MaxWin", "8");
		defaultProps.setProperty("WinBy", "1");
		defaultProps.setProperty("GamesToWin", "2");
		defaultProps.setProperty("AutoIncrementGame", "1");
		defaultProps.setProperty("AnnounceWinner", "1");
		
		configProps = new Properties(defaultProps);
    }

    public void loadProperties() throws IOException {
		// loads properties from file
    	foosObsSettings.loadFromConfig(configProps);
/**
		System.out.println("Points to win: " + configProps.getProperty("PointsToWin"));
		System.out.println("Max win: " + configProps.getProperty("MaxWin"));
		System.out.println("Win by: " + configProps.getProperty("WinBy"));
		System.out.println("Games to win: " + configProps.getProperty("GamesToWin"));
		System.out.println("Auto Increment Game: " + configProps.getProperty("AutoIncrementGame"));
		System.out.println("Announce Winner: " + configProps.getProperty("AnnounceWinner"));
**/
	}
	
	public void saveProperties(Settings foosObsSettings, OBSInterface obsInterface) throws IOException {
		System.out.println("datapath: " + obsInterface.getFilePath());
		System.out.println("foosObsSettings: " + foosObsSettings.getDatapath());
		String tmpDatapath = foosObsSettings.getDatapath();
		System.out.println("foosObsSettings: " + tmpDatapath);
		foosObsSettings.setDatapath(tmpDatapath);
//		foosObsSettings.setDatapath(obsInterface.getFilePath());
		foosObsSettings.setPointsToWin(foosObsSettings.getPointsToWin());
		foosObsSettings.setMaxWin(foosObsSettings.getMaxWin());
		foosObsSettings.setWinBy(foosObsSettings.getWinBy());
		foosObsSettings.setGamesToWin(foosObsSettings.getGamesToWin());
		foosObsSettings.setAutoIncrementGame(foosObsSettings.getAutoIncrementGame());
		foosObsSettings.setAnnounceWinner(foosObsSettings.getAnnounceWinner());
		foosObsSettings.saveToConfig(configProps);

/**
		configProps.setProperty("datapath", formattedTxtPath.getText());
		configProps.setProperty("PointsToWin", Integer.toString(foosObsSettings.getPointsToWin()));
		configProps.setProperty("MaxWin", Integer.toString(foosObsSettings.getMaxWin()));
		configProps.setProperty("WinBy", Integer.toString(foosObsSettings.getWinBy()));
		configProps.setProperty("GamesToWin", Integer.toString(foosObsSettings.getGamesToWin()));
		configProps.setProperty("AutoIncrementGame", Integer.toString(foosObsSettings.getAutoIncrementGame()));
		configProps.setProperty("AnnounceWinner", Integer.toString(foosObsSettings.getAnnounceWinner()));
		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB settings");
		outputStream.close();
		System.out.println(formattedTxtPath.getText());
**/
	}

	private void writeTournamentName() {
    	try {
    		obsInterface.setContents("tournament.txt", txtTournamentName.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearTournamentName() {
		txtTournamentName.setText(null);
		writeTournamentName();
	}

    private void writeEventName() {
		try {
    		obsInterface.setContents("event.txt", txtEventName.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    private void clearEventName() {
    	txtEventName.setText(null);
    	writeEventName();
    }

	private void writeTeam1Name() {
		try {
			obsInterface.setContents("team1.txt", txtTeam1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearTeam1Name() {
		txtTeam1.setText(null);
		writeTeam1Name();
	}

	private void writeTeam2Name() {
		try {
			obsInterface.setContents("team2.txt", txtTeam2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearTeam2Name() {
		txtTeam2.setText(null);
		writeTeam1Name();
	}

	private void switchTeamNames() {
		String temp1 = txtTeam1.getText();
		txtTeam1.setText(txtTeam2.getText());
		txtTeam2.setText(temp1);
		writeTeam1Name();
		writeTeam2Name();
	}

	private void switchTeam1Names() {
		String team = txtTeam1.getText();
		int index = team.indexOf("/");
		if (index>-1) {
			String player1 = team.substring(0,index);
			String player2 = team.substring(index+1);
			txtTeam1.setText(player2+"/"+player1);
			writeTeam1Name();
		}
	}

	private void switchTeam2Names() {
		String team = txtTeam2.getText();
		int index = team.indexOf("/");
		if (index>-1) {
			String player1 = team.substring(0,index);
			String player2 = team.substring(index+1);
			txtTeam2.setText(player2+"/"+player1);
			writeTeam2Name();
		}
	}

	private void writeGameCount1() {
    	try {
    		obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private void decrementGameCount1() {
		int num1;
		num1=Integer.parseInt(txtGameCount1.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtGameCount1.setText(Integer.toString(num1));
		writeGameCount1();
	}

	private void incrementGameCount1() {
		int num1;
		num1=Integer.parseInt(txtGameCount1.getText());
		num1=num1+1;
		if (num1>maxGameCount) {
			num1 = maxGameCount;
		}
		txtGameCount1.setText(Integer.toString(num1));
		writeGameCount1();
	}

	private void writeGameCount2() {
    	try {
    		obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private void decrementGameCount2() {
		int num1;
		num1=Integer.parseInt(txtGameCount2.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtGameCount2.setText(Integer.toString(num1));
		writeGameCount2();
	}

	private void incrementGameCount2() {
		int num1;
		num1=Integer.parseInt(txtGameCount2.getText());
		num1=num1+1;
		if (num1>maxGameCount) {
			num1 = maxGameCount;
		}
		txtGameCount2.setText(Integer.toString(num1));
		writeGameCount2();
	}
	
	private void writeScore1() {
		try {
			obsInterface.setContents("score1.txt", txtScore1.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void decrementScore1() {
		int num1;
		num1=Integer.parseInt(txtScore1.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtScore1.setText(Integer.toString(num1));
		writeScore1();
	}

	private void incrementScore1() {
		int num1;
		num1=Integer.parseInt(txtScore1.getText());
		num1=num1+1;
		if (num1>maxScore) {
			num1 = maxScore;
		}
		txtScore1.setText(Integer.toString(num1));
		writeScore1();
	}

	private void writeScore2() {
		try {
			obsInterface.setContents("score2.txt", txtScore2.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void decrementScore2() {
		int num1;
		num1=Integer.parseInt(txtScore2.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtScore2.setText(Integer.toString(num1));
		writeScore2();
	}

	private void incrementScore2() {
		int num1;
		num1=Integer.parseInt(txtScore2.getText());
		num1=num1+1;
		if (num1>maxScore) {
			num1 = maxScore;
		}
		txtScore2.setText(Integer.toString(num1));
		writeScore2();
	}

	private void switchGameCount() {
		String temp1 = txtGameCount1.getText();
		txtGameCount1.setText(txtGameCount2.getText());
		txtGameCount2.setText(temp1);
		writeGameCount1();
		writeGameCount2();
	}

	private void resetGameCounts() {
		txtGameCount1.setText("0");
		txtGameCount2.setText("0");
		writeGameCount1();
		writeGameCount2();
	}

	private void switchScore() {
		String temp1 = txtScore1.getText();
		txtScore1.setText(txtScore2.getText());
		txtScore2.setText(temp1);
		writeScore1();
		writeScore2();
	}

	private void resetScores() {
		txtScore1.setText("0");
		txtScore2.setText("0");
		writeScore1();
		writeScore2();
	}

	private void writeTimeOut1() {
    	try {
    		obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTimeOut2() {
    	try {
    		obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void decrementTimeOut1() {
		int num1;
		num1=Integer.parseInt(txtTimeOut1.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtTimeOut1.setText(Integer.toString(num1));
		try {
			obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void decrementTimeOut2() {
		int num1;
		num1=Integer.parseInt(txtTimeOut2.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtTimeOut2.setText(Integer.toString(num1));
		try {
			obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void switchTimeOut() {
		String temp1 = txtTimeOut1.getText();
		txtTimeOut1.setText(txtTimeOut2.getText());
		txtTimeOut2.setText(temp1);
		writeTimeOut1();
		writeTimeOut2();
	}
	
	private void incrementTimeOut1() {
		int num1;
		num1=Integer.parseInt(txtTimeOut1.getText());
		num1=num1+1;
		if (num1>maxTimeOut) {
			num1 = maxTimeOut;
		}
		txtTimeOut1.setText(Integer.toString(num1));
		writeTimeOut1();
	}
	
	private void incrementTimeOut2() {
		int num1;
		num1=Integer.parseInt(txtTimeOut2.getText());
		num1=num1+1;
		if (num1>maxTimeOut) {
			num1 = maxTimeOut;
		}
		txtTimeOut2.setText(Integer.toString(num1));
		writeTimeOut2();
	}

	private void writeReset1() {
		try {
			if(tglbtnReset1.isSelected()) {
				obsInterface.setContents("reset1.txt", "RESET");
			} else {
				obsInterface.setContents("reset1.txt", "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void writeReset2() {
		try {
			if(tglbtnReset2.isSelected()) {
				obsInterface.setContents("reset2.txt", "RESET");
			} else {
				obsInterface.setContents("reset2.txt", "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeWarn1() {
		try {
			if(tglbtnWarn1.isSelected()) {
				obsInterface.setContents("warn1.txt", "WARNING");
			} else {
				obsInterface.setContents("warn1.txt", "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeWarn2() {
		try {
			if(tglbtnWarn2.isSelected()) {
				obsInterface.setContents("warn2.txt", "WARNING");
			} else {
				obsInterface.setContents("warn2.txt", "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void switchResetWarn() {
		boolean sel1 = tglbtnReset1.isSelected();
		tglbtnReset1.setSelected(tglbtnReset2.isSelected());
		tglbtnReset2.setSelected(sel1);
		boolean sel2 = tglbtnWarn1.isSelected();
		tglbtnWarn1.setSelected(tglbtnWarn2.isSelected());
		tglbtnWarn2.setSelected(sel2);
		writeReset1();
		writeReset2();
		writeWarn1();
		writeWarn2();
	}

	private void writeTimerInUse() {
		try {
			obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeTimeRemaining() {
		try {
			obsInterface.setContents("timeremaining.txt", lblTimerDisplay.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void resetTimeOuts() {
		txtTimeOut1.setText("0");
		txtTimeOut2.setText("0");
		writeTimeOut1();
		writeTimeOut2();
	}
	
	private void resetResetWarns() {
		tglbtnReset1.setSelected(false);
		tglbtnReset2.setSelected(false);
		tglbtnWarn1.setSelected(false);
		tglbtnWarn2.setSelected(false);
		writeReset1();
		writeReset2();
		writeWarn1();
		writeWarn2();
	}
	
	private void resetAll() {
		resetGameCounts();
		resetScores();
		resetTimeOuts();
		resetResetWarns();
	}

	private void switchAll() {
		switchTeamNames();
		switchGameCount();
		switchScore();
		switchTimeOut();
		switchResetWarn();
	}

	private void updateTimerDisplay() {
		int timeRemaining = timeClock.getTimeRemaining();
		int nbrOfSeconds = timeClock.getNbrOfSeconds();
		int nbrOfMinutes = 0;
		int displaySeconds = 0;
		if(timeRemaining <= 0 && nbrOfSeconds != 0) {
			lblTimerDisplay.setBackground(Color.RED);
		}
		float tr = (float) timeRemaining / 10f;
		if(Float.compare(tr, 60f) > 0) {
			nbrOfMinutes = (int) (tr / 60);
			displaySeconds = (timeRemaining - (nbrOfMinutes * 600))/10;
			lblTimerDisplay.setText("   " + nbrOfMinutes + ":" + String.format("%02d", displaySeconds) + "   ");
		} else {

		lblTimerDisplay.setText("   " + Float.toString(tr) + "   ");
		}
		if(tr == (int) tr) {
			writeTimeRemaining();
		};
	}
	
	private void resetTimers() {
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Timer Reset");
		writeTimerInUse();
		timeClock.resetTimer(0);
	}

	private void startPossessionTimer() {
		int count = (int) (Integer.parseInt(btnPossessionTimer.getText().substring(0,btnPossessionTimer.getText().indexOf(" "))) * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Shot Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}
	
	private void start5RowTimer() {
		int count = (int) (Integer.parseInt(btn5RowTimer.getText().substring(0,btn5RowTimer.getText().indexOf(" "))) * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Pass Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}

	private void startTimeOutTimer() {
		int count = (int) (Integer.parseInt(btnTimeOutTimer.getText().substring(0,btnTimeOutTimer.getText().indexOf(" "))) * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Time Out Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}
	
	private void startRecallTimer() {
		int count = (int) (Integer.parseInt(btnRecallTimer.getText().substring(0,btnRecallTimer.getText().indexOf(" "))) * 10 * 60);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Recall Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}

	private void startGameTimer() {
		int count = (int) (Integer.parseInt(btnGameTimer.getText().substring(0,btnGameTimer.getText().indexOf(" "))) * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Game Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}

	private void fetchAll() {
		try {
			txtTournamentName.setText(obsInterface.getContents("tournament.txt"));
			txtEventName.setText(obsInterface.getContents("event.txt"));
			txtTeam1.setText(obsInterface.getContents("team1.txt"));
			txtTeam2.setText(obsInterface.getContents("team2.txt"));
			txtGameCount1.setText(obsInterface.getContents("gamecount1.txt"));
			txtGameCount2.setText(obsInterface.getContents("gamecount2.txt"));
			txtScore1.setText(obsInterface.getContents("score1.txt"));
			txtScore2.setText(obsInterface.getContents("score2.txt"));
			txtTimeOut1.setText(obsInterface.getContents("timeout1.txt"));
			txtTimeOut2.setText(obsInterface.getContents("timeout2.txt"));
			tglbtnReset1.setSelected(obsInterface.getContents("reset1.txt")!=null);
			tglbtnReset2.setSelected(obsInterface.getContents("reset2.txt")!=null);
			tglbtnWarn1.setSelected(obsInterface.getContents("warn1.txt")!=null);
			tglbtnWarn2.setSelected(obsInterface.getContents("warn2.txt")!=null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void clearAll() {
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
		lblTimerDisplay.setBackground(Color.GREEN);
		timeClock.resetTimer(0);
		lblTimerInUse.setText("Timer Reset");
		saveAll();
	}

	private void saveAll() {
		writeTournamentName();
		writeEventName();
		writeTeam1Name();
		writeTeam2Name();
		writeGameCount1();
		writeGameCount2();
		writeScore1();
		writeScore2();
		writeTimeOut1();
		writeTimeOut2();
		writeTimeRemaining();
		writeReset1();
		writeReset2();
		writeWarn1();
		writeWarn2();
		writeTimerInUse();
	}

}

