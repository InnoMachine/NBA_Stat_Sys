package businessLogic;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;

public class testChart3 {

	public static void main(String args[]){
		Team_BS team_bs = new Team_BL();
		ArrayList<PlayerVo> vo = team_bs.getPlayers("LAC");
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance("LAC");
		
		
	}
}
