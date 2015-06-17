package chartMaking;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;

public class ScatterPlotChartMaking {
	
	public ChartPanel makeChart(XYDataset xydataset){
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
		standardChartTheme.setExtraLargeFont(new Font("微软雅黑",Font.BOLD,15));
		standardChartTheme.setRegularFont(new Font("微软雅黑",Font.BOLD,15));
		standardChartTheme.setLargeFont(new Font("微软雅黑",Font.BOLD,15));
		ChartFactory.setChartTheme(standardChartTheme);
		JFreeChart  chart = ChartFactory.createScatterPlot(null, null, null,  xydataset,  
				PlotOrientation.VERTICAL, // 绘制方向  
				true, // 显示图例  
				true, // 采用标准生成器  
				false // 是否生成超链接  
				);  
		
	
		return new ChartPanel(chart);
	}
	
}
