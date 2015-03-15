package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;
import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);//球队用缩写好了
	public ArrayList<TeamVo>  getAllTeam();
	public ArrayList<TeamVo>  sortTeamBy(String option);
	public ArrayList<PlayerVo> getPlayers(String abbr);
}
