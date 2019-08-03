package com.midsouthfoosball.foosobs;

import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HotKeysJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtTournamentNameClearHotKey;
	private JTextField txtEventClearHotKey;
	private JTextField txtTeam1ClearHotKey;
	private JTextField txtTeam1NameSwitchHotKey;
	private JTextField txtTeam2ClearHotKey;
	private JTextField txtTeam2NameSwitchHotKey;
	private JTextField txtTeamSwitchHotKey;
	private JTextField txtGameCount1MinusHotKey;
	private JTextField txtGameCount1PlusHotKey;
	private JTextField txtGameCount2MinusHotKey;
	private JTextField txtGameCount2PlusHotKey;
	private JTextField txtGameCountSwitchHotKey;
	private JTextField txtScore1MinusHotKey;
	private JTextField txtScore1PlusHotKey;
	private JTextField txtScore2MinusHotKey;
	private JTextField txtScore2PlusHotKey;
	private JTextField txtScoreSwitchHotKey;
	private JTextField txtTimeOut1MinusHotKey;
	private JTextField txtTimeOut1PlusHotKey;
	private JTextField txtTimeOut2MinusHotKey;
	private JTextField txtTimeOut2PlusHotKey;
	private JTextField txtTimeOutSwitchHotKey;
	private JTextField txtReset1HotKey;
	private JTextField txtReset2HotKey;
	private JTextField txtWarn1HotKey;
	private JTextField txtWarn2HotKey;
	private JTextField txtResetSwitchHotKey;
	private JTextField txtAllSwitchHotKey;
	private JTextField txtResetGameCountsHotKey;
	private JTextField txtResetScoresHotKey;
	private JTextField txtResetTimeOutsHotKey;
	private JTextField txtResetResetWarnHotKey;
	private JTextField txtResetAllHotKey;
	private JTextField txtClearAllHotKey;
	private JTextField txtShotTimerHotKey;
	private JTextField txtPassTimerHotKey;
	private JTextField txtTimeOutTimerHotKey;
	private JTextField txtGameTimerHotKey;
	private JTextField txtRecallTimerHotKey;
	private JTextField txtResetTimersHotKey;
	private JTextField txtSelectPathHotKey;
	private JTextField txtSetPathHotKey;
	private JTextField txtFetchDataHotKey;
	private JTextField txtSaveAllHotKey;
	private JTextField txtSettingsHotKey;

	public HotKeysJPanel(Settings foosObsSettings, JFrame hotKeysFrame) throws IOException {
		setLayout(new MigLayout("", "[][grow][10.00][][grow][10.00][][grow][10.00][][grow]", "[][][][][][][][][][][][][][][][][]"));
		
		JLabel lblButton = new JLabel("Button");
		lblButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblButton, "cell 0 0,alignx right");
		
		JLabel lblHotKey = new JLabel("Hot Key");
		lblHotKey.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblHotKey, "cell 1 0,alignx center");
		
		JLabel lblButton1 = new JLabel("Button");
		lblButton1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblButton1, "cell 3 0,alignx right");
		
		JLabel lblHotKey1 = new JLabel("Hot Key");
		lblHotKey1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblHotKey1, "cell 4 0,alignx center");
		
		JLabel lblButton2 = new JLabel("Button");
		lblButton2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblButton2, "cell 6 0,alignx right");
		
		JLabel lblHotKey2 = new JLabel("Hot Key");
		lblHotKey2.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblHotKey2, "cell 7 0,alignx center");
		
		JLabel lblButton3 = new JLabel("Button");
		lblButton3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblButton3, "cell 9 0,alignx right");
		
		JLabel lblHotKey3 = new JLabel("Hot Key");
		lblHotKey3.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblHotKey3, "cell 10 0,alignx center");
		
		JLabel lblTournamentNameClearHotKey = new JLabel("X (Tournament)");
		add(lblTournamentNameClearHotKey, "cell 0 1,alignx trailing");
		
		txtTournamentNameClearHotKey = new JTextField();
		txtTournamentNameClearHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTournamentNameClearHotKey.setText(foosObsSettings.getTournamentNameClearHotKey());
		add(txtTournamentNameClearHotKey, "cell 1 1,alignx left");
		txtTournamentNameClearHotKey.setColumns(10);
		
		JLabel lblScore1MinusHotKey = new JLabel("- (Score 1)");
		add(lblScore1MinusHotKey, "cell 3 1,alignx trailing");
		
		txtScore1MinusHotKey = new JTextField();
		txtScore1MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore1MinusHotKey.setText(foosObsSettings.getScore1MinusHotKey());
		add(txtScore1MinusHotKey, "cell 4 1,alignx left");
		txtScore1MinusHotKey.setColumns(10);
		
		JLabel lblWarn1HotKey = new JLabel("Warn (Team 1)");
		add(lblWarn1HotKey, "cell 6 1,alignx trailing");
		
		txtWarn1HotKey = new JTextField();
		txtWarn1HotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtWarn1HotKey.setText(foosObsSettings.getWarn1HotKey());
		add(txtWarn1HotKey, "cell 7 1,alignx left");
		txtWarn1HotKey.setColumns(10);
		
		JLabel lblShotTimerHotKey = new JLabel("Start (Shot Timer)");
		add(lblShotTimerHotKey, "cell 9 1,alignx trailing");
		
		txtShotTimerHotKey = new JTextField();
		txtShotTimerHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtShotTimerHotKey.setText(foosObsSettings.getShotTimerHotKey());
		add(txtShotTimerHotKey, "cell 10 1,alignx left");
		txtShotTimerHotKey.setColumns(10);
		
		JLabel lblEventClearHotKey = new JLabel("X (Event)");
		add(lblEventClearHotKey, "cell 0 2,alignx trailing");
		
		txtEventClearHotKey = new JTextField();
		txtEventClearHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtEventClearHotKey.setText(foosObsSettings.getEventClearHotKey());
		add(txtEventClearHotKey, "cell 1 2,alignx left,aligny top");
		txtEventClearHotKey.setColumns(10);
		
		JLabel lblScore1PlusHotKey = new JLabel("+ (Score 1)");
		add(lblScore1PlusHotKey, "cell 3 2,alignx trailing");
		
		txtScore1PlusHotKey = new JTextField();
		txtScore1PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore1PlusHotKey.setText(foosObsSettings.getScore1PlusHotKey());
		add(txtScore1PlusHotKey, "cell 4 2,alignx left");
		txtScore1PlusHotKey.setColumns(10);
		
		JLabel lblWarn2HotKey = new JLabel("Warn (Team 2)");
		add(lblWarn2HotKey, "cell 6 2,alignx trailing");
		
		txtWarn2HotKey = new JTextField();
		txtWarn2HotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtWarn2HotKey.setText(foosObsSettings.getWarn2HotKey());
		add(txtWarn2HotKey, "cell 7 2,alignx left");
		txtWarn2HotKey.setColumns(10);
		
		JLabel lblPassTimerHotKey = new JLabel("Start (Pass Timer)");
		add(lblPassTimerHotKey, "cell 9 2,alignx trailing");
		
		txtPassTimerHotKey = new JTextField();
		txtPassTimerHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassTimerHotKey.setText(foosObsSettings.getPassTimerHotKey());
		add(txtPassTimerHotKey, "cell 10 2,alignx left");
		txtPassTimerHotKey.setColumns(10);
		
		JLabel lblScore2MinusHotKey = new JLabel("- (Score 2)");
		add(lblScore2MinusHotKey, "cell 3 3,alignx trailing");
		
		txtScore2MinusHotKey = new JTextField();
		txtScore2MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore2MinusHotKey.setText(foosObsSettings.getScore2MinusHotKey());
		add(txtScore2MinusHotKey, "cell 4 3,alignx left");
		txtScore2MinusHotKey.setColumns(10);
		
		JLabel lblResetSwitchHotKey = new JLabel("<-> (Resets/Warns)");
		add(lblResetSwitchHotKey, "cell 6 3,alignx trailing");
		
		txtResetSwitchHotKey = new JTextField();
		txtResetSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetSwitchHotKey.setText(foosObsSettings.getResetSwitchHotKey());
		add(txtResetSwitchHotKey, "cell 7 3,alignx left");
		txtResetSwitchHotKey.setColumns(10);
		
		JLabel lblTimeOutTimerHotKey = new JLabel("Start (Time Out Timer)");
		add(lblTimeOutTimerHotKey, "cell 9 3,alignx trailing");
		
		txtTimeOutTimerHotKey = new JTextField();
		txtTimeOutTimerHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOutTimerHotKey.setText(foosObsSettings.getTimeOutTimerHotKey());
		add(txtTimeOutTimerHotKey, "cell 10 3,alignx left");
		txtTimeOutTimerHotKey.setColumns(10);
		
		JLabel lblTeam1ClearHotKey = new JLabel("X (Team 1 Name)");
		add(lblTeam1ClearHotKey, "cell 0 4,alignx trailing");
		
		txtTeam1ClearHotKey = new JTextField();
		txtTeam1ClearHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam1ClearHotKey.setText(foosObsSettings.getTeam1ClearHotKey());
		add(txtTeam1ClearHotKey, "cell 1 4,alignx left");
		txtTeam1ClearHotKey.setColumns(10);
		
		JLabel lblScore2PlusHotKey = new JLabel("+ (Score 2)");
		add(lblScore2PlusHotKey, "cell 3 4,alignx trailing");
		
		txtScore2PlusHotKey = new JTextField();
		txtScore2PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore2PlusHotKey.setText(foosObsSettings.getScore2PlusHotKey());
		add(txtScore2PlusHotKey, "cell 4 4,alignx left,aligny top");
		txtScore2PlusHotKey.setColumns(10);
		
		JLabel lblGameTimerHotKey = new JLabel("Start (Game Timer)");
		add(lblGameTimerHotKey, "cell 9 4,alignx trailing");
		
		txtGameTimerHotKey = new JTextField();
		txtGameTimerHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameTimerHotKey.setText(foosObsSettings.getGameTimerHotKey());
		add(txtGameTimerHotKey, "cell 10 4,alignx left");
		txtGameTimerHotKey.setColumns(10);
		
		JLabel lblTeam1NameSwitchHotKey = new JLabel("<-> (Team 1 Names)");
		add(lblTeam1NameSwitchHotKey, "cell 0 5,alignx trailing");
		
		txtTeam1NameSwitchHotKey = new JTextField();
		txtTeam1NameSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam1NameSwitchHotKey.setText(foosObsSettings.getTeam1NameSwitchHotKey());
		add(txtTeam1NameSwitchHotKey, "cell 1 5,alignx left");
		txtTeam1NameSwitchHotKey.setColumns(10);
		
		JLabel lblScoreSwitchHotKey = new JLabel("<-> (Scores)");
		add(lblScoreSwitchHotKey, "cell 3 5,alignx trailing");
		
		txtScoreSwitchHotKey = new JTextField();
		txtScoreSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtScoreSwitchHotKey.setText(foosObsSettings.getScoreSwitchHotKey());
		add(txtScoreSwitchHotKey, "cell 4 5,alignx left");
		txtScoreSwitchHotKey.setColumns(10);
		
		JLabel lblAllSwitchHotKey = new JLabel("<--------> (Teams)");
		add(lblAllSwitchHotKey, "cell 6 5,alignx trailing");
		
		txtAllSwitchHotKey = new JTextField();
		txtAllSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtAllSwitchHotKey.setText(foosObsSettings.getAllSwitchHotKey());
		add(txtAllSwitchHotKey, "cell 7 5,alignx left");
		txtAllSwitchHotKey.setColumns(10);
		
		JLabel lblRecallTimerHotKey = new JLabel("Start (Recall Timer)");
		add(lblRecallTimerHotKey, "cell 9 5,alignx trailing");
		
		txtRecallTimerHotKey = new JTextField();
		txtRecallTimerHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecallTimerHotKey.setText(foosObsSettings.getRecallTimerHotKey());
		add(txtRecallTimerHotKey, "cell 10 5,alignx left");
		txtRecallTimerHotKey.setColumns(10);
		
		JLabel lblTeam2ClearHotKey = new JLabel("X (Team 2 Name)");
		add(lblTeam2ClearHotKey, "cell 0 6,alignx trailing");
		
		txtTeam2ClearHotKey = new JTextField();
		txtTeam2ClearHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam2ClearHotKey.setText(foosObsSettings.getTeam2ClearHotKey());
		add(txtTeam2ClearHotKey, "cell 1 6,alignx left");
		txtTeam2ClearHotKey.setColumns(10);
		
		JLabel lblResetTimersHotKey = new JLabel("Reset Timer");
		add(lblResetTimersHotKey, "cell 9 6,alignx trailing");
		
		txtResetTimersHotKey = new JTextField();
		txtResetTimersHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetTimersHotKey.setText(foosObsSettings.getResetTimersHotKey());
		add(txtResetTimersHotKey, "cell 10 6,alignx left");
		txtResetTimersHotKey.setColumns(10);
		
		JLabel lblTeam2NameSwitchHotKey = new JLabel("<-> (Team 2 Names)");
		add(lblTeam2NameSwitchHotKey, "cell 0 7,alignx trailing");
		
		txtTeam2NameSwitchHotKey = new JTextField();
		txtTeam2NameSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeam2NameSwitchHotKey.setText(foosObsSettings.getTeam2NameSwitchHotKey());
		add(txtTeam2NameSwitchHotKey, "cell 1 7,alignx left");
		txtTeam2NameSwitchHotKey.setColumns(10);
		
		JLabel lblTimeOut1MinusHotKey = new JLabel("Give back TO (Team 1)");
		add(lblTimeOut1MinusHotKey, "cell 3 7,alignx trailing");
		
		txtTimeOut1MinusHotKey = new JTextField();
		txtTimeOut1MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut1MinusHotKey.setText(foosObsSettings.getTimeOut1MinusHotKey());
		add(txtTimeOut1MinusHotKey, "cell 4 7,alignx left");
		txtTimeOut1MinusHotKey.setColumns(10);
		
		JLabel lblResetGameCountsHotKey = new JLabel("Reset Game Counts");
		add(lblResetGameCountsHotKey, "cell 6 7,alignx trailing");
		
		txtResetGameCountsHotKey = new JTextField();
		txtResetGameCountsHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetGameCountsHotKey.setText(foosObsSettings.getResetGameCountsHotKey());
		add(txtResetGameCountsHotKey, "cell 7 7,alignx left");
		txtResetGameCountsHotKey.setColumns(10);
		
		JLabel lblTeamSwitchHotKey = new JLabel("<-> (Team Names)");
		add(lblTeamSwitchHotKey, "cell 0 8,alignx trailing");
		
		txtTeamSwitchHotKey = new JTextField();
		txtTeamSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTeamSwitchHotKey.setText(foosObsSettings.getTeamSwitchHotKey());
		add(txtTeamSwitchHotKey, "cell 1 8,alignx left");
		txtTeamSwitchHotKey.setColumns(10);
		
		JLabel lblTimeOut1PlusHotKey = new JLabel("Use TO (Team 1)");
		add(lblTimeOut1PlusHotKey, "cell 3 8,alignx trailing");
		
		txtTimeOut1PlusHotKey = new JTextField();
		txtTimeOut1PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut1PlusHotKey.setText(foosObsSettings.getTimeOut1PlusHotKey());
		add(txtTimeOut1PlusHotKey, "cell 4 8,alignx left");
		txtTimeOut1PlusHotKey.setColumns(10);
		
		JLabel lblResetScoresHotKey = new JLabel("Reset Scores");
		add(lblResetScoresHotKey, "cell 6 8,alignx trailing");
		
		txtResetScoresHotKey = new JTextField();
		txtResetScoresHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetScoresHotKey.setText(foosObsSettings.getResetScoresHotKey());
		add(txtResetScoresHotKey, "cell 7 8,alignx left");
		txtResetScoresHotKey.setColumns(10);
		
		JLabel lblSelectPathHotKey = new JLabel("Select Path");
		add(lblSelectPathHotKey, "cell 9 8,alignx trailing");
		
		txtSelectPathHotKey = new JTextField();
		txtSelectPathHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtSelectPathHotKey.setText(foosObsSettings.getSelectPathHotKey());
		add(txtSelectPathHotKey, "cell 10 8,alignx left");
		txtSelectPathHotKey.setColumns(10);
		
		JLabel lblTimeOut2MinusHotKey = new JLabel("Give back TO (Team 2)");
		add(lblTimeOut2MinusHotKey, "cell 3 9,alignx trailing");
		
		txtTimeOut2MinusHotKey = new JTextField();
		txtTimeOut2MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut2MinusHotKey.setText(foosObsSettings.getTimeOut2MinusHotKey());
		add(txtTimeOut2MinusHotKey, "cell 4 9,alignx left");
		txtTimeOut2MinusHotKey.setColumns(10);
		
		JLabel lblResetTimeOutsHotKey = new JLabel("Reset Time Outs");
		add(lblResetTimeOutsHotKey, "cell 6 9,alignx trailing");
		
		txtResetTimeOutsHotKey = new JTextField();
		txtResetTimeOutsHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetTimeOutsHotKey.setText(foosObsSettings.getResetTimeOutsHotKey());
		add(txtResetTimeOutsHotKey, "cell 7 9,alignx left");
		txtResetTimeOutsHotKey.setColumns(10);
		
		JLabel lblSetPathHotKey = new JLabel("Set Path");
		add(lblSetPathHotKey, "cell 9 9,alignx trailing");
		
		txtSetPathHotKey = new JTextField();
		txtSetPathHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtSetPathHotKey.setText(foosObsSettings.getSetPathHotKey());
		add(txtSetPathHotKey, "cell 10 9,alignx left");
		txtSetPathHotKey.setColumns(10);
		
		JLabel lblGameCount1MinusHotKey = new JLabel("- (Game Count 1)");
		add(lblGameCount1MinusHotKey, "cell 0 10,alignx trailing");
		
		txtGameCount1MinusHotKey = new JTextField();
		txtGameCount1MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount1MinusHotKey.setText(foosObsSettings.getGameCount1MinusHotKey());
		add(txtGameCount1MinusHotKey, "cell 1 10,alignx left");
		txtGameCount1MinusHotKey.setColumns(10);
		
		JLabel lblTimeOut2PlusHotKey = new JLabel("Use  TO (Team 2)");
		add(lblTimeOut2PlusHotKey, "cell 3 10,alignx trailing");
		
		txtTimeOut2PlusHotKey = new JTextField();
		txtTimeOut2PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOut2PlusHotKey.setText(foosObsSettings.getTimeOut2PlusHotKey());
		add(txtTimeOut2PlusHotKey, "cell 4 10,alignx left");
		txtTimeOut2PlusHotKey.setColumns(10);
		
		JLabel lblResetResetWarnHotKey = new JLabel("Reset Reset/Warn");
		add(lblResetResetWarnHotKey, "cell 6 10,alignx trailing");
		
		txtResetResetWarnHotKey = new JTextField();
		txtResetResetWarnHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetResetWarnHotKey.setText(foosObsSettings.getResetResetWarnHotKey());
		add(txtResetResetWarnHotKey, "cell 7 10,alignx left");
		txtResetResetWarnHotKey.setColumns(10);
		
		JLabel lblFetchDataHotKey = new JLabel("Fetch Data");
		add(lblFetchDataHotKey, "cell 9 10,alignx trailing");
		
		txtFetchDataHotKey = new JTextField();
		txtFetchDataHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtFetchDataHotKey.setText(foosObsSettings.getFetchDataHotKey());
		add(txtFetchDataHotKey, "cell 10 10,alignx left");
		txtFetchDataHotKey.setColumns(10);
		
		JLabel lblGameCount1PlusHotKey = new JLabel("+ (Game Count 1)");
		add(lblGameCount1PlusHotKey, "cell 0 11,alignx trailing");
		
		txtGameCount1PlusHotKey = new JTextField();
		txtGameCount1PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount1PlusHotKey.setText(foosObsSettings.getGameCount1PlusHotKey());
		add(txtGameCount1PlusHotKey, "cell 1 11,alignx left");
		txtGameCount1PlusHotKey.setColumns(10);
		
		JLabel lblTimeOutSwitchHotKey = new JLabel("<-> (Time Outs)");
		add(lblTimeOutSwitchHotKey, "cell 3 11,alignx trailing");
		
		txtTimeOutSwitchHotKey = new JTextField();
		txtTimeOutSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimeOutSwitchHotKey.setText(foosObsSettings.getTimeOutSwitchHotKey());
		add(txtTimeOutSwitchHotKey, "cell 4 11,alignx left");
		txtTimeOutSwitchHotKey.setColumns(10);
		
		JLabel lblResetAllHotKey = new JLabel("Reset All");
		add(lblResetAllHotKey, "cell 6 11,alignx trailing");
		
		txtResetAllHotKey = new JTextField();
		txtResetAllHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtResetAllHotKey.setText(foosObsSettings.getResetAllHotKey());
		add(txtResetAllHotKey, "cell 7 11,alignx left");
		txtResetAllHotKey.setColumns(10);
		
		JLabel lblSaveAllHotKey = new JLabel("Save All");
		add(lblSaveAllHotKey, "cell 9 11,alignx trailing");
		
		txtSaveAllHotKey = new JTextField();
		txtSaveAllHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtSaveAllHotKey.setText(foosObsSettings.getSaveAllHotKey());
		add(txtSaveAllHotKey, "cell 10 11,alignx left");
		txtSaveAllHotKey.setColumns(10);
		
		JLabel lblGameCount2MinusHotKey = new JLabel("- (Game Count 2)");
		add(lblGameCount2MinusHotKey, "cell 0 12,alignx trailing");
		
		txtGameCount2MinusHotKey = new JTextField();
		txtGameCount2MinusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount2MinusHotKey.setText(foosObsSettings.getGameCount2MinusHotKey());
		add(txtGameCount2MinusHotKey, "cell 1 12,alignx left");
		txtGameCount2MinusHotKey.setColumns(10);
		
		JLabel lblGameCount2PlusHotKey = new JLabel("+ (Game Count 2)");
		add(lblGameCount2PlusHotKey, "cell 0 13,alignx trailing");
		
		txtGameCount2PlusHotKey = new JTextField();
		txtGameCount2PlusHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCount2PlusHotKey.setText(foosObsSettings.getGameCount2PlusHotKey());
		add(txtGameCount2PlusHotKey, "cell 1 13,alignx left");
		txtGameCount2PlusHotKey.setColumns(10);
		
		JLabel lblReset1HotKey = new JLabel("Reset  (Team 1)");
		add(lblReset1HotKey, "cell 3 13,alignx trailing");
		
		txtReset1HotKey = new JTextField();
		txtReset1HotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtReset1HotKey.setText(foosObsSettings.getReset1HotKey());
		add(txtReset1HotKey, "cell 4 13,alignx left");
		txtReset1HotKey.setColumns(10);
		
		JLabel lblClearAllHotKey = new JLabel("Clear All");
		add(lblClearAllHotKey, "cell 6 13,alignx trailing");
		
		txtClearAllHotKey = new JTextField();
		txtClearAllHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtClearAllHotKey.setText(foosObsSettings.getClearAllHotKey());
		add(txtClearAllHotKey, "cell 7 13,alignx left");
		txtClearAllHotKey.setColumns(10);
		
		JLabel lblSettingsHotKey = new JLabel("Settings");
		add(lblSettingsHotKey, "cell 9 13,alignx trailing");
		
		txtSettingsHotKey = new JTextField();
		txtSettingsHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtSettingsHotKey.setText(foosObsSettings.getSettingsHotKey());
		add(txtSettingsHotKey, "cell 10 13,alignx left");
		txtSettingsHotKey.setColumns(10);
		
		JLabel lblGameCountSwitchHotKey = new JLabel("<-> (Game Counts)");
		add(lblGameCountSwitchHotKey, "cell 0 14,alignx trailing");
		
		txtGameCountSwitchHotKey = new JTextField();
		txtGameCountSwitchHotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtGameCountSwitchHotKey.setText(foosObsSettings.getGameCountSwitchHotKey());
		add(txtGameCountSwitchHotKey, "cell 1 14,growx");
		txtGameCountSwitchHotKey.setColumns(10);
		
		JLabel lblReset2HotKey = new JLabel("Reset (Team 2)");
		add(lblReset2HotKey, "cell 3 14,alignx trailing");
		
		txtReset2HotKey = new JTextField();
		txtReset2HotKey.setHorizontalAlignment(SwingConstants.CENTER);
		txtReset2HotKey.setText(foosObsSettings.getReset2HotKey());
		add(txtReset2HotKey, "cell 4 14,growx");
		txtReset2HotKey.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveSettings(foosObsSettings, hotKeysFrame);
			}
		});
		add(btnSave, "cell 3 16,alignx center");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelSettings(hotKeysFrame);
			}
		});
		add(btnCancel, "cell 6 16,alignx center");
		
		JButton btnRestoreDefaults = new JButton("Restore Defaults");
		btnRestoreDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restoreDefaults(foosObsSettings);
			}
		});
		add(btnRestoreDefaults, "cell 9 16,alignx center");

	}
	private void restoreDefaults(Settings foosObsSettings) {
		txtTournamentNameClearHotKey.setText(foosObsSettings.getDefaultTournamentNameClearHotKey());
		txtEventClearHotKey.setText(foosObsSettings.getDefaultEventClearHotKey());
		txtTeam1ClearHotKey.setText(foosObsSettings.getDefaultTeam1ClearHotKey());
		txtTeam1NameSwitchHotKey.setText(foosObsSettings.getDefaultTeam1NameSwitchHotKey());
		txtTeam2ClearHotKey.setText(foosObsSettings.getDefaultTeam2ClearHotKey());
		txtTeam2NameSwitchHotKey.setText(foosObsSettings.getDefaultTeam2NameSwitchHotKey());
		txtTeamSwitchHotKey.setText(foosObsSettings.getDefaultTeamSwitchHotKey());
		txtGameCount1MinusHotKey.setText(foosObsSettings.getDefaultGameCount1MinusHotKey());
		txtGameCount1PlusHotKey.setText(foosObsSettings.getDefaultGameCount1PlusHotKey());
		txtGameCount2MinusHotKey.setText(foosObsSettings.getDefaultGameCount2MinusHotKey());
		txtGameCount2PlusHotKey.setText(foosObsSettings.getDefaultGameCount2PlusHotKey());
		txtGameCountSwitchHotKey.setText(foosObsSettings.getDefaultGameCountSwitchHotKey());
		txtScore1MinusHotKey.setText(foosObsSettings.getDefaultScore1MinusHotKey());
		txtScore1PlusHotKey.setText(foosObsSettings.getDefaultScore1PlusHotKey());
		txtScore2MinusHotKey.setText(foosObsSettings.getDefaultScore2MinusHotKey());
		txtScore2PlusHotKey.setText(foosObsSettings.getDefaultScore2PlusHotKey());
		txtScoreSwitchHotKey.setText(foosObsSettings.getDefaultScoreSwitchHotKey());
		txtTimeOut1MinusHotKey.setText(foosObsSettings.getDefaultTimeOut1MinusHotKey());
		txtTimeOut1PlusHotKey.setText(foosObsSettings.getDefaultTimeOut1PlusHotKey());
		txtTimeOut2MinusHotKey.setText(foosObsSettings.getDefaultTimeOut2MinusHotKey());
		txtTimeOut2PlusHotKey.setText(foosObsSettings.getDefaultTimeOut2PlusHotKey());
		txtTimeOutSwitchHotKey.setText(foosObsSettings.getDefaultTimeOutSwitchHotKey());
		txtReset1HotKey.setText(foosObsSettings.getDefaultReset1HotKey());
		txtReset2HotKey.setText(foosObsSettings.getDefaultReset2HotKey());
		txtWarn1HotKey.setText(foosObsSettings.getDefaultWarn1HotKey());
		txtWarn2HotKey.setText(foosObsSettings.getDefaultWarn2HotKey());
		txtResetSwitchHotKey.setText(foosObsSettings.getDefaultResetSwitchHotKey());
		txtAllSwitchHotKey.setText(foosObsSettings.getDefaultAllSwitchHotKey());
		txtResetGameCountsHotKey.setText(foosObsSettings.getDefaultResetGameCountsHotKey());
		txtResetScoresHotKey.setText(foosObsSettings.getDefaultResetScoresHotKey());
		txtResetTimeOutsHotKey.setText(foosObsSettings.getDefaultResetTimeOutsHotKey());
		txtResetResetWarnHotKey.setText(foosObsSettings.getDefaultResetResetWarnHotKey());
		txtResetAllHotKey.setText(foosObsSettings.getDefaultResetAllHotKey());
		txtClearAllHotKey.setText(foosObsSettings.getDefaultClearAllHotKey());
		txtShotTimerHotKey.setText(foosObsSettings.getDefaultShotTimerHotKey());
		txtPassTimerHotKey.setText(foosObsSettings.getDefaultPassTimerHotKey());
		txtTimeOutTimerHotKey.setText(foosObsSettings.getDefaultTimeOutTimerHotKey());
		txtGameTimerHotKey.setText(foosObsSettings.getDefaultGameTimerHotKey());
		txtRecallTimerHotKey.setText(foosObsSettings.getDefaultRecallTimerHotKey());
		txtResetTimersHotKey.setText(foosObsSettings.getDefaultResetTimersHotKey());
		txtSelectPathHotKey.setText(foosObsSettings.getDefaultSelectPathHotKey());
		txtSetPathHotKey.setText(foosObsSettings.getDefaultSetPathHotKey());
		txtFetchDataHotKey.setText(foosObsSettings.getDefaultFetchDataHotKey());
		txtSaveAllHotKey.setText(foosObsSettings.getDefaultSaveAllHotKey());
		txtSettingsHotKey.setText(foosObsSettings.getDefaultSettingsHotKey());
	}
	
	private void saveSettings(Settings foosObsSettings, JFrame hotKeysFrame) {
		foosObsSettings.setTournamentNameClearHotKey(txtTournamentNameClearHotKey.getText());
		foosObsSettings.setEventClearHotKey(txtEventClearHotKey.getText());
		foosObsSettings.setTeam1ClearHotKey(txtTeam1ClearHotKey.getText());
		foosObsSettings.setTeam1NameSwitchHotKey(txtTeam1NameSwitchHotKey.getText());
		foosObsSettings.setTeam2ClearHotKey(txtTeam2ClearHotKey.getText());
		foosObsSettings.setTeam2NameSwitchHotKey(txtTeam2NameSwitchHotKey.getText());
		foosObsSettings.setTeamSwitchHotKey(txtTeamSwitchHotKey.getText());
		foosObsSettings.setGameCount1MinusHotKey(txtGameCount1MinusHotKey.getText());
		foosObsSettings.setGameCount1PlusHotKey(txtGameCount1PlusHotKey.getText());
		foosObsSettings.setGameCount2MinusHotKey(txtGameCount2MinusHotKey.getText());
		foosObsSettings.setGameCount2PlusHotKey(txtGameCount2PlusHotKey.getText());
		foosObsSettings.setGameCountSwitchHotKey(txtGameCountSwitchHotKey.getText());
		foosObsSettings.setScore1MinusHotKey(txtScore1MinusHotKey.getText());
		foosObsSettings.setScore1PlusHotKey(txtScore1PlusHotKey.getText());
		foosObsSettings.setScore2MinusHotKey(txtScore2MinusHotKey.getText());
		foosObsSettings.setScore2PlusHotKey(txtScore2PlusHotKey.getText());
		foosObsSettings.setScoreSwitchHotKey(txtScoreSwitchHotKey.getText());
		foosObsSettings.setTimeOut1MinusHotKey(txtTimeOut1MinusHotKey.getText());
		foosObsSettings.setTimeOut1PlusHotKey(txtTimeOut1PlusHotKey.getText());
		foosObsSettings.setTimeOut2MinusHotKey(txtTimeOut2MinusHotKey.getText());
		foosObsSettings.setTimeOut2PlusHotKey(txtTimeOut2PlusHotKey.getText());
		foosObsSettings.setTimeOutSwitchHotKey(txtTimeOutSwitchHotKey.getText());
		foosObsSettings.setReset1HotKey(txtReset1HotKey.getText());
		foosObsSettings.setReset2HotKey(txtReset2HotKey.getText());
		foosObsSettings.setWarn1HotKey(txtWarn1HotKey.getText());
		foosObsSettings.setWarn2HotKey(txtWarn2HotKey.getText());
		foosObsSettings.setResetSwitchHotKey(txtResetSwitchHotKey.getText());
		foosObsSettings.setAllSwitchHotKey(txtAllSwitchHotKey.getText());
		foosObsSettings.setResetGameCountsHotKey(txtResetGameCountsHotKey.getText());
		foosObsSettings.setResetScoresHotKey(txtResetScoresHotKey.getText());
		foosObsSettings.setResetTimeOutsHotKey(txtResetTimeOutsHotKey.getText());
		foosObsSettings.setResetResetWarnHotKey(txtResetResetWarnHotKey.getText());
		foosObsSettings.setResetAllHotKey(txtResetAllHotKey.getText());
		foosObsSettings.setClearAllHotKey(txtClearAllHotKey.getText());
		foosObsSettings.setShotTimerHotKey(txtShotTimerHotKey.getText());
		foosObsSettings.setPassTimerHotKey(txtPassTimerHotKey.getText());
		foosObsSettings.setTimeOutTimerHotKey(txtTimeOutTimerHotKey.getText());
		foosObsSettings.setGameTimerHotKey(txtGameTimerHotKey.getText());
		foosObsSettings.setRecallTimerHotKey(txtRecallTimerHotKey.getText());
		foosObsSettings.setResetTimersHotKey(txtResetTimersHotKey.getText());
		foosObsSettings.setSelectPathHotKey(txtSelectPathHotKey.getText());
		foosObsSettings.setSetPathHotKey(txtSetPathHotKey.getText());
		foosObsSettings.setFetchDataHotKey(txtFetchDataHotKey.getText());
		foosObsSettings.setSaveAllHotKey(txtSaveAllHotKey.getText());
		foosObsSettings.setSettingsHotKey(txtSettingsHotKey.getText());
		try {
			foosObsSettings.saveToConfig();
		} catch (IOException ex) {
			System.out.print("Error saving properties file: " + ex.getMessage());		
		}
		hotKeysFrame.dispose();
	}

	private void cancelSettings(JFrame hotKeysFrame) {
		hotKeysFrame.dispose();
	}

}
