package ui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;

public class TeamButtonsPanel extends JPanel{
	int X;
	int Y;
	static TeamInfoPanel atlInfoPanel;
	static TeamInfoPanel bknInfoPanel;
	static TeamInfoPanel bosInfoPanel;
	static TeamInfoPanel chaInfoPanel;
	static TeamInfoPanel chiInfoPanel;
	static TeamInfoPanel cleInfoPanel;
	static TeamInfoPanel dalInfoPanel;
	static TeamInfoPanel denInfoPanel;
	static TeamInfoPanel detInfoPanel;
	static TeamInfoPanel gswInfoPanel;
	static TeamInfoPanel houInfoPanel;
	static TeamInfoPanel indInfoPanel;
	static TeamInfoPanel lacInfoPanel;
	static TeamInfoPanel lalInfoPanel;
	static TeamInfoPanel memInfoPanel;
	static TeamInfoPanel miaInfoPanel;
	static TeamInfoPanel milInfoPanel;
	static TeamInfoPanel minInfoPanel;
	static TeamInfoPanel nopInfoPanel;
	static TeamInfoPanel nykInfoPanel;
	static TeamInfoPanel okcInfoPanel;
	static TeamInfoPanel orlInfoPanel;
	static TeamInfoPanel phiInfoPanel;
	static TeamInfoPanel phxInfoPanel;
	static TeamInfoPanel porInfoPanel;
	static TeamInfoPanel sacInfoPanel;
	static TeamInfoPanel sasInfoPanel;
	static TeamInfoPanel torInfoPanel;
	static TeamInfoPanel utaInfoPanel;
	static TeamInfoPanel wasInfoPanel;
	
