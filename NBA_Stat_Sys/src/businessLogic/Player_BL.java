package businessLogic;

import po.Division;
import vo.PlayerVo;

public class Player_BL implements Player_BS{
	Player_Handler player_handler;
	

	public PlayerVo getPlayerByName(String name) {
		
		return null;
	}

	@Override
	public PlayerVo[] getAllPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerVo[] sortPlayerBy(int option) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlayerVo[] filterPlayerBy(String position, Division div, int option) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public PlayerVo getPlayersByTeam(String abbr)
	{
		return null;
		
	}
}
