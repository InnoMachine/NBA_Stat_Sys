/**
 * puppy
 * 2015年3月21日 下午3:56:01
 * TODO
 */
package databaseUtility;

import java.util.ArrayList;

import dataService.GameDao;
import dataService.GameDaoImpl;
import dataService.PlayerDao;
import dataService.PlayerDaoImpl;
import dataService.TeamDao;
import dataService.TeamDaoImpl;
import enums.TeamAbbr;
import po.GamePO;
import po.PlayerPO;
import po.SinglePerformance;
import po.TeamPO;
import po.TeamPerformance;

public class DataFurtherDistributor {

	public static void allDistribute() {
		
		DataFurtherDistributor.importPlayersToTeams();
		DataFurtherDistributor.importSeasontpToTeams();
		DataFurtherDistributor.importSpToPlayers();
		System.out.println("------------------------------");
		
	}
	
	public static void importSpToPlayers(){
		
		GameDao gd = new GameDaoImpl();
		PlayerDao pd = new PlayerDaoImpl();
		
		ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
		ArrayList<GamePO> gameList = gd.getAllGames();
		
		ArrayList<PlayerPO> allPlayerList = pd.getAllPlayers();
		ArrayList<String> allPlayerNameList = new ArrayList<String>();
		for(PlayerPO player: allPlayerList){
			allPlayerNameList.add(player.getName());
		}
		
		for(String playerName: allPlayerNameList){
			for(GamePO gamePo: gameList){
				for(SinglePerformance sp: gamePo.getGuestTP().getSpList()){//guest performance
					if(sp.getName().equalsIgnoreCase(playerName)){
						spList.add(SinglePerformance.makeSP(sp.toString()));
					}
				}
				
				for(SinglePerformance sp: gamePo.getHomeTP().getSpList()){//home performance
					if(sp.getName().equalsIgnoreCase(playerName)){
						spList.add(SinglePerformance.makeSP(sp.toString()));
					}
				}
			}
			PlayerPO playerPo = pd.getPlayerByName(playerName);
			playerPo.setSeasonSinglePerformance(spList);
			pd.update(playerPo);
			spList.clear();
		}
		
		System.out.println("Season single performances distributed to players!");
		
	}
	
	public static void importSeasontpToTeams(){
		
		GameDao gd = new GameDaoImpl();
		TeamDao td = new TeamDaoImpl();
		
		ArrayList<TeamPerformance> tpList = new ArrayList<TeamPerformance>();
		ArrayList<GamePO> gameList = gd.getAllGames();
		
		for(TeamAbbr teamAbbr:TeamAbbr.values()){
			for(GamePO gamePo: gameList){
				if(gamePo.getHomeTeam().equalsIgnoreCase(teamAbbr.toString())){
					tpList.add(gamePo.getHomeTP());
				}
				if(gamePo.getGuestTeam().equalsIgnoreCase(teamAbbr.toString())){
					tpList.add(gamePo.getGuestTP());
				}
			}
			TeamPO teamPo = td.getTeamByAbbr(teamAbbr.toString());
			teamPo.setSeansonTeamPerformance(tpList);;
			td.update(teamPo);
			tpList.clear();
		}
		
		System.out.println("Season team performances distributed to teams!");
		
	}
	
	public static void importPlayersToTeams(){
		
		GameDao gd = new GameDaoImpl();
		TeamDao td = new TeamDaoImpl();
		ArrayList<String> playersNameList = new ArrayList<String>();
		ArrayList<GamePO> gameList = gd.getAllGames();
		
		for(TeamAbbr teamAbbr:TeamAbbr.values()){
			for(GamePO gamePo: gameList){
				if(gamePo.getHomeTeam().equalsIgnoreCase(teamAbbr.toString())){
					for(SinglePerformance sp:gamePo.getHomeTP().getSpList()){
						playersNameList.add(sp.getName());
					}
					break;
				}
			}
			TeamPO teamPo = td.getTeamByAbbr(teamAbbr.toString());
			teamPo.setPlayersNameList(playersNameList);
			td.update(teamPo);
			playersNameList.clear();
		}
		
		System.out.println("Players lists distributed to teams!");
		
	}

}
