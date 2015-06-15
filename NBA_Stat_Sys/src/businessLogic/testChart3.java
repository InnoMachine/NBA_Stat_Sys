package businessLogic;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.SpiderWebPlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;

import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import vo.TotalInfo;

public class testChart3 {

	public static void main(String args[]){
		Team_BS team_bs = new Team_BL();
		Player_BS player_bs = new Player_BL();
		ArrayList<PlayerVo> vo = team_bs.getPlayers("LAC");
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance("LAC");
		TotalInfo ti = player_bs.getTotalInfo("11-12");
		PlayerVo p=vo.get(2);
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String s=p.getName();
		String s3 = "score";
		 String s4 = "assist";
		 String s5 = "rebound"; 
		 String s6 = "steal";
		 String s7 = "block";
		 dataset.addValue(p.getScoreField()/ti.getScoreField(), s, s3);
		 dataset.addValue(p.getAssistanceField()/ti.getAssistanceField(), s, s4);
		 dataset.addValue(p.getReboundOverallField()/ti.getReboundField(), s, s5);
		 dataset.addValue(p.getStealField()/ti.getStealField(), s, s6);
		 dataset.addValue(p.getBlockField()/ti.getBlockField(), s, s7);
		 String all="all";
		 dataset.addValue(1, all, s3);
		 dataset.addValue(1, all, s4);
		 dataset.addValue(1, all, s5);
		 dataset.addValue(1, all, s6);
		 dataset.addValue(1, all, s7);
//		 String s = "First";
//		 String s1 = "Second";
//		 String s2 = "Third";
//		 String s3 = "Category 1";
//		 String s4 = "Category 2";
//		 String s5 = "Category 3"; 
//		 String s6 = "Category 4";
//		 String s7 = "Category 5";
//		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//		 dataset.addValue(1.0D, s, s3);
//		 dataset.addValue(4D, s, s4);
//		 dataset.addValue(3D, s, s5);
//		 dataset.addValue(5D, s, s6);
//		 dataset.addValue(5D, s, s7);
//		 dataset.addValue(5D, s1, s3);
//		 dataset.addValue(7D, s1, s4);
//		 dataset.addValue(6D, s1, s5);
//		 dataset.addValue(8D, s1, s6);
//		 dataset.addValue(4D, s1, s7);
//		 dataset.addValue(4D, s2, s3);
//		 dataset.addValue(3D, s2, s4);
//		 dataset.addValue(2D, s2, s5);
//		 dataset.addValue(3D, s2, s6);
//		 dataset.addValue(6D, s2, s7);
		 SpiderWebPlot spiderwebplot = new SpiderWebPlot(dataset);
		 spiderwebplot.setStartAngle(54D);
		 spiderwebplot.setInteriorGap(0.40000000000000002D);
		 spiderwebplot.setToolTipGenerator(new StandardCategoryToolTipGenerator()); 
		 JFreeChart chart = new JFreeChart("Spider Web Chart Demo 1", TextTitle.DEFAULT_FONT, spiderwebplot, false);
		 LegendTitle legendtitle = new LegendTitle(spiderwebplot);
		 legendtitle.setPosition(RectangleEdge.BOTTOM);
		 chart.addSubtitle(legendtitle);
		 ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
	        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
	        chartFrame.pack(); //以合适的大小展现图形
	        chartFrame.setVisible(true);//图形是否可见
				 
	}
	
}
