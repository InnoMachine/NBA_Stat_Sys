package businessLogic;

import java.util.ArrayList;

import po.Conference;
import po.Division;
import vo.PlayerVo;
import vo.TeamVo;

public class Team_BL_Stub implements Team_BS {
	public TeamVo getTeamByAbbr(String abbr) {
		TeamVo a = new TeamVo();
		a.setBirthYear("1970");
		a.setDivision(Division.ATLANTIC);
		a.setConference(Conference.E);
		return a;
	}

	@Override
	public ArrayList<TeamVo> getAllTeam() {
		ArrayList<TeamVo> teamVos = new ArrayList<TeamVo>();
		TeamVo a = new TeamVo();
		TeamVo b = new TeamVo();
		TeamVo c = new TeamVo();
		a.setBirthYear("1970");
		a.setDivision(Division.ATLANTIC);
		a.setConference(Conference.E);
		b.setGameNum(190);
		b.setDivision(Division.CENTRAL);
		b.setConference(Conference.W);
		c.setTeamName("Spurs");
		c.setDivision(Division.NORTHWEST);
		c.setConference(Conference.E);
		teamVos.add(a);
		teamVos.add(b);
		teamVos.add(c);
		return teamVos;
	}

	@Override
	public ArrayList<TeamVo> sortTeamBy(String option) {
		ArrayList<TeamVo> teamVos = new ArrayList<TeamVo>();
		TeamVo a = new TeamVo();
		TeamVo b = new TeamVo();
		TeamVo c = new TeamVo();
		a.setBirthYear("1970");
		a.setDivision(Division.ATLANTIC);
		a.setConference(Conference.E);
		b.setGameNum(190);
		b.setDivision(Division.CENTRAL);
		b.setConference(Conference.W);
		c.setTeamName("Spurs");
		c.setDivision(Division.NORTHWEST);
		c.setConference(Conference.E);
		teamVos.add(a);
		teamVos.add(b);
		teamVos.add(c);
		return teamVos;
	}

	@Override
	public ArrayList<PlayerVo> getPlayers(String abbr) {
		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		PlayerVo a = new PlayerVo();
		PlayerVo b = new PlayerVo();
		PlayerVo c = new PlayerVo();
		a.setName("aaa");
		a.setDivision(Division.ATLANTIC);
		b.setAge(26);
		b.setDivision(Division.CENTRAL);
		c.setBirth("1988-07-08");
		c.setDivision(Division.NORTHWEST);
		playerVos.add(a);
		playerVos.add(b);
		playerVos.add(c);
		return playerVos;
	}

}
