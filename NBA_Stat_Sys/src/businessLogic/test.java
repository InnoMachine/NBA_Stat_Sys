package businessLogic;

import java.util.ArrayList;

import po.GameDate;
import vo.GameVo;
import vo.PlayerCardVo;
import vo.PlayerPerformanceInSingleGame;

public class test {
	
	public static void main(String args[]){
		Player_BS p = new Player_BL();
		ArrayList<PlayerCardVo> cv=p.hotPlayerSeason("scoreField");
		for(PlayerCardVo temp:cv){
			System.out.println(temp.getSortvalue());
		}
		/*Game_BS g = new Game_BL();
		GameDate gd = new GameDate(2012,11,1);
		ArrayList<PlayerPerformanceInSingleGame> gv = g.getGameByLabel("12-13_2012-10-31_DAL-UTA");
		ArrayList<GameVo> gl= g.getGamesByDate("2012-11-01");
		ArrayList<PlayerPerformanceInSingleGame> fl = gl.get(0).getGuestTP().getFirstonList();
		for(GameVo temp:gl){
			System.out.println(temp.getGameLabel());
			//System.out.println(temp.getHomeTeam());
		}
		for(PlayerPerformanceInSingleGame temp:gv){
			System.out.println(temp.getFirstOn());
		}
		for(PlayerPerformanceInSingleGame temp:fl){
			System.out.println(temp.getName());
		}*/
		
	}
}
