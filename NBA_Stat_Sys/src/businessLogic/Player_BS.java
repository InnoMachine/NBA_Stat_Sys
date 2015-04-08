package businessLogic;

import java.util.ArrayList;

import test.data.PlayerHotInfo;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerVo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public ArrayList<PlayerVo> getAllPlayer();
	public ArrayList<PlayerVo> sortPlayerBy(String option);
	public ArrayList<PlayerVo> filterPlayerBy(String position,String div,String option); 
	public ArrayList<PlayerHotInfo> hotPlayerDaily(String option);
	public ArrayList<PlayerHotInfo> hotPlayerSeason(String option);
	public ArrayList<PlayerVo> progressFastPlayer(String option);
	public ArrayList<PlayerPerformanceInSingleGame> getRecentGames(String PlayerName);
}
