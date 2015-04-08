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
	private String gamelabel;//sudo
	private ArrayList<SinglePerformance> spList = new ArrayList<SinglePerformance>();
	
	public ArrayList<SinglePerformance> getSpList() {
		return spList;
	}

	public void setSpList(ArrayList<SinglePerformance> spList) {
		this.spList = spList;
	}

	public void addSinglePerformance(SinglePerformance sp) {
		this.spList.add(sp);
	}
	
	public String toString() {
		
		String result = "";
		if(!spList.isEmpty()){
			result += gamelabel;
//			result += spList.get(0).toString();
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
	
	public static TeamPerformance makeTP(String teamAbbr, String gamelabel, String tpText){
		
		TeamPerformance tp = new TeamPerformance();
		tp.setTeamNameAbbr(teamAbbr);
		
		Scanner scannerFull = new Scanner(tpText);
		String line = new String();
		SinglePerformance sp;
		while(scannerFull.hasNextLine()){
			line = scannerFull.nextLine();
			sp = SinglePerformance.makeSP(teamAbbr, gamelabel, line);
			tp.addSinglePerformance(sp);
		}
		scannerFull.close();
		return tp;
		
	}
	
	public static TeamPerformance makeTP(String teamAbbr, String tpText){
		
		TeamPerformance tp = new TeamPerformance();
		tp.setTeamNameAbbr(teamAbbr);
		
		Scanner scannerFull = new Scanner(tpText);
		String line = new String();
		String gamelabel = "";
		SinglePerformance sp;
		if(scannerFull.hasNextLine()){
			gamelabel = scannerFull.nextLine();
		}
		while(scannerFull.hasNextLine()){
			line = scannerFull.nextLine();
			sp = SinglePerformance.makeSP(teamAbbr, gamelabel, line);
			tp.addSinglePerformance(sp);
		}
		scannerFull.close();
		return tp;
		
	}

	public String getGamelabel() {
		return gamelabel;
	}

	public void setGamelabel(String gamelabel) {
		this.gamelabel = gamelabel;
	}
	
}
