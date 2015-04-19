package businessLogic;

import java.util.ArrayList;

import vo.GameVo;
import vo.PlayerPerformanceInSingleGame;

public interface Game_BS {

	public ArrayList<GameVo> getAllGames();
	public ArrayList<GameVo> getGamesDaily();
	public ArrayList<GameVo> getGamesByDate(String date);
	public ArrayList<PlayerPerformanceInSingleGame> getGameByLabel(String label);
	public PlayerPerformanceInSingleGame getPerformance(String label,String name);
}
