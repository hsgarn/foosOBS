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
	private JFormattedTextField formattedTxtPath;
	private File configFile = new File("config.properties");
	private Properties configProps;
	private int maxGameCount = 3, maxTimeOut = 2, maxScore = 9;
	private int shotTimerValue = 15, passTimerValue = 10, timeOutTimerValue = 30, gameTimerValue = 90, recallTimerValue = 10;
	private String defaultFilePath = "c:\\temp";
	JButton btnGameTimer;
	JLabel lblTimerDisplay;
	JLabel lblTimerInUse;
	TimeClock timeClock;
	ActionListener alAction;
	OBSInterface obsInterface;
	JFrame f;
	/**
	 * Create the panel.
	 **/
    public MainJPanel(JFrame f) throws IOException {
		timeClock = new TimeClock();
		obsInterface = new OBSInterface();
		try {
			loadProperties();
		} catch (IOException ex) {
			System.out.print("The config.properties file does not exist, default properties loaded.\r\n");
			System.out.print("did we get this far?" + " " + configProps.getProperty("datapath") + "\r\n");
		}

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
			    	try {
			    		obsInterface.setContents("tournament.txt", txtTournamentName.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtTournamentName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent evt) {
				try {
					obsInterface.setContents("tournament.txt", txtTournamentName.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		txtTournamentName.setText("High Pockets Monday Night");
		add(txtTournamentName, "flowy,cell 1 1,growx");
		txtTournamentName.setColumns(10);
		
		JButton btnTournamentNameClear = new JButton("X");
		btnTournamentNameClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTournamentName.setText(null);
				try {
					obsInterface.setContents("tournament.txt", txtTournamentName.getText());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("event.txt", txtEventName.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtEventName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("event.txt", txtEventName.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnEventClear = new JButton("X");
		btnEventClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEventName.setText(null);
				try {
					obsInterface.setContents("event.txt", txtEventName.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnEventClear, "cell 4 1,alignx right");
		txtEventName.setText("DYP #1");
		add(txtEventName, "flowx,cell 5 1,growx");
		txtEventName.setColumns(10);
		
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
			    	try {
			    		obsInterface.setContents("team1.txt", txtTeam1.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtTeam1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("team1.txt", txtTeam1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtTeam1, "cell 1 4,growx");
		txtTeam1.setColumns(10);
		
		JButton btnTeam1Clear = new JButton("X");
		btnTeam1Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeam1.setText(null);
			}
		});
		add(btnTeam1Clear, "cell 2 4,alignx left,aligny bottom");
		
		JButton btnTeamSwitch = new JButton("<->");
		btnTeamSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtTeam1.getText();
				txtTeam1.setText(txtTeam2.getText());
				txtTeam2.setText(temp1);
				try {
					obsInterface.setContents("team1.txt", txtTeam1.getText());
					obsInterface.setContents("team2.txt", txtTeam2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("team2.txt", txtTeam2.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtTeam2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("team2.txt", txtTeam2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnTeam2Clear = new JButton("X");
		btnTeam2Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTeam2.setText(null);
			}
		});
		add(btnTeam2Clear, "cell 4 4,alignx right");
		add(txtTeam2, "flowx,cell 5 4,growx");
		txtTeam2.setColumns(10);
		
		JButton btnTeam1NameSwitch = new JButton("<->");
		btnTeam1NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team = txtTeam1.getText();
				int index = team.indexOf("/");
				if (index>-1) {
					String player1 = team.substring(0,index);
					String player2 = team.substring(index+1);
					txtTeam1.setText(player2+"/"+player1);
					try {
						obsInterface.setContents("team1.txt", txtTeam1.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		JLabel lblName2 = new JLabel("Name");
		add(lblName2, "cell 6 4,alignx left");
		add(btnTeam1NameSwitch, "cell 1 5,alignx center");
		
		JButton btnTeam2NameSwitch = new JButton("<->");
		btnTeam2NameSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String team = txtTeam2.getText();
				int index = team.indexOf("/");
				if (index>-1) {
					String player1 = team.substring(0,index);
					String player2 = team.substring(index+1);
					txtTeam2.setText(player2+"/"+player1);
					try {
						obsInterface.setContents("team2.txt", txtTeam2.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
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
				int num1;
				num1=Integer.parseInt(txtGameCount1.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtGameCount1.setText(Integer.toString(num1));
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtGameCount1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtGameCount1, "cell 1 7,growx");
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
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnGameCount1Plus, "cell 2 7,growx");
		
		JButton btnGameCountSwitch = new JButton("<->");
		btnGameCountSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtGameCount1.getText();
				txtGameCount1.setText(txtGameCount2.getText());
				txtGameCount2.setText(temp1);
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnGameCountSwitch, "cell 3 7,growx");
		
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
				try {
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtGameCount2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtGameCount2, "cell 5 7,growx");
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
				try {
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
				int num1;
				num1=Integer.parseInt(txtScore1.getText());
				num1=num1-1;
				if (num1<0) {
					num1 = 0;
				}
				txtScore1.setText(Integer.toString(num1));
				try {
					obsInterface.setContents("score1.txt", txtScore1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("score1.txt", txtScore1.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtScore1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("score1.txt", txtScore1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtScore1, "cell 1 9,growx");
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
				txtScore1.setText(Integer.toString(num1));
				try {
					obsInterface.setContents("score1.txt", txtScore1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnScore1Plus, "cell 2 9,growx");
		
		JButton btnScoreSwitch = new JButton("<->");
		btnScoreSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtScore1.getText();
				txtScore1.setText(txtScore2.getText());
				txtScore2.setText(temp1);
				try {
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnScoreSwitch, "cell 3 9,growx");
		
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
				try {
					obsInterface.setContents("score2.txt", txtScore2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("score2.txt", txtScore2.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtScore2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("score2.txt", txtScore2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtScore2, "cell 5 9,growx");
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
				try {
					obsInterface.setContents("score2.txt", txtScore2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtTimeOut1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtTimeOut1, "cell 1 11,growx");
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
				try {
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnTimeOut1Plus, "cell 2 11,growx");
		
		JButton btnTimeOutSwitch = new JButton("<->");
		btnTimeOutSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String temp1 = txtTimeOut1.getText();
				txtTimeOut1.setText(txtTimeOut2.getText());
				txtTimeOut2.setText(temp1);
				try {
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnTimeOutSwitch, "cell 3 11,growx");
		
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
				try {
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
			    	try {
			    		obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}
		});
		txtTimeOut2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(txtTimeOut2, "cell 5 11,growx");
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
				try {
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnTimeOut2Plus, "cell 6 11,growx");
		
		JToggleButton tglbtnReset1 = new JToggleButton("Reset");
		tglbtnReset1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
		});
		add(tglbtnReset1, "cell 0 12,growx");
		
		JToggleButton tglbtnWarn1 = new JToggleButton(" Warn ");
		tglbtnWarn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
		});
		add(tglbtnWarn1, "cell 2 12,growx");
		
		JToggleButton tglbtnReset2 = new JToggleButton("Reset");
		tglbtnReset2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
		});
		add(tglbtnReset2, "cell 4 12,growx");
		
		JToggleButton tglbtnWarn2 = new JToggleButton(" Warn ");
		tglbtnWarn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
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
		});
		add(tglbtnWarn2, "cell 6 12,growx");

		JButton btnResetSwitch = new JButton("<->");
		btnResetSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean sel1 = tglbtnReset1.isSelected();
				tglbtnReset1.setSelected(tglbtnReset2.isSelected());
				tglbtnReset2.setSelected(sel1);
				boolean sel2 = tglbtnWarn1.isSelected();
				tglbtnWarn1.setSelected(tglbtnWarn2.isSelected());
				tglbtnWarn2.setSelected(sel2);
				try {
					if(tglbtnReset1.isSelected()) {
						obsInterface.setContents("reset1.txt", "RESET");
					} else {
						obsInterface.setContents("reset1.txt", "");
					}
					if(tglbtnReset2.isSelected()) {
						obsInterface.setContents("Reset2.txt", "RESET");
					} else {
						obsInterface.setContents("Reset2.txt", "");
					}
					if(tglbtnWarn1.isSelected()) {
						obsInterface.setContents("warn1.txt", "WARNING");
					} else {
						obsInterface.setContents("warn1.txt", "");
					}
					if(tglbtnWarn2.isSelected()) {
						obsInterface.setContents("warn2.txt", "WARNING");
					} else {
						obsInterface.setContents("warn2.txt", "");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnResetSwitch, "cell 3 12,growx");
		
		JButton btnResetGameCounts = new JButton("Reset Game Counts");
		btnResetGameCounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtGameCount1.setText("0");
				txtGameCount2.setText("0");
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnResetGameCounts, "cell 1 13,growx");
		
		JButton btnResetScores = new JButton("Reset Scores");
		btnResetScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtScore1.setText("0");
				txtScore2.setText("0");
				try {
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblTimerInUse = new JLabel("Timer Reset");
		lblTimerInUse.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblTimerInUse, "cell 3 18,growx");
		
		JButton btnResetTimers = new JButton("Reset Timer");
		btnResetTimers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Timer Reset");
				try {
					obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(0);
			}
		});
		add(btnResetTimers, "cell 5 13,growx,aligny bottom");
		add(btnResetScores, "cell 1 14,growx");
		
		JButton btnResetTimeOuts = new JButton("Reset Time Outs");
		btnResetTimeOuts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTimeOut1.setText("0");
				txtTimeOut2.setText("0");
				try {
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnResetTimeOuts, "cell 1 15,growx");
		
		JButton btnResetResetWarn = new JButton("Reset Reset/Warn");
		btnResetResetWarn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tglbtnReset1.setSelected(false);
				tglbtnReset2.setSelected(false);
				tglbtnWarn1.setSelected(false);
				tglbtnWarn2.setSelected(false);
			}
		});
		add(btnResetResetWarn, "cell 1 16,growx");
		
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
				try {
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
					obsInterface.setContents("reset1.txt", "");
					obsInterface.setContents("Reset2.txt", "");
					obsInterface.setContents("warn1.txt", "");
					obsInterface.setContents("warn2.txt", "");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnResetAll, "cell 1 17,growx");
		
		JButton btnAllSwitch = new JButton("<--------------------------------------------->");
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
				tglbtnWarn2.setSelected(sel2);
				try {
					obsInterface.setContents("team1.txt", txtTeam1.getText());
					obsInterface.setContents("team2.txt", txtTeam2.getText());
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
					if(tglbtnReset1.isSelected()) {
						obsInterface.setContents("reset1.txt", "RESET");
					} else {
						obsInterface.setContents("reset1.txt", "");
					}
					if(tglbtnReset2.isSelected()) {
						obsInterface.setContents("Reset2.txt", "RESET");
					} else {
						obsInterface.setContents("Reset2.txt", "");
					}
					if(tglbtnWarn1.isSelected()) {
						obsInterface.setContents("warn1.txt", "WARNING");
					} else {
						obsInterface.setContents("warn1.txt", "");
					}
					if(tglbtnWarn2.isSelected()) {
						obsInterface.setContents("warn2.txt", "WARNING");
					} else {
						obsInterface.setContents("warn2.txt", "");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
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
				int timeRemaining = timeClock.getTimeRemaining();
				int nbrOfSeconds = timeClock.getNbrOfSeconds();
				if(timeRemaining <= 0 && nbrOfSeconds != 0) {
					lblTimerDisplay.setBackground(Color.RED);
				}
				float tr = (float) timeRemaining / 10f;
				lblTimerDisplay.setText("   " + Float.toString(tr) + "   ");
				if(tr == (int) tr) {
					try {
						obsInterface.setContents("timeremaining.txt", Float.toString(tr));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				};
			}
		};
		timeClock.addTimeClockTimerListener(alAction);
		add(lblTimerDisplay, "cell 2 14 3 4,alignx center,aligny center");
		
		JLabel lblNonPossession = new JLabel("Shot Timer (2 & 3 row)");
		add(lblNonPossession, "cell 5 14,alignx right");
		
		JButton btnPossessionTimer = new JButton(Integer.toString(shotTimerValue));
		btnPossessionTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = (int) (Integer.parseInt(btnPossessionTimer.getText()) * 10);
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Shot Timer");
				try {
				obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(count);
			}
		});
		add(btnPossessionTimer, "cell 6 14,growx");
		
		JLabel lblRowPossession = new JLabel("Pass Timer (5 row)");
		add(lblRowPossession, "cell 5 15,alignx right");
		
		JButton btn5RowTimer = new JButton(Integer.toString(passTimerValue));
		btn5RowTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = (int) (Integer.parseInt(btn5RowTimer.getText()) * 10);
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Pass Timer");
				try {
				obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(count);
			}
		});
		add(btn5RowTimer, "cell 6 15,growx,aligny bottom");
		
		JLabel lblTimeOutTimer = new JLabel("Time Out Timer");
		add(lblTimeOutTimer, "cell 5 16,alignx right");
		
		JButton btnTimeOutTimer = new JButton(Integer.toString(timeOutTimerValue));
		btnTimeOutTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = (int) (Integer.parseInt(btnTimeOutTimer.getText()) * 10);
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Time Out Timer");
				try {
				obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(count);
			}
		});
		add(btnTimeOutTimer, "cell 6 16,growx");
		
		JLabel lblGameTimer = new JLabel("Game Timer");
		add(lblGameTimer, "cell 5 17,alignx right");
		
		JLabel lblRecallTimer = new JLabel("Recall Timer");
		add(lblRecallTimer, "cell 5 18,alignx right");
		
		JButton btnRecallTimer = new JButton(Integer.toString(recallTimerValue));
		btnRecallTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = (int) (Integer.parseInt(btnRecallTimer.getText()) * 10 * 60);
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Recall Timer");
				try {
				obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(count);
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
						saveProperties();
//						System.out.print("Properties were saved successfully!");
					} catch (IOException ex) {
						System.out.print("Error saving properties file: " + ex.getMessage());		
					}
				}
			}
		});
		add(btnSelectPath, "cell 0 19,growx");
		add(formattedTxtPath, "cell 1 19,growx");
		
		btnGameTimer = new JButton(Integer.toString(gameTimerValue));
		btnGameTimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int count = (int) (Integer.parseInt(btnGameTimer.getText()) * 10);
				lblTimerDisplay.setBackground(Color.GREEN);
				lblTimerInUse.setText("Game Timer");
				try {
				obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				timeClock.resetTimer(count);
			}
		});
		add(btnGameTimer, "cell 6 17,growx");
		
		JButton btnFetch = new JButton("Fetch Data");
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					saveProperties();
//					System.out.print("Properties were saved successfully!");
				} catch (IOException ex) {
					System.out.print("Error saving properties file: " + ex.getMessage());		
				}
			}
		});
		add(btnSetPath, "cell 2 19,growx");

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
				lblTimerDisplay.setBackground(Color.GREEN);
				timeClock.resetTimer(0);
				lblTimerInUse.setText("Timer Reset");
				try {
					obsInterface.setContents("tournament.txt", txtTournamentName.getText());
					obsInterface.setContents("event.txt", txtEventName.getText());
					obsInterface.setContents("team1.txt", txtTeam1.getText());
					obsInterface.setContents("team2.txt", txtTeam2.getText());
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
					obsInterface.setContents("reset1.txt", "");
					obsInterface.setContents("reset2.txt", "");
					obsInterface.setContents("warn1.txt", "");
					obsInterface.setContents("warn2.txt", "");
					obsInterface.setContents("timeremaining.txt", "0.0");
					obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnClearAll, "cell 3 0,growx");
		
		JCheckBox chckbxAlwaysOnTop = new JCheckBox("Always On Top");
		chckbxAlwaysOnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				f.setAlwaysOnTop(chckbxAlwaysOnTop.isSelected());
			}
		});
		
		JButton btnSaveAll = new JButton("Save All");
		btnSaveAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					obsInterface.setContents("tournament.txt", txtTournamentName.getText());
					obsInterface.setContents("event.txt", txtEventName.getText());
					obsInterface.setContents("team1.txt", txtTeam1.getText());
					obsInterface.setContents("team2.txt", txtTeam2.getText());
					obsInterface.setContents("gamecount1.txt", txtGameCount1.getText());
					obsInterface.setContents("gamecount2.txt", txtGameCount2.getText());
					obsInterface.setContents("score1.txt", txtScore1.getText());
					obsInterface.setContents("score2.txt", txtScore2.getText());
					obsInterface.setContents("timeout1.txt", txtTimeOut1.getText());
					obsInterface.setContents("timeout2.txt", txtTimeOut2.getText());
					obsInterface.setContents("timeremaining.txt", "0.0");
					obsInterface.setContents("timerinuse.txt", lblTimerInUse.getText());
					if(tglbtnReset1.isSelected()) {
						obsInterface.setContents("reset1.txt", "RESET");
					} else {
						obsInterface.setContents("reset1.txt", "");
					}
					if(tglbtnReset2.isSelected()) {
						obsInterface.setContents("Reset2.txt", "RESET");
					} else {
						obsInterface.setContents("Reset2.txt", "");
					}
					if(tglbtnWarn1.isSelected()) {
						obsInterface.setContents("warn1.txt", "WARNING");
					} else {
						obsInterface.setContents("warn1.txt", "");
					}
					if(tglbtnWarn2.isSelected()) {
						obsInterface.setContents("warn2.txt", "WARNING");
					} else {
						obsInterface.setContents("warn2.txt", "");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		add(btnSaveAll, "cell 4 19,growx");
		
		chckbxAlwaysOnTop.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlwaysOnTop.setSelected(f.isAlwaysOnTop());
		add(chckbxAlwaysOnTop, "cell 5 19,alignx right");
    }
	private void loadProperties() throws IOException {
		Properties defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("datapath", "c:" + File.separator + "temp");
		
		configProps = new Properties(defaultProps);
		
		// loads properties from file
		InputStream inputStream = new FileInputStream(configFile);
		configProps.load(inputStream);
		inputStream.close();
	}
	
	private void saveProperties() throws IOException {
		configProps.setProperty("datapath", formattedTxtPath.getText());
		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB setttings");
		outputStream.close();
	}

}
