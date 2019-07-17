package com.midsouthfoosball.foosobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OBSInterface {
	
	private String txtFilePath = "c:" + File.separator + "Temp";
	
	public String[] fileNames = {"tournament.txt", "event.txt", "team1.txt", "team2.txt", "game1.txt", "game2.txt", "score1.txt", "score2.txt",
									"timeout1.txt", "timeout2.txt", "reset1.txt", "reset2.txt", "warn1.txt", "warn2.txt", "timeremaining.txt", "timer.txt"};
	
	public void setFilePath(String filePath) {
		this.txtFilePath = filePath;
	}
	
	public String getFilePath() {return this.txtFilePath;} 

	public void setContents(String whichFile, String theContents) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath + File.separator + whichFile));
		writer.write(theContents);
		writer.close();
	}

	public String getContents(String whichFile) throws IOException {
		String theContents = null;
		String theFileName = txtFilePath + File.separator + whichFile;
		File theFile = new File(theFileName); 
		if (!theFile.exists()) {
			theContents = null;
		} else {
			try {
				BufferedReader br = new BufferedReader(new FileReader(theFileName));
				theContents = br.readLine();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.print("io exception!");
			}
		}
		return theContents;
	}
}
