package com.midsouthfoosball.foosobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Settings {
	
	private String datapath;
	private int pointsToWin;
	private int maxWin;
	private int winBy;
	private int gamesToWin;
	private int autoIncrementGame;
	private int announceWinner;
	public Properties configProps;
	private File configFile = new File("config.properties");
	
	public Settings(Properties configProps) throws IOException {}
	
	public String getDatapath() {return datapath;}
	public int getPointsToWin() {return pointsToWin;}
	public int getMaxWin() {return maxWin;}
	public int getWinBy() {return winBy;}
	public int getGamesToWin() {return gamesToWin;}
	public int getAutoIncrementGame() {return autoIncrementGame;}
	public int getAnnounceWinner() {return announceWinner;}
	
	public void setDatapath(String datapath) {
		this.datapath = datapath;
		configProps.setProperty("datapath", this.datapath);
	}
	public void setPointsToWin(int pointsToWin) {
		this.pointsToWin = pointsToWin;
		configProps.setProperty("PointsToWin", Integer.toString(this.pointsToWin));
		}
	public void setMaxWin(int maxWin) {
		this.maxWin = maxWin;
		configProps.setProperty("MaxWin", Integer.toString(this.maxWin));
		}
	public void setWinBy(int winBy) {
		this.winBy = winBy;
		configProps.setProperty("WinBy", Integer.toString(this.winBy));
		}
	public void setGamesToWin(int gamesToWin) {
		this.gamesToWin = gamesToWin;
		configProps.setProperty("GamesToWin", Integer.toString(this.gamesToWin));
		}
	public void setAutoIncrementGame(int autoIncrementGame) {
		this.autoIncrementGame = autoIncrementGame;
		configProps.setProperty("AutoIncrementGame", Integer.toString(this.autoIncrementGame));
		}
	public void setAnnounceWinner(int announceWinner) {
		this.announceWinner = announceWinner;
		configProps.setProperty("AnnounceWinner", Integer.toString(this.announceWinner));
		}

	public void loadFromConfig(Properties configProps) throws IOException {

		InputStream inputStream = new FileInputStream(configFile);
		configProps.load(inputStream);
		inputStream.close();
		
		datapath = configProps.getProperty("datapath");
		pointsToWin = Integer.parseInt(configProps.getProperty("PointsToWin"));
		maxWin = Integer.parseInt(configProps.getProperty("MaxWin"));
		winBy = Integer.parseInt(configProps.getProperty("WinBy"));
		gamesToWin = Integer.parseInt(configProps.getProperty("GamesToWin"));
		autoIncrementGame = Integer.parseInt(configProps.getProperty("AutoIncrementGame"));
		announceWinner = Integer.parseInt(configProps.getProperty("AnnounceWinner"));
	}
	
	public void saveToConfig(Properties configProps) throws IOException {
		System.out.println("made it to settings savetoconfig");
		configProps.setProperty("datapath", this.getDatapath());
		configProps.setProperty("PointsToWin", Integer.toString(this.getPointsToWin()));
		configProps.setProperty("MaxWin", Integer.toString(this.getMaxWin()));
		configProps.setProperty("WinBy", Integer.toString(this.getWinBy()));
		configProps.setProperty("GamesToWin", Integer.toString(this.getGamesToWin()));
		configProps.setProperty("AutoIncrementGame", Integer.toString(this.getAutoIncrementGame()));
		configProps.setProperty("AnnounceWinner", Integer.toString(this.getAnnounceWinner()));

		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB settings");
		outputStream.close();
	}
}
