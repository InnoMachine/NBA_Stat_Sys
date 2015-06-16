package businessLogic;

import java.util.ArrayList;

import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;

import vo.TeamGames;
import vo.TeamPerformanceInSingleGame;
import vo.TeamVo;
import vo.TotalInfo;
import chartMaking.LineChartMaking;
import chartMaking.ScatterPlotChartMaking;

public class ChartPanelMake {
	static Team_BS team_bs = new Team_BL();
	public ChartPanel getLineChartPanel(int number,String abbr){
		LineChartMaking lcm = new LineChartMaking();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset = dataset1();
		return lcm.makeChart(dataset);
	}
	
	public ChartPanel getScatterChartPanel(int number,String abbr){
		ScatterPlotChartMaking spcm = new ScatterPlotChartMaking();
		DefaultXYDataset dataset = new DefaultXYDataset();
		//dataset = dataset1();
		return spcm.makeChart(dataset);
	}
	
	
	public static DefaultCategoryDataset dataset1(){
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
            dataset.addValue(vos.get(i).getScoreField(), Teamabbr, time[i]);
            dataset.addValue(tis.get(i).getScoreField(), All, time[i]);
     }
        return dataset;
	}
	
	
}
