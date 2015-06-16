package chartMaking;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartMaking {
	

	public PieChartMaking(){
		   
	}
	
	private ChartPanel makeChart(DefaultPieDataset getDataset){
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
	 	standardChartTheme.setExtraLargeFont(new Font("微软雅黑",Font.BOLD,15));
	 	standardChartTheme.setRegularFont(new Font("微软雅黑",Font.BOLD,15));
	 	standardChartTheme.setLargeFont(new Font("微软雅黑",Font.BOLD,15));
	 	ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart chart=ChartFactory.createPieChart(null, getDataset,true,true,false);
		//set plot
		PiePlot plot=(PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("微软雅黑",Font.BOLD,10));
		//set legend
		LegendTitle legend=chart.getLegend(0);
		legend.setItemFont(new Font("微软雅黑",Font.BOLD,10));
		return new ChartPanel(chart);
	}
	

	

	
}
