package ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import vo.PlayerVo;

public class PlayerPanel extends JPanel {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	static ShowPanel showPlayerPanel;
	static SortPanel sortPlayerPanel;
	static ShowPanel searchTeamPanel;
	static ScreeningPlayerPanel screeningPlayerPanel;
    static SearchPanel searchPlayerPanel;
	
	JFrame mainFrame;

	Player_BS player_BS = new Player_BL_Stub();
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
	String progressFastPlayerCriteria = "scoreField";

	public PlayerPanel(JFrame mainFrame) {
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
		 * bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
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

		JButton searchPlayerbtn = new JButton("球员搜索");
		searchPlayerbtn.setBounds(X*1161/1366, Y*275/768, X*120/1366, Y*23/768);
		searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
		add(searchPlayerbtn);

		JButton ShowPlayerbtn = new JButton("球员查看");
		ShowPlayerbtn.setBounds(X*1161/1366, Y*345/768, X*120/1366, Y*23/768);
		ShowPlayerbtn.addActionListener(e -> toShowPlayerPanel());
		add(ShowPlayerbtn);

		JButton sortPlayerbtn = new JButton("球员排序");
		sortPlayerbtn.setBounds(X*1161/1366, Y*415/768, X*120/1366, Y*23/768);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		add(sortPlayerbtn);

		JButton screeningPlayerbtn = new JButton("球员筛选");
		screeningPlayerbtn.setBounds(X*1161/1366, Y*485/768, X*120/1366, Y*23/768);
		screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
		add(screeningPlayerbtn);

		JLabel label = new JLabel("热点球员");
		label.setBounds(X*60/1366, Y*82/768, X*60/1366, Y*15/768);
		add(label);
		
		
		JButton dailyHotDatabtn = new JButton("每日");
		dailyHotDatabtn.setBounds(X*899/1366, Y*74/768, X*60/1366, Y*23/768);
		dailyHotDatabtn.addActionListener(e -> showDailyHotComponent());
		add(dailyHotDatabtn);

		dailyHotData_Scorebtn = new JButton("得分");
		dailyHotData_Scorebtn.setBounds(X*55/1366, Y*105/768, X*194/1366, Y*23/768);
		dailyHotData_Scorebtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "score";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
		});
		dailyHotData_Scorebtn.setVisible(true);
		add(dailyHotData_Scorebtn);

		dailyHotData_Reboundbtn = new JButton("篮板");
		dailyHotData_Reboundbtn.setBounds(X*248/1366, Y*105/768, X*194/1366, Y*23/768);
		dailyHotData_Reboundbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "rebound";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
		});
		dailyHotData_Reboundbtn.setVisible(true);
		add(dailyHotData_Reboundbtn);

		dailyHotData_Assistancebtn = new JButton("助攻");
		dailyHotData_Assistancebtn.setBounds(X*441/1366, Y*105/768, X*194/1366, Y*23/768);
		dailyHotData_Assistancebtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "assistance";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
		});
		dailyHotData_Assistancebtn.setVisible(true);
		add(dailyHotData_Assistancebtn);

		dailyHotData_Blockbtn = new JButton("盖帽");
		dailyHotData_Blockbtn.setBounds(X*634/1366, Y*105/768, X*194/1366, Y*23/768);
		dailyHotData_Blockbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "block";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
		});
		dailyHotData_Blockbtn.setVisible(true);
		add(dailyHotData_Blockbtn);

		dailyHotData_Stealbtn = new JButton("抢断");
		dailyHotData_Stealbtn.setBounds(X*827/1366, Y*105/768, X*194/1366, Y*23/768);
		dailyHotData_Stealbtn.addActionListener(e -> {
			dailyHotPlayerCriteria = "steal";
			showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
		});
		dailyHotData_Stealbtn.setVisible(true);
		add(dailyHotData_Stealbtn);

		JButton seasonHotDatabtn = new JButton("赛季");
		seasonHotDatabtn.setBounds(X*960/1366, Y*74/768, X*60/1366, Y*23/768);
		seasonHotDatabtn.addActionListener(e -> showSeasonHotComponent());
		add(seasonHotDatabtn);

		seasonHotData_ScoreFieldbtn = new JButton("场均得分");
		seasonHotData_ScoreFieldbtn.setBounds(X*55/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_ScoreFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "scoreField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_ScoreFieldbtn.setVisible(false);
		add(seasonHotData_ScoreFieldbtn);

		seasonHotData_ReboundFieldbtn = new JButton("场均篮板");
		seasonHotData_ReboundFieldbtn.setBounds(X*175/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_ReboundFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "reboundField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_ReboundFieldbtn.setVisible(false);
		add(seasonHotData_ReboundFieldbtn);

		seasonHotData_AssistanceFieldbtn = new JButton("场均助攻");
		seasonHotData_AssistanceFieldbtn.setBounds(X*295/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_AssistanceFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "assistanceField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_AssistanceFieldbtn.setVisible(false);
		add(seasonHotData_AssistanceFieldbtn);

		seasonHotData_BlockFieldbtn = new JButton("场均盖帽");
		seasonHotData_BlockFieldbtn.setBounds(X*415/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_BlockFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "blockField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_BlockFieldbtn.setVisible(false);
		add(seasonHotData_BlockFieldbtn);

		seasonHotData_StealFieldbtn = new JButton("场均抢断");
		seasonHotData_StealFieldbtn.setBounds(X*535/1366, Y*105/768, X*121/1366, Y*23/768);
		seasonHotData_StealFieldbtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "stealField";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_StealFieldbtn.setVisible(false);
		add(seasonHotData_StealFieldbtn);

		seasonHotData_ThreePointHitRatebtn = new JButton("三分命中率");
		seasonHotData_ThreePointHitRatebtn.setBounds(X*655/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_ThreePointHitRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "threePointHitRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_ThreePointHitRatebtn.setVisible(false);
		add(seasonHotData_ThreePointHitRatebtn);

		seasonHotData_HitRatebtn = new JButton("投篮命中率");
		seasonHotData_HitRatebtn.setBounds(X*776/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_HitRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "hitRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_HitRatebtn.setVisible(false);
		add(seasonHotData_HitRatebtn);

		seasonHotData_FreeThrowRatebtn = new JButton("罚球命中率");
		seasonHotData_FreeThrowRatebtn.setBounds(X*897/1366, Y*105/768, X*122/1366, Y*23/768);
		seasonHotData_FreeThrowRatebtn.addActionListener(e -> {
			seasonHotPlayerCriteria = "freeThrowRate";
			showSeasonHotTopFivePlayer(seasonHotPlayerCriteria);
		});
		seasonHotData_FreeThrowRatebtn.setVisible(false);
		add(seasonHotData_FreeThrowRatebtn);

		dailyHotPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.hotPlayerDaily(dailyHotPlayerCriteria));
		dailyHotPlayerPanel.setVisible(true);
		dailyHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*208/768);
		this.add(dailyHotPlayerPanel);
		
		
		
		
		JLabel label_1 = new JLabel("进步最快球员");
		label_1.setBounds(X*60/1366, Y*408/768, X*80/1366, Y*15/768);
		add(label_1);

		JButton seasonData_ScoreFieldbtn = new JButton("场均得分");
		seasonData_ScoreFieldbtn.setBounds(X*55/1366, Y*432/768, X*323/1366, Y*23/768);
		seasonData_ScoreFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "scoreField";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
		});
		add(seasonData_ScoreFieldbtn);

		JButton seasonData_ReboundFieldbtn = new JButton("场均篮板");
		seasonData_ReboundFieldbtn.setBounds(X*377/1366, Y*432/768, X*323/1366, Y*23/768);
		seasonData_ReboundFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "reboundField";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
		});
		add(seasonData_ReboundFieldbtn);

		JButton seasonData_AssistanceFieldbtn = new JButton("场均助攻");
		seasonData_AssistanceFieldbtn.setBounds(X*699/1366, Y*432/768, X*323/1366, Y*23/768);
		seasonData_AssistanceFieldbtn.addActionListener(e -> {
			progressFastPlayerCriteria = "assistanceField";
			showProgressFastTopFivePlayer(progressFastPlayerCriteria);
		});
		add(seasonData_AssistanceFieldbtn);

		progressFastPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.progressFastPlayer(progressFastPlayerCriteria));
		progressFastPlayerPanel.setVisible(true);
		progressFastPlayerPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*208/768);
		this.add(progressFastPlayerPanel);	
		
		
		mainFrame.getContentPane().add(this);

	}

	public void showDailyHotComponent() {

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

		showDailyHotTopFivePlayer(dailyHotPlayerCriteria);
	}

	public void showSeasonHotComponent() {
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
				player_BS.hotPlayerDaily(dailyHotPlayerCriteria));
		dailyHotPlayerPanel.setVisible(true);
		dailyHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*208/768);
		this.add(dailyHotPlayerPanel);

	}

	public void showSeasonHotTopFivePlayer(String seasonHotPlayerCriteria) {
		if (seasonHotPlayerPanel != null) {
			seasonHotPlayerPanel.setVisible(false);
		}
		if (dailyHotPlayerPanel != null) {
			dailyHotPlayerPanel.setVisible(false);
		}
		seasonHotPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.hotPlayerSeason(seasonHotPlayerCriteria));
		seasonHotPlayerPanel.setVisible(true);
		seasonHotPlayerPanel.setBounds(X*55/1366, Y*128/768, X*967/1366, Y*208/768);
		this.add(seasonHotPlayerPanel);
	}

	public void showProgressFastTopFivePlayer(String progressFastPlayerCriteria) {
		if(progressFastPlayerPanel!=null){
			progressFastPlayerPanel.setVisible(false);
		}
		
		progressFastPlayerPanel = new TopFivePlayerCardPanel(X,Y,
				player_BS.progressFastPlayer(progressFastPlayerCriteria));
		progressFastPlayerPanel.setVisible(true);
		progressFastPlayerPanel.setBounds(X*55/1366, Y*455/768, X*967/1366, Y*208/768);
		this.add(progressFastPlayerPanel);	
	
	}

	public void toSearchPlayerPanel() {
		this.setVisible(false);
		searchPlayerPanel = new SearchPanel(mainFrame);
	}

	public void toShowPlayerPanel() {
		this.setVisible(false);
		showPlayerPanel = new ShowPanel("player", mainFrame);

	}

	public void toSortPlayerPanel() {
		this.setVisible(false);
		sortPlayerPanel = new SortPanel("player", mainFrame);

	}

	public void toScreeningPlayerPanel() {
		this.setVisible(false);
		screeningPlayerPanel = new ScreeningPlayerPanel(mainFrame);

	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
		// playerCriteriaPanel.setVisible(false);
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
