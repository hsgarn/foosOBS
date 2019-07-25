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
	private int maxTimeOuts;
	private int autoIncrementGame;
	private int announceWinner;
	private int announceMeatball;
	private String winnerPrefix;
	private String winnerSuffix;
	private int shotTime;
	private int passTime;
	private int timeOutTime;
	private int gameTime;
	private int recallTime;
	private String meatball;
	private int showTimeOutsUsed;
	private Properties defaultProps;
	
	public Properties configProps;
	private File configFile = new File("config.properties");
	
	public Settings() throws IOException {
		defaultProps = new Properties();
		// sets default properties
		defaultProps.setProperty("datapath", "c:" + File.separator + "temp");
		defaultProps.setProperty("PointsToWin", "5");
		defaultProps.setProperty("MaxWin", "8");
		defaultProps.setProperty("WinBy", "1");
		defaultProps.setProperty("GamesToWin", "2");
		defaultProps.setProperty("MaxTimeOuts", "2");
		defaultProps.setProperty("AutoIncrementGame", "1");
		defaultProps.setProperty("AnnounceWinner", "1");
		defaultProps.setProperty("AnnounceMeatball", "1");
		defaultProps.setProperty("WinnerPrefix", "Match Winner: ");
		defaultProps.setProperty("WinnerSuffix", "!!!");
		defaultProps.setProperty("Meatball", "Meatball!!!");
		defaultProps.setProperty("ShotTime", "15");
		defaultProps.setProperty("PassTime", "10");
		defaultProps.setProperty("TimeOutTime", "30");
		defaultProps.setProperty("GameTime", "90");
		defaultProps.setProperty("RecallTime", "10");
		defaultProps.setProperty("ShowTimeOutsUsed", "1");

		configProps = new Properties(defaultProps);
		
		loadFromConfig();
	}
	
	public String getDatapath() {return configProps.getProperty("datapath");}
	public int getPointsToWin() {return pointsToWin;}
	public int getMaxWin() {return maxWin;}
	public int getWinBy() {return winBy;}
	public int getGamesToWin() {return gamesToWin;}
	public int getMaxTimeOuts() {return maxTimeOuts;}
	public int getAutoIncrementGame() {return autoIncrementGame;}
	public int getAnnounceWinner() {return announceWinner;}
	public int getAnnounceMeatball() {return announceMeatball;}
	public String getWinnerPrefix() {return winnerPrefix;}
	public String getWinnerSuffix() {return winnerSuffix;}
	public String getMeatball() {return meatball;}
	public int getShotTime() {return shotTime;}
	public int getPassTime() {return passTime;}
	public int getTimeOutTime() {return timeOutTime;}
	public int getGameTime() {return gameTime;}
	public int getRecallTime() {return recallTime;}
	public int getShowTimeOutsUsed() {return showTimeOutsUsed;}
	
	
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
	public void setMaxTimeOuts(int maxTimeOuts) {
		this.maxTimeOuts = maxTimeOuts;
		configProps.setProperty("MaxTimeOuts", Integer.toString(this.maxTimeOuts));
		}
	public void setAutoIncrementGame(int autoIncrementGame) {
		this.autoIncrementGame = autoIncrementGame;
		configProps.setProperty("AutoIncrementGame", Integer.toString(this.autoIncrementGame));
		}
	public void setAnnounceWinner(int announceWinner) {
		this.announceWinner = announceWinner;
		configProps.setProperty("AnnounceWinner", Integer.toString(this.announceWinner));
		}
	public void setAnnounceMeatball(int announceMeatball) {
		this.announceMeatball = announceMeatball;
		configProps.setProperty("AnnounceMeatball", Integer.toString(this.announceMeatball));
		}
	public void setWinnerSufffix(String winnerSuffix) {
		this.winnerSuffix = winnerSuffix;
		configProps.setProperty("WinnerSuffix", this.winnerSuffix);
	}
	public void setMeatball(String meatball) {
		this.meatball= meatball;
		configProps.setProperty("Meatball", this.meatball);
	}
	public void setShotTime(int shotTime) {
		this.shotTime = shotTime;
		configProps.setProperty("ShotTime", Integer.toString(this.shotTime));
		}
	public void setPassTime(int passTime) {
		this.passTime = passTime;
		configProps.setProperty("PassTime", Integer.toString(this.passTime));
		}
	public void setTimeOutTime(int timeOutTime) {
		this.timeOutTime = timeOutTime;
		configProps.setProperty("TimeOutTime", Integer.toString(this.timeOutTime));
		}
	public void setGameTime(int gameTime) {
		this.gameTime = gameTime;
		configProps.setProperty("GameTime", Integer.toString(this.gameTime));
		}
	public void setRecallTime(int recallTime) {
		this.recallTime = recallTime;
		configProps.setProperty("RecallTime", Integer.toString(this.recallTime));
		}
	public void setShowTimeOutsUsed(int showTimeOutsUsed) {
		this.showTimeOutsUsed = showTimeOutsUsed;
		configProps.setProperty("ShowTimeOutsUsed", Integer.toString(this.showTimeOutsUsed));
	}
	
	public int getDefaultPointsToWin() {return Integer.parseInt(defaultProps.getProperty("PointsToWin"));}
	public int getDefaultMaxWin() {return Integer.parseInt(defaultProps.getProperty("MaxWin"));}
	public int getDefaultWinBy() {return Integer.parseInt(defaultProps.getProperty("WinBy"));}
	public int getDefaultGamesToWin() {return Integer.parseInt(defaultProps.getProperty("GamesToWin"));}
	public int getDefaultMaxTimeOuts() {return Integer.parseInt(defaultProps.getProperty("MaxTimeOuts"));}
	public int getDefaultAutoIncrementGame() {return Integer.parseInt(defaultProps.getProperty("AutoIncrementGame"));}
	public int getDefaultAnnounceWinner() {return Integer.parseInt(defaultProps.getProperty("AnnounceWinner"));}
	public int getDefaultAnnounceMeatball() {return Integer.parseInt(defaultProps.getProperty("AnnounceMeatball"));}
	public String getDefaultWinnerPrefix() {return defaultProps.getProperty("WinnerPrefix");}
	public String getDefaultWinnerSuffix() {return defaultProps.getProperty("WinnerSuffix");}
	public String getDefaultMeatball() {return defaultProps.getProperty("Meatball");}
	public int getDefaultShotTime() {return Integer.parseInt(defaultProps.getProperty("ShotTime"));}
	public int getDefaultPassTime() {return Integer.parseInt(defaultProps.getProperty("PassTime"));}
	public int getDefaultTimeOutTime() {return Integer.parseInt(defaultProps.getProperty("TimeOutTime"));}
	public int getDefaultGameTime() {return Integer.parseInt(defaultProps.getProperty("GameTime"));}
	public int getDefaultRecallTime() {return Integer.parseInt(defaultProps.getProperty("RecallTime"));}
	public int getDefaultShowTimeOutsUsed() {return Integer.parseInt(defaultProps.getProperty("ShowTimeOutsUsed"));}

	public void loadFromConfig() throws IOException {

		InputStream inputStream = new FileInputStream(configFile);
		configProps.load(inputStream);
		inputStream.close();
		
		datapath = configProps.getProperty("datapath");
		pointsToWin = Integer.parseInt(configProps.getProperty("PointsToWin"));
		maxWin = Integer.parseInt(configProps.getProperty("MaxWin"));
		winBy = Integer.parseInt(configProps.getProperty("WinBy"));
		gamesToWin = Integer.parseInt(configProps.getProperty("GamesToWin"));
		maxTimeOuts = Integer.parseInt(configProps.getProperty("MaxTimeOuts"));
		autoIncrementGame = Integer.parseInt(configProps.getProperty("AutoIncrementGame"));
		announceWinner = Integer.parseInt(configProps.getProperty("AnnounceWinner"));
		announceMeatball = Integer.parseInt(configProps.getProperty("AnnounceMeatball"));
		winnerPrefix = configProps.getProperty("WinnerPrefix");
		winnerSuffix = configProps.getProperty("WinnerSuffix");
		meatball = configProps.getProperty("Meatball");
		shotTime = Integer.parseInt(configProps.getProperty("ShotTime"));
		passTime = Integer.parseInt(configProps.getProperty("PassTime"));
		timeOutTime = Integer.parseInt(configProps.getProperty("TimeOutTime"));
		gameTime = Integer.parseInt(configProps.getProperty("GameTime"));
		recallTime = Integer.parseInt(configProps.getProperty("RecallTime"));
		showTimeOutsUsed = Integer.parseInt(configProps.getProperty("ShowTimeOutsUsed"));
	}
	
	public void saveToConfig() throws IOException {
		configProps.setProperty("datapath", this.getDatapath());
		configProps.setProperty("PointsToWin", Integer.toString(this.getPointsToWin()));
		configProps.setProperty("MaxWin", Integer.toString(this.getMaxWin()));
		configProps.setProperty("WinBy", Integer.toString(this.getWinBy()));
		configProps.setProperty("GamesToWin", Integer.toString(this.getGamesToWin()));
		configProps.setProperty("MaxTimeOuts", Integer.toString(this.getMaxTimeOuts()));
		configProps.setProperty("AutoIncrementGame", Integer.toString(this.getAutoIncrementGame()));
		configProps.setProperty("AnnounceWinner", Integer.toString(this.getAnnounceWinner()));
		configProps.setProperty("AnnounceMeatball", Integer.toString(this.getAnnounceMeatball()));
		configProps.setProperty("WinnerPrefix", this.getWinnerPrefix());
		configProps.setProperty("WinnerSuffix", this.getWinnerSuffix());
		configProps.setProperty("Meatball",  this.getMeatball());
		configProps.setProperty("ShotTime", Integer.toString(this.getShotTime()));
		configProps.setProperty("PassTime", Integer.toString(this.getPassTime()));
		configProps.setProperty("TimeOutTime", Integer.toString(this.getTimeOutTime()));
		configProps.setProperty("GameTime", Integer.toString(this.getGameTime()));
		configProps.setProperty("RecallTime", Integer.toString(this.getRecallTime()));
		configProps.setProperty("ShowTimeOutsUsed", Integer.toString(this.getShowTimeOutsUsed()));

		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB settings");
		outputStream.close();
	}
}
