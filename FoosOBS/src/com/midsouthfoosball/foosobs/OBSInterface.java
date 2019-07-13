package com.midsouthfoosball.foosobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OBSInterface {
	
	private String txtFilePath = "c:" + File.separator + "Temp";
	
	public enum fileNames {
		TOURNAMENT,
		EVENTNAME,
		TEAM1,
		TEAM2,
		GAME1,
		GAME2,
		SCORE1,
		SCORE2,
		TIMEOUT1,
		TIMEOUT2,
		RESET1,
		RESET2,
		WARN1,
		WARN2,
		TIMEREMAINING,
		TIMER
	}
	public enum fileContents {
		TOURNAMENT,
		EVENTNAME,
		TEAM1,
		TEAM2,
		GAME1,
		GAME2,
		SCORE1,
		SCORE2,
		TIMEOUT1,
		TIMEOUT2,
		RESET1,
		RESET2,
		WARN1,
		WARN2,
		TIMEREMAINING,
		TIMER
	}
	public String[] fileNames = {"tournament.txt", "event.txt", "team1.txt", "team2.txt", "game1.txt", "game2.txt", "score1.txt", "score2.txt",
									"timeout1.txt", "timeout2.txt", "reset1.txt", "reset2.txt", "warn1.txt", "warn2.txt", "timeremaining.txt", "timer.txt"};
	
	public void setFilePath(String filePath) {
		this.txtFilePath = filePath;
	}

	public void setContents(String whichFile, String theContents) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath + File.separator + whichFile));
		writer.write(theContents);
		writer.close();
	}
	
	public void writeContent(int whichFile) throws IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(fileNames[whichFile]));
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
