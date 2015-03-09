package businessLogic;

import java.util.ArrayList;
import vo.TeamVo;

public interface Team_BS {

	public TeamVo getTeamByAbbr(String abbr);
	public ArrayList<TeamVo> getAllTeam();
}
