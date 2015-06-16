package businessLogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import vo.TeamPerformanceInSingleGame;
import vo.chiquareout;


public class TableGet {
	BigDecimal b; 
	static Team_BS team_bs = new Team_BL();
	Random rand = new Random();
	public chiquareout getChiquareout(int number,String abbr,String season,String n){
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance(abbr,season);
		int num=tp.size();
		switch (n) {
		case "40":num=40;
			break;
		case "60":num=60;
			break;
		case "All":num=tp.size();
			break;
		default:
			break;
		}
		 double b[]=new double [num];
		 int i=0;
		 for(int k=0;k<num;k++){
			 b[i]=tp.get(rand.nextInt(num)).getScore();
			 i++;
		 }
		chiquareout co = countFuncs.chisquare(b, 5);
		if(num==40){
			co.biaozhi=49.5126;
		}
		else if(num==60){
			co.biaozhi = 72.1598;
		}
		else {
			co.biaozhi = 96.5782;
		}
		return co;
	}
}
