package ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import businessLogic.Player_BL;
import businessLogic.Player_BS;

public class PlayerPanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	static ShowPanel showPlayerPanel;

	static ShowPanel searchTeamPanel;
	
	
	JFrame mainFrame;

	Player_BS player_BS = new Player_BL();

	static int X;
	static int Y;
	JLabel bgLabel;
	TopFivePlayerCardPanel dailyHotPlayerPanel;
	TopFivePlayerCardPanel seasonHotPlayerPanel;
	TopFivePlayerCardPanel progressFastPlayerPanel;

	JButton dailyHotData_Scorebtn;
	JButton dailyHotData_Reboundbtn;
	JButton dailyHotData_Assistancebtn;
	JButton dailyHotData_Blockbtn;
	JButton dailyHotData_Stealbtn;

	JButton seasonHotData_ScoreFieldbtn;
	JButton seasonHotData_ReboundFieldbtn;
	JButton seasonHotData_AssistanceFieldbtn;
	JButton seasonHotData_BlockFieldbtn;
	JButton seasonHotData_StealFieldbtn;
	JButton seasonHotData_ThreePointHitRatebtn;
	JButton seasonHotData_HitRatebtn;
	JButton seasonHotData_FreeThrowRatebtn;

	String dailyHotPlayerCriteria = "score";
	String seasonHotPlayerCriteria = "scoreField";
	String progressFastPlayerCriteria = "scoreFieldProgress";
	
	private String selected="每日热点球员";
	private String selectedby="-得分";
	private JLabel hotLabel;
	private JLabel progress;
	private String progressby="-场均得分";
	
	public PlayerPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/playerPanel.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X*1180/1366, Y*20/768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		bgLabel.add(home);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25, X / 25,Image.SCALE_SMOOTH));
		minimize.setBounds(X*1240/1366, Y*20/768, X / 25, X / 25);
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
		close.setBounds(X*1300/1366, Y*20/768, X / 25, X / 25);
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


		JButton searchPlayerbtn = new MyButton("球员搜索");
		searchPlayerbtn.setBounds(X*1100/1366, Y*330/768,X*180/1366, Y*50/768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance( X*180/1366, Y*50/768,
						 Image.SCALE_SMOOTH));
		
		searchPlayerbtn.setIcon(buttonIcon);
		searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
		bgLabel.add(searchPlayerbtn);
