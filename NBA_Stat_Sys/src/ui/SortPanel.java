package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

import vo.PlayerVo;
import vo.TeamVo;
import businessLogic.Player_BS;
import businessLogic.Team_BS;

public class SortPanel extends JPanel {
	JFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;
	Vector<Vector<String>> rowData;
	private Vector<String> columnNames;
	JButton playerCriteriabtn;
	JButton teamCriteriabtn;
	SortPlayerCriteriaPanel sortPlayerCriteriaPanel;
	SortTeamCriteriaPanel sortTeamCriteriaPanel;

	Player_BS player_BS;
	Team_BS team_BS;

	public SortPanel(String category, JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		sortPlayerCriteriaPanel = new SortPlayerCriteriaPanel();
		sortPlayerCriteriaPanel.setVisible(false);

		sortTeamCriteriaPanel = new SortTeamCriteriaPanel();
		sortTeamCriteriaPanel.setVisible(false);

		JLabel criterialbl = new JLabel("排序依据");
		criterialbl.setBounds(99, 37, 57, 15);
		this.add(criterialbl);

		JButton upSortbtn = new JButton("U");
		upSortbtn.setBounds(455, 33, 22, 23);
		this.add(upSortbtn);

		JButton downSortbtn = new JButton("D");
		downSortbtn.setBounds(478, 33, 22, 23);
		this.add(downSortbtn);

		JButton btnSort = new JButton("排序");
		btnSort.addActionListener(e -> sortPlayer());
		btnSort.setBounds(525, 33, 88, 23);
		this.add(btnSort);

		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e -> back());
		this.add(backbtn);

		if (category == "player") {

			columnNames = new Vector<String>();
			columnNames.add("姓名");
			columnNames.add("球衣号码");
			columnNames.add("位置");
			columnNames.add("身高");
			columnNames.add("体重");
			columnNames.add("生日");
			columnNames.add("年龄");
			columnNames.add("球龄");
			columnNames.add("毕业学校");

			playerCriteriabtn = new JButton("");
			playerCriteriabtn.setBounds(166, 33, 271, 23);
			playerCriteriabtn.addActionListener(e -> playerCriteriaShow());
			add(playerCriteriabtn);

		}
		if (category == "team") {

			columnNames = new Vector<String>();
			columnNames.add("球队全名");
			columnNames.add("缩写");
			columnNames.add("所在地");
			columnNames.add("赛区");
			columnNames.add("分区");
			columnNames.add("主场");
			columnNames.add("建立时间");

			teamCriteriabtn = new JButton("");
			teamCriteriabtn.setBounds(166, 33, 271, 23);
			teamCriteriabtn.addActionListener(e -> teamCriteriaShow());
			add(teamCriteriabtn);
			
		}

