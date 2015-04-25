package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import businessLogic.test;
import ui.ShowPanel.MyTextField;
import ui.TeamInfoPanel.MyTableRenderer;
import vo.PlayerGames;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerRecentGames;
import vo.PlayerVo;
import vo.TotalInfo;

public class PlayerInfoPanel extends JPanel {

	JFrame mainFrame;
	JPanel previousPanel;
	String playerName;
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
	private JTextField textField_17;
	private JTextField textField_18;

	private JLabel playerPortrait;
	private JLabel playerAction;
	private JButton teambtn;
	private JButton recentbtn;
	private JButton historicalbtn;
	private JButton vsbtn;

	private JLabel contentlbl;

	Vector<Vector<String>> recentGameRowData;
	Vector<String> recentGameColumn;
	private JTable recentGameInfoTable;
	private JScrollPane recentGameInfoJSP;
	Vector<Vector<String>> historicalGameRowData;
	Vector<String> historicalGameColumn;
	private JTable historicalGameInfoTable;
	private JScrollPane historicalGameInfoJSP;

	private JTextField txtPgamenum;
	private JTextField txtPminute;
	private JTextField txtPscorefield;
	private JTextField txtPassistancefield;
	private JTextField txtPreboundfield;
	private JTextField txtPhitnum;
	private JTextField txtP3prate;
	private JTextField txtPfreethrowrate;
	private JTextField txtPsteal;
	private JTextField txtPblock;
	private JTextField txtPturnover;
	private JTextField txtPfoul;
	private JTextField txtAgamenum;
	private JTextField txtAminute;
	private JTextField txtAscorefield;
	private JTextField txtAassistancefield;
	private JTextField txtAreboundfield;
	private JTextField txtAhitnum;
	private JTextField txtAprate;
	private JTextField txtAfreethrowrate;
	private JTextField txtAsteal;
	private JTextField txtAblock;
	private JTextField txtAturnover;
	private JTextField txtAfoul;

	Player_BS player_BS = new Player_BL_Stub();

	public PlayerInfoPanel(String playerName, JFrame mainFrame,
			JPanel previousPanel) {

		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		previousPanel.setVisible(false);
		this.playerName = playerName;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		System.out.println(X + "   " + Y);

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/sortPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);

		playerPortrait = new JLabel();
		playerPortrait.setBounds(X * 90 / 1366, Y * 60 / 768, X * 130 / 1366,
				Y * 130 / 768);

