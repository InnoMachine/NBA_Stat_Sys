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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.util.Collections;

import vo.PlayerVo;
import vo.TeamVo;
import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import businessLogic.Team_BL;
import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class SortPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame mainFrame;
	JPanel previousPanel;
	private JTable table;
	private JScrollPane scrollPane;

	private Vector<Vector<PlayerCardPanel>> playerRowData;
	private Vector<Vector<TeamCardPanel>> teamRowData;
	private DefaultTableModel dtm;
	private Vector<String> column;

	JComboBox<String> playerSortSeason;
	JButton playerCriteriabtn1;
//	JButton playerCriteriabtn2;
	JComboBox<String> teamSortSeason;
	JButton teamCriteriabtn;
	SortPlayerCriteriaPanel sortPlayerCriteriaPanel1;
//	SortPlayerCriteriaPanel sortPlayerCriteriaPanel2;
	SortTeamCriteriaPanel sortTeamCriteriaPanel;

	Player_BS player_BS = new Player_BL();
	Team_BS team_BS = new Team_BL();

	String playerCriteria1 = "gameNum";
//	String playerCriteria2 = "";
	String teamCriteria = "GameNum.";

	String UpOrDown = "Down";

	static int X;
	static int Y;
	JLabel bgLabel;
	String category;

	public SortPanel(String category, JFrame mainFrame, JPanel previousPanel) {

		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		this.category = category;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);

		this.add(bgLabel);

		sortPlayerCriteriaPanel1 = new SortPlayerCriteriaPanel("first");
		sortPlayerCriteriaPanel1.setVisible(false);
