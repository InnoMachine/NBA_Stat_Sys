package businessLogic;

import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);
	public TeamVo [] getAllTeam();
	public TeamVo [] sortTeamBy(int option);//排序所要用的那项属性编号，用vo里的？
}
