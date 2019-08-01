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
	private String team1FileName;
	private String tournamentFileName;
	private String team2FileName;
	private String eventFileName;
	private String gameCount1FileName;
	private String timeRemainingFileName;
	private String gameCount2FileName;
	private String timerFileName;
	private String score1FileName;
	private String matchWinnerFileName;
	private String score2FileName;
	private String timeOut1FileName;
	private String timeOut2FileName;
	private String reset1FileName;
	private String reset2FileName;
	private String warn1FileName;
	private String warn2FileName;
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
		defaultProps.setProperty("Team1FileName", "team1.txt");
		defaultProps.setProperty("TournamentFileName", "tournament.txt");
		defaultProps.setProperty("Team2FileName", "team2.txt");
		defaultProps.setProperty("EventFileName", "event.txt");
		defaultProps.setProperty("GameCount1FileName", "gamecount1.txt");
		defaultProps.setProperty("TimeRemainingFileName", "timeremaining.txt");
		defaultProps.setProperty("GameCount2FileName", "gamecount2.txt");
		defaultProps.setProperty("TimerFileName", "timerinuse.txt");
		defaultProps.setProperty("Score1FileName", "score1.txt");
		defaultProps.setProperty("MatchWinnerFileName", "matchwinner.txt");
		defaultProps.setProperty("Score2FileName", "score2.txt");
		defaultProps.setProperty("TimeOut1FileName", "timeout1.txt");
		defaultProps.setProperty("TimeOut2FileName", "timeout2.txt");
		defaultProps.setProperty("Reset1FileName", "reset1.txt");
		defaultProps.setProperty("Reset2FileName", "reset2.txt");
		defaultProps.setProperty("Warn1FileName", "warn1.txt");
		defaultProps.setProperty("Warn2FileName", "warn2.txt");
		
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
	public String getTeam1FileName() {return team1FileName;}
	public String getTournamentFileName() {return tournamentFileName;}
	public String getTeam2FileName() {return team2FileName;}
	public String getEventFileName() {return eventFileName;}
	public String getGameCount1FileName() {return gameCount1FileName;}
	public String getTimeRemainingFileName() {return timeRemainingFileName;}
	public String getGameCount2FileName() {return gameCount2FileName;}
	public String getTimerFileName() {return timerFileName;}
	public String getScore1FileName() {return score1FileName;}
	public String getMatchWinnerFileName() {return matchWinnerFileName;}
	public String getScore2FileName() {return score2FileName;}
	public String getTimeOut1FileName() {return timeOut1FileName;}
	public String getTimeOut2FileName() {return timeOut2FileName;}
	public String getReset1FileName() {return reset1FileName;}
	public String getReset2FileName() {return reset2FileName;}
	public String getWarn1FileName() {return warn1FileName;}
	public String getWarn2FileName() {return warn2FileName;}
	
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
	public void setWinnerPrefix(String winnerPrefix) {
		this.winnerPrefix = winnerPrefix;
		configProps.setProperty("WinnerPrefix", this.winnerPrefix);
	}
	public void setWinnerSuffix(String winnerSuffix) {
		this.winnerSuffix = winnerSuffix;
		configProps.setProperty("WinnerSuffix", this.winnerSuffix);
	}
	public void setMeatball(String meatball) {
		this.meatball = meatball;
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
	public void setTeam1FileName(String team1FileName) {
		this.team1FileName = team1FileName;
		configProps.setProperty("Team1FileName", this.team1FileName);
	}
	public void setTournamentFileName(String tournamentFileName) {
		this.tournamentFileName = tournamentFileName;
		configProps.setProperty("TournamentFileName", this.tournamentFileName);
	}
	public void setTeam2FileName(String team2FileName) {
		this.team2FileName = team2FileName;
		configProps.setProperty("Team2FileName", this.team2FileName);
	}
	public void setEventFileName(String eventFileName) {
		this.eventFileName = eventFileName;
		configProps.setProperty("EventFileName", this.eventFileName);
	}
	public void setGameCount1FileName(String gameCount1FileName) {
		this.gameCount1FileName = gameCount1FileName;
		configProps.setProperty("GameCount1FileName", this.gameCount1FileName);
	}
	public void setTimeRemainingFileName(String timeRemainingFileName) {
		this.timeRemainingFileName = timeRemainingFileName;
		configProps.setProperty("TimeRemainingFileName", this.timeRemainingFileName);
	}
	public void setGameCount2FileName(String gameCount2FileName) {
		this.gameCount2FileName = gameCount2FileName;
		configProps.setProperty("GameCount2FileName", this.gameCount2FileName);
	}
	public void setTimerFileName(String timerFileName) {
		this.timerFileName = timerFileName;
		configProps.setProperty("TimerFileName", this.timerFileName);
	}
	public void setScore1FileName(String score1FileName) {
		this.score1FileName = score1FileName;
		configProps.setProperty("Score1FileName", this.score1FileName);
	}
	public void setMatchWinnerFileName(String matchWinnerFileName) {
		this.matchWinnerFileName = matchWinnerFileName;
		configProps.setProperty("MatchWinnerFileName", this.matchWinnerFileName);
	}
	public void setScore2FileName(String score2FileName) {
		this.score2FileName = score2FileName;
		configProps.setProperty("Score2FileName", this.score2FileName);
	}
	public void setTimeOut1FileName(String timeOut1FileName) {
		this.timeOut1FileName = timeOut1FileName;
		configProps.setProperty("TimeOut1FileName", this.timeOut1FileName);
	}
	public void setTimeOut2FileName(String timeOut2FileName) {
		this.timeOut2FileName = timeOut2FileName;
		configProps.setProperty("TimeOut2FileName", this.timeOut2FileName);
	}
	public void setReset1FileName(String reset1FileName) {
		this.reset1FileName = reset1FileName;
		configProps.setProperty("Reset1FileName", this.reset1FileName);
	}
	public void setReset2FileName(String reset2FileName) {
		this.reset2FileName = reset2FileName;
		configProps.setProperty("Reset2FileName", this.reset2FileName);
	}
	public void setWarn1FileName(String warn1FileName) {
		this.warn1FileName = warn1FileName;
		configProps.setProperty("Warn1FileName", this.warn1FileName);
	}
	public void setWarn2FileName(String warn2FileName) {
		this.warn2FileName = warn2FileName;
		configProps.setProperty("Warn2FileName", this.warn2FileName);
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
	public String getDefaultTeam1FileName() {return defaultProps.getProperty("Team1FileName");}
	public String getDefaultTournamentFileName() {return defaultProps.getProperty("TournamentFileName");}
	public String getDefaultTeam2FileName() {return defaultProps.getProperty("Team2FileName");}
	public String getDefaultEventFileName() {return defaultProps.getProperty("EventFileName");}
	public String getDefaultGameCount1FileName() {return defaultProps.getProperty("GameCount1FileName");}
	public String getDefaultTimeRemainingFileName() {return defaultProps.getProperty("TimeRemainingFileName");}
	public String getDefaultGameCount2FileName() {return defaultProps.getProperty("GameCount2FileName");}
	public String getDefaultTimerFileName() {return defaultProps.getProperty("TimerFileName");}
	public String getDefaultScore1FileName() {return defaultProps.getProperty("Score1FileName");}
	public String getDefaultMatchWinnerFileName() {return defaultProps.getProperty("MatchWinnerFileName");}
	public String getDefaultScore2FileName() {return defaultProps.getProperty("Score2FileName");}
	public String getDefaultTimeOut1FileName() {return defaultProps.getProperty("TimeOut1FileName");}
	public String getDefaultTimeOut2FileName() {return defaultProps.getProperty("TimeOut2FileName");}
	public String getDefaultReset1FileName() {return defaultProps.getProperty("Reset1FileName");}
	public String getDefaultReset2FileName() {return defaultProps.getProperty("Reset2FileName");}
	public String getDefaultWarn1FileName() {return defaultProps.getProperty("Warn1FileName");}
	public String getDefaultWarn2FileName() {return defaultProps.getProperty("Warn2FileName");}
	
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
		team1FileName = configProps.getProperty("Team1FileName");
		tournamentFileName = configProps.getProperty("TournamentFileName");
		team2FileName = configProps.getProperty("Team2FileName");
		eventFileName = configProps.getProperty("EventFileName");
		gameCount1FileName = configProps.getProperty("GameCount1FileName");
		timeRemainingFileName = configProps.getProperty("TimeRemainingFileName");
		gameCount2FileName = configProps.getProperty("GameCount2FileName");
		timerFileName = configProps.getProperty("TimerFileName");
		score1FileName = configProps.getProperty("Score1FileName");
		matchWinnerFileName = configProps.getProperty("MatchWinnerFileName");
		score2FileName = configProps.getProperty("Score2FileName");
		timeOut1FileName = configProps.getProperty("TimeOut1FileName");
		timeOut2FileName = configProps.getProperty("TimeOut2FileName");
		reset1FileName = configProps.getProperty("Reset1FileName");
		reset2FileName = configProps.getProperty("Reset2FileName");
		warn1FileName = configProps.getProperty("Warn1FileName");
		warn2FileName = configProps.getProperty("Warn2FileName");
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
		configProps.setProperty("Team1FileName", this.getTeam1FileName());
		configProps.setProperty("TournamentFileName", this.getTournamentFileName());
		configProps.setProperty("Team2FileName", this.getTeam2FileName());
		configProps.setProperty("EventFileName", this.getEventFileName());
		configProps.setProperty("GameCount1FileName", this.getGameCount1FileName());
		configProps.setProperty("TimeRemainingFileName", this.getTimeRemainingFileName());
		configProps.setProperty("GameCount2FileName", this.getGameCount2FileName());
		configProps.setProperty("TimerFileName", this.getTimerFileName());
		configProps.setProperty("Score1FileName", this.getScore1FileName());
		configProps.setProperty("MatchWinnerFileName", this.getMatchWinnerFileName());
		configProps.setProperty("Score2FileName", this.getScore2FileName());
		configProps.setProperty("TimeOut1FileName", this.getTimeOut1FileName());
		configProps.setProperty("TimeOut2FileName", this.getTimeOut2FileName());
		configProps.setProperty("Reset1FileName", this.getReset1FileName());
		configProps.setProperty("Reset2FileName", this.getReset2FileName());
		configProps.setProperty("Warn1FileName", this.getWarn1FileName());
		configProps.setProperty("Warn2FileName", this.getWarn2FileName());

		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB settings");
		outputStream.close();
	}
}
