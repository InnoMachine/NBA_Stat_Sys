package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class TeamPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	static ShowPanel searchTeamPanel;
	static SortPanel sortTeamPanel;
    static TeamButtonsPanel teamButtonsPanel;

	JFrame mainFrame;

	Team_BS team_BS = new Team_BL_Stub();
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
	
	public TeamPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		// X = mainFrame.getWidth();
		// Y = mainFrame.getHeight();
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		/*
		 * bgLabel = new JLabel(); bgLabel.setBounds(10, -10, X, Y); ImageIcon
		 * bg = new ImageIcon(new ImageIcon("Image/screeningTeam.png")
		 * .getImage().getScaledInstance(this.getWidth(), this.getHeight(),
		 * Image.SCALE_SMOOTH)); bgLabel.setIcon(bg); this.add(bgLabel);
		 */
		JButton home = new JButton();
		System.out.println(X+"  "+Y);
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X*1180/1366, Y*10/768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		// bgLabel.add(home);
		this.add(home);

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
		// bgLabel.add(minimize);
		this.add(minimize);

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
		// bgLabel.add(close);
		this.add(close);
		

		JButton sortTeambtn = new JButton("球队排序");
		sortTeambtn.setBounds(X*1161/1366, Y*380/768, X*120/1366, Y*23/768);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		add(sortTeambtn);

		
		JLabel label = new JLabel("热点球队");
		label.setBounds(X*60/1366, Y*82/768, X*60/1366, Y*15/768);
		add(label);


		seasonHotData_ScoreFieldbtn = new JButton("场均得分");
		seasonHotData_ScoreFieldbtn.setBounds(X*55/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_ScoreFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "scoreField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_ScoreFieldbtn.setVisible(true);
		add(seasonHotData_ScoreFieldbtn);

		seasonHotData_ReboundFieldbtn = new JButton("场均篮板");
		seasonHotData_ReboundFieldbtn.setBounds(X*175/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_ReboundFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "reboundField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_ReboundFieldbtn.setVisible(true);
		add(seasonHotData_ReboundFieldbtn);

		seasonHotData_AssistanceFieldbtn = new JButton("场均助攻");
		seasonHotData_AssistanceFieldbtn.setBounds(X*295/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_AssistanceFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "assistanceField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_AssistanceFieldbtn.setVisible(true);
		add(seasonHotData_AssistanceFieldbtn);

		seasonHotData_BlockFieldbtn = new JButton("场均盖帽");
		seasonHotData_BlockFieldbtn.setBounds(X*415/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_BlockFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "blockField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_BlockFieldbtn.setVisible(true);
		add(seasonHotData_BlockFieldbtn);

		seasonHotData_StealFieldbtn = new JButton("场均抢断");
		seasonHotData_StealFieldbtn.setBounds(X*535/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_StealFieldbtn.addActionListener(e -> {
			seasonHotTeamCriteria = "stealField";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_StealFieldbtn.setVisible(true);
		add(seasonHotData_StealFieldbtn);

		seasonHotData_ThreePointHitRatebtn = new JButton("三分命中率");
		seasonHotData_ThreePointHitRatebtn.setBounds(X*655/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_ThreePointHitRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "threePointHitRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_ThreePointHitRatebtn.setVisible(true);
		add(seasonHotData_ThreePointHitRatebtn);

		seasonHotData_HitRatebtn = new JButton("投篮命中率");
		seasonHotData_HitRatebtn.setBounds(X*776/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_HitRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "hitRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_HitRatebtn.setVisible(true);
		add(seasonHotData_HitRatebtn);

		seasonHotData_FreeThrowRatebtn = new JButton("罚球命中率");
		seasonHotData_FreeThrowRatebtn.setBounds(X*897/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_FreeThrowRatebtn.addActionListener(e -> {
			seasonHotTeamCriteria = "freeThrowRate";
			showSeasonHotTopFiveTeam(seasonHotTeamCriteria);
		});
		seasonHotData_FreeThrowRatebtn.setVisible(true);
		add(seasonHotData_FreeThrowRatebtn);

		seasonHotTeamPanel = new TopFiveTeamCardPanel(X,Y,team_BS.hotTeamSeason(seasonHotTeamCriteria),mainFrame,this);
		seasonHotTeamPanel.setVisible(true);
		seasonHotTeamPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*208/768);
		this.add(seasonHotTeamPanel);
		
		
		teamButtonsPanel=new TeamButtonsPanel(X, Y,mainFrame,this);
		teamButtonsPanel.setVisible(true);
		teamButtonsPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*240/768);
		this.add(teamButtonsPanel);	
		
		mainFrame.getContentPane().add(this);

	}
	
	public void showSeasonHotTopFiveTeam(String seasonHotTeamCriteria){
		
		if(seasonHotTeamPanel!=null){
			seasonHotTeamPanel.setVisible(false);
		}
		
		seasonHotTeamPanel = new TopFiveTeamCardPanel(X,Y,
				team_BS.hotTeamSeason(seasonHotTeamCriteria),mainFrame,this);
		seasonHotTeamPanel.setVisible(true);
		seasonHotTeamPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*208/768);
		this.add(seasonHotTeamPanel);
		
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
}
