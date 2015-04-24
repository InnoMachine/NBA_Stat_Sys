package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.TableCellRenderer;

import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import ui.ShowPanel.MyTextField;
import vo.PlayerGames;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerRecentGames;
import vo.PlayerVo;

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

	Vector<Vector<String>> recentGameRowData;
	Vector<String> recentGameColumn;
	private JTable recentGameInfoTable;
	private JScrollPane recentGameInfoJSP;
	Vector<Vector<String>> historicalGameRowData;
	Vector<String> historicalGameColumn;
	private JTable historicalGameInfoTable;
	private JScrollPane historicalGameInfoJSP;

	JButton historicalDataCheck;
	JButton currentDataCheck;
	private JLabel contentlbl;

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
		ImageIcon portrait = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + playerName + ".png").getImage()
				.getScaledInstance(playerPortrait.getWidth(),
						playerPortrait.getHeight(), Image.SCALE_SMOOTH));
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
		ImageIcon action = new ImageIcon(new ImageIcon(
				"CSEdata/players/action/" + playerName + ".png").getImage()
				.getScaledInstance(playerAction.getWidth(),
						playerAction.getHeight(), Image.SCALE_SMOOTH));
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

		JButton fresh = new JButton();
		ImageIcon freshIcon = new ImageIcon(
				new ImageIcon("Image/freshIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		fresh.setBounds(X * 1250 / 1366, Y * 120 / 768, X / 25, X / 25);
		fresh.setIcon(freshIcon);
		fresh.setOpaque(false);
		fresh.setContentAreaFilled(false);
		fresh.setBorderPainted(false);
		fresh.addActionListener(e -> fresh());
		bgLabel.add(fresh);

		

		// -----------------------------------------------------------------------------------------------
		

		contentlbl = new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);
		
		bgLabel.add(contentlbl);

		JButton recentbtn = new JButton("近期比赛");
		recentbtn.setBounds(X * 90 / 1366, Y * 220 / 768, X * 333 / 1366,
				Y * 30 / 768);
		recentbtn.setVisible(true);
		recentbtn.addActionListener(e -> showRecentData());
		bgLabel.add(recentbtn);

		JButton historicalbtn = new JButton("过往数据");
		historicalbtn.setBounds(X * 423 / 1366, Y * 220 / 768, X * 333 / 1366,
				Y * 30 / 768);
		historicalbtn.setVisible(true);
		historicalbtn.addActionListener(e->showHistoricalData());
		bgLabel.add(historicalbtn);
		
		JButton vsbtn = new JButton("对比");
		vsbtn.setBounds(X * 756 / 1366, Y * 220 / 768, X * 333 / 1366,
				Y * 30 / 768);
		vsbtn.setVisible(true);
		vsbtn.addActionListener(e->showVSData());
		bgLabel.add(vsbtn);

		addBasicInfo();
		addBasicData();

		mainFrame.getContentPane().add(this);
	}

	public void showRecentData() {
		PlayerRecentGames recentGames = new PlayerRecentGames();
		recentGames = player_BS.getPlayerRecentPerformance(playerName);
        ArrayList<PlayerPerformanceInSingleGame> recentFiveGames=new ArrayList<PlayerPerformanceInSingleGame>();
        recentFiveGames=recentGames.getFiveGames();
		
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

		recentGameInfoTable = new JTable(recentGameRowData,
				recentGameColumn) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		/*
		 * DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		 * r2.setHorizontalAlignment(JLabel.CENTER);
		 * recentGameInfoTable.getColumnModel().getColumn(0)
		 * .setPreferredWidth(X * 100 / 1366);
		 * recentGameInfoTable.setDefaultRenderer(Object.class, r2);
		 */
		recentGameInfoTable.setForeground(Color.WHITE);
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		recentGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		recentGameInfoTable.setDefaultRenderer(Object.class, r2);

		recentGameInfoTable.setRowHeight(X * 20 / 1366);
		// recentGameInfoTable.setOpaque(false);
		recentGameInfoTable.setBackground(Color.gray);

		recentGameInfoJSP = new JScrollPane(recentGameInfoTable);
		recentGameInfoJSP.setSize(X * 1000 / 1366, Y * 480 / 768);
		recentGameInfoJSP.setVisible(true);
		recentGameInfoJSP.setBackground(Color.gray);
		if(contentlbl!=null){
			contentlbl.setVisible(false);
		}
		contentlbl=new JLabel();
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
				historicalGameColumn) {
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		/*
		 * DefaultTableCellRenderer r2 = new DefaultTableCellRenderer();
		 * r2.setHorizontalAlignment(JLabel.CENTER);
		 * historicalGameInfoTable.getColumnModel().getColumn(0)
		 * .setPreferredWidth(X * 100 / 1366);
		 * historicalGameInfoTable.setDefaultRenderer(Object.class, r2);
		 */
		historicalGameInfoTable.setForeground(Color.WHITE);
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		historicalGameInfoTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 100 / 1366);
		historicalGameInfoTable.setDefaultRenderer(Object.class, r2);

		historicalGameInfoTable.setRowHeight(X * 20 / 1366);
		// historicalGameInfoTable.setOpaque(false);
		historicalGameInfoTable.setBackground(Color.gray);

		historicalGameInfoJSP = new JScrollPane(historicalGameInfoTable);
		historicalGameInfoJSP.setSize(X * 1000 / 1366, Y * 480 / 768);
		historicalGameInfoJSP.setVisible(true);
		historicalGameInfoJSP.setBackground(Color.gray);
		if(contentlbl!=null){
			contentlbl.setVisible(false);
		}
		contentlbl=new JLabel();
		contentlbl.setBounds(X * 90 / 1366, Y * 250 / 768, X * 1000 / 1366,
				Y * 480 / 768);
		contentlbl.setOpaque(false);	
		contentlbl.add(historicalGameInfoJSP);
		bgLabel.add(contentlbl);
	}

	public void showVSData() {
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

	public void fresh() {

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
				setBackground(Color.DARK_GRAY);

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
}
