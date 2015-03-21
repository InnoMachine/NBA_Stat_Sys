package businessLogic;


import java.util.ArrayList;

import vo.PlayerVo;
import vo.TeamVo;

public class Test {

	public static void main(String[] args) {
		Player_BS player_bs = new Player_BL();
		Team_BS team_bs = new Team_BL();
		ArrayList<PlayerVo> plist = team_bs.getPlayers("ATL");
		for(PlayerVo temp :plist)
		{
			System.out.println(temp.getName());
		}
		ArrayList<TeamVo> tlist = team_bs.getAllTeam();
		for(TeamVo temp :tlist)
		{
			System.out.println(temp.getAbbreviation());
		}
		
	}

}
