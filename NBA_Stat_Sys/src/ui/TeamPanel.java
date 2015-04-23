package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import businessLogic.Team_BL;
import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class TeamPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	static ShowPanel searchTeamPanel;
	static SortPanel sortTeamPanel;
    static TeamButtonsPanel teamButtonsPanel;

	JFrame mainFrame;

	Team_BS team_BS = new Team_BL();
	static int X;
	static int Y;
	JLabel bgLabel;
	TopFiveTeamCardPanel seasonHotTeamPanel;
	
	JButton seasonHotData_ScoreFieldbtn;
	JButton seasonHotData_ReboundFieldbtn;
	JButton seasonHotData_AssistanceFieldbtn;
	JButton seasonHotData_BlockFieldbtn;
	JButton seasonHotData_StealFieldbtn;
	JButton seasonHotData_ThreePointHitRatebtn;
	JButton seasonHotData_HitRatebtn;
	JButton seasonHotData_FreeThrowRatebtn;
	
	String seasonHotTeamCriteria = "scoreField";
	private JLabel hotTeam;
	private String selectedby="-场均得分";
	
	public TeamPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		
		bgLabel = new JLabel(); bgLabel.setBounds(0,0, X, Y); ImageIcon
		bg = new ImageIcon(new ImageIcon("Image/teamPanel.png")
		.getImage().getScaledInstance(this.getWidth(), this.getHeight(),
		Image.SCALE_SMOOTH)); bgLabel.setIcon(bg); this.add(bgLabel);
		 
		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X*1180/1366, Y*10/768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		bgLabel.add(home);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25, X / 25,Image.SCALE_SMOOTH));
		minimize.setBounds(X*1240/1366, Y*10/768, X / 25, X / 25);
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
		bgLabel.add(minimize);
		
		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		close.setBounds(X*1300/1366, Y*10/768, X / 25, X / 25);
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
		bgLabel.add(close);
		

		JButton sortTeambtn = new JButton("球队排序");
		sortTeambtn.setBounds(X*1100/1366, Y*550/768, X*180/1366, Y*50/768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(
				X * 160/ 1366, Y * 50 / 768, Image.SCALE_SMOOTH));
		sortTeambtn.setHorizontalTextPosition(SwingConstants.CENTER);
		sortTeambtn.setForeground(Color.WHITE);
		sortTeambtn.setFont(new Font("微软雅黑",1,20));
		sortTeambtn.setIcon(buttonIcon);
		sortTeambtn.setOpaque(false);
		sortTeambtn.setContentAreaFilled(false);
		sortTeambtn.setBorderPainted(false);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		bgLabel.add(sortTeambtn);

	
		hotTeam = new JLabel();
		hotTeam.setText("热点球队"+selectedby);
		hotTeam.setBounds(X*60/1366, Y*75/768, X*300/1366, Y*22/768);
		hotTeam.setFont(new Font("微软雅黑",1,20));
		hotTeam.setForeground(Color.WHITE);
		bgLabel.add(hotTeam);


		seasonHotData_ScoreFieldbtn = new MyButton("场均得分");
		seasonHotData_ScoreFieldbtn.setBounds(X*55/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_ScoreFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "scoreField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-场均得分";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_ScoreFieldbtn.setVisible(true);
		bgLabel.add(seasonHotData_ScoreFieldbtn);

		seasonHotData_ReboundFieldbtn = new MyButton("场均篮板");
		seasonHotData_ReboundFieldbtn.setBounds(X*175/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_ReboundFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "reboundField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-场均篮板";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_ReboundFieldbtn.setVisible(true);
		bgLabel.add(seasonHotData_ReboundFieldbtn);

		seasonHotData_AssistanceFieldbtn = new MyButton("场均助攻");
		seasonHotData_AssistanceFieldbtn.setBounds(X*295/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_AssistanceFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "assistanceField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-场均助攻";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_AssistanceFieldbtn.setVisible(true);
		bgLabel.add(seasonHotData_AssistanceFieldbtn);

		seasonHotData_BlockFieldbtn = new MyButton("场均盖帽");
		seasonHotData_BlockFieldbtn.setBounds(X*415/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_BlockFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "blockField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-场均盖帽";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_BlockFieldbtn.setVisible(true);
		bgLabel.add(seasonHotData_BlockFieldbtn);

		seasonHotData_StealFieldbtn = new MyButton("场均抢断");
		seasonHotData_StealFieldbtn.setBounds(X*535/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_StealFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "stealField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-场均抢断";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_StealFieldbtn.setVisible(true);
		bgLabel.add(seasonHotData_StealFieldbtn);

		seasonHotData_ThreePointHitRatebtn = new MyButton("三分命中率");
		seasonHotData_ThreePointHitRatebtn.setBounds(X*655/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_ThreePointHitRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "threePointHitRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-三分命中率";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_ThreePointHitRatebtn.setVisible(true);
		bgLabel.add(seasonHotData_ThreePointHitRatebtn);

		seasonHotData_HitRatebtn = new MyButton("投篮命中率");
		seasonHotData_HitRatebtn.setBounds(X*776/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_HitRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "hitRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-投篮命中率";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_HitRatebtn.setVisible(true);
		bgLabel.add(seasonHotData_HitRatebtn);

		seasonHotData_FreeThrowRatebtn = new MyButton("罚球命中率");
		seasonHotData_FreeThrowRatebtn.setBounds(X*897/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_FreeThrowRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "freeThrowRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
			selectedby="-罚球命中率";
			hotTeam.setText("热点球队"+selectedby);
		});
		seasonHotData_FreeThrowRatebtn.setVisible(true);
		bgLabel.add(seasonHotData_FreeThrowRatebtn);

		seasonHotTeamPanel = new TopFiveTeamCardPanel(X,Y,team_BS.hotTeamSeason(seasonHotTeamCriteria),mainFrame,this);
		seasonHotTeamPanel.setVisible(true);
		seasonHotTeamPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*250/768);
		bgLabel.add(seasonHotTeamPanel);
		
		
		teamButtonsPanel=new TeamButtonsPanel(X, Y,mainFrame,this);
		teamButtonsPanel.setVisible(true);
		teamButtonsPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*240/768);
		bgLabel.add(teamButtonsPanel);	
		
		mainFrame.getContentPane().add(this);

	}
	
	public void showSeasonHotTopFiveTeam(String seasonHotTeamCriteria){
		
		if(seasonHotTeamPanel!=null){
			seasonHotTeamPanel.setVisible(false);
		}
		
		seasonHotTeamPanel = new TopFiveTeamCardPanel(X,Y,
				team_BS.hotTeamSeason(seasonHotTeamCriteria),mainFrame,this);
		seasonHotTeamPanel.setVisible(true);
		seasonHotTeamPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*250/768);
		bgLabel.add(seasonHotTeamPanel);
		
	} 
	
	
	
	public void toShowTeamPanel() {
		this.setVisible(true);
		searchTeamPanel = new ShowPanel("team", mainFrame,this);

	}

	public void toSortTeamPanel() {
		this.setVisible(false);
		sortTeamPanel = new SortPanel("team", mainFrame,this);

	}

	
	
	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
		 
	}
	
	class MyButton extends JButton{
		
		public MyButton(String function) {
			super();
			this.setText(function);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑", 1, 15));
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					X * 122 / 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);

		}
		
	}
}
