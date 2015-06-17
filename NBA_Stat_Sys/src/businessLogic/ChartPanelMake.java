package businessLogic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

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
	BigDecimal b; 
	Random rand = new Random();
	static Team_BS team_bs = new Team_BL();
	public ChartPanel getLineChartPanel(int number,String abbr){
		LineChartMaking lcm = new LineChartMaking();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset = dataset1(number,abbr);
		return lcm.makeChart(dataset);
	}
	
	public ChartPanel getScatterChartPanel(int number,String abbr,String season){
		ScatterPlotChartMaking spcm = new ScatterPlotChartMaking();
		DefaultXYDataset dataset = new DefaultXYDataset();
		ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance(abbr,season);
		int num=tp.size();
		 double b[]=new double [num];
		 int i=0;
		 for(int k=0;k<num;k++){
			 int t =rand.nextInt(num);
			 b[i]=tp.get(t).getScore();
			 i++;
		 }
		 double data[][] = new double[2][num];
			for(TeamPerformanceInSingleGame temp:tp){
				data[1][i] = temp.getHitNum();
				data[0][i] = temp.getThreePointHitNum();
				i++;
			}
			dataset.addSeries("", data);
		return spcm.makeChart(dataset);
	}
	
	
	public static DefaultCategoryDataset dataset1(int number,String abbr){
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<TeamVo> vos = team_bs.getTeamByAbbrA(abbr);
		ArrayList<TotalInfo> tis = team_bs.getTeamTotalInfos();
		
		// 曲线名称
		String All = "All";
        String Teamabbr = abbr;  // series指的就是报表里的那条数据线 
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
        if(number==1){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getScoreField(), Teamabbr, time[i]);
                dataset.addValue(tis.get(i).getScoreField(), All, time[i]);
         }
        }else if(number==2){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getRoundAttackField(), Teamabbr, time[i]);
                dataset.addValue(tis.get(i).getRoundAttackField(), All, time[i]);
                }
        }
        else if(number==3){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getAssistanceField(), Teamabbr, time[i]);
                dataset.addValue(tis.get(i).getAssistanceField(), All, time[i]);
                }
        }
        else if(number==4){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getFreeThrowShotNumField(), Teamabbr, time[i]);
                dataset.addValue((double)tis.get(i).getFreeshot()/tis.get(i).getGamenum(), All, time[i]);
                }
        }
        else if(number==5){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getThreePointHitNumField()*3/vos.get(i).getScoreField(), Teamabbr, time[i]);
                dataset.addValue(tis.get(i).getThree()*3/tis.get(i).getScore(), All, time[i]);
                }
        }
        else if(number==6){
        	for (int i = 0; i < 15; i++) {
                dataset.addValue(vos.get(i).getAssistanceField()/vos.get(i).getShotNumField(), Teamabbr, time[i]);
                dataset.addValue(tis.get(i).getAssistanceField()/tis.get(i).getShotField(), All, time[i]);
                }
        }
        else if(number==7){
        	ArrayList<String> abbrs = team_bs.getTeamAbbrs();
        	 ArrayList<TeamGames> gms = team_bs.getTeamGames(abbr);
        	 ArrayList<TeamPerformanceInSingleGame> tps = new ArrayList<TeamPerformanceInSingleGame> ();
        	for(int i=0;i<15;i++){
				tps = gms.get(i).getGames();
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
					 gms = team_bs.getTeamGames(abbrs.get(p));
					tps = gms.get(i).getGames();
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
        }
        
        return dataset;
	}
	
	public static DefaultCategoryDataset xydataset1(){
		
		return null;
	}
	
}
