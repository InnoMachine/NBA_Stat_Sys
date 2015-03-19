package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;
import vo.TeamVo;

public class Team_BL_Stub implements Team_BS{
public TeamVo getTeamByAbbr(String abbr) {
		
		return null;
	}

	@Override
	public ArrayList<TeamVo> getAllTeam() {
		ArrayList<TeamVo>  teamVos=new ArrayList<TeamVo>();
		TeamVo a=new TeamVo();
		TeamVo b=new TeamVo();
		TeamVo c=new TeamVo();
		a.setBirthYear("1970");
		b.setGameNum(190);
		c.setTeamName("Spurs");
		teamVos.add(a);
		teamVos.add(b);
		teamVos.add(c);
		return teamVos;
	}

	@Override
	public ArrayList<TeamVo> sortTeamBy(String option) {
		ArrayList<TeamVo>  teamVos=new ArrayList<TeamVo>();
		TeamVo a=new TeamVo();
		TeamVo b=new TeamVo();
		TeamVo c=new TeamVo();
		a.setBirthYear("1970");
		b.setGameNum(190);
		c.setTeamName("Spurs");
		teamVos.add(a);
		teamVos.add(b);
		teamVos.add(c);
		return teamVos;
	}

	@Override
	public ArrayList<PlayerVo> getPlayers(String abbr) {
		ArrayList<PlayerVo>  playerVos=new ArrayList<PlayerVo>();
		PlayerVo a=new PlayerVo();
		PlayerVo b=new PlayerVo();
		PlayerVo c=new PlayerVo();
		a.setName("aaa");
		b.setAge(26);
		c.setBirth("1988-07-08");
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
	}

}
