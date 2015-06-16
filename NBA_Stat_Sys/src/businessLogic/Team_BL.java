package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;
import vo.TeamCardVo;
import vo.TeamGames;
import vo.TeamPerformanceInSingleGame;
import vo.TeamRecentGames;
import vo.TeamVo;
import vo.TotalInfo;

public class Team_BL implements Team_BS{
	Team_Handler team_handler;
	Player_BL player_bl;
	public Team_BL()
	{
		team_handler = new Team_Handler();
		player_bl = new Player_BL();
	}
	public TeamVo getTeamByAbbr(String abbr) {
		
		return team_handler.getTeamByAbbr(abbr);
	}

	@Override
	public ArrayList<TeamVo> getAllTeam() {
		return team_handler.getAllTeam();
	}

	@Override
	public ArrayList<TeamVo> sortTeamBy(String option,String seasonid) {
		return team_handler.sortTeamBy(option,seasonid);
	}
	@Override
	public ArrayList<PlayerVo> getPlayers(String abbr) {
		return player_bl.getPlayersByTeam(abbr);
	}
	@Override
	public ArrayList<TeamCardVo> hotTeamSeason(String option) {
		return team_handler.hotTeamSeason(option);
	}
	@Override
	public TeamRecentGames getTeamRecentPerformance(String abbr) {
		
		return team_handler.getTeamRecentPerformance(abbr);
	}
	public ArrayList<TeamPerformanceInSingleGame> getTeamPerformance(String abbr){
		return team_handler.getTeamPerformance(abbr);
	}
	public ArrayList<TeamPerformanceInSingleGame> getTeamPerformance(String abbr,String season){
		return team_handler.getTeamPerformance(abbr,season);
	}
	@Override
	public ArrayList<TeamVo> getTeamByAbbrA(String abbr) {
		return team_handler.getTeamByAbbrA(abbr);
	}
	@Override
	public ArrayList<TotalInfo> getTeamTotalInfos() {
		
		return team_handler.getTeamTotalInfos();
	}
	@Override
	public ArrayList<TeamGames> getTeamGames(String abbr) {
		
		return team_handler.getTeamGames(abbr);
	}
	@Override
	public ArrayList<String> getTeamAbbrs() {
		// TODO Auto-generated method stub
		return team_handler.getTeamAbbrs();
	}

}
