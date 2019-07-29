package com.midsouthfoosball.foosobs;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FileNamesJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTournamentFileName;
	private JTextField txtEventFileName;
	private JTextField txtTeam1FileName;
	private JTextField txtTeam2FileName;
	private JTextField txtGameCount1FileName;
	private JTextField txtGameCount2FileName;

	private JTextField txtScore1FileName;
	private JTextField txtScore2FileName;
	private JTextField txtTimeOut1FileName;
	private JTextField txtTimeOut2FileName;
	private JTextField txtReset1FileName;
	private JTextField txtReset2FileName;
	private JTextField txtWarn1FileName;
	private JTextField txtWarn2FileName;
	private JTextField txtTimeRemainingFileName;
	private JTextField txtTimerFileName;
	private JTextField txtMatchWinnerFileName;

	/**
	 * Create the frame.
	 */
	public FileNamesJPanel(Settings foosObsSettings, JFrame fileNamesFrame) throws IOException {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 489);
		setLayout(new MigLayout("", "[][][151.00][15.00][][][]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblFileName = new JLabel("File Name");
		add(lblFileName, "cell 2 0,alignx left");
		
		JLabel lblNewLabel = new JLabel("File Name");
		add(lblNewLabel, "cell 5 0,alignx left,aligny center");
		
		JLabel lblTeam1FileName = new JLabel("Team 1:");
		add(lblTeam1FileName, "cell 1 1,alignx trailing");
		
		txtTeam1FileName = new JTextField();
		add(txtTeam1FileName, "cell 2 1,alignx left");
		txtTeam1FileName.setColumns(10);
		
		JLabel lblTournamentFileName = new JLabel("Tournament:");
		add(lblTournamentFileName, "cell 4 1,alignx right");
		
		txtTournamentFileName = new JTextField();
		add(txtTournamentFileName, "cell 5 1,alignx left");
		txtTournamentFileName.setColumns(10);
		
		JLabel lblTeam2FileName = new JLabel("Team 2:");
		add(lblTeam2FileName, "cell 1 2,alignx right");
		
		txtTeam2FileName = new JTextField();
		add(txtTeam2FileName, "cell 2 2,alignx left");
		txtTeam2FileName.setColumns(10);
		
		JLabel lblEventFileName = new JLabel("Event:");
		add(lblEventFileName, "cell 4 2,alignx trailing");
		
		txtEventFileName = new JTextField();
		add(txtEventFileName, "cell 5 2,alignx left");
		txtEventFileName.setColumns(10);
		
		JLabel lblGameCountFileName = new JLabel("Game Count 1:");
		add(lblGameCountFileName, "cell 1 3,alignx right");
		
		txtGameCount1FileName = new JTextField();
		add(txtGameCount1FileName, "cell 2 3,alignx left");
		txtGameCount1FileName.setColumns(10);
		
		JLabel lblTimeRemainingFileName = new JLabel("Time Remaining:");
		add(lblTimeRemainingFileName, "cell 4 3,alignx trailing");
		
		txtTimeRemainingFileName = new JTextField();
		add(txtTimeRemainingFileName, "cell 5 3,alignx left");
		txtTimeRemainingFileName.setColumns(10);

		JLabel lblGameCount2FileName = new JLabel("Game Count 2:");
		add(lblGameCount2FileName, "cell 1 4,alignx right");
		
		txtGameCount2FileName = new JTextField();
		add(txtGameCount2FileName, "cell 2 4,alignx left");
		txtGameCount2FileName.setColumns(10);
		
		JLabel lblTimerFileName = new JLabel("Timer:");
		add(lblTimerFileName, "cell 4 4,alignx trailing");
		
		txtTimerFileName = new JTextField();
		add(txtTimerFileName, "cell 5 4,alignx left");
		txtTimerFileName.setColumns(10);

		JLabel lblScore1FileName = new JLabel("Score 1:");
		add(lblScore1FileName, "cell 1 5,alignx trailing");
		
		txtScore1FileName = new JTextField();
		add(txtScore1FileName, "cell 2 5,alignx left");
		txtScore1FileName.setColumns(10);
		
		JLabel lblMatchWinnerFileName = new JLabel("Match Winner:");
		add(lblMatchWinnerFileName, "cell 4 5,alignx trailing");
		
		txtMatchWinnerFileName = new JTextField();
		add(txtMatchWinnerFileName, "cell 5 5,alignx left");
		txtMatchWinnerFileName.setColumns(10);
		
		JLabel lblScore2FileName = new JLabel("Score 2:");
		add(lblScore2FileName, "cell 1 6,alignx trailing");
		
		txtScore2FileName = new JTextField();
		add(txtScore2FileName, "cell 2 6,alignx left");
		txtScore2FileName.setColumns(10);
		
		JLabel lblTimeOut1FileName = new JLabel("Time Out 1:");
		add(lblTimeOut1FileName, "cell 1 7,alignx trailing");
		
		txtTimeOut1FileName = new JTextField();
		add(txtTimeOut1FileName, "cell 2 7,alignx left");
		txtTimeOut1FileName.setColumns(10);
		
		JLabel lblTimeOut2FileName = new JLabel("Time Out 2:");
		add(lblTimeOut2FileName, "cell 1 8,alignx trailing");
		
		txtTimeOut2FileName = new JTextField();
		add(txtTimeOut2FileName, "cell 2 8,alignx left");
		txtTimeOut2FileName.setColumns(10);
		
		JLabel lblReset1FileName = new JLabel("Reset 1:");
		add(lblReset1FileName, "cell 1 9,alignx trailing");
		
		txtReset1FileName = new JTextField();
		add(txtReset1FileName, "cell 2 9,alignx left");
		txtReset1FileName.setColumns(10);
		
		JLabel lblReset2FileName = new JLabel("Reset 2:");
		add(lblReset2FileName, "cell 1 10,alignx trailing");
		
		txtReset2FileName = new JTextField();
		add(txtReset2FileName, "cell 2 10,alignx left");
		txtReset2FileName.setColumns(10);
		
		JLabel lblWarn1FileName = new JLabel("Warn 1:");
		add(lblWarn1FileName, "cell 1 11,alignx trailing");
		
		txtWarn1FileName = new JTextField();
		add(txtWarn1FileName, "cell 2 11,alignx left");
		txtWarn1FileName.setColumns(10);
		
		JLabel lblWarn2FileName = new JLabel("Warn 2:");
		add(lblWarn2FileName, "cell 1 12,alignx trailing");
		
		txtWarn2FileName = new JTextField();
		add(txtWarn2FileName, "cell 2 12,alignx left");
		txtWarn2FileName.setColumns(10);
		
		JButton btnSaveFileNames = new JButton("Save");
		add(btnSaveFileNames, "cell 2 14,alignx center");
		
		JButton btnCancelFileNames = new JButton("Cancel");
		add(btnCancelFileNames, "cell 4 14,alignx center");
		
		JButton btnRestoreDefaults = new JButton("Restore Defaults");
		add(btnRestoreDefaults, "cell 5 14,alignx center");
		
	}

}
