package com.midsouthfoosball.foosobs;

import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;

public class SettingsJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPointsToWin;
	private JTextField txtMaxWin;
	private JTextField txtGamesToWin;
	private JTextField txtWinBy;
	private JCheckBox chckbxAutoIncrementGame;
	private JCheckBox chckbxAnnounceWinner;
	private JCheckBox chckbxAnnounceMeatball;
	private JTextField txtMaxTimeOuts;
	private JTextField txtWinnerPrefix;
	private JTextField txtWinnerSuffix;
	private JTextField txtShotTime;
	private JTextField txtPassTime;
	private JTextField txtTimeOutTime;
	private JTextField txtGameTime;
	private JTextField txtRecallTime;
	private JTextField txtMeatball;
	private JToggleButton tglbtnTimeOutsUsed;

	public SettingsJPanel(Settings foosObsSettings, JFrame settingsFrame) throws IOException {

		setLayout(new MigLayout("", "[119.00][50.00:87.00,left][78.00,grow][grow][]", "[][][][][][][][][][][][][]"));
		
		JLabel lblParameter = new JLabel("Parameter");
		lblParameter.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblParameter, "cell 0 0,alignx right");
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblValue, "cell 1 0,alignx left");
		
		JLabel lblPointsToWin = new JLabel("Points to Win");
		add(lblPointsToWin, "flowx,cell 0 1,alignx right");
		
		txtPointsToWin = new JTextField();
		txtPointsToWin.setText(Integer.toString(foosObsSettings.getPointsToWin()));
		add(txtPointsToWin, "cell 1 1,alignx left");
		txtPointsToWin.setColumns(10);
		
		JLabel lblShotTime = new JLabel("Shot Time");
		add(lblShotTime, "cell 2 1,alignx trailing");
		
		txtShotTime = new JTextField();
		txtShotTime.setText(Integer.toString(foosObsSettings.getShotTime()));
		add(txtShotTime, "cell 3 1,growx");
		txtShotTime.setColumns(10);
		
		JLabel lblMaxWin = new JLabel("Max Win");
		add(lblMaxWin, "flowx,cell 0 2,alignx right");
		
		txtMaxWin = new JTextField();
		txtMaxWin.setText(Integer.toString(foosObsSettings.getMaxWin()));
		add(txtMaxWin, "cell 1 2,alignx left");
		txtMaxWin.setColumns(10);
		
		JLabel lblPassTime = new JLabel("Pass Time");
		add(lblPassTime, "cell 2 2,alignx trailing");
		
		txtPassTime = new JTextField();
		txtPassTime.setText(Integer.toString(foosObsSettings.getPassTime()));
		add(txtPassTime, "cell 3 2,growx");
		txtPassTime.setColumns(10);
		
		JLabel lblWinBy = new JLabel("Win by");
		add(lblWinBy, "cell 0 3,alignx trailing");
		
		txtWinBy = new JTextField();
		txtWinBy.setText(Integer.toString(foosObsSettings.getWinBy()));
		add(txtWinBy, "cell 1 3,alignx left");
		txtWinBy.setColumns(10);
		
		JLabel lblTimeOutTime = new JLabel("Time Out Time");
		add(lblTimeOutTime, "cell 2 3,alignx trailing");
		
		txtTimeOutTime = new JTextField();
		txtTimeOutTime.setText(Integer.toString(foosObsSettings.getTimeOutTime()));
		add(txtTimeOutTime, "cell 3 3,growx");
		txtTimeOutTime.setColumns(10);
		
		JLabel lblGamesToWin = new JLabel("Games to Win");
		add(lblGamesToWin, "cell 0 4,alignx trailing");
		
		txtGamesToWin = new JTextField();
		txtGamesToWin.setText(Integer.toString(foosObsSettings.getGamesToWin()));
		add(txtGamesToWin, "cell 1 4,alignx left");
		txtGamesToWin.setColumns(10);
		
		JLabel lblGameTime = new JLabel("Game Time");
		add(lblGameTime, "cell 2 4,alignx trailing");
		
		txtGameTime = new JTextField();
		txtGameTime.setText(Integer.toString(foosObsSettings.getGameTime()));
		add(txtGameTime, "cell 3 4,growx");
		txtGameTime.setColumns(10);
		
		JLabel lblMaxTimeOuts = new JLabel("Max Time Outs");
		add(lblMaxTimeOuts, "flowx,cell 0 5,alignx right");
		
		txtMaxTimeOuts = new JTextField();
		txtMaxTimeOuts.setText(Integer.toString(foosObsSettings.getMaxTimeOuts()));
		add(txtMaxTimeOuts, "cell 1 5");
		txtMaxTimeOuts.setColumns(10);
		
		JLabel lblRecallTime = new JLabel("Recall Time (min)");
		add(lblRecallTime, "cell 2 5,alignx trailing");
		
		txtRecallTime = new JTextField();
		txtRecallTime.setText(Integer.toString(foosObsSettings.getRecallTime()));
		add(txtRecallTime, "cell 3 5,growx,aligny top");
		txtRecallTime.setColumns(10);
		
		JLabel lblAutoIncrementGame = new JLabel("Auto Increment Game");
		add(lblAutoIncrementGame, "cell 0 7,alignx right");
		
		chckbxAutoIncrementGame = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAutoIncrementGame()).equals("1")) {
			chckbxAutoIncrementGame.setSelected(true);
		} else {
			chckbxAutoIncrementGame.setSelected(false);
		}
		add(chckbxAutoIncrementGame, "cell 1 7");
		
		JLabel lblWinnerPrefix = new JLabel("Winner Prefix");
		add(lblWinnerPrefix, "cell 2 7,alignx center");
		
		JLabel lblWinnerSuffix = new JLabel("Winner Suffix");
		add(lblWinnerSuffix, "cell 3 7,alignx center");
		
		JLabel lblAnnounceWinner = new JLabel("Announce Winner");
		add(lblAnnounceWinner, "cell 0 8,alignx right");
		
		chckbxAnnounceWinner = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAnnounceWinner()).equals("1")) {
			chckbxAnnounceWinner.setSelected(true);
		} else {
			chckbxAnnounceWinner.setSelected(false);
		}
		add(chckbxAnnounceWinner, "cell 1 8,alignx left");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSettings(foosObsSettings, settingsFrame);
			}
		});
		
		txtWinnerPrefix = new JTextField();
		txtWinnerPrefix.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWinnerPrefix.setText(foosObsSettings.getWinnerPrefix());
		add(txtWinnerPrefix, "cell 2 8,alignx center");
		txtWinnerPrefix.setColumns(10);
		
		txtWinnerSuffix = new JTextField();
		txtWinnerSuffix.setText(foosObsSettings.getWinnerSuffix());
		add(txtWinnerSuffix, "cell 3 8,growx,aligny top");
		txtWinnerSuffix.setColumns(10);
		
		JLabel lblAnnounceMeatball = new JLabel("Announce Meatball");
		add(lblAnnounceMeatball, "cell 0 9,alignx right");
		
		chckbxAnnounceMeatball = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAnnounceMeatball()).equals("1")) {
			chckbxAnnounceMeatball.setSelected(true);
		} else {
			chckbxAnnounceMeatball.setSelected(false);
		}
		add(chckbxAnnounceMeatball, "cell 1 9,alignx left");
		
		txtMeatball = new JTextField();
		txtMeatball.setHorizontalAlignment(SwingConstants.CENTER);
		txtMeatball.setText(foosObsSettings.getMeatball());
		add(txtMeatball, "cell 2 9,alignx center");
		txtMeatball.setColumns(10);
		
		JToggleButton tglbtnTimeOutsUsed = new JToggleButton("Time Outs Used");
		tglbtnTimeOutsUsed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (Integer.toString(foosObsSettings.getDefaultTimeOutsUsed()).equals("1")) {
					tglbtnTimeOutsUsed.setSelected(true);;
				} else {
					tglbtnTimeOutsUsed.setSelected(false);
				}
				System.out.println("togglebutton:  " + tglbtnTimeOutsUsed.isSelected());
			}
		});
		tglbtnTimeOutsUsed.setSelected(true);
		add(tglbtnTimeOutsUsed, "cell 0 10,alignx center");
		add(btnSave, "cell 1 12");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelSettings(settingsFrame);
			}
		});
		add(btnCancel, "cell 2 12,alignx center");
		
		JButton btnRestoreDefaults = new JButton("Restore Defaults");
		btnRestoreDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restoreDefaults(foosObsSettings);
			}
		});
		btnRestoreDefaults.setHorizontalAlignment(SwingConstants.RIGHT);
		add(btnRestoreDefaults, "cell 3 12,alignx right");

	}

	private void restoreDefaults(Settings foosObsSettings) {
		txtPointsToWin.setText(Integer.toString(foosObsSettings.getDefaultPointsToWin()));
		txtShotTime.setText(Integer.toString(foosObsSettings.getDefaultShotTime()));
		txtMaxWin.setText(Integer.toString(foosObsSettings.getDefaultMaxWin()));
		txtPassTime.setText(Integer.toString(foosObsSettings.getDefaultPassTime()));
		txtWinBy.setText(Integer.toString(foosObsSettings.getDefaultWinBy()));
		txtTimeOutTime.setText(Integer.toString(foosObsSettings.getDefaultTimeOutTime()));
		txtGamesToWin.setText(Integer.toString(foosObsSettings.getDefaultGamesToWin()));
		txtGameTime.setText(Integer.toString(foosObsSettings.getDefaultGameTime()));
		txtMaxTimeOuts.setText(Integer.toString(foosObsSettings.getDefaultMaxTimeOuts()));
		txtRecallTime.setText(Integer.toString(foosObsSettings.getDefaultRecallTime()));
		if (Integer.toString(foosObsSettings.getDefaultAutoIncrementGame()).equals("1")) {
			chckbxAutoIncrementGame.setSelected(true);
		} else {
			chckbxAutoIncrementGame.setSelected(false);
		}
		if (Integer.toString(foosObsSettings.getDefaultAnnounceWinner()).equals("1")) {
			chckbxAnnounceWinner.setSelected(true);
		} else {
			chckbxAnnounceWinner.setSelected(false);
		}
		txtWinnerPrefix.setText(foosObsSettings.getDefaultWinnerPrefix());
		txtWinnerSuffix.setText(foosObsSettings.getDefaultWinnerSuffix());
		if (Integer.toString(foosObsSettings.getDefaultAnnounceMeatball()).equals("1")) {
			chckbxAnnounceMeatball.setSelected(true);
		} else {
			chckbxAnnounceMeatball.setSelected(false);
		}
		txtMeatball.setText(foosObsSettings.getDefaultMeatball());
	}
	
	private void saveSettings(Settings foosObsSettings, JFrame settingsFrame) {
    	if (isValidInteger(txtPointsToWin.getText())) {
			foosObsSettings.setPointsToWin(Integer.parseInt(txtPointsToWin.getText()));
    	}
    	if (isValidInteger(txtMaxWin.getText())) {
			foosObsSettings.setMaxWin(Integer.parseInt(txtMaxWin.getText()));
    	}
    	if (isValidInteger(txtWinBy.getText())) {
		foosObsSettings.setWinBy(Integer.parseInt(txtWinBy.getText()));
    	}
    	if (isValidInteger(txtGamesToWin.getText())) {
		foosObsSettings.setGamesToWin(Integer.parseInt(txtGamesToWin.getText()));
    	}
    	if (isValidInteger(txtMaxTimeOuts.getText())) {
    		foosObsSettings.setMaxTimeOuts(Integer.parseInt(txtMaxTimeOuts.getText()));
    	}
		if (chckbxAutoIncrementGame.isSelected()) {
			foosObsSettings.setAutoIncrementGame(1);
		} else {
			foosObsSettings.setAutoIncrementGame(0);
		}
		if (chckbxAnnounceWinner.isSelected()) {
			foosObsSettings.setAnnounceWinner(1);
		} else {
			foosObsSettings.setAnnounceWinner(0);
		}
		if (chckbxAnnounceMeatball.isSelected()) {
			foosObsSettings.setAnnounceMeatball(1);
		} else {
			foosObsSettings.setAnnounceMeatball(0);
		}
		foosObsSettings.setMeatball(txtMeatball.getText());
    	if (isValidInteger(txtShotTime.getText())) {
    		foosObsSettings.setShotTime(Integer.parseInt(txtShotTime.getText()));
    	}
    	if (isValidInteger(txtPassTime.getText())) {
    		foosObsSettings.setPassTime(Integer.parseInt(txtPassTime.getText()));
    	}
    	if (isValidInteger(txtTimeOutTime.getText())) {
    		foosObsSettings.setTimeOutTime(Integer.parseInt(txtTimeOutTime.getText()));
    	}
    	if (isValidInteger(txtGameTime.getText())) {
    		foosObsSettings.setGameTime(Integer.parseInt(txtGameTime.getText()));
    	}
    	if (isValidInteger(txtRecallTime.getText())) {
    		foosObsSettings.setRecallTime(Integer.parseInt(txtRecallTime.getText()));
    	}
		try {
			foosObsSettings.saveToConfig();
		} catch (IOException ex) {
			System.out.print("Error saving properties file: " + ex.getMessage());		
		}
		settingsFrame.dispose();
	}

	private void cancelSettings(JFrame settingsFrame) {
		settingsFrame.dispose();
	}

	private boolean isValidInteger(String checkString) {
    	try {
    		Integer.parseInt(checkString);
    		return true;
    	} catch (NumberFormatException e) {
    		return false;
    	}
	}

	
}
