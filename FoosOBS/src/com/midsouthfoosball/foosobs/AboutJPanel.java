package com.midsouthfoosball.foosobs;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class AboutJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AboutJPanel(JFrame aboutFrame) {
		setLayout(new MigLayout("", "[127.00][50.00:87.00,grow,left]", "[][][][]"));
		
		JLabel lblProgram = new JLabel("Program:");
		add(lblProgram, "cell 0 0,alignx right");
		
		JLabel lblProgramValue = new JLabel("Foos OBS");
		add(lblProgramValue, "cell 1 0");
		
		JLabel lblVersion = new JLabel("Version:");
		add(lblVersion, "cell 0 1,alignx right");
		
		JLabel lblNewLabel = new JLabel("1.1");
		add(lblNewLabel, "cell 1 1");
		
		JLabel lblAuthor = new JLabel("Author:");
		add(lblAuthor, "cell 0 2,alignx right");
		
		JLabel lblAuthorValue = new JLabel("Hugh Garner");
		add(lblAuthorValue, "cell 1 2");
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9");
		add(lblCopyright, "cell 0 3,alignx right");
		
		JLabel lblCopyrightValue = new JLabel("2019");
		add(lblCopyrightValue, "cell 1 3");

	}

}
