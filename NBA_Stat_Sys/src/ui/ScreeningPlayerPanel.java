package ui;

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

public class ScreeningPlayerPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame mainFrame;
	JPanel previousPanel;
	private JTable table;
	private JScrollPane scrollPane;
	ScreeningPlayerCriteriaPanel playerCriteriaPanel;
	Player_BS player_BS = new Player_BL();
	private JButton screeningCriteriabtn;
	Vector<Vector<PlayerCardPanel>> rowData;
	static int X;
	static int Y;
	JLabel bgLabel;
	
	JLabel nbaUnionSymbol;
	JLabel westernUnionSymbol;
	JLabel easternUnionSymbol;
	JButton nbaUnion;
	JButton westernUnion;
	JButton easternUnion;
	JButton pacific;
	JButton southwest;
	JButton northwest;
	JButton southeast;
	JButton central;
	JButton atlantic;
	
	JButton allposition;
	JButton center;
	JButton guard;
	JButton forward;
	
	private String positionSelected="NBA联盟";
	private String leagueSelected="所有位置";
	private String criteriaSelected="得分";
	private JLabel showSelected;
	public ScreeningPlayerPanel(JFrame mainFrame, JPanel previousPanel) {
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);
		playerCriteriaPanel = new ScreeningPlayerCriteriaPanel(mainFrame, this);
		playerCriteriaPanel.setVisible(false);

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
		
		  ImageIcon backIcon = new ImageIcon(new
		 ImageIcon("Image/backIcon.png") .getImage().getScaledInstance(X / 25,
		 X / 25, Image.SCALE_SMOOTH));
		
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
		
		showSelected=new JLabel();
		showSelected.setBounds(200, 210, 1000, 30);
		showSelected.setFont(new Font("微软雅黑",1,20));
		showSelected.setForeground(Color.WHITE);
		showSelected.setText(leagueSelected+"-"+positionSelected+"-"+criteriaSelected);
		bgLabel.add(showSelected);
		
		nbaUnion=new LeagueButton("NBA联盟");
		nbaUnion.setLocation(600,50);
		westernUnionSymbol=new JLabel();
		ImageIcon westernUnionIcon = new ImageIcon(new ImageIcon(
				"Image/western.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH));	
		westernUnionSymbol.setIcon(westernUnionIcon);
		westernUnionSymbol.setBounds(280, 20, 80, 80);
		bgLabel.add(westernUnionSymbol);
		westernUnion=new LeagueButton("西部联盟");
		westernUnion.setLocation(400, 50);
		easternUnionSymbol=new JLabel();
		easternUnionSymbol.setBounds(990, 20, 80, 80);
		ImageIcon easternUnionIcon = new ImageIcon(new ImageIcon(
				"Image/eastern.png").getImage().getScaledInstance(80,80,Image.SCALE_SMOOTH));
		easternUnionSymbol.setIcon(easternUnionIcon);
		bgLabel.add(easternUnionSymbol);
		easternUnion=new LeagueButton("东部联盟");
		easternUnion.setLocation(800, 50);	
		pacific=new LeagueButton("太平洋赛区");
		pacific.setLocation(200, 110);
		northwest=new LeagueButton("西北赛区");
		northwest.setLocation(350, 110);
		southwest=new LeagueButton("西南赛区");
		southwest.setLocation(500, 110);
		center=new LeagueButton("中央赛区");
		center.setLocation(700, 110);
		southeast=new LeagueButton("东南赛区");
		southeast.setLocation(850, 110);
		atlantic=new LeagueButton("大西洋赛区");
		atlantic.setLocation(1000, 110);
		
		allposition=new PositionButton("所有位置");
		allposition.setLocation(200, 160);
		allposition.setText("所有位置⊙");
		allposition.addActionListener(e->{
			allposition.setText("所有位置⊙");
			forward.setText("前锋");
			center.setText("中锋");
			guard.setText("后卫");
		});
		forward=new PositionButton("前锋");
		forward.setLocation(320, 160);
		forward.addActionListener(e->{
			allposition.setText("所有位置");
			forward.setText("前锋⊙");
			center.setText("中锋");
			guard.setText("后卫");
		});
		center=new PositionButton("中锋");
		center.setLocation(440, 160);
		center.addActionListener(e->{
			allposition.setText("所有位置");
			forward.setText("前锋");
			center.setText("中锋⊙");
			guard.setText("后卫");
		});
		guard=new PositionButton("后卫");
		guard.setLocation(560, 160);
		guard.addActionListener(e->{
			allposition.setText("所有位置");
			forward.setText("前锋");
			center.setText("中锋");
			guard.setText("后卫⊙");
		});
		
		screeningCriteriabtn = new JButton("筛选依据");
		screeningCriteriabtn.setBounds(X*750/1366, Y*160/768,X*213/1366,Y*30/768);
		screeningCriteriabtn.setFont(new Font("微软雅黑",1,15));
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(
				X * 213 / 1366,30, Image.SCALE_SMOOTH));
		screeningCriteriabtn.setHorizontalTextPosition(SwingConstants.CENTER);
		screeningCriteriabtn.setForeground(Color.WHITE);
		screeningCriteriabtn.setIcon(buttonIcon);
		screeningCriteriabtn.setOpaque(false);
		screeningCriteriabtn.setContentAreaFilled(false);
		screeningCriteriabtn.setBorderPainted(false);
		screeningCriteriabtn.addActionListener(e -> showScreeningCriteria());
		bgLabel.add(screeningCriteriabtn);
		
//		JButton screeningbtn = new JButton("显示前50名");
//		screeningbtn.setForeground(Color.WHITE);
//		screeningbtn.setHorizontalTextPosition(SwingConstants.CENTER);
//		screeningbtn.setBounds(X * 1000 / 1366, Y * 160 / 768, X * 150 / 1366,
//				30);
//		screeningbtn.setFont(new Font("微软雅黑",1,15));
//		ImageIcon buttonIcon2 = new ImageIcon(new ImageIcon(
//				"Image/mainButton.png").getImage().getScaledInstance(
//				X * 150 / 1366, 30, Image.SCALE_SMOOTH));
//		screeningbtn.setIcon(buttonIcon2);
//		screeningbtn.setOpaque(false);
//		screeningbtn.setContentAreaFilled(false);
//		screeningbtn.setBorderPainted(false);
//		screeningbtn.addActionListener(e -> screening());
//		bgLabel.add(screeningbtn);
		mainFrame.getContentPane().add(this);

		

		bgLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				// System.out.println("CLICKED!    X: "+e.getX()+"   Y: "+e.getY());
				if (e.getX() <= X * 715 / 1366 || e.getX() >= X * 928 / 1366
						|| e.getY() <= (Y * 66 / 768 + X / 50)
						|| e.getY() >= (Y * 66 / 768 + X / 50 + X * 108 / 1366)) {
					if (playerCriteriaPanel != null) {
						playerCriteriaPanel.setVisible(false);
					}
				}
			}
		});

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		playerVos = player_BS.filterPlayerBy("All", "All", "scoreField");
		if (rowData == null) {
			rowData = new Vector<Vector<PlayerCardPanel>>();
		} else {
			rowData.clear();
		}
		for (int i = 0; i < playerVos.size(); i++) {
			Vector<PlayerCardPanel> a = new Vector<PlayerCardPanel>();
			a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
					screeningCriteriabtn.getText(), String.valueOf(playerVos
							.get(i).getScoreField())));
			rowData.add(a);

		}

		Vector<String> column = new Vector<String>();
		column.add("");
		DefaultTableModel dtm = new DefaultTableModel(rowData, column) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(dtm);
		DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
		tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		table.setRowHeight(Y * 120 / 768);
		table.setVisible(true);
		table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerCardRenderer());
		table.setOpaque(false);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 200/ 1366, Y * 250 / 768, X * 940 / 1366,
				Y * 480 / 768);
		scrollPane.setVisible(true);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		bgLabel.add(scrollPane);

	}

	public void showScreeningCriteria() {

		playerCriteriaPanel.setVisible(true);

	}

	public void screening() {
		String position = "All";
		String league = "All";
		String screeningCriteria = "score";
		System.out.println("add actionListening!");
		if (playerCriteriaPanel != null) {
			playerCriteriaPanel.setVisible(false);
		}

		switch (positionSelected) {
		case "前锋":
			position = "F";
			break;
		case "中锋":
			position = "C";
			break;
		case "后卫":
			position = "G";
			break;
		case "所有":
			position = "All";
			break;
		default:
			break;
		}

		switch (leagueSelected) {
		case "大西洋赛区":
			league = "ATLANTIC";
			break;
		case "中央赛区":
			league = "CENTRAL";
			break;
		case "东南赛区":
			league = "SOUTHEAST";
			break;
		case "西北赛区":
			league = "NORTHWEST";
			break;
		case "西南赛区":
			league = "SOUTHWEST";
			break;
		case "太平洋赛区":
			league = "PACIFIC";
			break;
		case "西部联盟":
			league= "West";
			break;
		case "东部联盟":
			league= "East";
			break;
		case "NBA联盟":
			league = "All";
			break;
		default:
			break;
		}

		switch (screeningCriteriabtn.getText()) {
		case "得分":
			screeningCriteria = "scoreField";
			break;
		case "篮板":
			screeningCriteria = "reboundOverallField";
			break;
		case "助攻":
			screeningCriteria = "assistanceField";
			break;
		case "得分/篮板/助攻":
			screeningCriteria = "weighted";
			break;
		case "盖帽":
			screeningCriteria = "blockField";
			break;
		case "抢断":
			screeningCriteria = "stealField";
			break;
		case "犯规":
			screeningCriteria = "foulField";
			break;
		case "失误":
			screeningCriteria = "turnoverField";
			break;
		case "分钟":
			screeningCriteria = "timeField";
			break;
		case "效率":
			screeningCriteria = "efficiencyField";
			break;
		case "投篮":
			screeningCriteria = "shotNumField";
			break;
		case "三分":
			screeningCriteria = "threePointShotNumField";
			break;
		case "罚球":
			screeningCriteria = "freeThrowShotNumField";
			break;
		case "两双":
			screeningCriteria = "twoTenNum";
			break;
		default:
			break;
		}

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();

		if (screeningCriteria == "") {
			JOptionPane.showMessageDialog(this, "请选择球员筛选依据");
		} else {
			// System.out.println(screeningCriteria);
			playerVos = player_BS.filterPlayerBy(position, league,
					screeningCriteria);
			if (rowData == null) {
				rowData = new Vector<Vector<PlayerCardPanel>>();
			} else {
				rowData.clear();
			}
			for (int i = 0; i < playerVos.size(); i++) {
				Vector<PlayerCardPanel> a = new Vector<PlayerCardPanel>();
				switch (screeningCriteria) {
				case "scoreField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getScoreField())));

					break;
				case "reboundOverallField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getReboundOverallField())));
					break;
				case "assistanceField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getAssistanceField())));
					break;
				case "weighted":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getWeighted())));
					break;
				case "blockField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getBlockField())));
					break;
				case "stealField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getStealField())));
					break;
				case "foulField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getFoulField())));
					break;
				case "turnoverField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getTurnoverField())));
					break;
				case "timeField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String.format(
									"%.2f",
									playerVos.get(i).getTimeField() / 60.0)));
					break;
				case "efficiencyField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getEfficiencyField())));
					break;
				case "shotNumField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(),
							String.valueOf(playerVos.get(i).getShotNumField())));
					break;
				case "threePointShotNumField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getThreePointHitNumField())));
					break;
				case "freeThrowShotNumField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getFreeThrowShotNumField())));
					break;
				case "twoTenNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTwoTenNum())));
					break;

				default:
					break;
				}
				rowData.add(a);

			}

			Vector<String> column = new Vector<String>();
			column.add("");
			DefaultTableModel dtm = new DefaultTableModel(rowData, column) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			if (table != null) {
				table.setVisible(false);
			}
			table = new JTable(dtm);
			DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
			tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
			table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
			table.setRowHeight(Y * 120 / 768);
			table.setVisible(true);
			table.setCellSelectionEnabled(true);
			table.getColumnModel().getColumn(0)
					.setCellRenderer(new PlayerCardRenderer());
			table.setOpaque(false);
			if (scrollPane != null) {
				scrollPane.setVisible(false);
			}
			scrollPane = new JScrollPane(table);
			scrollPane.getVerticalScrollBar().setUI(
					new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
			scrollPane.setBounds(X * 200 / 1366, Y *250/ 768, X * 940 / 1366,
					Y * 480 / 768);
			scrollPane.setVisible(true);
			scrollPane
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scrollPane
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setOpaque(false);
			bgLabel.add(scrollPane);

		}
	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		// playerCriteriaPanel.setVisible(false);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		MainFrame.currentPanel="PlayerPanel";
		// playerCriteriaPanel.setVisible(false);
	}

	public class ScreeningPlayerCriteriaPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ScreeningPlayerCriteriaPanel(JFrame mainFrame,
				ScreeningPlayerPanel screeningPlayerPanel) {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(X * 750 / 1366, 190,
					X * 213 / 1366, X * 108 / 1366);
			this.setBorder(new TitledBorder(new EtchedBorder()));
			JLabel bglabel = new JLabel();
			ImageIcon bgPanel = new ImageIcon(new ImageIcon(
					"Image/screeningcriteria.png").getImage()
					.getScaledInstance(this.getWidth(), this.getHeight(),
							Image.SCALE_SMOOTH));
			bglabel.setIcon(bgPanel);
			bglabel.setBounds(0, 0, this.getWidth(), this.getHeight());

			this.add(bglabel);
			ButtonGroup bg = new ButtonGroup();

			MyRadioButton scorebtn = new MyRadioButton("得分");
			scorebtn.setBounds(X * 6 / 1366, Y * 6 / 768, X * 51 / 1366,
					Y * 23 / 768);
			scorebtn.addActionListener(new ScreeningCriteriaListener("得分"));
			bglabel.add(scorebtn);
			bg.add(scorebtn);

			MyRadioButton reboundbtn = new MyRadioButton("篮板");
			reboundbtn.setBounds(X * 6 / 1366, Y * 31 / 768, X * 51 / 1366,
					Y * 23 / 768);
			reboundbtn.addActionListener(new ScreeningCriteriaListener("篮板"));
			bglabel.add(reboundbtn);
			bg.add(reboundbtn);

			MyRadioButton assistancebtn = new MyRadioButton("助攻");
			assistancebtn.setBounds(X * 6 / 1366, Y * 56 / 768, X * 51 / 1366,
					Y * 23 / 768);
			assistancebtn
					.addActionListener(new ScreeningCriteriaListener("助攻"));
			bglabel.add(assistancebtn);
			bg.add(assistancebtn);

			MyRadioButton rdbtnNewRadioButton_3 = new MyRadioButton("得分/篮板/助攻");
			rdbtnNewRadioButton_3.setBounds(X * 56 / 1366, Y * 81 / 768,
					X * 150 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_3
					.addActionListener(new ScreeningCriteriaListener("得分/篮板/助攻"));
			bglabel.add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			MyRadioButton rdbtnNewRadioButton_4 = new MyRadioButton("盖帽");
			rdbtnNewRadioButton_4.setBounds(X * 6 / 1366, Y * 81 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_4
					.addActionListener(new ScreeningCriteriaListener("盖帽"));
			bglabel.add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			MyRadioButton rdbtnNewRadioButton_5 = new MyRadioButton("抢断");
			rdbtnNewRadioButton_5.setBounds(X * 56 / 1366, Y * 6 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_5
					.addActionListener(new ScreeningCriteriaListener("抢断"));
			bglabel.add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

			MyRadioButton rdbtnNewRadioButton_6 = new MyRadioButton("犯规");
			rdbtnNewRadioButton_6.setBounds(X * 56 / 1366, Y * 31 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_6
					.addActionListener(new ScreeningCriteriaListener("犯规"));
			bglabel.add(rdbtnNewRadioButton_6);
			bg.add(rdbtnNewRadioButton_6);

			MyRadioButton rdbtnNewRadioButton_7 = new MyRadioButton("失误");
			rdbtnNewRadioButton_7.setBounds(X * 56 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_7
					.addActionListener(new ScreeningCriteriaListener("失误"));
			bglabel.add(rdbtnNewRadioButton_7);
			bg.add(rdbtnNewRadioButton_7);

			MyRadioButton rdbtnNewRadioButton_8 = new MyRadioButton("分钟");
			rdbtnNewRadioButton_8.setBounds(X * 106 / 1366, Y * 6 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_8
					.addActionListener(new ScreeningCriteriaListener("分钟"));
			bglabel.add(rdbtnNewRadioButton_8);
			bg.add(rdbtnNewRadioButton_8);

			MyRadioButton radioButton = new MyRadioButton("效率");
			radioButton.setBounds(X * 106 / 1366, Y * 31 / 768, X * 51 / 1366,
					Y * 23 / 768);
			radioButton.addActionListener(new ScreeningCriteriaListener("效率"));
			bglabel.add(radioButton);
			bg.add(radioButton);

			MyRadioButton radioButton_1 = new MyRadioButton("投篮");
			radioButton_1.setBounds(X * 106 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_1
					.addActionListener(new ScreeningCriteriaListener("投篮"));
			bglabel.add(radioButton_1);
			bg.add(radioButton_1);

			MyRadioButton radioButton_2 = new MyRadioButton("三分");
			radioButton_2.setBounds(X * 156 / 1366, Y * 6 / 768, X * 51 / 1366,
					Y * 23 / 768);
			radioButton_2
					.addActionListener(new ScreeningCriteriaListener("三分"));
			bglabel.add(radioButton_2);
			bg.add(radioButton_2);

			MyRadioButton radioButton_3 = new MyRadioButton("罚球");
			radioButton_3.setBounds(X * 156 / 1366, Y * 31 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_3
					.addActionListener(new ScreeningCriteriaListener("罚球"));
			bglabel.add(radioButton_3);
			bg.add(radioButton_3);

			MyRadioButton radioButton_4 = new MyRadioButton("两双");
			radioButton_4.setBounds(X * 156 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_4
					.addActionListener(new ScreeningCriteriaListener("两双"));
			bglabel.add(radioButton_4);
			bg.add(radioButton_4);

			mainFrame.getContentPane().add(this);
		}
	}

	class ScreeningCriteriaListener implements ActionListener {
		String criteria;

		public ScreeningCriteriaListener(String criteria) {
			this.criteria = criteria;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			criteriaSelected=criteria;
			showSelected.setText(leagueSelected+"-"+positionSelected+"-"+criteriaSelected);
			switch (criteria) {
			case "得分":
				screeningCriteriabtn.setText("得分");
				playerCriteriaPanel.setVisible(false);
				break;
			case "篮板":
				screeningCriteriabtn.setText("篮板");
				playerCriteriaPanel.setVisible(false);
				break;
			case "助攻":
				screeningCriteriabtn.setText("助攻");
				playerCriteriaPanel.setVisible(false);
				break;
			case "得分/篮板/助攻":
				screeningCriteriabtn.setText("得分/篮板/助攻");
				playerCriteriaPanel.setVisible(false);
				break;
			case "盖帽":
				screeningCriteriabtn.setText("盖帽");
				playerCriteriaPanel.setVisible(false);
				break;
			case "抢断":
				screeningCriteriabtn.setText("抢断");
				playerCriteriaPanel.setVisible(false);
				break;
			case "犯规":
				screeningCriteriabtn.setText("犯规");
				playerCriteriaPanel.setVisible(false);
				break;
			case "失误":
				screeningCriteriabtn.setText("失误");
				playerCriteriaPanel.setVisible(false);
				break;
			case "分钟":
				screeningCriteriabtn.setText("分钟");
				playerCriteriaPanel.setVisible(false);
				break;
			case "效率":
				screeningCriteriabtn.setText("效率");
				playerCriteriaPanel.setVisible(false);
				break;
			case "投篮":
				screeningCriteriabtn.setText("投篮");
				playerCriteriaPanel.setVisible(false);
				break;
			case "三分":
				screeningCriteriabtn.setText("三分");
				playerCriteriaPanel.setVisible(false);
				break;
			case "罚球":
				screeningCriteriabtn.setText("罚球");
				playerCriteriaPanel.setVisible(false);
				break;
			case "两双":
				screeningCriteriabtn.setText("两双");
				playerCriteriaPanel.setVisible(false);
				break;

			default:
				// System.out.println("筛选标准选择出错");
				break;
			}

		}
	}

	
	public void refresh(){
		mainFrame.remove(this);
		MainFrame.screeningPlayerPanel=new ScreeningPlayerPanel(mainFrame, previousPanel);
		if(MainFrame.currentPanel=="ScreeningPlayerPanel"){
			MainFrame.screeningPlayerPanel.setVisible(true);
		}else{
			MainFrame.screeningPlayerPanel.setVisible(false);
		}
		
	}
	
	public void selfClose() {
		this.setVisible(false);
	}

	// class: TableRenderer
	class PlayerCardRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// TODO Auto-generated method stub
			PlayerCardPanel renderer = new PlayerCardPanel(
					((PlayerCardPanel) value).number, X, Y,
					((PlayerCardPanel) value).getPlayerInfo(),
					((PlayerCardPanel) value).getCriteria1(),
					((PlayerCardPanel) value).getCriteriaValue1());

			renderer.fillPanel();
			renderer.setOpaque(false);
			if (hasFocus) {
				MainFrame.playerPanel.setVisible(false);
				MainFrame.playerInfoPanel = new PlayerInfoPanel(renderer
						.getPlayerInfo().getName(), mainFrame,
						new ScreeningPlayerPanel(mainFrame, MainFrame.playerPanel),"ScreeningPlayerPanel");
				selfClose();
			}
			// TODO Auto-generated method stub
			return renderer;

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

	class LeagueButton extends JButton{
		public LeagueButton(String s){
			super();
			this.setText(s);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
			this.setSize(150, 30);
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance( this.getWidth(),this.getHeight(),
						 Image.SCALE_SMOOTH));
		
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.addActionListener(e->{leagueSelected=s;showSelected.setText(leagueSelected+"-"+positionSelected+"-"+criteriaSelected);screening();});
			bgLabel.add(this);
		}
	}
	
	class PositionButton extends JButton{
		public PositionButton(String s){
			super();
			this.setText(s);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
			this.setSize(120, 30);
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance( this.getWidth(),this.getHeight(),
						 Image.SCALE_SMOOTH));
		
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.addActionListener(e->{positionSelected=s;showSelected.setText(leagueSelected+"-"+positionSelected+"-"+criteriaSelected);screening();});
			bgLabel.add(this);
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
			this.addActionListener(e->screening());
		}
	}

}
