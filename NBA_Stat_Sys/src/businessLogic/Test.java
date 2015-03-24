package businessLogic;


import java.math.BigDecimal;
import java.util.ArrayList;

import po.PlayerPO;
import po.SinglePerformance;
import database.PlayerDao;
import database.PlayerDaoImpl;
import vo.PlayerVo;
import vo.TeamVo;

public class Test {

	public static void main(String[] args) {
		Player_BS player_bs = new Player_BL();
		Team_BS team_bs = new Team_BL();
		PlayerDao pd = new PlayerDaoImpl();
		PlayerPO po = pd.getPlayerByName("Blake Griffin");
		ArrayList<SinglePerformance> list = po.getSeasonSinglePerformance();
		int i=0,k=0;
		for(SinglePerformance temp:list)
		{
			i+=temp.getScore();
			k++;
		}
		System.out.println(i);
		System.out.println(k);
		PlayerVo vo =player_bs.getPlayerByName("Blake Griffin");
		System.out.println(vo.getScore());
		System.out.println(vo.getGameNum());
		TeamVo teamvo=team_bs.getTeamByAbbr("ATL");
		System.out.println(teamvo.getHitRate());
		/*ArrayList<PlayerVo> plist = player_bs.sortPlayerBy("useRate");
		for(PlayerVo temp :plist)
		{
			System.out.print(temp.getUseRate());
			System.out.print("    ");
			System.out.println(temp.getGameNum());
		}
		ArrayList<TeamVo> tlist = team_bs.getAllTeam();
		for(TeamVo temp :tlist)
		{
			System.out.println(temp.getAbbreviation());
		}*/
		
		
		
		
		
	}

}
