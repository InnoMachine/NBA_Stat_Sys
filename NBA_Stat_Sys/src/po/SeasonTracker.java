/**
 * puppy
 * Apr 8, 2015 4:55:20 PM
 * TODO record the sequence of games in a certain season
 */
package po;

import java.util.ArrayList;

public class SeasonTracker {
	
	private ArrayList<GameDayPack> seasonRecord = new ArrayList<GameDayPack>();
	private GameDate currentDate;
	private String seasonId;
	private ArrayList<String> updateTeamList;
	private ArrayList<String> updatePlayerList;
	private int gameNumSofar;
	
	public GameDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(GameDate currentDate) {
		this.currentDate = currentDate;
	}

	public String toString() {//sudo
		return null;
	}
	
	public ArrayList<GameDayPack> getSeasonRecord() {
		return seasonRecord;
	}

	public void setSeasonRecord(ArrayList<GameDayPack> seasonRecord) {
		this.seasonRecord = seasonRecord;
	}

	public int getGameNumSofar() {
		return gameNumSofar;
	}

	public void setGameNumSofar(int gameNumSofar) {
		this.gameNumSofar = gameNumSofar;
	}

	public String getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(String seasonId) {
		this.seasonId = seasonId;
	}

	public ArrayList<String> getUpdateTeamList() {
		return updateTeamList;
	}

	public void setUpdateTeamList(ArrayList<String> updateTeamList) {
		this.updateTeamList = updateTeamList;
	}

	public ArrayList<String> getUpdatePlayerList() {
		return updatePlayerList;
	}

	public void setUpdatePlayerList(ArrayList<String> updatePlayerList) {
		this.updatePlayerList = updatePlayerList;
	}
	
}
