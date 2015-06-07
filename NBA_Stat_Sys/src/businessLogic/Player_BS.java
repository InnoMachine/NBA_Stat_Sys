package businessLogic;

import java.util.ArrayList;

import vo.PlayerCardVo;
import vo.PlayerGames;
import vo.PlayerRecentGames;
import vo.PlayerVo;
import vo.TotalInfo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public ArrayList<PlayerVo> getAllPlayer();
	public ArrayList<PlayerVo> sortPlayerBy(String option,String seasonid);
	public ArrayList<PlayerVo> filterPlayerBy(String position,String div,String option,String seasonid); 
	public ArrayList<PlayerCardVo> hotPlayerDaily(String option);
	public ArrayList<PlayerCardVo> hotPlayerSeason(String option);
	public ArrayList<PlayerCardVo> progressFastPlayer(String option);
	public PlayerRecentGames getPlayerRecentPerformance(String name);
	public ArrayList<PlayerVo> sortPlayerBy(String option1, String option2,String seasonid);
	public ArrayList<PlayerVo> searchPlayer(String key,String first) ;
	public PlayerGames getPlayerPerformacne(String name);
	public TotalInfo getTotalInfo();
}
