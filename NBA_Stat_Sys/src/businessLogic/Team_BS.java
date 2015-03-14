package businessLogic;

import vo.PlayerVo;
import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);//球队用缩写好了
	public TeamVo [] getAllTeam();
	public TeamVo [] sortTeamBy(String option);//排序所要用的那项属性编号，用vo里的？
	public PlayerVo[] getPlayers(String abbr);
}
