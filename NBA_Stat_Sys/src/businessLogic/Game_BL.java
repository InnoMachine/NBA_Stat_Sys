package businessLogic;

import java.util.ArrayList;

import vo.GameVo;

public class Game_BL implements Game_BS{
	Game_Handler game_handler = new Game_Handler();
	
	public ArrayList<GameVo> getAllGames() {
		
		return game_handler.getAllGames();
	}

	
	public ArrayList<GameVo> getGamesDaily() {
		
		return game_handler.getGameDaily();
	}

	
	public ArrayList<GameVo> getGamesByDate(String date) {
		return game_handler.getGameByDate(date);
	}

	public ArrayList<GameVo> getGamesByDate(String date1,String date2) {
		ArrayList<GameVo> list = new ArrayList<GameVo>();
		
		return null;
	}
}
