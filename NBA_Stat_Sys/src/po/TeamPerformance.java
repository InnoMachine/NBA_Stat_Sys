/**
 * puppy
 * 2015年3月8日 下午3:53:39
 * TODO
 */
package po;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	public String toString() {/////////////////////////////
		
		String result = "";
		if(tpList.isEmpty()){
			result += (tpList.get(0).toString());
		}
		for(int i = 1; i < tpList.size(); i ++){
			result += "\n";
			tpList.get(i).toString();
		}
		return result;
		
	}

	public String getTeamNameAbbr() {
		return teamNameAbbr;
	}

	public void setTeamNameAbbr(String teamNameAbbr) {
		this.teamNameAbbr = teamNameAbbr;
	}
	
	public static TeamPerformance makeTP(String teamAbbr, String tpText){
		
		TeamPerformance tp = new TeamPerformance();
		tp.setTeamNameAbbr(teamAbbr);
		
		Scanner scannerFull = new Scanner(tpText);
		String line = new String();
		SinglePerformance sp;
		while(scannerFull.hasNextLine()){
			line = scannerFull.nextLine();
			sp = SinglePerformance.makeSP(line);
			tp.addSinglePerformance(sp);
		}
		scannerFull.close();
		return tp;
		
	}
	
}
