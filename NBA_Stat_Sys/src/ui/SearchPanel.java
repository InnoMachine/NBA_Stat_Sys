package ui;

import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import vo.PlayerVo;
import vo.TeamVo;
import businessLogic.Player_BL;
import businessLogic.Player_BS;
import businessLogic.Team_BL;
import businessLogic.Team_BS;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SearchPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame mainFrame;
	Player_BS player_BS = new Player_BL();
	Team_BS team_BS = new Team_BL();
	// private JTable table;
	// private DefaultTableModel model;
	// private JScrollPane scrollPane;

	JLabel bgLabel;
	String category = "player";
	Vector<Vector<PlayerButton>> playerRowData;
	Vector<String> teamColumn;
	Vector<String> playerColumn;
	JTable playerTable;
	DefaultTableModel playerDTM;

	// private JTextField textField;
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
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField txtGmsc;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	// private JTextField textField_68;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_69;
	private JTextField textField_72;
	private JTextField textField_73;
	private JTextField textField_67;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JTextField textField_87;
	private JTextField textField_88;
	private JTextField textField_89;
	private JTextField textField_90;
	private JTextField textField_91;
	private JTextField textField_92;
	private JTextField textField_93;
	private JTextField textField_94;
	private JTextField textField_95;
	private JTextField textField_96;
	private JTextField textField_97;
	private JTextField textField_98;
	private JTextField textField_99;
	private JTextField textField_100;
	private JTextField textField_101;
	private JTextField textField_102;
	private JTextField textField_103;
	private JTextField textField_104;
	private JTextField textField_105;
	private JTextField textField_106;
	private JTextField textField_107;
	private JTextField textField_108;
	private JTextField textField_109;
	private JTextField textField_110;
	private JTextField textField_111;
	private JTextField textField_112;
	private JTextField textField_113;
	private JTextField textField_114;
	private JTextField textField_115;
	private JTextField textField_116;
	private JTextField textField_117;
	private JTextField textField_118;
	private JTextField textField_119;
	private JTextField textField_120;
	private JTextField textField_121;
	private JTextField textField_122;
	private JTextField textField_123;
	private JTextField textField_124;
	private JTextField textField_125;
	private JTextField textField_126;
	private JTextField textField_127;
	private JTextField textField_128;
	private JTextField textField_129;
	private JTextField textField_130;
	private JTextField textField_131;
	private JTextField textField_132;
	private JTextField textField_133;
	private JTextField textField_134;
	private JTextField textField_135;
	private JTextField textField_136;
	private JTextField textField_137;
	private JTextField textField_138;
	private JLabel playerAction;
	String teamForShowPlayer = "";

	static int X;
	static int Y;

	public SearchPanel(String category, JFrame mainFrame) {
		this.category = category;
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);


		ImageIcon bg;
		bgLabel = new JLabel();

		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		if (category.equals("player")) {
			bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png")
					.getImage().getScaledInstance(this.getWidth(),
							this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			createPlayerPanel();
			this.repaint();
		}
		if (category == "team") {
			bg = new ImageIcon(new ImageIcon("Image/searchTeam.png").getImage()
					.getScaledInstance(this.getWidth(), this.getHeight(),
							Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			createTeamPanel();
			this.repaint();
		}
		JButton home= new JButton();
		ImageIcon homeIcon=new ImageIcon(new ImageIcon("Image/homeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
		home.setBounds(17*X/20,Y/18, X/25,X/25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		bgLabel.add(home);
		JButton minimize = new JButton();
		ImageIcon minimizeIcon=new ImageIcon(new ImageIcon("Image/minimizeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
		minimize.setBounds(18*X/20,Y/18, X/25,X/25);
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
		ImageIcon closeIcon=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
		close.setBounds(19*X/20,Y/18, X/25,X/25);
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

	}

	public void showTeamInfo(String abbr) {

		TeamVo teamVo = team_BS.getTeamByAbbr(abbr);
		textField_74.setText(teamVo.getTeamName());
		textField_79.setText(teamVo.getAbbreviation());
		textField_76.setText(teamVo.getCity());
		textField_80.setText(String.valueOf(teamVo.getConference()));
		textField_82.setText(String.valueOf(teamVo.getDivision()));
		textField_84.setText(String.valueOf(teamVo.getHomeField()));
		textField_86.setText(teamVo.getBirthYear());
		textField_88.setText(String.valueOf(teamVo.getGameNum()));
		textField_90.setText(String.valueOf(teamVo.getHitNum()) + "/"
				+ String.valueOf(teamVo.getHitNumField()));
		textField_93.setText(String.valueOf(teamVo.getShotNum()) + "/"
				+ String.valueOf(teamVo.getShotNumField()));
		textField_94.setText(String.valueOf(teamVo.getThreePointHitNum()) + "/"
				+ String.valueOf(teamVo.getThreePointHitNumField()));
		textField_96.setText(String.valueOf(teamVo.getThreePointShotNum())
				+ "/" + String.valueOf(teamVo.getThreePointShotNumField()));
		textField_98.setText(String.valueOf(teamVo.getFreeThrowHitNum()) + "/"
				+ String.valueOf(teamVo.getFreeThrowHitNumField()));
		textField_100.setText(String.valueOf(teamVo.getFreeThrowShotNum())
				+ "/" + String.valueOf(teamVo.getFreeThrowShotNumField()));
		textField_102.setText(String.valueOf(teamVo.getOffensiveRebound())
				+ "/" + String.valueOf(teamVo.getOffensiveReboundField()));
		textField_104.setText(String.valueOf(teamVo.getDefensiveRebound())
				+ "/" + String.valueOf(teamVo.getDefensiveReboundField()));
		textField_106.setText(String.valueOf(teamVo.getReboundOverall()) + "/"
				+ String.valueOf(teamVo.getReboundOverallField()));
		textField_108.setText(String.valueOf(teamVo.getAssistance()) + "/"
				+ String.valueOf(teamVo.getAssistanceField()));
		textField_110.setText(String.valueOf(teamVo.getSteal()) + "/"
				+ String.valueOf(teamVo.getStealField()));
		textField_112.setText(String.valueOf(teamVo.getBlock()) + "/"
				+ String.valueOf(teamVo.getBlockField()));
		textField_114.setText(String.valueOf(teamVo.getTurnover()) + "/"
				+ String.valueOf(teamVo.getTurnoverField()));
		textField_116.setText(String.valueOf(teamVo.getFoul()) + "/"
				+ String.valueOf(teamVo.getFoulField()));
		textField_118.setText(String.valueOf(teamVo.getScore()) + "/"
				+ String.valueOf(teamVo.getScoreField()));
		textField_120.setText(String.valueOf(teamVo.getHitRate()));
		textField_122.setText(String.valueOf(teamVo.getThreePointHitRate()));
		textField_124.setText(String.valueOf(teamVo.getFreeThrowRate()));
		textField_126.setText(String.valueOf(teamVo.getWinningRate()));
		textField_128.setText(String.valueOf(teamVo.getRoundAttack()));
		textField_130.setText(String.valueOf(teamVo.getAttackingEfficiency()));
		textField_132.setText(String.valueOf(teamVo.getDefensiveEfficiency()));
		textField_134.setText(String.valueOf(teamVo.getReboundEfficiency()));
		textField_136.setText(String.valueOf(teamVo.getStealEfficiency()));
		textField_138.setText(String.valueOf(teamVo.getAssistanceEfficiency()));

	}

	public void showPlayerInfo(String pName) {
		PlayerVo player = player_BS.getPlayerByName(pName);

		textField_4.setText(player.getName());
		textField_9.setText(player.getHeight());
		textField_13.setText(player.getBirth());
		textField_5.setText(player.getPosition());
		textField_10.setText(player.getWeight());
		textField_73.setText(String.valueOf(player.getExp()));
		textField_72.setText(String.valueOf(player.getNumber()));
		textField_14.setText(String.valueOf(player.getAge()));
		textField_16.setText(player.getSchool());
		textField_18.setText(String.valueOf(player.getGameNum()));
		textField_20.setText(String.valueOf(player.getFirstOnNum()));
		textField_24.setText(String.valueOf(player.getReboundOverall()) + "/"
				+ String.valueOf(player.getReboundOverallField()));
		textField_26.setText(String.valueOf(player.getAssistance()) + "/"
				+ String.valueOf(player.getAssistanceField()));
		textField_30.setText(String.format("%.2f", player.getTime() / 60.0)
				+ "/" + String.format("%.2f", player.getTimeField() / 60.0));
		textField_32.setText(String.valueOf(player.getHitRate()));
		textField_36.setText(String.valueOf(player.getThreePointHitRate()));
		textField_38.setText(String.valueOf(player.getFreeThrowRate()));
		textField_42.setText(String.valueOf(player.getAttackingNum()) + "/"
				+ String.valueOf(player.getAttackingNumField()));
		textField_44.setText(String.valueOf(player.getDefensiveNum()) + "/"
				+ String.valueOf(player.getDefensiveNumField()));
		textField_47.setText(String.valueOf(player.getSteal()) + "/"
				+ String.valueOf(player.getStealField()));
		textField_49.setText(String.valueOf(player.getBlock()) + "/"
				+ String.valueOf(player.getBlockField()));
		textField_53.setText(String.valueOf(player.getTurnover()) + "/"
				+ String.valueOf(player.getTurnoverField()));
		textField_55.setText(String.valueOf(player.getFoul()) + "/"
				+ String.valueOf(player.getFoulField()));
		textField_59.setText(String.valueOf(player.getScore()) + "/"
				+ String.valueOf(player.getScoreField()));
		textField_61.setText(String.valueOf(player.getEfficiency()) + "/"
				+ String.valueOf(player.getEfficiencyField()));
		textField_65.setText(String.valueOf(player.getGmSc()) + "/"
				+ String.valueOf(player.getGmScField()));
		textField_22.setText(String.valueOf(player.getTrueHitRate()));
		textField_34.setText(String.valueOf(player.getHitEfficiency()));
		textField_31.setText(String.valueOf(player.getReboundOverallRate()));
		textField_69.setText(String.valueOf(player.getOffensiveReboundRate()));
		textField_40.setText(String.valueOf(player.getDefensiveReboundRate()));
		textField_63.setText(String.valueOf(player.getAssistanceRate()));
		textField_70.setText(String.valueOf(player.getStealRate()));
		textField_51.setText(String.valueOf(player.getBlockRate()));
		textField_57.setText(String.valueOf(player.getTurnOverRate()));
		textField_71.setText(String.valueOf(player.getUseRate()));
		ImageIcon playerIcon = new ImageIcon(new ImageIcon(
				"CSEdata/players/action/" + player.getName() + ".png")
				.getImage().getScaledInstance(X / 4, 3 * Y / 4,
						Image.SCALE_AREA_AVERAGING));
		playerAction.setIcon(playerIcon);
	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}

	public void createTeamPanel() {

		// TeamButton
		createTeamDataPanel();

		Vector<Vector<TeamButton>> teamRowData = new Vector<Vector<TeamButton>>();
		Vector<TeamButton> testColumn = new Vector<TeamButton>();

		testColumn.add(new TeamButton("ATL"));
		testColumn.add(new TeamButton("BKN"));
		testColumn.add(new TeamButton("BOS"));
		testColumn.add(new TeamButton("CHA"));
		testColumn.add(new TeamButton("CHI"));
		testColumn.add(new TeamButton("CLE"));
		testColumn.add(new TeamButton("DAL"));
		testColumn.add(new TeamButton("DEN"));
		testColumn.add(new TeamButton("DET"));
		testColumn.add(new TeamButton("GSW"));
		testColumn.add(new TeamButton("HOU"));
		testColumn.add(new TeamButton("IND"));
		testColumn.add(new TeamButton("LAC"));
		testColumn.add(new TeamButton("LAL"));
		testColumn.add(new TeamButton("MEM"));
		testColumn.add(new TeamButton("MIA"));
		testColumn.add(new TeamButton("MIL"));
		testColumn.add(new TeamButton("MIN"));
		testColumn.add(new TeamButton("NOP"));
		testColumn.add(new TeamButton("NYK"));
		testColumn.add(new TeamButton("OKC"));
		testColumn.add(new TeamButton("ORL"));
		testColumn.add(new TeamButton("PHI"));
		testColumn.add(new TeamButton("PHX"));
		testColumn.add(new TeamButton("POR"));
		testColumn.add(new TeamButton("SAC"));
		testColumn.add(new TeamButton("SAS"));
		testColumn.add(new TeamButton("TOR"));
		testColumn.add(new TeamButton("UTA"));
		testColumn.add(new TeamButton("WAS"));

		teamRowData.add(testColumn);

		DefaultTableModel teamDTM = new DefaultTableModel(teamRowData,
				testColumn) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable teamTable = new JTable(teamDTM);
		teamTable.setOpaque(false);
		teamTable.setRowHeight(Y / 7);
		teamTable.getTableHeader().setVisible(false);
		DefaultTableCellRenderer teamTableHeaderRenderer = new DefaultTableCellRenderer();
		teamTableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		teamTable.getTableHeader().setDefaultRenderer(teamTableHeaderRenderer);
		teamTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 0; i < testColumn.size(); i++) {
			teamTable.getColumnModel().getColumn(i)
					.setCellRenderer(new TeamTableRenderer());
			teamTable.getColumnModel().getColumn(i).setPreferredWidth(100);
		}

		JScrollPane teamJSP = new JScrollPane(teamTable);
		teamJSP.getViewport().setOpaque(false);
		teamJSP.setOpaque(false);
		teamJSP.getHorizontalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		teamJSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		teamJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		teamJSP.setBounds(X / 5, Y / 10, 5 * X / 8, Y / 6);
		teamJSP.setVisible(true);
		bgLabel.add(teamJSP);

		TeamVo defaultTeam = team_BS.getTeamByAbbr(String.valueOf(teamRowData
				.get(0).get(0).teamName));
		textField_74.setText(defaultTeam.getTeamName());
		textField_79.setText(defaultTeam.getAbbreviation());
		textField_76.setText(defaultTeam.getCity());
		textField_80.setText(String.valueOf(defaultTeam.getConference()));
		textField_82.setText(String.valueOf(defaultTeam.getDivision()));
		textField_84.setText(String.valueOf(defaultTeam.getHomeField()));
		textField_86.setText(defaultTeam.getBirthYear());
		textField_88.setText(String.valueOf(defaultTeam.getGameNum()));
		textField_90.setText(String.valueOf(defaultTeam.getHitNum()) + "/"
				+ String.valueOf(defaultTeam.getHitNumField()));
		textField_93.setText(String.valueOf(defaultTeam.getShotNum()) + "/"
				+ String.valueOf(defaultTeam.getShotNumField()));
		textField_94.setText(String.valueOf(defaultTeam.getThreePointHitNum())
				+ "/" + String.valueOf(defaultTeam.getThreePointHitNumField()));
		textField_96
				.setText(String.valueOf(defaultTeam.getThreePointShotNum())
						+ "/"
						+ String.valueOf(defaultTeam
								.getThreePointShotNumField()));
		textField_98.setText(String.valueOf(defaultTeam.getFreeThrowHitNum())
				+ "/" + String.valueOf(defaultTeam.getFreeThrowHitNumField()));
		textField_100.setText(String.valueOf(defaultTeam.getFreeThrowShotNum())
				+ "/" + String.valueOf(defaultTeam.getFreeThrowShotNumField()));
		textField_102.setText(String.valueOf(defaultTeam.getOffensiveRebound())
				+ "/" + String.valueOf(defaultTeam.getOffensiveReboundField()));
		textField_104.setText(String.valueOf(defaultTeam.getDefensiveRebound())
				+ "/" + String.valueOf(defaultTeam.getDefensiveReboundField()));
		textField_106.setText(String.valueOf(defaultTeam.getReboundOverall())
				+ "/" + String.valueOf(defaultTeam.getReboundOverall()));
		textField_108.setText(String.valueOf(defaultTeam.getAssistance()) + "/"
				+ String.valueOf(defaultTeam.getAssistanceField()));
		textField_110.setText(String.valueOf(defaultTeam.getSteal()) + "/"
				+ String.valueOf(defaultTeam.getStealField()));
		textField_112.setText(String.valueOf(defaultTeam.getBlock()) + "/"
				+ String.valueOf(defaultTeam.getBlockField()));
		textField_114.setText(String.valueOf(defaultTeam.getTurnover()) + "/"
				+ String.valueOf(defaultTeam.getTurnoverField()));
		textField_116.setText(String.valueOf(defaultTeam.getFoul()) + "/"
				+ String.valueOf(defaultTeam.getFoulField()));
		textField_118.setText(String.valueOf(defaultTeam.getScore()) + "/"
				+ String.valueOf(defaultTeam.getScoreField()));
		textField_120.setText(String.valueOf(defaultTeam.getHitRate()));
		textField_122
				.setText(String.valueOf(defaultTeam.getThreePointHitRate()));
		textField_124.setText(String.valueOf(defaultTeam.getFreeThrowRate()));
		textField_126.setText(String.valueOf(defaultTeam.getWinningRate()));
		textField_128.setText(String.valueOf(defaultTeam.getRoundAttack()));
		textField_130.setText(String.valueOf(defaultTeam
				.getAttackingEfficiency()));
		textField_132.setText(String.valueOf(defaultTeam
				.getDefensiveEfficiency()));
		textField_134
				.setText(String.valueOf(defaultTeam.getReboundEfficiency()));
		textField_136.setText(String.valueOf(defaultTeam.getStealEfficiency()));
		textField_138.setText(String.valueOf(defaultTeam
				.getAssistanceEfficiency()));

	}

	public void createPlayerPanel() {
		createPlayerDataPanel();

		PlayerVo defaultPlayer = player_BS.getPlayerByName(team_BS
				.getPlayers("ATL").get(0).getName());
		textField_4.setText(String.valueOf(defaultPlayer.getName()));

		textField_9.setText(String.valueOf(defaultPlayer.getHeight()));
		textField_13.setText(String.valueOf(defaultPlayer.getBirth()));
		textField_5.setText(String.valueOf(defaultPlayer.getPosition()));
		textField_10.setText(String.valueOf(defaultPlayer.getWeight()));
		textField_73.setText(String.valueOf(defaultPlayer.getExp()));
		textField_72.setText(String.valueOf(defaultPlayer.getNumber()));
		textField_14.setText(String.valueOf(defaultPlayer.getAge()));
		textField_16.setText(String.valueOf(defaultPlayer.getSchool()));
		textField_18.setText(String.valueOf(defaultPlayer.getGameNum()));
		textField_20.setText(String.valueOf(defaultPlayer.getFirstOnNum()));
		textField_24.setText(String.valueOf(defaultPlayer.getReboundOverall())
				+ "/" + String.valueOf(defaultPlayer.getReboundOverallField()));
		textField_26.setText(String.valueOf(defaultPlayer.getAssistance())
				+ "/" + String.valueOf(defaultPlayer.getAssistanceField()));
		textField_30.setText(String.format("%.2f",
				defaultPlayer.getTime() / 60.0)
				+ "/"
				+ String.format("%.2f", defaultPlayer.getTimeField() / 60.0));
		textField_32.setText(String.valueOf(defaultPlayer.getHitRate()));
		textField_36.setText(String.valueOf(defaultPlayer
				.getThreePointHitRate()));
		textField_38.setText(String.valueOf(defaultPlayer.getFreeThrowRate()));
		textField_42.setText(String.valueOf(defaultPlayer.getAttackingNum())
				+ "/" + String.valueOf(defaultPlayer.getAttackingNumField()));
		textField_44.setText(String.valueOf(defaultPlayer.getDefensiveNum())
				+ "/" + String.valueOf(defaultPlayer.getDefensiveNumField()));
		textField_47.setText(String.valueOf(defaultPlayer.getSteal()) + "/"
				+ String.valueOf(defaultPlayer.getStealField()));
		textField_49.setText(String.valueOf(defaultPlayer.getBlock()) + "/"
				+ String.valueOf(defaultPlayer.getStealField()));
		textField_53.setText(String.valueOf(defaultPlayer.getTurnover()) + "/"
				+ String.valueOf(defaultPlayer.getTurnoverField()));
		textField_55.setText(String.valueOf(defaultPlayer.getFoul()) + "/"
				+ String.valueOf(defaultPlayer.getFoulField()));
		textField_59.setText(String.valueOf(defaultPlayer.getScore()) + "/"
				+ String.valueOf(defaultPlayer.getScoreField()));
		textField_61.setText(String.valueOf(defaultPlayer.getEfficiency())
				+ "/" + String.valueOf(defaultPlayer.getEfficiencyField()));
		textField_65.setText(String.valueOf(defaultPlayer.getGmSc()) + "/"
				+ String.valueOf(defaultPlayer.getGmScField()));
		textField_22.setText(String.valueOf(defaultPlayer.getTrueHitRate()));
		textField_34.setText(String.valueOf(defaultPlayer.getHitEfficiency()));
		textField_31.setText(String.valueOf(defaultPlayer
				.getReboundOverallRate()));
		textField_69.setText(String.valueOf(defaultPlayer
				.getOffensiveReboundRate()));
		textField_40.setText(String.valueOf(defaultPlayer
				.getDefensiveReboundRate()));
		textField_63.setText(String.valueOf(defaultPlayer.getAssistanceRate()));
		textField_70.setText(String.valueOf(defaultPlayer.getStealRate()));
		textField_51.setText(String.valueOf(defaultPlayer.getBlockRate()));
		textField_57.setText(String.valueOf(defaultPlayer.getTurnOverRate()));
		textField_71.setText(String.valueOf(defaultPlayer.getUseRate()));
		// TeamButton
		Vector<Vector<TeamButton>> teamRowData = new Vector<Vector<TeamButton>>();
		Vector<TeamButton> testDATA = new Vector<TeamButton>();
		TeamButton teamATL = new TeamButton("ATL");
		testDATA.add(teamATL);
		TeamButton teamBKN = new TeamButton("BKN");
		testDATA.add(teamBKN);
		TeamButton teamBOS = new TeamButton("BOS");
		testDATA.add(teamBOS);
		TeamButton teamCHA = new TeamButton("CHA");
		testDATA.add(teamCHA);
		TeamButton teamCHI = new TeamButton("CHI");
		testDATA.add(teamCHI);
		TeamButton teamCLE = new TeamButton("CLE");
		testDATA.add(teamCLE);
		TeamButton teamDAL = new TeamButton("DAL");
		testDATA.add(teamDAL);
		TeamButton teamDEN = new TeamButton("DEN");
		testDATA.add(teamDEN);
		TeamButton teamDET = new TeamButton("DET");
		testDATA.add(teamDET);
		TeamButton teamGSW = new TeamButton("GSW");
		testDATA.add(teamGSW);
		TeamButton teamHOU = new TeamButton("HOU");
		testDATA.add(teamHOU);
		TeamButton teamIND = new TeamButton("IND");
		testDATA.add(teamIND);
		TeamButton teamLAC = new TeamButton("LAC");
		testDATA.add(teamLAC);
		TeamButton teamLAL = new TeamButton("LAL");
		testDATA.add(teamLAL);
		TeamButton teamMEM = new TeamButton("MEM");
		testDATA.add(teamMEM);
		TeamButton teamMIA = new TeamButton("MIA");
		testDATA.add(teamMIA);
		TeamButton teamMIL = new TeamButton("MIL");
		testDATA.add(teamMIL);
		TeamButton teamMIN = new TeamButton("MIN");
		testDATA.add(teamMIN);
		TeamButton teamNOP = new TeamButton("NOP");
		testDATA.add(teamNOP);
		TeamButton teamNYK = new TeamButton("NYK");
		testDATA.add(teamNYK);
		TeamButton teamOKC = new TeamButton("OKC");
		testDATA.add(teamOKC);
		TeamButton teamORL = new TeamButton("ORL");
		testDATA.add(teamORL);
		TeamButton teamPHI = new TeamButton("PHI");
		testDATA.add(teamPHI);
		TeamButton teamPHX = new TeamButton("PHX");
		testDATA.add(teamPHX);
		TeamButton teamPOR = new TeamButton("POR");
		testDATA.add(teamPOR);
		TeamButton teamSAC = new TeamButton("SAC");
		testDATA.add(teamSAC);
		TeamButton teamSAS = new TeamButton("SAS");
		testDATA.add(teamSAS);
		TeamButton teamTOR = new TeamButton("TOR");
		testDATA.add(teamTOR);
		TeamButton teamUTA = new TeamButton("UTA");
		testDATA.add(teamUTA);
		TeamButton teamWAS = new TeamButton("WAS");
		testDATA.add(teamWAS);
		teamRowData.add(testDATA);
		teamColumn = new Vector<String>(testDATA.size());
		for (int i = 0; i < testDATA.size(); i++) {
			teamColumn.add("");
		}

		DefaultTableModel teamDTM = new DefaultTableModel(teamRowData,
				teamColumn) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable teamTable = new JTable(teamDTM);
		teamTable.setOpaque(false);
		teamTable.setRowHeight(Y / 7);
		teamTable.getTableHeader().setVisible(false);
		DefaultTableCellRenderer teamTableHeaderRenderer = new DefaultTableCellRenderer();
		teamTableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		teamTable.getTableHeader().setDefaultRenderer(teamTableHeaderRenderer);
		teamTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 0; i < testDATA.size(); i++) {
			teamTable.getColumnModel().getColumn(i)
					.setCellRenderer(new TeamTableRenderer());
			teamTable.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		JScrollPane teamJSP = new JScrollPane(teamTable);
		teamJSP.getViewport().setOpaque(false);
		teamJSP.setOpaque(false);
		teamJSP.getHorizontalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		teamJSP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		teamJSP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		teamJSP.setBounds(X / 6, Y / 20, 5 * X / 8, Y / 6);
		teamJSP.setVisible(true);
		teamJSP.getViewport().setOpaque(false);
		teamJSP.setOpaque(false);
		bgLabel.add(teamJSP);

		// playerButton
		playerRowData = new Vector<Vector<PlayerButton>>();
		playerColumn = new Vector<String>();
		playerColumn.add("");

		playerDTM = new DefaultTableModel(playerRowData, playerColumn) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		playerTable = new JTable(playerDTM);
		playerTable.setOpaque(false);
		playerTable.setRowHeight(X / 10);
		playerTable.setCellSelectionEnabled(true);
		playerTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerTableRenderer());
		playerTable.getTableHeader().setVisible(false);
		DefaultTableCellRenderer playerTableHeaderRenderer = new DefaultTableCellRenderer();
		playerTableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		playerTable.getTableHeader().setDefaultRenderer(
				playerTableHeaderRenderer);
		playerTable.getColumnModel().getColumn(0).setPreferredWidth(X / 10);
		JScrollPane playerJSP = new JScrollPane(playerTable);
		playerJSP.getViewport().setOpaque(false);
		playerJSP.setOpaque(false);
		playerJSP.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		playerJSP
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		playerJSP
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		playerJSP.setBounds(X / 18, Y / 4, X / 10, 7 * Y / 10);
		playerJSP.setVisible(true);
		bgLabel.add(playerJSP);

	}

	public void createTeamDataPanel() {
		int tempX = X * 190 / 1366;
		int tempY = 3 * Y / 10;
		int spaceX = X / 8;
		int spaceY = Y / 17;
		textField_67 = new MyTextField();
		textField_67.setHorizontalAlignment(SwingConstants.CENTER);
		textField_67.setText("球队全名");
		textField_67.setEditable(false);

		textField_67.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_67);
		textField_67.setColumns(10);

		textField_74 = new MyTextField();
		textField_74.setHorizontalAlignment(SwingConstants.CENTER);
		textField_74.setEditable(false);

		textField_74.setColumns(10);
		textField_74.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_74);

		textField_75 = new MyTextField();
		textField_75.setHorizontalAlignment(SwingConstants.CENTER);
		textField_75.setText("缩写");
		textField_75.setEditable(false);

		textField_75.setColumns(10);
		textField_75.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_75);

		textField_79 = new MyTextField();
		textField_79.setHorizontalAlignment(SwingConstants.CENTER);
		textField_79.setEditable(false);

		textField_79.setColumns(10);
		textField_79.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_79);

		textField_78 = new MyTextField();
		textField_78.setHorizontalAlignment(SwingConstants.CENTER);
		textField_78.setText("所在地");
		textField_78.setEditable(false);
		textField_78.setOpaque(false);
		textField_78.setColumns(10);
		textField_78.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_78);

		textField_76 = new MyTextField();
		textField_76.setHorizontalAlignment(SwingConstants.CENTER);
		textField_76.setEditable(false);

		textField_76.setColumns(10);
		textField_76.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_76);

		textField_77 = new MyTextField();
		textField_77.setHorizontalAlignment(SwingConstants.CENTER);
		textField_77.setText("赛区");
		textField_77.setEditable(false);
		textField_77.setColumns(10);
		textField_77.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_77);

		textField_80 = new MyTextField();
		textField_80.setHorizontalAlignment(SwingConstants.CENTER);
		textField_80.setEditable(false);
		textField_80.setColumns(10);
		textField_80.setBounds(tempX + spaceX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_80);

		textField_81 = new MyTextField();
		textField_81.setText("分区");
		textField_81.setHorizontalAlignment(SwingConstants.CENTER);
		textField_81.setEditable(false);
		textField_81.setColumns(10);
		textField_81.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_81);

		textField_82 = new MyTextField();
		textField_82.setHorizontalAlignment(SwingConstants.CENTER);
		textField_82.setEditable(false);
		textField_82.setColumns(10);
		textField_82.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_82);

		textField_83 = new MyTextField();
		textField_83.setText("主场");
		textField_83.setHorizontalAlignment(SwingConstants.CENTER);
		textField_83.setEditable(false);
		textField_83.setColumns(10);
		textField_83.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_83);

		textField_84 = new MyTextField();
		textField_84.setHorizontalAlignment(SwingConstants.CENTER);
		textField_84.setEditable(false);
		textField_84.setColumns(10);
		textField_84.setFont(new Font("黑体", 1, 11));
		textField_84.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_84);

		textField_85 = new MyTextField();
		textField_85.setText("建立时间");
		textField_85.setHorizontalAlignment(SwingConstants.CENTER);
		textField_85.setEditable(false);
		textField_85.setColumns(10);
		textField_85.setBounds(tempX, tempY + 2 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_85);

		textField_86 = new MyTextField();
		textField_86.setHorizontalAlignment(SwingConstants.CENTER);
		textField_86.setEditable(false);
		textField_86.setColumns(10);
		textField_86.setBounds(tempX + spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_86);

		textField_87 = new MyTextField();
		textField_87.setText("比赛场数");
		textField_87.setHorizontalAlignment(SwingConstants.CENTER);
		textField_87.setEditable(false);
		textField_87.setColumns(10);
		textField_87.setBounds(tempX + 2 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_87);

		textField_88 = new MyTextField();
		textField_88.setHorizontalAlignment(SwingConstants.CENTER);
		textField_88.setEditable(false);
		textField_88.setColumns(10);
		textField_88.setBounds(tempX + 3 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_88);

		textField_89 = new MyTextField();
		textField_89.setText("投篮命中数/场均");
		textField_89.setHorizontalAlignment(SwingConstants.CENTER);
		textField_89.setEditable(false);
		textField_89.setColumns(10);
		textField_89.setBounds(tempX + 4 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_89);

		textField_90 = new MyTextField();
		textField_90.setHorizontalAlignment(SwingConstants.CENTER);
		textField_90.setEditable(false);
		textField_90.setColumns(10);
		textField_90.setBounds(tempX + 5 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_90);

		textField_91 = new MyTextField();
		textField_91.setText("投篮出手数/场均");
		textField_91.setHorizontalAlignment(SwingConstants.CENTER);
		textField_91.setEditable(false);
		textField_91.setColumns(10);
		textField_91.setBounds(tempX, tempY + 3 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_91);

		textField_93 = new MyTextField();
		textField_93.setHorizontalAlignment(SwingConstants.CENTER);
		textField_93.setEditable(false);
		textField_93.setColumns(10);
		textField_93.setBounds(tempX + spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_93);

		textField_92 = new MyTextField();
		textField_92.setText("三分命中数/场均");
		textField_92.setHorizontalAlignment(SwingConstants.CENTER);
		textField_92.setEditable(false);
		textField_92.setColumns(10);
		textField_92.setBounds(tempX + 2 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_92);

		textField_94 = new MyTextField();
		textField_94.setHorizontalAlignment(SwingConstants.CENTER);
		textField_94.setEditable(false);
		textField_94.setColumns(10);
		textField_94.setBounds(tempX + 3 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_94);

		textField_95 = new MyTextField();
		textField_95.setText("三分出手数/场均");
		textField_95.setHorizontalAlignment(SwingConstants.CENTER);
		textField_95.setEditable(false);
		textField_95.setColumns(10);
		textField_95.setBounds(tempX + 4 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_95);

		textField_96 = new MyTextField();
		textField_96.setHorizontalAlignment(SwingConstants.CENTER);
		textField_96.setEditable(false);
		textField_96.setColumns(10);
		textField_96.setBounds(tempX + 5 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_96);

		textField_97 = new MyTextField();
		textField_97.setText("罚球命中数/场均");
		textField_97.setHorizontalAlignment(SwingConstants.CENTER);
		textField_97.setEditable(false);
		textField_97.setColumns(10);
		textField_97.setBounds(tempX, tempY + 4 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_97);

		textField_98 = new MyTextField();
		textField_98.setHorizontalAlignment(SwingConstants.CENTER);
		textField_98.setEditable(false);
		textField_98.setColumns(10);
		textField_98.setBounds(tempX + spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_98);

		textField_99 = new MyTextField();
		textField_99.setText("罚球出手数/场均");
		textField_99.setHorizontalAlignment(SwingConstants.CENTER);
		textField_99.setEditable(false);
		textField_99.setColumns(10);
		textField_99.setBounds(tempX + 2 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_99);

		textField_100 = new MyTextField();
		textField_100.setHorizontalAlignment(SwingConstants.CENTER);
		textField_100.setEditable(false);
		textField_100.setColumns(10);
		textField_100.setBounds(tempX + 3 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_100);

		textField_101 = new MyTextField();
		textField_101.setText("进攻篮板数/场均");
		textField_101.setHorizontalAlignment(SwingConstants.CENTER);
		textField_101.setEditable(false);
		textField_101.setColumns(10);
		textField_101.setBounds(tempX + 4 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_101);

		textField_102 = new MyTextField();
		textField_102.setHorizontalAlignment(SwingConstants.CENTER);
		textField_102.setEditable(false);
		textField_102.setColumns(10);
		textField_102.setBounds(tempX + 5 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_102);

		textField_103 = new MyTextField();
		textField_103.setText("防守篮板数/场均");
		textField_103.setHorizontalAlignment(SwingConstants.CENTER);
		textField_103.setEditable(false);
		textField_103.setColumns(10);
		textField_103.setBounds(tempX, tempY + 5 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_103);

		textField_104 = new MyTextField();
		textField_104.setHorizontalAlignment(SwingConstants.CENTER);
		textField_104.setEditable(false);
		textField_104.setColumns(10);
		textField_104.setBounds(tempX + spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_104);

		textField_105 = new MyTextField();
		textField_105.setText("篮板数/场均");
		textField_105.setHorizontalAlignment(SwingConstants.CENTER);
		textField_105.setEditable(false);
		textField_105.setColumns(10);
		textField_105.setBounds(tempX + 2 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_105);

		textField_106 = new MyTextField();
		textField_106.setHorizontalAlignment(SwingConstants.CENTER);
		textField_106.setEditable(false);
		textField_106.setColumns(10);
		textField_106.setBounds(tempX + 3 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_106);

		textField_107 = new MyTextField();
		textField_107.setText("助攻数/场均");
		textField_107.setHorizontalAlignment(SwingConstants.CENTER);
		textField_107.setEditable(false);
		textField_107.setColumns(10);
		textField_107.setBounds(tempX + 4 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_107);

		textField_108 = new MyTextField();
		textField_108.setHorizontalAlignment(SwingConstants.CENTER);
		textField_108.setEditable(false);
		textField_108.setColumns(10);
		textField_108.setBounds(tempX + 5 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_108);

		textField_109 = new MyTextField();
		textField_109.setText("抢断数/场均");
		textField_109.setHorizontalAlignment(SwingConstants.CENTER);
		textField_109.setEditable(false);
		textField_109.setColumns(10);
		textField_109.setBounds(tempX, tempY + 6 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_109);

		textField_110 = new MyTextField();
		textField_110.setHorizontalAlignment(SwingConstants.CENTER);
		textField_110.setEditable(false);
		textField_110.setColumns(10);
		textField_110.setBounds(tempX + spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_110);

		textField_111 = new MyTextField();
		textField_111.setText("盖帽数/场均");
		textField_111.setHorizontalAlignment(SwingConstants.CENTER);
		textField_111.setEditable(false);
		textField_111.setColumns(10);
		textField_111.setBounds(tempX + 2 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_111);

		textField_112 = new MyTextField();
		textField_112.setHorizontalAlignment(SwingConstants.CENTER);
		textField_112.setEditable(false);
		textField_112.setColumns(10);
		textField_112.setBounds(tempX + 3 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_112);

		textField_113 = new MyTextField();
		textField_113.setText("失误数/场均");
		textField_113.setHorizontalAlignment(SwingConstants.CENTER);
		textField_113.setEditable(false);
		textField_113.setColumns(10);
		textField_113.setBounds(tempX + 4 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_113);

		textField_114 = new MyTextField();
		textField_114.setHorizontalAlignment(SwingConstants.CENTER);
		textField_114.setEditable(false);
		textField_114.setColumns(10);
		textField_114.setBounds(tempX + 5 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_114);

		textField_115 = new MyTextField();
		textField_115.setText("犯规数/场均");
		textField_115.setHorizontalAlignment(SwingConstants.CENTER);
		textField_115.setEditable(false);
		textField_115.setColumns(10);
		textField_115.setBounds(tempX, tempY + 7 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_115);

		textField_116 = new MyTextField();
		textField_116.setHorizontalAlignment(SwingConstants.CENTER);
		textField_116.setEditable(false);
		textField_116.setColumns(10);
		textField_116.setBounds(tempX + spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_116);

		textField_117 = new MyTextField();
		textField_117.setText("比赛得分/场均");
		textField_117.setHorizontalAlignment(SwingConstants.CENTER);
		textField_117.setEditable(false);
		textField_117.setColumns(10);
		textField_117.setBounds(tempX + 2 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_117);

		textField_118 = new MyTextField();
		textField_118.setHorizontalAlignment(SwingConstants.CENTER);
		textField_118.setEditable(false);
		textField_118.setColumns(10);
		textField_118.setBounds(tempX + 3 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_118);

		textField_119 = new MyTextField();
		textField_119.setText("投篮命中率");
		textField_119.setHorizontalAlignment(SwingConstants.CENTER);
		textField_119.setEditable(false);
		textField_119.setColumns(10);
		textField_119.setBounds(tempX + 4 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_119);

		textField_120 = new MyTextField();
		textField_120.setHorizontalAlignment(SwingConstants.CENTER);
		textField_120.setEditable(false);
		textField_120.setColumns(10);
		textField_120.setBounds(tempX + 5 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_120);

		textField_121 = new MyTextField();
		textField_121.setText("三分命中率");
		textField_121.setHorizontalAlignment(SwingConstants.CENTER);
		textField_121.setEditable(false);
		textField_121.setColumns(10);
		textField_121.setBounds(tempX, tempY + 8 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_121);

		textField_122 = new MyTextField();
		textField_122.setHorizontalAlignment(SwingConstants.CENTER);
		textField_122.setEditable(false);
		textField_122.setColumns(10);
		textField_122.setBounds(tempX + spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_122);

		textField_123 = new MyTextField();
		textField_123.setText("罚球命中率");
		textField_123.setHorizontalAlignment(SwingConstants.CENTER);
		textField_123.setEditable(false);
		textField_123.setColumns(10);
		textField_123.setBounds(tempX + 2 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_123);

		textField_124 = new MyTextField();
		textField_124.setHorizontalAlignment(SwingConstants.CENTER);
		textField_124.setEditable(false);
		textField_124.setColumns(10);
		textField_124.setBounds(tempX + 3 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_124);

		textField_125 = new MyTextField();
		textField_125.setText("胜率");
		textField_125.setHorizontalAlignment(SwingConstants.CENTER);
		textField_125.setEditable(false);
		textField_125.setColumns(10);
		textField_125.setBounds(tempX + 4 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_125);

		textField_126 = new MyTextField();
		textField_126.setHorizontalAlignment(SwingConstants.CENTER);
		textField_126.setEditable(false);
		textField_126.setColumns(10);
		textField_126.setBounds(tempX + 5 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_126);

		textField_127 = new MyTextField();
		textField_127.setText("进攻回合");
		textField_127.setHorizontalAlignment(SwingConstants.CENTER);
		textField_127.setEditable(false);
		textField_127.setColumns(10);
		textField_127.setBounds(tempX, tempY + 9 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_127);

		textField_128 = new MyTextField();
		textField_128.setHorizontalAlignment(SwingConstants.CENTER);
		textField_128.setEditable(false);
		textField_128.setColumns(10);
		textField_128.setBounds(tempX + spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_128);

		textField_129 = new MyTextField();
		textField_129.setText("进攻效率");
		textField_129.setHorizontalAlignment(SwingConstants.CENTER);
		textField_129.setEditable(false);
		textField_129.setColumns(10);
		textField_129.setBounds(tempX + 2 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_129);

		textField_130 = new MyTextField();
		textField_130.setHorizontalAlignment(SwingConstants.CENTER);
		textField_130.setEditable(false);
		textField_130.setColumns(10);
		textField_130.setBounds(tempX + 3 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_130);

		textField_131 = new MyTextField();
		textField_131.setText("防守效率");
		textField_131.setHorizontalAlignment(SwingConstants.CENTER);
		textField_131.setEditable(false);
		textField_131.setColumns(10);
		textField_131.setBounds(tempX + 4 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_131);

		textField_132 = new MyTextField();
		textField_132.setHorizontalAlignment(SwingConstants.CENTER);
		textField_132.setEditable(false);
		textField_132.setColumns(10);
		textField_132.setBounds(tempX + 5 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_132);

		textField_133 = new MyTextField();
		textField_133.setText("篮板效率");
		textField_133.setHorizontalAlignment(SwingConstants.CENTER);
		textField_133.setEditable(false);
		textField_133.setColumns(10);
		textField_133.setBounds(tempX, tempY + 10 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_133);

		textField_134 = new MyTextField();
		textField_134.setHorizontalAlignment(SwingConstants.CENTER);
		textField_134.setEditable(false);
		textField_134.setColumns(10);
		textField_134.setBounds(tempX + spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_134);

		textField_135 = new MyTextField();
		textField_135.setText("抢断效率");
		textField_135.setHorizontalAlignment(SwingConstants.CENTER);
		textField_135.setEditable(false);
		textField_135.setColumns(10);
		textField_135.setBounds(tempX + 2 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_135);

		textField_136 = new MyTextField();
		textField_136.setHorizontalAlignment(SwingConstants.CENTER);
		textField_136.setEditable(false);
		textField_136.setColumns(10);
		textField_136.setBounds(tempX + 3 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_136);

		textField_137 = new MyTextField();
		textField_137.setText("助攻率");
		textField_137.setHorizontalAlignment(SwingConstants.CENTER);
		textField_137.setEditable(false);
		textField_137.setColumns(10);
		textField_137.setBounds(tempX + 4 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_137);

		textField_138 = new MyTextField();
		textField_138.setHorizontalAlignment(SwingConstants.CENTER);
		textField_138.setEditable(false);
		textField_138.setColumns(10);
		textField_138.setBounds(tempX + 5 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_138);

	}

	public void createPlayerDataPanel() {
		int tempX = 2 * X / 11;
		int tempY = 27 * Y / 100;
		int spaceX = X / 10;
		int spaceY = Y / 18;

		playerAction = new JLabel();
		playerAction.setBounds(3 * X / 4, Y / 5, X / 4, 3 * Y / 4);
		bgLabel.add(playerAction);

		textField_1 = new MyTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("姓名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_1);
		textField_1.setColumns(10);

		textField_4 = new MyTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		textField_4.setFont(new Font("黑体", 1, 14));
		bgLabel.add(textField_4);
		textField_4.setColumns(10);

		textField_7 = new MyTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("身高");
		textField_7.setEditable(false);
		textField_7.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_7);
		textField_7.setColumns(10);

		textField_9 = new MyTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_9);
		textField_9.setColumns(10);

		textField_11 = new MyTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("生日");
		textField_11.setEditable(false);
		textField_11.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_11);
		textField_11.setColumns(10);

		textField_13 = new MyTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_13);
		textField_13.setColumns(10);

		textField_2 = new MyTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("位置");
		textField_2.setEditable(false);
		textField_2.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_2);
		textField_2.setColumns(10);

		textField_5 = new MyTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setBounds(tempX + spaceX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_5);
		textField_5.setColumns(10);

		textField_8 = new MyTextField();
		textField_8.setText("体重");
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_8);
		textField_8.setColumns(10);

		textField_10 = new MyTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_10);
		textField_10.setColumns(10);

		textField_12 = new MyTextField();
		textField_12.setText("球龄");
		textField_12.setEditable(false);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_12);
		textField_12.setColumns(10);

		textField_73 = new MyTextField();
		textField_73.setHorizontalAlignment(SwingConstants.CENTER);
		textField_73.setEditable(false);
		textField_73.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_73);
		textField_73.setColumns(10);

		textField_3 = new MyTextField();
		textField_3.setEditable(false);
		textField_3.setText("球衣号码");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(tempX, tempY + 2 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_3);
		textField_3.setColumns(10);

		textField_72 = new MyTextField();
		textField_72.setHorizontalAlignment(SwingConstants.CENTER);
		textField_72.setEditable(false);
		textField_72.setBounds(tempX + spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_72);
		textField_72.setColumns(10);

		textField_6 = new MyTextField();
		textField_6.setText("年龄");
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setBounds(tempX + 2 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_6);
		textField_6.setColumns(10);

		textField_14 = new MyTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setBounds(tempX + 3 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_14);
		textField_14.setColumns(10);

		textField_15 = new MyTextField();
		textField_15.setText("毕业院校");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setBounds(tempX + 4 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_15);
		textField_15.setColumns(10);

		textField_16 = new MyTextField();
		textField_16.setEditable(false);
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setFont(new Font("黑体", 0, 11));
		textField_16.setBounds(tempX + 5 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_16);
		textField_16.setColumns(10);

		textField_17 = new MyTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setEditable(false);
		textField_17.setText("参赛场数");
		textField_17.setBounds(tempX, tempY + 3 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_17);
		textField_17.setColumns(10);

		textField_18 = new MyTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setEditable(false);
		textField_18.setBounds(tempX + spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_18);
		textField_18.setColumns(10);

		textField_19 = new MyTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setText("先发场数");
		textField_19.setEditable(false);
		textField_19.setBounds(tempX + 2 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new MyTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEditable(false);
		textField_20.setBounds(tempX + 3 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_20);
		textField_20.setColumns(10);

		// textField_68 = new MyTextField();
		// textField_68.setBounds(445, 179, 132, 190);
		// bgLabel.add(textField_68);
		// textField_68.setColumns(10);

		textField_21 = new MyTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setText("篮板数/场均");
		textField_21.setEditable(false);
		textField_21.setBounds(tempX + 4 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_21);
		textField_21.setColumns(10);

		textField_24 = new MyTextField();
		textField_24.setEditable(false);
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setBounds(tempX + 5 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_24);
		textField_24.setColumns(10);

		textField_23 = new MyTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setText("助攻数/场均");
		textField_23.setEditable(false);
		textField_23.setBounds(tempX, tempY + 4 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_23);
		textField_23.setColumns(10);

		textField_26 = new MyTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setEditable(false);
		textField_26.setBounds(tempX + spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_26);
		textField_26.setColumns(10);

		textField_25 = new MyTextField();
		textField_25.setText("在场时间/场均");
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setEditable(false);
		textField_25.setBounds(tempX + 2 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_25);
		textField_25.setColumns(10);

		textField_30 = new MyTextField();
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setEditable(false);
		textField_30.setBounds(tempX + 3 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_30);
		textField_30.setColumns(10);

		textField_27 = new MyTextField();
		textField_27.setText("投篮命中率");
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setEditable(false);
		textField_27.setBounds(tempX + 4 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_27);
		textField_27.setColumns(10);

		textField_32 = new MyTextField();
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setEditable(false);
		textField_32.setBounds(tempX + 5 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_32);
		textField_32.setColumns(10);

		textField_28 = new MyTextField();
		textField_28.setText("三分命中率");
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setEditable(false);
		textField_28.setBounds(tempX, tempY + 5 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_28);
		textField_28.setColumns(10);

		textField_36 = new MyTextField();
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setEditable(false);
		textField_36.setBounds(tempX + spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_36);
		textField_36.setColumns(10);

		textField_29 = new MyTextField();
		textField_29.setText("罚球命中率");
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setEditable(false);
		textField_29.setBounds(tempX + 2 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_29);
		textField_29.setColumns(10);

		textField_38 = new MyTextField();
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setEditable(false);
		textField_38.setBounds(tempX + 3 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_38);
		textField_38.setColumns(10);

		textField_33 = new MyTextField();
		textField_33.setText("进攻数/场均");
		textField_33.setEditable(false);
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setBounds(tempX + 4 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_33);
		textField_33.setColumns(10);

		textField_42 = new MyTextField();
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setEditable(false);
		textField_42.setBounds(tempX + 5 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_42);
		textField_42.setColumns(10);

		textField_35 = new MyTextField();
		textField_35.setText("防守数/场均");
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setEditable(false);
		textField_35.setBounds(tempX, tempY + 6 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_35);
		textField_35.setColumns(10);

		textField_44 = new MyTextField();
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setEditable(false);
		textField_44.setBounds(tempX + spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_44);
		textField_44.setColumns(10);

		textField_37 = new MyTextField();
		textField_37.setText("抢断数/场均");
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setEditable(false);
		textField_37.setBounds(tempX + 2 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_37);
		textField_37.setColumns(10);

		textField_47 = new MyTextField();
		textField_47.setEditable(false);
		textField_47.setHorizontalAlignment(SwingConstants.CENTER);
		textField_47.setBounds(tempX + 3 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_47);
		textField_47.setColumns(10);

		textField_39 = new MyTextField();
		textField_39.setText("盖帽数/场均");
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setEditable(false);
		textField_39.setBounds(tempX + 4 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_39);
		textField_39.setColumns(10);

		textField_49 = new MyTextField();
		textField_49.setHorizontalAlignment(SwingConstants.CENTER);
		textField_49.setEditable(false);
		textField_49.setBounds(tempX + 5 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_49);
		textField_49.setColumns(10);

		textField_41 = new MyTextField();
		textField_41.setText("失误数/场均");
		textField_41.setEditable(false);
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setBounds(tempX, tempY + 7 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_41);
		textField_41.setColumns(10);

		textField_53 = new MyTextField();
		textField_53.setEditable(false);
		textField_53.setHorizontalAlignment(SwingConstants.CENTER);
		textField_53.setBounds(tempX + spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_53);
		textField_53.setColumns(10);

		textField_43 = new MyTextField();
		textField_43.setText("犯规数/场均");
		textField_43.setEditable(false);
		textField_43.setHorizontalAlignment(SwingConstants.CENTER);
		textField_43.setBounds(tempX + 2 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_43);
		textField_43.setColumns(10);

		textField_55 = new MyTextField();
		textField_55.setHorizontalAlignment(SwingConstants.CENTER);
		textField_55.setEditable(false);
		textField_55.setBounds(tempX + 3 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_55);
		textField_55.setColumns(10);

		textField_45 = new MyTextField();
		textField_45.setText("得分/场均");
		textField_45.setHorizontalAlignment(SwingConstants.CENTER);
		textField_45.setEditable(false);
		textField_45.setBounds(tempX + 4 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_45);
		textField_45.setColumns(10);

		textField_59 = new MyTextField();
		textField_59.setHorizontalAlignment(SwingConstants.CENTER);
		textField_59.setEditable(false);
		textField_59.setBounds(tempX + 5 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_59);
		textField_59.setColumns(10);

		textField_46 = new MyTextField();
		textField_46.setText("效率/场均");
		textField_46.setHorizontalAlignment(SwingConstants.CENTER);
		textField_46.setEditable(false);
		textField_46.setBounds(tempX, tempY + 8 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_46);
		textField_46.setColumns(10);

		textField_61 = new MyTextField();
		textField_61.setHorizontalAlignment(SwingConstants.CENTER);
		textField_61.setEditable(false);
		textField_61.setBounds(tempX + spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_61);
		textField_61.setColumns(10);

		txtGmsc = new MyTextField();
		txtGmsc.setText("GmSc效率值/场均");
		txtGmsc.setHorizontalAlignment(SwingConstants.CENTER);
		txtGmsc.setEditable(false);
		txtGmsc.setBounds(tempX + 2 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(txtGmsc);
		txtGmsc.setColumns(10);

		textField_65 = new MyTextField();
		textField_65.setHorizontalAlignment(SwingConstants.CENTER);
		textField_65.setEditable(false);
		textField_65.setText("");
		textField_65.setBounds(tempX + 3 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_65);
		textField_65.setColumns(10);

		textField_48 = new MyTextField();
		textField_48.setText("真实命中率");
		textField_48.setHorizontalAlignment(SwingConstants.CENTER);
		textField_48.setEditable(false);
		textField_48.setBounds(tempX + 4 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_48);
		textField_48.setColumns(10);

		textField_22 = new MyTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setEditable(false);
		textField_22.setBounds(tempX + 5 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_22);
		textField_22.setColumns(10);

		textField_50 = new MyTextField();
		textField_50.setText("投篮效率");
		textField_50.setHorizontalAlignment(SwingConstants.CENTER);
		textField_50.setEditable(false);
		textField_50.setBounds(tempX, tempY + 9 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_50);
		textField_50.setColumns(10);

		textField_34 = new MyTextField();
		textField_34.setEditable(false);
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setBounds(tempX + spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_34);
		textField_34.setColumns(10);

		textField_52 = new MyTextField();
		textField_52.setText("篮板率");
		textField_52.setHorizontalAlignment(SwingConstants.CENTER);
		textField_52.setEditable(false);
		textField_52.setBounds(tempX + 2 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_52);
		textField_52.setColumns(10);

		textField_31 = new MyTextField();
		textField_31.setEditable(false);
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setBounds(tempX + 3 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_31);
		textField_31.setColumns(10);

		textField_54 = new MyTextField();
		textField_54.setText("进攻篮板率");
		textField_54.setHorizontalAlignment(SwingConstants.CENTER);
		textField_54.setEditable(false);
		textField_54.setBounds(tempX + 4 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_54);
		textField_54.setColumns(10);

		textField_69 = new MyTextField();
		textField_69.setHorizontalAlignment(SwingConstants.CENTER);
		textField_69.setEditable(false);
		textField_69.setBounds(tempX + 5 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_69);
		textField_69.setColumns(10);

		textField_56 = new MyTextField();
		textField_56.setText("防守篮板率");
		textField_56.setHorizontalAlignment(SwingConstants.CENTER);
		textField_56.setEditable(false);
		textField_56.setBounds(tempX, tempY + 10 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_56);
		textField_56.setColumns(10);

		textField_40 = new MyTextField();
		textField_40.setHorizontalAlignment(SwingConstants.CENTER);
		textField_40.setEditable(false);
		textField_40.setBounds(tempX + spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_40);
		textField_40.setColumns(10);

		textField_58 = new MyTextField();
		textField_58.setText("助攻率");
		textField_58.setHorizontalAlignment(SwingConstants.CENTER);
		textField_58.setEditable(false);
		textField_58.setBounds(tempX + 2 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_58);
		textField_58.setColumns(10);

		textField_63 = new MyTextField();
		textField_63.setHorizontalAlignment(SwingConstants.CENTER);
		textField_63.setEditable(false);
		textField_63.setBounds(tempX + 3 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_63);
		textField_63.setColumns(10);

		textField_60 = new MyTextField();
		textField_60.setText("抢断率");
		textField_60.setEditable(false);
		textField_60.setHorizontalAlignment(SwingConstants.CENTER);
		textField_60.setBounds(tempX + 4 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_60);
		textField_60.setColumns(10);

		textField_70 = new MyTextField();
		textField_70.setHorizontalAlignment(SwingConstants.CENTER);
		textField_70.setEditable(false);
		textField_70.setBounds(tempX + 5 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_70);
		textField_70.setColumns(10);

		textField_62 = new MyTextField();
		textField_62.setText("盖帽率");
		textField_62.setEditable(false);
		textField_62.setHorizontalAlignment(SwingConstants.CENTER);
		textField_62.setBounds(tempX, tempY + 11 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_62);
		textField_62.setColumns(10);

		textField_51 = new MyTextField();
		textField_51.setHorizontalAlignment(SwingConstants.CENTER);
		textField_51.setEditable(false);
		textField_51.setBounds(tempX + spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_51);
		textField_51.setColumns(10);

		textField_64 = new MyTextField();
		textField_64.setText("失误率");
		textField_64.setHorizontalAlignment(SwingConstants.CENTER);
		textField_64.setEditable(false);
		textField_64.setBounds(tempX + 2 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_64);
		textField_64.setColumns(10);

		textField_57 = new MyTextField();
		textField_57.setHorizontalAlignment(SwingConstants.CENTER);
		textField_57.setEditable(false);
		textField_57.setBounds(tempX + 3 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_57);
		textField_57.setColumns(10);

		textField_66 = new MyTextField();
		textField_66.setText("使用率");
		textField_66.setHorizontalAlignment(SwingConstants.CENTER);
		textField_66.setEditable(false);
		textField_66.setBounds(tempX + 4 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_66);
		textField_66.setColumns(10);

		textField_71 = new MyTextField();
		textField_71.setHorizontalAlignment(SwingConstants.CENTER);
		textField_71.setEditable(false);
		textField_71.setBounds(tempX + 5 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_71);
		textField_71.setColumns(10);
	}

	// class: TeamButton
	class TeamButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String teamName;
		ArrayList<PlayerVo> playersInTeam;
		ImageIcon teamIcon;

		public TeamButton(String teamName) {
			this.teamName = teamName;
			playersInTeam = team_BS.getPlayers(teamName);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setOpaque(false);
		}
	}

	// class: PlayerButton
	class PlayerButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		String playerName;
		ImageIcon playerPortrait;

		public PlayerButton(String playerName) {
			this.playerName = playerName;
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			this.setOpaque(false);
		}
	}

	// class: PlayerTableRenderer
	class PlayerTableRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// TODO Auto-generated method stub
			PlayerButton renderer = new PlayerButton(
					((PlayerButton) value).playerName);
			renderer.playerPortrait = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + renderer.playerName + ".png")
					.getImage().getScaledInstance(X / 10, X / 10,
							Image.SCALE_SMOOTH));
			renderer.setIcon(renderer.playerPortrait);
			renderer.setSize(X / 10, X / 10);
			if (hasFocus) {
				renderer.setBorder(BorderFactory.createLineBorder(Color.BLACK,
						3));
				showPlayerInfo(renderer.playerName);
			}
			return renderer;
		}

	}

	// class: TeamTableRenderer
	class TeamTableRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			TeamButton renderer = new TeamButton(((TeamButton) value).teamName);
			renderer.playersInTeam = ((TeamButton) value).playersInTeam;
			renderer.teamIcon = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
							+ renderer.teamName + ".png")
					.getImage().getScaledInstance(X/15,
							X/15, Image.SCALE_SMOOTH));
			renderer.setIcon(renderer.teamIcon);
			teamForShowPlayer = renderer.teamName;
			if (hasFocus) {
				renderer.setBorder(BorderFactory.createLineBorder(Color.BLACK,
						3));

				if (category == "player") {
					playerRowData.clear();
					for (int i = 0; i < renderer.playersInTeam.size(); i++) {

						Vector<PlayerButton> a = new Vector<PlayerButton>(1);
						a.add(new PlayerButton(renderer.playersInTeam.get(i)
								.getName()));
						playerRowData.add(a);
					}
					playerDTM.setDataVector(playerRowData, playerColumn);
					playerTable.getColumnModel().getColumn(0)
							.setCellRenderer(new PlayerTableRenderer());

					PlayerVo defaultPlayer = player_BS.getPlayerByName(String
							.valueOf(renderer.playersInTeam.get(0).getName()));
					textField_4
							.setText(String.valueOf(defaultPlayer.getName()));

					textField_9.setText(String.valueOf(defaultPlayer
							.getHeight()));
					textField_13.setText(String.valueOf(defaultPlayer
							.getBirth()));
					textField_5.setText(String.valueOf(defaultPlayer
							.getPosition()));
					textField_10.setText(String.valueOf(defaultPlayer
							.getWeight()));
					textField_73
							.setText(String.valueOf(defaultPlayer.getExp()));
					textField_72.setText(String.valueOf(defaultPlayer
							.getNumber()));
					textField_14
							.setText(String.valueOf(defaultPlayer.getAge()));
					textField_16.setText(String.valueOf(defaultPlayer
							.getSchool()));
					textField_18.setText(String.valueOf(defaultPlayer
							.getGameNum()));
					textField_20.setText(String.valueOf(defaultPlayer
							.getFirstOnNum()));
					textField_24.setText(String.valueOf(defaultPlayer
							.getReboundOverall())
							+ "/"
							+ String.valueOf(defaultPlayer
									.getReboundOverallField()));
					textField_26
							.setText(String.valueOf(defaultPlayer
									.getAssistance())
									+ "/"
									+ String.valueOf(defaultPlayer
											.getAssistanceField()));
					textField_30.setText(String.format("%.2f",
							defaultPlayer.getTime() / 60.0)
							+ "/"
							+ String.format("%.2f",
									defaultPlayer.getTimeField() / 60));
					textField_32.setText(String.valueOf(defaultPlayer
							.getHitRate()));
					textField_36.setText(String.valueOf(defaultPlayer
							.getThreePointHitRate()));
					textField_38.setText(String.valueOf(defaultPlayer
							.getFreeThrowRate()));
					textField_42.setText(String.valueOf(defaultPlayer
							.getAttackingNum())
							+ "/"
							+ String.valueOf(defaultPlayer
									.getAttackingNumField()));
					textField_44.setText(String.valueOf(defaultPlayer
							.getDefensiveNum())
							+ "/"
							+ String.valueOf(defaultPlayer
									.getDefensiveNumField()));
					textField_47.setText(String.valueOf(defaultPlayer
							.getSteal())
							+ "/"
							+ String.valueOf(defaultPlayer.getStealField()));
					textField_49.setText(String.valueOf(defaultPlayer
							.getBlock())
							+ "/"
							+ String.valueOf(defaultPlayer.getBlockField()));
					textField_53.setText(String.valueOf(defaultPlayer
							.getTurnover())
							+ "/"
							+ String.valueOf(defaultPlayer.getTurnoverField()));
					textField_55
							.setText(String.valueOf(defaultPlayer.getFoul())
									+ "/"
									+ String.valueOf(defaultPlayer
											.getFoulField()));
					textField_59.setText(String.valueOf(defaultPlayer
							.getScore())
							+ "/"
							+ String.valueOf(defaultPlayer.getScoreField()));
					textField_61
							.setText(String.valueOf(defaultPlayer
									.getEfficiency())
									+ "/"
									+ String.valueOf(defaultPlayer
											.getEfficiencyField()));
					textField_65
							.setText(String.valueOf(defaultPlayer.getGmSc())
									+ "/"
									+ String.valueOf(defaultPlayer
											.getGmScField()));
					textField_22.setText(String.valueOf(defaultPlayer
							.getTrueHitRate()));
					textField_34.setText(String.valueOf(defaultPlayer
							.getHitEfficiency()));
					textField_31.setText(String.valueOf(defaultPlayer
							.getReboundOverallRate()));
					textField_69.setText(String.valueOf(defaultPlayer
							.getOffensiveReboundRate()));
					textField_40.setText(String.valueOf(defaultPlayer
							.getDefensiveReboundRate()));
					textField_63.setText(String.valueOf(defaultPlayer
							.getAssistanceRate()));
					textField_70.setText(String.valueOf(defaultPlayer
							.getStealRate()));
					textField_51.setText(String.valueOf(defaultPlayer
							.getBlockRate()));
					textField_57.setText(String.valueOf(defaultPlayer
							.getTurnOverRate()));
					textField_71.setText(String.valueOf(defaultPlayer
							.getUseRate()));
					ImageIcon playerIcon = new ImageIcon(new ImageIcon(
							"CSEdata/players/action/" + defaultPlayer.getName()
									+ ".png").getImage().getScaledInstance(
							X / 4, 3 * Y / 4, Image.SCALE_AREA_AVERAGING));
					playerAction.setIcon(playerIcon);

				}
				if (category == "team") {
					showTeamInfo(renderer.teamName);
				}
			}
			return renderer;
		}

	}

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 15));

		}
	}
}
