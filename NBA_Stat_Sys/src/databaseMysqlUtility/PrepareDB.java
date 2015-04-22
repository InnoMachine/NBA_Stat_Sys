/**
 * puppy
 * 2015年3月23日 下午5:42:52
 * TODO
 */
package databaseMysqlUtility;

import java.util.ArrayList;

import po.GameDate;
import po.SeasonTracker;

public class PrepareDB {

	public static void main(String[] args) {
		
		SeasonTracker st = new SeasonTracker();
		ArrayList<String> fileNameList = DataFileReader.getFileNameList("CSEdata/new");
		st.setCurrentDate(filterCurrentDate(fileNameList));
		st.setFileNameList(fileNameList);
		st.setGameNumSofar(fileNameList.size());
		st.setSeasonId("12-13");
//		st.setSeasonRecord(seasonRecord);
//		st.setUpdatePlayerList(updatePlayerList);
//		st.setUpdateTeamList(updateTeamList);
		
		InitDB.init();
		DataFileReader.importGamesFrom(fileNameList);
		DataFileReader.importPlayersAndTeams();
		
		while(true){
			if(checkNew(st.getGameNumSofar())) {
				ArrayList<String> nowFileNameList = DataFileReader.getFileNameList("CSEdata/new");
				ArrayList<String> newFileNameList = getNewFileName(st.getFileNameList(), nowFileNameList);
				DataFileReader.importGamesFrom(newFileNameList);
				st.setFileNameList(nowFileNameList);
				st.setGameNumSofar(DataFileReader.getFileNameList("CSEdata/new").size());
				st.setCurrentDate(filterCurrentDate(newFileNameList));
			}
			DataFurtherDistributor.allDistribute();
		}
		
//		System.out.println("**************************************");
//		System.out.println("Database fully prepared now! :p");
//		System.out.println("**************************************");

	}
	
	public static boolean checkNew(int stGameNum) {
		int numberNow = DataFileReader.getFileNameList("CSEdata/new").size();
		return stGameNum <  numberNow;
	}
	
	public static ArrayList<String> getNewFileName(ArrayList<String> dbFileNameList, ArrayList<String> nowFileNameList) {
		ArrayList<String> result = new ArrayList<String>(nowFileNameList);
		for(String test: nowFileNameList) {
			if(dbFileNameList.contains(test)) {
				result.remove(test);
			}
		}
		return result;
	}
	
	public static GameDate filterCurrentDate(ArrayList<String> fileNameList) {
		
		GameDate result = new GameDate();
		for(String filePath: fileNameList) {
			GameDate test = getGamedateFromPath(filePath);
			if(result.compareTo(test) == -1) {
				result = test;
			}
		}
		return result;
		
	}
	
	public static GameDate getGamedateFromPath(String path) {
//		path = "CSEdata/new/12-13_10-30_BOS-MIA";
		System.out.println(path);
		String time = path.split("\\\\|\\/")[2];
		return new GameDate(GameDate.appendYear(time.split("_")[0], time.split("_")[1]));
	}

}
