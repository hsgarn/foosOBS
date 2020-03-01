/**
Copyright 2019, 2020 Hugh Garner
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

import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

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
	private JCheckBox chckbxShowTimeOutsUsed;
	private JCheckBox chckbxAutoCapNames;
	private JTextField txtTeam1LastScored;
	private JTextField txtTeam2LastScored;
	private JTextField txtClearLastScored;
	private JTextField txtNameSeparator;

	public SettingsJPanel(Settings foosObsSettings, JFrame settingsFrame) throws IOException {

		setLayout(new MigLayout("", "[119.00][50.00:87.00,grow,left][78.00,grow][grow][]", "[][][][][][][][][][][][][][][][][][][]"));
		
		JLabel lblParameter = new JLabel("Parameter");
		lblParameter.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblParameter, "cell 0 0,alignx right");
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblValue, "cell 1 0,alignx left");
		
		JLabel label = new JLabel("Parameter");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label, "cell 2 0,alignx right");
		
		JLabel label_1 = new JLabel("Value");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(label_1, "cell 3 0");
		
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
		
		JLabel lblTeam1LastScored = new JLabel("Team 1 Last Scored");
		add(lblTeam1LastScored, "cell 0 6,alignx trailing");
		
		txtTeam1LastScored = new JTextField();
		txtTeam1LastScored.setText(foosObsSettings.getTeam1LastScored());
		add(txtTeam1LastScored, "cell 1 6,growx");
		txtTeam1LastScored.setColumns(10);

		JLabel lblTeam2LastScored = new JLabel("Team 2 Last Scored");
		add(lblTeam2LastScored, "cell 2 6,alignx trailing");
		
		txtTeam2LastScored = new JTextField();
		txtTeam2LastScored.setText(foosObsSettings.getTeam2LastScored());
		add(txtTeam2LastScored, "cell 3 6,growx");
		txtTeam2LastScored.setColumns(10);
		
		JLabel lblClearLastScored = new JLabel("Clear Last Scored");
		add(lblClearLastScored, "cell 0 7,alignx trailing");
		
		txtClearLastScored = new JTextField();
		txtClearLastScored.setText(foosObsSettings.getClearLastScored());
		add(txtClearLastScored, "cell 1 7,growx");
		txtClearLastScored.setColumns(10);
		
		JLabel lblTeamNameSeparator = new JLabel("Team Name Separator");
		add(lblTeamNameSeparator, "cell 2 7,alignx trailing");
		
		txtNameSeparator = new JTextField();
		txtNameSeparator.setText(foosObsSettings.getNameSeparator());
		add(txtNameSeparator, "cell 3 7,alignx left");
		txtNameSeparator.setColumns(10);
		
		JLabel lblAutoIncrementGame = new JLabel("Auto Increment Game");
		add(lblAutoIncrementGame, "cell 0 11,alignx right");
		
		chckbxAutoIncrementGame = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAutoIncrementGame()).equals("1")) {
			chckbxAutoIncrementGame.setSelected(true);
		} else {
			chckbxAutoIncrementGame.setSelected(false);
		}
		add(chckbxAutoIncrementGame, "cell 1 11");
		
		JLabel lblWinnerPrefix = new JLabel("Winner Prefix");
		add(lblWinnerPrefix, "cell 2 11,alignx center");
		
		JLabel lblWinnerSuffix = new JLabel("Winner Suffix");
		add(lblWinnerSuffix, "cell 3 11,alignx center");
		
		JLabel lblAnnounceWinner = new JLabel("Announce Winner");
		add(lblAnnounceWinner, "cell 0 12,alignx right");
		
		chckbxAnnounceWinner = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAnnounceWinner()).equals("1")) {
			chckbxAnnounceWinner.setSelected(true);
		} else {
			chckbxAnnounceWinner.setSelected(false);
		}
		add(chckbxAnnounceWinner, "cell 1 12,alignx left");
		
		JButton btnFiles = new JButton("Files...");
		btnFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame fileNamesFrame = new JFrame("Foos OBS File Names ");
				fileNamesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				FileNamesJPanel fnjp;
				try {
					fileNamesFrame.setAlwaysOnTop(true);
					fnjp = new FileNamesJPanel(foosObsSettings, fileNamesFrame);
					fnjp.setPreferredSize(new Dimension(500, 350));

					fileNamesFrame.getContentPane().add(fnjp);
					fileNamesFrame.pack();
					fileNamesFrame.setVisible(true);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnFiles.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnFiles.setForeground(Color.BLACK);
		btnFiles.setBackground(Color.CYAN);
		btnFiles.setBounds(92, 100, 125, 23);
		add(btnFiles, "cell 0 17,growx");
		
		txtWinnerPrefix = new JTextField();
		txtWinnerPrefix.setHorizontalAlignment(SwingConstants.RIGHT);
		txtWinnerPrefix.setText(foosObsSettings.getWinnerPrefix());
		add(txtWinnerPrefix, "cell 2 12,alignx center");
		txtWinnerPrefix.setColumns(10);
		
		txtWinnerSuffix = new JTextField();
		txtWinnerSuffix.setText(foosObsSettings.getWinnerSuffix());
		add(txtWinnerSuffix, "cell 3 12,growx,aligny top");
		txtWinnerSuffix.setColumns(10);
		
		JLabel lblAnnounceMeatball = new JLabel("Announce Meatball");
		add(lblAnnounceMeatball, "cell 0 13,alignx right");
		
		chckbxAnnounceMeatball = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAnnounceMeatball()).equals("1")) {
			chckbxAnnounceMeatball.setSelected(true);
		} else {
			chckbxAnnounceMeatball.setSelected(false);
		}
		add(chckbxAnnounceMeatball, "cell 1 13,alignx left");
		
		txtMeatball = new JTextField();
		txtMeatball.setHorizontalAlignment(SwingConstants.CENTER);
		txtMeatball.setText(foosObsSettings.getMeatball());
		add(txtMeatball, "cell 2 13,alignx center");
		txtMeatball.setColumns(10);
		
		JLabel lblShowTimeOutsUsed = new JLabel("Show Time Outs Used");
		add(lblShowTimeOutsUsed, "cell 0 14,alignx right");
		
		chckbxShowTimeOutsUsed = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getShowTimeOutsUsed()).equals("1")) {
			chckbxShowTimeOutsUsed.setSelected(true);
		} else {
			chckbxShowTimeOutsUsed.setSelected(false);
		}
		add(chckbxShowTimeOutsUsed, "cell 1 14");
		
		JLabel lblAutoCapitalizeTeam = new JLabel("Auto Capitalize Names");
		add(lblAutoCapitalizeTeam, "cell 0 15,alignx right");
		
		chckbxAutoCapNames = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAutoCapNames()).equals("1")) {
			chckbxAutoCapNames.setSelected(true);
		} else {
			chckbxAutoCapNames.setSelected(false);
		}
		add(chckbxAutoCapNames, "cell 1 15");

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSettings(foosObsSettings, settingsFrame);
			}
		});
		
		JButton btnHotKeys = new JButton("Hot Keys...");
		btnHotKeys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame hotKeysFrame = new JFrame("Foos OBS Hot Keys ");
				hotKeysFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
				HotKeysJPanel hkjp;
				try {
					hotKeysFrame.setAlwaysOnTop(true);
					hkjp = new HotKeysJPanel(foosObsSettings, hotKeysFrame);
					hkjp.setPreferredSize(new Dimension(800, 410));

					hotKeysFrame.getContentPane().add(hkjp);
					hotKeysFrame.pack();
					hotKeysFrame.setVisible(true);

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnHotKeys.setForeground(Color.BLACK);
		btnHotKeys.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHotKeys.setBackground(Color.CYAN);
		add(btnHotKeys, "cell 0 18,growx");
		add(btnSave, "cell 1 18,alignx center");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelSettings(settingsFrame);
			}
		});
		add(btnCancel, "cell 2 18,alignx center");
		
		JButton btnRestoreDefaults = new JButton("Restore Defaults");
		btnRestoreDefaults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				restoreDefaults(foosObsSettings);
			}
		});
		btnRestoreDefaults.setHorizontalAlignment(SwingConstants.RIGHT);
		add(btnRestoreDefaults, "cell 3 18,alignx center");
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
		if (Integer.toString(foosObsSettings.getDefaultShowTimeOutsUsed()).equals("1")) {
			chckbxShowTimeOutsUsed.setSelected(true);
		} else {
			chckbxShowTimeOutsUsed.setSelected(false);
		}
		if (Integer.toString(foosObsSettings.getDefaultAutoCapNames()).equals("1")) {
			chckbxAutoCapNames.setSelected(true);
		} else {
			chckbxAutoCapNames.setSelected(false);
		}
		txtTeam1LastScored.setText(foosObsSettings.getDefaultTeam1LastScored());
		txtTeam2LastScored.setText(foosObsSettings.getDefaultTeam2LastScored());
		txtClearLastScored.setText(foosObsSettings.getDefaultClearLastScored());
		txtNameSeparator.setText(foosObsSettings.getDefaultNameSeparator());
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
		foosObsSettings.setWinnerPrefix(txtWinnerPrefix.getText());
		foosObsSettings.setWinnerSuffix(txtWinnerSuffix.getText());
		foosObsSettings.setTeam1LastScored(txtTeam1LastScored.getText());
		foosObsSettings.setTeam2LastScored(txtTeam2LastScored.getText());
		foosObsSettings.setClearLastScored(txtClearLastScored.getText());
		foosObsSettings.setNameSeparator(txtNameSeparator.getText());

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
		if (chckbxShowTimeOutsUsed.isSelected()) {
			foosObsSettings.setShowTimeOutsUsed(1);
		} else {
			foosObsSettings.setShowTimeOutsUsed(0);
		}
		if (chckbxAutoCapNames.isSelected()) {
			foosObsSettings.setAutoCapNames(1);
		} else {
			foosObsSettings.setAutoCapNames(0);
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
