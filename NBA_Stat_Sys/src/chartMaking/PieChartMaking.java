package chartMaking;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class PieChartMaking {
	
	public static void main(String[] args) throws IOException{
		PieChartMaking making = new PieChartMaking("Pie Chart Test!");
	}
	
	public PieChartMaking(String chartTitle) throws IOException{
		chart2PNG(makeChart(chartTitle));    
	}
	
	private JFreeChart makeChart(String chartTitle){
		JFreeChart chart=ChartFactory.createPieChart(chartTitle, getDataset(),true,true,false);
		chart.setTitle(new TextTitle(chartTitle,new Font("微软雅黑",Font.BOLD,10)));
		//set plot
		PiePlot plot=(PiePlot) chart.getPlot();
		plot.setLabelFont(new Font("微软雅黑",Font.BOLD,10));
		//set legend
		LegendTitle legend=chart.getLegend(0);
		legend.setItemFont(new Font("微软雅黑",Font.BOLD,10));
		return chart;
	}
	
	private void chart2PNG(JFreeChart chart) throws IOException{
	
		OutputStream os = new FileOutputStream("ChartPNG/"+chart.getTitle()+".png");
		ChartUtilities.writeChartAsPNG(os, chart, 500, 500);
		os.close();
	}
	
	private DefaultPieDataset getDataset(){
		 DefaultPieDataset dpd=new DefaultPieDataset();
		 //add data!!!
		 
		 //test
		 dpd.setValue("player1", 20);
		 dpd.setValue("player2", 30);
		 dpd.setValue("player3", 10);
		 dpd.setValue("player4", 80);
		 dpd.setValue("player5", 40);
		 dpd.setValue("player6", 100); 
		 
		 return dpd;
	}
	

	
}
