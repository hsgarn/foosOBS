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
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Properties;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

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
	public Properties configProps;
	private String defaultFilePath = "c:\\temp";
	private JButton btnGameTimer;
	private JButton btnShotTimer;
	private JButton btnPassTimer;
	private JButton btnTimeOutTimer;
	private JButton btnRecallTimer;
	private JLabel lblTimerDisplay;
	private JLabel lblTimerInUse;
	private URI logoLinkURI;
	private ImageIcon imageIcon;
	TimeClock timeClock;
	ActionListener alAction;
	OBSInterface obsInterface;
	Settings foosObsSettings;
	JFrame f;
	private JTextField txtLastScored;
	private static TimerWindowJPanel twjp;
	private int displayWidth = 9;
	private int prefixWidth;
	private int suffixWidth = 3;
	/**
	 * Create the panel.
	 **/
    public MainJPanel(JFrame f) throws IOException {

    	initialize();
    	setLayout(new MigLayout("", "[90.00][135.00,grow][90.00][grow][90.00][135.00,grow][90.00]", "[][][][][][][][][][][][][][][][][][][][][][][]"));
    	
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(100, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		JLabel lblLogo = new JLabel(imageIcon);
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				java.awt.Desktop.getDesktop().browse(logoLinkURI);
				} catch (IOException ex) {
					System.out.print("Error calling URI: " + ex.getMessage());		
				}
			}
		});
		lblLogo.setBackground(Color.BLACK);
		lblLogo.setOpaque(true);
		add(lblLogo, "cell 0 0 1 4");
	
		JLabel lblLogo2 = new JLabel(imageIcon);
		lblLogo2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
				java.awt.Desktop.getDesktop().browse(logoLinkURI);
				} catch (IOException ex) {
					System.out.print("Error calling URI: " + ex.getMessage());		
				}
			}
		});
		lblLogo2.setBackground(Color.BLACK);
		lblLogo2.setOpaque(true);
		add(lblLogo2, "flowx,cell 6 0 1 4");
		
		JLabel lblTournamentName = new JLabel("Tournament:");
		add(lblTournamentName, "flowx,cell 1 1,alignx center,aligny bottom");
		
		JSeparator separator = new JSeparator();
		add(separator, "flowx,cell 3 1");
		
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
		
		txtLastScored = new JTextField();
		txtLastScored.setEditable(false);
		txtLastScored.setFont(UIManager.getFont("TextArea.font"));
		txtLastScored.setText("    Last Scored    ");
		add(txtLastScored, "cell 3 2,alignx center");
		txtLastScored.setColumns(10);
		
		txtTournamentName.setText("High Pockets Monday Night");
		add(txtTournamentName, "flowy,cell 1 4,growx");
		txtTournamentName.setColumns(10);

		JLabel lblEvent = new JLabel("Event:");
		add(lblEvent, "cell 5 1,alignx center,aligny bottom");
		
		JButton btnTournamentNameClear = new JButton("Clear");
		if(foosObsSettings.getTournamentNameClearHotKey().isEmpty()) {
			btnTournamentNameClear.setMnemonic(-1);
		} else {
			btnTournamentNameClear.setMnemonic(foosObsSettings.getTournamentNameClearHotKey().charAt(0));
		};
		btnTournamentNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTournamentName();
			}
		});
		add(btnTournamentNameClear, "cell 2 4,alignx left");
		
		JButton btnEventClear = new JButton("Clear");
		if(foosObsSettings.getEventClearHotKey().isEmpty()) {
			btnEventClear.setMnemonic(-1);
		} else {
			btnEventClear.setMnemonic(foosObsSettings.getEventClearHotKey().charAt(0));
		};
		btnEventClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearEventName();
			}
		});
		add(btnEventClear, "cell 4 4,alignx right");
		
		lblTimerInUse = new JLabel("Timer Reset");
		lblTimerInUse.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTimerInUse, "cell 3 4,growx");
		
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
		add(txtEventName, "flowx,cell 5 4,growx");
		txtEventName.setColumns(10);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAbout.setBackground(Color.CYAN);
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame aboutFrame = new JFrame("About Foos OBS");
				aboutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				AboutJPanel pnl;
//				try {
					aboutFrame.setAlwaysOnTop(true);
					pnl = new AboutJPanel(aboutFrame);
					pnl.setPreferredSize(new Dimension(270, 90));

					aboutFrame.getContentPane().add(pnl);
					aboutFrame.pack();
					aboutFrame.setVisible(true);

