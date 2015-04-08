/**
 * puppy
 * Apr 8, 2015 4:55:20 PM
 * TODO record the sequence of games in a certain season
 */
package po;

import java.util.ArrayList;

public class SeasonTracker {
	
	ArrayList<GameDayPack> seasonRecord = new ArrayList<GameDayPack>();
	GameDate currentDate;
	
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
	
}
