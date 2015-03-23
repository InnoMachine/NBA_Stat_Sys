/**
 * puppy
 * 2015年3月21日 下午3:56:01
 * TODO
 */
package database;

import java.util.ArrayList;

import po.GamePO;
import po.SinglePerformance;
import po.TeamAbbr;
import po.TeamPO;

public class DataFutherDistributor {

	public static void main(String[] args) {
		
		GameDao gd = new GameDaoImpl();
		TeamDao td = new TeamDaoImpl();
		ArrayList<String> playersNameList = new ArrayList<String>();
		ArrayList<GamePO> gameList = gd.getAllGames();
		
		for(TeamAbbr teamAbbr:TeamAbbr.values()){
			for(GamePO gamePo: gameList){
				if(gamePo.getHomeTeam().equalsIgnoreCase(teamAbbr.toString())){
					for(SinglePerformance sp:gamePo.getHomeTP().getTpList()){
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
		
	}

}