	public TeamButtonsPanel(int X,int Y,JFrame mainFrame,JPanel previousPanel){
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.setBounds(0, 0, X * 967 / 1366, Y * 240 / 768);
		
		JLabel label = new JLabel("-------------------------东部球队-------------------------");
		label.setFont(new Font("微软雅黑",1,15));
		label.setForeground(Color.white);
		label.setBounds(X*47/1366, Y*1/768, X*420/1366, Y*20/768);
		add(label);
		
		JLabel label_1 = new JLabel("-----------------------西部球队-------------------------");
		label_1.setForeground(Color.white);
		label_1.setFont(new Font("微软雅黑",1,15));
		label_1.setBounds(X*518/1366, Y*1/768, X*420/1366, Y*20/768);
		add(label_1);
		
		JButton eastTeambtn1 = new JButton();
		eastTeambtn1.setBounds(X*47/1366, Y*30/768, X*60/1366, Y*60/768);
		eastTeambtn1.setContentAreaFilled(false);
		eastTeambtn1.setBorderPainted(false);
		eastTeambtn1.setOpaque(false);
		eastTeambtn1.addActionListener(e->(phiInfoPanel=new TeamInfoPanel("PHI",mainFrame,previousPanel)));
		add(eastTeambtn1);
		ImageIcon eastTeamImg1 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "PHI"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn1.setIcon(eastTeamImg1);	
		
		JButton eastTeambtn2 = new JButton();
		eastTeambtn2.setBounds(X*130/1366, Y*30/768, X*60/1366, Y*60/768);
		eastTeambtn2.setContentAreaFilled(false);
		eastTeambtn2.setBorderPainted(false);
		eastTeambtn2.setOpaque(false);
		eastTeambtn2.addActionListener(e->(bosInfoPanel=new TeamInfoPanel("BOS",mainFrame,previousPanel)));
		add(eastTeambtn2);
		ImageIcon eastTeamImg2 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "BOS"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn2.setIcon(eastTeamImg2);	
		
		JButton eastTeambtn3 = new JButton();
		eastTeambtn3.setBounds(X*213/1366, Y*30/768, X*60/1366, Y*60/768);
		eastTeambtn3.setContentAreaFilled(false);
		eastTeambtn3.setBorderPainted(false);
		eastTeambtn3.setOpaque(false);
		eastTeambtn3.addActionListener(e->(nykInfoPanel=new TeamInfoPanel("NYK",mainFrame,previousPanel)));
		add(eastTeambtn3);
		ImageIcon eastTeamImg3 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "NYK"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn3.setIcon(eastTeamImg3);	
		
		JButton eastTeambtn4 = new JButton();
		eastTeambtn4.setBounds(X*296/1366, Y*30/768, X*60/1366, Y*60/768);
		eastTeambtn4.setContentAreaFilled(false);
		eastTeambtn4.setBorderPainted(false);
		eastTeambtn4.setOpaque(false);
		eastTeambtn4.addActionListener(e->(bknInfoPanel=new TeamInfoPanel("BKN",mainFrame,previousPanel)));
		add(eastTeambtn4);
		ImageIcon eastTeamImg4 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "BKN"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn4.setIcon(eastTeamImg4);	
		
		JButton eastTeambtn5 = new JButton();
		eastTeambtn5.setBounds(X*379/1366, Y*30/768, X*60/1366, Y*60/768);
		eastTeambtn5.setContentAreaFilled(false);
		eastTeambtn5.setBorderPainted(false);
		eastTeambtn5.setOpaque(false);
		eastTeambtn5.addActionListener(e->(torInfoPanel=new TeamInfoPanel("TOR",mainFrame,previousPanel)));
		add(eastTeambtn5);
		ImageIcon eastTeamImg5 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "TOR"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn5.setIcon(eastTeamImg5);	
		
		JButton eastTeambtn6 = new JButton();
		eastTeambtn6.setBounds(X*47/1366, Y*101/768, X*60/1366, Y*60/768);
		eastTeambtn6.setContentAreaFilled(false);
		eastTeambtn6.setBorderPainted(false);
		eastTeambtn6.setOpaque(false);
		eastTeambtn6.addActionListener(e->(chaInfoPanel=new TeamInfoPanel("CHA",mainFrame,previousPanel)));
		add(eastTeambtn6);
		ImageIcon eastTeamImg6 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "CHA"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn6.setIcon(eastTeamImg6);	
		
		JButton eastTeambtn7 = new JButton();
		eastTeambtn7.setBounds(X*130/1366, Y*101/768, X*60/1366, Y*60/768);
		eastTeambtn7.setContentAreaFilled(false);
		eastTeambtn7.setBorderPainted(false);
		eastTeambtn7.setOpaque(false);
		eastTeambtn7.addActionListener(e->(atlInfoPanel=new TeamInfoPanel("ATL",mainFrame,previousPanel)));
		add(eastTeambtn7);
		ImageIcon eastTeamImg7 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "ATL"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn7.setIcon(eastTeamImg7);	
		
	
		JButton eastTeambtn8 = new JButton();
		eastTeambtn8.setBounds(X*213/1366,Y*101/768, X*60/1366, Y*60/768);
		eastTeambtn8.setContentAreaFilled(false);
		eastTeambtn8.setBorderPainted(false);
		eastTeambtn8.setOpaque(false);
		eastTeambtn8.addActionListener(e->(miaInfoPanel=new TeamInfoPanel("MIA",mainFrame,previousPanel)));
		add(eastTeambtn8);
		ImageIcon eastTeamImg8 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "MIA"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn8.setIcon(eastTeamImg8);	
		
		JButton eastTeambtn9 = new JButton();
		eastTeambtn9.setBounds(X*296/1366, Y*101/768, X*60/1366, Y*60/768);
		eastTeambtn9.setContentAreaFilled(false);
		eastTeambtn9.setBorderPainted(false);
		eastTeambtn9.setOpaque(false);
		eastTeambtn9.addActionListener(e->(orlInfoPanel=new TeamInfoPanel("ORL",mainFrame,previousPanel)));
		add(eastTeambtn9);
		ImageIcon eastTeamImg9 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "ORL"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn9.setIcon(eastTeamImg9);	
		
		JButton eastTeambtn10 = new JButton();
		eastTeambtn10.setBounds(X*379/1366, Y*101/768,  X*60/1366, Y*60/768);
		eastTeambtn10.setContentAreaFilled(false);
		eastTeambtn10.setBorderPainted(false);
		eastTeambtn10.setOpaque(false);
		eastTeambtn10.addActionListener(e->(wasInfoPanel=new TeamInfoPanel("WAS",mainFrame,previousPanel)));
		add(eastTeambtn10);
		ImageIcon eastTeamImg10 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "WAS"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn10.setIcon(eastTeamImg10);
		
		JButton eastTeambtn11 = new JButton();
		eastTeambtn11.setBounds(X*47/1366,Y*172/768,  X*60/1366, Y*60/768);
		eastTeambtn11.setContentAreaFilled(false);
		eastTeambtn11.setBorderPainted(false);
		eastTeambtn11.setOpaque(false);
		eastTeambtn11.addActionListener(e->(milInfoPanel=new TeamInfoPanel("MIL",mainFrame,previousPanel)));
		add(eastTeambtn11);
		ImageIcon eastTeamImg11 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "MIL"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn11.setIcon(eastTeamImg11);
		
		JButton eastTeambtn12 = new JButton();
		eastTeambtn12.setBounds(X*130/1366,Y*172/768,  X*60/1366, Y*60/768);
		eastTeambtn12.setContentAreaFilled(false);
		eastTeambtn12.setBorderPainted(false);
		eastTeambtn12.setOpaque(false);
		eastTeambtn12.addActionListener(e->(chiInfoPanel=new TeamInfoPanel("CHI",mainFrame,previousPanel)));
		add(eastTeambtn12);
		ImageIcon eastTeamImg12 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "CHI"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn12.setIcon(eastTeamImg12);
		
		
		
		JButton eastTeambtn13 = new JButton();
		eastTeambtn13.setBounds(X*213/1366,Y*172/768,  X*60/1366, Y*60/768);
		eastTeambtn13.setContentAreaFilled(false);
		eastTeambtn13.setBorderPainted(false);
		eastTeambtn13.setOpaque(false);
		eastTeambtn13.addActionListener(e->(cleInfoPanel=new TeamInfoPanel("CLE",mainFrame,previousPanel)));
		add(eastTeambtn13);
		ImageIcon eastTeamImg13 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "CLE"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn13.setIcon(eastTeamImg13);
		
		JButton eastTeambtn14 = new JButton();
		eastTeambtn14.setBounds(X*296/1366,Y*172/768,  X*60/1366, Y*60/768);
		eastTeambtn14.setContentAreaFilled(false);
		eastTeambtn14.setBorderPainted(false);
		eastTeambtn14.setOpaque(false);
		eastTeambtn14.addActionListener(e->(indInfoPanel=new TeamInfoPanel("IND",mainFrame,previousPanel)));
		add(eastTeambtn14);
		ImageIcon eastTeamImg14= new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "IND"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn14.setIcon(eastTeamImg14);
		
		JButton eastTeambtn15 = new JButton();
		eastTeambtn15.setBounds(X*379/1366,Y*172/768,  X*60/1366, Y*60/768);
		eastTeambtn15.setContentAreaFilled(false);
		eastTeambtn15.setBorderPainted(false);
		eastTeambtn15.setOpaque(false);
		eastTeambtn15.addActionListener(e->(detInfoPanel=new TeamInfoPanel("DET",mainFrame,previousPanel)));
		add(eastTeambtn15);
		ImageIcon eastTeamImg15 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "DET"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		eastTeambtn15.setIcon(eastTeamImg15);
	
		
		
		
	
		JButton westTeambtn1 = new JButton();
		westTeambtn1.setBounds(X*528/1366, Y*30/768,  X*60/1366, Y*60/768);
		westTeambtn1.setContentAreaFilled(false);
		westTeambtn1.setBorderPainted(false);
		westTeambtn1.setOpaque(false);
		westTeambtn1.addActionListener(e->(lacInfoPanel=new TeamInfoPanel("LAC",mainFrame,previousPanel)));
		add(westTeambtn1);
		ImageIcon westTeamImg1 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "LAC"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn1.setIcon(westTeamImg1);	
		
		JButton westTeambtn2 = new JButton();
		westTeambtn2.setBounds(X*611/1366, Y*30/768,  X*60/1366, Y*60/768);
		westTeambtn2.setContentAreaFilled(false);
		westTeambtn2.setBorderPainted(false);
		westTeambtn2.setOpaque(false);
		westTeambtn2.addActionListener(e->(lalInfoPanel=new TeamInfoPanel("LAL",mainFrame,previousPanel)));
		add(westTeambtn2);
		ImageIcon westTeamImg2 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "LAL"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn2.setIcon(westTeamImg2);	
		
		JButton westTeambtn3 = new JButton();
		westTeambtn3.setBounds(X*694/1366, Y*30/768,  X*60/1366, Y*60/768);
		westTeambtn3.setContentAreaFilled(false);
		westTeambtn3.setBorderPainted(false);
		westTeambtn3.setOpaque(false);
		westTeambtn3.addActionListener(e->(sacInfoPanel=new TeamInfoPanel("SAC",mainFrame,previousPanel)));
		add(westTeambtn3);
		ImageIcon westTeamImg3 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "SAC"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn3.setIcon(westTeamImg3);	
		
		JButton westTeambtn4 = new JButton();
		westTeambtn4.setBounds(X*777/1366, Y*30/768,  X*60/1366, Y*60/768);
		westTeambtn4.setContentAreaFilled(false);
		westTeambtn4.setBorderPainted(false);
		westTeambtn4.setOpaque(false);
		westTeambtn4.addActionListener(e->(gswInfoPanel=new TeamInfoPanel("GSW",mainFrame,previousPanel)));
		add(westTeambtn4);
		ImageIcon westTeamImg4 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "GSW"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn4.setIcon(westTeamImg4);	
		
		JButton westTeambtn5 = new JButton();
		westTeambtn5.setBounds(X*860/1366, Y*30/768,  X*60/1366, Y*60/768);
		westTeambtn5.setContentAreaFilled(false);
		westTeambtn5.setBorderPainted(false);
		westTeambtn5.setOpaque(false);
		westTeambtn5.addActionListener(e->(phxInfoPanel=new TeamInfoPanel("PHX",mainFrame,previousPanel)));
		add(westTeambtn5);
		ImageIcon westTeamImg5 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "PHX"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn5.setIcon(westTeamImg5);	
		
		JButton westTeambtn6 = new JButton();
		westTeambtn6.setBounds(X*528/1366, Y*101/768,  X*60/1366, Y*60/768);
		westTeambtn6.setContentAreaFilled(false);
		westTeambtn6.setBorderPainted(false);
		westTeambtn6.setOpaque(false);
		westTeambtn6.addActionListener(e->(memInfoPanel=new TeamInfoPanel("MEM",mainFrame,previousPanel)));
		add(westTeambtn6);
		ImageIcon westTeamImg6 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "MEM"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn6.setIcon(westTeamImg6);	
		
		JButton westTeambtn7 = new JButton();
		westTeambtn7.setBounds(X*611/1366, Y*101/768,  X*60/1366, Y*60/768);
		westTeambtn7.setContentAreaFilled(false);
		westTeambtn7.setBorderPainted(false);
		westTeambtn7.setOpaque(false);
		westTeambtn7.addActionListener(e->(nopInfoPanel=new TeamInfoPanel("NOP",mainFrame,previousPanel)));
		add(westTeambtn7);
		ImageIcon westTeamImg7 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "NOP"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn7.setIcon(westTeamImg7);	
		
	
		JButton westTeambtn8 = new JButton();
		westTeambtn8.setBounds(X*694/1366,Y*101/768, X*60/1366, Y*60/768);
		westTeambtn8.setContentAreaFilled(false);
		westTeambtn8.setBorderPainted(false);
		westTeambtn8.setOpaque(false);
		westTeambtn8.addActionListener(e->(dalInfoPanel=new TeamInfoPanel("DAL",mainFrame,previousPanel)));
		add(westTeambtn8);
		ImageIcon westTeamImg8 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "DAL"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn8.setIcon(westTeamImg8);	
		
		JButton westTeambtn9 = new JButton();
		westTeambtn9.setBounds(X*777/1366, Y*101/768,  X*60/1366, Y*60/768);
		westTeambtn9.setContentAreaFilled(false);
		westTeambtn9.setBorderPainted(false);
		westTeambtn9.setOpaque(false);
		westTeambtn9.addActionListener(e->(houInfoPanel=new TeamInfoPanel("HOU",mainFrame,previousPanel)));
		add(westTeambtn9);
		ImageIcon westTeamImg9 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "HOU"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn9.setIcon(westTeamImg9);	
		
		JButton westTeambtn10 = new JButton();
		westTeambtn10.setBounds(X*860/1366, Y*101/768,  X*60/1366, Y*60/768);
		westTeambtn10.setContentAreaFilled(false);
		westTeambtn10.setBorderPainted(false);
		westTeambtn10.setOpaque(false);
		westTeambtn10.addActionListener(e->(sasInfoPanel=new TeamInfoPanel("SAS",mainFrame,previousPanel)));
		add(westTeambtn10);
		ImageIcon westTeamImg10 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "SAS"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn10.setIcon(westTeamImg10);
		
		JButton westTeambtn11 = new JButton();
		westTeambtn11.setBounds(X*528/1366,Y*172/768,  X*60/1366, Y*60/768);
		westTeambtn11.setContentAreaFilled(false);
		westTeambtn11.setBorderPainted(false);
		westTeambtn11.setOpaque(false);
		westTeambtn11.addActionListener(e->(utaInfoPanel=new TeamInfoPanel("UTA",mainFrame,previousPanel)));
		add(westTeambtn11);
		ImageIcon westTeamImg11 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "UTA"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn11.setIcon(westTeamImg11);
		
		JButton westTeambtn12 = new JButton();
		westTeambtn12.setBounds(X*611/1366,Y*172/768,  X*60/1366, Y*60/768);
		westTeambtn12.setContentAreaFilled(false);
		westTeambtn12.setBorderPainted(false);
		westTeambtn12.setOpaque(false);
		westTeambtn12.addActionListener(e->(denInfoPanel=new TeamInfoPanel("DEN",mainFrame,previousPanel)));
		add(westTeambtn12);
		ImageIcon westTeamImg12 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "DEN"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn12.setIcon(westTeamImg12);
		
		
		
		JButton westTeambtn13 = new JButton();
		westTeambtn13.setBounds(X*694/1366,Y*172/768,  X*60/1366, Y*60/768);
		westTeambtn13.setContentAreaFilled(false);
		westTeambtn13.setBorderPainted(false);
		westTeambtn13.setOpaque(false);
		westTeambtn13.addActionListener(e->(okcInfoPanel=new TeamInfoPanel("OKC",mainFrame,previousPanel)));
		add(westTeambtn13);
		ImageIcon westTeamImg13 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "OKC"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn13.setIcon(westTeamImg13);
		
		JButton westTeambtn14 = new JButton();
		westTeambtn14.setBounds(X*777/1366,Y*172/768, X*60/1366, Y*60/768);
		westTeambtn14.setContentAreaFilled(false);
		westTeambtn14.setBorderPainted(false);
		westTeambtn14.setOpaque(false);
		westTeambtn14.addActionListener(e->(minInfoPanel=new TeamInfoPanel("MIN",mainFrame,previousPanel)));
		add(westTeambtn14);
		ImageIcon westTeamImg14= new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "MIN"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn14.setIcon(westTeamImg14);
		
		JButton westTeambtn15 = new JButton();
		westTeambtn15.setBounds(X*860/1366,Y*172/768,  X*60/1366, Y*60/768);
		westTeambtn15.setContentAreaFilled(false);
		westTeambtn15.setBorderPainted(false);
		westTeambtn15.setOpaque(false);
		westTeambtn15.addActionListener(e->(porInfoPanel=new TeamInfoPanel("POR",mainFrame,previousPanel)));
		add(westTeambtn15);
		ImageIcon westTeamImg15 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/" + "POR"+ ".png").getImage().getScaledInstance(X*60/1366, Y*60/768,
				Image.SCALE_AREA_AVERAGING));
		westTeambtn15.setIcon(westTeamImg15);
		
	}
}
