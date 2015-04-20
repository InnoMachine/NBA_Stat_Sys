package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ui.GamePanel.GameCardRenderer;
import vo.GameVo;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class GameInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	GameVo gameVo;
	JFrame mainFrame;
	JPanel previousPanel;

	

	Game_BS game_BS = new Game_BL_Stub();

	static int X;
	static int Y;

	JLabel bgLabel;
	private JLabel guestTeamlbl;
	private JLabel hostTeamlbl;
	private JTextField txtGTPoint;
	private JTextField txtHTPoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField guestTeamtF;
	private JTextField guestTeam1;
	private JTextField guestTeam2;
	private JTextField guestTeam3;
	private JTextField guestTeam4;
	private JTextField guestScoreSum;
	private JTextField txtState;
	private JTextField hostTeamtF;
	private JTextField hostScore1;
	private JTextField hostScore2;
	private JTextField hostScore3;
	private JTextField hostScore4;
	private JTextField hostScoreSum;
	private JLabel courtlbl;
	private JButton btnG1;
	private JButton btnG2;
	private JButton btnG3;
	private JButton btnG4;
	private JButton btnG5;
	private JButton btnH1;
	private JButton btnH2;
	private JButton btnH3;
	private JButton btnH4;
	private JButton btnH5;
	private JTextField textField_6;
	private JTextField txtGt;
	private JTextField txtHt;
	private JTextField FGtF;
	private JTextField FTtF;
	private JTextField ThreePtF;
	private JTextField ASTtF;
	private JTextField REBtF;
	private JTextField TOtF;
	private JTextField txtGTfg;
	private JTextField txtHTfg;
	private JTextField txtGTft;
	private JTextField txtHTft;
	private JTextField txtGT3p;
	private JTextField txtHT3p;
	private JTextField txtGTast;
	private JTextField txtHTast;
	private JTextField txtGTreb;
	private JTextField txtHTreb;
	private JTextField txtGTto;
	private JTextField txtHTto;

	private JLabel summarylbl;
	JLabel gameInfolbl;
	private JLabel leadinglbl;
	private JTextField txtGuestTeam;
	private JTextField txtHostTeam;
	private JTextField txtGTscorefirst;
	private JTextField txtGTscore;
	private JTextField txtScore;
	private JTextField txtHTscore;
	private JTextField txtHTscorefirst;
	private JTextField txtGTreboundfirst;
	private JTextField txtGTrebound;
	private JTextField txtRebound;
	private JTextField txtHTrebound;
	private JTextField txtHTreboundfirst;
	private JTextField txtGTassistancefirst;
	private JTextField txtGTassistance;
	private JTextField txtAssistance;
	private JTextField txtHTassistance;
	private JTextField txtHTassistancefirst;
	private JTextField txtGTblockfirst;
	private JTextField txtGTblock;
	private JTextField txtBlock;
	private JTextField txtHTblock;
	private JTextField txtHTblockfirst;

	private JLabel datalbl;
	private JLabel guestTeamDatalbl;
	private JLabel hostTeamDatalbl;
	private String[] guestCriterias;
	private String[] hostCriterias;
	JComboBox<String> guestCriteriajcb;
	JComboBox<String> hostCriteriajcb;
	
	private String guestDataCriteria = "BASIC";
	private String hostDataCriteria = "BASIC";
	Vector<Vector<String>> guestRowData;
	Vector<String> guestColumn;
	private JTable guestTable;
	private JScrollPane guestScrollPane;
	Vector<Vector<String>> hostRowData;
	Vector<String> hostColumn;
	private JTable hostTable;
	private JScrollPane hostScrollPane;

	public GameInfoPanel(GameVo gameVo, JFrame mainFrame, JPanel previousPanel) {
		previousPanel.setVisible(false);
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		this.gameVo = gameVo;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		// this.setBounds(0, 0, X, Y);
		this.setBounds(0, 0, 1366, 768);
		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		// bgLabel.setBounds(0, 0, X, Y);
		bgLabel.setBounds(0, 0, 1366, 768);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);

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

		JButton back = new JButton("返回");
		back.setForeground(Color.WHITE);
		/*
		 * ImageIcon backIcon = new ImageIcon(new
		 * ImageIcon("Image/homeIcon.png") .getImage().getScaledInstance(X / 25,
		 * X / 25, Image.SCALE_SMOOTH));
		 */
		back.setBounds(17 * X / 20, Y * 10 / 768, X / 25, X / 25);
		// back.setIcon(backIcon);
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

		mainFrame.getContentPane().add(this);

		guestTeamlbl = new JLabel();
		guestTeamlbl.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamlbl.setText("GuestTeamName");
		guestTeamlbl.setBounds(449, 10, 100, 36);
		bgLabel.add(guestTeamlbl);

		hostTeamlbl = new JLabel();
		hostTeamlbl.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamlbl.setText("HostTeamName");
		hostTeamlbl.setBounds(816, 10, 100, 36);
		bgLabel.add(hostTeamlbl);

		txtGTPoint = new JTextField();
		txtGTPoint.setText("GTPoint");
		txtGTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTPoint.setBounds(449, 51, 100, 60);
		bgLabel.add(txtGTPoint);
		txtGTPoint.setColumns(10);

		txtHTPoint = new JTextField();
		txtHTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTPoint.setText("HTPoint");
		txtHTPoint.setBounds(816, 51, 100, 60);
		bgLabel.add(txtHTPoint);
		txtHTPoint.setColumns(10);

		txtState = new JTextField();
		txtState.setText("结束");
		txtState.setHorizontalAlignment(SwingConstants.CENTER);
		txtState.setBounds(651, 17, 66, 21);
		bgLabel.add(txtState);
		txtState.setColumns(10);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("球队");
		textField.setBounds(596, 55, 55, 16);
		bgLabel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("1");
		textField_1.setBounds(651, 55, 21, 16);
		bgLabel.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setText("2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		textField_2.setBounds(672, 55, 21, 16);
		bgLabel.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setText("3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		textField_3.setBounds(693, 55, 21, 16);
		bgLabel.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setText("4");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(10);
		textField_4.setBounds(714, 55, 21, 16);
		bgLabel.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setText("总分");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(10);
		textField_5.setBounds(735, 55, 35, 16);
		bgLabel.add(textField_5);

		guestTeamtF = new JTextField();
		guestTeamtF.setText("G");
		guestTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamtF.setColumns(10);
		guestTeamtF.setBounds(596, 71, 55, 16);
		bgLabel.add(guestTeamtF);

		guestTeam1 = new JTextField();
		guestTeam1.setText("G1");
		guestTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam1.setColumns(10);
		guestTeam1.setBounds(651, 71, 21, 16);
		bgLabel.add(guestTeam1);

		guestTeam2 = new JTextField();
		guestTeam2.setText("G2");
		guestTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam2.setColumns(10);
		guestTeam2.setBounds(672, 71, 21, 16);
		bgLabel.add(guestTeam2);

		guestTeam3 = new JTextField();
		guestTeam3.setText("G3");
		guestTeam3.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam3.setColumns(10);
		guestTeam3.setBounds(693, 71, 21, 16);
		bgLabel.add(guestTeam3);

		guestTeam4 = new JTextField();
		guestTeam4.setText("G4");
		guestTeam4.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam4.setColumns(10);
		guestTeam4.setBounds(714, 71, 21, 16);
		bgLabel.add(guestTeam4);

		guestScoreSum = new JTextField();
		guestScoreSum.setText("GS");
		guestScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		guestScoreSum.setColumns(10);
		guestScoreSum.setBounds(735, 71, 35, 16);
		bgLabel.add(guestScoreSum);

		hostTeamtF = new JTextField();
		hostTeamtF.setText("H");
		hostTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamtF.setColumns(10);
		hostTeamtF.setBounds(596, 87, 55, 16);
		bgLabel.add(hostTeamtF);

		hostScore1 = new JTextField();
		hostScore1.setText("H1");
		hostScore1.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore1.setColumns(10);
		hostScore1.setBounds(651, 87, 21, 16);
		bgLabel.add(hostScore1);

		hostScore2 = new JTextField();
		hostScore2.setText("H2");
		hostScore2.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore2.setColumns(10);
		hostScore2.setBounds(672, 87, 21, 16);
		bgLabel.add(hostScore2);

		hostScore3 = new JTextField();
		hostScore3.setText("H3");
		hostScore3.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore3.setColumns(10);
		hostScore3.setBounds(693, 87, 21, 16);
		bgLabel.add(hostScore3);

		hostScore4 = new JTextField();
		hostScore4.setText("H4");
		hostScore4.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore4.setColumns(10);
		hostScore4.setBounds(714, 87, 21, 16);
		bgLabel.add(hostScore4);

		hostScoreSum = new JTextField();
		hostScoreSum.setText("HS");
		hostScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		hostScoreSum.setColumns(10);
		hostScoreSum.setBounds(735, 87, 35, 16);
		bgLabel.add(hostScoreSum);

		JButton startingbtn = new JButton("首发");
		startingbtn.setBounds(450, 139, 155, 23);
		startingbtn.addActionListener(e -> starting());
		bgLabel.add(startingbtn);

		JButton summarybtn = new JButton("赛后总结");
		summarybtn.setBounds(605, 139, 155, 23);
		summarybtn.addActionListener(e -> summary());
		bgLabel.add(summarybtn);

		JButton databtn = new JButton("数据");
		databtn.setBounds(760, 139, 155, 23);
		databtn.addActionListener(e->showData());
		bgLabel.add(databtn);

		datalbl = new JLabel("data");
		datalbl.setHorizontalAlignment(SwingConstants.CENTER);
		datalbl.setBounds(131, 194, 1100, 500);
		datalbl.setBackground(Color.blue);
		add(datalbl);
		
		guestTeamDatalbl = new JLabel();
		guestTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamDatalbl.setBounds(0, 0, 550, 100);
		guestTeamDatalbl.setBackground(Color.blue);
		datalbl.add(guestTeamDatalbl);
		
		guestCriterias = new String[4];
		guestCriterias[0] = "BASIC";
		guestCriterias[1] = "SHOOTING";
		guestCriterias[2] = "REBOUNDS";
		guestCriterias[3] = "X-FACTOR";
		guestCriteriajcb = new JComboBox<String>(guestCriterias);

		guestCriteriajcb.setBounds(400,50,100,30);
		guestCriteriajcb.setForeground(Color.WHITE);
		guestCriteriajcb.setBackground(Color.GRAY);
		guestTeamDatalbl.add(guestCriteriajcb);
		
		
		hostTeamDatalbl = new JLabel();
		hostTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamDatalbl.setBounds(550, 0, 550, 100);
		hostTeamDatalbl.setBackground(Color.blue);
		datalbl.add(hostTeamDatalbl);
		

		ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
				.getGuestTP();
		guestPlayerVos = guestTeamPerformanceInSingleGame.getPlayerList();
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		if (guestDataCriteria == "BASIC") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("分钟");
			guestColumn.add("得分");
			guestColumn.add("篮板");
			guestColumn.add("助攻");
			guestColumn.add("个人犯规");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(guestPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getScore()));
				a.add(String.valueOf(guestPlayerVos.get(i).getReboundOverall()));
				a.add(String.valueOf(guestPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(guestPlayerVos.get(i).getFoul()));
				guestRowData.add(a);
			}
		} else if (guestDataCriteria == "SHOOTING") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("分钟");
			guestColumn.add("命中数");
			guestColumn.add("三分命中数");
			guestColumn.add("罚球命中数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(guestPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getHitNum()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getThreePointHitNum()));
				a.add(String
						.valueOf(guestPlayerVos.get(i).getFreeThrowHitNum()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "REBOUNDS") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("分钟");
			guestColumn.add("进攻篮板");
			guestColumn.add("防守篮板");
			guestColumn.add("总篮板数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(guestPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getOffensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getDefensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i).getReboundOverall()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "X-FACTOR") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("分钟");
			guestColumn.add("抢断");
			guestColumn.add("盖帽");
			guestColumn.add("失误");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(guestPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(guestPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTurnover()));
				guestRowData.add(a);
			}

		} else {
			System.out.println("guestDataCriteria in GameInfoPanel！！！");
		}

		DefaultTableModel guestdtm = new DefaultTableModel(guestRowData, guestColumn) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEdiguestTable(int row, int guestColumn) {
				return false;
			}
		};

		if (guestTable != null) {
			guestTable.setVisible(false);
		}
		DefaultTableCellRenderer guestTableHeaderRenderer = new DefaultTableCellRenderer();
		guestTableHeaderRenderer.setPreferredSize(new Dimension(0, 0));

		if (guestScrollPane != null) {
			guestScrollPane.setVisible(false);
		}
		guestTable = new JTable(guestdtm);
		guestTable.getTableHeader().setDefaultRenderer(guestTableHeaderRenderer);

		guestTable.setRowHeight(80);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		// guestTable.getguestColumnModel().getguestColumn(0)
		// .setCellRenderer(new GameCardRenderer());
		guestTable.setOpaque(false);
		
		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		// guestScrollPane.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
		// Y * 600 / 768);
		guestScrollPane.setBounds(0, 100, 550, 400);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);
		
		datalbl.add(guestScrollPane);
		
		
		
		ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo.getHomeTP();
		hostPlayerVos = hostTeamPerformanceInSingleGame.getPlayerList();
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		if (hostDataCriteria == "BASIC") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("分钟");
			hostColumn.add("得分");
			hostColumn.add("篮板");
			hostColumn.add("助攻");
			hostColumn.add("个人犯规");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(hostPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
				a.add(String.valueOf(hostPlayerVos.get(i).getReboundOverall()));
				a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
				hostRowData.add(a);
			}
		} else if (hostDataCriteria == "SHOOTING") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("分钟");
			hostColumn.add("命中数");
			hostColumn.add("三分命中数");
			hostColumn.add("罚球命中数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(hostPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getHitNum()));
				a.add(String.valueOf(hostPlayerVos.get(i)
						.getThreePointHitNum()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getFreeThrowHitNum()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "REBOUNDS") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("分钟");
			hostColumn.add("进攻篮板");
			hostColumn.add("防守篮板");
			hostColumn.add("总篮板数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(hostPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i)
						.getOffensiveRebound()));
				a.add(String.valueOf(hostPlayerVos.get(i)
						.getDefensiveRebound()));
				a.add(String.valueOf(hostPlayerVos.get(i).getReboundOverall()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "X-FACTOR") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("分钟");
			hostColumn.add("抢断");
			hostColumn.add("盖帽");
			hostColumn.add("失误");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add(String.valueOf(hostPlayerVos.get(i).getName()) + "  #"
						+ String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(hostPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTurnover()));
				hostRowData.add(a);
			}

		} else {
			System.out.println("hostDataCriteria in GameInfoPanel！！！");
		}

		DefaultTableModel hostdtm = new DefaultTableModel(hostRowData, hostColumn) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEdihostTable(int row, int hostColumn) {
				return false;
			}
		};

		if (hostTable != null) {
			hostTable.setVisible(false);
		}
		DefaultTableCellRenderer hostTableHeaderRenderer = new DefaultTableCellRenderer();
		hostTableHeaderRenderer.setPreferredSize(new Dimension(0, 0));

		if (hostScrollPane != null) {
			hostScrollPane.setVisible(false);
		}
		hostTable = new JTable(hostdtm);
		hostTable.getTableHeader().setDefaultRenderer(hostTableHeaderRenderer);

		hostTable.setRowHeight(80);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		// hostTable.gethostColumnModel().gethostColumn(0)
		// .setCellRenderer(new GameCardRenderer());
		hostTable.setOpaque(false);
		
		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		// hostScrollPane.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
		// Y * 600 / 768);
		hostScrollPane.setBounds(550, 100, 550, 400);
		hostScrollPane.setVisible(true);
		hostScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hostScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hostScrollPane.getViewport().setOpaque(false);
		hostScrollPane.setOpaque(false);
		
		datalbl.add(hostScrollPane);
        bgLabel.add(datalbl);
		
		mainFrame.getContentPane().add(this);
	}

	public void starting() {
		if(summarylbl!=null){
			summarylbl.setVisible(false);
		}
		if(datalbl!=null){
			datalbl.setVisible(false);
		}
		
		courtlbl = new JLabel("court");
		courtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		courtlbl.setBounds(131, 194, 1100, 500);
		courtlbl.setBackground(Color.blue);
		add(courtlbl);

		btnG1 = new JButton("G1");
		btnG1.setBounds(503, 409, 70, 70);
		courtlbl.add(btnG1);

		btnG2 = new JButton("G2");
		btnG2.setBounds(404, 274, 70, 70);
		courtlbl.add(btnG2);

		btnG3 = new JButton("G3");
		btnG3.setBounds(204, 613, 70, 70);
		courtlbl.add(btnG3);

		btnG4 = new JButton("G4");
		btnG4.setBounds(265, 367, 70, 70);
		courtlbl.add(btnG4);

		btnG5 = new JButton("G5");
		btnG5.setBounds(368, 529, 70, 70);
		courtlbl.add(btnG5);

		btnH1 = new JButton("H1");
		btnH1.setBounds(778, 409, 70, 70);
		courtlbl.add(btnH1);

		btnH2 = new JButton("H2");
		btnH2.setBounds(875, 544, 70, 70);
		courtlbl.add(btnH2);

		btnH3 = new JButton("H3");
		btnH3.setBounds(921, 286, 70, 70);
		courtlbl.add(btnH3);

		btnH4 = new JButton("H4");
		btnH4.setBounds(1020, 453, 70, 70);
		courtlbl.add(btnH4);

		btnH5 = new JButton("H5");
		btnH5.setBounds(1081, 201, 70, 70);
		courtlbl.add(btnH5);

		bgLabel.add(courtlbl);
		
	}

	public void summary() {
		if(courtlbl!=null){
			courtlbl.setVisible(false);
		}
		if(datalbl!=null){
			datalbl.setVisible(false);
		}
		
		summarylbl = new JLabel("summary");
		summarylbl.setHorizontalAlignment(SwingConstants.CENTER);
		summarylbl.setBounds(131, 194, 1100, 500);
		summarylbl.setBackground(Color.blue);
		add(summarylbl);

		gameInfolbl = new JLabel("比赛概览");
		gameInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameInfolbl.setBounds(97, 16, 54, 30);
		summarylbl.add(gameInfolbl);

		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(97, 46, 130, 30);
		summarylbl.add(textField_6);
		textField_6.setColumns(10);

		txtGt = new JTextField();
		txtGt.setEditable(false);
		txtGt.setText("GT");
		txtGt.setHorizontalAlignment(SwingConstants.CENTER);
		txtGt.setColumns(10);
		txtGt.setBounds(97, 76, 130, 30);
		summarylbl.add(txtGt);

		txtHt = new JTextField();
		txtHt.setEditable(false);
		txtHt.setText("HT");
		txtHt.setHorizontalAlignment(SwingConstants.CENTER);
		txtHt.setColumns(10);
		txtHt.setBounds(97, 106, 130, 30);
		summarylbl.add(txtHt);

		FGtF = new JTextField();
		FGtF.setText("投篮命中率");
		FGtF.setEditable(false);
		FGtF.setHorizontalAlignment(SwingConstants.CENTER);
		FGtF.setColumns(10);
		FGtF.setBounds(227, 46, 130, 30);
		summarylbl.add(FGtF);

		FTtF = new JTextField();
		FTtF.setText("罚球命中率");
		FTtF.setEditable(false);
		FTtF.setHorizontalAlignment(SwingConstants.CENTER);
		FTtF.setColumns(10);
		FTtF.setBounds(357, 46, 130, 30);
		summarylbl.add(FTtF);

		ThreePtF = new JTextField();
		ThreePtF.setText("三分命中率");
		ThreePtF.setEditable(false);
		ThreePtF.setHorizontalAlignment(SwingConstants.CENTER);
		ThreePtF.setColumns(10);
		ThreePtF.setBounds(487, 46, 130, 30);
		summarylbl.add(ThreePtF);

		ASTtF = new JTextField();
		ASTtF.setText("助攻");
		ASTtF.setEditable(false);
		ASTtF.setHorizontalAlignment(SwingConstants.CENTER);
		ASTtF.setColumns(10);
		ASTtF.setBounds(617, 46, 130, 30);
		summarylbl.add(ASTtF);

		REBtF = new JTextField();
		REBtF.setText("篮板");
		REBtF.setEditable(false);
		REBtF.setHorizontalAlignment(SwingConstants.CENTER);
		REBtF.setColumns(10);
		REBtF.setBounds(747, 46, 130, 30);
		summarylbl.add(REBtF);

		TOtF = new JTextField();
		TOtF.setText("失误");
		TOtF.setEditable(false);
		TOtF.setHorizontalAlignment(SwingConstants.CENTER);
		TOtF.setColumns(10);
		TOtF.setBounds(877, 46, 130, 30);
		summarylbl.add(TOtF);

		txtGTfg = new JTextField();
		txtGTfg.setText("GTFG");
		txtGTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTfg.setEditable(false);
		txtGTfg.setColumns(10);
		txtGTfg.setBounds(227, 76, 130, 30);
		summarylbl.add(txtGTfg);

		txtHTfg = new JTextField();
		txtHTfg.setText("HTFG");
		txtHTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTfg.setEditable(false);
		txtHTfg.setColumns(10);
		txtHTfg.setBounds(227, 106, 130, 30);
		summarylbl.add(txtHTfg);

		txtGTft = new JTextField();
		txtGTft.setText("GTFT");
		txtGTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTft.setEditable(false);
		txtGTft.setColumns(10);
		txtGTft.setBounds(357, 76, 130, 30);
		summarylbl.add(txtGTft);

		txtHTft = new JTextField();
		txtHTft.setText("HTFT");
		txtHTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTft.setEditable(false);
		txtHTft.setColumns(10);
		txtHTft.setBounds(357, 106, 130, 30);
		summarylbl.add(txtHTft);

		txtGT3p = new JTextField();
		txtGT3p.setText("GT3P");
		txtGT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtGT3p.setEditable(false);
		txtGT3p.setColumns(10);
		txtGT3p.setBounds(487, 76, 130, 30);
		summarylbl.add(txtGT3p);

		txtHT3p = new JTextField();
		txtHT3p.setText("HT3P");
		txtHT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtHT3p.setEditable(false);
		txtHT3p.setColumns(10);
		txtHT3p.setBounds(487, 106, 130, 30);
		summarylbl.add(txtHT3p);

		txtGTast = new JTextField();
		txtGTast.setText("GTAST");
		txtGTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTast.setEditable(false);
		txtGTast.setColumns(10);
		txtGTast.setBounds(617, 76, 130, 30);
		summarylbl.add(txtGTast);

		txtHTast = new JTextField();
		txtHTast.setText("HTAST");
		txtHTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTast.setEditable(false);
		txtHTast.setColumns(10);
		txtHTast.setBounds(617, 106, 130, 30);
		summarylbl.add(txtHTast);

		txtGTreb = new JTextField();
		txtGTreb.setText("GTREB");
		txtGTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreb.setEditable(false);
		txtGTreb.setColumns(10);
		txtGTreb.setBounds(747, 76, 130, 30);
		summarylbl.add(txtGTreb);

		txtHTreb = new JTextField();
		txtHTreb.setText("HTREB");
		txtHTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreb.setEditable(false);
		txtHTreb.setColumns(10);
		txtHTreb.setBounds(747, 106, 130, 30);
		summarylbl.add(txtHTreb);

		txtGTto = new JTextField();
		txtGTto.setText("GTTO");
		txtGTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTto.setEditable(false);
		txtGTto.setColumns(10);
		txtGTto.setBounds(877, 76, 130, 30);
		summarylbl.add(txtGTto);

		txtHTto = new JTextField();
		txtHTto.setText("HTTO");
		txtHTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTto.setEditable(false);
		txtHTto.setColumns(10);
		txtHTto.setBounds(877, 106, 130, 30);
		summarylbl.add(txtHTto);

		leadinglbl = new JLabel("数据领跑者");
		leadinglbl.setHorizontalAlignment(SwingConstants.CENTER);
		leadinglbl.setBounds(97, 166, 74, 30);
		summarylbl.add(leadinglbl);

		txtGuestTeam = new JTextField();
		txtGuestTeam.setEditable(false);
		txtGuestTeam.setText("GuestTeam");
		txtGuestTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuestTeam.setBounds(97, 196, 455, 30);
		summarylbl.add(txtGuestTeam);
		txtGuestTeam.setColumns(10);

		txtHostTeam = new JTextField();
		txtHostTeam.setEditable(false);
		txtHostTeam.setText("HostTeam");
		txtHostTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtHostTeam.setColumns(10);
		txtHostTeam.setBounds(552, 196, 455, 30);
		summarylbl.add(txtHostTeam);

		txtGTscorefirst = new JTextField();
		txtGTscorefirst.setText("GTScoreFirst");
		txtGTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscorefirst.setEditable(false);
		txtGTscorefirst.setColumns(10);
		txtGTscorefirst.setBounds(97, 226, 260, 30);
		summarylbl.add(txtGTscorefirst);

		txtGTscore = new JTextField();
		txtGTscore.setText("GTScore");
		txtGTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscore.setEditable(false);
		txtGTscore.setColumns(10);
		txtGTscore.setBounds(357, 226, 130, 30);
		summarylbl.add(txtGTscore);

		txtScore = new JTextField();
		txtScore.setText("得分");
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setEditable(false);
		txtScore.setColumns(10);
		txtScore.setBounds(487, 226, 130, 30);
		summarylbl.add(txtScore);

		txtHTscore = new JTextField();
		txtHTscore.setText("HTScore");
		txtHTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscore.setEditable(false);
		txtHTscore.setColumns(10);
		txtHTscore.setBounds(617, 226, 130, 30);
		summarylbl.add(txtHTscore);

		txtHTscorefirst = new JTextField();
		txtHTscorefirst.setText("HTScoreFirst");
		txtHTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscorefirst.setEditable(false);
		txtHTscorefirst.setColumns(10);
		txtHTscorefirst.setBounds(747, 226, 260, 30);
		summarylbl.add(txtHTscorefirst);

		txtGTreboundfirst = new JTextField();
		txtGTreboundfirst.setText("GTReboundFirst");
		txtGTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreboundfirst.setEditable(false);
		txtGTreboundfirst.setColumns(10);
		txtGTreboundfirst.setBounds(97, 256, 260, 30);
		summarylbl.add(txtGTreboundfirst);

		txtGTrebound = new JTextField();
		txtGTrebound.setText("GTRebound");
		txtGTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTrebound.setEditable(false);
		txtGTrebound.setColumns(10);
		txtGTrebound.setBounds(357, 256, 130, 30);
		summarylbl.add(txtGTrebound);

		txtRebound = new JTextField();
		txtRebound.setText("篮板");
		txtRebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtRebound.setEditable(false);
		txtRebound.setColumns(10);
		txtRebound.setBounds(487, 256, 130, 30);
		summarylbl.add(txtRebound);

		txtHTrebound = new JTextField();
		txtHTrebound.setText("HTRebound");
		txtHTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTrebound.setEditable(false);
		txtHTrebound.setColumns(10);
		txtHTrebound.setBounds(617, 256, 130, 30);
		summarylbl.add(txtHTrebound);

		txtHTreboundfirst = new JTextField();
		txtHTreboundfirst.setText("HTReboundFirst");
		txtHTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreboundfirst.setEditable(false);
		txtHTreboundfirst.setColumns(10);
		txtHTreboundfirst.setBounds(747, 256, 260, 30);
		summarylbl.add(txtHTreboundfirst);

		txtGTassistancefirst = new JTextField();
		txtGTassistancefirst.setText("GTAssistanceFirst");
		txtGTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistancefirst.setEditable(false);
		txtGTassistancefirst.setColumns(10);
		txtGTassistancefirst.setBounds(97, 286, 260, 30);
		summarylbl.add(txtGTassistancefirst);

		txtGTassistance = new JTextField();
		txtGTassistance.setText("GTAssistance");
		txtGTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistance.setEditable(false);
		txtGTassistance.setColumns(10);
		txtGTassistance.setBounds(357, 286, 130, 30);
		summarylbl.add(txtGTassistance);

		txtAssistance = new JTextField();
		txtAssistance.setText("助攻");
		txtAssistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssistance.setEditable(false);
		txtAssistance.setColumns(10);
		txtAssistance.setBounds(487, 286, 130, 30);
		summarylbl.add(txtAssistance);

		txtHTassistance = new JTextField();
		txtHTassistance.setText("HTAssistance");
		txtHTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistance.setEditable(false);
		txtHTassistance.setColumns(10);
		txtHTassistance.setBounds(617, 286, 130, 30);
		summarylbl.add(txtHTassistance);

		txtHTassistancefirst = new JTextField();
		txtHTassistancefirst.setText("HTAssistanceFirst");
		txtHTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistancefirst.setEditable(false);
		txtHTassistancefirst.setColumns(10);
		txtHTassistancefirst.setBounds(747, 286, 260, 30);
		summarylbl.add(txtHTassistancefirst);

		txtGTblockfirst = new JTextField();
		txtGTblockfirst.setText("GTblockFirst");
		txtGTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblockfirst.setEditable(false);
		txtGTblockfirst.setColumns(10);
		txtGTblockfirst.setBounds(97, 316, 260, 30);
		summarylbl.add(txtGTblockfirst);

		txtGTblock = new JTextField();
		txtGTblock.setText("GTblock");
		txtGTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblock.setEditable(false);
		txtGTblock.setColumns(10);
		txtGTblock.setBounds(357, 316, 130, 30);
		summarylbl.add(txtGTblock);

		txtBlock = new JTextField();
		txtBlock.setText("助攻");
		txtBlock.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlock.setEditable(false);
		txtBlock.setColumns(10);
		txtBlock.setBounds(487, 316, 130, 30);
		summarylbl.add(txtBlock);

		txtHTblock = new JTextField();
		txtHTblock.setText("HTblock");
		txtHTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblock.setEditable(false);
		txtHTblock.setColumns(10);
		txtHTblock.setBounds(617, 316, 130, 30);
		summarylbl.add(txtHTblock);

		txtHTblockfirst = new JTextField();
		txtHTblockfirst.setText("HTblockFirst");
		txtHTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblockfirst.setEditable(false);
		txtHTblockfirst.setColumns(10);
		txtHTblockfirst.setBounds(747, 316, 260, 30);
		summarylbl.add(txtHTblockfirst);
		
		bgLabel.add(summarylbl);
	}

	public void showData() {
		if(courtlbl!=null){
			courtlbl.setVisible(false);
		}
		if(summarylbl!=null){
			summarylbl.setVisible(false);
		}
		
		
		bgLabel.add(datalbl);
	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
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