/*
		JButton ShowPlayerbtn = new MyButton("球员查看");
		ShowPlayerbtn.setBounds(X*1100/1366, Y*330/768,X*180/1366, Y*50/768);
		ShowPlayerbtn.setIcon(buttonIcon);
		ShowPlayerbtn.addActionListener(e -> toShowPlayerPanel());
		bgLabel.add(ShowPlayerbtn);
*/
		JButton sortPlayerbtn = new MyButton("球员排序");
		sortPlayerbtn.setBounds(X*1100/1366, Y*410/768, X*180/1366, Y*50/768);
		sortPlayerbtn.setIcon(buttonIcon);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		bgLabel.add(sortPlayerbtn);

		JButton screeningPlayerbtn = new MyButton("球员筛选");
		screeningPlayerbtn.setBounds(X*1100/1366, Y*490/768,X*180/1366, Y*50/768);
		screeningPlayerbtn.setIcon(buttonIcon);
		screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
		bgLabel.add(screeningPlayerbtn);

		hotLabel = new JLabel();
		hotLabel.setText(selected+selectedby);
		hotLabel.setBounds(X*60/1366, Y*70/768, X*300/1366, Y*20/768);
		hotLabel.setForeground(Color.WHITE);
		hotLabel.setFont(new Font("微软雅黑",1,20));
		bgLabel.add(hotLabel);
		
		
		JButton dailyHotDatabtn = new MyButton("每日");
		dailyHotDatabtn.setBounds(X*700/1366, Y*70/768, X*150/1366, Y*30/768);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(  X*150/1366, Y*30/768,
						 Image.SCALE_SMOOTH));
		
		dailyHotDatabtn.setIcon(buttonIcon);
		dailyHotDatabtn.addActionListener(e -> showDailyHotComponent());
		bgLabel.add(dailyHotDatabtn);

		dailyHotData_Scorebtn = new MyButton("得分");
		dailyHotData_Scorebtn.setBounds(X*55/1366, Y*105/768, X*194/1366, Y*30/768);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(  X*194/1366, Y*30/768,
						 Image.SCALE_SMOOTH));
		dailyHotData_Scorebtn.setIcon(buttonIcon);
		dailyHotData_Scorebtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "score";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
			selectedby="-得分";
			hotLabel.setText(selected+selectedby);
		});
		dailyHotData_Scorebtn.setVisible(true);
		bgLabel.add(dailyHotData_Scorebtn);

		dailyHotData_Reboundbtn = new MyButton("篮板");
		dailyHotData_Reboundbtn.setBounds(X*248/1366, Y*105/768, X*194/1366, Y*30/768);
		dailyHotData_Reboundbtn.setIcon(buttonIcon);
		dailyHotData_Reboundbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "reboundOverall";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
			selectedby="-篮板";
			hotLabel.setText(selected+selectedby);
		});
		dailyHotData_Reboundbtn.setVisible(true);
		bgLabel.add(dailyHotData_Reboundbtn);

		dailyHotData_Assistancebtn = new MyButton("助攻");
		dailyHotData_Assistancebtn.setBounds(X*441/1366, Y*105/768, X*194/1366, Y*30/768);
		dailyHotData_Assistancebtn.setIcon(buttonIcon);
		dailyHotData_Assistancebtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "assistance";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
			selectedby="-助攻";
			hotLabel.setText(selected+selectedby);
		});
		dailyHotData_Assistancebtn.setVisible(true);
		bgLabel.add(dailyHotData_Assistancebtn);

		dailyHotData_Blockbtn = new MyButton("盖帽");
		dailyHotData_Blockbtn.setBounds(X*634/1366, Y*105/768, X*194/1366, Y*30/768);
		dailyHotData_Blockbtn.setIcon(buttonIcon);
		dailyHotData_Blockbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "block";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
			selectedby="-盖帽";
			hotLabel.setText(selected+selectedby);
		});
		dailyHotData_Blockbtn.setVisible(true);
		bgLabel.add(dailyHotData_Blockbtn);

		dailyHotData_Stealbtn = new MyButton("抢断");
		dailyHotData_Stealbtn.setBounds(X*827/1366, Y*105/768, X*194/1366, Y*30/768);
		dailyHotData_Stealbtn.setIcon(buttonIcon);
		dailyHotData_Stealbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "steal";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
			selectedby="-抢断";
			hotLabel.setText(selected+selectedby);
		});
		dailyHotData_Stealbtn.setVisible(true);
		bgLabel.add(dailyHotData_Stealbtn);

		JButton seasonHotDatabtn = new MyButton("赛季");
		seasonHotDatabtn.setBounds(X*850/1366, Y*70/768, X*150/1366, Y*30/768);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(  X*150/1366, Y*30/768,
						 Image.SCALE_SMOOTH));
		seasonHotDatabtn.setIcon(buttonIcon);
		seasonHotDatabtn.addActionListener(e -> showSeasonHotComponent());
		bgLabel.add(seasonHotDatabtn);

		seasonHotData_ScoreFieldbtn = new MyButton("场均得分");
		seasonHotData_ScoreFieldbtn.setBounds(X*55/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_ScoreFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "scoreField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-场均得分";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_ScoreFieldbtn.setVisible(false);
		bgLabel.add(seasonHotData_ScoreFieldbtn);

		seasonHotData_ReboundFieldbtn = new MyButton("场均篮板");
		seasonHotData_ReboundFieldbtn.setBounds(X*175/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_ReboundFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "reboundOverallField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-场均篮板";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_ReboundFieldbtn.setVisible(false);
		bgLabel.add(seasonHotData_ReboundFieldbtn);

		seasonHotData_AssistanceFieldbtn = new MyButton("场均助攻");
		seasonHotData_AssistanceFieldbtn.setBounds(X*295/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_AssistanceFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "assistanceField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-场均助攻";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_AssistanceFieldbtn.setVisible(false);
		bgLabel.add(seasonHotData_AssistanceFieldbtn);

		seasonHotData_BlockFieldbtn = new MyButton("场均盖帽");
		seasonHotData_BlockFieldbtn.setBounds(X*415/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_BlockFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "blockField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-场均盖帽";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_BlockFieldbtn.setVisible(false);
		bgLabel.add(seasonHotData_BlockFieldbtn);

		seasonHotData_StealFieldbtn = new MyButton("场均抢断");
		seasonHotData_StealFieldbtn.setBounds(X*535/1366, Y*105/768, X*121/1366, Y*30/768);
		seasonHotData_StealFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "stealField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-场均抢断";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_StealFieldbtn.setVisible(false);
		bgLabel.add(seasonHotData_StealFieldbtn);

		seasonHotData_ThreePointHitRatebtn = new MyButton("三分命中率");
		seasonHotData_ThreePointHitRatebtn.setBounds(X*655/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_ThreePointHitRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "threePointHitRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-三分命中率";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_ThreePointHitRatebtn.setVisible(false);
		bgLabel.add(seasonHotData_ThreePointHitRatebtn);

		seasonHotData_HitRatebtn = new MyButton("投篮命中率");
		seasonHotData_HitRatebtn.setBounds(X*776/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_HitRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "hitRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-投篮命中率";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_HitRatebtn.setVisible(false);
		bgLabel.add(seasonHotData_HitRatebtn);

		seasonHotData_FreeThrowRatebtn = new MyButton("罚球命中率");
		seasonHotData_FreeThrowRatebtn.setBounds(X*897/1366, Y*105/768, X*122/1366, Y*30/768);
		seasonHotData_FreeThrowRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "freeThrowRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
			selectedby="-罚球命中率";
			hotLabel.setText(selected+selectedby);
		});
		seasonHotData_FreeThrowRatebtn.setVisible(false);
		bgLabel.add(seasonHotData_FreeThrowRatebtn);

		dailyHotPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.hotPlayerDaily(dailyHotPlayerCriteria),mainFrame,this,"PlayerPanel");
		dailyHotPlayerPanel.setVisible(true);
		dailyHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*230/768);
		bgLabel.add(dailyHotPlayerPanel);
		
		
		
		
		progress = new JLabel();
		progress.setText("进步最快球员"+progressby);
		progress.setBounds(X*60/1366, Y*390/768, X*300/1366, Y*30/768);
		progress.setForeground(Color.WHITE);
		progress.setFont(new Font("微软雅黑",1,20));
		bgLabel.add(progress);

		JButton seasonData_ScoreFieldbtn = new MyButton("场均得分");
		seasonData_ScoreFieldbtn.setBounds(X*55/1366, Y*432/768, X*322/1366, Y*30/768);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(  X*322/1366, Y*30/768,
						 Image.SCALE_SMOOTH));
		seasonData_ScoreFieldbtn.setIcon(buttonIcon);
		seasonData_ScoreFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "scoreFieldProgress";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
			progressby="-场均得分";
			progress.setText("进步最快球员"+progressby);
		});
		bgLabel.add(seasonData_ScoreFieldbtn);

		JButton seasonData_ReboundFieldbtn = new MyButton("场均篮板");
		seasonData_ReboundFieldbtn.setBounds(X*377/1366, Y*432/768,X*322/1366, Y*30/768);
		seasonData_ReboundFieldbtn.setIcon(buttonIcon);
		seasonData_ReboundFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "reboundOverallFieldProgress";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
			progressby="-场均篮板";
			progress.setText("进步最快球员"+progressby);
		});
		bgLabel.add(seasonData_ReboundFieldbtn);

		JButton seasonData_AssistanceFieldbtn = new MyButton("场均助攻");
		seasonData_AssistanceFieldbtn.setBounds(X*699/1366, Y*432/768, X*322/1366,Y*30/768);
		seasonData_AssistanceFieldbtn.setIcon(buttonIcon);
		seasonData_AssistanceFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "assistanceFieldProgress";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
			progressby="-场均助攻";
			progress.setText("进步最快球员"+progressby);
		});
		bgLabel.add(seasonData_AssistanceFieldbtn);

		progressFastPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.progressFastPlayer(progressFastPlayerCriteria),mainFrame,this,"PlayerPanel");
		progressFastPlayerPanel.setVisible(true);
		progressFastPlayerPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*230/768);
		bgLabel.add(progressFastPlayerPanel);	
		
		
		mainFrame.getContentPane().add(this);

	}

	public void showDailyHotComponent() {
		selected="每日热点球员";
		selectedby="-得分";
		hotLabel.setText(selected+selectedby);
		if (seasonHotData_ScoreFieldbtn != null) {
			seasonHotData_ScoreFieldbtn.setVisible(false);
		}
		if (seasonHotData_ReboundFieldbtn != null) {
			seasonHotData_ReboundFieldbtn.setVisible(false);
		}
		if (seasonHotData_AssistanceFieldbtn != null) {
			seasonHotData_AssistanceFieldbtn.setVisible(false);
		}
		if (seasonHotData_BlockFieldbtn != null) {
			seasonHotData_BlockFieldbtn.setVisible(false);
		}
		if (seasonHotData_StealFieldbtn != null) {
			seasonHotData_StealFieldbtn.setVisible(false);
		}
		if (seasonHotData_ThreePointHitRatebtn != null) {
			seasonHotData_ThreePointHitRatebtn.setVisible(false);
		}
		if (seasonHotData_HitRatebtn != null) {
			seasonHotData_HitRatebtn.setVisible(false);
		}
		if (seasonHotData_FreeThrowRatebtn != null) {
			seasonHotData_FreeThrowRatebtn.setVisible(false);
		}

		dailyHotData_Scorebtn.setVisible(true);

		dailyHotData_Reboundbtn.setVisible(true);

		dailyHotData_Assistancebtn.setVisible(true);

		dailyHotData_Blockbtn.setVisible(true);

		dailyHotData_Stealbtn.setVisible(true);

		showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
	}

	public void showSeasonHotComponent() {
		selected="赛季热点球员";
		selectedby="-场均得分";
		hotLabel.setText(selected+selectedby);
		if (dailyHotData_Scorebtn != null) {
			dailyHotData_Scorebtn.setVisible(false);
		}
		if (dailyHotData_Reboundbtn != null) {
			dailyHotData_Reboundbtn.setVisible(false);
		}
		if (dailyHotData_Assistancebtn != null) {
			dailyHotData_Assistancebtn.setVisible(false);
		}
		if (dailyHotData_Blockbtn != null) {
			dailyHotData_Blockbtn.setVisible(false);
		}
		if (dailyHotData_Stealbtn != null) {
			dailyHotData_Stealbtn.setVisible(false);
		}

		seasonHotData_ScoreFieldbtn.setVisible(true);
		seasonHotData_ReboundFieldbtn.setVisible(true);
		seasonHotData_AssistanceFieldbtn.setVisible(true);
		seasonHotData_BlockFieldbtn.setVisible(true);
		seasonHotData_StealFieldbtn.setVisible(true);
		seasonHotData_ThreePointHitRatebtn.setVisible(true);
		seasonHotData_HitRatebtn.setVisible(true);
		seasonHotData_FreeThrowRatebtn.setVisible(true);

		showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
	}

	public void showDailyHotTopFivePlayer(String dailyHotPlayerCriteria) {
		if (dailyHotPlayerPanel != null) {
			dailyHotPlayerPanel.setVisible(false);
		}
		if (seasonHotPlayerPanel != null) {
			seasonHotPlayerPanel.setVisible(false);
		}
		dailyHotPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.hotPlayerDaily(dailyHotPlayerCriteria),mainFrame,this,"PlayerPanel");
		dailyHotPlayerPanel.setVisible(true);
		dailyHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*230/768);
		bgLabel.add(dailyHotPlayerPanel);

	}

	public void showSeasonHotTopFivePlayer(String seasonHotPlayerCriteria) {
		if (seasonHotPlayerPanel != null) {
			seasonHotPlayerPanel.setVisible(false);
		}
		if (dailyHotPlayerPanel != null) {
			dailyHotPlayerPanel.setVisible(false);
		}
		seasonHotPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.hotPlayerSeason(seasonHotPlayerCriteria),mainFrame,this,"PlayerPanel");
		seasonHotPlayerPanel.setVisible(true);
		seasonHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*230/768);
		bgLabel.add(seasonHotPlayerPanel);
	}

	public void showProgressFastTopFivePlayer(String progressFastPlayerCriteria) {
		if(progressFastPlayerPanel!=null){
			progressFastPlayerPanel.setVisible(false);
		}
		
		progressFastPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.progressFastPlayer(progressFastPlayerCriteria),mainFrame,this,"PlayerPanel");
		progressFastPlayerPanel.setVisible(true);
		progressFastPlayerPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*230/768);
		bgLabel.add(progressFastPlayerPanel);	
	
	}

	public void toSearchPlayerPanel() {
		this.setVisible(false);
		MainFrame.searchPanel = new SearchPanel(mainFrame,this);
		MainFrame.currentPanel="SearchPanel";
	}
