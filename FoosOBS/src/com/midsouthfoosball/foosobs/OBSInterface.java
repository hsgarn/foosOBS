package com.midsouthfoosball.foosobs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class OBSInterface {
	
	private String txtFileName;
	private String txtFilePath = "c:\\Temp";
	private String txtFileData;
	private int writeStatus;
	
	public String getFileName() {return txtFileName;};
	public void setFileName(String txtFileName) {this.txtFileName = txtFileName;}
	public String getFilePath() {return txtFilePath;};
	public void setFilePathe(String txtFilePath) {this.txtFilePath = txtFilePath;}
	public String getFileData() {return txtFileData;};
	public void setFileData(String txtFileData) {this.txtFileData = txtFileData;}
		
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
//		System.out.print("filename: " + whichFile + " Contents: " + theContents + "\r\n");
		BufferedWriter writer = new BufferedWriter(new FileWriter(txtFilePath + "\\" + whichFile));
		writer.write(theContents);
		writer.close();
	}
	
	public void writeContent(int whichFile) throws IOException {
		BufferedWriter writer = null;
		writer = new BufferedWriter(new FileWriter(fileNames[whichFile]));
		writer.close();
		
	}
	public String getContents(String whichFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(txtFilePath + "\\" + whichFile));
		String theContents = br.readLine();
		br.close();
		return theContents;
	}
	public int writeAllFiles() {
		return writeStatus;
	}

}
