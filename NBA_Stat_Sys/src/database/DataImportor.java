/**
 * puppy
 * 2015年3月9日 上午00:35:19
 * TODO
 */
package database;

public class DataImportor {

	public static void main(String[] args) {
		
		String teamDataPath = new String("CSEdata/teams/teams");
		new DataImportor().importTeams(teamDataPath);
		
	}
	
	public void importTeams(String teamDataPath){
		
		DataFileReader frt = new DataFileReader();
		System.out.println(frt.teamDataSplitor(frt.getFileContext(teamDataPath)).size()+"*******************");
//		ArrayList<Team> teamList = new ArrayList<Team>(frt.makeTeamList(frt.teamDataSplitor(frt.getFileContext(teamDataPath))));	
		
//		TeamDao teamDataController = new TeamDaoImpl();
//		for(int i = 0; i < teamList.size(); i ++){
//			teamDataController.add(teamList.get(i));
//		}
		
	}
	
	public void importPlayers(){
		
		
	}
	
	public void importGames(){
		
	}
	
}
