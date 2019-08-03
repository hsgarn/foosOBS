package com.midsouthfoosball.foosobs;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField txtTimerInUseFileName;
	private JTextField txtMatchWinnerFileName;
	private JTextField txtMeatballFileName;

	/**
	 * Create the frame.
	 */
	public FileNamesJPanel(Settings foosObsSettings, JFrame fileNamesFrame) throws IOException {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 489);
		setLayout(new MigLayout("", "[][][151.00][15.00][][grow][]", "[][][][][][][][][][][][][][][]"));
		
		JLabel lblFileName = new JLabel("File Name");
		add(lblFileName, "cell 2 0,alignx left");
		
		JLabel lblNewLabel = new JLabel("File Name");
		add(lblNewLabel, "cell 5 0,alignx left,aligny center");
		
		JLabel lblTeam1FileName = new JLabel("Team 1:");
		add(lblTeam1FileName, "cell 1 1,alignx trailing");
		
		txtTeam1FileName = new JTextField();
		txtTeam1FileName.setText(foosObsSettings.getTeam1FileName());
		add(txtTeam1FileName, "cell 2 1,alignx left");
		txtTeam1FileName.setColumns(10);
		
		JLabel lblTournamentFileName = new JLabel("Tournament:");
		add(lblTournamentFileName, "cell 4 1,alignx right");
		
		txtTournamentFileName = new JTextField();
		txtTournamentFileName.setText(foosObsSettings.getTournamentFileName());
		add(txtTournamentFileName, "cell 5 1,alignx left");
		txtTournamentFileName.setColumns(10);
		
		JLabel lblTeam2FileName = new JLabel("Team 2:");
		add(lblTeam2FileName, "cell 1 2,alignx right");
		
		txtTeam2FileName = new JTextField();
		txtTeam2FileName.setText(foosObsSettings.getTeam2FileName());
		add(txtTeam2FileName, "cell 2 2,alignx left");
		txtTeam2FileName.setColumns(10);
		
		JLabel lblEventFileName = new JLabel("Event:");
		add(lblEventFileName, "cell 4 2,alignx trailing");
		
		txtEventFileName = new JTextField();
		txtEventFileName.setText(foosObsSettings.getEventFileName());
		add(txtEventFileName, "cell 5 2,alignx left");
		txtEventFileName.setColumns(10);
		
		JLabel lblGameCountFileName = new JLabel("Game Count 1:");
		add(lblGameCountFileName, "cell 1 3,alignx right");
		
		txtGameCount1FileName = new JTextField();
		txtGameCount1FileName.setText(foosObsSettings.getGameCount1FileName());
		add(txtGameCount1FileName, "cell 2 3,alignx left");
		txtGameCount1FileName.setColumns(10);
		
		JLabel lblTimeRemainingFileName = new JLabel("Time Remaining:");
		add(lblTimeRemainingFileName, "cell 4 3,alignx trailing");
		
		txtTimeRemainingFileName = new JTextField();
		txtTimeRemainingFileName.setText(foosObsSettings.getTimeRemainingFileName());
		add(txtTimeRemainingFileName, "cell 5 3,alignx left");
		txtTimeRemainingFileName.setColumns(10);

		JLabel lblGameCount2FileName = new JLabel("Game Count 2:");
		add(lblGameCount2FileName, "cell 1 4,alignx right");
		
		txtGameCount2FileName = new JTextField();
		txtGameCount2FileName.setText(foosObsSettings.getGameCount2FileName());
		add(txtGameCount2FileName, "cell 2 4,alignx left");
		txtGameCount2FileName.setColumns(10);
		
		JLabel lblTimerFileName = new JLabel("Timer:");
		add(lblTimerFileName, "cell 4 4,alignx trailing");
		
		txtTimerInUseFileName = new JTextField();
		txtTimerInUseFileName.setText(foosObsSettings.getTimerInUseFileName());
		add(txtTimerInUseFileName, "cell 5 4,alignx left");
		txtTimerInUseFileName.setColumns(10);

		JLabel lblScore1FileName = new JLabel("Score 1:");
		add(lblScore1FileName, "cell 1 5,alignx trailing");
		
		txtScore1FileName = new JTextField();
		txtScore1FileName.setText(foosObsSettings.getScore1FileName());
		add(txtScore1FileName, "cell 2 5,alignx left");
		txtScore1FileName.setColumns(10);
		
		JLabel lblMatchWinnerFileName = new JLabel("Match Winner:");
		add(lblMatchWinnerFileName, "cell 4 5,alignx trailing");
		
		txtMatchWinnerFileName = new JTextField();
		txtMatchWinnerFileName.setText(foosObsSettings.getMatchWinnerFileName());
		add(txtMatchWinnerFileName, "cell 5 5,alignx left");
		txtMatchWinnerFileName.setColumns(10);
		
		JLabel lblScore2FileName = new JLabel("Score 2:");
		add(lblScore2FileName, "cell 1 6,alignx trailing");
		
		txtScore2FileName = new JTextField();
		txtScore2FileName.setText(foosObsSettings.getScore2FileName());
		add(txtScore2FileName, "cell 2 6,alignx left");
		txtScore2FileName.setColumns(10);
		
		JLabel lblMeatball = new JLabel("Meatball:");
		add(lblMeatball, "cell 4 6,alignx trailing");
		
		txtMeatballFileName = new JTextField();
		txtMeatballFileName.setText(foosObsSettings.getMeatballFileName());
		add(txtMeatballFileName, "cell 5 6,alignx left");
		txtMeatballFileName.setColumns(10);
		
		JLabel lblTimeOut1FileName = new JLabel("Time Out 1:");
		add(lblTimeOut1FileName, "cell 1 7,alignx trailing");
		
		txtTimeOut1FileName = new JTextField();
		txtTimeOut1FileName.setText(foosObsSettings.getTimeOut1FileName());
		add(txtTimeOut1FileName, "cell 2 7,alignx left");
		txtTimeOut1FileName.setColumns(10);
		
		JLabel lblTimeOut2FileName = new JLabel("Time Out 2:");
		add(lblTimeOut2FileName, "cell 1 8,alignx trailing");
		
		txtTimeOut2FileName = new JTextField();
		txtTimeOut2FileName.setText(foosObsSettings.getTimeOut2FileName());
		add(txtTimeOut2FileName, "cell 2 8,alignx left");
		txtTimeOut2FileName.setColumns(10);
		
		JLabel lblReset1FileName = new JLabel("Reset 1:");
		add(lblReset1FileName, "cell 1 9,alignx trailing");
		
		txtReset1FileName = new JTextField();
		txtReset1FileName.setText(foosObsSettings.getReset1FileName());
		add(txtReset1FileName, "cell 2 9,alignx left");
		txtReset1FileName.setColumns(10);
		
		JLabel lblReset2FileName = new JLabel("Reset 2:");
		add(lblReset2FileName, "cell 1 10,alignx trailing");
		
		txtReset2FileName = new JTextField();
		txtReset2FileName.setText(foosObsSettings.getReset2FileName());
		add(txtReset2FileName, "cell 2 10,alignx left");
		txtReset2FileName.setColumns(10);
		
		JLabel lblWarn1FileName = new JLabel("Warn 1:");
		add(lblWarn1FileName, "cell 1 11,alignx trailing");
		
		txtWarn1FileName = new JTextField();
		txtWarn1FileName.setText(foosObsSettings.getWarn1FileName());
		add(txtWarn1FileName, "cell 2 11,alignx left");
		txtWarn1FileName.setColumns(10);
		
		JLabel lblWarn2FileName = new JLabel("Warn 2:");
		add(lblWarn2FileName, "cell 1 12,alignx trailing");
		
		txtWarn2FileName = new JTextField();
		txtWarn2FileName.setText(foosObsSettings.getWarn2FileName());
		add(txtWarn2FileName, "cell 2 12,alignx left");
		txtWarn2FileName.setColumns(10);
		
		JButton btnSaveFileNames = new JButton("Save");
		btnSaveFileNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSettings(foosObsSettings, fileNamesFrame);
			}
		});
		add(btnSaveFileNames, "cell 2 14,alignx center");
		
		JButton btnCancelFileNames = new JButton("Cancel");
		btnCancelFileNames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSettings(fileNamesFrame);
			}
		});
		add(btnCancelFileNames, "cell 4 14,alignx center");
		
		JButton btnRestoreDefaults = new JButton("Restore Defaults");
		btnRestoreDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restoreDefaults(foosObsSettings);
			}
		});
		add(btnRestoreDefaults, "cell 5 14,alignx center");
	}

	private void restoreDefaults(Settings foosObsSettings) {
		txtTeam1FileName.setText(foosObsSettings.getDefaultTeam1FileName());
		txtTournamentFileName.setText(foosObsSettings.getDefaultTournamentFileName());
		txtTeam2FileName.setText(foosObsSettings.getDefaultTeam2FileName());
		txtEventFileName.setText(foosObsSettings.getDefaultEventFileName());
		txtGameCount1FileName.setText(foosObsSettings.getDefaultGameCount1FileName());
		txtTimeRemainingFileName.setText(foosObsSettings.getDefaultTimeRemainingFileName());
		txtGameCount2FileName.setText(foosObsSettings.getDefaultGameCount2FileName());
		txtTimerInUseFileName.setText(foosObsSettings.getDefaultTimerInUseFileName());
		txtScore1FileName.setText(foosObsSettings.getDefaultScore1FileName());
		txtMatchWinnerFileName.setText(foosObsSettings.getDefaultMatchWinnerFileName());
		txtMeatballFileName.setText(foosObsSettings.getDefaultMeatballFileName());
		txtScore2FileName.setText(foosObsSettings.getDefaultScore2FileName());
		txtTimeOut1FileName.setText(foosObsSettings.getDefaultTimeOut1FileName());
		txtTimeOut2FileName.setText(foosObsSettings.getDefaultTimeOut2FileName());
		txtReset1FileName.setText(foosObsSettings.getDefaultReset1FileName());
		txtReset2FileName.setText(foosObsSettings.getDefaultReset2FileName());
		txtWarn1FileName.setText(foosObsSettings.getDefaultWarn1FileName());
		txtWarn2FileName.setText(foosObsSettings.getDefaultWarn2FileName());
	}
	
	private void saveSettings(Settings foosObsSettings, JFrame fileNamesFrame) {
		foosObsSettings.setTeam1FileName(txtTeam1FileName.getText());
		foosObsSettings.setTournamentFileName(txtTournamentFileName.getText());
		foosObsSettings.setTeam2FileName(txtTeam2FileName.getText());
		foosObsSettings.setEventFileName(txtEventFileName.getText());
		foosObsSettings.setGameCount1FileName(txtGameCount1FileName.getText());
		foosObsSettings.setTimeRemainingFileName(txtTimeRemainingFileName.getText());
		foosObsSettings.setGameCount2FileName(txtGameCount2FileName.getText());
		foosObsSettings.setTimerInUseFileName(txtTimerInUseFileName.getText());
		foosObsSettings.setScore1FileName(txtScore1FileName.getText());
		foosObsSettings.setMatchWinnerFileName(txtMatchWinnerFileName.getText());
		foosObsSettings.setMeatballFileName(txtMeatballFileName.getText());
		foosObsSettings.setScore2FileName(txtScore2FileName.getText());
		foosObsSettings.setTimeOut1FileName(txtTimeOut1FileName.getText());
		foosObsSettings.setTimeOut2FileName(txtTimeOut2FileName.getText());
		foosObsSettings.setReset1FileName(txtReset1FileName.getText());
		foosObsSettings.setReset2FileName(txtReset2FileName.getText());
		foosObsSettings.setWarn1FileName(txtWarn1FileName.getText());
		foosObsSettings.setWarn2FileName(txtWarn2FileName.getText());
		try {
			foosObsSettings.saveToConfig();
		} catch (IOException ex) {
			System.out.print("Error saving properties file: " + ex.getMessage());		
		}
		fileNamesFrame.dispose();
	}

	private void cancelSettings(JFrame fileNamesFrame) {
		fileNamesFrame.dispose();
	}

}
