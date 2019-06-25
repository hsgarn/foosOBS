package com.midsouthfoosball.foosobs;

public class TextFile {
	private String txtFileName;
	private String txtFilePath;
	private String txtFileData;
	private int writeStatus;
	
	public String getFileName() {return txtFileName;};
	public void setFileName(String txtFileName) {this.txtFileName = txtFileName;}
	public String getFilePath() {return txtFilePath;};
	public void setFilePathe(String txtFilePath) {this.txtFilePath = txtFilePath;}
	public String getFileData() {return txtFileData;};
	public void setFileData(String txtFileData) {this.txtFileData = txtFileData;}

	public String readFileData() {
		return txtFileData;
	}
	
	public int writeFile() {
		return writeStatus;
	}
}