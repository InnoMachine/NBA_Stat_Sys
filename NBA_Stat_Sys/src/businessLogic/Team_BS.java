package businessLogic;

import java.util.ArrayList;

import test.data.TeamHotInfo;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);
	public ArrayList<TeamVo>  getAllTeam();
	public ArrayList<TeamVo>  sortTeamBy(String option);
	public ArrayList<PlayerVo> getPlayers(String abbr);
	public ArrayList<TeamHotInfo> hotTeamSeason(String option); 
	public ArrayList<TeamPerformanceInSingleGame> getRecentGame(String abbr);
}