		ImageIcon portrait;
		if (hasPortrait(playerName + ".png")) {
			portrait = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
					+ playerName + ".png").getImage().getScaledInstance(
					playerPortrait.getWidth(), playerPortrait.getHeight(),
					Image.SCALE_SMOOTH));
		} else {
			portrait = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
					+ "DefaultPortrait" + ".png").getImage().getScaledInstance(
					playerPortrait.getWidth(), playerPortrait.getHeight(),
					Image.SCALE_SMOOTH));
		}
		playerPortrait.setIcon(portrait);

		bgLabel.add(playerPortrait);

		teambtn = new JButton();
		teambtn.setBounds(X * 1070 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 130 / 768);
		ImageIcon team = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ player_BS.getPlayerByName(playerName).getTeam() + ".png")
				.getImage().getScaledInstance(playerPortrait.getWidth(),
						playerPortrait.getHeight(), Image.SCALE_SMOOTH));
		teambtn.setIcon(team);
		teambtn.addActionListener(e -> {
			this.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(player_BS
					.getPlayerByName(playerName).getTeam(), mainFrame, this);
		});
		teambtn.setOpaque(false);
		teambtn.setContentAreaFilled(false);
		teambtn.setBorderPainted(false);
		bgLabel.add(teambtn);

		playerAction = new JLabel();
		playerAction
				.setBounds(X * 1060 / 1366, Y * 240 / 768, X / 4, 2 * Y / 3);

		ImageIcon action;
		if (hasAction(playerName + ".png")) {
			action = new ImageIcon(new ImageIcon("CSEdata/players/action/"
					+ playerName + ".png").getImage().getScaledInstance(
					playerAction.getWidth(), playerAction.getHeight(),
					Image.SCALE_SMOOTH));
		} else {
			action = new ImageIcon(new ImageIcon("CSEdata/players/action/"
					+ "DefaultAction" + ".png").getImage().getScaledInstance(
					playerAction.getWidth(), playerAction.getHeight(),
					Image.SCALE_SMOOTH));
		}

		playerAction.setIcon(action);
		bgLabel.add(playerAction);

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
		bgLabel.add(home);

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
		bgLabel.add(back);

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

		bgLabel.add(minimize);

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
		bgLabel.add(close);

		contentlbl = new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);

		bgLabel.add(contentlbl);

		recentbtn = new MyButton("近期比赛⊙");
		recentbtn.setBounds(X * 90 / 1366, Y * 220 / 768, X * 150 / 1366,
				Y * 30 / 768);
		recentbtn.addActionListener(e -> {
			showRecentData();
			recentbtn.setText("近期比赛⊙");
			historicalbtn.setText("过往数据");
			vsbtn.setText("数据对比");
		});

		historicalbtn = new MyButton("过往数据");
		historicalbtn.setBounds(X * 240 / 1366, Y * 220 / 768, X * 150 / 1366,
				Y * 30 / 768);
		historicalbtn.addActionListener(e -> {
			showHistoricalData();
			recentbtn.setText("近期比赛");
			historicalbtn.setText("过往数据⊙");
			vsbtn.setText("数据对比");
		});

		vsbtn = new MyButton("数据对比");
		vsbtn.setBounds(X * 390 / 1366, Y * 220 / 768, X * 150 / 1366,
				Y * 30 / 768);
		vsbtn.addActionListener(e -> {
			showVSData();
			recentbtn.setText("近期比赛");
			historicalbtn.setText("过往数据");
			vsbtn.setText("数据对比⊙");
		});

		addBasicInfo();
		addBasicData();
		showRecentData();
		mainFrame.getContentPane().add(this);
	}

	public void showRecentData() {
		PlayerRecentGames recentGames = new PlayerRecentGames();
		recentGames = player_BS.getPlayerRecentPerformance(playerName);
		ArrayList<PlayerPerformanceInSingleGame> recentFiveGames = new ArrayList<PlayerPerformanceInSingleGame>();
		recentFiveGames = recentGames.getFiveGames();

		if (recentGameRowData == null) {
			recentGameRowData = new Vector<Vector<String>>();
		} else {
			recentGameRowData.clear();
		}
		recentGameColumn = new Vector<String>();
		recentGameColumn.add("日期");
		recentGameColumn.add("对手");
		recentGameColumn.add("分钟");
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

		for (int i = 0; i < recentFiveGames.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add(recentFiveGames.get(i).getDate());
			a.add(recentFiveGames.get(i).getOpTeam());
			a.add(String.valueOf(recentFiveGames.get(i).getTime()));
			a.add(String.valueOf(recentFiveGames.get(i).getHitNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getShotNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getThreePointHitNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getThreePointShotNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getFreeThrowHitNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getFreeThrowShotNum()));
			a.add(String.valueOf(recentFiveGames.get(i).getOffensiveRebound()));
			a.add(String.valueOf(recentFiveGames.get(i).getDefensiveRebound()));
			a.add(String.valueOf(recentFiveGames.get(i).getReboundOverall()));
			a.add(String.valueOf(recentFiveGames.get(i).getAssistance()));
			a.add(String.valueOf(recentFiveGames.get(i).getFoul()));
			a.add(String.valueOf(recentFiveGames.get(i).getSteal()));
			a.add(String.valueOf(recentFiveGames.get(i).getTurnover()));
			a.add(String.valueOf(recentFiveGames.get(i).getBlock()));
			a.add(String.valueOf(recentFiveGames.get(i).getScore()));
			recentGameRowData.add(a);
		}

		if (recentGameInfoTable != null) {
			recentGameInfoTable.setVisible(false);
		}

		if (recentGameInfoJSP != null) {
			recentGameInfoJSP.setVisible(false);
		}

		recentGameInfoTable = new JTable(recentGameRowData, recentGameColumn);
		JTableHeader header = recentGameInfoTable.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);

		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		recentGameInfoTable.setDefaultRenderer(Object.class, r2);

		recentGameInfoTable.setForeground(Color.WHITE);
		recentGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);

		recentGameInfoTable.setRowHeight(X * 20 / 1366);

		recentGameInfoJSP = new JScrollPane(recentGameInfoTable);
		recentGameInfoJSP.setSize(X * 1000 / 1366, Y * 480 / 768);
		recentGameInfoJSP.setVisible(true);
		if (contentlbl != null) {
			contentlbl.setVisible(false);
		}
		contentlbl = new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);
		contentlbl.add(recentGameInfoJSP);
		bgLabel.add(contentlbl);

	}

	public void showHistoricalData() {
		ArrayList<PlayerPerformanceInSingleGame> historicalGames = new ArrayList<PlayerPerformanceInSingleGame>();
		historicalGames = player_BS.getPlayerPerformacne(playerName).getGames();

		if (historicalGameRowData == null) {
			historicalGameRowData = new Vector<Vector<String>>();
		} else {
			historicalGameRowData.clear();
		}
		historicalGameColumn = new Vector<String>();
		historicalGameColumn.add("日期");
		historicalGameColumn.add("对手");
		historicalGameColumn.add("分钟");
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
			a.add(historicalGames.get(i).getDate());
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

		JTableHeader header = historicalGameInfoTable.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		
		
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		historicalGameInfoTable.setDefaultRenderer(Object.class, r2);

		historicalGameInfoTable.setForeground(Color.WHITE);
		historicalGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		historicalGameInfoTable.setRowHeight(X * 20 / 1366);

		historicalGameInfoJSP = new JScrollPane(historicalGameInfoTable);
		historicalGameInfoJSP.setSize(X * 1000 / 1366, Y * 480 / 768);
		historicalGameInfoJSP.setVisible(true);
		if (contentlbl != null) {
			contentlbl.setVisible(false);
		}
		contentlbl = new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);
		contentlbl.add(historicalGameInfoJSP);
		bgLabel.add(contentlbl);
	}

	public void showVSData() {

		if (contentlbl != null) {
			contentlbl.setVisible(false);
		}
		contentlbl = new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);

		DecimalFormat df = new DecimalFormat(".00");

		TotalInfo aveInfo = new TotalInfo();
		aveInfo = player_BS.getTotalInfo();
		PlayerVo playerInfo = new PlayerVo();
		playerInfo = player_BS.getPlayerByName(playerName);

		MyLabel namelbl = new MyLabel();
		namelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		namelbl.setBounds(0, 0, X * 450 / 1366, Y * 35 / 768);
		namelbl.setText(playerName + "  ");
		namelbl.setBackground(Color.DARK_GRAY);
		namelbl.setOpaque(true);
		namelbl.setFont(new Font("黑体", 1, 20));
		contentlbl.add(namelbl);

		MyLabel nAtlbl = new MyLabel("号码/球队");
		nAtlbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nAtlbl.setBounds(0, Y * 35 / 768, X * 450 / 1366, Y * 15 / 768);
		nAtlbl.setText(player_BS.getPlayerByName(playerName).getNumber() + "/"
				+ player_BS.getPlayerByName(playerName).getTeam() + "   ");
		nAtlbl.setBackground(Color.DARK_GRAY);
		nAtlbl.setOpaque(true);
		nAtlbl.setFont(new Font("黑体", 0, 13));
		contentlbl.add(nAtlbl);

		MyLabel vslbl = new MyLabel("VS");
		vslbl.setHorizontalAlignment(SwingConstants.CENTER);
		vslbl.setBounds(X * 450 / 1366, 0, X * 100 / 1366, Y * 50 / 768);
		vslbl.setBackground(Color.LIGHT_GRAY);
		vslbl.setOpaque(true);
		vslbl.setFont(new Font("黑体", 1, 24));
		contentlbl.add(vslbl);

		MyLabel nbaAvelbl = new MyLabel("  NBA联盟平均数据");
		nbaAvelbl.setBounds(X * 550 / 1366, 0, X * 450 / 1366, Y * 35 / 768);
		nbaAvelbl.setBackground(Color.DARK_GRAY);
		nbaAvelbl.setOpaque(true);
		nbaAvelbl.setFont(new Font("黑体", 1, 20));
		contentlbl.add(nbaAvelbl);

		MyLabel nonelbl = new MyLabel();
		nonelbl.setHorizontalAlignment(SwingConstants.RIGHT);
		nonelbl.setBounds(X * 550 / 1366, Y * 35 / 768, X * 450 / 1366,
				Y * 15 / 768);
		nonelbl.setBackground(Color.DARK_GRAY);
		nonelbl.setOpaque(true);
		nonelbl.setFont(new Font("黑体", 0, 13));
		contentlbl.add(nonelbl);

		MyLabel seasonDatalbl = new MyLabel("赛季数据");
		seasonDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		seasonDatalbl.setBounds(0, Y * 50 / 768, X * 1000 / 1366, Y * 20 / 768);
		seasonDatalbl.setBackground(Color.GRAY);
		seasonDatalbl.setForeground(Color.WHITE);
		seasonDatalbl.setOpaque(true);
		contentlbl.add(seasonDatalbl);

		MyLabel gameNumlbl = new MyLabel("参赛场数");
		gameNumlbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameNumlbl.setBounds(X * 425 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(gameNumlbl);

		MyLabel minutelbl = new MyLabel("分钟");
		minutelbl.setHorizontalAlignment(SwingConstants.CENTER);
		minutelbl.setBounds(X * 425 / 1366, Y * 104 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(minutelbl);

		MyLabel scoreFieldlbl = new MyLabel("场均得分");
		scoreFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreFieldlbl.setBounds(X * 425 / 1366, Y * 138 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(scoreFieldlbl);

		MyLabel assistanceFieldlbl = new MyLabel("场均助攻");
		assistanceFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		assistanceFieldlbl.setBounds(X * 425 / 1366, Y * 172 / 768,
				X * 150 / 1366, Y * 34 / 768);
		contentlbl.add(assistanceFieldlbl);

		MyLabel reboundFieldlbl = new MyLabel("场均篮板");
		reboundFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		reboundFieldlbl.setBounds(X * 425 / 1366, Y * 206 / 768,
				X * 150 / 1366, Y * 34 / 768);
		contentlbl.add(reboundFieldlbl);

		MyLabel hitlbl = new MyLabel("投篮命中数");
		hitlbl.setHorizontalAlignment(SwingConstants.CENTER);
		hitlbl.setBounds(X * 425 / 1366, Y * 240 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(hitlbl);

		MyLabel tpHitRatelbl = new MyLabel("三分命中率");
		tpHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		tpHitRatelbl.setBounds(X * 425 / 1366, Y * 274 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(tpHitRatelbl);

		MyLabel ftHitRatelbl = new MyLabel("罚球命中率");
		ftHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		ftHitRatelbl.setBounds(X * 425 / 1366, Y * 308 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(ftHitRatelbl);

		MyLabel stealFieldlbl = new MyLabel("场均抢断");
		stealFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		stealFieldlbl.setBounds(X * 425 / 1366, Y * 342 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(stealFieldlbl);

		MyLabel blockFieldlbl = new MyLabel("场均盖帽");
		blockFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		blockFieldlbl.setBounds(X * 425 / 1366, Y * 376 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(blockFieldlbl);

		MyLabel turnoverlbl = new MyLabel("失误");
		turnoverlbl.setHorizontalAlignment(SwingConstants.CENTER);
		turnoverlbl.setBounds(X * 425 / 1366, Y * 410 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(turnoverlbl);

		MyLabel foullbl = new MyLabel("犯规");
		foullbl.setHorizontalAlignment(SwingConstants.CENTER);
		foullbl.setBounds(X * 425 / 1366, Y * 444 / 768, X * 150 / 1366,
				Y * 34 / 768);
		contentlbl.add(foullbl);

		JLabel lblPlayergamenum = new JLabel();
		lblPlayergamenum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayergamenum.setBounds(X * (425 - playerInfo.getGameNum() * 3)
				/ 1366, Y * 75 / 768, X * (playerInfo.getGameNum() * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getGameNum() >= aveInfo.getGamenumField()) {
			lblPlayergamenum.setBackground(Color.BLUE);
		} else {
			lblPlayergamenum.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayergamenum.setOpaque(true);
		contentlbl.add(lblPlayergamenum);

		JLabel lblPlayerminute = new JLabel();
		lblPlayerminute.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerminute.setBounds(X
				* (425 - (int) (playerInfo.getTimeField() / 60.0 * 3)) / 1366,
				Y * 109 / 768,
				X * ((int) (playerInfo.getTimeField() / 60.0) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getTimeField() >= aveInfo.getTime()) {
			lblPlayerminute.setBackground(Color.BLUE);
		} else {
			lblPlayerminute.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerminute.setOpaque(true);
		contentlbl.add(lblPlayerminute);

		JLabel lblPlayerscorefield = new JLabel();
		lblPlayerscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerscorefield.setBounds(
				X
						* (425 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getScoreField())) * 3)
						/ 1366,
				Y * 143 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(playerInfo.getScoreField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getScoreField() >= aveInfo.getScoreField()) {
			lblPlayerscorefield.setBackground(Color.BLUE);
		} else {
			lblPlayerscorefield.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerscorefield.setOpaque(true);
		contentlbl.add(lblPlayerscorefield);

		JLabel lblPlayerassistancefield = new JLabel();
		lblPlayerassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerassistancefield
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getAssistanceField())) * 3)
								/ 1366,
						Y * 177 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getAssistanceField())) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getAssistanceField() >= aveInfo.getAssistanceField()) {
			lblPlayerassistancefield.setBackground(Color.BLUE);
		} else {
			lblPlayerassistancefield.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerassistancefield.setOpaque(true);
		contentlbl.add(lblPlayerassistancefield);

		JLabel lblPlayerreboundfield = new JLabel();
		lblPlayerreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerreboundfield
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getReboundOverallField())) * 3)
								/ 1366,
						Y * 211 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getReboundOverallField())) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getReboundOverallField() >= aveInfo.getReboundField()) {
			lblPlayerreboundfield.setBackground(Color.BLUE);
		} else {
			lblPlayerreboundfield.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerreboundfield.setOpaque(true);
		contentlbl.add(lblPlayerreboundfield);

		JLabel lblPlayerhitnum = new JLabel();
		lblPlayerhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerhitnum.setBounds(
				X
						* (425 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getHitNumField())) * 3)
						/ 1366,
				Y * 245 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(playerInfo.getHitNumField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getHitNumField() >= aveInfo.getHitField()) {
			lblPlayerhitnum.setBackground(Color.BLUE);
		} else {
			lblPlayerhitnum.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerhitnum.setOpaque(true);
		contentlbl.add(lblPlayerhitnum);

		JLabel lblPlayer3prate = new JLabel();
		lblPlayer3prate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer3prate
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getThreePointHitRate() * 100)) * 3)
								/ 1366,
						Y * 279 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getThreePointHitRate() * 100)) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getThreePointHitRate() >= aveInfo.getThreeRate()) {
			lblPlayer3prate.setBackground(Color.BLUE);
		} else {
			lblPlayer3prate.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayer3prate.setOpaque(true);
		contentlbl.add(lblPlayer3prate);

		JLabel lblPlayerfreethrowrate = new JLabel();
		lblPlayerfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerfreethrowrate
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getFreeThrowRate() * 100)) * 3)
								/ 1366,
						Y * 313 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getFreeThrowRate() * 100)) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getFreeThrowRate() >= aveInfo.getFreeRate()) {
			lblPlayerfreethrowrate.setBackground(Color.BLUE);
		} else {
			lblPlayerfreethrowrate.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerfreethrowrate.setOpaque(true);
		contentlbl.add(lblPlayerfreethrowrate);

		JLabel lblPlayersteal = new JLabel();
		lblPlayersteal.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayersteal.setBounds(
				X
						* (425 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getStealField())) * 3)
						/ 1366,
				Y * 347 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(playerInfo.getStealField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getStealField() >= aveInfo.getStealField()) {
			lblPlayersteal.setBackground(Color.BLUE);
		} else {
			lblPlayersteal.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayersteal.setOpaque(true);
		contentlbl.add(lblPlayersteal);

		JLabel lblPlayerblock = new JLabel();
		lblPlayerblock.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerblock.setBounds(
				X
						* (425 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getBlockField())) * 3)
						/ 1366,
				Y * 381 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(playerInfo.getBlockField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getBlockField() >= aveInfo.getBlockField()) {
			lblPlayerblock.setBackground(Color.BLUE);
		} else {
			lblPlayerblock.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerblock.setOpaque(true);
		contentlbl.add(lblPlayerblock);

		JLabel lblPlayerturnover = new JLabel();
		lblPlayerturnover.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerturnover
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getTurnoverField())) * 3)
								/ 1366,
						Y * 415 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getTurnoverField())) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getTurnoverField() >= aveInfo.getTurnoverField()) {
			lblPlayerturnover.setBackground(Color.BLUE);
		} else {
			lblPlayerturnover.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerturnover.setOpaque(true);
		contentlbl.add(lblPlayerturnover);

		JLabel lblPlayerfoul = new JLabel();
		lblPlayerfoul.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerfoul
				.setBounds(
						X
								* (425 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getFoulField())) * 3) / 1366,
						Y * 449 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getFoulField())) * 3) / 1366,
						Y * 24 / 768);
		if (playerInfo.getFoulField() >= aveInfo.getFoulField()) {
			lblPlayerfoul.setBackground(Color.BLUE);
		} else {
			lblPlayerfoul.setBackground(Color.LIGHT_GRAY);
		}
		lblPlayerfoul.setOpaque(true);
		contentlbl.add(lblPlayerfoul);

		JLabel lblAvegamenum = new JLabel();
		lblAvegamenum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvegamenum
				.setBounds(
						X * 575 / 1366,
						Y * 75 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(aveInfo
												.getGamenumField())) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getGameNum() >= aveInfo.getGamenumField()) {
			lblAvegamenum.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvegamenum.setBackground(Color.BLUE);
		}
		lblAvegamenum.setOpaque(true);
		contentlbl.add(lblAvegamenum);

		JLabel lblAveminute = new JLabel();
		lblAveminute.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveminute.setBounds(X * 575 / 1366, Y * 109 / 768, X
				* ((int) (aveInfo.getTime() / 60.0 * 3)) / 1366, Y * 24 / 768);
		if (playerInfo.getTimeField() >= aveInfo.getTime()) {
			lblAveminute.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAveminute.setBackground(Color.BLUE);
		}
		lblAveminute.setOpaque(true);
		contentlbl.add(lblAveminute);

		JLabel lblAvescorefield = new JLabel();
		lblAvescorefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvescorefield.setBounds(
				X * 575 / 1366,
				Y * 143 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getScoreField())) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getScoreField() >= aveInfo.getScoreField()) {
			lblAvescorefield.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvescorefield.setBackground(Color.BLUE);
		}
		lblAvescorefield.setOpaque(true);
		contentlbl.add(lblAvescorefield);

		JLabel lblAveassistancefield = new JLabel();
		lblAveassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveassistancefield.setBounds(
				X * 575 / 1366,
				Y * 177 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getAssistanceField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getAssistanceField() >= aveInfo.getAssistanceField()) {
			lblAveassistancefield.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAveassistancefield.setBackground(Color.BLUE);
		}
		lblAveassistancefield.setOpaque(true);
		contentlbl.add(lblAveassistancefield);

		JLabel lblAvereboundfield = new JLabel();
		lblAvereboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvereboundfield
				.setBounds(
						X * 575 / 1366,
						Y * 211 / 768,
						X
								* (Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(aveInfo
												.getReboundField())) * 3)
								/ 1366, Y * 24 / 768);
		if (playerInfo.getReboundOverallField() >= aveInfo.getReboundField()) {
			lblAvereboundfield.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvereboundfield.setBackground(Color.BLUE);
		}
		lblAvereboundfield.setOpaque(true);
		contentlbl.add(lblAvereboundfield);

		JLabel lblAvehitnum = new JLabel();
		lblAvehitnum.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvehitnum.setBounds(
				X * 575 / 1366,
				Y * 245 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getHitField())) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getHitNumField() >= aveInfo.getHitField()) {
			lblAvehitnum.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvehitnum.setBackground(Color.BLUE);
		}
		lblAvehitnum.setOpaque(true);
		contentlbl.add(lblAvehitnum);

		JLabel lblAve3prate = new JLabel();
		lblAve3prate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAve3prate.setBounds(
				X * 575 / 1366,
				Y * 279 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getThreeRate() * 100)) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getThreePointHitRate() >= aveInfo.getThreeRate()) {
			lblAve3prate.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAve3prate.setBackground(Color.BLUE);
		}
		lblAve3prate.setOpaque(true);
		contentlbl.add(lblAve3prate);

		JLabel lblAvefreethrowrate = new JLabel();
		lblAvefreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvefreethrowrate.setBounds(
				X * 575 / 1366,
				Y * 313 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getFreeRate() * 100)) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getFreeThrowRate() >= aveInfo.getFreeRate()) {
			lblAvefreethrowrate.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvefreethrowrate.setBackground(Color.BLUE);
		}
		lblAvefreethrowrate.setOpaque(true);
		contentlbl.add(lblAvefreethrowrate);

		JLabel lblAvesteal = new JLabel();
		lblAvesteal.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvesteal.setBounds(
				X * 575 / 1366,
				Y * 347 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getStealField())) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getStealField() >= aveInfo.getStealField()) {
			lblAvesteal.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvesteal.setBackground(Color.BLUE);
		}
		lblAvesteal.setOpaque(true);
		contentlbl.add(lblAvesteal);

		JLabel lblAveblock = new JLabel();
		lblAveblock.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveblock.setBounds(
				X * 575 / 1366,
				Y * 381 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getBlockField())) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getBlockField() >= aveInfo.getBlockField()) {
			lblAveblock.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAveblock.setBackground(Color.BLUE);
		}
		lblAveblock.setOpaque(true);
		contentlbl.add(lblAveblock);

		JLabel lblAveturnover = new JLabel();
		lblAveturnover.setHorizontalAlignment(SwingConstants.CENTER);
		lblAveturnover.setBounds(
				X * 575 / 1366,
				Y * 415 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getTurnoverField())) * 3)
						/ 1366, Y * 24 / 768);
		if (playerInfo.getTurnoverField() >= aveInfo.getTurnoverField()) {
			lblAveturnover.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAveturnover.setBackground(Color.BLUE);
		}
		lblAveturnover.setOpaque(true);
		contentlbl.add(lblAveturnover);

		JLabel lblAvefoul = new JLabel();
		lblAvefoul.setHorizontalAlignment(SwingConstants.CENTER);
		lblAvefoul.setBounds(
				X * 575 / 1366,
				Y * 449 / 768,
				X
						* (Integer.parseInt(new java.text.DecimalFormat("0")
								.format(aveInfo.getFoulField())) * 3) / 1366,
				Y * 24 / 768);
		if (playerInfo.getFoulField() >= aveInfo.getFoulField()) {
			lblAvefoul.setBackground(Color.LIGHT_GRAY);
		} else {
			lblAvefoul.setBackground(Color.BLUE);
		}
		lblAvefoul.setOpaque(true);
		contentlbl.add(lblAvefoul);

		txtPgamenum = new MyDataTextField();
		txtPgamenum.setText("pGameNum");
		txtPgamenum.setHorizontalAlignment(SwingConstants.CENTER);
		txtPgamenum.setBounds(X * (355 - playerInfo.getGameNum() * 3) / 1366,
				75, X * 60 / 1366, Y * 24 / 768);
		txtPgamenum.setColumns(Y * 10 / 768);
		txtPgamenum.setText(String.valueOf(playerInfo.getGameNum()));
		txtPgamenum.setOpaque(false);
		txtPgamenum.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPgamenum);

		txtPminute = new MyDataTextField();
		txtPminute.setText("pMinute");
		txtPminute.setHorizontalAlignment(SwingConstants.CENTER);
		txtPminute.setColumns(Y * 10 / 768);
		txtPminute
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getTimeField() / 60.0)) * 3)
								/ 1366, Y * 109 / 768, X * 60 / 1366,
						Y * 24 / 768);
		txtPminute
				.setText(String.valueOf(df.format(playerInfo.getTimeField() / 60.0)));
		txtPminute.setOpaque(false);
		txtPminute.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPminute);

		txtPscorefield = new MyDataTextField();
		txtPscorefield.setText("pScoreField");
		txtPscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPscorefield.setColumns(Y * 10 / 768);
		txtPscorefield.setBounds(
				X
						* (355 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getScoreField())) * 3)
						/ 1366, 143, X * 60 / 1366, Y * 24 / 768);
		txtPscorefield.setText(String.valueOf(playerInfo.getScoreField()));
		txtPscorefield.setOpaque(false);
		txtPscorefield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPscorefield);

		txtPassistancefield = new MyDataTextField();
		txtPassistancefield.setText("pAssistanceField");
		txtPassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassistancefield.setColumns(Y * 10 / 768);
		txtPassistancefield
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getAssistanceField())) * 3)
								/ 1366, 177, X * 60 / 1366, Y * 24 / 768);
		txtPassistancefield.setText(String.valueOf(playerInfo
				.getAssistanceField()));
		txtPassistancefield.setOpaque(false);
		txtPassistancefield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPassistancefield);

		txtPreboundfield = new MyDataTextField();
		txtPreboundfield.setText("pReboundField");
		txtPreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		txtPreboundfield.setColumns(Y * 10 / 768);
		txtPreboundfield
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getReboundOverallField())) * 3)
								/ 1366, 211, X * 60 / 1366, Y * 24 / 768);
		txtPreboundfield.setText(String.valueOf(playerInfo
				.getReboundOverallField()));
		txtPreboundfield.setOpaque(false);
		txtPreboundfield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPreboundfield);

		txtPhitnum = new MyDataTextField();
		txtPhitnum.setText("pHitNum");
		txtPhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		txtPhitnum.setColumns(Y * 10 / 768);
		txtPhitnum.setBounds(
				X
						* (355 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getHitNumField())) * 3)
						/ 1366, 245, X * 60 / 1366, Y * 24 / 768);
		txtPhitnum.setText(String.valueOf(playerInfo.getHitNumField()));
		txtPhitnum.setOpaque(false);
		txtPhitnum.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPhitnum);

		txtP3prate = new MyDataTextField();
		txtP3prate.setText("p3PRate");
		txtP3prate.setHorizontalAlignment(SwingConstants.CENTER);
		txtP3prate.setColumns(Y * 10 / 768);
		txtP3prate
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getThreePointHitRate() * 100)) * 3)
								/ 1366, 279, X * 60 / 1366, Y * 24 / 768);
		txtP3prate
				.setText(String.valueOf(playerInfo.getThreePointHitRate() * 100));
		txtP3prate.setOpaque(false);
		txtP3prate.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtP3prate);

		txtPfreethrowrate = new MyDataTextField();
		txtPfreethrowrate.setText("pFreeThrowRate");
		txtPfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		txtPfreethrowrate.setColumns(Y * 10 / 768);
		txtPfreethrowrate
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getFreeThrowRate() * 100)) * 3)
								/ 1366, 313, X * 60 / 1366, Y * 24 / 768);
		txtPfreethrowrate
				.setText(String.valueOf(playerInfo.getFreeThrowRate() * 100));
		txtPfreethrowrate.setOpaque(false);
		txtPfreethrowrate.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPfreethrowrate);

		txtPsteal = new MyDataTextField();
		txtPsteal.setText("pSteal");
		txtPsteal.setHorizontalAlignment(SwingConstants.CENTER);
		txtPsteal.setColumns(Y * 10 / 768);
		txtPsteal.setBounds(
				X
						* (355 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getStealField())) * 3)
						/ 1366, 347, X * 60 / 1366, Y * 24 / 768);
		txtPsteal.setText(String.valueOf(playerInfo.getStealField()));
		txtPsteal.setOpaque(false);
		txtPsteal.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPsteal);

		txtPblock = new MyDataTextField();
		txtPblock.setText("pBlock");
		txtPblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtPblock.setColumns(Y * 10 / 768);
		txtPblock.setBounds(
				X
						* (355 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getBlockField())) * 3)
						/ 1366, 381, X * 60 / 1366, Y * 24 / 768);
		txtPblock.setText(String.valueOf(playerInfo.getBlockField()));
		txtPblock.setOpaque(false);
		txtPblock.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPblock);

		txtPturnover = new MyDataTextField();
		txtPturnover.setText("pTurnOver");
		txtPturnover.setHorizontalAlignment(SwingConstants.CENTER);
		txtPturnover.setColumns(Y * 10 / 768);
		txtPturnover
				.setBounds(
						X
								* (355 - Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getTurnoverField())) * 3)
								/ 1366, 415, X * 60 / 1366, Y * 24 / 768);
		txtPturnover.setText(String.valueOf(playerInfo.getTurnoverField()));
		txtPturnover.setOpaque(false);
		txtPturnover.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPturnover);

		txtPfoul = new MyDataTextField();
		txtPfoul.setText("pFoul");
		txtPfoul.setHorizontalAlignment(SwingConstants.CENTER);
		txtPfoul.setColumns(Y * 10 / 768);
		txtPfoul.setBounds(
				X
						* (355 - Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getFoulField())) * 3)
						/ 1366, 449, X * 60 / 1366, Y * 24 / 768);
		txtPfoul.setText(String.valueOf(playerInfo.getFoulField()));
		txtPfoul.setOpaque(false);
		txtPfoul.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtPfoul);

		txtAgamenum = new MyDataTextField();
		txtAgamenum.setText("aGameNum");
		txtAgamenum.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgamenum.setColumns(Y * 10 / 768);
		txtAgamenum.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getGamenumField())) * 3)
						/ 1366, Y * 75 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAgamenum.setText(String.valueOf(aveInfo.getGamenumField()));
		txtAgamenum.setOpaque(false);
		txtAgamenum.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAgamenum);

		txtAminute = new MyDataTextField();
		txtAminute.setText("aMinute");
		txtAminute.setHorizontalAlignment(SwingConstants.CENTER);
		txtAminute.setColumns(Y * 10 / 768);
		txtAminute.setBounds(X * (585 + (int) (aveInfo.getTime() / 60.0) * 3)
				/ 1366, Y * 109 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAminute.setText(String.valueOf(df.format(aveInfo.getTime() / 60.0)));
		txtAminute.setOpaque(false);
		txtAminute.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAminute);

		txtAscorefield = new MyDataTextField();
		txtAscorefield.setText("aScoreField");
		txtAscorefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAscorefield.setColumns(Y * 10 / 768);
		txtAscorefield.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getScoreField())) * 3)
						/ 1366, Y * 143 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAscorefield.setText(String.valueOf(aveInfo.getScoreField()));
		txtAscorefield.setOpaque(false);
		txtAscorefield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAscorefield);

		txtAassistancefield = new MyDataTextField();
		txtAassistancefield.setText("aAssistanceField");
		txtAassistancefield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAassistancefield.setColumns(Y * 10 / 768);
		txtAassistancefield.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getAssistanceField())) * 3)
						/ 1366, Y * 177 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAassistancefield
				.setText(String.valueOf(aveInfo.getAssistanceField()));
		txtAassistancefield.setOpaque(false);
		txtAassistancefield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAassistancefield);

		txtAreboundfield = new MyDataTextField();
		txtAreboundfield.setText("aReboundField");
		txtAreboundfield.setHorizontalAlignment(SwingConstants.CENTER);
		txtAreboundfield.setColumns(Y * 10 / 768);
		txtAreboundfield.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getReboundField())) * 3)
						/ 1366, Y * 211 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAreboundfield.setText(String.valueOf(aveInfo.getReboundField()));
		txtAreboundfield.setOpaque(false);
		txtAreboundfield.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAreboundfield);

		txtAhitnum = new MyDataTextField();
		txtAhitnum.setText("aHitNum");
		txtAhitnum.setHorizontalAlignment(SwingConstants.CENTER);
		txtAhitnum.setColumns(Y * 10 / 768);
		txtAhitnum.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getHit())) * 3) / 1366,
				Y * 245 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAhitnum.setText(String.valueOf(aveInfo.getHitField()));
		txtAhitnum.setOpaque(false);
		txtAhitnum.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAhitnum);

		txtAprate = new MyDataTextField();
		txtAprate.setText("a3PRate");
		txtAprate.setHorizontalAlignment(SwingConstants.CENTER);
		txtAprate.setColumns(Y * 10 / 768);
		txtAprate.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getThreeRate() * 100)) * 3)
						/ 1366, Y * 279 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAprate.setText(String.valueOf(aveInfo.getThreeRate() * 100));
		txtAprate.setOpaque(false);
		txtAprate.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAprate);

		txtAfreethrowrate = new MyDataTextField();
		txtAfreethrowrate.setText("aFreeThrowRate");
		txtAfreethrowrate.setHorizontalAlignment(SwingConstants.CENTER);
		txtAfreethrowrate.setColumns(Y * 10 / 768);
		txtAfreethrowrate.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getFreeRate() * 100)) * 3)
						/ 1366, Y * 313 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAfreethrowrate.setText(String.valueOf(aveInfo.getFreeRate() * 100));
		txtAfreethrowrate.setOpaque(false);
		txtAfreethrowrate.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAfreethrowrate);

		txtAsteal = new MyDataTextField();
		txtAsteal.setText("aSteal");
		txtAsteal.setHorizontalAlignment(SwingConstants.CENTER);
		txtAsteal.setColumns(Y * 10 / 768);
		txtAsteal.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getStealField())) * 3)
						/ 1366, Y * 347 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAsteal.setText(String.valueOf(aveInfo.getStealField()));
		txtAsteal.setOpaque(false);
		txtAsteal.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAsteal);

		txtAblock = new MyDataTextField();
		txtAblock.setText("aBlock");
		txtAblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtAblock.setColumns(Y * 10 / 768);
		txtAblock.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(aveInfo.getBlockField())) * 3)
						/ 1366, Y * 381 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAblock.setText(String.valueOf(aveInfo.getBlockField()));
		txtAblock.setOpaque(false);
		txtAblock.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAblock);

		txtAturnover = new MyDataTextField();
		txtAturnover.setText("aTurnOver");
		txtAturnover.setHorizontalAlignment(SwingConstants.CENTER);
		txtAturnover.setColumns(Y * 10 / 768);
		txtAturnover
				.setBounds(
						X
								* (585 + Integer
										.parseInt(new java.text.DecimalFormat(
												"0").format(playerInfo
												.getTurnoverField())) * 3)
								/ 1366, Y * 415 / 768, X * 60 / 1366,
						Y * 24 / 768);
		txtAturnover.setText(String.valueOf(aveInfo.getTurnoverField()));
		txtAturnover.setOpaque(false);
		txtAturnover.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAturnover);

		txtAfoul = new MyDataTextField();
		txtAfoul.setText("aFoul");
		txtAfoul.setHorizontalAlignment(SwingConstants.CENTER);
		txtAfoul.setColumns(Y * 10 / 768);
		txtAfoul.setBounds(
				X
						* (585 + Integer.parseInt(new java.text.DecimalFormat(
								"0").format(playerInfo.getFoulField())) * 3)
						/ 1366, Y * 449 / 768, X * 60 / 1366, Y * 24 / 768);
		txtAfoul.setText(String.valueOf(aveInfo.getFoulField()));
		txtAfoul.setOpaque(false);
		txtAfoul.setBorder(BorderFactory.createEmptyBorder());
		contentlbl.add(txtAfoul);

		bgLabel.add(contentlbl);
	}

	private void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		mainFrame.add(previousPanel);
	}

	private void addBasicData() {
		PlayerVo one = player_BS.getPlayerByName(playerName);
		textField_2.setText(one.getName());
		textField_4.setText(one.getHeight());
		textField_6.setText(one.getBirth());
		textField_8.setText(one.getPosition());
		textField_10.setText(one.getWeight());
		textField_12.setText(String.valueOf(one.getExp()));
		textField_14.setText(String.valueOf(one.getNumber()));
		textField_16.setText(String.valueOf(one.getAge()));
		textField_18.setText(one.getSchool());
	}

	private void addBasicInfo() {

		int tempX = 230;
		int tempY = Y / 10 + 20;
		int spaceX = X / 10;
		int spaceY = Y / 24;

		textField_1 = new MyTextField();
		textField_1.setText("姓名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("身高");
		textField_3.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("生日");
		textField_5.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_5);

		textField_6 = new MyTextField();
		textField_6.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_6);

		textField_7 = new MyTextField();
		textField_7.setText("位置");
		textField_7.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_7);

		textField_8 = new MyTextField();
		textField_8.setBounds(tempX + spaceX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_8);

		textField_9 = new MyTextField();
		textField_9.setText("体重");
		textField_9.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_9);

		textField_10 = new MyTextField();
		textField_10.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_10);

		textField_11 = new MyTextField();
		textField_11.setText("球龄");
		textField_11.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_11);

		textField_12 = new MyTextField();
		textField_12.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_12);

		textField_13 = new MyTextField();
		textField_13.setText("球衣号码");
		textField_13.setBounds(tempX, tempY + 2 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_13);

		textField_14 = new MyTextField();
		textField_14.setBounds(tempX + spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_14);

		textField_15 = new MyTextField();
		textField_15.setText("年龄");
		textField_15.setBounds(tempX + 2 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_15);

		textField_16 = new MyTextField();
		textField_16.setBounds(tempX + 3 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_16);

		textField_17 = new MyTextField();
		textField_17.setText("毕业院校");
		textField_17.setBounds(tempX + 4 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_17);

		textField_18 = new MyTextField();
		textField_18.setBounds(tempX + 5 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_18);

	}

	public class MyTableRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean cellHasFocus,
				int row, int col) {

			if ((row % 2) == 1)
				setBackground(Color.GRAY);
			else
				setBackground(Color.LIGHT_GRAY);

			setText((value == null) ? "" : value.toString());

			return this;
		}
	}

	public boolean hasAction(String actionPath) {
		boolean hasAction = false;
		File actionFile = new File("CSEdata/players/action//");
		String action[];
		action = actionFile.list();
		for (int i = 0; i < action.length; i++) {
			if (actionPath.equals(action[i])) {
				hasAction = true;
				break;
			}
		}
		return hasAction;
	}

	public boolean hasPortrait(String portraitPath) {
		boolean hasPortrait = false;
		File portraitFile = new File("CSEdata/players/portrait//");
		String portrait[];
		portrait = portraitFile.list();
		for (int i = 0; i < portrait.length; i++) {
			if (portraitPath.equals(portrait[i])) {
				hasPortrait = true;
				break;
			}
		}

		return hasPortrait;
	}

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setVisible(true);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setColumns(X * 10 / 1366);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setOpaque(false);
		}
	}

	class MyDataTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyDataTextField() {
			super();
			this.setVisible(true);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 12));
			this.setBorder(BorderFactory.createEmptyBorder());
			this.setColumns(X * 10 / 1366);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setOpaque(false);
		}
	}

	class MyLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyLabel() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(String text) {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 14));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 11));

		}
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
					X * 150 / 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			bgLabel.add(this);
		}
	}
}
