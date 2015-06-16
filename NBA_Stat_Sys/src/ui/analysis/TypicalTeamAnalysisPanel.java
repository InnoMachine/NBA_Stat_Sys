package ui.analysis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;


import ui.MainFrame;
import ui.StartPanel;
import businessLogic.ChartPanelMake;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;

public class TypicalTeamAnalysisPanel extends JPanel {
	JFrame mainFrame;

	static int X;
	static int Y;
	JLabel bgLabel;
	JPanel previousPanel;
	JButton picturebtn;
	JButton tablebtn;
	JLabel picturelbl;
	JLabel chartlbl;
	JLabel tablelbl;
	String team;
	String currentPicCriteria = "";
	ChartPanelMake cpm=new ChartPanelMake();
	JPanel firstChartPanel;
	JPanel secondChartPanel;

	public TypicalTeamAnalysisPanel(JFrame mainFrame, String team,
			JPanel previousPanel) {

		this.mainFrame = mainFrame;
		this.team = team;
		this.previousPanel = previousPanel;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		/*
		 * bgLabel = new JLabel(); bgLabel.setBounds(0, 0, X, Y);
		 * 
		 * this.add(bgLabel);
		 */
		this.setBackground(Color.BLACK);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		this.add(home);

		JButton back = new JButton();
		back.setForeground(Color.WHITE);

		ImageIcon backIcon = new ImageIcon(new ImageIcon("Image/backIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));

		back.setBounds(17 * X / 20, Y * 20 / 768, X / 25, X / 25);
		back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		this.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 20 / 768, X / 25, X / 25);
		minimize.setIcon(minimizeIcon);
		minimize.setOpaque(false);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});

		this.add(minimize);

		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		close.setBounds(19 * X / 20, Y * 20 / 768, X / 25, X / 25);
		close.setIcon(closeIcon);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
		});
		this.add(close);

		JLabel teamlbl = new JLabel();
		teamlbl.setBounds(0, 670, 1366, 80);
		teamlbl.setVisible(true);
		
		  ImageIcon teamIcon = new ImageIcon(new
		  ImageIcon("Image/teamstrip/"+team+".png") .getImage().getScaledInstance(1366,
		  80, Image.SCALE_SMOOTH)); teamlbl.setIcon(teamIcon);
		 
//		teamlbl.setBackground(Color.BLUE);
		teamlbl.setOpaque(true);
		this.add(teamlbl);

		picturelbl = new JLabel();
		picturelbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		picturelbl.setVisible(false);
        this.add(picturelbl);
		
		tablelbl = new JLabel();
		tablelbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		tablelbl.setVisible(false);
		this.add(tablelbl);

		picturebtn = new MyButton("数据变化");	
		picturebtn.setBounds(X * 183 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		picturebtn.addActionListener(e -> {
			showPicture();
		});
        this.add(picturebtn);
		
		
		tablebtn = new MyButton("");
		tablebtn.setBounds(X * 333 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		tablebtn.addActionListener(e -> {
			showTable();
		});
        this.add(tablebtn);
		
		mainFrame.add(this);
	}

	public void showPicture() {
		tablelbl.setVisible(false);
		picturelbl.setVisible(true);

		ButtonGroup bg = new ButtonGroup();

		MyRadioButton pic1 = new MyRadioButton("场均得分");
		pic1.setBounds(6, 70, 110, 23);
		pic1.addActionListener(e -> {
			createChart(1);
		});
		picturelbl.add(pic1);
		bg.add(pic1);

		MyRadioButton pic2 = new MyRadioButton("进攻回合数");
		pic2.setBounds(X * 6 / 1366, Y * 105 / 768, X * 100 / 1366, Y * 23 / 768);
		pic2.addActionListener(e -> {
			createChart(2);		
		});
		picturelbl.add(pic2);
		bg.add(pic2);

		MyRadioButton pic3 = new MyRadioButton("场均助攻");
		pic3.setBounds(X * 6 / 1366, Y * 140 / 768, X * 100 / 1366, Y * 23 / 768);
		pic3.addActionListener(e -> {
			createChart(3);
		});
		picturelbl.add(pic3);
		bg.add(pic3);

		MyRadioButton pic4 = new MyRadioButton("场均罚球数");
		pic4.setBounds(X * 6 / 1366, Y * 175 / 768, X * 100 / 1366,
				Y * 23 / 768);
		pic4.addActionListener(e -> {
			createChart(4);
		});
		picturelbl.add(pic4);
		bg.add(pic4);

		MyRadioButton pic5 = new MyRadioButton("三分占得分比");
		pic5.setBounds(X * 6 / 1366, Y * 210 / 768, X * 51 / 1366, Y * 23 / 768);
		pic5.addActionListener(e -> {
			createChart(5);

		});
		picturelbl.add(pic5);
		bg.add(pic5);

		MyRadioButton pic6 = new MyRadioButton("助攻出手比");
		pic6.setBounds(X * 6 / 1366, Y * 245 / 768, X * 51 / 1366, Y * 23 / 768);
		pic6.addActionListener(e -> {
			createChart(6);
		});
		picturelbl.add(pic6);
		bg.add(pic6);

		MyRadioButton pic7 = new MyRadioButton("首发得分方差");
		pic7.setBounds(X * 6 / 1366, Y *280 / 768, X * 51 / 1366, Y * 23 / 768);
		pic7.addActionListener(e -> {
			createChart(7);
		});
		picturelbl.add(pic7);
		bg.add(pic7);

		MyRadioButton pic8 = new MyRadioButton("胜率变化");
		pic8.setBounds(X * 6 / 1366, Y * 315 / 768, X * 51 / 1366, Y * 23 / 768);
		pic8.addActionListener(e -> {
			createChart(8);
		});
		picturelbl.add(pic8);
		bg.add(pic8);

		MyRadioButton pic9 = new MyRadioButton("进攻效率");
		pic9.setBounds(X * 6 / 1366, Y * 350 / 768, X * 51 / 1366, Y * 23 / 768);
		pic9.addActionListener(e -> {
			createChart(9);
		});
		picturelbl.add(pic9);
		bg.add(pic9);

		MyRadioButton pic10 = new MyRadioButton("防守效率");
		pic10.setBounds(X * 6 / 1366, Y * 385 / 768, X * 51 / 1366, Y * 23 / 768);
		pic10.addActionListener(e -> {
			createChart(10);
		});
		picturelbl.add(pic10);
		bg.add(pic10);
		
	}

	public void showTable() {
		picturelbl.setVisible(false);
		tablelbl.setVisible(true);

		
		
		
		
		
		
	}

	public void createChart(int i) {

		if(firstChartPanel!=null){
			firstChartPanel.setVisible(false);
		}
		firstChartPanel=new JPanel();
		firstChartPanel=cpm.getLineChartPanel(i, team);
		firstChartPanel.setBounds(170,50 , 700, 450);			
		picturelbl.add(firstChartPanel);		
		
	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame, MainFrame.analysisPanel,
				MainFrame.playerPanel, MainFrame.teamPanel, MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		mainFrame.add(previousPanel);
	}
	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	public MyButton(String function) {
		super();
		this.setText(function);
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setForeground(Color.WHITE);
		this.setFont(new Font("微软雅黑", 1, 15));
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(
				X * 150/ 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

		this.setIcon(buttonIcon);
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
	}
}
	
	class MyRadioButton extends JRadioButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyRadioButton(String choice) {
			super();
			this.setText(choice);
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
		}
	}
}
