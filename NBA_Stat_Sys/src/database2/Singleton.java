/**
 * puppy
 * Apr 26, 2015 7:12:47 PM
 * TODO
 */
package database2;

import java.util.ArrayList;

import po.GamePO;
import po.PlayerPO;
import po.SeasonTracker;
import po.TeamPO;

public class Singleton {

	private static Singleton instance;
	private String message;
	private ArrayList<GamePO> gameDB = new ArrayList<GamePO>();
	private ArrayList<PlayerPO> playerDB = new ArrayList<PlayerPO>();
	private ArrayList<TeamPO> teamDB = new ArrayList<TeamPO>();
	private SeasonTracker seasonTrackerDB = new SeasonTracker();
	
	
	private Singleton() {//private constructor
		message = "this is message";
		System.out.println("database initialized1");
	}
	
	public static Singleton getInstance() {//static method to get an instance
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<GamePO> getGameDB() {
		return gameDB;
	}

	public void setGameDB(ArrayList<GamePO> gameDB) {
		this.gameDB = gameDB;
	}

	public ArrayList<PlayerPO> getPlayerDB() {
		return playerDB;
	}

	public void setPlayerDB(ArrayList<PlayerPO> playerDB) {
		this.playerDB = playerDB;
	}

	public ArrayList<TeamPO> getTeamDB() {
		return teamDB;
	}

	public void setTeamDB(ArrayList<TeamPO> teamDB) {
		this.teamDB = teamDB;
	}

	public SeasonTracker getSeasonTrackerDB() {
		return seasonTrackerDB;
	}

	public void setSeasonTrackerDB(SeasonTracker seasonTrackerDB) {
		this.seasonTrackerDB = seasonTrackerDB;
	}
	
}
