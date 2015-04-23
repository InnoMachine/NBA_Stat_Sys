package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import vo.PlayerPerformanceInSingleGame;
import vo.PlayerRecentGames;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import vo.TeamRecentGames;
import vo.TeamVo;
import businessLogic.Team_BL;
import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class TeamInfoPanel extends JPanel {

	String teamABBR;
	JFrame mainFrame;
	JPanel previousPanel;
	static int X;
	static int Y;
	JLabel bgLabel;

	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	private JTabbedPane JTP;

	Vector<Vector<String>> playersRowData;
	Vector<String> playersColumn;
	private JTable playersInfoTable;
	private JScrollPane playersInfoJSP;
	Vector<Vector<String>> recentGameRowData;
	Vector<String> recentGameColumn;
	private JTable recentGameInfoTable;
	private JScrollPane recentGameInfoJSP;
	Vector<Vector<String>> historicalGameRowData;
	Vector<String> historicalGameColumn;
	private JTable historicalGameInfoTable;
	private JScrollPane historicalGameInfoJSP;

	private JLabel TeamBadge;

	Team_BS team_BS = new Team_BL();

	public TeamInfoPanel(String abbr, JFrame mainFrame, JPanel previousPanel) {
		this.mainFrame = mainFrame;
		this.teamABBR = abbr;
		this.previousPanel = previousPanel;
		previousPanel.setVisible(false);
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 10 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);

		JButton back = new JButton();
		back.setForeground(Color.WHITE);

		ImageIcon backIcon = new ImageIcon(new ImageIcon("Image/backIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));

		back.setBounds(17 * X / 20, Y * 10 / 768, X / 25, X / 25);
		back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		bgLabel.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 10 / 768, X / 25, X / 25);
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
		close.setBounds(19 * X / 20, Y * 10 / 768, X / 25, X / 25);
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

		JButton fresh = new JButton();
		ImageIcon freshIcon = new ImageIcon(
				new ImageIcon("Image/freshIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		fresh.setBounds(X * 10 / 1366, Y * 10 / 768, X / 25, X / 25);
		fresh.setIcon(freshIcon);
		fresh.setOpaque(false);
		fresh.setContentAreaFilled(false);
		fresh.setBorderPainted(false);
		fresh.addActionListener(e -> fresh());
		bgLabel.add(fresh);

		TeamBadge = new JLabel();
		TeamBadge.setOpaque(false);
		TeamBadge.setBounds(X * 65 / 1366, Y * 55 / 768, X * 150 / 1366,
				Y * 150 / 768);
		ImageIcon portrait = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ this.teamABBR + ".png").getImage()
				.getScaledInstance(TeamBadge.getWidth(), TeamBadge.getHeight(),
						Image.SCALE_SMOOTH));
		TeamBadge.setIcon(portrait);
		bgLabel.add(TeamBadge);

		// -----------------------------------------------------------------------------

		ArrayList<PlayerVo> players = new ArrayList<PlayerVo>();
		players = team_BS.getPlayers(abbr);

		if (playersRowData == null) {
			playersRowData = new Vector<Vector<String>>();
		} else {
			playersRowData.clear();
		}
		playersColumn = new Vector<String>();
		playersColumn.add("姓名");
		playersColumn.add("号码");
		playersColumn.add("命中");
		playersColumn.add("出手");
		playersColumn.add("三分命中");
		playersColumn.add("三分出手");
		playersColumn.add("罚球命中");
		playersColumn.add("罚球出手");
		playersColumn.add("进攻");
		playersColumn.add("防守");
		playersColumn.add("篮板");
		playersColumn.add("助攻");
		playersColumn.add("犯规");
		playersColumn.add("抢断");
		playersColumn.add("失误");
		playersColumn.add("盖帽");
		playersColumn.add("得分");
		playersColumn.add("More");

		for (int i = 0; i < players.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add(players.get(i).getName());
			a.add(players.get(i).getNumber());
			a.add(String.valueOf(players.get(i).getHitNumField()));
			a.add(String.valueOf(players.get(i).getShotNumField()));
			a.add(String.valueOf(players.get(i).getThreePointHitNumField()));
			a.add(String.valueOf(players.get(i).getThreePointShotNumField()));
			a.add(String.valueOf(players.get(i).getFreeThrowHitNumField()));
			a.add(String.valueOf(players.get(i).getFreeThrowShotNumField()));
			a.add(String.valueOf(players.get(i).getAttackingNumField()));
			a.add(String.valueOf(players.get(i).getDefensiveNumField()));
			a.add(String.valueOf(players.get(i).getReboundOverallField()));
			a.add(String.valueOf(players.get(i).getAssistanceField()));
			a.add(String.valueOf(players.get(i).getFoulField()));
			a.add(String.valueOf(players.get(i).getStealField()));
			a.add(String.valueOf(players.get(i).getTurnoverField()));
			a.add(String.valueOf(players.get(i).getBlockField()));
			a.add(String.valueOf(players.get(i).getScoreField()));
			playersRowData.add(a);
		}
		if (playersInfoTable != null) {
			playersInfoTable.setVisible(false);
		}

		if (playersInfoJSP != null) {
			playersInfoJSP.setVisible(false);
		}
		playersInfoTable = new JTable(playersRowData, playersColumn);
		DefaultTableCellRenderer r1 = new DefaultTableCellRenderer();
		r1.setHorizontalAlignment(JLabel.CENTER);
		playersInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 120 / 1366);
		playersInfoTable.setDefaultRenderer(Object.class, r1);
		playersInfoTable.getColumnModel().getColumn(17)
				.setCellRenderer(new MyButtonRenderer());
		playersInfoTable.setRowHeight(X * 30 / 1366);
		playersInfoJSP = new JScrollPane(playersInfoTable);
		setSize(X * 1000 / 1366, Y * 510 / 768);
		playersInfoJSP.setVisible(true);

		// ------------------------------------------------------------------------------
		TeamRecentGames teamRecentGames = new TeamRecentGames();
		teamRecentGames = team_BS.getTeamRecentPerformance(abbr);
		ArrayList<TeamPerformanceInSingleGame> fiveRecentGames = new ArrayList<TeamPerformanceInSingleGame>();
		fiveRecentGames = teamRecentGames.getFiveGames();

		if (recentGameRowData == null) {
			recentGameRowData = new Vector<Vector<String>>();
		} else {
			recentGameRowData.clear();
		}
		recentGameColumn = new Vector<String>();
		recentGameColumn.add("日期");
		recentGameColumn.add("对手");
		recentGameColumn.add("命中");
		recentGameColumn.add("出手");
		recentGameColumn.add("三分命中");
		recentGameColumn.add("三分出手");
		recentGameColumn.add("罚球命中");
		recentGameColumn.add("罚球出手");
		recentGameColumn.add("进攻");
		recentGameColumn.add("防守");
		recentGameColumn.add("篮板");
		recentGameColumn.add("助攻");
		recentGameColumn.add("犯规");
		recentGameColumn.add("抢断");
		recentGameColumn.add("失误");
		recentGameColumn.add("盖帽");
		recentGameColumn.add("得分");

		for (int i = 0; i < fiveRecentGames.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add(fiveRecentGames.get(i).getGameDate().toString());
			a.add(fiveRecentGames.get(i).getOpTeam());
			a.add(String.valueOf(fiveRecentGames.get(i).getTime()));
			a.add(String.valueOf(fiveRecentGames.get(i).getHitNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getShotNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getThreePointHitNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getThreePointShotNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getFreeThrowHitNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getFreeThrowShotNum()));
			a.add(String.valueOf(fiveRecentGames.get(i).getOffensiveRebound()));
			a.add(String.valueOf(fiveRecentGames.get(i).getDefensiveRebound()));
			a.add(String.valueOf(fiveRecentGames.get(i).getReboundOverall()));
			a.add(String.valueOf(fiveRecentGames.get(i).getAssistance()));
			a.add(String.valueOf(fiveRecentGames.get(i).getFoul()));
			a.add(String.valueOf(fiveRecentGames.get(i).getSteal()));
			a.add(String.valueOf(fiveRecentGames.get(i).getTurnover()));
			a.add(String.valueOf(fiveRecentGames.get(i).getBlock()));
			a.add(String.valueOf(fiveRecentGames.get(i).getScore()));
			recentGameRowData.add(a);
		}
		if (recentGameInfoTable != null) {
			recentGameInfoTable.setVisible(false);
		}

		if (recentGameInfoJSP != null) {
			recentGameInfoJSP.setVisible(false);
		}
		recentGameInfoTable = new JTable(recentGameRowData, recentGameColumn);
		DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		recentGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		recentGameInfoTable.setDefaultRenderer(Object.class, r2);
		recentGameInfoTable.setRowHeight(X * 30 / 1366);
		recentGameInfoJSP = new JScrollPane(recentGameInfoTable);
		setSize(X * 1000 / 1366, Y * 510 / 768);
		recentGameInfoJSP.setVisible(true);

		// ------------------------------------------------------------------------------

		ArrayList<TeamPerformanceInSingleGame> historicalGames = new ArrayList<TeamPerformanceInSingleGame>();
		historicalGames = team_BS.getTeamPerformance(abbr);

		if (historicalGameRowData == null) {
			historicalGameRowData = new Vector<Vector<String>>();
		} else {
			historicalGameRowData.clear();
		}
		historicalGameColumn = new Vector<String>();
		historicalGameColumn.add("日期");
		historicalGameColumn.add("对手");
		historicalGameColumn.add("命中");
		historicalGameColumn.add("出手");
		historicalGameColumn.add("三分命中");
		historicalGameColumn.add("三分出手");
		historicalGameColumn.add("罚球命中");
		historicalGameColumn.add("罚球出手");
		historicalGameColumn.add("进攻");
		historicalGameColumn.add("防守");
		historicalGameColumn.add("篮板");
		historicalGameColumn.add("助攻");
		historicalGameColumn.add("犯规");
		historicalGameColumn.add("抢断");
		historicalGameColumn.add("失误");
		historicalGameColumn.add("盖帽");
		historicalGameColumn.add("得分");

		for (int i = 0; i < historicalGames.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add(historicalGames.get(i).getGameDate().toString());
			a.add(historicalGames.get(i).getOpTeam());
			a.add(String.valueOf(historicalGames.get(i).getTime()));
			a.add(String.valueOf(historicalGames.get(i).getHitNum()));
			a.add(String.valueOf(historicalGames.get(i).getShotNum()));
			a.add(String.valueOf(historicalGames.get(i).getThreePointHitNum()));
			a.add(String.valueOf(historicalGames.get(i).getThreePointShotNum()));
			a.add(String.valueOf(historicalGames.get(i).getFreeThrowHitNum()));
			a.add(String.valueOf(historicalGames.get(i).getFreeThrowShotNum()));
			a.add(String.valueOf(historicalGames.get(i).getOffensiveRebound()));
			a.add(String.valueOf(historicalGames.get(i).getDefensiveRebound()));
			a.add(String.valueOf(historicalGames.get(i).getReboundOverall()));
			a.add(String.valueOf(historicalGames.get(i).getAssistance()));
			a.add(String.valueOf(historicalGames.get(i).getFoul()));
			a.add(String.valueOf(historicalGames.get(i).getSteal()));
			a.add(String.valueOf(historicalGames.get(i).getTurnover()));
			a.add(String.valueOf(historicalGames.get(i).getBlock()));
			a.add(String.valueOf(historicalGames.get(i).getScore()));
			historicalGameRowData.add(a);
		}
		if (historicalGameInfoTable != null) {
			historicalGameInfoTable.setVisible(false);
		}

		if (historicalGameInfoJSP != null) {
			historicalGameInfoJSP.setVisible(false);
		}
		historicalGameInfoTable = new JTable(historicalGameRowData,
				historicalGameColumn);
		DefaultTableCellRenderer r3 = new DefaultTableCellRenderer();
		r3.setHorizontalAlignment(JLabel.CENTER);
		historicalGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		historicalGameInfoTable.setDefaultRenderer(Object.class, r3);
		historicalGameInfoTable.setRowHeight(X * 30 / 1366);
		historicalGameInfoJSP = new JScrollPane(historicalGameInfoTable);
		setSize(X * 1000 / 1366, Y * 510 / 768);
		historicalGameInfoJSP.setVisible(true);

		// --------------------------------------------------------------------------------------------
		JTP = new JTabbedPane();
		JTP.addTab("teamPlayers", playersInfoJSP);
		JTP.addTab("currentMatches", recentGameInfoJSP);
		JTP.addTab("historicalMatches", historicalGameInfoJSP);
		JTP.setBounds(X * 183 / 1366, Y * 220 / 768, X * 1000 / 1366,
				Y * 510 / 768);
		JTP.setOpaque(false);
		bgLabel.add(JTP);

		addBasicInfo();
		addBasicData();

		mainFrame.getContentPane().add(this);
	}

	private void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
	}

	public void fresh() {

	}

	private void addBasicData() {
		TeamVo team = team_BS.getTeamByAbbr(teamABBR);
		textField_2.setText(team.getTeamName());
		textField_4.setText(team.getAbbreviation());
		textField_6.setText(team.getCity());
		textField_8.setText(String.valueOf(team.getConference()));
		textField_10.setText(String.valueOf(team.getDivision()));
		textField_12.setText(team.getHomeField());
		textField_14.setText(String.valueOf(team.getTime()));
		textField_16.setText(String.valueOf(team.getGameNum()));
	}

	private void addBasicInfo() {
		int tempX = X * 240 / 1366;
		int tempY = Y / 9;
		int spaceX = X / 12;
		int spaceY = Y / 24;

		textField_1 = new MyTextField();
		textField_1.setText("球队全名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("缩写");
		textField_3.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("所在地");
		textField_5.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_5);

		textField_6 = new MyTextField();
		textField_6.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_6);

		textField_7 = new MyTextField();
		textField_7.setText("赛区");
		textField_7.setBounds(tempX + 6 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_7);

		textField_8 = new MyTextField();
		textField_8.setBounds(tempX + 7 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_8);

		textField_9 = new MyTextField();
		textField_9.setText("分区");
		textField_9.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_9);

		textField_10 = new MyTextField();
		textField_10.setBounds(tempX + 1 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_10);

		textField_11 = new MyTextField();
		textField_11.setText("主场");
		textField_11.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_11);

		textField_12 = new MyTextField();
		textField_12.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_12);

		textField_13 = new MyTextField();
		textField_13.setText("建立时间");
		textField_13.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_13);

		textField_14 = new MyTextField();
		textField_14.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_14);

		textField_15 = new MyTextField();
		textField_15.setText("比赛场数");
		textField_15.setBounds(tempX + 6 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_15);

		textField_16 = new MyTextField();
		textField_16.setBounds(tempX + 7 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_16);

	}
	
	public void selfClose(){
		this.setVisible(false);
	}

	class MyButtonRenderer extends JButton implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object arg1, boolean isFocus, boolean isSelected, int arg4,
				int arg5) {
			// TODO Auto-generated method stub
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					X * 122 / 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);

			if (isSelected) {
				selfClose();
				PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(
						String.valueOf(playersInfoTable.getModel().getValueAt(
								playersInfoTable.getSelectedRow(), 0)),
						mainFrame, new TeamInfoPanel(teamABBR, mainFrame,
								previousPanel));
			}
			return this;
		}

	}

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setForeground(Color.BLACK);
			this.setFont(new Font("黑体", 1, 13));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setColumns(X * 10 / 1366);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
