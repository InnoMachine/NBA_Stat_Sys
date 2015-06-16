package businessLogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import chartMaking.BarChartMaking;
import chartMaking.ScatterPlotChartMaking;
import vo.TeamPerformanceInSingleGame;
import vo.chiquareout;
import vo.regAnalysisout;
import vo.varAnakysisout;


public class TableGet {
	BigDecimal b; 
	static Team_BS team_bs = new Team_BL();
	Random rand = new Random();
	public chiquareout getChiquareout(int number,String abbr,String season,String n){
		BarChartMaking bcm = new BarChartMaking();
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance(abbr,season);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
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
		for(int k=0;k<co.ni.length;i++){
			dataset.addValue(co.ni[k], co.qujian[k], "score");
		}
		
		co.cp = bcm.makeChart(dataset);
		return co;
	}
	
	public regAnalysisout getRegAnalysisout(int number,String abbr,String season){
		ScatterPlotChartMaking spcm = new ScatterPlotChartMaking();
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance(abbr,season);
		DefaultXYDataset dataset = new DefaultXYDataset();
		 double t[] = new double[20];
		 double g[] = new double[20];
		 double data[][] = new double[2][20];
		 for(int i=0;i<20;i++){
			 TeamPerformanceInSingleGame temp=tp.get(rand.nextInt(tp.size()));
			 t[i]=temp.getScore();
			 g[i]=temp.getAssistance();
			data[1][i] = temp.getScore();
			data[0][i] = temp.getAssistance();
		 }
		 regAnalysisout rao = countFuncs.leastSquare(g, t);
		dataset.addSeries("", data);
		 rao.cp=spcm.makeChart(dataset);
		 return rao;
		 
	}
	
	public varAnakysisout getVarAnakysisout(int number,String abbr){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		return null;
	}
}
