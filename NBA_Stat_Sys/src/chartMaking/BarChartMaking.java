package chartMaking;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

public class BarChartMaking {
	public ChartPanel makeChart(CategoryDataset dataset){
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("微软雅黑",Font.BOLD,15));
		standardChartTheme.setRegularFont(new Font("微软雅黑",Font.BOLD,15));
		standardChartTheme.setLargeFont(new Font("微软雅黑",Font.BOLD,15));
		ChartFactory.setChartTheme(standardChartTheme);
		 JFreeChart chart=ChartFactory.createBarChart(null, null, 
	                null, dataset, PlotOrientation.VERTICAL, true, true, false); //创建一个JFreeChart
	       
	        return new ChartPanel(chart);
	}
}
