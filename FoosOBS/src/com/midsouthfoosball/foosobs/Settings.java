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
	private String logoImageURL;
	private String logoLinkURI;

	private String team1FileName;
	private String tournamentFileName;
	private String team2FileName;
	private String eventFileName;
	private String gameCount1FileName;
	private String timeRemainingFileName;
	private String gameCount2FileName;
	private String timerInUseFileName;
	private String score1FileName;
	private String matchWinnerFileName;
	private String meatballFileName;
	private String score2FileName;
	private String timeOut1FileName;
	private String timeOut2FileName;
	private String reset1FileName;
	private String reset2FileName;
	private String warn1FileName;
	private String warn2FileName;
	private String lastScoredFileName;

	private String tournamentNameClearHotKey;
	private String eventClearHotKey;
	private String team1ClearHotKey;
	private String team1NameSwitchHotKey;
	private String team2ClearHotKey;
	private String team2NameSwitchHotKey;
	private String teamSwitchHotKey;
	private String gameCount1MinusHotKey;
	private String gameCount1PlusHotKey;
	private String gameCount2MinusHotKey;
	private String gameCount2PlusHotKey;
	private String gameCountSwitchHotKey;
	private String score1MinusHotKey;
	private String score1PlusHotKey;
	private String score2MinusHotKey;
	private String score2PlusHotKey;
	private String scoreSwitchHotKey;
	private String timeOut1MinusHotKey;
	private String timeOut1PlusHotKey;
	private String timeOut2MinusHotKey;
	private String timeOut2PlusHotKey;
	private String timeOutSwitchHotKey;
	private String reset1HotKey;
	private String reset2HotKey;
	private String warn1HotKey;
	private String warn2HotKey;
	private String resetSwitchHotKey;
	private String allSwitchHotKey;
	private String resetGameCountsHotKey;
	private String resetScoresHotKey;
	private String resetTimeOutsHotKey;
	private String resetResetWarnHotKey;
	private String resetAllHotKey;
	private String clearAllHotKey;
	private String shotTimerHotKey;
	private String passTimerHotKey;
	private String timeOutTimerHotKey;
	private String gameTimerHotKey;
	private String recallTimerHotKey;
	private String resetTimersHotKey;
	private String selectPathHotKey;
	private String setPathHotKey;
	private String fetchDataHotKey;
	private String saveAllHotKey;
	private String settingsHotKey;
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
		defaultProps.setProperty("LogoImageURL", "/imgs/MidsouthFoosballLogo4.png");
		defaultProps.setProperty("LogoLinkURI", "https://www.facebook.com/midsouthfoosball");

		defaultProps.setProperty("Team1FileName", "team1.txt");
		defaultProps.setProperty("TournamentFileName", "tournament.txt");
		defaultProps.setProperty("Team2FileName", "team2.txt");
		defaultProps.setProperty("EventFileName", "event.txt");
		defaultProps.setProperty("GameCount1FileName", "gamecount1.txt");
		defaultProps.setProperty("TimeRemainingFileName", "timeremaining.txt");
		defaultProps.setProperty("GameCount2FileName", "gamecount2.txt");
		defaultProps.setProperty("TimerInUseFileName", "timerinuse.txt");
		defaultProps.setProperty("Score1FileName", "score1.txt");
		defaultProps.setProperty("MatchWinnerFileName", "matchwinner.txt");
		defaultProps.setProperty("MeatballFileName",  "meatball.txt");
		defaultProps.setProperty("Score2FileName", "score2.txt");
		defaultProps.setProperty("TimeOut1FileName", "timeout1.txt");
		defaultProps.setProperty("TimeOut2FileName", "timeout2.txt");
		defaultProps.setProperty("Reset1FileName", "reset1.txt");
		defaultProps.setProperty("Reset2FileName", "reset2.txt");
		defaultProps.setProperty("Warn1FileName", "warn1.txt");
		defaultProps.setProperty("Warn2FileName", "warn2.txt");
		defaultProps.setProperty("LastScoredFileName","lastscored.txt");
		
		defaultProps.setProperty("TournamentNameClearHotKey", "");
		defaultProps.setProperty("EventClearHotKey", "");
		defaultProps.setProperty("Team1ClearHotKey", "");
		defaultProps.setProperty("Team1NameSwitchHotKey", "t");
		defaultProps.setProperty("Team2ClearHotKey", "");
		defaultProps.setProperty("Team2NameSwitchHotKey", "m");
		defaultProps.setProperty("TeamSwitchHotKey", "e");
		defaultProps.setProperty("GameCount1MinusHotKey", "");
		defaultProps.setProperty("GameCount1PlusHotKey", "5");
		defaultProps.setProperty("GameCount2MinusHotKey", "");
		defaultProps.setProperty("GameCount2PlusHotKey", "6");
		defaultProps.setProperty("GameCountSwitchHotKey", "");
		defaultProps.setProperty("Score1MinusHotKey", "");
		defaultProps.setProperty("Score1PlusHotKey", "1");
		defaultProps.setProperty("Score2MinusHotKey", "");
		defaultProps.setProperty("Score2PlusHotKey", "2");
		defaultProps.setProperty("ScoreSwitchHotKey", "");
		defaultProps.setProperty("TimeOut1MinusHotKey", "");
		defaultProps.setProperty("TimeOut1PlusHotKey", "9");
		defaultProps.setProperty("TimeOut2MinusHotKey", "");
		defaultProps.setProperty("TimeOut2PlusHotKey", "0");
		defaultProps.setProperty("TimeOutSwitchHotKey", "");
		defaultProps.setProperty("Reset1HotKey", "z");
		defaultProps.setProperty("Reset2HotKey", ",");
		defaultProps.setProperty("Warn1HotKey", "x");
		defaultProps.setProperty("Warn2HotKey", ".");
		defaultProps.setProperty("ResetSwitchHotKey", "");
		defaultProps.setProperty("AllSwitchHotKey", "w");
		defaultProps.setProperty("ResetGameCountsHotKey", "7");
		defaultProps.setProperty("ResetScoresHotKey", "3");
		defaultProps.setProperty("ResetTimeOutsHotKey", "-");
		defaultProps.setProperty("ResetResetWarnHotKey", "");
		defaultProps.setProperty("ResetAllHotKey", "a");
		defaultProps.setProperty("ClearAllHotKey", "");
		defaultProps.setProperty("ShotTimerHotKey", "s");
		defaultProps.setProperty("PassTimerHotKey", "p");
		defaultProps.setProperty("TimeOutTimerHotKey", "o");
		defaultProps.setProperty("GameTimerHotKey", "g");
		defaultProps.setProperty("RecallTimerHotKey", "c");
		defaultProps.setProperty("ResetTimersHotKey", "r");
		defaultProps.setProperty("SelectPathHotKey", "");
		defaultProps.setProperty("SetPathHotKey", "");
		defaultProps.setProperty("FetchDataHotKey", "");
		defaultProps.setProperty("SaveAllHotKey", "");
		defaultProps.setProperty("SettingsHotKey", "");

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
	public String getLogoImageURL() {return logoImageURL;}
	public String getLogoLinkURI() {return logoLinkURI;}

	public String getTeam1FileName() {return team1FileName;}
	public String getTournamentFileName() {return tournamentFileName;}
	public String getTeam2FileName() {return team2FileName;}
	public String getEventFileName() {return eventFileName;}
	public String getGameCount1FileName() {return gameCount1FileName;}
	public String getTimeRemainingFileName() {return timeRemainingFileName;}
	public String getGameCount2FileName() {return gameCount2FileName;}
	public String getTimerInUseFileName() {return timerInUseFileName;}
	public String getScore1FileName() {return score1FileName;}
	public String getMatchWinnerFileName() {return matchWinnerFileName;}
	public String getMeatballFileName() {return meatballFileName;}
	public String getScore2FileName() {return score2FileName;}
	public String getTimeOut1FileName() {return timeOut1FileName;}
	public String getTimeOut2FileName() {return timeOut2FileName;}
	public String getReset1FileName() {return reset1FileName;}
	public String getReset2FileName() {return reset2FileName;}
	public String getWarn1FileName() {return warn1FileName;}
	public String getWarn2FileName() {return warn2FileName;}
	public String getLastScoredFileName() {return lastScoredFileName;}

	public String getTournamentNameClearHotKey() {return tournamentNameClearHotKey;}
	public String getEventClearHotKey() {return eventClearHotKey;}
	public String getTeam1ClearHotKey() {return team1ClearHotKey;}
	public String getTeam1NameSwitchHotKey() {return team1NameSwitchHotKey;}
	public String getTeam2ClearHotKey() {return team2ClearHotKey;}
	public String getTeam2NameSwitchHotKey() {return team2NameSwitchHotKey;}
	public String getTeamSwitchHotKey() {return teamSwitchHotKey;}
	public String getGameCount1MinusHotKey() {return gameCount1MinusHotKey;}
	public String getGameCount1PlusHotKey() {return gameCount1PlusHotKey;}
	public String getGameCount2MinusHotKey() {return gameCount2MinusHotKey;}
	public String getGameCount2PlusHotKey() {return gameCount2PlusHotKey;}
	public String getGameCountSwitchHotKey() {return gameCountSwitchHotKey;}
	public String getScore1MinusHotKey() {return score1MinusHotKey;}
	public String getScore1PlusHotKey() {return score1PlusHotKey;}
	public String getScore2MinusHotKey() {return score2MinusHotKey;}
	public String getScore2PlusHotKey() {return score2PlusHotKey;}
	public String getScoreSwitchHotKey() {return scoreSwitchHotKey;}
	public String getTimeOut1MinusHotKey() {return timeOut1MinusHotKey;}
	public String getTimeOut1PlusHotKey() {return timeOut1PlusHotKey;}
	public String getTimeOut2MinusHotKey() {return timeOut2MinusHotKey;}
	public String getTimeOut2PlusHotKey() {return timeOut2PlusHotKey;}
	public String getTimeOutSwitchHotKey() {return timeOutSwitchHotKey;}
	public String getReset1HotKey() {return reset1HotKey;}
	public String getReset2HotKey() {return reset2HotKey;}
	public String getWarn1HotKey() {return warn1HotKey;}
	public String getWarn2HotKey() {return warn2HotKey;}
	public String getResetSwitchHotKey() {return resetSwitchHotKey;}
	public String getAllSwitchHotKey() {return allSwitchHotKey;}
	public String getResetGameCountsHotKey() {return resetGameCountsHotKey;}
	public String getResetScoresHotKey() {return resetScoresHotKey;}
	public String getResetTimeOutsHotKey() {return resetTimeOutsHotKey;}
	public String getResetResetWarnHotKey() {return resetResetWarnHotKey;}
	public String getResetAllHotKey() {return resetAllHotKey;}
	public String getClearAllHotKey() {return clearAllHotKey;}
	public String getShotTimerHotKey() {return shotTimerHotKey;}
	public String getPassTimerHotKey() {return passTimerHotKey;}
	public String getTimeOutTimerHotKey() {return timeOutTimerHotKey;}
	public String getGameTimerHotKey() {return gameTimerHotKey;}
	public String getRecallTimerHotKey() {return recallTimerHotKey;}
	public String getResetTimersHotKey() {return resetTimersHotKey;}
	public String getSelectPathHotKey() {return selectPathHotKey;}
	public String getSetPathHotKey() {return setPathHotKey;}
	public String getFetchDataHotKey() {return fetchDataHotKey;}
	public String getSaveAllHotKey() {return saveAllHotKey;}
	public String getSettingsHotKey() {return settingsHotKey;}
	
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
	public void setLogoImageURL(String logoImageURL) {
		this.logoImageURL = logoImageURL;
		configProps.setProperty("LogoImageURL", this.logoImageURL);
	}
	public void setLogoLinkURI(String logoLinkURI) {
		this.logoLinkURI = logoLinkURI;
		configProps.setProperty("LogoLinkURI", this.logoLinkURI);
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
	public void setTimerInUseFileName(String timerInUseFileName) {
		this.timerInUseFileName = timerInUseFileName;
		configProps.setProperty("TimerInUseFileName", this.timerInUseFileName);
	}
	public void setScore1FileName(String score1FileName) {
		this.score1FileName = score1FileName;
		configProps.setProperty("Score1FileName", this.score1FileName);
	}
	public void setMatchWinnerFileName(String matchWinnerFileName) {
		this.matchWinnerFileName = matchWinnerFileName;
		configProps.setProperty("MatchWinnerFileName", this.matchWinnerFileName);
	}
	public void setMeatballFileName(String meatballFileName) {
		this.meatballFileName = meatballFileName;
		configProps.setProperty("MeatballFileName", this.meatballFileName);
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
	public void setLastScoredFileName(String lastScoredFileName) {
		this.lastScoredFileName = lastScoredFileName;
		configProps.setProperty("LastScoredFileName", this.lastScoredFileName);
	}
	
	public void setTournamentNameClearHotKey(String tournamentNameClearHotKey) {
		this.tournamentNameClearHotKey = tournamentNameClearHotKey;
		configProps.setProperty("TournamentNameClearHotKey", this.tournamentNameClearHotKey);
	}
	public void setEventClearHotKey(String eventClearHotKey) {
		this.eventClearHotKey = eventClearHotKey;
		configProps.setProperty("EventClearHotKey", this.eventClearHotKey);
	}
	public void setTeam1ClearHotKey(String team1ClearHotKey) {
		this.team1ClearHotKey = team1ClearHotKey;
		configProps.setProperty("Team1ClearHotKey", this.team1ClearHotKey);
	}
	public void setTeam1NameSwitchHotKey(String team1NameSwitchHotKey) {
		this.team1NameSwitchHotKey = team1NameSwitchHotKey;
		configProps.setProperty("Team1NameSwitchHotKey", this.team1NameSwitchHotKey);
	}
	public void setTeam2ClearHotKey(String team2ClearHotKey) {
		this.team2ClearHotKey = team2ClearHotKey;
		configProps.setProperty("Team2ClearHotKey", this.team2ClearHotKey);
	}
	public void setTeam2NameSwitchHotKey(String team2NameSwitchHotKey) {
		this.team2NameSwitchHotKey = team2NameSwitchHotKey;
		configProps.setProperty("Team2NameSwitchHotKey", this.team2NameSwitchHotKey);
	}
	public void setTeamSwitchHotKey(String teamSwitchHotKey) {
		this.teamSwitchHotKey = teamSwitchHotKey;
		configProps.setProperty("TeamSwitchHotKey", this.teamSwitchHotKey);
	}
	public void setGameCount1MinusHotKey(String gameCount1MinusHotKey) {
		this.gameCount1MinusHotKey = gameCount1MinusHotKey;
		configProps.setProperty("GameCount1MinusHotKey", this.gameCount1MinusHotKey);
	}
	public void setGameCount1PlusHotKey(String gameCount1PlusHotKey) {
		this.gameCount1PlusHotKey = gameCount1PlusHotKey;
		configProps.setProperty("GameCount1PlusHotKey", this.gameCount1PlusHotKey);
	}
	public void setGameCount2MinusHotKey(String gameCount2MinusHotKey) {
		this.gameCount2MinusHotKey = gameCount2MinusHotKey;
		configProps.setProperty("GameCount2MinusHotKey", this.gameCount2MinusHotKey);
	}
	public void setGameCount2PlusHotKey(String gameCount2PlusHotKey) {
		this.gameCount2PlusHotKey = gameCount2PlusHotKey;
		configProps.setProperty("GameCount2PlusHotKey", this.gameCount2PlusHotKey);
	}
	public void setGameCountSwitchHotKey(String gameCountSwitchHotKey) {
		this.gameCountSwitchHotKey = gameCountSwitchHotKey;
		configProps.setProperty("GameCountSwitchHotKey", this.gameCountSwitchHotKey);
	}
	public void setScore1MinusHotKey(String score1MinusHotKey) {
		this.score1MinusHotKey = score1MinusHotKey;
		configProps.setProperty("Score1MinusHotKey", this.score1MinusHotKey);
	}
	public void setScore1PlusHotKey(String score1PlusHotKey) {
		this.score1PlusHotKey = score1PlusHotKey;
		configProps.setProperty("Score1PlusHotKey", this.score1PlusHotKey);
	}
	public void setScore2MinusHotKey(String score2MinusHotKey) {
		this.score2MinusHotKey = score2MinusHotKey;
		configProps.setProperty("Score2MinusHotKey", this.score2MinusHotKey);
	}
	public void setScore2PlusHotKey(String score2PlusHotKey) {
		this.score2PlusHotKey = score2PlusHotKey;
		configProps.setProperty("Score2PlusHotKey", this.score2PlusHotKey);
	}
	public void setScoreSwitchHotKey(String scoreSwitchHotKey) {
		this.scoreSwitchHotKey = scoreSwitchHotKey;
		configProps.setProperty("ScoreSwitchHotKey", this.scoreSwitchHotKey);
	}
	public void setTimeOut1MinusHotKey(String timeOut1MinusHotKey) {
		this.timeOut1MinusHotKey = timeOut1MinusHotKey;
		configProps.setProperty("TimeOut1MinusHotKey", this.timeOut1MinusHotKey);
	}
	public void setTimeOut1PlusHotKey(String timeOut1PlusHotKey) {
		this.timeOut1PlusHotKey = timeOut1PlusHotKey;
		configProps.setProperty("TimeOut1PlusHotKey", this.timeOut1PlusHotKey);
	}
	public void setTimeOut2MinusHotKey(String timeOut2MinusHotKey) {
		this.timeOut2MinusHotKey = timeOut2MinusHotKey;
		configProps.setProperty("TimeOut2MinusHotKey", this.timeOut2MinusHotKey);
	}
	public void setTimeOut2PlusHotKey(String timeOut2PlusHotKey) {
		this.timeOut2PlusHotKey = timeOut2PlusHotKey;
		configProps.setProperty("TimeOut2PlusHotKey", this.timeOut2PlusHotKey);
	}
	public void setTimeOutSwitchHotKey(String timeOutSwitchHotKey) {
		this.timeOutSwitchHotKey = timeOutSwitchHotKey;
		configProps.setProperty("TimeOutSwitchHotKey", this.timeOutSwitchHotKey);
	}
	public void setReset1HotKey(String reset1HotKey) {
		this.reset1HotKey = reset1HotKey;
		configProps.setProperty("Reset1HotKey", this.reset1HotKey);
	}
	public void setReset2HotKey(String reset2HotKey) {
		this.reset2HotKey = reset2HotKey;
		configProps.setProperty("Reset2HotKey", this.reset2HotKey);
	}
	public void setWarn1HotKey(String warn1HotKey) {
		this.warn1HotKey = warn1HotKey;
		configProps.setProperty("Warn1HotKey", this.warn1HotKey);
	}
	public void setWarn2HotKey(String warn2HotKey) {
		this.warn2HotKey = warn2HotKey;
		configProps.setProperty("Warn2HotKey", this.warn2HotKey);
	}
	public void setResetSwitchHotKey(String resetSwitchHotKey) {
		this.resetSwitchHotKey = resetSwitchHotKey;
		configProps.setProperty("ResetSwitchHotKey", this.resetSwitchHotKey);
	}
	public void setAllSwitchHotKey(String allSwitchHotKey) {
		this.allSwitchHotKey = allSwitchHotKey;
		configProps.setProperty("AllSwitchHotKey", this.allSwitchHotKey);
	}
	public void setResetGameCountsHotKey(String resetGameCountsHotKey) {
		this.resetGameCountsHotKey = resetGameCountsHotKey;
		configProps.setProperty("ResetGameCountsHotKey", this.resetGameCountsHotKey);
	}
	public void setResetScoresHotKey(String resetScoresHotKey) {
		this.resetScoresHotKey = resetScoresHotKey;
		configProps.setProperty("ResetScoresHotKey", this.resetScoresHotKey);
	}
	public void setResetTimeOutsHotKey(String resetTimeOutsHotKey) {
		this.resetTimeOutsHotKey = resetTimeOutsHotKey;
		configProps.setProperty("ResetTimeOutsHotKey", this.resetTimeOutsHotKey);
	}
	public void setResetResetWarnHotKey(String resetResetWarnHotKey) {
		this.resetResetWarnHotKey = resetResetWarnHotKey;
		configProps.setProperty("ResetResetWarnHotKey", this.resetResetWarnHotKey);
	}
	public void setResetAllHotKey(String resetAllHotKey) {
		this.resetAllHotKey = resetAllHotKey;
		configProps.setProperty("ResetAllHotKey", this.resetAllHotKey);
	}
	public void setClearAllHotKey(String clearAllHotKey) {
		this.clearAllHotKey = clearAllHotKey;
		configProps.setProperty("ClearAllHotKey", this.clearAllHotKey);
	}
	public void setShotTimerHotKey(String shotTimerHotKey) {
		this.shotTimerHotKey = shotTimerHotKey;
		configProps.setProperty("ShotTimerHotKey", this.shotTimerHotKey);
	}
	public void setPassTimerHotKey(String passTimerHotKey) {
		this.passTimerHotKey = passTimerHotKey;
		configProps.setProperty("PassTimerHotKey", this.passTimerHotKey);
	}
	public void setTimeOutTimerHotKey(String timeOutTimerHotKey) {
		this.timeOutTimerHotKey = timeOutTimerHotKey;
		configProps.setProperty("TimeOutTimerHotKey", this.timeOutTimerHotKey);
	}
	public void setGameTimerHotKey(String gameTimerHotKey) {
		this.gameTimerHotKey = gameTimerHotKey;
		configProps.setProperty("GameTimerHotKey", this.gameTimerHotKey);
	}
	public void setRecallTimerHotKey(String recallTimerHotKey) {
		this.recallTimerHotKey = recallTimerHotKey;
		configProps.setProperty("RecallTimerHotKey", this.recallTimerHotKey);
	}
	public void setResetTimersHotKey(String resetTimersHotKey) {
		this.resetTimersHotKey = resetTimersHotKey;
		configProps.setProperty("ResetTimersHotKey", this.resetTimersHotKey);
	}
	public void setSelectPathHotKey(String selectPathHotKey) {
		this.selectPathHotKey = selectPathHotKey;
		configProps.setProperty("SelectPathHotKey", this.selectPathHotKey);
	}
	public void setSetPathHotKey(String setPathHotKey) {
		this.setPathHotKey = setPathHotKey;
		configProps.setProperty("SetPathHotKey", this.setPathHotKey);
	}
	public void setFetchDataHotKey(String fetchDataHotKey) {
		this.fetchDataHotKey = fetchDataHotKey;
		configProps.setProperty("FetchDataHotKey", this.fetchDataHotKey);
	}
	public void setSaveAllHotKey(String saveAllHotKey) {
		this.saveAllHotKey = saveAllHotKey;
		configProps.setProperty("SaveAllHotKey", this.saveAllHotKey);
	}
	public void setSettingsHotKey(String settingsHotKey) {
		this.settingsHotKey = settingsHotKey;
		configProps.setProperty("SettingsHotKey", this.settingsHotKey);
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
	public String getDefaultLogoImageURL() {return defaultProps.getProperty("LogoImageURL");}
	public String getDefaultLogoLinkURI() {return defaultProps.getProperty("LogoLinkURI");}
	
	public String getDefaultTeam1FileName() {return defaultProps.getProperty("Team1FileName");}
	public String getDefaultTournamentFileName() {return defaultProps.getProperty("TournamentFileName");}
	public String getDefaultTeam2FileName() {return defaultProps.getProperty("Team2FileName");}
	public String getDefaultEventFileName() {return defaultProps.getProperty("EventFileName");}
	public String getDefaultGameCount1FileName() {return defaultProps.getProperty("GameCount1FileName");}
	public String getDefaultTimeRemainingFileName() {return defaultProps.getProperty("TimeRemainingFileName");}
	public String getDefaultGameCount2FileName() {return defaultProps.getProperty("GameCount2FileName");}
	public String getDefaultTimerInUseFileName() {return defaultProps.getProperty("TimerInUseFileName");}
	public String getDefaultScore1FileName() {return defaultProps.getProperty("Score1FileName");}
	public String getDefaultMatchWinnerFileName() {return defaultProps.getProperty("MatchWinnerFileName");}
	public String getDefaultMeatballFileName() {return defaultProps.getProperty("MeatballFileName");}
	public String getDefaultScore2FileName() {return defaultProps.getProperty("Score2FileName");}
	public String getDefaultTimeOut1FileName() {return defaultProps.getProperty("TimeOut1FileName");}
	public String getDefaultTimeOut2FileName() {return defaultProps.getProperty("TimeOut2FileName");}
	public String getDefaultReset1FileName() {return defaultProps.getProperty("Reset1FileName");}
	public String getDefaultReset2FileName() {return defaultProps.getProperty("Reset2FileName");}
	public String getDefaultWarn1FileName() {return defaultProps.getProperty("Warn1FileName");}
	public String getDefaultWarn2FileName() {return defaultProps.getProperty("Warn2FileName");}
	public String getDefaultLastScoredFileName() {return defaultProps.getProperty("LastScoredFileName");}

	public String getDefaultTournamentNameClearHotKey() {return defaultProps.getProperty("TournamentNameClearHotKey");}
	public String getDefaultEventClearHotKey() {return defaultProps.getProperty("EventClearHotKey");}
	public String getDefaultTeam1ClearHotKey() {return defaultProps.getProperty("Team1ClearHotKey");}
	public String getDefaultTeam1NameSwitchHotKey() {return defaultProps.getProperty("Team1NameSwitchHotKey");}
	public String getDefaultTeam2ClearHotKey() {return defaultProps.getProperty("Team2ClearHotKey");}
	public String getDefaultTeam2NameSwitchHotKey() {return defaultProps.getProperty("Team2NameSwitchHotKey");}
	public String getDefaultTeamSwitchHotKey() {return defaultProps.getProperty("TeamSwitchHotKey");}
	public String getDefaultGameCount1MinusHotKey() {return defaultProps.getProperty("GameCount1MinusHotKey");}
	public String getDefaultGameCount1PlusHotKey() {return defaultProps.getProperty("GameCount1PlusHotKey");}
	public String getDefaultGameCount2MinusHotKey() {return defaultProps.getProperty("GameCount2MinusHotKey");}
	public String getDefaultGameCount2PlusHotKey() {return defaultProps.getProperty("GameCount2PlusHotKey");}
	public String getDefaultGameCountSwitchHotKey() {return defaultProps.getProperty("GameCountSwitchHotKey");}
	public String getDefaultScore1MinusHotKey() {return defaultProps.getProperty("Score1MinusHotKey");}
	public String getDefaultScore1PlusHotKey() {return defaultProps.getProperty("Score1PlusHotKey");}
	public String getDefaultScore2MinusHotKey() {return defaultProps.getProperty("Score2MinusHotKey");}
	public String getDefaultScore2PlusHotKey() {return defaultProps.getProperty("Score2PlusHotKey");}
	public String getDefaultScoreSwitchHotKey() {return defaultProps.getProperty("ScoreSwitchHotKey");}
	public String getDefaultTimeOut1MinusHotKey() {return defaultProps.getProperty("TimeOut1MinusHotKey");}
	public String getDefaultTimeOut1PlusHotKey() {return defaultProps.getProperty("TimeOut1PlusHotKey");}
	public String getDefaultTimeOut2MinusHotKey() {return defaultProps.getProperty("TimeOut2MinusHotKey");}
	public String getDefaultTimeOut2PlusHotKey() {return defaultProps.getProperty("TimeOut2PlusHotKey");}
	public String getDefaultTimeOutSwitchHotKey() {return defaultProps.getProperty("TimeOutSwitchHotKey");}
	public String getDefaultReset1HotKey() {return defaultProps.getProperty("Reset1HotKey");}
	public String getDefaultReset2HotKey() {return defaultProps.getProperty("Reset2HotKey");}
	public String getDefaultWarn1HotKey() {return defaultProps.getProperty("Warn1HotKey");}
	public String getDefaultWarn2HotKey() {return defaultProps.getProperty("Warn2HotKey");}
	public String getDefaultResetSwitchHotKey() {return defaultProps.getProperty("ResetSwitchHotKey");}
	public String getDefaultAllSwitchHotKey() {return defaultProps.getProperty("AllSwitchHotKey");}
	public String getDefaultResetGameCountsHotKey() {return defaultProps.getProperty("ResetGameCountsHotKey");}
	public String getDefaultResetScoresHotKey() {return defaultProps.getProperty("ResetScoresHotKey");}
	public String getDefaultResetTimeOutsHotKey() {return defaultProps.getProperty("ResetTimeOutsHotKey");}
	public String getDefaultResetResetWarnHotKey() {return defaultProps.getProperty("ResetResetWarnHotKey");}
	public String getDefaultResetAllHotKey() {return defaultProps.getProperty("ResetAllHotKey");}
	public String getDefaultClearAllHotKey() {return defaultProps.getProperty("ClearAllHotKey");}
	public String getDefaultShotTimerHotKey() {return defaultProps.getProperty("ShotTimerHotKey");}
	public String getDefaultPassTimerHotKey() {return defaultProps.getProperty("PassTimerHotKey");}
	public String getDefaultTimeOutTimerHotKey() {return defaultProps.getProperty("TimeOutTimerHotKey");}
	public String getDefaultGameTimerHotKey() {return defaultProps.getProperty("GameTimerHotKey");}
	public String getDefaultRecallTimerHotKey() {return defaultProps.getProperty("RecallTimerHotKey");}
	public String getDefaultResetTimersHotKey() {return defaultProps.getProperty("ResetTimersHotKey");}
	public String getDefaultSelectPathHotKey() {return defaultProps.getProperty("SelectPathHotKey");}
	public String getDefaultSetPathHotKey() {return defaultProps.getProperty("SetPathHotKey");}
	public String getDefaultFetchDataHotKey() {return defaultProps.getProperty("FetchDataHotKey");}
	public String getDefaultSaveAllHotKey() {return defaultProps.getProperty("SaveAllHotKey");}
	public String getDefaultSettingsHotKey() {return defaultProps.getProperty("SettingsHotKey");}
	
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
		logoImageURL = configProps.getProperty("LogoImageURL");
		if (logoImageURL.isEmpty()) {
			logoImageURL = this.getDefaultLogoImageURL();
		};
		logoLinkURI = configProps.getProperty("LogoLinkURI");
		if (logoLinkURI.isEmpty()) {
			logoLinkURI = this.getDefaultLogoLinkURI();
		};

		team1FileName = configProps.getProperty("Team1FileName");
		tournamentFileName = configProps.getProperty("TournamentFileName");
		team2FileName = configProps.getProperty("Team2FileName");
		eventFileName = configProps.getProperty("EventFileName");
		gameCount1FileName = configProps.getProperty("GameCount1FileName");
		timeRemainingFileName = configProps.getProperty("TimeRemainingFileName");
		gameCount2FileName = configProps.getProperty("GameCount2FileName");
		timerInUseFileName = configProps.getProperty("TimerInUseFileName");
		score1FileName = configProps.getProperty("Score1FileName");
		matchWinnerFileName = configProps.getProperty("MatchWinnerFileName");
		meatballFileName = configProps.getProperty("MeatballFileName");
		score2FileName = configProps.getProperty("Score2FileName");
		timeOut1FileName = configProps.getProperty("TimeOut1FileName");
		timeOut2FileName = configProps.getProperty("TimeOut2FileName");
		reset1FileName = configProps.getProperty("Reset1FileName");
		reset2FileName = configProps.getProperty("Reset2FileName");
		warn1FileName = configProps.getProperty("Warn1FileName");
		warn2FileName = configProps.getProperty("Warn2FileName");
		lastScoredFileName = configProps.getProperty("LastScoredFileName");
		
		tournamentNameClearHotKey = configProps.getProperty("TournamentNameClearHotKey");
		eventClearHotKey = configProps.getProperty("EventClearHotKey");
		team1ClearHotKey = configProps.getProperty("Team1ClearHotKey");
		team1NameSwitchHotKey = configProps.getProperty("Team1NameSwitchHotKey");
		team2ClearHotKey = configProps.getProperty("Team2ClearHotKey");
		team2NameSwitchHotKey = configProps.getProperty("Team2NameSwitchHotKey");
		teamSwitchHotKey = configProps.getProperty("TeamSwitchHotKey");
		gameCount1MinusHotKey = configProps.getProperty("GameCount1MinusHotKey");
		gameCount1PlusHotKey = configProps.getProperty("GameCount1PlusHotKey");
		gameCount2MinusHotKey = configProps.getProperty("GameCount2MinusHotKey");
		gameCount2PlusHotKey = configProps.getProperty("GameCount2PlusHotKey");
		gameCountSwitchHotKey = configProps.getProperty("GameCountSwitchHotKey");
		score1MinusHotKey = configProps.getProperty("Score1MinusHotKey");
		score1PlusHotKey = configProps.getProperty("Score1PlusHotKey");
		score2MinusHotKey = configProps.getProperty("Score2MinusHotKey");
		score2PlusHotKey = configProps.getProperty("Score2PlusHotKey");
		scoreSwitchHotKey = configProps.getProperty("ScoreSwitchHotKey");
		timeOut1MinusHotKey = configProps.getProperty("TimeOut1MinusHotKey");
		timeOut1PlusHotKey = configProps.getProperty("TimeOut1PlusHotKey");
		timeOut2MinusHotKey = configProps.getProperty("TimeOut2MinusHotKey");
		timeOut2PlusHotKey = configProps.getProperty("TimeOut2PlusHotKey");
		timeOutSwitchHotKey = configProps.getProperty("TimeOutSwitchHotKey");
		reset1HotKey = configProps.getProperty("Reset1HotKey");
		reset2HotKey = configProps.getProperty("Reset2HotKey");
		warn1HotKey = configProps.getProperty("Warn1HotKey");
		warn2HotKey = configProps.getProperty("Warn2HotKey");
		resetSwitchHotKey = configProps.getProperty("ResetSwitchHotKey");
		allSwitchHotKey = configProps.getProperty("AllSwitchHotKey");
		resetGameCountsHotKey = configProps.getProperty("ResetGameCountsHotKey");
		resetScoresHotKey = configProps.getProperty("ResetScoresHotKey");
		resetTimeOutsHotKey = configProps.getProperty("ResetTimeOutsHotKey");
		resetResetWarnHotKey = configProps.getProperty("ResetResetWarnHotKey");
		resetAllHotKey = configProps.getProperty("ResetAllHotKey");
		clearAllHotKey = configProps.getProperty("ClearAllHotKey");
		shotTimerHotKey = configProps.getProperty("ShotTimerHotKey");
		passTimerHotKey = configProps.getProperty("PassTimerHotKey");
		timeOutTimerHotKey = configProps.getProperty("TimeOutTimerHotKey");
		gameTimerHotKey = configProps.getProperty("GameTimerHotKey");
		recallTimerHotKey = configProps.getProperty("RecallTimerHotKey");
		resetTimersHotKey = configProps.getProperty("ResetTimersHotKey");
		selectPathHotKey = configProps.getProperty("SelectPathHotKey");
		setPathHotKey = configProps.getProperty("SetPathHotKey");
		fetchDataHotKey = configProps.getProperty("FetchDataHotKey");
		saveAllHotKey = configProps.getProperty("SaveAllHotKey");
		settingsHotKey = configProps.getProperty("SettingsHotKey");
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
//		configProps.setProperty("LogoImageURL", this.getLogoImageURL());
//		configProps.setProperty("LogoLinkURI", this.getLogoLinkURI());

		configProps.setProperty("Team1FileName", this.getTeam1FileName());
		configProps.setProperty("TournamentFileName", this.getTournamentFileName());
		configProps.setProperty("Team2FileName", this.getTeam2FileName());
		configProps.setProperty("EventFileName", this.getEventFileName());
		configProps.setProperty("GameCount1FileName", this.getGameCount1FileName());
		configProps.setProperty("TimeRemainingFileName", this.getTimeRemainingFileName());
		configProps.setProperty("GameCount2FileName", this.getGameCount2FileName());
		configProps.setProperty("TimerInUseFileName", this.getTimerInUseFileName());
		configProps.setProperty("Score1FileName", this.getScore1FileName());
		configProps.setProperty("MatchWinnerFileName", this.getMatchWinnerFileName());
		configProps.setProperty("MeatballFileName", this.getMeatballFileName());
		configProps.setProperty("Score2FileName", this.getScore2FileName());
		configProps.setProperty("TimeOut1FileName", this.getTimeOut1FileName());
		configProps.setProperty("TimeOut2FileName", this.getTimeOut2FileName());
		configProps.setProperty("Reset1FileName", this.getReset1FileName());
		configProps.setProperty("Reset2FileName", this.getReset2FileName());
		configProps.setProperty("Warn1FileName", this.getWarn1FileName());
		configProps.setProperty("Warn2FileName", this.getWarn2FileName());
		configProps.setProperty("LastScoredFileName", this.getLastScoredFileName());

		configProps.setProperty("TournamentNameClearHotKey", this.getTournamentNameClearHotKey());
		configProps.setProperty("EventClearHotKey", this.getEventClearHotKey());
		configProps.setProperty("Team1ClearHotKey", this.getTeam1ClearHotKey());
		configProps.setProperty("Team1NameSwitchHotKey", this.getTeam1NameSwitchHotKey());
		configProps.setProperty("Team2ClearHotKey", this.getTeam2ClearHotKey());
		configProps.setProperty("Team2NameSwitchHotKey", this.getTeam2NameSwitchHotKey());
		configProps.setProperty("TeamSwitchHotKey", this.getTeamSwitchHotKey());
		configProps.setProperty("GameCount1MinusHotKey", this.getGameCount1MinusHotKey());
		configProps.setProperty("GameCount1PlusHotKey", this.getGameCount1PlusHotKey());
		configProps.setProperty("GameCount2MinusHotKey", this.getGameCount2MinusHotKey());
		configProps.setProperty("GameCount2PlusHotKey", this.getGameCount2PlusHotKey());
		configProps.setProperty("GameCountSwitchHotKey", this.getGameCountSwitchHotKey());
		configProps.setProperty("Score1MinusHotKey", this.getScore1MinusHotKey());
		configProps.setProperty("Score1PlusHotKey", this.getScore1PlusHotKey());
		configProps.setProperty("Score2MinusHotKey", this.getScore2MinusHotKey());
		configProps.setProperty("Score2PlusHotKey", this.getScore2PlusHotKey());
		configProps.setProperty("ScoreSwitchHotKey", this.getScoreSwitchHotKey());
		configProps.setProperty("TimeOut1MinusHotKey", this.getTimeOut1MinusHotKey());
		configProps.setProperty("TimeOut1PlusHotKey", this.getTimeOut1PlusHotKey());
		configProps.setProperty("TimeOut2MinusHotKey", this.getTimeOut2MinusHotKey());
		configProps.setProperty("TimeOut2PlusHotKey", this.getTimeOut2PlusHotKey());
		configProps.setProperty("TimeOutSwitchHotKey", this.getTimeOutSwitchHotKey());
		configProps.setProperty("Reset1HotKey", this.getReset1HotKey());
		configProps.setProperty("Reset2HotKey", this.getReset2HotKey());
		configProps.setProperty("Warn1HotKey", this.getWarn1HotKey());
		configProps.setProperty("Warn2HotKey", this.getWarn2HotKey());
		configProps.setProperty("ResetSwitchHotKey", this.getResetSwitchHotKey());
		configProps.setProperty("AllSwitchHotKey", this.getAllSwitchHotKey());
		configProps.setProperty("ResetGameCountsHotKey", this.getResetGameCountsHotKey());
		configProps.setProperty("ResetScoresHotKey", this.getResetScoresHotKey());
		configProps.setProperty("ResetTimeOutsHotKey", this.getResetTimeOutsHotKey());
		configProps.setProperty("ResetResetWarnHotKey", this.getResetResetWarnHotKey());
		configProps.setProperty("ResetAllHotKey", this.getResetAllHotKey());
		configProps.setProperty("ClearAllHotKey", this.getClearAllHotKey());
		configProps.setProperty("ShotTimerHotKey", this.getShotTimerHotKey());
		configProps.setProperty("PassTimerHotKey", this.getPassTimerHotKey());
		configProps.setProperty("TimeOutTimerHotKey", this.getTimeOutTimerHotKey());
		configProps.setProperty("GameTimerHotKey", this.getGameTimerHotKey());
		configProps.setProperty("RecallTimerHotKey", this.getRecallTimerHotKey());
		configProps.setProperty("ResetTimersHotKey", this.getResetTimersHotKey());
		configProps.setProperty("SelectPathHotKey", this.getSelectPathHotKey());
		configProps.setProperty("SetPathHotKey", this.getSetPathHotKey());
		configProps.setProperty("FetchDataHotKey", this.getFetchDataHotKey());
		configProps.setProperty("SaveAllHotKey", this.getSaveAllHotKey());
		configProps.setProperty("SettingsHotKey", this.getSettingsHotKey());

		OutputStream outputStream = new FileOutputStream(configFile);
		configProps.store(outputStream, "FoosOSB settings");
		outputStream.close();
	}
}
