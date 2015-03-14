/**
 * puppy
 * 2015年3月8日 下午3:53:39
 * TODO
 */
package po;

import java.util.ArrayList;

public class TeamPerformance {
	
	private String teamNameAbbr;
	private ArrayList<SinglePerformance> tpList = new ArrayList<SinglePerformance>();
	
	public ArrayList<SinglePerformance> getTpList() {
		return tpList;
	}

	public void setTpList(ArrayList<SinglePerformance> tpList) {
		this.tpList = tpList;
	}

	public void addSinglePerformance(SinglePerformance sp) {
		tpList.add(sp);
	}
	
	public String toString() {
		return null;
	}

	public String getTeamNameAbbr() {
		return teamNameAbbr;
	}

	public void setTeamNameAbbr(String teamNameAbbr) {
		this.teamNameAbbr = teamNameAbbr;
	}
	
}
