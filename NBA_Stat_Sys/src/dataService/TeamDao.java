/**
 * puppy
 * 2015年3月9日 上午10:24:04
 * TODO
 */
package dataService;

import java.util.ArrayList;
import po.TeamPO;

public interface TeamDao {

	public void add(TeamPO team);

	public void update(TeamPO team);

	public void deleteTeamByAbbr(String abbr);

	public TeamPO getTeamByAbbr(String abbr);

	public ArrayList<TeamPO> getAllTeams();

}
