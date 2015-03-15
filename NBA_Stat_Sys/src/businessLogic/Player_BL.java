package businessLogic;

import java.util.ArrayList;

import po.Division;
import vo.PlayerVo;

public class Player_BL implements Player_BS{
	Player_Handler player_handler;
	
	public Player_BL()
	{
		player_handler =new Player_Handler(); 
	}
	public PlayerVo getPlayerByName(String name) {
		return player_handler.getPlayerByName(name);
	}

	public ArrayList<PlayerVo> getAllPlayer() {
		return player_handler.getAllPlayer();
	}

	public ArrayList<PlayerVo> sortPlayerBy(String option) {
		
		return player_handler.sortPlayerBy(option);
	}

	public ArrayList<PlayerVo> filterPlayerBy(String position, Division div, String option) {
		return null;
	}
	
	public ArrayList<PlayerVo> getPlayersByTeam(String abbr)
	{
		return player_handler.getPlayersByTeam(abbr);
		
	}
}
