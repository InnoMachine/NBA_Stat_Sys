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
	private ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
	
	public ArrayList<SinglePerformance> getSpList() {
		return spList;
	}

	public void setSpList(ArrayList<SinglePerformance> spList) {
		this.spList = spList;
	}

	public void addSinglePerformance(SinglePerformance sp) {
		spList.add(sp);
	}
	
	public String toString() {
		
		String result = "";
		if(!spList.isEmpty()){
			result += (spList.get(0).toString());
		}
		for(int i = 1; i < spList.size(); i ++){
			result += "\n";
			result += spList.get(i).toString();
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
