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
			value[k] = countFuncs.variance(s);
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
			value[k] = countFuncs.variance(s);
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
		ArrayList<TeamVo> vos = team_bs.getTeamByAbbrA("SAS");
		ArrayList<TotalInfo> tis = team_bs.getTeamTotalInfos();
		
		// 曲线名称
		String All = "All";
        String Teamabbr = "SAS";  // series指的就是报表里的那条数据线 
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
            //dataset.addValue((double)vos.get(i).getAssistanceField()/(vos.get(i).getShotNumField()-vos.get(i).getAssistanceField()),Teamabbr,time[i]);
            dataset.addValue(vos.get(i).getOffensiveReboundField()/vos.get(i).getDefensiveReboundField(), Teamabbr, time[i]);
        	// dataset.addValue((double)tis.get(i).getAssistanceField()/tis.get(i).get,All,time[i]);
     }
        return dataset;
	}
	public static DefaultCategoryDataset dataset4(){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		// 曲线名称
		ArrayList<String> abbrs = team_bs.getTeamAbbrs();
		String All = "All";
        String Teamabbr = "SAS";  // series指的就是报表里的那条数据线 
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
        ArrayList<TeamGames> vos = team_bs.getTeamGames("SAS");
		for(int i=0;i<15;i++){
			ArrayList<TeamPerformanceInSingleGame> tps = vos.get(i).getGames();
			double vm[] = new double[tps.size()]; 
			int p=0;
			for(TeamPerformanceInSingleGame temp:tps){
				double v[]=new double[5];
				for(int k=0;k<5;k++){
					v[k] = temp.getFirstonList().get(k).getScore();
				}
				vm[p]=countFuncs.variance(v);
				p++;
			}
			dataset.addValue(countFuncs.meanValue(vm),Teamabbr,time[i]);
		}
		 vos = team_bs.getTeamGames("LAL");
		 Teamabbr = "LAL";
			for(int i=0;i<15;i++){
				ArrayList<TeamPerformanceInSingleGame> tps = vos.get(i).getGames();
				double vm[] = new double[tps.size()]; 
				int p=0;
				for(TeamPerformanceInSingleGame temp:tps){
					double v[]=new double[5];
					for(int k=0;k<5;k++){
						v[k] = temp.getFirstonList().get(k).getScore();
					}
					vm[p]=countFuncs.variance(v);
					p++;
				}
				dataset.addValue(countFuncs.meanValue(vm),Teamabbr,time[i]);
			}
			for(int i=0;i<15;i++){
				double pm[] = new double[30];
				 for(int p=0;p<30;p++){
					 vos = team_bs.getTeamGames(abbrs.get(p));
					 ArrayList<TeamPerformanceInSingleGame> tps = vos.get(i).getGames();
						double vm[] = new double[tps.size()]; 
						int g=0;
						for(TeamPerformanceInSingleGame temp:tps){
							double v[]=new double[5];
							for(int k=0;k<5;k++){
								v[k] = temp.getFirstonList().get(k).getScore();
							}
							vm[g]=countFuncs.variance(v);
							g++;
						}
						pm[p] = countFuncs.meanValue(vm);
			        }
				
				dataset.addValue(countFuncs.meanValue(pm),All,time[i]);
			}
       

        return dataset;
	}
}
