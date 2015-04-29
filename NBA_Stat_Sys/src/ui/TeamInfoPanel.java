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
import javax.swing.JComponent;
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
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import ui.PlayerInfoPanel.MyTableRenderer;
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
	String previouspanel;
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

	Vector<Vector<String>> playersRowData;
	Vector<String> playersColumn;
	private DefaultTableModel playersInfoDTM;
	private JTable playersInfoTable;
	private JScrollPane playersInfoJSP;
	private JButton playersInfoButton;
	
	Vector<Vector<String>> recentGameRowData;
	Vector<String> recentGameColumn;
	private DefaultTableModel recentGameDTM;
	private JTable recentGameInfoTable;
	private JScrollPane recentGameInfoJSP;
	private JButton recentGameButton;
	
	Vector<Vector<String>> historicalGameRowData;
	Vector<String> historicalGameColumn;
	private DefaultTableModel historicalGameDTM;
	private JTable historicalGameInfoTable;
	private JScrollPane historicalGameInfoJSP;
	private JButton historicalGameButton;

	private JLabel TeamBadge;

	Team_BS team_BS = new Team_BL_Stub();

	public TeamInfoPanel(String abbr, JFrame mainFrame, JPanel previousPanel,String previouspanel) {
		this.mainFrame = mainFrame;
		this.teamABBR = abbr;
		this.previousPanel = previousPanel;
		this.previouspanel = previouspanel;
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
		bg = new ImageIcon(new ImageIcon("Image/teamPanel.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);

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
		close.setBounds(19 * X / 20, Y * 20/ 768, X / 25, X / 25);
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

		playersInfoButton=new MyButton("球员列表⊙");
		playersInfoButton.setLocation(X*200/1366, Y*200/768);
		playersInfoButton.addActionListener(e->{
			playersInfoJSP.setVisible(true);
			recentGameInfoJSP.setVisible(false);
			historicalGameInfoJSP.setVisible(false);
			playersInfoButton.setText("球员列表⊙");
			recentGameButton.setText("最近比赛");
			historicalGameButton.setText("历史比赛");
		});
		
		recentGameButton=new MyButton("最近比赛");
		recentGameButton.setLocation(X*350/1366, Y*200/768);
		recentGameButton.addActionListener(e->{
			playersInfoJSP.setVisible(false);
			recentGameInfoJSP.setVisible(true);
			historicalGameInfoJSP.setVisible(false);
			playersInfoButton.setText("球员列表");
			recentGameButton.setText("最近比赛⊙");
			historicalGameButton.setText("历史比赛");
		});
		
		historicalGameButton=new MyButton("历史比赛");
		historicalGameButton.setLocation(X*500/1366, Y*200/768);
		historicalGameButton.addActionListener(e->{
			playersInfoJSP.setVisible(false);
			recentGameInfoJSP.setVisible(false);
			historicalGameInfoJSP.setVisible(true);
			playersInfoButton.setText("球员列表");
			recentGameButton.setText("最近比赛");
			historicalGameButton.setText("历史比赛⊙");
		});
		
		addBasicInfo();
		addBasicData();
		createPlayerInfoJSP();
		createRecentDataJSP();
		createHistoricalDataJSP();
		playersInfoJSP.setVisible(true);

		mainFrame.getContentPane().add(this);
	}
	
	private void createPlayerInfoJSP(){
		ArrayList<PlayerVo> players = new ArrayList<PlayerVo>();
		players = team_BS.getPlayers(teamABBR);

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
		playersInfoDTM=new DefaultTableModel(playersRowData, playersColumn){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		playersInfoTable = new JTable(playersInfoDTM);
		JTableHeader header =playersInfoTable.getTableHeader();		
        header.setDefaultRenderer(new DefaultTableCellRenderer(){
        
        	
             public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
                 Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                     cell.setBackground(Color.DARK_GRAY);
                 return cell;
             }
          
        });
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		playersInfoTable.setDefaultRenderer(Object.class, r2);
        playersInfoTable.setForeground(Color.WHITE);
		
		playersInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		
		playersInfoTable.getColumnModel().getColumn(17)
				.setCellRenderer(new MyButtonRenderer());
		playersInfoTable.setRowHeight(X * 20 / 1366);
		playersInfoJSP = new JScrollPane(playersInfoTable);
		playersInfoJSP.setBounds(X*200/1366,Y*230/768 , X*1000/1366, Y*500/768);
//		playersInfoJSP.setBackground(Color.GRAY);
		playersInfoJSP.setOpaque(false);
		playersInfoJSP.getViewport().setOpaque(false);
		playersInfoJSP.setVisible(false);
		bgLabel.add(playersInfoJSP);
	}

	private void createRecentDataJSP(){
		TeamRecentGames teamRecentGames = new TeamRecentGames();
		teamRecentGames = team_BS.getTeamRecentPerformance(teamABBR);
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
		recentGameDTM=new DefaultTableModel(recentGameRowData, recentGameColumn){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		recentGameInfoTable = new JTable(recentGameDTM);
		JTableHeader header =recentGameInfoTable.getTableHeader();		
        header.setDefaultRenderer(new DefaultTableCellRenderer(){	
             public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
                 Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                     cell.setBackground(Color.DARK_GRAY);
                 return cell;
             }
          
        });
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
        MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		recentGameInfoTable.setDefaultRenderer(Object.class, r2);
        recentGameInfoTable.setForeground(Color.WHITE);
		recentGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		recentGameInfoTable.setRowHeight(X * 20 / 1366);
		recentGameInfoTable.setOpaque(false);
		recentGameInfoJSP = new JScrollPane(recentGameInfoTable);
		recentGameInfoJSP.setBounds(X*200/1366,Y*230/768 , X*1000/1366, Y*500/768);
		recentGameInfoJSP.setOpaque(false);
		recentGameInfoJSP.getViewport().setOpaque(false);
		recentGameInfoJSP.setVisible(false);
		bgLabel.add(recentGameInfoJSP);
	}

	private void createHistoricalDataJSP(){

		ArrayList<TeamPerformanceInSingleGame> historicalGames = new ArrayList<TeamPerformanceInSingleGame>();
		historicalGames = team_BS.getTeamPerformance(teamABBR);

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
		
		historicalGameDTM=new DefaultTableModel(historicalGameRowData,
				historicalGameColumn){
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		historicalGameInfoTable = new JTable(historicalGameDTM);
		JTableHeader header =historicalGameInfoTable.getTableHeader();		
        header.setDefaultRenderer(new DefaultTableCellRenderer(){     	
             public Component getTableCellRendererComponent(JTable table, Object value,
                     boolean isSelected, boolean hasFocus, int row, int column) {
                 Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                     cell.setBackground(Color.DARK_GRAY);
                 return cell;
             }
          
        });
        ((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        
        MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		historicalGameInfoTable.setDefaultRenderer(Object.class, r2);
		
        historicalGameInfoTable.setForeground(Color.WHITE);
		historicalGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		historicalGameInfoTable.setRowHeight(X * 20 / 1366);
		historicalGameInfoTable.setOpaque(false);
		historicalGameInfoJSP = new JScrollPane(historicalGameInfoTable);
		historicalGameInfoJSP.setBounds(X*200/1366,Y*230/768 , X*1000/1366, Y*500/768);
		historicalGameInfoJSP.setOpaque(false);
		historicalGameInfoJSP.getViewport().setOpaque(false);
		historicalGameInfoJSP.setVisible(false);
		bgLabel.add(historicalGameInfoJSP);
	}
	
 	private void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel="StartPanel";
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		mainFrame.add(previousPanel);
		MainFrame.currentPanel=previouspanel;
	
	
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
		int tempX = X * 245 / 1366;
		int tempY = Y / 9;
		int spaceX = X / 12;
		int spaceY = Y / 20;

		textField_1 = new MyTextField();
		textField_1.setText("球队全名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		textField_1.setBackground(Color.GRAY);
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		textField_2.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("缩写");
		textField_3.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		textField_3.setBackground(Color.GRAY);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		textField_4.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("所在地");
		textField_5.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		textField_5.setBackground(Color.GRAY);
		bgLabel.add(textField_5);

		textField_6 = new MyTextField();
		textField_6.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		textField_6.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_6);

		textField_7 = new MyTextField();
		textField_7.setText("赛区");
		textField_7.setBounds(tempX + 6 * spaceX, tempY, spaceX, spaceY);
		textField_7.setBackground(Color.GRAY);
		bgLabel.add(textField_7);

		textField_8 = new MyTextField();
		textField_8.setBounds(tempX + 7 * spaceX, tempY, spaceX, spaceY);
		textField_8.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_8);

		textField_9 = new MyTextField();
		textField_9.setText("分区");
		textField_9.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		textField_9.setBackground(Color.GRAY);
		bgLabel.add(textField_9);

		textField_10 = new MyTextField();
		textField_10.setBounds(tempX + 1 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_10.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_10);

		textField_11 = new MyTextField();
		textField_11.setText("主场");
		textField_11.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_11.setBackground(Color.GRAY);
		bgLabel.add(textField_11);

		textField_12 = new MyTextField();
		textField_12.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_12.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_12);

		textField_13 = new MyTextField();
		textField_13.setText("建立时间");
		textField_13.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_13.setBackground(Color.GRAY);
		bgLabel.add(textField_13);

		textField_14 = new MyTextField();
		textField_14.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_14.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_14);

		textField_15 = new MyTextField();
		textField_15.setText("比赛场数");
		textField_15.setBounds(tempX + 6 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_15.setBackground(Color.GRAY);
		bgLabel.add(textField_15);

		textField_16 = new MyTextField();
		textField_16.setBounds(tempX + 7 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		textField_16.setBackground(Color.DARK_GRAY);
		bgLabel.add(textField_16);

	}
	
	public void refresh(){
		remove(this);
		MainFrame.teamInfoPanel=new TeamInfoPanel(teamABBR, mainFrame, previousPanel,previouspanel);
		
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
								previousPanel,previouspanel));
				mainFrame.add(playerInfoPanel);
			}
			return this;
		}

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

	
	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setForeground(Color.BLACK);
			this.setFont(new Font("微软雅黑", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setForeground(Color.WHITE);
			this.setColumns(X * 10 / 1366);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
	//		this.setOpaque(false);
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
			this.setSize(X*150/1366, Y*30/768);
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(this.getWidth(), this.getHeight(),
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			bgLabel.add(this);
		}
	}
}
