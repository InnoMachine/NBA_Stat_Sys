package businessLogic;

import java.awt.Font;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import vo.TeamGames;
import vo.TeamPerformanceInSingleGame;
import vo.TeamVo;
import vo.TotalInfo;
import dataService.DataScrawl;

public class test2 {
	static Team_BS team_bs = new Team_BL();
	public static void main(String args[]){
		
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 dataset = dataset3();
		

        
		JFreeChart chart =ChartFactory.createLineChart("", "season", "score", dataset, PlotOrientation.VERTICAL, true, true, true);
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
	
	public static DefaultCategoryDataset dataset1(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<TeamVo> vos = team_bs.getTeamByAbbrA("LAL");
		ArrayList<TotalInfo> tis = team_bs.getTeamTotalInfos();
		ArrayList<TeamGames> tgs  =team_bs.getTeamGames("LAL");
		double [] value=new double[15];
		int k=0;
		for(TeamGames temp:tgs){
			int i=0;
			int n =temp.getGames().size();
			double s[] = new double [n];
			for(TeamPerformanceInSingleGame tp:temp.getGames()){
				s[i]=tp.getScore();
			}
			value[k] = testChart2.variance(s);
			k++;
		}
		// 曲线名称
		String All = "All";
        String Teamabbr = "LAL";  // series指的就是报表里的那条数据线 
                        //因此 对数据线的相关设置就需要联系到serise
                        //比如说setSeriesPaint 设置数据线的颜色
        // 横轴名称(列名称)  
        String[] time = new String[15];
        String[] timeValue = { "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                      "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13",
                      "13-14", "14-15" };
        for (int i = 0; i < 15; i++) {
               time[i] = timeValue[i];
        }
        
        for (int i = 0; i < 15; i++) {
            dataset.addValue(value[i],Teamabbr,
                                     time[i]);
     }
        return dataset;
	}
	
	public static DefaultCategoryDataset dataset2(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<TeamVo> vos = team_bs.getTeamByAbbrA("LAL");
		ArrayList<TotalInfo> tis = team_bs.getTeamTotalInfos();
		ArrayList<TeamGames> tgs  =team_bs.getTeamGames("LAL");
		double [] value=new double[15];
		int k=0;
		for(TeamGames temp:tgs){
			int i=0;
			int n =temp.getGames().size();
			double s[] = new double [n];
			for(TeamPerformanceInSingleGame tp:temp.getGames()){
				s[i]=tp.getScore();
			}
			value[k] = testChart2.variance(s);
			k++;
		}
		// 曲线名称
		String All = "All";
        String Teamabbr = "LAL";  // series指的就是报表里的那条数据线 
                        //因此 对数据线的相关设置就需要联系到serise
                        //比如说setSeriesPaint 设置数据线的颜色
        // 横轴名称(列名称)  
        String[] time = new String[15];
        String[] timeValue = { "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                      "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13",
                      "13-14", "14-15" };
        for (int i = 0; i < 15; i++) {
               time[i] = timeValue[i];
        }
        
        for (int i = 0; i < 15; i++) {
            dataset.addValue(vos.get(i).getWinningRate(),All,
                                     time[i]);
     }
        return dataset;
	}
	public static DefaultCategoryDataset dataset3(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<TeamVo> vos = team_bs.getTeamByAbbrA("LAL");
		ArrayList<TotalInfo> tis = team_bs.getTeamTotalInfos();
		
		// 曲线名称
		String All = "All";
        String Teamabbr = "LAL";  // series指的就是报表里的那条数据线 
                        //因此 对数据线的相关设置就需要联系到serise
                        //比如说setSeriesPaint 设置数据线的颜色
        // 横轴名称(列名称)  
        String[] time = new String[15];
        String[] timeValue = { "00-01", "01-02", "02-03", "03-04", "04-05", "05-06",
                      "06-07", "07-08", "08-09", "09-10", "10-11", "11-12", "12-13",
                      "13-14", "14-15" };
        for (int i = 0; i < 15; i++) {
               time[i] = timeValue[i];
        }
        
        for (int i = 0; i < 15; i++) {
            dataset.addValue(vos.get(i).getRoundAttackField(),Teamabbr,time[i]);
            dataset.addValue(tis.get(i).getRoundAttackField(),All,time[i]);
     }
        return dataset;
	}
}
