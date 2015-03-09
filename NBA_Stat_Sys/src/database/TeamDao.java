/**
 * puppy
 * 2015年3月9日 上午10:24:04
 * TODO
 */
package database;

import java.util.ArrayList;
import po.Team;

public interface TeamDao {

	public void add(Team team);
	public void update(Team team);
	public void deleteTeamByAbbr(String abbr);
	public Team getTeamByAbbr(String abbr);
	public ArrayList<Team> getAllTeams();
	
}