		rowData = new Vector<Vector<String>>();

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 338);
		scrollPane.setVisible(true);
		this.add(scrollPane);

		mainFrame.getContentPane().add(this);

	}

	public void sortPlayer() {

		rowData = new Vector<Vector<String>>();
		Vector<String> playerInfo = new Vector<String>();

		ArrayList<PlayerVo> player = player_BS.sortPlayerBy(playerCriteriabtn
				.getText());
		for (int i = 0; i < player.size(); i++) {
			playerInfo.add(player.get(i).getName());
			playerInfo.add(String.valueOf(player.get(i).getNumber()));
			playerInfo.add(player.get(i).getPosition());
			playerInfo.add(player.get(i).getHeight());
			playerInfo.add(player.get(i).getWeight());
			playerInfo.add(player.get(i).getBirth());
			playerInfo.add(String.valueOf(player.get(i).getAge()));
			playerInfo.add(String.valueOf(player.get(i).getExp()));
			playerInfo.add(player.get(i).getSchool());
			rowData.add(playerInfo);
		}

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);

	}

	public void showTopFifty() {

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);

	}

	public void sortTeam() {

		rowData = new Vector<Vector<String>>();

		Vector<String> teamInfo = new Vector<String>();

		ArrayList<TeamVo> team = team_BS.sortTeamBy(teamCriteriabtn.getText());

		for (int i = 0; i < team.size(); i++) {
			teamInfo.add(team.get(i).getTeamName());
			teamInfo.add(team.get(i).getAbbreviation());
			teamInfo.add(team.get(i).getCity());
			teamInfo.add(team.get(i).getConference().toString());
			teamInfo.add(team.get(i).getDivision().toString());
			teamInfo.add(team.get(i).getHomeField());
			teamInfo.add(team.get(i).getBirthYear());
			rowData.add(teamInfo);
		}
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);

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
			this.setBounds(166, 56, 361, 187);

			ButtonGroup bg = new ButtonGroup();
			
			JRadioButton rdbtnNewRadioButton = new JRadioButton("参赛场数");
			rdbtnNewRadioButton.setBounds(0, 6, 90, 23);
			rdbtnNewRadioButton
					.addActionListener(new SortPlayerCriteriaListener("参赛场数"));
			add(rdbtnNewRadioButton);
			bg.add(rdbtnNewRadioButton);

			JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("先发场数");
			rdbtnNewRadioButton_1.setBounds(90, 6, 90, 23);
			rdbtnNewRadioButton_1
					.addActionListener(new SortPlayerCriteriaListener("先发场数"));
			add(rdbtnNewRadioButton_1);
			bg.add(rdbtnNewRadioButton_1);

			JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("篮板数");
			rdbtnNewRadioButton_2.setBounds(180, 31, 90, 23);
			rdbtnNewRadioButton_2
					.addActionListener(new SortPlayerCriteriaListener("篮板数"));
			add(rdbtnNewRadioButton_2);
			bg.add(rdbtnNewRadioButton_2);

			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("助攻数");
			rdbtnNewRadioButton_3.setBounds(270, 31, 90, 23);
			rdbtnNewRadioButton_3
					.addActionListener(new SortPlayerCriteriaListener("助攻数"));
			add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("在场时间");
			rdbtnNewRadioButton_4.setBounds(180, 6, 90, 23);
			rdbtnNewRadioButton_4
					.addActionListener(new SortPlayerCriteriaListener("在场时间"));
			add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			JRadioButton radioButton = new JRadioButton("投篮命中率");
			radioButton.setBounds(0, 156, 90, 23);
			radioButton.addActionListener(new SortPlayerCriteriaListener(
					"投篮命中率"));
			add(radioButton);
			bg.add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("三分命中率");
			radioButton_1.setBounds(90, 156, 90, 23);
			radioButton_1.addActionListener(new SortPlayerCriteriaListener(
					"三分命中率"));
			add(radioButton_1);
			bg.add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("罚球命中率");
			radioButton_2.setBounds(180, 156, 90, 23);
			radioButton_2.addActionListener(new SortPlayerCriteriaListener(
					"罚球命中率"));
			add(radioButton_2);
			bg.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("进攻数");
			radioButton_3.setBounds(0, 31, 90, 23);
			radioButton_3.addActionListener(new SortPlayerCriteriaListener(
					"进攻数"));
			add(radioButton_3);
			bg.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("防守数");
			radioButton_4.setBounds(90, 31, 90, 23);
			radioButton_4.addActionListener(new SortPlayerCriteriaListener(
					"防守数"));
			add(radioButton_4);
			bg.add(radioButton_4);

			JRadioButton radioButton_5 = new JRadioButton("抢断数");
			radioButton_5.setBounds(0, 56, 90, 23);
			radioButton_5.addActionListener(new SortPlayerCriteriaListener(
					"抢断数"));
			add(radioButton_5);
			bg.add(radioButton_5);

			JRadioButton radioButton_6 = new JRadioButton("盖帽数");
			radioButton_6.setBounds(90, 56, 90, 23);
			radioButton_6.addActionListener(new SortPlayerCriteriaListener(
					"盖帽数"));
			add(radioButton_6);
			bg.add(radioButton_6);

			JRadioButton radioButton_7 = new JRadioButton("失误数");
			radioButton_7.setBounds(180, 56, 90, 23);
			radioButton_7.addActionListener(new SortPlayerCriteriaListener(
					"失误数"));
			add(radioButton_7);
			bg.add(radioButton_7);

			JRadioButton radioButton_8 = new JRadioButton("犯规数");
			radioButton_8.setBounds(270, 56, 90, 23);
			radioButton_8.addActionListener(new SortPlayerCriteriaListener(
					"犯规数"));
			add(radioButton_8);
			bg.add(radioButton_8);

			JRadioButton radioButton_9 = new JRadioButton("得分");
			radioButton_9.setBounds(0, 81, 90, 23);
			radioButton_9
					.addActionListener(new SortPlayerCriteriaListener("得分"));
			add(radioButton_9);
			bg.add(radioButton_9);

			JRadioButton radioButton_10 = new JRadioButton("效率");
			radioButton_10.setBounds(180, 131, 90, 23);
			radioButton_10.addActionListener(new SortPlayerCriteriaListener(
					"效率"));
			add(radioButton_10);
			bg.add(radioButton_10);

			JRadioButton rdbtnGmsc = new JRadioButton("GmSc效率值");
			rdbtnGmsc.setBounds(90, 81, 90, 23);
			rdbtnGmsc.addActionListener(new SortPlayerCriteriaListener(
					"GmSc效率值"));
			add(rdbtnGmsc);
			bg.add(rdbtnGmsc);

			JRadioButton radioButton_11 = new JRadioButton("真实命中率");
			radioButton_11.setBounds(270, 131, 90, 23);
			radioButton_11.addActionListener(new SortPlayerCriteriaListener(
					"真实命中率"));
			add(radioButton_11);
			bg.add(radioButton_11);

			JRadioButton radioButton_12 = new JRadioButton("投篮效率");
			radioButton_12.setBounds(180, 81, 90, 23);
			radioButton_12.addActionListener(new SortPlayerCriteriaListener(
					"投篮效率"));
			add(radioButton_12);
			bg.add(radioButton_12);

			JRadioButton radioButton_13 = new JRadioButton("篮板率");
			radioButton_13.setBounds(270, 81, 90, 23);
			radioButton_13.addActionListener(new SortPlayerCriteriaListener(
					"篮板率"));
			add(radioButton_13);
			bg.add(radioButton_13);

			JRadioButton radioButton_14 = new JRadioButton("进攻篮板率");
			radioButton_14.setBounds(0, 106, 90, 23);
			radioButton_14.addActionListener(new SortPlayerCriteriaListener(
					"进攻篮板率"));
			add(radioButton_14);
			bg.add(radioButton_14);

			JRadioButton radioButton_15 = new JRadioButton("防守篮板率");
			radioButton_15.setBounds(90, 106, 90, 23);
			radioButton_15.addActionListener(new SortPlayerCriteriaListener(
					"防守篮板率"));
			add(radioButton_15);
			bg.add(radioButton_15);

			JRadioButton radioButton_16 = new JRadioButton("助攻率");
			radioButton_16.setBounds(180, 106, 90, 23);
			radioButton_16.addActionListener(new SortPlayerCriteriaListener(
					"助攻率"));
			add(radioButton_16);
			bg.add(radioButton_16);

			JRadioButton radioButton_17 = new JRadioButton("抢断率");
			radioButton_17.setBounds(270, 106, 90, 23);
			radioButton_17.addActionListener(new SortPlayerCriteriaListener(
					"抢断率"));
			add(radioButton_17);
			bg.add(radioButton_17);

			JRadioButton radioButton_18 = new JRadioButton("盖帽率");
			radioButton_18.setBounds(0, 131, 90, 23);
			radioButton_18.addActionListener(new SortPlayerCriteriaListener(
					"盖帽率"));
			add(radioButton_18);
			bg.add(radioButton_18);

			JRadioButton radioButton_19 = new JRadioButton("失误率");
			radioButton_19.setBounds(90, 131, 90, 23);
			radioButton_19.addActionListener(new SortPlayerCriteriaListener(
					"失误率"));
			add(radioButton_19);
			bg.add(radioButton_19);

			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("使用率");
			rdbtnNewRadioButton_5.setBounds(270, 6, 90, 23);
			rdbtnNewRadioButton_5
					.addActionListener(new SortPlayerCriteriaListener("使用率"));
			add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

		
			mainFrame.getContentPane().add(this);

		}
	}

	public class SortTeamCriteriaPanel extends JPanel {
		public SortTeamCriteriaPanel() {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(166, 56, 361, 187);

			ButtonGroup bg1=new ButtonGroup();
			
			JRadioButton radioButton = new JRadioButton("比赛场数");
			radioButton.setBounds(0, 6, 90, 23);
			radioButton.addActionListener(new SortTeamCriteriaListener("比赛场数"));
			add(radioButton);
			bg1.add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("投篮命中数");
			radioButton_1.setBounds(0, 31, 90, 23);
			radioButton_1.addActionListener(new SortTeamCriteriaListener("投篮命中率"));
			add(radioButton_1);
            bg1.add(radioButton_1);
            
			JRadioButton radioButton_2 = new JRadioButton("投篮出手数");
			radioButton_2.setBounds(90, 31, 90, 23);
			radioButton_2.addActionListener(new SortTeamCriteriaListener("投篮出手数"));
			add(radioButton_2);
			bg1.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("三分命中数");
			radioButton_3.setBounds(180, 31, 90, 23);
			radioButton_3.addActionListener(new SortTeamCriteriaListener("三分命中数"));
			add(radioButton_3);
			bg1.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("三分出手数");
			radioButton_4.setBounds(270, 31, 90, 23);
			radioButton_4.addActionListener(new SortTeamCriteriaListener("三分出手数"));
			add(radioButton_4);
			bg1.add(radioButton_4);
			
			JRadioButton radioButton_5 = new JRadioButton("罚球命中数");
			radioButton_5.setBounds(0, 56, 90, 23);
			radioButton_5.addActionListener(new SortTeamCriteriaListener("罚球命中数"));
			add(radioButton_5);
			bg1.add(radioButton_5);

			JRadioButton radioButton_6 = new JRadioButton("罚球出手数");
			radioButton_6.setBounds(90, 56, 90, 23);
			radioButton_6.addActionListener(new SortTeamCriteriaListener("罚球出手数"));
			add(radioButton_6);
			bg1.add(radioButton_6);

			JRadioButton radioButton_7 = new JRadioButton("进攻篮板数");
			radioButton_7.setBounds(90, 6, 90, 23);
			radioButton_7.addActionListener(new SortTeamCriteriaListener("进攻篮板数"));
			add(radioButton_7);
			bg1.add(radioButton_7);

			JRadioButton radioButton_8 = new JRadioButton("防守篮板数");
			radioButton_8.setBounds(180, 6, 90, 23);
			radioButton_8.addActionListener(new SortTeamCriteriaListener("防守篮板数"));
			add(radioButton_8);
			bg1.add(radioButton_8);

			JRadioButton radioButton_9 = new JRadioButton("篮板数");
			radioButton_9.setBounds(270, 6, 90, 23);
			radioButton_9.addActionListener(new SortTeamCriteriaListener("篮板数"));
			add(radioButton_9);
			bg1.add(radioButton_9);

			JRadioButton radioButton_10 = new JRadioButton("助攻数");
			radioButton_10.setBounds(180, 56, 90, 23);
			radioButton_10.addActionListener(new SortTeamCriteriaListener("助攻数"));
			add(radioButton_10);
			bg1.add(radioButton_10);

			JRadioButton radioButton_11 = new JRadioButton("抢断数");
			radioButton_11.setBounds(270, 56, 90, 23);
			radioButton_11.addActionListener(new SortTeamCriteriaListener("抢断数"));
			add(radioButton_11);
			bg1.add(radioButton_11);

			JRadioButton radioButton_12 = new JRadioButton("盖帽数");
			radioButton_12.setBounds(0, 81, 90, 23);
			radioButton_12.addActionListener(new SortTeamCriteriaListener("盖帽数"));
			add(radioButton_12);
			bg1.add(radioButton_12);
			
			JRadioButton radioButton_13 = new JRadioButton("失误数");
			radioButton_13.setBounds(90, 81, 90, 23);
			radioButton_13.addActionListener(new SortTeamCriteriaListener("失误数"));
			add(radioButton_13);
			bg1.add(radioButton_13);
			
			JRadioButton radioButton_14 = new JRadioButton("犯规数");
			radioButton_14.setBounds(180, 81, 90, 23);
			radioButton_14.addActionListener(new SortTeamCriteriaListener("犯规数"));
			add(radioButton_14);
			bg1.add(radioButton_14);
			
			JRadioButton radioButton_15 = new JRadioButton("比赛得分");
			radioButton_15.setBounds(270, 81, 90, 23);
			radioButton_15.addActionListener(new SortTeamCriteriaListener("比赛得分"));
			add(radioButton_15);
			bg1.add(radioButton_15);
			
			JRadioButton radioButton_16 = new JRadioButton("投篮命中率");
			radioButton_16.setBounds(0, 106, 90, 23);
			radioButton_16.addActionListener(new SortTeamCriteriaListener("投篮命中率"));
			add(radioButton_16);
			bg1.add(radioButton_16);
			
			JRadioButton radioButton_17 = new JRadioButton("三分命中率");
			radioButton_17.setBounds(90, 106, 90, 23);
			radioButton_17.addActionListener(new SortTeamCriteriaListener("三分命中率"));
			add(radioButton_17);
			bg1.add(radioButton_17);
			
			JRadioButton radioButton_18 = new JRadioButton("罚球命中率");
			radioButton_18.setBounds(180, 106, 90, 23);
			radioButton_18.addActionListener(new SortTeamCriteriaListener("罚球命中率"));
			add(radioButton_18);
			bg1.add(radioButton_18);
			
			JRadioButton radioButton_19 = new JRadioButton("胜率");
			radioButton_19.setBounds(270, 106, 90, 23);
			radioButton_19.addActionListener(new SortTeamCriteriaListener("胜率"));
			add(radioButton_19);
			bg1.add(radioButton_19);
			
			JRadioButton radioButton_20 = new JRadioButton("进攻回合");
			radioButton_20.setBounds(0, 131, 90, 23);
			radioButton_20.addActionListener(new SortTeamCriteriaListener("进攻回合"));
			add(radioButton_20);
			bg1.add(radioButton_20);
			
			JRadioButton radioButton_21 = new JRadioButton("进攻效率");
			radioButton_21.setBounds(90, 131, 90, 23);
			radioButton_21.addActionListener(new SortTeamCriteriaListener("进攻效率"));
			add(radioButton_21);
			bg1.add(radioButton_21);
			
			JRadioButton radioButton_22 = new JRadioButton("防守效率");
			radioButton_22.setBounds(180, 131, 90, 23);
			radioButton_22.addActionListener(new SortTeamCriteriaListener("防守效率"));
			add(radioButton_22);
			bg1.add(radioButton_22);
			
			JRadioButton radioButton_23 = new JRadioButton("篮板效率");
			radioButton_23.setBounds(270, 131, 90, 23);
			radioButton_23.addActionListener(new SortTeamCriteriaListener("篮板效率"));
			add(radioButton_23);
			bg1.add(radioButton_23);
			
			JRadioButton radioButton_24 = new JRadioButton("抢断效率");
			radioButton_24.setBounds(0, 156, 90, 23);
			radioButton_24.addActionListener(new SortTeamCriteriaListener("抢断效率"));
			add(radioButton_24);
			bg1.add(radioButton_24);
			
			JRadioButton radioButton_25 = new JRadioButton("助攻率");
			radioButton_25.setBounds(90, 156, 90, 23);
			radioButton_25.addActionListener(new SortTeamCriteriaListener("助攻率"));
			add(radioButton_25);
			bg1.add(radioButton_25);
			
			mainFrame.getContentPane().add(this);
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
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "先发场数":
				playerCriteriabtn.setText("先发场数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "篮板数":
				playerCriteriabtn.setText("篮板数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "助攻数":
				playerCriteriabtn.setText("助攻数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "在场时间":
				playerCriteriabtn.setText("在场时间");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "投篮命中率":
				playerCriteriabtn.setText("投篮命中率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "三分命中率":
				playerCriteriabtn.setText("三分命中率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "罚球命中率":
				playerCriteriabtn.setText("罚球命中率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "进攻数":
				playerCriteriabtn.setText("进攻数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "防守数":
				playerCriteriabtn.setText("防守数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "抢断数":
				playerCriteriabtn.setText("抢断数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "盖帽数":
				playerCriteriabtn.setText("盖帽数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "失误数":
				playerCriteriabtn.setText("失误数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "犯规数":
				playerCriteriabtn.setText("犯规数");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "得分":
				playerCriteriabtn.setText("得分");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "效率":
				playerCriteriabtn.setText("效率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "GmSc效率值":
				playerCriteriabtn.setText("GmSc效率值");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "真实命中率":
				playerCriteriabtn.setText("真实命中率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "投篮效率":
				playerCriteriabtn.setText("投篮效率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "篮板率":
				playerCriteriabtn.setText("篮板率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "进攻篮板率":
				playerCriteriabtn.setText("进攻篮球率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "防守篮板率":
				playerCriteriabtn.setText("防守篮板率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "助攻率":
				playerCriteriabtn.setText("助攻率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;

			case "抢断率":
				playerCriteriabtn.setText("抢断率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "盖帽率":
				playerCriteriabtn.setText("盖帽率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "失误率":
				playerCriteriabtn.setText("失误率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			case "使用率":
				playerCriteriabtn.setText("使用率");
				sortPlayerCriteriaPanel.setVisible(false);
				break;
			default:
				System.out.println("筛选标准选择出错");
				break;
			}

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
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮命中数":
				teamCriteriabtn.setText("投篮命中数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮出手数":
				teamCriteriabtn.setText("投篮出手数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分命中数":
				teamCriteriabtn.setText("三分命中数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分出手数":
				teamCriteriabtn.setText("三分出手数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球命中数":
				teamCriteriabtn.setText("罚球命中数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球出手数":
				teamCriteriabtn.setText("罚球出手数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻篮板数":
				teamCriteriabtn.setText("进攻篮板数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "防守篮板数":
				teamCriteriabtn.setText("防守篮板数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "篮板数":
				teamCriteriabtn.setText("篮板数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "助攻数":
				teamCriteriabtn.setText("助攻数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "抢断数":
				teamCriteriabtn.setText("抢断数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "盖帽数":
				teamCriteriabtn.setText("盖帽数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "失误数":
				teamCriteriabtn.setText("失误数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "犯规数":
				teamCriteriabtn.setText("犯规数");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "比赛得分":
				teamCriteriabtn.setText("比赛得分");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "投篮命中率":
				teamCriteriabtn.setText("投篮命中率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "三分命中率":
				teamCriteriabtn.setText("三分命中率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "罚球命中率":
				teamCriteriabtn.setText("罚球命中率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "胜率":
				teamCriteriabtn.setText("胜率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻回合":
				teamCriteriabtn.setText("进攻回合");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "进攻效率":
				teamCriteriabtn.setText("进攻效率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "防守效率":
				teamCriteriabtn.setText("防守效率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "篮板效率":
				teamCriteriabtn.setText("篮板效率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "抢断效率":
				teamCriteriabtn.setText("抢断效率");
				sortTeamCriteriaPanel.setVisible(false);
				break;
			case "助攻率":
				teamCriteriabtn.setText("助攻率");
				sortTeamCriteriaPanel.setVisible(false);
				break;

			default:
				System.out.println("筛选标准选择出错");
				break;
			}

		}
	}
}
