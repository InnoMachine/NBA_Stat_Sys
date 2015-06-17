package businessLogic;

import java.awt.Font;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

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
import vo.chiquareout;
import vo.regAnalysisout;
import vo.varAnakysisout;

public class countFuncs {
	BigDecimal b; 
	static Team_BS team_bs = new Team_BL();
	static Player_BS player_bs = new Player_BL();
	
	public static void main(String[] args)
    {
		Random rand = new Random();
	 ArrayList<PlayerVo> vo = team_bs.getPlayers("CLE");
	 ArrayList<TeamPerformanceInSingleGame>  tp= team_bs.getTeamPerformance("LAC","13-14");
	 ArrayList<TeamVo>teamlist=team_bs.getAllTeam();
	 ArrayList<PlayerVo> vl = player_bs.filterPlayerBy("F", "All", "threePointShotNumField", "");
	 int i =0;
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
	 
		
/*		DefaultXYDataset xy = new DefaultXYDataset();
		double data[][] = new double[2][tp.size()];
		
		for(TeamPerformanceInSingleGame temp:tp){
			data[1][i] = temp.getHitNum();
			data[0][i] = temp.getThreePointHitNum();
			i++;
		}
		xy.addSeries("", data);
		
		
		JFreeChart chart =ChartFactory.createScatterPlot("数据点图 ", "姓名", "产量", xy, PlotOrientation.VERTICAL, true, true, true);
        StandardChartTheme standardChartTheme=new StandardChartTheme("CN");         //设置标题字体
        standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));         //设置图例的字体
        standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));         //设置轴向的字体
        standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));         //应用主题样式
        ChartFactory.setChartTheme(standardChartTheme);   
       
        ChartFrame chartFrame=new ChartFrame("某公司人员组织数据图",chart); 
        //chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数的数据是放在窗口左上角的，不是正中间的标题。
        chartFrame.pack(); //以合适的大小展现图形
        chartFrame.setVisible(true);//图形是否可见
        */
	 /*for(PlayerVo temp:vo){
		 showMeanAndVar(temp.getName());
	 }*/
//	 double a[] = {20,30,20,24,25,31,40,22,23,33,33,33,33,28,29,30,28,29,29,27};
//	 PlayerVo v1 = vo.get(2);
//	 PlayerGames pg = player_bs.getPlayerPerformacne(v1.getName());
	 double b[]=new double [80];
	 i=0;
	 for(int k=0;k<80;k++){
		 b[i]=tp.get(k).getScore();
		 i++;
	 }
////	 for(TeamPerformanceInSingleGame temp:tp){
////		 b[i] = temp.getScore();
////		 i++;
////	 }
	 chisquare(b,5);
//	 interval_estimation3(b);
//	 double t[] = new double[20];
//	 double g[] = new double[20];
//	 for(i=0;i<20;i++){
//		 TeamPerformanceInSingleGame temp=tp.get(rand.nextInt(tp.size()));
//		 t[i]=temp.getScore();
//		 g[i]=temp.getHitRate();
//	 }
//	 leastSquare(g,t);
//	 System.out.println(correlationCoefficient(t, g));
//	 System.out.println(pearson_r(t, g));
	
	
        
    }
	//单因素方差检验
	public static varAnakysisout Single_factor_analysis_of_variance(double xij[][],int m,int r){
		double xi[] = new double[m],x=0;
		double xim[] = new double[m];
		for(int i=0;i<m;i++){
			for(int j=0;j<r;j++){
				xi[i]+=xij[i][j];
			}
			xim[i]=xi[i]/r;
			x+=xi[i];
		}
		double xm=x/(m*r);
		
		double SA=0,Se=0,ST=0;
		for(int i=0;i<m;i++){
			SA+=Math.pow((xim[i]-xm), 2);
		}
		SA=r*SA;
		for(int i=0;i<m;i++){
			for(int j=0;j<r;j++){
				Se+=Math.pow(xij[i][j]-xim[i], 2);
			}
		}
		ST=SA+Se;
		int fA=m-1,fT=m*r-1,fe=m*r-m;
		double VA = SA/(m-1);
		double Ve = Se/(m*r-m);
		double FA = VA/Ve;
		double F5 = F_square_distribution_table4("0.05",m*r-m);
		double F1 = F_square_distribution_table4("0.01", m*r-m);
		double xi2[] = new double[m];
		for(int i=0;i<m;i++){
			xi2[i]= Math.pow(xi[i], 2);
		}
		varAnakysisout rao = new varAnakysisout();
		rao.xi = xi;
		rao.xi = xi2;
		rao.xij = xij;
		rao.F = FA;
		rao.F1 = F1;
		rao.F5 = F5;
		rao.SA = SA;
		rao.Se = Se;
		rao.ST = ST;
		rao.VA = SA/(m-1);
		rao.Ve = Se/(m*r-m);
		
		return rao;
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
	
	public double Standard_normal_distribution_table(double x){
		if(x>0){
			double v=NormalDistribution(0,1,0,x)+0.5;
			b = new BigDecimal(v);
			double f = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			return f;
		}
		else if(x<0){
			double v=NormalDistribution(0,1,x,0);
			b = new BigDecimal(v);
			double f = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
			return f;
		}
		else {
			return 0.5000;
		}
	}
	public static double F_square_distribution_table1(String alpha,int n){
		double F [][] =new double [2][20];
		F[0][0]=161.448;F[0][1]=18.513;F[0][2]=10.128;F[0][3]=7.709;F[0][4]=6.608;
		F[0][5]=5.987;F[0][6]=5.591;F[0][7]=5.318;F[0][8]=5.117;F[0][9]=4.965;
		F[0][10]=4.844;F[0][11]=4.747;F[0][12]=4.667;F[0][13]=4.600;F[0][14]=4.543;
		F[0][15]=4.494;F[0][16]=4.451;F[0][17]=4.414;F[0][18]=4.381;F[0][19]=4.351;
		
		F[1][0]=4051.181;F[1][1]=98.503;F[1][2]=34.116;F[1][3]=21.198;F[1][4]=16.258;
		F[1][5]=13.745;F[1][6]=12.246;F[1][7]=11.259;F[1][8]=10.561;F[1][9]=10.044;
		F[1][10]=9.646;F[1][11]=9.330;F[1][12]=9.074;F[1][13]=8.862;F[1][14]=8.683;
		F[1][15]=8.531;F[1][16]=8.400;F[1][17]=8.285;F[1][18]=8.185;F[1][19]=8.096;
		
		switch (alpha) {
		case "0.05":return F[0][n-1];
		case "0.01":return F[1][n-1];
		default:
		return 0;
		}
	}
	public static double F_square_distribution_table4(String alpha,int n){
		double F [][] =new double [2][20];
		F[0][0]=224.583;F[0][1]=19.247;F[0][2]=9.117;F[0][3]=6.388;F[0][4]=5.192;
		F[0][5]=4.534;F[0][6]=4.120;F[0][7]=3.838;F[0][8]=3.633;F[0][9]=3.478;
		F[0][10]=3.357;F[0][11]=3.259;F[0][12]=3.179;F[0][13]=3.112;F[0][14]=3.056;
		F[0][15]=3.007;F[0][16]=2.965;F[0][17]=2.928;F[0][18]=2.895;F[0][19]=2.866;
		
		F[1][0]=5624.583;F[1][1]=99.249;F[1][2]=28.710;F[1][3]=15.977;F[1][4]=11.392;
		F[1][5]=9.148;F[1][6]=7.847;F[1][7]=7.006;F[1][8]=6.422;F[1][9]=5.994;
		F[1][10]=5.668;F[1][11]=5.412;F[1][12]=5.205;F[1][13]=5.035;F[1][14]=4.893;
		F[1][15]=4.773;F[1][16]=4.669;F[1][17]=4.579;F[1][18]=4.500;F[1][19]=4.431;
		
		switch (alpha) {
		case "0.05":return F[0][n-1];
		case "0.01":return F[1][n-1];
		default:
		return 0;
		}
	}
	public static double Chi_square_distribution_table(String alpha,int n){
		double chi[][] = new double[80][12];
		chi[0][0]=2.7055;chi[0][1]=3.8415;chi[0][2]=5.0239;chi[0][3]=6.6349;
		chi[0][4]=7.8794;chi[0][5]=10.8276;chi[0][6]=0.0158;chi[0][7]=0.0039;
		chi[0][8]=0.0010;chi[0][9]=0.0002;chi[0][10]=0.0000;chi[0][11]=0.0000;
		
		chi[1][0]=4.6052;chi[1][1]=5.9915;chi[1][2]=7.3778;chi[1][3]=9.2103;
		chi[1][4]=10.5966;chi[1][5]=16.2662;chi[1][6]=0.2107;chi[1][7]=0.1026;
		chi[1][8]=0.0506;chi[1][9]=0.0201;chi[1][10]=0.0100;chi[1][11]=0.0020;
		
		
		
		chi[79][0]=96.5782;chi[79][1]=101.8795;chi[79][2]=106.6286;chi[79][3]=112.3288;
		chi[79][4]=116.3211;chi[79][5]=124.8392;chi[79][6]=64.2778;chi[79][7]=60.3915;
		chi[79][8]=57.1532;chi[79][9]=53.5401;chi[79][10]=51.1719;chi[79][11]=46.5199;
		
		switch (alpha) {
		case "0.1":return chi[n-1][0];
		case "0.05":return chi[n-1][1];
		case "0025":return chi[n-1][2];
		case "0.01":return chi[n-1][3];
		case "0.005":return chi[n-1][4];
		case "0.001":return chi[n-1][5];
		case "0.9":return chi[n-1][6];
		case "0.95":return chi[n-1][7];
		case "0.975":return chi[n-1][8];
		case "0.99":return chi[n-1][9];
		case "0.995":return chi[n-1][10];
		case "0.999":return chi[n-1][11];
		default:
			return 0;
		}
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
	public static chiquareout chisquare(double a[],int step){
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
		int qj[]=new int[i];
		for(int k=0;k<i;k++){
			ni[k]=0;
			qj[k]=k;
		}
		double pi[]=new double[i];
		for(int k=0;k<i;k++){
			pi[k]=0;
		}
		int n=0;
		for(int k=0;k<i;k++){
			ni[n]+=c[k];
			pi[n]+=NormalDistribution(miu,sigma2,step*k,step*(k+1));
			if(ni[n]>=5){
				n++;
				qj[n] =k;
			}
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
		double zuihou[] = new double [n+1];
		for(int k=0;k<n+1;k++){
			zuihou[k] = Math.pow(ni[k], 2)/(a.length*pi[k]);
			x[k]+=zuihou[k];
			kf+=x[k];
		}
		kf-=a.length;
		
		
		//
		String fengzu[] = new String[n+1];
		String qujian[] = new String[n+1];
		for(int k=0;k<n;k++){
			qujian[k] = "["+(""+qj[k]*step)+","+(""+qj[k+1]*step)+"]";
			fengzu[k] = (""+(qj[k]+1))+"-"+(""+(qj[k+1]));
		}
		fengzu[n] = (""+(qj[n]+1))+"-"+(""+(i));
		qujian[n] = "["+(""+qj[n]*step)+","+(""+i*step)+"]";
		double nii[] = new double[n+1];
		double pii[] = new double[n+1];
		double npii[] = new double [n+1];
		for(int k=0;k<n+1;k++){
			nii[k] = ni[k];
			pii[k] = pi[k];
			npii[k] = ni[k]*pi[k];
		}
		chiquareout co = new chiquareout();
		co.fengzu = fengzu;
		co.qujian = qujian;
		co.ni = nii;
		co.pi = pii;
		co.npi = npii;
		co.zuihou = zuihou;
		co.kafang = kf;
		return co;
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
	public static regAnalysisout leastSquare(double x[],double y[]){
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
		regAnalysisout rao = new regAnalysisout();
		rao.F = F;
		rao.F1 = F_square_distribution_table1("0.01", n-2);
		rao.F5 = F_square_distribution_table1("0.05", n-2);
		rao.pearson_r = pearson_r(x, y);
		rao.SR = SR;
		rao.Se = Se;
		rao.ST = ST;
		rao.VR = SR;
		rao.Ve = Se/(n-2);
		rao.ρ = correlationCoefficient(x, y);
		rao.r2 = r2;
		rao.Sy = Sy;
		rao.n = n;
		return rao;
//		System.out.println("F值："+F);
//		System.out.println("F0.01(1,n-2)："+F_square_distribution_table1("0.01", n-2));
//		System.out.println("F0.05(1,n-2)："+F_square_distribution_table1("0.05", n-2));
//		System.out.println("决定系数："+r2);
//		System.out.println("标准残差："+Sy);
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
 public static void interval_estimation3(double a[]){
	 double xm = meanValue(a);
	 double n=a.length;
	 double S = Math.sqrt(variance(a));
	 System.out.println("("+(xm-1.96*S/Math.sqrt(n))+","+(xm+1.96*S/Math.sqrt(n))+")");
	 
 }


}