//				} catch (IOException e) {
//					e.printStackTrace();
//				}
			}
		});
		add(btnAbout, "cell 6 4,growx,aligny top");
		
		JLabel lblTeam1 = new JLabel("Team 1 Name(s):");
		add(lblTeam1, "cell 1 6,alignx center");
		
		JLabel lblTeam2 = new JLabel("Team 2 Name(s):");
		add(lblTeam2, "cell 5 6,alignx center");
		
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
		add(txtTeam1, "cell 1 7,growx");
		txtTeam1.setColumns(10);
		
		JButton btnTeam1NameSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getTeam1NameSwitchHotKey().isEmpty()) {
			btnTeam1NameSwitch.setMnemonic(-1);
		} else {
			btnTeam1NameSwitch.setMnemonic(foosObsSettings.getTeam1NameSwitchHotKey().charAt(0));
		};
		btnTeam1NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeam1Names();
			}
		});
		add(btnTeam1NameSwitch, "cell 0 7,alignx right");
		
		JButton btnTeam1Clear = new JButton("Clear");
		if(foosObsSettings.getTeam1ClearHotKey().isEmpty()) {
			btnTeam1Clear.setMnemonic(-1);
		} else {
			btnTeam1Clear.setMnemonic(foosObsSettings.getTeam1ClearHotKey().charAt(0));
		};
		btnTeam1Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTeam1Name();
			}
		});
		add(btnTeam1Clear, "cell 2 7,alignx left,aligny bottom");
		
		JButton btnTeamSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getTeamSwitchHotKey().isEmpty()) {
			btnTeamSwitch.setMnemonic(-1);
		} else {
			btnTeamSwitch.setMnemonic(foosObsSettings.getTeamSwitchHotKey().charAt(0));
		};
		btnTeamSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeamNames();
			}
		});
		add(btnTeamSwitch, "cell 3 7,alignx center");
		
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
		add(txtTeam2, "flowx,cell 5 7,growx");
		txtTeam2.setColumns(10);
		
		JButton btnTeam2Clear = new JButton("Clear");
		if(foosObsSettings.getTeam2ClearHotKey().isEmpty()) {
			btnTeam2Clear.setMnemonic(-1);
		} else {
			btnTeam2Clear.setMnemonic(foosObsSettings.getTeam2ClearHotKey().charAt(0));
		};
		btnTeam2Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    	clearTeam2Name();
			}
		});
		add(btnTeam2Clear, "cell 4 7,alignx right");
		
		JButton btnTeam2NameSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getTeam2NameSwitchHotKey().isEmpty()) {
			btnTeam2NameSwitch.setMnemonic(-1);
		} else {
			btnTeam2NameSwitch.setMnemonic(foosObsSettings.getTeam2NameSwitchHotKey().charAt(0));
		};
		btnTeam2NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTeam2Names();
			}
		});
		add(btnTeam2NameSwitch, "cell 6 7,alignx left");
		
		JLabel lblGameCount1 = new JLabel("Game Count");
		add(lblGameCount1, "cell 1 9,alignx center");
		
		JLabel lblGameCount2 = new JLabel("Game Count");
		add(lblGameCount2, "cell 5 9,alignx center");
		
		JButton btnGameCount1Minus = new JButton("-");
		if(foosObsSettings.getGameCount1MinusHotKey().isEmpty()) {
			btnGameCount1Minus.setMnemonic(-1);
		} else {
			btnGameCount1Minus.setMnemonic(foosObsSettings.getGameCount1MinusHotKey().charAt(0));
		};
		btnGameCount1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtGameCount1.getText().isEmpty()) {
					txtGameCount1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount1.getText())) {
		    		decrementGameCount1();
		    	}
			}
		});
		add(btnGameCount1Minus, "cell 0 10,growx");
		
		txtGameCount1 = new JTextField();
		txtGameCount1.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount1.setText("0");
		txtGameCount1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
					if (txtGameCount1.getText().isEmpty()) {
						txtGameCount1.setText(Integer.toString(0));
					}
			    	if (isValidInteger(txtGameCount1.getText())) {
				    	writeGameCount1();			    		
			    	}
			    }
			}
		});
		txtGameCount1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtGameCount1.getText().isEmpty()) {
					txtGameCount1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount1.getText())) {
		    		writeGameCount1();
		    	}
			}
		});
		add(txtGameCount1, "cell 1 10,growx");
		txtGameCount1.setColumns(10);
		
		JButton btnGameCount1Plus = new JButton("+");
		if(foosObsSettings.getGameCount1PlusHotKey().isEmpty()) {
			btnGameCount1Plus.setMnemonic(-1);
		} else {
			btnGameCount1Plus.setMnemonic(foosObsSettings.getGameCount1PlusHotKey().charAt(0));
		};
		btnGameCount1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtGameCount1.getText().isEmpty()) {
					txtGameCount1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount1.getText())) {
		    		incrementGameCount1();
		    	}
			}
		});
		add(btnGameCount1Plus, "cell 2 10,growx");
		
		JButton btnGameCountSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getGameCountSwitchHotKey().isEmpty()) {
			btnGameCountSwitch.setMnemonic(-1);
		} else {
			btnGameCountSwitch.setMnemonic(foosObsSettings.getGameCountSwitchHotKey().charAt(0));
		};
		btnGameCountSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchGameCount();
			}
		});
		add(btnGameCountSwitch, "cell 3 10,growx");
		
		JButton btnGameCount2Minus = new JButton("-");
		if(foosObsSettings.getGameCount2MinusHotKey().isEmpty()) {
			btnGameCount2Minus.setMnemonic(-1);
		} else {
			btnGameCount2Minus.setMnemonic(foosObsSettings.getGameCount2MinusHotKey().charAt(0));
		};
		btnGameCount2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtGameCount2.getText().isEmpty()) {
					txtGameCount2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount2.getText())) {
		    		decrementGameCount2();
		    	}
			}
		});
		add(btnGameCount2Minus, "cell 4 10,growx");
		
		txtGameCount2 = new JTextField();
		txtGameCount2.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount2.setText("0");
		txtGameCount2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	if (isValidInteger(txtGameCount2.getText())) {
			    		writeGameCount2();
			    	}
		    	}
			}
		});
		txtGameCount2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtGameCount2.getText().isEmpty()) {
					txtGameCount2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount2.getText())) {
		    		writeGameCount2();
		    	}
			}
		});
		add(txtGameCount2, "cell 5 10,growx");
		txtGameCount2.setColumns(10);
		
		JButton btnGameCount2Plus = new JButton("+");
		if(foosObsSettings.getGameCount2PlusHotKey().isEmpty()) {
			btnGameCount2Plus.setMnemonic(-1);
		} else {
			btnGameCount2Plus.setMnemonic(foosObsSettings.getGameCount2PlusHotKey().charAt(0));
		};
		btnGameCount2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtGameCount2.getText().isEmpty()) {
					txtGameCount2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtGameCount2.getText())) {
		    		incrementGameCount2();
		    	}
			}
		});
		add(btnGameCount2Plus, "cell 6 10,growx");
		
		JLabel lblScore1 = new JLabel("Score");
		add(lblScore1, "cell 1 11,alignx center");
		
		JLabel lblScore = new JLabel("Score");
		add(lblScore, "cell 5 11,alignx center");
		
		JButton btnScore1Minus = new JButton("-");
		if(foosObsSettings.getScore1MinusHotKey().isEmpty()) {
			btnScore1Minus.setMnemonic(-1);
		} else {
			btnScore1Minus.setMnemonic(foosObsSettings.getScore1MinusHotKey().charAt(0));
		};
		btnScore1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtScore1.getText().isEmpty()) {
					txtScore1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore1.getText())) {
		    		decrementScore1();
		    	}
			}
		});
		add(btnScore1Minus, "cell 0 12,growx,aligny top");
		
		txtScore1 = new JTextField();
		txtScore1.setBackground(Color.WHITE);
		txtScore1.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore1.setText("0");
		txtScore1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
					if (txtScore1.getText().isEmpty()) {
						txtScore1.setText(Integer.toString(0));
					}
			    	if (isValidInteger(txtScore1.getText())) {
			    		writeScore1();
			    	}
		    	}
			}
		});
		txtScore1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtScore1.getText().isEmpty()) {
					txtScore1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore1.getText())) {
		    		writeScore1();
		    	}
			}
		});
		add(txtScore1, "cell 1 12,growx");
		txtScore1.setColumns(10);
		
		JButton btnScore1Plus = new JButton("+");
		if(foosObsSettings.getScore1PlusHotKey().isEmpty()) {
			btnScore1Plus.setMnemonic(-1);
		} else {
			btnScore1Plus.setMnemonic(foosObsSettings.getScore1PlusHotKey().charAt(0));
		};
		btnScore1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtScore1.getText().isEmpty()) {
					txtScore1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore1.getText())) {
		    		incrementScore1();
		    	}
			}
		});
		add(btnScore1Plus, "cell 2 12,growx");
		
		JButton btnScoreSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getScoreSwitchHotKey().isEmpty()) {
			btnScoreSwitch.setMnemonic(-1);
		} else {
			btnScoreSwitch.setMnemonic(foosObsSettings.getScoreSwitchHotKey().charAt(0));
		};
		btnScoreSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchScore();
			}
		});
		add(btnScoreSwitch, "cell 3 12,growx");
		
		JButton btnScore2Minus = new JButton("-");
		if(foosObsSettings.getScore2MinusHotKey().isEmpty()) {
			btnScore2Minus.setMnemonic(-1);
		} else {
			btnScore2Minus.setMnemonic(foosObsSettings.getScore2MinusHotKey().charAt(0));
		};
		btnScore2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtScore2.getText().isEmpty()) {
					txtScore2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore2.getText())) {
		    		decrementScore2();
		    	}
			}
		});
		add(btnScore2Minus, "cell 4 12,growx");
		
		txtScore2 = new JTextField();
		txtScore2.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore2.setText("0");
		txtScore2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
				if (txtScore2.getText().isEmpty()) {
					txtScore2.setText(Integer.toString(0));
				}
			    if (key == KeyEvent.VK_ENTER) {
			    	if (isValidInteger(txtScore2.getText())) {
			    		writeScore2();
			    	}
			    }
			}
		});
		txtScore2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtScore2.getText().isEmpty()) {
					txtScore2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore2.getText())) {
		    		writeScore2();
		    	}
			}
		});
		add(txtScore2, "cell 5 12,growx");
		txtScore2.setColumns(10);
		
		JButton btnScore2Plus = new JButton("+");
		if(foosObsSettings.getScore2PlusHotKey().isEmpty()) {
			btnScore2Plus.setMnemonic(-1);
		} else {
			btnScore2Plus.setMnemonic(foosObsSettings.getScore2PlusHotKey().charAt(0));
		};
		btnScore2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtScore2.getText().isEmpty()) {
					txtScore2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtScore2.getText())) {
		    		incrementScore2();
		    	}
			}
		});
		add(btnScore2Plus, "cell 6 12,growx");
		
		JLabel lblTimeOut1 = new JLabel("TimeOut");
		add(lblTimeOut1, "cell 1 13,alignx center");
		
		JLabel lblTimeout = new JLabel("TimeOut");
		add(lblTimeout, "cell 5 13,alignx center");
		
		JButton btnTimeOut1Minus = new JButton("Return TO");
		if(foosObsSettings.getTimeOut1MinusHotKey().isEmpty()) {
			btnTimeOut1Minus.setMnemonic(-1);
		} else {
			btnTimeOut1Minus.setMnemonic(foosObsSettings.getTimeOut1MinusHotKey().charAt(0));
		};
		btnTimeOut1Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtTimeOut1.getText().isEmpty()) {
					txtTimeOut1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut1.getText())) {
		    		decrementTimeOut1();
		    	}
			}
		});
		add(btnTimeOut1Minus, "cell 0 14,growx");
		
		txtTimeOut1 = new JTextField();
		txtTimeOut1.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut1.setText("0");
		txtTimeOut1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
					if (txtTimeOut1.getText().isEmpty()) {
						txtTimeOut1.setText(Integer.toString(0));
					}
			    	if (isValidInteger(txtTimeOut1.getText())) {
			    		writeTimeOut1();
			    	}
			    }
			}
		});
		txtTimeOut1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtTimeOut1.getText().isEmpty()) {
					txtTimeOut1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut1.getText())) {
		    		writeTimeOut1();
		    	}
			}
		});
		add(txtTimeOut1, "cell 1 14,growx");
		txtTimeOut1.setColumns(10);
		
		JButton btnTimeOut1Plus = new JButton("Use TO");
		if(foosObsSettings.getTimeOut1PlusHotKey().isEmpty()) {
			btnTimeOut1Plus.setMnemonic(-1);
		} else {
			btnTimeOut1Plus.setMnemonic(foosObsSettings.getTimeOut1PlusHotKey().charAt(0));
		};
		btnTimeOut1Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTimeOut1.getText().isEmpty()) {
					txtTimeOut1.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut1.getText())) {
		    		incrementTimeOut1();
		    	}
			}
		});
		add(btnTimeOut1Plus, "cell 2 14,growx");
		
		JButton btnTimeOutSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getTimeOutSwitchHotKey().isEmpty()) {
			btnTimeOutSwitch.setMnemonic(-1);
		} else {
			btnTimeOutSwitch.setMnemonic(foosObsSettings.getTimeOutSwitchHotKey().charAt(0));
		};
		btnTimeOutSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchTimeOut();
			}
		});
		add(btnTimeOutSwitch, "cell 3 14,growx");
		
		JButton btnTimeOut2Minus = new JButton("Return TO");
		if(foosObsSettings.getTimeOut2MinusHotKey().isEmpty()) {
			btnTimeOut2Minus.setMnemonic(-1);
		} else {
			btnTimeOut2Minus.setMnemonic(foosObsSettings.getTimeOut2MinusHotKey().charAt(0));
		};
		btnTimeOut2Minus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTimeOut2.getText().isEmpty()) {
					txtTimeOut2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut2.getText())) {
		    		decrementTimeOut2();
		    	}
			}
		});
		add(btnTimeOut2Minus, "cell 4 14,growx");
		
		txtTimeOut2 = new JTextField();
		txtTimeOut2.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut2.setText("0");
		txtTimeOut2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
					if (txtTimeOut2.getText().isEmpty()) {
						txtTimeOut2.setText(Integer.toString(0));
					}
			    	if (isValidInteger(txtTimeOut2.getText())) {
			    		writeTimeOut2();
			    	}
			    }
			}
		});
		txtTimeOut2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtTimeOut2.getText().isEmpty()) {
					txtTimeOut2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut2.getText())) {
		    		writeTimeOut2();
		    	}
			}
		});
		add(txtTimeOut2, "cell 5 14,growx");
		txtTimeOut2.setColumns(10);
		
		JButton btnTimeOut2Plus = new JButton("Use TO");
		if(foosObsSettings.getTimeOut2PlusHotKey().isEmpty()) {
			btnTimeOut2Plus.setMnemonic(-1);
		} else {
			btnTimeOut2Plus.setMnemonic(foosObsSettings.getTimeOut2PlusHotKey().charAt(0));
		};
		btnTimeOut2Plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTimeOut2.getText().isEmpty()) {
					txtTimeOut2.setText(Integer.toString(0));
				}
		    	if (isValidInteger(txtTimeOut2.getText())) {
		    		incrementTimeOut2();
		    	}
			}
		});
		add(btnTimeOut2Plus, "cell 6 14,growx");
		
		tglbtnReset1 = new JToggleButton("Reset");
		tglbtnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeReset1();
			}
		});
		add(tglbtnReset1, "cell 0 15,growx");
		
		tglbtnWarn1 = new JToggleButton(" Warn");
		tglbtnWarn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeWarn1();
			}
		});
		add(tglbtnWarn1, "cell 2 15,growx");
		
		tglbtnReset2 = new JToggleButton("Reset");
		tglbtnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeReset2();
			}
		});
		add(tglbtnReset2, "cell 4 15,growx");
		
		tglbtnWarn2 = new JToggleButton(" Warn");
		tglbtnWarn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				writeWarn2();
			}
		});
		add(tglbtnWarn2, "cell 6 15,growx");

		JButton btnResetSwitch = new JButton("<-Switch->");
		if(foosObsSettings.getResetSwitchHotKey().isEmpty()) {
			btnResetSwitch.setMnemonic(-1);
		} else {
			btnResetSwitch.setMnemonic(foosObsSettings.getResetSwitchHotKey().charAt(0));
		};
		btnResetSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switchResetWarn();
			}
		});
		add(btnResetSwitch, "cell 3 15,growx");
		
		JButton btnResetGameCounts = new JButton("Reset Game Counts");
		if(foosObsSettings.getResetGameCountsHotKey().isEmpty()) {
			btnResetGameCounts.setMnemonic(-1);
		} else {
			btnResetGameCounts.setMnemonic(foosObsSettings.getResetGameCountsHotKey().charAt(0));
		};
		btnResetGameCounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetGameCounts();
			}
		});
		add(btnResetGameCounts, "cell 1 16,growx");
		
		JButton btnResetScores = new JButton("Reset Scores");
		if(foosObsSettings.getResetScoresHotKey().isEmpty()) {
			btnResetScores.setMnemonic(-1);
		} else {
			btnResetScores.setMnemonic(foosObsSettings.getResetScoresHotKey().charAt(0));
		};
		btnResetScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetScores();
			}
		});
		add(btnResetScores, "cell 1 17,growx");
		
		JButton btnResetTimers = new JButton("Reset Timer");
		if(foosObsSettings.getResetTimersHotKey().isEmpty()) {
			btnResetTimers.setMnemonic(-1);
		} else {
			btnResetTimers.setMnemonic(foosObsSettings.getResetTimersHotKey().charAt(0));
		};
		btnResetTimers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTimers();
		}
		});
		add(btnResetTimers, "cell 5 16,growx,aligny bottom");
		
		JButton btnResetTimeOuts = new JButton("Reset Time Outs");
		if(foosObsSettings.getResetTimeOutsHotKey().isEmpty()) {
			btnResetTimeOuts.setMnemonic(-1);
		} else {
			btnResetTimeOuts.setMnemonic(foosObsSettings.getResetTimeOutsHotKey().charAt(0));
		};
		btnResetTimeOuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTimeOuts();
			}
		});
		add(btnResetTimeOuts, "cell 1 18,growx");
		
		JButton btnResetResetWarn = new JButton("Reset Reset/Warn");
		if(foosObsSettings.getResetResetWarnHotKey().isEmpty()) {
			btnResetResetWarn.setMnemonic(-1);
		} else {
			btnResetResetWarn.setMnemonic(foosObsSettings.getResetResetWarnHotKey().charAt(0));
		};
		btnResetResetWarn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				resetResetWarns();
			}
		});
		add(btnResetResetWarn, "cell 1 19,growx");
		
		JButton btnResetAll = new JButton("Reset All");
		if(foosObsSettings.getResetAllHotKey().isEmpty()) {
			btnResetAll.setMnemonic(-1);
		} else {
			btnResetAll.setMnemonic(foosObsSettings.getResetAllHotKey().charAt(0));
		};
		btnResetAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetAll();
			}
		});
		add(btnResetAll, "cell 1 20,growx");
		
		JButton btnAllSwitch = new JButton("<-Switch Sides->");
		if(foosObsSettings.getAllSwitchHotKey().isEmpty()) {
			btnAllSwitch.setMnemonic(-1);
		} else {
			btnAllSwitch.setMnemonic(foosObsSettings.getAllSwitchHotKey().charAt(0));
		};
		btnAllSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchAll();
			}
		});
		add(btnAllSwitch, "cell 2 16 3 1,growx");

		ActionListener alAction = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				updateTimerDisplay();
			}
		};
		timeClock.addTimeClockTimerListener(alAction);
		
		JLabel lblShotTimer = new JLabel("Shot Timer (2 & 3 row)");
		add(lblShotTimer, "cell 5 17,alignx right");
		
		btnShotTimer = new JButton("Start");
		if(foosObsSettings.getShotTimerHotKey().isEmpty()) {
			btnShotTimer.setMnemonic(-1);
		} else {
			btnShotTimer.setMnemonic(foosObsSettings.getShotTimerHotKey().charAt(0));
		};
		btnShotTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startShotTimer();
			}
		});
		add(btnShotTimer, "cell 6 17,growx");
		
		JLabel lblPassTimer = new JLabel("Pass Timer (5 row)");
		add(lblPassTimer, "cell 5 18,alignx right");
		
		btnPassTimer = new JButton("Start");
		if(foosObsSettings.getPassTimerHotKey().isEmpty()) {
			btnPassTimer.setMnemonic(-1);
		} else {
			btnPassTimer.setMnemonic(foosObsSettings.getPassTimerHotKey().charAt(0));
		};
		btnPassTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startPassTimer();
			}
		});
		add(btnPassTimer, "cell 6 18,growx,aligny bottom");
		
		JLabel lblTimeOutTimer = new JLabel("Time Out Timer");
		add(lblTimeOutTimer, "cell 5 19,alignx right");
		
		btnTimeOutTimer = new JButton("Start");
		if(foosObsSettings.getTimeOutTimerHotKey().isEmpty()) {
			btnTimeOutTimer.setMnemonic(-1);
		} else {
			btnTimeOutTimer.setMnemonic(foosObsSettings.getTimeOutTimerHotKey().charAt(0));
		};
		btnTimeOutTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startTimeOutTimer();
			}
		});
		add(btnTimeOutTimer, "cell 6 19,growx");
		
		JButton btnClearAll = new JButton("Clear All");
		if(foosObsSettings.getClearAllHotKey().isEmpty()) {
			btnClearAll.setMnemonic(-1);
		} else {
			btnClearAll.setMnemonic(foosObsSettings.getClearAllHotKey().charAt(0));
		};
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAll();
			}
		});
		add(btnClearAll, "cell 3 20,growx");
		
		JLabel lblGameTimer = new JLabel("Game Timer");
		add(lblGameTimer, "cell 5 20,alignx right");

		btnGameTimer = new JButton("Start");
		if(foosObsSettings.getGameTimerHotKey().isEmpty()) {
			btnGameTimer.setMnemonic(-1);
		} else {
			btnGameTimer.setMnemonic(foosObsSettings.getGameTimerHotKey().charAt(0));
		};
		btnGameTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGameTimer();
			}
		});
		add(btnGameTimer, "cell 6 20,growx");
		
		JButton btnTimerWindow = new JButton("Timer Window");
		btnTimerWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame timerWindowFrame = new JFrame("Foos OBS Timer Window");
				timerWindowFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				timerWindowFrame.setAlwaysOnTop(true);
				if (lblTimerDisplay == null) {
					System.out.println("lblTimerDisplay is null");
				}
				twjp = new TimerWindowJPanel(lblTimerDisplay.getText().trim(), lblTimerDisplay.getBackground());
				twjp.setPreferredSize(new Dimension(256, 70));

				timerWindowFrame.getContentPane().add(twjp);
				timerWindowFrame.pack();
				timerWindowFrame.setVisible(true);
			}
		});
		add(btnTimerWindow, "cell 0 21");

		JLabel lblRecallTimer = new JLabel("Recall Timer");
		add(lblRecallTimer, "cell 5 21,alignx right");
		
		btnRecallTimer = new JButton("Start");
		if(foosObsSettings.getRecallTimerHotKey().isEmpty()) {
			btnRecallTimer.setMnemonic(-1);
		} else {
			btnRecallTimer.setMnemonic(foosObsSettings.getRecallTimerHotKey().charAt(0));
		};
		btnRecallTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startRecallTimer();
			}
		});
		add(btnRecallTimer, "cell 6 21,growx");
		
		formattedTxtPath = new JFormattedTextField(defaultFilePath);
		formattedTxtPath.setText(foosObsSettings.getDatapath());
		formattedTxtPath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
		    	try {
					obsInterface.setFilePath(formattedTxtPath.getText());
					foosObsSettings.setDatapath(formattedTxtPath.getText());
					foosObsSettings.saveToConfig();
		    	} catch (IOException ex) {
		    		System.out.print("Error saving properties file: " + ex.getMessage());		
		    	}
			}
		});
		formattedTxtPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				int key = evt.getKeyCode();
			    if (key == KeyEvent.VK_ENTER) {
			    	try {
						obsInterface.setFilePath(formattedTxtPath.getText());
						foosObsSettings.setDatapath(formattedTxtPath.getText());
						foosObsSettings.saveToConfig();
			    	} catch (IOException ex) {
			    		System.out.print("Error saving properties file: " + ex.getMessage());		
			    	}
			    }
			}
		});
		add(formattedTxtPath, "cell 1 22,growx");
		
		JButton btnSelectPath = new JButton("Select Path");
		if(foosObsSettings.getSelectPathHotKey().isEmpty()) {
			btnSelectPath.setMnemonic(-1);
		} else {
			btnSelectPath.setMnemonic(foosObsSettings.getSelectPathHotKey().charAt(0));
		};
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
						foosObsSettings.setDatapath(formattedTxtPath.getText());
						foosObsSettings.saveToConfig();
					} catch (IOException ex) {
						System.out.print("Error saving properties file: " + ex.getMessage());		
					}
				}
			}
		});
		add(btnSelectPath, "cell 0 22,growx");
		
		JButton btnFetchData = new JButton("Fetch Data");
		if(foosObsSettings.getFetchDataHotKey().isEmpty()) {
			btnFetchData.setMnemonic(-1);
		} else {
			btnFetchData.setMnemonic(foosObsSettings.getFetchDataHotKey().charAt(0));
		};
		btnFetchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fetchAll();
			}
		});
		add(btnFetchData, "cell 3 22,growx");
		
		JButton btnSetPath = new JButton("Set Path");
		if(foosObsSettings.getSetPathHotKey().isEmpty()) {
			btnSetPath.setMnemonic(-1);
		} else {
			btnSetPath.setMnemonic(foosObsSettings.getSetPathHotKey().charAt(0));
		};
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
					foosObsSettings.setDatapath(formattedTxtPath.getText());
					foosObsSettings.saveToConfig();
				} catch (IOException ex) {
					System.out.print("Error saving properties file: " + ex.getMessage());		
				}
			}
		});
		add(btnSetPath, "cell 2 22,growx");
		
		JButton btnSaveAll = new JButton("Save All");
		if(foosObsSettings.getSaveAllHotKey().isEmpty()) {
			btnSaveAll.setMnemonic(-1);
		} else {
			btnSaveAll.setMnemonic(foosObsSettings.getSaveAllHotKey().charAt(0));
		};
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAll();
			}
		});
		add(btnSaveAll, "cell 4 22,growx");
		
		JButton btnSettings = new JButton("Settings");
		if(foosObsSettings.getSettingsHotKey().isEmpty()) {
			btnSettings.setMnemonic(-1);
		} else {
			btnSettings.setMnemonic(foosObsSettings.getSettingsHotKey().charAt(0));
		};
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame settingsFrame = new JFrame("Foos OBS Settings");
				settingsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				SettingsJPanel p;
				try {
					settingsFrame.setAlwaysOnTop(true);
					p = new SettingsJPanel(foosObsSettings, settingsFrame);
					p.setPreferredSize(new Dimension(550, 380));

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
		add(btnSettings, "cell 6 22,growx");
		
		JCheckBox chckbxAlwaysOnTop = new JCheckBox("Always On Top");
		chckbxAlwaysOnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				f.setAlwaysOnTop(chckbxAlwaysOnTop.isSelected());
			}
		});
		chckbxAlwaysOnTop.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlwaysOnTop.setSelected(f.isAlwaysOnTop());
		add(chckbxAlwaysOnTop, "cell 5 22,alignx right");
		
		lblTimerDisplay = new JLabel(" 0.0 ");
		lblTimerDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimerDisplay.setOpaque(true);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerDisplay.setFont(new Font("Consolas", Font.BOLD, 50));
		add(lblTimerDisplay, "cell 2 1 3 1,alignx center,aligny center");
		if (twjp != null) {
			twjp.setTimerWindowColor(Color.GREEN);
		}
		postInitialize();

    }

    private void postInitialize() {
		fetchAll();
    }

    private void initialize() throws IOException {
    	timeClock = new TimeClock();
		obsInterface = new OBSInterface();
		foosObsSettings = new Settings();
		obsInterface.setFilePath(foosObsSettings.getDatapath());
    	try {
    	logoLinkURI = new URI(foosObsSettings.getLogoLinkURI());
    	} catch (URISyntaxException ex) {
			System.out.print("Error in URI Syntax: " + ex.getMessage());		
		}
		ImageIcon defaultLogoImageIcon = new ImageIcon(getClass().getResource(foosObsSettings.getDefaultLogoImageURL()));
		ImageIcon settingsLogoImageIcon = new ImageIcon(foosObsSettings.getLogoImageURL());
		if (foosObsSettings.getDefaultLogoImageURL().equals(settingsLogoImageIcon.toString())) {
			imageIcon = defaultLogoImageIcon;
		} else {
			imageIcon = settingsLogoImageIcon;
		}
	
		clearMatchWinner();
    }
    
	private boolean isValidInteger(String checkString) {
    	try {
    		Integer.parseInt(checkString);
    		return true;
    	} catch (NumberFormatException e) {
    		return false;
    	}
	}

	private void writeTournamentName() {
    	try {
    		obsInterface.setContents(foosObsSettings.getTournamentFileName(), txtTournamentName.getText());
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
    		obsInterface.setContents(foosObsSettings.getEventFileName(), txtEventName.getText());
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
			obsInterface.setContents(foosObsSettings.getTeam1FileName(), txtTeam1.getText());
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
			obsInterface.setContents(foosObsSettings.getTeam2FileName(), txtTeam2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearTeam2Name() {
		txtTeam2.setText(null);
		writeTeam2Name();
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
    		obsInterface.setContents(foosObsSettings.getGameCount1FileName(), txtGameCount1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

	private void decrementGameCount1() {
		int num1;
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtGameCount1.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtGameCount1.setText(Integer.toString(num1));
		writeGameCount1();
		clearMatchWinner();
		if (foosObsSettings.getAnnounceWinner()==1) {
			if (txtGameCount2.getText().isEmpty()) {
				txtGameCount2.setText(Integer.toString(0));
			}
			if(Integer.parseInt(txtGameCount2.getText()) == foosObsSettings.getGamesToWin()) {
				writeMatchWinner(foosObsSettings.getWinnerPrefix() + txtTeam2.getText() + foosObsSettings.getWinnerSuffix());
			}
		}
	}

	private void incrementGameCount1() {
		int num1;
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtGameCount1.getText());
		num1=num1+1;
		if (num1>foosObsSettings.getGamesToWin()) {
			num1 = foosObsSettings.getGamesToWin();
		}
		if (foosObsSettings.getAnnounceWinner()==1) {
			if (num1 == foosObsSettings.getGamesToWin()) {
				writeMatchWinner(foosObsSettings.getWinnerPrefix() + txtTeam1.getText() + foosObsSettings.getWinnerSuffix());
			}
		}
		txtGameCount1.setText(Integer.toString(num1));
		writeGameCount1();
		startGameTimer();
	}

	private void writeGameCount2() {
    	try {
    		obsInterface.setContents(foosObsSettings.getGameCount2FileName(), txtGameCount2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	private void decrementGameCount2() {
		int num1;
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtGameCount2.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtGameCount2.setText(Integer.toString(num1));
		writeGameCount2();
		clearMatchWinner();
		if (foosObsSettings.getAnnounceWinner()==1) {
			if (txtGameCount1.getText().isEmpty()) {
				txtGameCount1.setText(Integer.toString(0));
			}
			if(Integer.parseInt(txtGameCount1.getText()) == foosObsSettings.getGamesToWin()) {
				writeMatchWinner(foosObsSettings.getWinnerPrefix() + txtTeam1.getText() + foosObsSettings.getWinnerSuffix());
			}
		}
	}

	private void incrementGameCount2() {
		int num1;
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtGameCount2.getText());
		num1=num1+1;
		if (num1>foosObsSettings.getGamesToWin()) {
			num1 = foosObsSettings.getGamesToWin();
		}
		if (foosObsSettings.getAnnounceWinner()==1) {
			if (num1 == foosObsSettings.getGamesToWin()) {
				writeMatchWinner(foosObsSettings.getWinnerPrefix() + txtTeam2.getText() + foosObsSettings.getWinnerSuffix());			}
		}
		txtGameCount2.setText(Integer.toString(num1));
		writeGameCount2();
		startGameTimer();
	}
	
	private void writeScore1() {
		try {
			obsInterface.setContents(foosObsSettings.getScore1FileName(), txtScore1.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void decrementScore1() {
		int num1;
		if (txtScore1.getText().isEmpty()) {
			txtScore1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtScore1.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtScore1.setText(Integer.toString(num1));
		resetLastScored();
		writeScore1();
		if (txtScore2.getText().isEmpty()) {
			txtScore2.setText(Integer.toString(0));
		}
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		checkMeatball(num1, Integer.parseInt(txtScore2.getText()), Integer.parseInt(txtGameCount1.getText()), Integer.parseInt(txtGameCount2.getText()));
	}

	private void incrementScore1() {
		int num1;
		if (txtScore1.getText().isEmpty()) {
			txtScore1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtScore1.getText());
		num1=num1+1;
		txtScore1.setText(Integer.toString(num1));
		txtLastScored.setText("<-- Last Scored");
		writeTeam1LastScored();
		resetTimers();
		if (checkIfGameWon(num1, Integer.parseInt(txtScore2.getText()))) {
			incrementGameCount1();
			resetScores();
			resetTimeOuts();
		};
		writeScore1();
		if (txtScore2.getText().isEmpty()) {
			txtScore2.setText(Integer.toString(0));
		}
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		checkMeatball(num1, Integer.parseInt(txtScore2.getText()), Integer.parseInt(txtGameCount1.getText()), Integer.parseInt(txtGameCount2.getText()));
	}
	private boolean checkIfGameWon(int points1, int points2) {
		int pointsToWin = foosObsSettings.getPointsToWin();
		int maxWin = foosObsSettings.getMaxWin();
		int winBy = foosObsSettings.getWinBy();
		if (foosObsSettings.getAutoIncrementGame()==1) {
			if (points1 >= maxWin || (points1 >= pointsToWin && points1 >= points2 + winBy)) {
				return true;
			}
		}
		return false;
	}

	private void writeScore2() {
		try {
			obsInterface.setContents(foosObsSettings.getScore2FileName(), txtScore2.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void decrementScore2() {
		int num1;
		if (txtScore2.getText().isEmpty()) {
			txtScore2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtScore2.getText());
		num1=num1-1;
		if (num1<0) {
			num1 = 0;
		}
		txtScore2.setText(Integer.toString(num1));
		resetLastScored();
		writeScore2();
		if (txtScore1.getText().isEmpty()) {
			txtScore1.setText(Integer.toString(0));
		}
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		checkMeatball(num1, Integer.parseInt(txtScore1.getText()), Integer.parseInt(txtGameCount1.getText()), Integer.parseInt(txtGameCount2.getText()));
	}

	private void incrementScore2() {
		int num1;
		if (txtScore2.getText().isEmpty()) {
			txtScore2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtScore2.getText());
		num1=num1+1;
		txtScore2.setText(Integer.toString(num1));
		txtLastScored.setText("    Last Scored -->");
		writeTeam2LastScored();
		resetTimers();
		if (checkIfGameWon(num1, Integer.parseInt(txtScore1.getText()))) {
			incrementGameCount2();
			resetScores();
			resetTimeOuts();
		};
		writeScore2();
		if (txtScore1.getText().isEmpty()) {
			txtScore1.setText(Integer.toString(0));
		}
		if (txtGameCount1.getText().isEmpty()) {
			txtGameCount1.setText(Integer.toString(0));
		}
		if (txtGameCount2.getText().isEmpty()) {
			txtGameCount2.setText(Integer.toString(0));
		}
		checkMeatball(num1, Integer.parseInt(txtScore1.getText()), Integer.parseInt(txtGameCount1.getText()), Integer.parseInt(txtGameCount2.getText()));
	}
	
	private void checkMeatball(int points1, int points2, int gameCount1, int gameCount2) {
		if (foosObsSettings.getAnnounceMeatball() == 1) {
			if (points1 == points2) {
				int meatballPoint = foosObsSettings.getPointsToWin() - 1;
				if (foosObsSettings.getWinBy() < 2) {
					if (points1 == meatballPoint) {
						if (gameCount1 == gameCount2) {
							if (gameCount1 == foosObsSettings.getGamesToWin()-1) {
								writeMeatball();
								return;
							}
						}
					}
				}
			}
		}
		clearMeatball();
	}

	private void writeMatchWinner(String theContents) {
		try {
			obsInterface.setContents(foosObsSettings.getMatchWinnerFileName(), theContents);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	private void clearMatchWinner() {
		try {
			obsInterface.setContents(foosObsSettings.getMatchWinnerFileName(), "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeMeatball() {
		try {
			obsInterface.setContents(foosObsSettings.getMeatballFileName(), foosObsSettings.getMeatball());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void clearMeatball() {
		try {
			obsInterface.setContents(foosObsSettings.getMeatballFileName(), "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTeam1LastScored() {
		try {
			obsInterface.setContents(foosObsSettings.getLastScoredFileName(), foosObsSettings.getTeam1LastScored());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeTeam2LastScored() {
		try {
			obsInterface.setContents(foosObsSettings.getLastScoredFileName(), foosObsSettings.getTeam2LastScored());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeClearLastScored() {
		try {
			obsInterface.setContents(foosObsSettings.getLastScoredFileName(), foosObsSettings.getClearLastScored());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
		clearMatchWinner();
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
    		obsInterface.setContents(foosObsSettings.getTimeOut1FileName(), txtTimeOut1.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void writeTimeOut2() {
    	try {
    		obsInterface.setContents(foosObsSettings.getTimeOut2FileName(), txtTimeOut2.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void decrementTimeOut1() {
		int num1;
		if (txtTimeOut1.getText().isEmpty()) {
			txtTimeOut1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtTimeOut1.getText());
		if (foosObsSettings.getShowTimeOutsUsed() == 1) {
			num1=num1+1;
			if (num1>foosObsSettings.getMaxTimeOuts()) {
				num1 = foosObsSettings.getMaxTimeOuts();
			}
		} else {
			num1=num1-1;
			if (num1<0) {
				num1 = 0;
			}
		}
		txtTimeOut1.setText(Integer.toString(num1));
		try {
			obsInterface.setContents(foosObsSettings.getTimeOut1FileName(), txtTimeOut1.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void decrementTimeOut2() {
		int num1;
		if (txtTimeOut2.getText().isEmpty()) {
			txtTimeOut2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtTimeOut2.getText());
		if (foosObsSettings.getShowTimeOutsUsed() == 1) {
			num1=num1+1;
			if (num1>foosObsSettings.getMaxTimeOuts()) {
				num1 = foosObsSettings.getMaxTimeOuts();
			}
		} else {
			num1=num1-1;
			if (num1<0) {
				num1 = 0;
			}
		}
		txtTimeOut2.setText(Integer.toString(num1));
		try {
			obsInterface.setContents(foosObsSettings.getTimeOut2FileName(), txtTimeOut2.getText());
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
		if (txtTimeOut1.getText().isEmpty()) {
			txtTimeOut1.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtTimeOut1.getText());
		if (foosObsSettings.getShowTimeOutsUsed() == 1) {
			num1=num1-1;
			if (num1<0) {
				num1 = 0;
			}
		} else {
			num1=num1+1;
			if (num1>foosObsSettings.getMaxTimeOuts()) {
				num1 = foosObsSettings.getMaxTimeOuts();
			}
		}
		txtTimeOut1.setText(Integer.toString(num1));
		writeTimeOut1();
		startTimeOutTimer();
	}
	
	private void incrementTimeOut2() {
		int num1;
		if (txtTimeOut2.getText().isEmpty()) {
			txtTimeOut2.setText(Integer.toString(0));
		}
		num1=Integer.parseInt(txtTimeOut2.getText());
		if (foosObsSettings.getShowTimeOutsUsed() == 1) {
			num1=num1-1;
			if (num1<0) {
				num1 = 0;
			}
		} else {
			num1=num1+1;
			if (num1>foosObsSettings.getMaxTimeOuts()) {
				num1 = foosObsSettings.getMaxTimeOuts();
			}
		}
		txtTimeOut2.setText(Integer.toString(num1));
		writeTimeOut2();
		startTimeOutTimer();
	}

	private void writeReset1() {
		try {
			if(tglbtnReset1.isSelected()) {
				obsInterface.setContents(foosObsSettings.getReset1FileName(), "RESET");
			} else {
				obsInterface.setContents(foosObsSettings.getReset1FileName(), "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void writeReset2() {
		try {
			if(tglbtnReset2.isSelected()) {
				obsInterface.setContents(foosObsSettings.getReset2FileName(), "RESET");
			} else {
				obsInterface.setContents(foosObsSettings.getReset2FileName(), "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeWarn1() {
		try {
			if(tglbtnWarn1.isSelected()) {
				obsInterface.setContents(foosObsSettings.getWarn1FileName(), "WARNING");
			} else {
				obsInterface.setContents(foosObsSettings.getWarn1FileName(), "");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeWarn2() {
		try {
			if(tglbtnWarn2.isSelected()) {
				obsInterface.setContents(foosObsSettings.getWarn2FileName(), "WARNING");
			} else {
				obsInterface.setContents(foosObsSettings.getWarn2FileName(), "");
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
			obsInterface.setContents(foosObsSettings.getTimerInUseFileName(), lblTimerInUse.getText());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void writeTimeRemaining() {
		try {
			obsInterface.setContents(foosObsSettings.getTimeRemainingFileName(), lblTimerDisplay.getText().trim());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void updateTimerWindow() {
		if (twjp != null) {
			twjp.setTimerWindowText(lblTimerDisplay.getText().trim());
			twjp.setTimerWindowColor(lblTimerDisplay.getBackground());
		}
	}
	
	private void writeLastScored() {
    	try {
    		if (txtLastScored.getText().equals("<-- Last Scored")) {
    			writeTeam1LastScored();
    		} else if (txtLastScored.getText().equals("    Last Scored -->")) {
    			writeTeam2LastScored();
    		} else {
    			writeClearLastScored();
    		}
   		obsInterface.setContents(foosObsSettings.getLastScoredFileName(), txtLastScored.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void switchLastScored() {
		if (txtLastScored.getText().equals("<-- Last Scored")) {
			txtLastScored.setText("    Last Scored -->");
			writeTeam2LastScored();
		} else if (txtLastScored.getText().equals("    Last Scored -->")) {
			txtLastScored.setText("<-- Last Scored");
			writeTeam1LastScored();
		}
//		writeLastScored();
	}

	private void resetTimeOuts() {
		if (foosObsSettings.getShowTimeOutsUsed() == 1) {
			txtTimeOut1.setText(Integer.toString(foosObsSettings.getMaxTimeOuts()));
			txtTimeOut2.setText(Integer.toString(foosObsSettings.getMaxTimeOuts()));
		} else {
			txtTimeOut1.setText("0");
			txtTimeOut2.setText("0");
		}
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
	
	private void resetLastScored() {
		txtLastScored.setText("   Last Scored    ");
		writeClearLastScored();
//		writeLastScored();
	}
	
	private void resetAll() {
		resetGameCounts();
		resetScores();
		resetTimeOuts();
		resetResetWarns();
		resetLastScored();
	}

	private void switchAll() {
		switchTeamNames();
		switchGameCount();
		switchScore();
		switchTimeOut();
		switchResetWarn();
		switchLastScored();
	}

	private void updateTimerDisplay() {
		int timeRemaining = timeClock.getTimeRemaining();
		int nbrOfSeconds = timeClock.getNbrOfSeconds();
		int nbrOfMinutes = 0;
		int displaySeconds = 0;
		if(timeRemaining <= 0 && nbrOfSeconds != 0) {
			lblTimerDisplay.setBackground(Color.RED);
			if (twjp != null) {
				twjp.setTimerWindowColor(Color.RED);
			}
		}
		float tr = (float) timeRemaining / 10f;
		if(Float.compare(tr, 60f) > 0) {
			nbrOfMinutes = (int) (tr / 60);
			displaySeconds = (timeRemaining - (nbrOfMinutes * 600))/10;

			String timeLeft = new String(nbrOfMinutes + ":" + String.format("%02d", displaySeconds));
			prefixWidth = displayWidth - timeLeft.length() - suffixWidth;
			char[] c1 = new char[prefixWidth];
		    Arrays.fill(c1, ' ');
		    char[] c2 = new char[suffixWidth];
		    Arrays.fill(c2, ' ');
			lblTimerDisplay.setText(String.valueOf(c1) + timeLeft + String.valueOf(c2));
			
		} else {


			String timeLeft = new String(Float.toString(tr));
			prefixWidth = displayWidth - timeLeft.length() - suffixWidth;
			char[] c1 = new char[prefixWidth];
		    Arrays.fill(c1, ' ');
		    char[] c2 = new char[suffixWidth];
		    Arrays.fill(c2, ' ');
			lblTimerDisplay.setText(String.valueOf(c1) + timeLeft + String.valueOf(c2));
			
			
//		lblTimerDisplay.setText("   " + Float.toString(tr) + "   ");
		}
		if(tr == (int) tr) {
			writeTimeRemaining();
		};
			if (twjp != null) {
//				updateTimerWindow(twjp);
				updateTimerWindow();
			};
	}
	
	private void resetTimers() {
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Timer Reset");
		writeTimerInUse();
		timeClock.resetTimer(0);
	}

	private void startShotTimer() {
		int count = (int) (foosObsSettings.getShotTime() * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Shot Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}
	
	private void startPassTimer() {
		int count = (int) (foosObsSettings.getPassTime() * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Pass Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}

	private void startTimeOutTimer() {
		int count = (int) (foosObsSettings.getTimeOutTime() * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Time Out Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}
	
	private void startRecallTimer() {
		int count = (int) (foosObsSettings.getRecallTime() * 10 * 60);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Recall Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}

	private void startGameTimer() {
		int count = (int) (foosObsSettings.getGameTime() * 10);
		lblTimerDisplay.setBackground(Color.GREEN);
		lblTimerInUse.setText("Game Timer");
		writeTimerInUse();
		timeClock.resetTimer(count);
	}
	
	private void fetchAll() {
		try {
			txtTournamentName.setText(obsInterface.getContents(foosObsSettings.getTournamentFileName()));
			txtEventName.setText(obsInterface.getContents(foosObsSettings.getEventFileName()));
			txtTeam1.setText(obsInterface.getContents(foosObsSettings.getTeam1FileName()));
			txtTeam2.setText(obsInterface.getContents(foosObsSettings.getTeam2FileName()));
			txtGameCount1.setText(obsInterface.getContents(foosObsSettings.getGameCount1FileName()));
			txtGameCount2.setText(obsInterface.getContents(foosObsSettings.getGameCount2FileName()));
			txtScore1.setText(obsInterface.getContents(foosObsSettings.getScore1FileName()));
			txtScore2.setText(obsInterface.getContents(foosObsSettings.getScore2FileName()));
			txtTimeOut1.setText(obsInterface.getContents(foosObsSettings.getTimeOut1FileName()));
			txtTimeOut2.setText(obsInterface.getContents(foosObsSettings.getTimeOut2FileName()));
			tglbtnReset1.setSelected(obsInterface.getContents(foosObsSettings.getReset1FileName())!=null);
			tglbtnReset2.setSelected(obsInterface.getContents(foosObsSettings.getReset2FileName())!=null);
			tglbtnWarn1.setSelected(obsInterface.getContents(foosObsSettings.getWarn1FileName())!=null);
			tglbtnWarn2.setSelected(obsInterface.getContents(foosObsSettings.getWarn2FileName())!=null);
			txtLastScored.setText(obsInterface.getContents(foosObsSettings.getLastScoredFileName()));
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
		resetLastScored();
		saveAll();
		clearMatchWinner();
		clearMeatball();
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
		writeLastScored();
	}

}

