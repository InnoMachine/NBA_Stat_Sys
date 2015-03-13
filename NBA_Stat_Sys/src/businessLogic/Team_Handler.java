package businessLogic;

import java.util.ArrayList;

import po.SinglePerformance;
import po.TeamPO;
import vo.TeamVo;
import database.TeamDao;
import database.TeamDaoImpl;

public class Team_Handler {
	protected TeamDao teamdao;
	private ArrayList<TeamPO> teamlistpo;
	private TeamVo[] teamlistvo;
	SinglePerformance splist[];
	
	
	public Team_Handler()
	{
		teamdao = new TeamDaoImpl();
		teamlistpo = teamdao.getAllTeams();
		teamlistvo = new TeamVo[teamlistpo.size()+1];
		splist = new SinglePerformance[teamlistvo.length];
		setVo();
	}


	private void setVo() {
		for(int i=0;i<teamlistpo.size();i++)
		{
			teamlistvo[i].setTeamName(teamlistpo.get(i).getTeamName());
			teamlistvo[i].setAbbreviation(teamlistpo.get(i).getAbbreviation());
			teamlistvo[i].setCity(teamlistpo.get(i).getCity());
			teamlistvo[i].setConference(teamlistpo.get(i).getConference());
			teamlistvo[i].setDivision(teamlistpo.get(i).getDivision());
			teamlistvo[i].setHomeField(teamlistpo.get(i).getHomeField());
			teamlistvo[i].setBirthYear(teamlistpo.get(i).getBirthYear());
			teamlistvo[i].setImgPath(teamlistpo.get(i).getImgPath());
			
			
			splist[i].setName(teamlistpo.get(i).getTeamName());
			//splist[i].setTime(0);
			splist[i].setHitNum(0);
			splist[i].setShotNum(0);
			splist[i].setThreePointHitNum(0);
			splist[i].setThreePointShotNum(0);
			splist[i].setFreeThrowHitNum(0);
			splist[i].setFreeThrowShotNum(0);
			splist[i].setOffensiveRebound(0);
			splist[i].setDefensiveRebound(0);
			splist[i].setReboundOverall(0);
			splist[i].setAssistance(0);
			splist[i].setBlock(0);
			splist[i].setTurnover(0);
			splist[i].setFoul(0);
			splist[i].setScore(0);
			//splist[i].setSteal(0);
		}
	}
}
