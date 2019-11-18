/**
Copyright 2019 Hugh Garner
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextArea;

public class AboutJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public AboutJPanel(JFrame aboutFrame) {
		setLayout(new MigLayout("", "[127.00][50.00:87.00,grow,left]", "[][][][][grow]"));
		
		JLabel lblProgram = new JLabel("Program:");
		add(lblProgram, "cell 0 0,alignx right");
		
		JLabel lblProgramValue = new JLabel("Foos OBS");
		add(lblProgramValue, "cell 1 0");
		
		JLabel lblVersion = new JLabel("Version:");
		add(lblVersion, "cell 0 1,alignx right");
		
		JLabel lblNewLabel = new JLabel("1.12");
		add(lblNewLabel, "cell 1 1");
		
		JLabel lblAuthor = new JLabel("Author:");
		add(lblAuthor, "cell 0 2,alignx right");
		
		JLabel lblAuthorValue = new JLabel("Hugh Garner");
		add(lblAuthorValue, "cell 1 2");
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9");
		add(lblCopyright, "cell 0 3,alignx right");
		
		JLabel lblCopyrightValue = new JLabel("2019 Hugh Garner");
		add(lblCopyrightValue, "cell 1 3");
		
		JLabel lblLicense = new JLabel("License:");
		add(lblLicense, "cell 0 4,alignx right");
		
		JTextArea txtrPermissionIsHereby = new JTextArea();
		txtrPermissionIsHereby.setText("Permission is hereby granted, free of charge, to any person obtaining a copy \r\nof this software and associated documentation files (the \"Software\"), to deal \r\nin the Software without restriction, including without limitation the rights \r\nto use, copy, modify, merge, publish, distribute, sublicense, and/or sell \r\ncopies of the Software, and to permit persons to whom the Software is \r\nfurnished to do so, subject to the following conditions:\r\n\r\nThe above copyright notice and this permission notice shall be included in \r\nall copies or substantial portions of the Software.\r\n\r\nTHE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR \r\nIMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, \r\nFITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL \r\nTHE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR \r\nOTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, \r\nARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR \r\nOTHER DEALINGS IN THE SOFTWARE.");
		add(txtrPermissionIsHereby, "cell 1 4,grow");

	}

}
