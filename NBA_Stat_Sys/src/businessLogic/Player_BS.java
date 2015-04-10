package businessLogic;

import java.util.ArrayList;

import vo.PlayerCardVo;
import vo.PlayerRecentGames;
import vo.PlayerVo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public ArrayList<PlayerVo> getAllPlayer();
	public ArrayList<PlayerVo> sortPlayerBy(String option);
	public ArrayList<PlayerVo> filterPlayerBy(String position,String div,String option); 
	public ArrayList<PlayerCardVo> hotPlayerDaily(String option);
	public ArrayList<PlayerCardVo> hotPlayerSeason(String option);
	public ArrayList<PlayerCardVo> progressFastPlayer(String option);
	public PlayerRecentGames getPlayerRecentPerformance(String name);
}
