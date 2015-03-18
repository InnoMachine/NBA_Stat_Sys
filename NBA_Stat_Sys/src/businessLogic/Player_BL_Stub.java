package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;

public class Player_BL_Stub implements Player_BS{

	
	public PlayerVo getPlayerByName(String name) {
		return null;
	}

	public ArrayList<PlayerVo> getAllPlayer() {
		return null;
	}

	public ArrayList<PlayerVo> sortPlayerBy(String option) {
		
		return null;
	}

	public ArrayList<PlayerVo> filterPlayerBy(String position, String div, String option) {
		System.out.println("筛选成功！");
		return null;
	}
	
	public ArrayList<PlayerVo> getPlayersByTeam(String abbr)
	{
		return null;
		
	}
	
	
}
