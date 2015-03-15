package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import po.Division;
import businessLogic.Player_BS;
import vo.PlayerVo;

public class ScreeningPlayerPanel extends JPanel {
	JFrame mainFrame;
	private String[] positions;
	private String[] leagues;
	private JTable table;
	private JScrollPane scrollPane;
	Vector<Vector<String>> rowData;
	private Vector<String> columnNames;
	JComboBox positionjcb;
	JComboBox leaguejcb;
	ScreeningPlayerCriteriaPanel playerCriteriaPanel;

	Player_BS player_BS;
	private JButton screeningCriteriabtn;

	public ScreeningPlayerPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		JLabel screeninglbl = new JLabel("筛选依据");
		screeninglbl.setBounds(338, 37, 57, 15);
		this.add(screeninglbl);

		screeningCriteriabtn = new JButton("");
		screeningCriteriabtn.setBounds(393, 33, 93, 23);
		screeningCriteriabtn.addActionListener(e -> showScreeningCriteria());
		add(screeningCriteriabtn);

		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e -> back());
		this.add(backbtn);

		JButton screeningbtn = new JButton("显示前50名");
		screeningbtn.setBounds(496, 33, 119, 23);
		screeningbtn.addActionListener(e -> screening());
		add(screeningbtn);

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
		// columnNames.add("具体信息");

		mainFrame.getContentPane().add(this);

		JLabel label = new JLabel("球员位置");
		label.setBounds(75, 37, 54, 15);
		add(label);

		JLabel label_1 = new JLabel("球员联盟");
		label_1.setBounds(202, 37, 54, 15);
		add(label_1);

		positions = new String[4];
		positions[0] = "所有";
		positions[1] = "前锋";
		positions[2] = "中锋";
		positions[3] = "后卫";
		positionjcb = new JComboBox(positions);
		positionjcb.setBounds(132, 34, 60, 21);
		this.add(positionjcb);

		leagues = new String[3];
		leagues[0] = "所有";
		leagues[1] = "东部";
		leagues[2] = "西部";
		leaguejcb = new JComboBox(leagues);
		leaguejcb.setBounds(259, 34, 60, 21);
		this.add(leaguejcb);

		rowData = new Vector<Vector<String>>();
		// Vector<String> test=new Vector<String>();
		// test.add(null);
		// test.add(null);
		// test.add(null);
		// test.add(null);
		// rowData.add(test);

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(60, 80, 580, 340);

		// table.getColumn("具体信息").setCellEditor(new MyRender());
		// table.getColumn("具体信息").setCellRenderer(new MyRender());
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 80, 580, 340);
		scrollPane.setVisible(true);

		this.add(scrollPane);

	}

	public void showScreeningCriteria() {

		playerCriteriaPanel = new ScreeningPlayerCriteriaPanel(mainFrame, this);

	}

	public void screening() {

		rowData = new Vector<Vector<String>>();
		Vector<String> playerInfo = new Vector<String>();

		ArrayList<PlayerVo> player = player_BS.filterPlayerBy(
				String.valueOf(positionjcb.getSelectedItem()),
				Division.valueOf(String.valueOf(leaguejcb.getSelectedItem())),
				screeningCriteriabtn.getText());
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
		table.setBounds(60, 80, 580, 340);

		// table.getColumn("具体信息").setCellEditor(new MyRender());
		// table.getColumn("具体信息").setCellRenderer(new MyRender());
		table.setColumnSelectionAllowed(true);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 80, 580, 340);
		scrollPane.setVisible(true);
		this.add(scrollPane);

	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
		playerCriteriaPanel.setVisible(false);
	}

	public class ScreeningPlayerCriteriaPanel extends JPanel {

		public ScreeningPlayerCriteriaPanel(JFrame mainFrame,
				ScreeningPlayerPanel screeningPlayerPanel) {
			this.setLayout(null);
			this.setVisible(true);
			this.setBounds(393, 56, 283, 118);

			JRadioButton scorebtn = new JRadioButton("得分");
			scorebtn.setBounds(6, 6, 56, 23);
			scorebtn.addActionListener(new ScreeningCriteriaListener("得分"));
			add(scorebtn);

			JRadioButton reboundbtn = new JRadioButton("篮板");
			reboundbtn.setBounds(6, 31, 56, 23);
			reboundbtn.addActionListener(new ScreeningCriteriaListener("篮板"));
			add(reboundbtn);

			JRadioButton assistancebtn = new JRadioButton("助攻");
			assistancebtn.setBounds(6, 56, 56, 23);
			assistancebtn.addActionListener(new ScreeningCriteriaListener("助攻"));
			add(assistancebtn);

			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("得分/篮板/助攻");
			rdbtnNewRadioButton_3.setBounds(76, 81, 150, 23);
			rdbtnNewRadioButton_3.addActionListener(new ScreeningCriteriaListener("得分/篮板/助攻"));
			add(rdbtnNewRadioButton_3);

			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("盖帽");
			rdbtnNewRadioButton_4.setBounds(6, 81, 56, 23);
			rdbtnNewRadioButton_4.addActionListener(new ScreeningCriteriaListener("盖帽"));
			add(rdbtnNewRadioButton_4);

			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("抢断");
			rdbtnNewRadioButton_5.setBounds(76, 6, 56, 23);
			rdbtnNewRadioButton_5.addActionListener(new ScreeningCriteriaListener("抢断"));
			add(rdbtnNewRadioButton_5);

			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("犯规");
			rdbtnNewRadioButton_6.setBounds(76, 31, 56, 23);
			rdbtnNewRadioButton_6.addActionListener(new ScreeningCriteriaListener("犯规"));
			add(rdbtnNewRadioButton_6);

			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("失误");
			rdbtnNewRadioButton_7.setBounds(76, 56, 56, 23);
			rdbtnNewRadioButton_7.addActionListener(new ScreeningCriteriaListener("失误"));
			add(rdbtnNewRadioButton_7);

			JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("分钟");
			rdbtnNewRadioButton_8.setBounds(146, 6, 56, 23);
			rdbtnNewRadioButton_8.addActionListener(new ScreeningCriteriaListener("分钟"));
			add(rdbtnNewRadioButton_8);

			JRadioButton radioButton = new JRadioButton("效率");
			radioButton.setBounds(146, 31, 56, 23);
			radioButton.addActionListener(new ScreeningCriteriaListener("效率"));
			add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("投篮");
			radioButton_1.setBounds(146, 56, 56, 23);
			radioButton_1.addActionListener(new ScreeningCriteriaListener("投篮"));
			add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("三分");
			radioButton_2.setBounds(216, 6, 56, 23);
			radioButton_2.addActionListener(new ScreeningCriteriaListener("三分"));
			add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("罚球");
			radioButton_3.setBounds(216, 31, 56, 23);
			radioButton_3.addActionListener(new ScreeningCriteriaListener("罚球"));
			add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("两双");
			radioButton_4.setBounds(216, 56, 56, 23);
			radioButton_4.addActionListener(new ScreeningCriteriaListener("两双"));
			add(radioButton_4);

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
				System.out.println("筛选标准选择出错");
				break;
			}
			
		}
	}

}
