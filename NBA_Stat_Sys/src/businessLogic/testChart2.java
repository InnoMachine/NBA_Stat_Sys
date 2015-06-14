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
import vo.PlayerGames;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import vo.TeamVo;

public class testChart2 {
	static Team_BS team_bs = new Team_BL();
	static Player_BS player_bs = new Player_BL();
	public static void main(String[] args)
    {
	
	 ArrayList<PlayerVo> vo = team_bs.getPlayers("CLE");
	 ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance("LAC");
	 ArrayList<TeamVo>teamlist=team_bs.getAllTeam();
	 ArrayList<PlayerVo> vl = player_bs.filterPlayerBy("F", "All", "threePointShotNumField", "");
//	 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//	 for(TeamVo temp:teamlist){
//		 dataset.setValue(temp.getScoreField(),  "score",temp.getAbbreviation());
//		 dataset.setValue(temp.getAssistanceField(),  "assist",temp.getAbbreviation());
//		 dataset.setValue(temp.getThreePointShotNumField(),  "threeshot",temp.getAbbreviation());
//	 }
//	 
//		JFreeChart chart = ChartFactory.createBarChart("team ", "name", "",  
//				                dataset, PlotOrientation.VERTICAL, true, false	,false);
//		CategoryPlot cpp = chart.getCategoryPlot();
	 
		
		DefaultXYDataset xy = new DefaultXYDataset();
		double data[][] = new double[2][tp.size()];
		int i =0;
		for(TeamPerformanceInSingleGame temp:tp){
			data[1][i] = temp.getHitNum();
			data[0][i] = temp.getThreePointHitNum();
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
        
	 /*for(PlayerVo temp:vo){
		 showMeanAndVar(temp.getName());
	 }*/
	 double a[] = {20,30,20,24,25,31,40,22,23,33,33,33,33,28,29,30,28,29,29,27};
	 PlayerVo v1 = vo.get(2);
	 PlayerGames pg = player_bs.getPlayerPerformacne(v1.getName());
	 double b[]=new double [pg.getGames().size()];
	 i=0;
//	 for(PlayerPerformanceInSingleGame temp:pg.getGames()){
//		 b[i] = temp.getScore();
//		 i++;
//	 }
	 double t[] = new double[tp.size()];
	 double g[] = new double[tp.size()];
	 for(TeamPerformanceInSingleGame temp:tp){
		t[i]=temp.getHitNum();
		g[i]=temp.getThreePointHitNum();
		i++;
	 }
//	 System.out.println(correlationCoefficient(t, g));
//	 System.out.println(pearson_r(t, g));
	 leastSquare(g,t);
	
        
    }
	public static void showMeanAndVar(String name){
		PlayerGames games=player_bs.getPlayerPerformacne(name);
		 ArrayList<PlayerPerformanceInSingleGame> ppg=games.getGames();
		 double a[] = new double[ppg.size()];
		 int i=0;
		 for(PlayerPerformanceInSingleGame t:ppg){
			 a[i]=(double )t.getScore();
			 i++;
		 }
		 System.out.print(name+"         ");
		 System.out.print(meanValue(a)+"         ");
		 System.out.println(samplevariance(a));
	}
	//均值
	public static double meanValue(double a[]){
		int n=a.length;
		if(n==0)
			return 0;
		double v=0;
		for(int i=0;i<n;i++){
			v+=a[i];
		}
		return v/n;
	}
	//样本方差
	public static double  samplevariance (double a[]){
		int n=a.length;
		if(n==0||n==1)
			return 0;
		double v=0;
		double m=meanValue(a);
		for(int i=0;i<n;i++){
			v+=Math.pow((a[i]-m),2);
		}
		return v/(n-1);
	}
	//方差
	public static double  variance (double a[]){
		int n=a.length;
		if(n==0||n==1)
			return 0;
		double v=0;
		double m=meanValue(a);
		for(int i=0;i<n;i++){
			v+=Math.pow((a[i]-m),2);
		}
		return v/n;
	}
	public static double max(double a[]){
		double b=0;
		for(int i=0;i<a.length;i++){
			if(b<a[i])
				b=a[i];
		}
		return b;
	}
	//卡方非参检验值
	public static double chisquare(double a[],int step){
		double miu=meanValue(a);
		double sigma2=variance(a);
		int i=0;
		for(;step*i<max(a)+0.0001;i++){
		}
		int c[]=new int [i];
		for(int k=0;k<i;k++){
			c[k]=0;
		}
		for(int k=0;k<a.length;k++){
			for(int l=0;l<i;l++){
				if(a[k]>=l*step&&a[k]<(l+1)*step){
					c[l]++;
					break;
				}
			}
		}
		int ni[]=new int[i];
		for(int k=0;k<i;k++){
			ni[k]=0;
		}
		double pi[]=new double[i];
		for(int k=0;k<i;k++){
			pi[k]=0;
		}
		int n=0;
		for(int k=0;k<i;k++){
			ni[n]+=c[k];
			pi[n]+=NormalDistribution(miu,sigma2,step*k,step*(k+1));
			if(ni[n]>=5)
				n++;
			
		}
		if(ni[n]<5){
			ni[n-1]+=ni[n];
			ni[n]=0;
			pi[n-1]+=pi[n];
			pi[n]=0;
			n--;
		}
		double x[] = new double [n+1];
		for(int k=0;k<n+1;k++){
			x[k]=0;
		}
		double kf = 0;
		for(int k=0;k<n+1;k++){
			x[k]+=Math.pow(ni[k], 2)/(a.length*pi[k]);
			kf+=x[k];
		}
		kf-=a.length;
		return kf;
	}
	//积分
	public static double  integration (double a,double b){
		double step=0.00001;
		double v=0;
		for(double d=a;d<b;d+=step){
			double s =0.5*(absolute(Func(d))+absolute(Func(d+step)))*step;
			v+=s;
		}
		return v;
	}
	public static double Func(double x){
		return x*x;
	}
	//绝对值
	public static double absolute(double x){
		if(x<0)
			return -x;
		else {
			return x;
		}
	}
	//正态分布
	public static double NormalDistribution (double miu,double sigma2,double a,double b){
		double step=0.00001;
		double v=0;
		for(double d=a;d<b;d+=step){
			double s =0.5*(absolute(FuncNormal(miu,sigma2,d))+absolute(FuncNormal(miu,sigma2,d+step)))*step;
			v+=s;
		}
		return v;
	}
	//正态分布
	public static double FuncNormal(double miu,double sigma2,double x){
		double f = Math.pow(Math.E, -Math.pow((x-miu), 2)/(2*sigma2))/(Math.sqrt(2*Math.PI*sigma2));
		return f;
	}
	
	public static double pearson_r(double x[],double y[]){
		int n=x.length;
		double xys=0,xs = 0,ys=0;
		double x2s=0,y2s=0;
		double r=0;
		for(int i=0;i<n;i++){
			xs+=x[i];
			ys+=y[i];
			xys+=x[i]*y[i];
			x2s+=Math.pow(x[i], 2);
			y2s+=Math.pow(y[i], 2);
		}
		r=n*xys-xs*ys;
		r=r/(Math.sqrt((n*x2s-xs*xs)*(n*y2s-ys*ys)));
		return r;
	}
	//协方差
	public static double covariance(double x[],double y[]){
		double ex=meanValue(x);
		double ey=meanValue(y);
		double xy[] = new double[x.length];
		for(int i=0;i<xy.length;i++){
			xy[i]=x[i]*y[i];
		}
		double exy=meanValue(xy);
		return exy-ex*ey;
	}
	//相关系数
	public static double correlationCoefficient(double x[],double y[]){
		double covxy = covariance(x,y); 
		return covxy/(Math.sqrt(variance(x)*variance(y)));
	}
	//最小二乘y=a+bx
	public static void leastSquare(double x[],double y[]){
		int n =x.length;
		double nxy=0,nx=0,ny=0;
		double nx2=0;
		for(int i=0;i<n;i++){
			nxy+=x[i]*y[i];
			nx+=x[i];
			ny+=y[i];
			nx2+=x[i]*x[i];
		}
		double lxy=nxy-nx*ny/n;
		double lxx=nx2-nx*nx/n;
		double b=lxy/lxx;
		double a=ny/n-b*nx/n;
		System.out.println("y="+a+"+"+b+"x");
		//显著性检验
		double ST=0,SR=0,Se=0;
		double ym = meanValue(y);
		double y1[]=new double[n];
		for(int i=0;i<n;i++){
			y1[i] = a+b*x[i];
		}
		for(int i=0;i<n;i++){
			ST+=Math.pow((y[i]-ym),2);
			SR+=Math.pow((y1[i]-ym),2);
			Se+=Math.pow((y[i]-y1[i]),2);
		}
		double r2=SR/ST;
		double Sy=Math.sqrt(Se/(n-2));
		double F =SR/(Se/(n-2));
		System.out.println("F值："+F);
		System.out.println("Fα(80)："+101.5782);
		System.out.println("决定系数："+r2);
		System.out.println("标准残差："+Sy);
	}
	//双曲线模型1/y=a+b*1/x
	public static void leastSquare_hyperbolic(double x[],double y[]){
		
		int n =x.length;
		double x0[]=new double[n];
		double y0[]=new double[n];
		for(int i=0;i<n;i++){
			x0[i]=1/x[i];
			y0[i]=1/y[i];
		}
		double nxy=0,nx=0,ny=0;
		double nx2=0;
		for(int i=0;i<n;i++){
			nxy+=x0[i]*y0[i];
			nx+=x0[i];
			ny+=y0[i];
			nx2+=x0[i]*x0[i];
		}
		double lxy=nxy-nx*ny/n;
		double lxx=nx2-nx*nx/n;
		double b=lxy/lxx;
		double a=ny/n-b*nx/n;
		System.out.println("y'="+a+"+"+b+"x'");
		System.out.println("1/y="+a+"+"+b+"1/x");
		//显著性检验
		double ST=0,SR=0,Se=0;
		double ym = meanValue(y);
		double y1[]=new double[n];
		for(int i=0;i<n;i++){
			y1[i] = 1/(a+b*x0[i]);
		}
		for(int i=0;i<n;i++){
			ST+=Math.pow((y[i]-ym),2);
			SR+=Math.pow((y1[i]-ym),2);
			Se+=Math.pow((y[i]-y1[i]),2);
		}
		double r2=SR/ST;
		double Sy=Math.sqrt(Se/(n-2));
		double F =SR/(Se/(n-2));
		System.out.println("F值："+F);
		System.out.println("Fα(80)："+101.5782);
		System.out.println("决定系数："+r2);
		System.out.println("标准残差："+Sy);
	}

	//指数模型y=ae^(bx)
public static void leastSquare_exponent(double x[],double y[]){
		int n =x.length;
		double y0[]=new double[n];
		for(int i=0;i<n;i++){
			y0[i]=Math.log(y[i]);
			
		}
		double nxy=0,nx=0,ny=0;
		double nx2=0;
		for(int i=0;i<n;i++){
			nxy+=x[i]*y0[i];
			nx+=x[i];
			ny+=y0[i];
			nx2+=x[i]*x[i];
		}
		double lxy=nxy-nx*ny/n;
		double lxx=nx2-nx*nx/n;
		double b=lxy/lxx;
		double a0=ny/n-b*nx/n;
		System.out.println("y'="+a0+"+"+b+"x'");
		double a=Math.pow(Math.E, a0);
		System.out.println("y="+a+"*e^("+b+"*x)");
		//显著性检验
		double ST=0,SR=0,Se=0;
		double ym = meanValue(y);
		double y1[]=new double[n];
		for(int i=0;i<n;i++){
			y1[i] =Math.pow(Math.E, a0+b*x[i]) ;
		}
		for(int i=0;i<n;i++){
			ST+=Math.pow((y[i]-ym),2);
			SR+=Math.pow((y1[i]-ym),2);
			Se+=Math.pow((y[i]-y1[i]),2);
		}
		double r2=SR/ST;
		double Sy=Math.sqrt(Se/(n-2));
		double F =SR/(Se/(n-2));
		System.out.println("F值："+F);
		System.out.println("Fα(80)："+101.5782);
		System.out.println("决定系数："+r2);
		System.out.println("标准残差："+Sy);
	}
}
