/**
 * puppy
 * 2015年3月23日 下午5:42:52
 * TODO
 */
package databaseMysqlUtility;

import java.util.ArrayList;

import dataService.DaoFactory;
import dataService.SystemDao;
import dataService.SystemDaoImpl;
import po.GameDate;
import po.SeasonTracker;

public class PrepareDB {

	public static void main(String[] args) {
		
		ArrayList<String> fileNameList = DataFileReader.getFileNameList("CSEdata/new");
		while(true) {//check if any data exists, continue when there is at least 1 entry
			fileNameList = DataFileReader.getFileNameList("CSEdata/new");
			System.out.println("当前数据目录加下数据文件数量为" + fileNameList.size());
			if(fileNameList.size() != 0) {
				break;
			}
		}
		
		SystemDao sd = new SystemDaoImpl();
		SeasonTracker st = new SeasonTracker();
		st.setCurrentDate(filterCurrentDate(fileNameList));
		st.setFileNameList(fileNameList);
		st.setGameNumSofar(fileNameList.size());
		st.setSeasonId("12-13");
		
		
//		st.setSeasonRecord(seasonRecord);
//		st.setUpdatePlayerList(updatePlayerList);
//		st.setUpdateTeamList(updateTeamList);
		
		InitDB.init();
		sd.add(st);
		DataFileReader.importGamesFrom(fileNameList);
		DataFileReader.importPlayersAndTeams();
		DataFurtherDistributor.allDistribute();	
		DaoFactory.getGameDaoInstence();
		
		while(true){
			if(checkNew(st.getGameNumSofar())) {
				ArrayList<String> nowFileNameList = DataFileReader.getFileNameList("CSEdata/new");
				ArrayList<String> newFileNameList = getNewFileName(st.getFileNameList(), nowFileNameList);
				DataFileReader.importGamesFrom(newFileNameList);
				st.setUpdateGameList(getGameLabelsFromPaths(newFileNameList));//new GamePOs' gamelabel
				
				st.setFileNameList(nowFileNameList);
				st.setGameNumSofar(DataFileReader.getFileNameList("CSEdata/new").size());
				st.setCurrentDate(filterCurrentDate(newFileNameList));
			}
			
			DataFurtherDistributor.allDistribute();	//improved
			DataFurtherDistributor.updateTeamAndPlayer(DaoFactory.getGameDaoInstence().getGameByLabel(st.getUpdateGameList()));
			sd.update(st);
			System.out.println(st.getCurrentDate().toString());
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
//		path = "CSEdata/new/12-13_10-30_BOS-MIA";  --  MAC OS X
//		path = "CSEdata\new\12-13_10-30_BOS-MIA";  --  WINDOWS
		System.out.println(path);
		String time = path.split("\\\\|\\/")[2];
		return new GameDate(GameDate.appendYear(time.split("_")[0], time.split("_")[1]));
	}
	
	
	public static String getGameLabelFromPath(String path) {
//		path = "CSEdata/new/12-13_10-30_BOS-MIA";  --  MAC OS X
//		path = "CSEdata\new\12-13_10-30_BOS-MIA";  --  WINDOWS
		System.out.println(path);
		String time = path.split("\\\\|\\/")[2];
		String seasonid = time.split("_")[0];
		String versus = time.split("_")[1];
		String gameDate = new GameDate(GameDate.appendYear(seasonid, versus)).toString();
		return seasonid + "_" + versus +"_"+ gameDate;
	}
	
	public static ArrayList<String> getGameLabelsFromPaths(ArrayList<String> paths) {
		ArrayList<String> result = new ArrayList<String>();
		for(String path: paths) {
			result.add(getGameLabelFromPath(path));
		}
		return result;
	}
	
	

}
