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

public class SettingsJPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtPointsToWin;
	private JTextField txtMaxWin;
	private JTextField txtGamesToWin;
	private JTextField txtWinBy;
	private JCheckBox chckbxAutoIncrementGame;
	private JCheckBox chckbxAnnounceWinner;
//	private static Settings foosObsSettingsTemp;
	private static Settings foosObsSettings;

	public SettingsJPanel(Settings foosObsSettings, JFrame settingsFrame) throws IOException {
//		SettingsJPanel.foosObsSettingsTemp = foosObsSettings; //Make a temp copy to work from in case user cancels
		System.out.println("foosobssettings: " + foosObsSettings.getPointsToWin());
		setLayout(new MigLayout("", "[119.00][50.00:90.00,grow][][][]", "[][][][][][][][][]"));
		
		JLabel lblParameter = new JLabel("Parameter");
		lblParameter.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblParameter, "cell 0 0,alignx right");
		
		JLabel lblValue = new JLabel("Value");
		lblValue.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(lblValue, "cell 1 0,alignx left");
		
		JLabel lblPointsToWin = new JLabel("Points to Win");
		add(lblPointsToWin, "cell 0 1,alignx right");
		
		txtPointsToWin = new JTextField();
		txtPointsToWin.setText(Integer.toString(foosObsSettings.getPointsToWin()));
		add(txtPointsToWin, "cell 1 1,alignx left");
		txtPointsToWin.setColumns(10);
		
		JLabel lblMaxWin = new JLabel("Max Win");
		add(lblMaxWin, "cell 0 2,alignx right");
		
		txtMaxWin = new JTextField();
		txtMaxWin.setText(Integer.toString(foosObsSettings.getMaxWin()));
		add(txtMaxWin, "cell 1 2,alignx left");
		txtMaxWin.setColumns(10);
		
		JLabel lblWinBy = new JLabel("Win by");
		add(lblWinBy, "cell 0 3,alignx trailing");
		
		txtWinBy = new JTextField();
		txtWinBy.setText(Integer.toString(foosObsSettings.getWinBy()));
		add(txtWinBy, "cell 1 3,alignx left");
		txtWinBy.setColumns(10);
		
		JLabel lblGamesToWin = new JLabel("Games to Win");
		add(lblGamesToWin, "cell 0 4,alignx trailing");
		
		txtGamesToWin = new JTextField();
		txtGamesToWin.setText(Integer.toString(foosObsSettings.getGamesToWin()));
		add(txtGamesToWin, "cell 1 4,alignx left");
		txtGamesToWin.setColumns(10);
		
		JLabel lblAutoIncrementGame = new JLabel("Auto Increment Game");
		add(lblAutoIncrementGame, "cell 0 5,alignx right");
		
		chckbxAutoIncrementGame = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAutoIncrementGame()).equals("1")) {
			chckbxAutoIncrementGame.setSelected(true);
		} else {
			chckbxAutoIncrementGame.setSelected(false);
		}
		chckbxAutoIncrementGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		add(chckbxAutoIncrementGame, "cell 1 5");
		
		JLabel lblAnnounceWinner = new JLabel("Announce Winner");
		add(lblAnnounceWinner, "cell 0 6,alignx right");
		
		chckbxAnnounceWinner = new JCheckBox("");
		if (Integer.toString(foosObsSettings.getAnnounceWinner()).equals("1")) {
			chckbxAnnounceWinner.setSelected(true);
		} else {
			chckbxAnnounceWinner.setSelected(false);
		}
		chckbxAnnounceWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(chckbxAnnounceWinner, "cell 1 6,alignx left");
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				saveSettings(foosObsSettings, settingsFrame);
			}
		});
		add(btnSave, "cell 1 8");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cancelSettings(settingsFrame);
			}
		});
		add(btnCancel, "cell 2 8");

	}

	private void saveSettings(Settings foosObsSettings, JFrame settingsFrame) {
		try {
			foosObsSettings.setPointsToWin(Integer.parseInt(txtPointsToWin.getText()));
			foosObsSettings.setMaxWin(Integer.parseInt(txtMaxWin.getText()));
			foosObsSettings.setGamesToWin(Integer.parseInt(txtGamesToWin.getText()));
			foosObsSettings.setWinBy(Integer.parseInt(txtWinBy.getText()));
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
			foosObsSettings.saveToConfig();
		} catch (IOException ex) {
			System.out.print("Error saving properties file: " + ex.getMessage());		
		}

		settingsFrame.dispose();
	}

	private void cancelSettings(JFrame settingsFrame) {
		settingsFrame.dispose();
	}


}
