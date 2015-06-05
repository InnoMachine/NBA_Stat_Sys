package businessLogic;

import java.awt.Font;
import java.util.ArrayList;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYDatasetTableModel;
import org.jfree.chart.ChartFactory;

import po.TeamPerformance;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;

public class testChart2 {
	

	public static void main(String[] args)
    {
	 Team_BS team_bs = new Team_BL();
	 ArrayList<PlayerVo> vo = team_bs.getPlayers("LAC");
	 ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance("LAC");
	 
//	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//	 for(PlayerVo temp:vo){
//		 dataset.setValue(temp.getScoreField(),  "score",temp.getName());
//		 dataset.setValue(temp.getAssistanceField(), "assistance",temp.getName());
//		 dataset.setValue(temp.getBlockField(),"block",temp.getName());
//	 }
//	 
//		JFreeChart chart = ChartFactory.createBarChart("数据折线 ", "姓名", "产量",  
//				                dataset, PlotOrientation.VERTICAL, true, false	,false);
//		CategoryPlot cpp = chart.getCategoryPlot();
	 
		DefaultXYDataset xy = new DefaultXYDataset();
		double data[][] = new double[2][tp.size()];
		int i =0;
		for(TeamPerformanceInSingleGame temp:tp){
			data[0][i] = temp.getScore();
			data[1][i] = temp.getAssistance();
			i++;
		}
		xy.addSeries("", data);
		
		
		JFreeChart chart =ChartFactory.createScatterPlot("数据折线 ", "姓名", "产量", xy, PlotOrientation.VERTICAL, true, true, true);
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");         //设置标题字体
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));         //设置图例的字体
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));         //设置轴向的字体
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));         //应用主题样式
        ChartFactory.setChartTheme(standardChartTheme);   
       
        ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
        chartFrame.pack(); //以合适的大小展现图形
        chartFrame.setVisible(true);//图形是否可见
        
    }
	        

}
