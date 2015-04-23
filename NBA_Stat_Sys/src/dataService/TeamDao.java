/**
 * puppy
 * 2015年3月9日 上午10:24:04
 * TODO
 */
package dataService;

import java.util.ArrayList;

import enums.TeamAbbr;
import po.TeamPO;
import po.TeamPerformance;

public interface TeamDao {

	public void add(TeamPO team);

	public void update(TeamPO team);

	public void deleteTeamByAbbr(String abbr);

	public TeamPO getTeamByAbbr(String abbr);

	public ArrayList<TeamPO> getAllTeams();
	
	public void addTeamPerformance(TeamPerformance tp, TeamAbbr teamAbbr);
	
	public void addCurrentPlayer(String playerName, TeamAbbr teamAbbr);
	
	public void playerTrans(String playerName, TeamAbbr fromTeamAbbr, TeamAbbr toTeamAbbr);
	
	public void changeTeamName(TeamAbbr teamAbbr, TeamPO newTeam);

}
