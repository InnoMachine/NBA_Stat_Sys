package businessLogic;

import java.util.ArrayList;

import vo.GameVo;

public interface Game_BS {

	public ArrayList<GameVo> getAllGames();
	public ArrayList<GameVo> getGamesDaily();
	public ArrayList<GameVo> getGamesByData();
	
}