//		sortPlayerCriteriaPanel2 = new SortPlayerCriteriaPanel("second");
//		sortPlayerCriteriaPanel2.setVisible(false);
		sortTeamCriteriaPanel = new SortTeamCriteriaPanel();
		sortTeamCriteriaPanel.setVisible(false);

		
		
		
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

		dtm = new DefaultTableModel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		column = new Vector<String>();
		column.add("");

		if (category == "player") {

			ImageIcon bg = new ImageIcon(new ImageIcon("Image/sortPlayer.png")
					.getImage().getScaledInstance(this.getWidth(),
							this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			
			Vector<String> seasons=new Vector<String>();
			seasons.addElement("14-15");
			seasons.addElement("13-14");
			seasons.addElement("12-13");
			seasons.addElement("11-12");
			seasons.addElement("10-11");
			playerSortSeason=new JComboBox<String>(seasons);
			playerSortSeason.setBounds(X * 400 / 1366, Y * 66 / 768, X*130/1366, Y*28/768);
			playerSortSeason.setSelectedItem("13-14");
			playerSortSeason.setForeground(Color.WHITE);
			playerSortSeason.setBackground(Color.DARK_GRAY);
			bgLabel.add(playerSortSeason);
			playerSortSeason.addActionListener(e->{
				sortPlayer(UpOrDown,String.valueOf(playerSortSeason.getSelectedItem()));
				});
			
			/*
			MyLabel criterialbl = new MyLabel(Color.WHITE, "排序依据");
			criterialbl.setFont(new Font("黑体", 1, 13));
			criterialbl.setBounds(X * 539 / 1366, Y * 66 / 768, X / 15, Y*28/768);
			bgLabel.add(criterialbl);
			*/
			
			playerCriteriabtn1 = new JButton("参赛场数");
			playerCriteriabtn1.setBounds(X * 630 / 1366, Y * 66 / 768,
					X * 212 / 1366, Y*28/768);
			ImageIcon buttonIcon1 = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					212, X / 50, Image.SCALE_SMOOTH));
			playerCriteriabtn1.setHorizontalTextPosition(SwingConstants.CENTER);
			playerCriteriabtn1.setForeground(Color.WHITE);
			playerCriteriabtn1.setIcon(buttonIcon1);
			playerCriteriabtn1.setOpaque(false);
			playerCriteriabtn1.setContentAreaFilled(false);
			playerCriteriabtn1.setBorderPainted(false);
			playerCriteriabtn1.addActionListener(e -> {
//				if (sortPlayerCriteriaPanel2 != null) {
//					sortPlayerCriteriaPanel2.setVisible(false);
//				}
				sortPlayerCriteriaPanel1.setVisible(true);

			});
			bgLabel.add(playerCriteriabtn1);

			
			JButton upSortbtn = new JButton();
			upSortbtn.addActionListener(e -> {
				UpOrDown = "Up";
				sortPlayer(UpOrDown,String.valueOf(playerSortSeason.getSelectedItem()));
			});
			
			ImageIcon UPIcon = new ImageIcon(new ImageIcon(
					"Image/ascending.png").getImage().getScaledInstance(X / 30,
					X / 30, Image.SCALE_SMOOTH));
			upSortbtn.setBounds(14 * X / 20, Y / 14, X / 30, X / 30);
			upSortbtn.setIcon(UPIcon);
			upSortbtn.setOpaque(false);
			upSortbtn.setContentAreaFilled(false);
			upSortbtn.setBorderPainted(false);
			bgLabel.add(upSortbtn);
			
			
			JButton downSortbtn = new JButton();
			downSortbtn.addActionListener(e -> {
				UpOrDown = "Down";
				sortPlayer(UpOrDown,String.valueOf(playerSortSeason.getSelectedItem()));
			});
			
			ImageIcon DownIcon = new ImageIcon(new ImageIcon(
					"Image/descending.png").getImage().getScaledInstance(
					X / 30, X / 30, Image.SCALE_SMOOTH));
			downSortbtn.setBounds(66 * X / 100, Y / 14, X / 30, X / 30);
			downSortbtn.setIcon(DownIcon);
			downSortbtn.setOpaque(false);
			downSortbtn.setContentAreaFilled(false);
			downSortbtn.setBorderPainted(false);
			bgLabel.add(downSortbtn);

			
			// btnSort.addActionListener(e -> sortPlayer(UpOrDown));
			

			this.addMouseListener(new MouseListener() {
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
					/*
					
					 */
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					if (e.getSource() == playerCriteriabtn1) {
						sortPlayerCriteriaPanel1.setVisible(true);
					}
					if (e.getSource() != playerCriteriabtn1
							&& e.getSource() != sortPlayerCriteriaPanel1) {
						sortPlayerCriteriaPanel1.setVisible(false);
					}
//					if (e.getSource() == playerCriteriabtn2) {
//						sortPlayerCriteriaPanel1.setVisible(true);
//					}
//					if (e.getSource() != playerCriteriabtn2
//							&& e.getSource() != sortPlayerCriteriaPanel2) {
//						sortPlayerCriteriaPanel2.setVisible(false);
//					}
				}
			});

			if (table != null) {
				table.setVisible(false);
			}
			playerRowData = new Vector<Vector<PlayerCardPanel>>();

			ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
			playerVos = player_BS.sortPlayerBy("gameNum",String.valueOf(playerSortSeason.getSelectedItem()));
			for (int i = 0; i < playerVos.size(); i++) {
				Vector<PlayerCardPanel> a = new Vector<PlayerCardPanel>();
				a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
						"参赛场数", String
								.valueOf(playerVos.get(i).getGameNum())));
				playerRowData.add(a);
			}

			dtm.setDataVector(playerRowData, column);
			if (table != null) {
				table.repaint();
				table.getColumnModel().getColumn(0)
						.setCellRenderer(new PlayerCardRenderer());
			} else {
				makeTable("player");
			}

		}
		if (category == "team") {

			ImageIcon bg = new ImageIcon(new ImageIcon("Image/teamPanel.png")
					.getImage().getScaledInstance(this.getWidth(),
							this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			JButton upSortbtn = new JButton();
			upSortbtn.addActionListener(e -> {
				UpOrDown = "Up";
				sortTeam(UpOrDown,String.valueOf(teamSortSeason.getSelectedItem()));
			});

			Vector<String> seasons=new Vector<String>();
			seasons.addElement("14-15");
			seasons.addElement("13-14");
			seasons.addElement("12-13");
			seasons.addElement("11-12");
			seasons.addElement("10-11");
		    teamSortSeason=new JComboBox<String>(seasons);
			teamSortSeason.setBounds(X * 240 / 1366, Y * 66 / 768, X*130/1366, Y*28/768);
			teamSortSeason.setSelectedItem("13-14");
			teamSortSeason.setForeground(Color.WHITE);
			teamSortSeason.setBackground(Color.DARK_GRAY);
			bgLabel.add(teamSortSeason);
			teamSortSeason.addActionListener(e->{
				sortTeam(UpOrDown, String.valueOf(teamSortSeason.getSelectedItem()));
			});
			
			teamCriteriabtn = new JButton("比赛场数");
			teamCriteriabtn.setBounds(X * 421 / 1366, Y * 66 / 768,
					X * 500 / 1366, X / 50);
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					X * 500 / 1366, X / 50, Image.SCALE_SMOOTH));
			teamCriteriabtn.setHorizontalTextPosition(SwingConstants.CENTER);
			teamCriteriabtn.setForeground(Color.WHITE);
			teamCriteriabtn.setIcon(buttonIcon);
			teamCriteriabtn.setOpaque(false);
			teamCriteriabtn.setContentAreaFilled(false);
			teamCriteriabtn.setBorderPainted(false);
			teamCriteriabtn.addActionListener(e -> teamCriteriaShow());
			bgLabel.add(teamCriteriabtn);
			
			ImageIcon UPIcon = new ImageIcon(new ImageIcon(
					"Image/ascending.png").getImage().getScaledInstance(X / 30,
					X / 30, Image.SCALE_SMOOTH));
			upSortbtn.setBounds(74 * X / 100, Y / 14, X / 30, X / 30);
			upSortbtn.setIcon(UPIcon);
			upSortbtn.setOpaque(false);
			upSortbtn.setContentAreaFilled(false);
			upSortbtn.setBorderPainted(false);
			bgLabel.add(upSortbtn);

			JButton downSortbtn = new JButton();
			downSortbtn.addActionListener(e -> {
				UpOrDown = "Down";
				sortTeam(UpOrDown,String.valueOf(teamSortSeason.getSelectedItem()));
			});
			ImageIcon DownIcon = new ImageIcon(new ImageIcon(
					"Image/descending.png").getImage().getScaledInstance(
					X / 30, X / 30, Image.SCALE_SMOOTH));
			downSortbtn.setBounds(70 * X / 100, Y / 14, X / 30, X / 30);
			downSortbtn.setIcon(DownIcon);
			downSortbtn.setOpaque(false);
			downSortbtn.setContentAreaFilled(false);
			downSortbtn.setBorderPainted(false);
			bgLabel.add(downSortbtn);

		
		

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
					if (e.getX() <= X * 461 / 1366
							|| e.getX() >= (X * 461 / 1366 + X * 31 / 100)
							|| e.getY() <= (Y * 66 / 768 + X / 50)
							|| e.getY() >= (Y * 66 / 768 + X / 50 + X * 195 / 1366)) {
						if (sortTeamCriteriaPanel != null) {
							sortTeamCriteriaPanel.setVisible(false);
						}
					}
				}
			});

			if (table != null) {
				table.setVisible(false);
			}
			teamRowData = new Vector<Vector<TeamCardPanel>>();

			ArrayList<TeamVo> teamVos = new ArrayList<TeamVo>();
			teamVos = team_BS.sortTeamBy("GameNum",String.valueOf(teamSortSeason.getSelectedItem()));
			for (int i = 0; i < teamVos.size(); i++) {
				Vector<TeamCardPanel> a = new Vector<TeamCardPanel>();
				a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i), "比赛场数",
						String.valueOf(teamVos.get(i).getGameNum())));
				teamRowData.add(a);
			}

			dtm.setDataVector(teamRowData, column);
			if (table != null) {
				table.repaint();
				table.getColumnModel().getColumn(0)
						.setCellRenderer(new PlayerCardRenderer());
			} else {
				makeTable("team");
			}

		}

		mainFrame.getContentPane().add(this);

	}

	public void makeTable(String category) {

		if (table != null) {
			table.setVisible(false);
		}

		table = new JTable(dtm);
		DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
		tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		table.setRowHeight(Y * 120 / 768);
		table.setOpaque(false);
		table.setVisible(true);
		table.setCellSelectionEnabled(true);
		if (category == "team") {
			table.getColumnModel().getColumn(0)
					.setCellRenderer(new TeamCardRenderer());
		}
		if (category == "player") {
			table.getColumnModel().getColumn(0)
					.setCellRenderer(new PlayerCardRenderer());
		}

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}

		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 220 / 1366, Y * 130 / 768, X * 930 / 1366,
				Y * 600 / 768);
		scrollPane.setVisible(true);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		bgLabel.add(scrollPane);

	}

	public void sortPlayer(String UpOrDown,String season) {

		if (sortPlayerCriteriaPanel1 != null) {
			sortPlayerCriteriaPanel1.setVisible(false);
		}
//		if (sortPlayerCriteriaPanel2 != null) {
//			sortPlayerCriteriaPanel2.setVisible(false);
//		}
		playerRowData = new Vector<Vector<PlayerCardPanel>>();

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();

		if (playerCriteria1 == "" ) {
			//	JOptionPane.showMessageDialog(this, "请选择球员排序依据");
		}

		else if (playerCriteria1 != "" ) {
			playerVos = player_BS.sortPlayerBy(playerCriteria1,season);

			if (UpOrDown == "Up") {
				Collections.reverse(playerVos);
			}

			for (int i = 0; i < playerVos.size(); i++) {

				Vector<PlayerCardPanel> a = new Vector<PlayerCardPanel>();
				a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
						playerCriteriabtn1.getText(), getSortValue(playerVos.get(i),
								playerCriteriabtn1.getText())));
				playerRowData.add(a);

			}
			dtm.setDataVector(playerRowData, column);
			if (table != null) {
				table.repaint();
				table.getColumnModel().getColumn(0)
						.setCellRenderer(new PlayerCardRenderer());
			} else {
				makeTable("player");
			}
			UpOrDown = "Down"; // 恢复默认降序
		} 
	}

	private String getSortValue(PlayerVo playerVo, String text) {
		String sortValue = "";
		switch (text) {
		case "gameNum":
			sortValue = String.valueOf(playerVo.getGameNum());

			break;
		case "FirstOnNum":
			sortValue = String.valueOf(playerVo.getFirstOnNum());
			break;
		case "reboundOverallField":
			sortValue = String.valueOf(playerVo.getReboundOverallField());
			break;
		case "assistanceField":
			sortValue = String.valueOf(playerVo.getAssistanceField());
			break;
		case "timeField":
			sortValue = String.valueOf(playerVo.getTimeField());
			break;
		case "hitRate":
			sortValue = String.valueOf(playerVo.getHitRate());
			break;
		case "threePointHitRate":
			sortValue = String.valueOf(playerVo.getThreePointHitRate());
			break;
		case "freeThrowRate":
			sortValue = String.valueOf(playerVo.getFreeThrowRate());
			break;
		case "attackingNumField":
			sortValue = String.valueOf(playerVo.getAttackingNumField());
			break;
		case "defensiveNumField":
			sortValue = String.valueOf(playerVo.getDefensiveNumField());
			break;
		case "stealField":
			sortValue = String.valueOf(playerVo.getStealField());
			break;
		case "blockField":
			sortValue = String.valueOf(playerVo.getBlockField());
			break;
		case "turnoverField":
			sortValue = String.valueOf(playerVo.getTurnoverField());
			break;
		case "foulField":
			sortValue = String.valueOf(playerVo.getFoulField());
			break;

		case "scoreField":
			sortValue = String.valueOf(playerVo.getScoreField());
			break;
		case "efficiencyField":
			sortValue = String.valueOf(playerVo.getEfficiencyField());
			break;

		case "GmScField":
			sortValue = String.valueOf(playerVo.getGmScField());
			break;
		case "trueHitRate":
			sortValue = String.valueOf(playerVo.getTrueHitRate());
			break;

		case "hitEfficiency":
			sortValue = String.valueOf(playerVo.getHitEfficiency());
			break;
		case "reboundOverallRate":
			sortValue = String.valueOf(playerVo.getReboundOverallRate());
			break;

		case "offensiveReboundRate":
			sortValue = String.valueOf(playerVo.getOffensiveReboundRate());
			break;
		case "defensiveReboundRate":
			sortValue = String.valueOf(playerVo.getDefensiveReboundRate());
			break;

		case "assistanceRate":
			sortValue = String.valueOf(playerVo.getAssistanceRate());
			break;
		case "stealRate":
			sortValue = String.valueOf(playerVo.getStealRate());
			break;
		case "blockRate":
			sortValue = String.valueOf(playerVo.getBlockRate());
			break;
		case "turnOverRate":
			sortValue = String.valueOf(playerVo.getTurnOverRate());
			break;
		case "useRate":
			sortValue = String.valueOf(playerVo.getUseRate());
			break;
		default:
			System.out.println(text);
			break;

		}

		return sortValue;
	}

	public void sortTeam(String UpOrDown,String season) {

		if (sortTeamCriteriaPanel != null) {
			sortTeamCriteriaPanel.setVisible(false);
		}

		teamRowData = new Vector<Vector<TeamCardPanel>>();
		ArrayList<TeamVo> teamVos = new ArrayList<TeamVo>();
		if (teamCriteria == "") {
			JOptionPane.showMessageDialog(this, "请选择球队排序依据");
		} else {

			teamVos = team_BS.sortTeamBy(teamCriteria,season);

			if (UpOrDown == "Up") {
				Collections.reverse(teamVos);
			}

			for (int i = 0; i < teamVos.size(); i++) {
				Vector<TeamCardPanel> a = new Vector<TeamCardPanel>();
				switch (teamCriteria) {
				case "GameNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getGameNum())));

					break;
				case "hitNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getHitNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getHitNumField())));

					break;
				case "shotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getShotNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getShotNumField())));

					break;
				case "threePointHitNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getThreePointHitNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getThreePointHitNumField())));

					break;
				case "threePointShotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getThreePointShotNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getThreePointShotNumField())));

					break;
				case "freeThrowHitNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFreeThrowHitNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getFreeThrowHitNumField())));

					break;
				case "freeThrowShotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFreeThrowShotNum())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getFreeThrowShotNumField())));

					break;
				case "offensiveRebound":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getOffensiveRebound())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getOffensiveReboundField())));

					break;
				case "defensiveRebound":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getDefensiveRebound())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getDefensiveReboundField())));

					break;
				case "reboundOverall":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getReboundOverall())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getReboundOverallField())));

					break;
				case "assistance":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getAssistance())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getAssistanceField())));

					break;
				case "steal":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getSteal())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getStealField())));
					break;
				case "block":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getBlock())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getBlockField())));

					break;
				case "turnover":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getTurnover())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getTurnoverField())));

					break;
				case "foul":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFoul())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getFoulField())));

					break;

				case "score":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getScore())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getScoreField())));

					break;
				case "hitRate":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getHitRate())));

					break;

				case "threePointHitRate":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getThreePointHitRate())));

					break;
				case "freeThrowRate":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFreeThrowRate())));

					break;

				case "winningRate":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getWinningRate())));

					break;
				case "roundAttack":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getRoundAttack())
									+ "/"
									+ String.valueOf(teamVos.get(i)
											.getRoundAttackField())));

					break;

				case "attackingEfficiency":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getAttackingEfficiency())));

					break;
				case "defensiveEfficiency":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getDefensiveEfficiency())));

					break;
				case "reboundEfficiency":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getReboundEfficiency())));

					break;
				case "stealEfficiency":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getStealEfficiency())));

					break;
				case "assistanceEfficiency":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getAssistanceEfficiency())));

					break;
				default:
					break;
				}
				teamRowData.add(a);
			}
			dtm.setDataVector(teamRowData, column);
			if (table != null) {
				table.repaint();
				table.getColumnModel().getColumn(0)
						.setCellRenderer(new TeamCardRenderer());
			} else {
				makeTable("team");
			}
			UpOrDown = "Down"; // 恢复默认降序
		}
	}

	public void teamCriteriaShow() {
		sortTeamCriteriaPanel.setVisible(true);
	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.analysisPanel, MainFrame.playerPanel,
				MainFrame.teamPanel, MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		sortPlayerCriteriaPanel1.setVisible(false);
//		sortPlayerCriteriaPanel2.setVisible(false);
		sortTeamCriteriaPanel.setVisible(false);
	}

	public void back() {
		this.setVisible(false);
		
		if (category.equals("player")) {
			MainFrame.playerPanel.setVisible(true);
			MainFrame.currentPanel = "PlayerPanel";
		} else if (category.equals("team")) {
			MainFrame.teamPanel.setVisible(true);
			MainFrame.currentPanel = "TeamPanel";
		}
	}

	public void refresh() {
		mainFrame.remove(this);
		if (category.equals("player")) {
			MainFrame.sortPlayerPanel = new SortPanel("player", mainFrame,
					previousPanel);
			if (MainFrame.currentPanel == "SortPlayerPanel") {
				MainFrame.sortPlayerPanel.setVisible(true);
			} else {
				MainFrame.sortPlayerPanel.setVisible(false);
			}
		} else if (category.equals("team")) {
			MainFrame.sortTeamPanel = new SortPanel("team", mainFrame,
					previousPanel);
			if (MainFrame.currentPanel == "SortTeamPanel") {
				MainFrame.sortTeamPanel.setVisible(true);
			} else {
				MainFrame.sortTeamPanel.setVisible(false);
			}
		}
	}

	public class SortPlayerCriteriaPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SortPlayerCriteriaPanel(String priority) {
			JLabel bglabel = new JLabel();
			ButtonGroup bg = new ButtonGroup();

			if (priority == "first") {

				this.setLayout(null);
				this.setVisible(true);
				this.setBounds(X * 630 / 1366, Y * 66 / 768 + X / 50,
						X * 212 / 1366, X * 263 / 1000);

			} else if (priority == "second") {
				this.setLayout(null);
				this.setVisible(true);
				this.setBounds(X * 655 / 1366, Y * 66 / 768 + X / 50,
						X * 212 / 1366, X * 263 / 1000);
				MyRadioButton radioButton_20 = new MyRadioButton("ALL");
				radioButton_20.setBounds(X * 34 / 400, Y * 331 / 768,
						X * 29 / 400, X * 15 / 700);
				radioButton_20
						.addActionListener(new SortPlayerCriteriaListener(
								"ALL", priority));
				bglabel.add(radioButton_20);
				bg.add(radioButton_20);

			}
			ImageIcon bgPanel = new ImageIcon(new ImageIcon(
					"Image/choosePanel.png").getImage()
					.getScaledInstance(this.getWidth(), this.getHeight(),
							Image.SCALE_SMOOTH));
			bglabel.setIcon(bgPanel);
			bglabel.setOpaque(false);
			bglabel.setBounds(0, 0, this.getWidth(), this.getHeight());
			this.add(bglabel);

			this.setBorder(new TitledBorder(new EtchedBorder()));

			MyRadioButton rdbtnNewRadioButton = new MyRadioButton("参赛场数");
			rdbtnNewRadioButton.setBounds(X * 4 / 1366, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton
					.addActionListener(new SortPlayerCriteriaListener("参赛场数",
							priority));
			bglabel.add(rdbtnNewRadioButton);
			bg.add(rdbtnNewRadioButton);

			MyRadioButton rdbtnNewRadioButton_1 = new MyRadioButton("先发场数");
			rdbtnNewRadioButton_1.setBounds(X * 34 / 400, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_1
					.addActionListener(new SortPlayerCriteriaListener("先发场数",
							priority));
			bglabel.add(rdbtnNewRadioButton_1);
			bg.add(rdbtnNewRadioButton_1);

			MyRadioButton rdbtnNewRadioButton_5 = new MyRadioButton("使用率");
			rdbtnNewRadioButton_5.setBounds(X * 34 / 400, Y * 181 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_5
					.addActionListener(new SortPlayerCriteriaListener("使用率",
							priority));
			bglabel.add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

			MyRadioButton rdbtnNewRadioButton_2 = new MyRadioButton("篮板数");
			rdbtnNewRadioButton_2.setBounds(X * 4 / 1366, Y * 206 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_2
					.addActionListener(new SortPlayerCriteriaListener("篮板数",
							priority));
			bglabel.add(rdbtnNewRadioButton_2);
			bg.add(rdbtnNewRadioButton_2);

			MyRadioButton rdbtnNewRadioButton_3 = new MyRadioButton("助攻数");
			rdbtnNewRadioButton_3.setBounds(X * 34 / 400, Y * 206 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_3
					.addActionListener(new SortPlayerCriteriaListener("助攻数",
							priority));
			bglabel.add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			MyRadioButton rdbtnNewRadioButton_4 = new MyRadioButton("在场时间");
			rdbtnNewRadioButton_4.setBounds(X * 4 / 1366, Y * 181 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_4
					.addActionListener(new SortPlayerCriteriaListener("在场时间",
							priority));
			bglabel.add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			MyRadioButton radioButton = new MyRadioButton("投篮命中率");
			radioButton.setBounds(X * 4 / 1366, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton.addActionListener(new SortPlayerCriteriaListener(
					"投篮命中率", priority));
			bglabel.add(radioButton);
			bg.add(radioButton);

			MyRadioButton radioButton_1 = new MyRadioButton("三分命中率");
			radioButton_1.setBounds(X * 34 / 400, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_1.addActionListener(new SortPlayerCriteriaListener(
					"三分命中率", priority));
			bglabel.add(radioButton_1);
			bg.add(radioButton_1);

			MyRadioButton radioButton_2 = new MyRadioButton("罚球命中率");
			radioButton_2.setBounds(X * 4 / 1366, Y * 331 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_2.addActionListener(new SortPlayerCriteriaListener(
					"罚球命中率", priority));
			bglabel.add(radioButton_2);
			bg.add(radioButton_2);

			MyRadioButton radioButton_3 = new MyRadioButton("进攻数");
			radioButton_3.setBounds(X * 4 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_3.addActionListener(new SortPlayerCriteriaListener(
					"进攻数", priority));
			bglabel.add(radioButton_3);
			bg.add(radioButton_3);

			MyRadioButton radioButton_4 = new MyRadioButton("防守数");
			radioButton_4.setBounds(X * 34 / 400, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_4.addActionListener(new SortPlayerCriteriaListener(
					"防守数", priority));
			bglabel.add(radioButton_4);
			bg.add(radioButton_4);

			MyRadioButton radioButton_5 = new MyRadioButton("抢断数");
			radioButton_5.setBounds(X * 4 / 1366, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_5.addActionListener(new SortPlayerCriteriaListener(
					"抢断数", priority));
			bglabel.add(radioButton_5);
			bg.add(radioButton_5);

			MyRadioButton radioButton_6 = new MyRadioButton("盖帽数");
			radioButton_6.setBounds(X * 34 / 400, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_6.addActionListener(new SortPlayerCriteriaListener(
					"盖帽数", priority));
			bglabel.add(radioButton_6);
			bg.add(radioButton_6);

			MyRadioButton radioButton_7 = new MyRadioButton("失误数");
			radioButton_7.setBounds(X * 4 / 1366, Y * 231 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_7.addActionListener(new SortPlayerCriteriaListener(
					"失误数", priority));
			bglabel.add(radioButton_7);
			bg.add(radioButton_7);

			MyRadioButton radioButton_8 = new MyRadioButton("犯规数");
			radioButton_8.setBounds(X * 34 / 400, Y * 231 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_8.addActionListener(new SortPlayerCriteriaListener(
					"犯规数", priority));
			bglabel.add(radioButton_8);
			bg.add(radioButton_8);

			MyRadioButton radioButton_9 = new MyRadioButton("得分");
			radioButton_9.setBounds(X * 4 / 1366, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_9.addActionListener(new SortPlayerCriteriaListener(
					"得分", priority));
			bglabel.add(radioButton_9);
			bg.add(radioButton_9);

			MyRadioButton radioButton_10 = new MyRadioButton("效率");
			radioButton_10.setBounds(X * 4 / 1366, Y * 306 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_10.addActionListener(new SortPlayerCriteriaListener(
					"效率", priority));
			bglabel.add(radioButton_10);
			bg.add(radioButton_10);

			MyRadioButton rdbtnGmsc = new MyRadioButton("GmSc效率值");
			rdbtnGmsc.setBounds(X * 34 / 400, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			rdbtnGmsc.addActionListener(new SortPlayerCriteriaListener(
					"GmSc效率值", priority));
			bglabel.add(rdbtnGmsc);
			bg.add(rdbtnGmsc);

			MyRadioButton radioButton_11 = new MyRadioButton("真实命中率");
			radioButton_11.setBounds(X * 34 / 400, Y * 306 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_11.addActionListener(new SortPlayerCriteriaListener(
					"真实命中率", priority));
			bglabel.add(radioButton_11);
			bg.add(radioButton_11);

			MyRadioButton radioButton_12 = new MyRadioButton("投篮效率");
			radioButton_12.setBounds(X * 4 / 1366, Y * 256 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_12.addActionListener(new SortPlayerCriteriaListener(
					"投篮效率", priority));
			bglabel.add(radioButton_12);
			bg.add(radioButton_12);

			MyRadioButton radioButton_13 = new MyRadioButton("篮板率");
			radioButton_13.setBounds(X * 34 / 400, Y * 256 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_13.addActionListener(new SortPlayerCriteriaListener(
					"篮板率", priority));
			bglabel.add(radioButton_13);
			bg.add(radioButton_13);

			MyRadioButton radioButton_14 = new MyRadioButton("进攻篮板率");
			radioButton_14.setBounds(X * 4 / 1366, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_14.addActionListener(new SortPlayerCriteriaListener(
					"进攻篮板率", priority));
			bglabel.add(radioButton_14);
			bg.add(radioButton_14);

			MyRadioButton radioButton_15 = new MyRadioButton("防守篮板率");
			radioButton_15.setBounds(X * 34 / 400, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_15.addActionListener(new SortPlayerCriteriaListener(
					"防守篮板率", priority));
			bglabel.add(radioButton_15);
			bg.add(radioButton_15);

			MyRadioButton radioButton_16 = new MyRadioButton("助攻率");
			radioButton_16.setBounds(X * 4 / 1366, Y * 281 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_16.addActionListener(new SortPlayerCriteriaListener(
					"助攻率", priority));
			bglabel.add(radioButton_16);
			bg.add(radioButton_16);

			MyRadioButton radioButton_17 = new MyRadioButton("抢断率");
			radioButton_17.setBounds(X * 34 / 400, Y * 281 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_17.addActionListener(new SortPlayerCriteriaListener(
					"抢断率", priority));
			bglabel.add(radioButton_17);
			bg.add(radioButton_17);

			MyRadioButton radioButton_18 = new MyRadioButton("盖帽率");
			radioButton_18.setBounds(X * 4 / 1366, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_18.addActionListener(new SortPlayerCriteriaListener(
					"盖帽率", priority));
			bglabel.add(radioButton_18);
			bg.add(radioButton_18);

			MyRadioButton radioButton_19 = new MyRadioButton("失误率");
			radioButton_19.setBounds(X * 34 / 400, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_19.addActionListener(new SortPlayerCriteriaListener(
					"失误率", priority));
			bglabel.add(radioButton_19);
			bg.add(radioButton_19);

			mainFrame.getContentPane().add(this);

		}
	}

	public class SortTeamCriteriaPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public SortTeamCriteriaPanel() {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(X * 421 / 1366, Y * 66 / 768 + X / 50,
					X * 500 / 1366, X * 195 / 1366);

			this.setBorder(new TitledBorder(new EtchedBorder()));
			this.setBorder(new TitledBorder(new EtchedBorder()));
			JLabel bglabel = new JLabel();
			ImageIcon bgPanel = new ImageIcon(new ImageIcon(
					"Image/choosePanel.png").getImage()
					.getScaledInstance(this.getWidth(), this.getHeight(),
							Image.SCALE_SMOOTH));
			bglabel.setIcon(bgPanel);
			bglabel.setBounds(0, 0, this.getWidth(), this.getHeight());

			this.add(bglabel);
			ButtonGroup bg1 = new ButtonGroup();

			MyRadioButton radioButton = new MyRadioButton("比赛场数");
			radioButton.setBounds(X * 5 / 1366, Y * 6 / 768, X * 130 / 1366,
					X * 15 / 700);
			radioButton.addActionListener(new SortTeamCriteriaListener("比赛场数"));
			bglabel.add(radioButton);
			bg1.add(radioButton);

			MyRadioButton radioButton_1 = new MyRadioButton("投篮命中数/场均");
			radioButton_1.setBounds(X * 5 / 1366, Y * 31 / 768, X * 130 / 1366,
					X * 15 / 700);
			radioButton_1.addActionListener(new SortTeamCriteriaListener(
					"投篮命中率"));
			bglabel.add(radioButton_1);
			bg1.add(radioButton_1);

			MyRadioButton radioButton_2 = new MyRadioButton("投篮出手数/场均");
			radioButton_2.setBounds(X * 131 / 1366, Y * 31 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_2.addActionListener(new SortTeamCriteriaListener(
					"投篮出手数"));
			bglabel.add(radioButton_2);
			bg1.add(radioButton_2);

			MyRadioButton radioButton_3 = new MyRadioButton("三分命中数/场均");
			radioButton_3.setBounds(X * 257 / 1366, Y * 31 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_3.addActionListener(new SortTeamCriteriaListener(
					"三分命中数"));
			bglabel.add(radioButton_3);
			bg1.add(radioButton_3);

			MyRadioButton radioButton_4 = new MyRadioButton("三分出手数/场均");
			radioButton_4.setBounds(X * 383 / 1366, Y * 31 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_4.addActionListener(new SortTeamCriteriaListener(
					"三分出手数"));
			bglabel.add(radioButton_4);
			bg1.add(radioButton_4);

			MyRadioButton radioButton_5 = new MyRadioButton("罚球命中数/场均");
			radioButton_5.setBounds(X * 5 / 1366, Y * 56 / 768, X * 130 / 1366,
					X * 15 / 700);
			radioButton_5.addActionListener(new SortTeamCriteriaListener(
					"罚球命中数"));
			bglabel.add(radioButton_5);
			bg1.add(radioButton_5);

			MyRadioButton radioButton_6 = new MyRadioButton("罚球出手数/场均");
			radioButton_6.setBounds(X * 131 / 1366, Y * 56 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_6.addActionListener(new SortTeamCriteriaListener(
					"罚球出手数"));
			bglabel.add(radioButton_6);
			bg1.add(radioButton_6);

			MyRadioButton radioButton_7 = new MyRadioButton("进攻篮板数/场均");
			radioButton_7.setBounds(X * 131 / 1366, Y * 6 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_7.addActionListener(new SortTeamCriteriaListener(
					"进攻篮板数"));
			bglabel.add(radioButton_7);
			bg1.add(radioButton_7);

			MyRadioButton radioButton_8 = new MyRadioButton("防守篮板数/场均");
			radioButton_8.setBounds(X * 257 / 1366, Y * 6 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_8.addActionListener(new SortTeamCriteriaListener(
					"防守篮板数"));
			bglabel.add(radioButton_8);
			bg1.add(radioButton_8);

			MyRadioButton radioButton_9 = new MyRadioButton("篮板数/场均");
			radioButton_9.setBounds(X * 383 / 1366, Y * 6 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_9
					.addActionListener(new SortTeamCriteriaListener("篮板数"));
			bglabel.add(radioButton_9);
			bg1.add(radioButton_9);

			MyRadioButton radioButton_10 = new MyRadioButton("助攻数/场均");
			radioButton_10.setBounds(X * 257 / 1366, Y * 56 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_10
					.addActionListener(new SortTeamCriteriaListener("助攻数"));
			bglabel.add(radioButton_10);
			bg1.add(radioButton_10);

			MyRadioButton radioButton_11 = new MyRadioButton("抢断数/场均");
			radioButton_11.setBounds(X * 383 / 1366, Y * 56 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_11
					.addActionListener(new SortTeamCriteriaListener("抢断数"));
			bglabel.add(radioButton_11);
			bg1.add(radioButton_11);

			MyRadioButton radioButton_12 = new MyRadioButton("盖帽数/场均");
			radioButton_12.setBounds(X * 5 / 1366, Y * 81 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_12
					.addActionListener(new SortTeamCriteriaListener("盖帽数"));
			bglabel.add(radioButton_12);
			bg1.add(radioButton_12);

			MyRadioButton radioButton_13 = new MyRadioButton("失误数/场均");
			radioButton_13.setBounds(X * 131 / 1366, Y * 81 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_13
					.addActionListener(new SortTeamCriteriaListener("失误数"));
			bglabel.add(radioButton_13);
			bg1.add(radioButton_13);

			MyRadioButton radioButton_14 = new MyRadioButton("犯规数/场均");
			radioButton_14.setBounds(X * 257 / 1366, Y * 81 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_14
					.addActionListener(new SortTeamCriteriaListener("犯规数"));
			bglabel.add(radioButton_14);
			bg1.add(radioButton_14);

			MyRadioButton radioButton_15 = new MyRadioButton("比赛得分/场均");
			radioButton_15.setBounds(X * 383 / 1366, Y * 81 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_15.addActionListener(new SortTeamCriteriaListener(
					"比赛得分"));
			bglabel.add(radioButton_15);
			bg1.add(radioButton_15);

			MyRadioButton radioButton_16 = new MyRadioButton("投篮命中率");
			radioButton_16.setBounds(X * 5 / 1366, Y * 106 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_16.addActionListener(new SortTeamCriteriaListener(
					"投篮命中率"));
			bglabel.add(radioButton_16);
			bg1.add(radioButton_16);

			MyRadioButton radioButton_17 = new MyRadioButton("三分命中率");
			radioButton_17.setBounds(X * 131 / 1366, Y * 106 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_17.addActionListener(new SortTeamCriteriaListener(
					"三分命中率"));
			bglabel.add(radioButton_17);
			bg1.add(radioButton_17);

			MyRadioButton radioButton_18 = new MyRadioButton("罚球命中率");
			radioButton_18.setBounds(X * 257 / 1366, Y * 106 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_18.addActionListener(new SortTeamCriteriaListener(
					"罚球命中率"));
			bglabel.add(radioButton_18);
			bg1.add(radioButton_18);

			MyRadioButton radioButton_19 = new MyRadioButton("胜率");
			radioButton_19.setBounds(X * 383 / 1366, Y * 106 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_19
					.addActionListener(new SortTeamCriteriaListener("胜率"));
			bglabel.add(radioButton_19);
			bg1.add(radioButton_19);

			MyRadioButton radioButton_20 = new MyRadioButton("进攻回合/场均");
			radioButton_20.setBounds(X * 5 / 1366, Y * 131 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_20.addActionListener(new SortTeamCriteriaListener(
					"进攻回合"));
			bglabel.add(radioButton_20);
			bg1.add(radioButton_20);

			MyRadioButton radioButton_21 = new MyRadioButton("进攻效率");
			radioButton_21.setBounds(X * 131 / 1366, Y * 131 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_21.addActionListener(new SortTeamCriteriaListener(
					"进攻效率"));
			bglabel.add(radioButton_21);
			bg1.add(radioButton_21);

			MyRadioButton radioButton_22 = new MyRadioButton("防守效率");
			radioButton_22.setBounds(X * 257 / 1366, Y * 131 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_22.addActionListener(new SortTeamCriteriaListener(
					"防守效率"));
			bglabel.add(radioButton_22);
			bg1.add(radioButton_22);

			MyRadioButton radioButton_23 = new MyRadioButton("篮板效率");
			radioButton_23.setBounds(X * 383 / 1366, Y * 131 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_23.addActionListener(new SortTeamCriteriaListener(
					"篮板效率"));
			bglabel.add(radioButton_23);
			bg1.add(radioButton_23);

			MyRadioButton radioButton_24 = new MyRadioButton("抢断效率");
			radioButton_24.setBounds(X * 5 / 1366, Y * 156 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_24.addActionListener(new SortTeamCriteriaListener(
					"抢断效率"));
			bglabel.add(radioButton_24);
			bg1.add(radioButton_24);

			MyRadioButton radioButton_25 = new MyRadioButton("助攻率");
			radioButton_25.setBounds(X * 131 / 1366, Y * 156 / 768,
					X * 130 / 1366, X * 15 / 700);
			radioButton_25
					.addActionListener(new SortTeamCriteriaListener("助攻率"));
			bglabel.add(radioButton_25);
			bg1.add(radioButton_25);

			mainFrame.getContentPane().add(this);
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
					((PlayerCardPanel) value).getCriteriaValue1(),
					((PlayerCardPanel) value).getCriteria2(),
					((PlayerCardPanel) value).getCriteriaValue2());

			renderer.fillPanel();

			if (hasFocus) {
				MainFrame.playerPanel.setVisible(false);
				MainFrame.playerInfoPanel = new PlayerInfoPanel(renderer
						.getPlayerInfo().getName(), mainFrame, new SortPanel(
						"player", mainFrame, MainFrame.playerPanel),
						"SortPlayerPanel");
				selfClose();
			}
			// TODO Auto-generated method stub
			return renderer;

		}

	}

	class TeamCardRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			TeamCardPanel renderer = new TeamCardPanel(
					((TeamCardPanel) value).number, X, Y,
					((TeamCardPanel) value).getTeamInfo(),
					((TeamCardPanel) value).getCriteria(),
					((TeamCardPanel) value).getCriteriaValue());
			renderer.fillPanel();
			if (hasFocus) {
				MainFrame.teamPanel.setVisible(false);
				MainFrame.teamInfoPanel = new TeamInfoPanel(renderer
						.getTeamInfo().getAbbreviation(), mainFrame,
						new SortPanel("team", mainFrame, MainFrame.teamPanel),
						"SortTeamPanel");
				selfClose();
			}
			// TODO Auto-generated method stub
			return renderer;
		}

	}

	class SortPlayerCriteriaListener implements ActionListener {
		String criteria;
		String priority;

		public SortPlayerCriteriaListener(String criteria, String priority) {
			this.criteria = criteria;
			this.priority = priority;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (priority == "first") {
				switch (criteria) {
				case "参赛场数":
					playerCriteriabtn1.setText("参赛场数");
					playerCriteria1 = "gameNum";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "先发场数":
					playerCriteriabtn1.setText("先发场数");
					playerCriteria1 = "FirstOnNum";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "篮板数":
					playerCriteriabtn1.setText("篮板数");
					playerCriteria1 = "reboundOverallField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "助攻数":
					playerCriteriabtn1.setText("助攻数");
					playerCriteria1 = "assistanceField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "在场时间":
					playerCriteriabtn1.setText("在场时间");
					playerCriteria1 = "timeField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "投篮命中率":
					playerCriteriabtn1.setText("投篮命中率");
					playerCriteria1 = "hitRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "三分命中率":
					playerCriteriabtn1.setText("三分命中率");
					playerCriteria1 = "threePointHitRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "罚球命中率":
					playerCriteriabtn1.setText("罚球命中率");
					playerCriteria1 = "freeThrowRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "进攻数":
					playerCriteriabtn1.setText("进攻数");
					playerCriteria1 = "attackingNumField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "防守数":
					playerCriteriabtn1.setText("防守数");
					playerCriteria1 = "defensiveNumField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "抢断数":
					playerCriteriabtn1.setText("抢断数");
					playerCriteria1 = "stealField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "盖帽数":
					playerCriteriabtn1.setText("盖帽数");
					playerCriteria1 = "blockField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "失误数":
					playerCriteriabtn1.setText("失误数");
					playerCriteria1 = "turnoverField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "犯规数":
					playerCriteriabtn1.setText("犯规数");
					playerCriteria1 = "foulField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "得分":
					playerCriteriabtn1.setText("得分");
					playerCriteria1 = "scoreField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "效率":
					playerCriteriabtn1.setText("效率");
					playerCriteria1 = "efficiencyField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "GmSc效率值":
					playerCriteriabtn1.setText("GmSc效率值");
					playerCriteria1 = "GmScField";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "真实命中率":
					playerCriteriabtn1.setText("真实命中率");
					playerCriteria1 = "trueHitRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "投篮效率":
					playerCriteriabtn1.setText("投篮效率");
					playerCriteria1 = "hitEfficiency";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "篮板率":
					playerCriteriabtn1.setText("篮板率");
					playerCriteria1 = "reboundOverallRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "进攻篮板率":
					playerCriteriabtn1.setText("进攻篮球率");
					playerCriteria1 = "offensiveReboundRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "防守篮板率":
					playerCriteriabtn1.setText("防守篮板率");
					playerCriteria1 = "defensiveReboundRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "助攻率":
					playerCriteriabtn1.setText("助攻率");
					playerCriteria1 = "assistanceRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;

				case "抢断率":
					playerCriteriabtn1.setText("抢断率");
					playerCriteria1 = "stealRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "盖帽率":
					playerCriteriabtn1.setText("盖帽率");
					playerCriteria1 = "blockRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "失误率":
					playerCriteriabtn1.setText("失误率");
					playerCriteria1 = "turnOverRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				case "使用率":
					playerCriteriabtn1.setText("使用率");
					playerCriteria1 = "useRate";
					sortPlayerCriteriaPanel1.setVisible(false);
					break;
				default:
					break;
				}
			} 
			sortPlayer(UpOrDown,String.valueOf(playerSortSeason.getSelectedItem()));
		}
	}

	class SortTeamCriteriaListener implements ActionListener {
		String criteria;

		public SortTeamCriteriaListener(String criteria) {
			this.criteria = criteria;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (criteria) {
			case "比赛场数":
				teamCriteriabtn.setText("比赛场数");
				teamCriteria = "GameNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮命中数":
				teamCriteriabtn.setText("投篮命中数");
				teamCriteria = "hitNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮出手数":
				teamCriteriabtn.setText("投篮出手数");
				teamCriteria = "shotNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分命中数":
				teamCriteriabtn.setText("三分命中数");
				teamCriteria = "threePointHitNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分出手数":
				teamCriteriabtn.setText("三分出手数");
				teamCriteria = "threePointShotNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球命中数":
				teamCriteriabtn.setText("罚球命中数");
				teamCriteria = "freeThrowHitNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球出手数":
				teamCriteriabtn.setText("罚球出手数");
				teamCriteria = "freeThrowShotNum";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻篮板数":
				teamCriteriabtn.setText("进攻篮板数");
				teamCriteria = "offensiveRebound";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "防守篮板数":
				teamCriteriabtn.setText("防守篮板数");
				teamCriteria = "defensiveRebound";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "篮板数":
				teamCriteriabtn.setText("篮板数");
				teamCriteria = "reboundOverall";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "助攻数":
				teamCriteriabtn.setText("助攻数");
				teamCriteria = "assistance";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "抢断数":
				teamCriteriabtn.setText("抢断数");
				teamCriteria = "steal";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "盖帽数":
				teamCriteriabtn.setText("盖帽数");
				teamCriteria = "block";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "失误数":
				teamCriteriabtn.setText("失误数");
				teamCriteria = "turnover";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "犯规数":
				teamCriteriabtn.setText("犯规数");
				teamCriteria = "foul";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "比赛得分":
				teamCriteriabtn.setText("比赛得分");
				teamCriteria = "score";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮命中率":
				teamCriteriabtn.setText("投篮命中率");
				teamCriteria = "hitRate";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分命中率":
				teamCriteriabtn.setText("三分命中率");
				teamCriteria = "threePointHitRate";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球命中率":
				teamCriteriabtn.setText("罚球命中率");
				teamCriteria = "freeThrowRate";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "胜率":
				teamCriteriabtn.setText("胜率");
				teamCriteria = "winningRate";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻回合":
				teamCriteriabtn.setText("进攻回合");
				teamCriteria = "roundAttack";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻效率":
				teamCriteriabtn.setText("进攻效率");
				teamCriteria = "attackingEfficiency";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "防守效率":
				teamCriteriabtn.setText("防守效率");
				teamCriteria = "defensiveEfficiency";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "篮板效率":
				teamCriteriabtn.setText("篮板效率");
				teamCriteria = "reboundEfficiency";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "抢断效率":
				teamCriteriabtn.setText("抢断效率");
				teamCriteria = "stealEfficiency";
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "助攻率":
				teamCriteriabtn.setText("助攻率");
				teamCriteria = "assistanceEfficiency";
				sortTeamCriteriaPanel.setVisible(false);
				break;

			default:
				break;
			}
			sortTeam(UpOrDown,String.valueOf(teamSortSeason.getSelectedItem()));
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
