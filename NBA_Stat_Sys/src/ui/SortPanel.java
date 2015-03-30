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
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
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
	JFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;

	private Vector<Vector<PlayerCardPanel>> playerRowData;
	private Vector<Vector<TeamCardPanel>> teamRowData;
	private DefaultTableModel dtm;
	private Vector<String> column;

	JButton playerCriteriabtn;
	JButton teamCriteriabtn;
	SortPlayerCriteriaPanel sortPlayerCriteriaPanel;
	SortTeamCriteriaPanel sortTeamCriteriaPanel;

	Player_BS player_BS = new Player_BL();
	Team_BS team_BS = new Team_BL();

	String playerCriteria = "";
	String teamCriteria = "";

	String UpOrDown = "Down";

	static int X;
	static int Y;
	JLabel bgLabel;

	public SortPanel(String category, JFrame mainFrame) {

		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);

		this.add(bgLabel);
		sortPlayerCriteriaPanel = new SortPlayerCriteriaPanel();
		sortPlayerCriteriaPanel.setVisible(false);

		sortTeamCriteriaPanel = new SortTeamCriteriaPanel();
		sortTeamCriteriaPanel.setVisible(false);

		MyLabel criterialbl = new MyLabel(Color.WHITE,"排序依据");
		criterialbl.setFont(new Font("黑体", 1, 13));
		criterialbl.setBounds(X * 335 / 1366, Y * 66 / 768, X / 15, X / 50);
		bgLabel.add(criterialbl);

		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 0, X / 15, X / 50);
		backbtn.addActionListener(e -> back());
		bgLabel.add(backbtn);
		
		
		JButton minimize = new JButton();
		minimize.setBounds(X - X * 70 / 1366, Y * 6 / 768, X * 25 / 1366,
				Y * 25 / 768);
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		bgLabel.add(minimize);
		
		JButton close = new JButton();
		close.setBounds(X - X * 35 / 1366, Y * 6 / 768, X * 25 / 1366,
				Y * 25 / 768);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
		});
		bgLabel.add(close);
		

		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		column = new Vector<String>();
		column.add("");

		if (category == "player") {

			ImageIcon bg = new ImageIcon(new ImageIcon(
					"Image/screeningPanel.png").getImage().getScaledInstance(
					this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			JButton upSortbtn = new JButton("U");
			upSortbtn.setBounds(X * 950 / 1366, Y * 66 / 768, X / 50, X / 50);
			upSortbtn.addActionListener(e -> {
				UpOrDown = "Up";
				sortPlayer(UpOrDown);
			});
			bgLabel.add(upSortbtn);

			JButton downSortbtn = new JButton("D");
			downSortbtn.setBounds(X * 991 / 1366, Y * 66 / 768, X / 50, X / 50);
			downSortbtn.addActionListener(e -> {
				UpOrDown = "Down";
				sortPlayer(UpOrDown);
			});
			bgLabel.add(downSortbtn);

			// btnSort.addActionListener(e -> sortPlayer(UpOrDown));
			playerCriteriabtn = new JButton("");
			playerCriteriabtn.setBounds(X * 461 / 1366, Y * 66 / 768,
					X * 31 / 100, X / 50);
			playerCriteriabtn.addActionListener(e -> playerCriteriaShow());
			bgLabel.add(playerCriteriabtn);

			
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
	                System.out.println("CLICKED!    X: "+e.getX()+"   Y: "+e.getY());
					if (e.getX() <= X * 461 / 1366 ||e.getX() >= (X * 461 / 1366+X * 31 / 100)
							|| e.getY() <= (Y * 66 / 768 + X / 50)
							|| e.getY() >= (Y * 66 / 768 + X / 50 + X * 14 / 100)){
						if (sortPlayerCriteriaPanel != null) {
	                            sortPlayerCriteriaPanel.setVisible(false);
						}
					}
				}
			});
			
		}
		if (category == "team") {

			ImageIcon bg = new ImageIcon(new ImageIcon(
					"Image/screeningPanel.png").getImage().getScaledInstance(
					this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			JButton upSortbtn = new JButton("U");
			upSortbtn.setBounds(X * 950 / 1366, Y * 66 / 768, X / 50, X / 50);
			upSortbtn.addActionListener(e -> {
				UpOrDown = "Up";
				sortTeam(UpOrDown);
			});
			bgLabel.add(upSortbtn);

			JButton downSortbtn = new JButton("D");
			downSortbtn.setBounds(X * 991 / 1366, Y * 66 / 768, X / 50, X / 50);
			downSortbtn.addActionListener(e -> {
				UpOrDown = "Down";
				sortTeam(UpOrDown);
			});
			bgLabel.add(downSortbtn);

			// btnSort.addActionListener(e -> sortTeam(UpOrDown));
			teamCriteriabtn = new JButton("");
			teamCriteriabtn.setBounds(X * 461 / 1366, Y * 66 / 768,
					X * 31 / 100, X / 50);
			teamCriteriabtn.addActionListener(e -> teamCriteriaShow());
			bgLabel.add(teamCriteriabtn);

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
	                System.out.println("CLICKED!    X: "+e.getX()+"   Y: "+e.getY());
					if (e.getX() <= X * 461 / 1366 ||e.getX() >= (X * 461 / 1366+ X * 31 / 100)
							|| e.getY() <= (Y * 66 / 768 + X / 50)
							|| e.getY() >= (Y * 66 / 768 + X / 50 + X * 195 / 1366)){
						if (sortTeamCriteriaPanel != null) {
	                            sortTeamCriteriaPanel.setVisible(false);
						}
					}
				}
			});
			
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

	public void sortPlayer(String UpOrDown) {

		if (sortPlayerCriteriaPanel != null) {
			sortPlayerCriteriaPanel.setVisible(false);
		}

		playerRowData = new Vector<Vector<PlayerCardPanel>>();

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();

		if (playerCriteria == "") {
			JOptionPane.showMessageDialog(this, "请选择球员排序依据");
		} else {
			System.out.println(playerCriteria);
			playerVos = player_BS.sortPlayerBy(playerCriteria);

			if (UpOrDown == "Up") {
				Collections.reverse(playerVos);
			}

			for (int i = 0; i < playerVos.size(); i++) {

				Vector<PlayerCardPanel> a = new Vector<PlayerCardPanel>();
				switch (playerCriteria) {
				case "gameNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getGameNum())));

					break;
				case "FirstOnNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getFirstOnNum())));
					break;
				case "reboundOverallField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getReboundOverallField())));
					break;
				case "assistanceField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getAssistanceField())));
					break;
				case "time":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTime() / 60.0)));
					break;
				case "hitRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getHitRate())));
					break;
				case "threePointHitRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getThreePointHitRate())));
					break;
				case "freeThrowRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getFreeThrowRate())));
					break;
				case "attackingNumField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(),
							String.valueOf(playerVos.get(i).getAttackingNumField())));
					break;
				case "defensiveNumField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(),
							String.valueOf(playerVos.get(i).getDefensiveNumField())));
					break;
				case "stealField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getStealField())));
					break;
				case "blockField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getBlockField())));
					break;
				case "turnoverField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTurnoverField())));
					break;
				case "foulField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getFoulField())));
					break;

				case "scoreField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getScoreField())));
					break;
				case "efficiencyField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getEfficiencyField())));
					break;

				case "GmScField":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getGmScField())));
					break;
				case "trueHitRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTrueHitRate())));
					break;

				case "hitEfficiency":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getHitEfficiency())));
					break;
				case "reboundOverallRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getReboundOverallRate())));
					break;

				case "offensiveReboundRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getOffensiveReboundRate())));
					break;
				case "defensiveReboundRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getDefensiveReboundRate())));
					break;

				case "assistanceRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getAssistanceRate())));
					break;
				case "stealRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getStealRate())));
					break;
				case "blockRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getBlockRate())));
					break;
				case "turnOverRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(),
							String.valueOf(playerVos.get(i).getTurnOverRate())));
					break;
				case "useRate":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							playerCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getUseRate())));
					break;
				default:
					break;

				}
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

	public void sortTeam(String UpOrDown) {

		if (sortTeamCriteriaPanel != null) {
			sortTeamCriteriaPanel.setVisible(false);
		}

		teamRowData = new Vector<Vector<TeamCardPanel>>();
		ArrayList<TeamVo> teamVos = new ArrayList<TeamVo>();
		if (teamCriteria == "") {
			JOptionPane.showMessageDialog(this, "请选择球队排序依据");
		} else {

			teamVos = team_BS.sortTeamBy(teamCriteria);

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
									.get(i).getHitNum())));

					break;
				case "shotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getShotNum())));

					break;
				case "threePointHitNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getThreePointHitNum())));

					break;
				case "threePointShotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getThreePointShotNum())));

					break;
				case "freeThrowHitNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFreeThrowHitNum())));

					break;
				case "freeThrowShotNum":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFreeThrowShotNum())));

					break;
				case "offensiveRebound":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getOffensiveRebound())));

					break;
				case "defensiveRebound":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getDefensiveRebound())));

					break;
				case "reboundOverall":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getReboundOverall())));

					break;
				case "assistance":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getAssistance())));

					break;
				case "steal":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getSteal())));
					break;
				case "block":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getBlock())));

					break;
				case "turnover":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getTurnover())));

					break;
				case "foul":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getFoul())));

					break;

				case "score":
					a.add(new TeamCardPanel(i + 1, X, Y, teamVos.get(i),
							teamCriteriabtn.getText(), String.valueOf(teamVos
									.get(i).getScore())));

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
				case "freeeThrowRate":
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
									.get(i).getRoundAttack())));

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

	public void playerCriteriaShow() {
		sortPlayerCriteriaPanel.setVisible(true);
	}

	public void teamCriteriaShow() {
		sortTeamCriteriaPanel.setVisible(true);
	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
		sortPlayerCriteriaPanel.setVisible(false);
		sortTeamCriteriaPanel.setVisible(false);
	}

	public class SortPlayerCriteriaPanel extends JPanel {
		public SortPlayerCriteriaPanel() {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(X * 461 / 1366, Y * 66 / 768 + X / 50, X * 31 / 100,
					X * 14 / 100);

			this.setBorder(new TitledBorder(new EtchedBorder()));

			ButtonGroup bg = new ButtonGroup();

			JRadioButton rdbtnNewRadioButton = new JRadioButton("参赛场数");
			rdbtnNewRadioButton.setBounds(X * 4 / 1366, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton
					.addActionListener(new SortPlayerCriteriaListener("参赛场数"));
			add(rdbtnNewRadioButton);
			bg.add(rdbtnNewRadioButton);

			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("先发场数");
			rdbtnNewRadioButton_1.setBounds(X * 34 / 400, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_1
					.addActionListener(new SortPlayerCriteriaListener("先发场数"));
			add(rdbtnNewRadioButton_1);
			bg.add(rdbtnNewRadioButton_1);

			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("使用率");
			rdbtnNewRadioButton_5.setBounds(X * 94 / 400, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_5
					.addActionListener(new SortPlayerCriteriaListener("使用率"));
			add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("篮板数");
			rdbtnNewRadioButton_2.setBounds(X * 64 / 400, Y * 31 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_2
					.addActionListener(new SortPlayerCriteriaListener("篮板数"));
			add(rdbtnNewRadioButton_2);
			bg.add(rdbtnNewRadioButton_2);

			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("助攻数");
			rdbtnNewRadioButton_3.setBounds(X * 94 / 400, Y * 31 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_3
					.addActionListener(new SortPlayerCriteriaListener("助攻数"));
			add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("在场时间");
			rdbtnNewRadioButton_4.setBounds(X * 64 / 400, Y * 6 / 768,
					X * 29 / 400, X * 15 / 700);
			rdbtnNewRadioButton_4
					.addActionListener(new SortPlayerCriteriaListener("在场时间"));
			add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			JRadioButton radioButton = new JRadioButton("投篮命中率");
			radioButton.setBounds(X * 4 / 1366, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton.addActionListener(new SortPlayerCriteriaListener(
					"投篮命中率"));
			add(radioButton);
			bg.add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("三分命中率");
			radioButton_1.setBounds(X * 34 / 400, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_1.addActionListener(new SortPlayerCriteriaListener(
					"三分命中率"));
			add(radioButton_1);
			bg.add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("罚球命中率");
			radioButton_2.setBounds(X * 64 / 400, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_2.addActionListener(new SortPlayerCriteriaListener(
					"罚球命中率"));
			add(radioButton_2);
			bg.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("进攻数");
			radioButton_3.setBounds(X * 4 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_3.addActionListener(new SortPlayerCriteriaListener(
					"进攻数"));
			add(radioButton_3);
			bg.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("防守数");
			radioButton_4.setBounds(X * 34 / 400, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_4.addActionListener(new SortPlayerCriteriaListener(
					"防守数"));
			add(radioButton_4);
			bg.add(radioButton_4);

			JRadioButton radioButton_5 = new JRadioButton("抢断数");
			radioButton_5.setBounds(X * 4 / 1366, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_5.addActionListener(new SortPlayerCriteriaListener(
					"抢断数"));
			add(radioButton_5);
			bg.add(radioButton_5);

			JRadioButton radioButton_6 = new JRadioButton("盖帽数");
			radioButton_6.setBounds(X * 34 / 400, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_6.addActionListener(new SortPlayerCriteriaListener(
					"盖帽数"));
			add(radioButton_6);
			bg.add(radioButton_6);

			JRadioButton radioButton_7 = new JRadioButton("失误数");
			radioButton_7.setBounds(X * 64 / 400, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_7.addActionListener(new SortPlayerCriteriaListener(
					"失误数"));
			add(radioButton_7);
			bg.add(radioButton_7);

			JRadioButton radioButton_8 = new JRadioButton("犯规数");
			radioButton_8.setBounds(X * 94 / 400, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_8.addActionListener(new SortPlayerCriteriaListener(
					"犯规数"));
			add(radioButton_8);
			bg.add(radioButton_8);

			JRadioButton radioButton_9 = new JRadioButton("得分");
			radioButton_9.setBounds(X * 4 / 1366, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_9
					.addActionListener(new SortPlayerCriteriaListener("得分"));
			add(radioButton_9);
			bg.add(radioButton_9);

			JRadioButton radioButton_10 = new JRadioButton("效率");
			radioButton_10.setBounds(X * 64 / 400, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_10.addActionListener(new SortPlayerCriteriaListener(
					"效率"));
			add(radioButton_10);
			bg.add(radioButton_10);

			JRadioButton rdbtnGmsc = new JRadioButton("GmSc效率值");
			rdbtnGmsc.setBounds(X * 34 / 400, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			rdbtnGmsc.addActionListener(new SortPlayerCriteriaListener(
					"GmSc效率值"));
			add(rdbtnGmsc);
			bg.add(rdbtnGmsc);

			JRadioButton radioButton_11 = new JRadioButton("真实命中率");
			radioButton_11.setBounds(X * 94 / 400, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_11.addActionListener(new SortPlayerCriteriaListener(
					"真实命中率"));
			add(radioButton_11);
			bg.add(radioButton_11);

			JRadioButton radioButton_12 = new JRadioButton("投篮效率");
			radioButton_12.setBounds(X * 64 / 400, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_12.addActionListener(new SortPlayerCriteriaListener(
					"投篮效率"));
			add(radioButton_12);
			bg.add(radioButton_12);

			JRadioButton radioButton_13 = new JRadioButton("篮板率");
			radioButton_13.setBounds(X * 94 / 400, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_13.addActionListener(new SortPlayerCriteriaListener(
					"篮板率"));
			add(radioButton_13);
			bg.add(radioButton_13);

			JRadioButton radioButton_14 = new JRadioButton("进攻篮板率");
			radioButton_14.setBounds(X * 4 / 1366, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_14.addActionListener(new SortPlayerCriteriaListener(
					"进攻篮板率"));
			add(radioButton_14);
			bg.add(radioButton_14);

			JRadioButton radioButton_15 = new JRadioButton("防守篮板率");
			radioButton_15.setBounds(X * 34 / 400, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_15.addActionListener(new SortPlayerCriteriaListener(
					"防守篮板率"));
			add(radioButton_15);
			bg.add(radioButton_15);

			JRadioButton radioButton_16 = new JRadioButton("助攻率");
			radioButton_16.setBounds(X * 64 / 400, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_16.addActionListener(new SortPlayerCriteriaListener(
					"助攻率"));
			add(radioButton_16);
			bg.add(radioButton_16);

			JRadioButton radioButton_17 = new JRadioButton("抢断率");
			radioButton_17.setBounds(X * 94 / 400, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_17.addActionListener(new SortPlayerCriteriaListener(
					"抢断率"));
			add(radioButton_17);
			bg.add(radioButton_17);

			JRadioButton radioButton_18 = new JRadioButton("盖帽率");
			radioButton_18.setBounds(X * 4 / 1366, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_18.addActionListener(new SortPlayerCriteriaListener(
					"盖帽率"));
			add(radioButton_18);
			bg.add(radioButton_18);

			JRadioButton radioButton_19 = new JRadioButton("失误率");
			radioButton_19.setBounds(X * 34 / 400, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_19.addActionListener(new SortPlayerCriteriaListener(
					"失误率"));
			add(radioButton_19);
			bg.add(radioButton_19);

			mainFrame.getContentPane().add(this);

		}
	}

	public class SortTeamCriteriaPanel extends JPanel {
		public SortTeamCriteriaPanel() {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(X * 461 / 1366, Y * 66 / 768 + X / 50, X * 31 / 100,
					X * 195 / 1366);

			this.setBorder(new TitledBorder(new EtchedBorder()));

			ButtonGroup bg1 = new ButtonGroup();

			JRadioButton radioButton = new JRadioButton("比赛场数");
			radioButton.setBounds(X * 8 / 1366, Y * 6 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton.addActionListener(new SortTeamCriteriaListener("比赛场数"));
			add(radioButton);
			bg1.add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("投篮命中数");
			radioButton_1.setBounds(X * 8 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_1.addActionListener(new SortTeamCriteriaListener(
					"投篮命中率"));
			add(radioButton_1);
			bg1.add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("投篮出手数");
			radioButton_2.setBounds(X * 111 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_2.addActionListener(new SortTeamCriteriaListener(
					"投篮出手数"));
			add(radioButton_2);
			bg1.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("三分命中数");
			radioButton_3.setBounds(X * 214 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_3.addActionListener(new SortTeamCriteriaListener(
					"三分命中数"));
			add(radioButton_3);
			bg1.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("三分出手数");
			radioButton_4.setBounds(X * 317 / 1366, Y * 31 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_4.addActionListener(new SortTeamCriteriaListener(
					"三分出手数"));
			add(radioButton_4);
			bg1.add(radioButton_4);

			JRadioButton radioButton_5 = new JRadioButton("罚球命中数");
			radioButton_5.setBounds(X * 8 / 1366, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_5.addActionListener(new SortTeamCriteriaListener(
					"罚球命中数"));
			add(radioButton_5);
			bg1.add(radioButton_5);

			JRadioButton radioButton_6 = new JRadioButton("罚球出手数");
			radioButton_6.setBounds(X * 111 / 1366, Y * 56 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_6.addActionListener(new SortTeamCriteriaListener(
					"罚球出手数"));
			add(radioButton_6);
			bg1.add(radioButton_6);

			JRadioButton radioButton_7 = new JRadioButton("进攻篮板数");
			radioButton_7.setBounds(X * 111 / 1366, Y * 6 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_7.addActionListener(new SortTeamCriteriaListener(
					"进攻篮板数"));
			add(radioButton_7);
			bg1.add(radioButton_7);

			JRadioButton radioButton_8 = new JRadioButton("防守篮板数");
			radioButton_8.setBounds(X * 214 / 1366, Y * 6 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_8.addActionListener(new SortTeamCriteriaListener(
					"防守篮板数"));
			add(radioButton_8);
			bg1.add(radioButton_8);

			JRadioButton radioButton_9 = new JRadioButton("篮板数");
			radioButton_9.setBounds(X * 317 / 1366, Y * 6 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_9
					.addActionListener(new SortTeamCriteriaListener("篮板数"));
			add(radioButton_9);
			bg1.add(radioButton_9);

			JRadioButton radioButton_10 = new JRadioButton("助攻数");
			radioButton_10.setBounds(X * 214 / 1366, Y * 56 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_10
					.addActionListener(new SortTeamCriteriaListener("助攻数"));
			add(radioButton_10);
			bg1.add(radioButton_10);

			JRadioButton radioButton_11 = new JRadioButton("抢断数");
			radioButton_11.setBounds(X * 317 / 1366, Y * 56 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_11
					.addActionListener(new SortTeamCriteriaListener("抢断数"));
			add(radioButton_11);
			bg1.add(radioButton_11);

			JRadioButton radioButton_12 = new JRadioButton("盖帽数");
			radioButton_12.setBounds(X * 8 / 1366, Y * 81 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_12
					.addActionListener(new SortTeamCriteriaListener("盖帽数"));
			add(radioButton_12);
			bg1.add(radioButton_12);

			JRadioButton radioButton_13 = new JRadioButton("失误数");
			radioButton_13.setBounds(X * 111 / 1366, Y * 81 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_13
					.addActionListener(new SortTeamCriteriaListener("失误数"));
			add(radioButton_13);
			bg1.add(radioButton_13);

			JRadioButton radioButton_14 = new JRadioButton("犯规数");
			radioButton_14.setBounds(X * 214 / 1366, Y * 81 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_14
					.addActionListener(new SortTeamCriteriaListener("犯规数"));
			add(radioButton_14);
			bg1.add(radioButton_14);

			JRadioButton radioButton_15 = new JRadioButton("比赛得分");
			radioButton_15.setBounds(X * 317 / 1366, Y * 81 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_15.addActionListener(new SortTeamCriteriaListener(
					"比赛得分"));
			add(radioButton_15);
			bg1.add(radioButton_15);

			JRadioButton radioButton_16 = new JRadioButton("投篮命中率");
			radioButton_16.setBounds(X * 8 / 1366, Y * 106 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_16.addActionListener(new SortTeamCriteriaListener(
					"投篮命中率"));
			add(radioButton_16);
			bg1.add(radioButton_16);

			JRadioButton radioButton_17 = new JRadioButton("三分命中率");
			radioButton_17.setBounds(X * 111 / 1366, Y * 106 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_17.addActionListener(new SortTeamCriteriaListener(
					"三分命中率"));
			add(radioButton_17);
			bg1.add(radioButton_17);

			JRadioButton radioButton_18 = new JRadioButton("罚球命中率");
			radioButton_18.setBounds(X * 214 / 1366, Y * 106 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_18.addActionListener(new SortTeamCriteriaListener(
					"罚球命中率"));
			add(radioButton_18);
			bg1.add(radioButton_18);

			JRadioButton radioButton_19 = new JRadioButton("胜率");
			radioButton_19.setBounds(X * 317 / 1366, Y * 106 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_19
					.addActionListener(new SortTeamCriteriaListener("胜率"));
			add(radioButton_19);
			bg1.add(radioButton_19);

			JRadioButton radioButton_20 = new JRadioButton("进攻回合");
			radioButton_20.setBounds(X * 8 / 1366, Y * 131 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_20.addActionListener(new SortTeamCriteriaListener(
					"进攻回合"));
			add(radioButton_20);
			bg1.add(radioButton_20);

			JRadioButton radioButton_21 = new JRadioButton("进攻效率");
			radioButton_21.setBounds(X * 111 / 1366, Y * 131 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_21.addActionListener(new SortTeamCriteriaListener(
					"进攻效率"));
			add(radioButton_21);
			bg1.add(radioButton_21);

			JRadioButton radioButton_22 = new JRadioButton("防守效率");
			radioButton_22.setBounds(X * 214 / 1366, Y * 131 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_22.addActionListener(new SortTeamCriteriaListener(
					"防守效率"));
			add(radioButton_22);
			bg1.add(radioButton_22);

			JRadioButton radioButton_23 = new JRadioButton("篮板效率");
			radioButton_23.setBounds(X * 317 / 1366, Y * 131 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_23.addActionListener(new SortTeamCriteriaListener(
					"篮板效率"));
			add(radioButton_23);
			bg1.add(radioButton_23);

			JRadioButton radioButton_24 = new JRadioButton("抢断效率");
			radioButton_24.setBounds(X * 8 / 1366, Y * 156 / 768, X * 29 / 400,
					X * 15 / 700);
			radioButton_24.addActionListener(new SortTeamCriteriaListener(
					"抢断效率"));
			add(radioButton_24);
			bg1.add(radioButton_24);

			JRadioButton radioButton_25 = new JRadioButton("助攻率");
			radioButton_25.setBounds(X * 111 / 1366, Y * 156 / 768,
					X * 29 / 400, X * 15 / 700);
			radioButton_25
					.addActionListener(new SortTeamCriteriaListener("助攻率"));
			add(radioButton_25);
			bg1.add(radioButton_25);

			mainFrame.getContentPane().add(this);
		}

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
					((PlayerCardPanel) value).getCriteria(),
					((PlayerCardPanel) value).getCriteriaValue());

			renderer.fillPanel();

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

			// TODO Auto-generated method stub
			return renderer;
		}

	}

	class SortPlayerCriteriaListener implements ActionListener {
		String criteria;

		public SortPlayerCriteriaListener(String criteria) {
			this.criteria = criteria;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (criteria) {
			case "参赛场数":
				playerCriteriabtn.setText("参赛场数");
				playerCriteria = "gameNum";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "先发场数":
				playerCriteriabtn.setText("先发场数");
				playerCriteria = "FirstOnNum";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "篮板数":
				playerCriteriabtn.setText("篮板数");
				playerCriteria = "reboundOverallField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "助攻数":
				playerCriteriabtn.setText("助攻数");
				playerCriteria = "assistanceField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "在场时间":
				playerCriteriabtn.setText("在场时间");
				playerCriteria = "time";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "投篮命中率":
				playerCriteriabtn.setText("投篮命中率");
				playerCriteria = "hitRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "三分命中率":
				playerCriteriabtn.setText("三分命中率");
				playerCriteria = "threePointHitRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "罚球命中率":
				playerCriteriabtn.setText("罚球命中率");
				playerCriteria = "freeThrowRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "进攻数":
				playerCriteriabtn.setText("进攻数");
				playerCriteria = "attackingNumField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "防守数":
				playerCriteriabtn.setText("防守数");
				playerCriteria = "defensiveNumField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "抢断数":
				playerCriteriabtn.setText("抢断数");
				playerCriteria = "stealField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "盖帽数":
				playerCriteriabtn.setText("盖帽数");
				playerCriteria = "blockField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "失误数":
				playerCriteriabtn.setText("失误数");
				playerCriteria = "turnoverField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "犯规数":
				playerCriteriabtn.setText("犯规数");
				playerCriteria = "foulField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "得分":
				playerCriteriabtn.setText("得分");
				playerCriteria = "scoreField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "效率":
				playerCriteriabtn.setText("效率");
				playerCriteria = "efficiencyField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "GmSc效率值":
				playerCriteriabtn.setText("GmSc效率值");
				playerCriteria = "GmScField";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "真实命中率":
				playerCriteriabtn.setText("真实命中率");
				playerCriteria = "trueHitRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "投篮效率":
				playerCriteriabtn.setText("投篮效率");
				playerCriteria = "hitEfficiency";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "篮板率":
				playerCriteriabtn.setText("篮板率");
				playerCriteria = "reboundOverallRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "进攻篮板率":
				playerCriteriabtn.setText("进攻篮球率");
				playerCriteria = "offensiveReboundRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "防守篮板率":
				playerCriteriabtn.setText("防守篮板率");
				playerCriteria = "defensiveReboundRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "助攻率":
				playerCriteriabtn.setText("助攻率");
				playerCriteria = "assistanceRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;

			case "抢断率":
				playerCriteriabtn.setText("抢断率");
				playerCriteria = "stealRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "盖帽率":
				playerCriteriabtn.setText("盖帽率");
				playerCriteria = "blockRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "失误率":
				playerCriteriabtn.setText("失误率");
				playerCriteria = "turnOverRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "使用率":
				playerCriteriabtn.setText("使用率");
				playerCriteria = "useRate";
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			default:
				System.out.println("筛选标准选择出错");
				break;
			}
			sortPlayer(UpOrDown);
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
				teamCriteria = "deffensiveRebound";
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
				System.out.println("筛选标准选择出错");
				break;
			}
			sortTeam(UpOrDown);
		}
	}
	
	class MyTextField extends JTextField {
		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));

		}

	}

	class MyLabel extends JLabel {
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
