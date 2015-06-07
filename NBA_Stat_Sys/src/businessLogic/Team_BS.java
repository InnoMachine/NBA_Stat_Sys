package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;
import vo.TeamCardVo;
import vo.TeamPerformanceInSingleGame;
import vo.TeamRecentGames;
import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);
	public ArrayList<TeamVo>  getAllTeam();
	public ArrayList<TeamVo>  sortTeamBy(String option,String seasonid);
	public ArrayList<PlayerVo> getPlayers(String abbr);
	public ArrayList<TeamCardVo> hotTeamSeason(String option); 
	public TeamRecentGames getTeamRecentPerformance(String abbr);
	public ArrayList<TeamPerformanceInSingleGame> getTeamPerformance(String abbr);
}
