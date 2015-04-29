/**
 * puppy
 * 2015年3月21日 下午3:56:01
 * TODO
 */
package databaseMysqlUtility;

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
	
	public static void updateTeamAndPlayer(GamePO game) {
		
		TeamDao td= new TeamDaoImpl();
		PlayerDao pd = new PlayerDaoImpl();
		//guest team
		TeamPerformance guestTP = game.getGuestTP();
		game.getGuestPlayersNameList();
		td.addTeamPerformance(guestTP, game.getGuestTeam());//import teamPerformance to team
		for(SinglePerformance sp: guestTP.getSpList()) {
			pd.addSinglePerformance(sp.getName(), sp); //import singlePerformance to player
			pd.updateHostTeam(sp.getName(), sp.getTeamThen());//import playerHostTeam to player
		}
		for(String name: guestTP.getPlayerNameList()) {
			td.addCurrentPlayer(name, game.getGuestTeam());//import currentPlayers to team
		}
		//home team
		TeamPerformance homeTP = game.getHomeTP();
		td.addTeamPerformance(homeTP, game.getHomeTeam());
		for(SinglePerformance sp: homeTP.getSpList()) {
			pd.addSinglePerformance(sp.getName(), sp); 
			pd.updateHostTeam(sp.getName(), sp.getTeamThen());
		}
		for(String name: homeTP.getPlayerNameList()) {
			td.addCurrentPlayer(name, game.getHomeTeam());
		}
		
	}
	
	public static void updateTeamAndPlayer(ArrayList<GamePO> games) {
		for(GamePO game: games) {
			updateTeamAndPlayer(game);
		}
	}
	
	public static void importSpToPlayers(){//遍历所有球员名字，再遍历所有比赛主客队的tp，如果其中包含该球员表现，加上
		
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
						new PlayerDaoImpl().updateHostTeam(playerName, sp.getTeamThen());//update player's host team
					}
				}
				
				for(SinglePerformance sp: gamePo.getHomeTP().getSpList()){//home performance
					if(sp.getName().equalsIgnoreCase(playerName)){
						spList.add(SinglePerformance.makeSP(sp.toString()));
						new PlayerDaoImpl().updateHostTeam(playerName, sp.getTeamThen());//update player's host team
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
	
	public static void importSeasontpToTeams(){//遍历所有比赛，检查主客场队名匹配就加上
		
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
	
	public static void importPlayersToTeams(){//遍历所有球队名，对每个球队名从比赛主客场中找，找到即认为出场名单为该球队当前球员列表
		
		GameDao gd = new GameDaoImpl();
		TeamDao td = new TeamDaoImpl();
		ArrayList<String> playersNameList = new ArrayList<String>();
		ArrayList<GamePO> gameList = gd.getAllGames();
		
		for(TeamAbbr teamAbbr: TeamAbbr.values()){//enums
			for(GamePO gamePo: gameList){
				if(gamePo.getHomeTeam().equalsIgnoreCase(teamAbbr.toString())){
					for(SinglePerformance sp:gamePo.getHomeTP().getSpList()){
						playersNameList.add(sp.getName());
					}
					break;
				}
			}
			TeamPO teamPo = td.getTeamByAbbr(teamAbbr.toString());
			teamPo.setCurrentPlayersNameList(playersNameList);
			td.update(teamPo);
			playersNameList.clear();
		}
		
		System.out.println("Players lists distributed to teams!");
		
	}
	
	

}