/*
	public void toShowPlayerPanel() {
		this.setVisible(false);
		showPlayerPanel = new ShowPanel("player", mainFrame,this);
		MainFrame.currentPanel="ShowPlayerPanel";
	}
*/
	public void toSortPlayerPanel() {
		this.setVisible(false);
		MainFrame.sortPlayerPanel = new SortPanel("player", mainFrame,this);
		MainFrame.currentPanel="SortPlayerPanel";
	}

	public void toScreeningPlayerPanel() {
		this.setVisible(false);
		MainFrame.screeningPlayerPanel = new ScreeningPlayerPanel(mainFrame,this);
		MainFrame.currentPanel="ScreeningPlayerPanel";
	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel="StartPanel";
		// playerCriteriaPanel.setVisible(false);
	}

	
	public void refresh(){
      mainFrame.remove(this);
//	this.setVisible(false);
		MainFrame.playerPanel=new PlayerPanel(mainFrame);
		if(MainFrame.currentPanel.equals("PlayerPanel")){
			MainFrame.playerPanel.setVisible(true);
		}else{
			MainFrame.playerPanel.setVisible(false);
		}
	}
	
	
	
	class MyTextField extends JTextField {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

	}

	class MyButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton(String function){
			super();
			this.setText(function);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(  X*122/1366, Y*30/768,
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			
		}
	}
	
	class MyLabel extends JLabel {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 11));

		}
	}
}
