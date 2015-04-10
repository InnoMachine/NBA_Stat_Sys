package businessLogic;

import java.util.ArrayList;





import enums.Conference;
import vo.PlayerVo;
import vo.TeamCardVo;
import vo.TeamRecentGames;
import vo.TeamVo;

public class Team_BL_Stub implements Team_BS{

	@Override
	public TeamVo getTeamByAbbr(String abbr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVo> getAllTeam() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamVo> sortTeamBy(String option) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PlayerVo> getPlayers(String abbr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<TeamCardVo> hotTeamSeason(String option) {
		// TODO Auto-generated method stub
		ArrayList<TeamCardVo> teamCardVos = new ArrayList<TeamCardVo>();
		if (option == "scoreField") {
			TeamCardVo teamCardVo1 = new TeamCardVo();
			teamCardVo1.setAbbreviation("DAL");
			teamCardVo1.setCity("Los Angeles");
			teamCardVo1.setConference(Conference.E);
			teamCardVo1.setSortOption(option);
			teamCardVo1.setSortValue(27.8);
			teamCardVos.add(teamCardVo1);
			TeamCardVo teamCardVo2 = new TeamCardVo();
			teamCardVo2.setAbbreviation("MEM");
			teamCardVo2.setCity("Atlanta");
			teamCardVo2.setConference(Conference.W);
			teamCardVo2.setSortOption(option);
			teamCardVo2.setSortValue(22.8);
			teamCardVos.add(teamCardVo2);
			TeamCardVo teamCardVo3 = new TeamCardVo();
			teamCardVo3.setAbbreviation("PHI");
			teamCardVo3.setCity("New York");
			teamCardVo3.setConference(Conference.E);
			teamCardVo3.setSortOption(option);
			teamCardVo3.setSortValue(18.9);
			teamCardVos.add(teamCardVo3);
			TeamCardVo teamCardVo4 = new TeamCardVo();
			teamCardVo4.setAbbreviation("SAS");
			teamCardVo4.setCity("New York");
			teamCardVo4.setConference(Conference.W);
			teamCardVo4.setSortOption(option);
			teamCardVo4.setSortValue(19.1);
			teamCardVos.add(teamCardVo4);
			TeamCardVo teamCardVo5 = new TeamCardVo();
			teamCardVo5.setAbbreviation("UTA");
			teamCardVo5.setCity("New York");
			teamCardVo5.setConference(Conference.W);
			teamCardVo5.setSortOption(option);
			teamCardVo5.setSortValue(26.3);
			teamCardVos.add(teamCardVo5);
		} else {

			TeamCardVo teamCardVo1 = new TeamCardVo();
			teamCardVo1.setAbbreviation("ATL");
			teamCardVo1.setCity("Los Angeles");
			teamCardVo1.setConference(Conference.E);
			teamCardVo1.setSortOption(option);
			teamCardVo1.setSortValue(27.8);
			teamCardVos.add(teamCardVo1);
			TeamCardVo teamCardVo2 = new TeamCardVo();
			teamCardVo2.setAbbreviation("MIN");
			teamCardVo2.setCity("Atlanta");
			teamCardVo2.setConference(Conference.W);
			teamCardVo2.setSortOption(option);
			teamCardVo2.setSortValue(22.8);
			teamCardVos.add(teamCardVo2);
			TeamCardVo teamCardVo3 = new TeamCardVo();
			teamCardVo3.setAbbreviation("DEN");
			teamCardVo3.setCity("New York");
			teamCardVo3.setConference(Conference.E);
			teamCardVo3.setSortOption(option);
			teamCardVo3.setSortValue(18.9);
			teamCardVos.add(teamCardVo3);
			TeamCardVo teamCardVo4 = new TeamCardVo();
			teamCardVo4.setAbbreviation("DEN");
			teamCardVo4.setCity("New York");
			teamCardVo4.setConference(Conference.W);
			teamCardVo4.setSortOption(option);
			teamCardVo4.setSortValue(19.1);
			teamCardVos.add(teamCardVo4);
			TeamCardVo teamCardVo5 = new TeamCardVo();
			teamCardVo5.setAbbreviation("DEN");
			teamCardVo5.setCity("New York");
			teamCardVo5.setConference(Conference.W);
			teamCardVo5.setSortOption(option);
			teamCardVo5.setSortValue(26.3);
			teamCardVos.add(teamCardVo5);

		}
		return teamCardVos;
		
	}

	@Override
	public TeamRecentGames getTeamRecentPerformance(String abbr) {
		// TODO Auto-generated method stub
		return null;
	}

}
