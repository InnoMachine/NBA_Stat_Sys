package chartMaking;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class ChartMaking {
	
	public ChartMaking(){
		
	}
	
	
	public ChartPanel makingChartPanel(JFreeChart chart){
		return new ChartPanel(chart);
	}
}
