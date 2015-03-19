package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import ui.SearchPanel.PlayerTableRenderer;
import vo.PlayerVo;

public class ScreeningPlayerPanel extends JPanel {
	JFrame mainFrame;
	private String[] positions;
	private String[] leagues;
	private JTable table;
	private JScrollPane scrollPane;
	JComboBox positionjcb;
	JComboBox leaguejcb;
	ScreeningPlayerCriteriaPanel playerCriteriaPanel;
	Player_BS player_BS=new Player_BL_Stub();
	private JButton screeningCriteriabtn;
	static int X;
	static int Y;
	
	public ScreeningPlayerPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X=mainFrame.getWidth();
		Y=mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		playerCriteriaPanel = new ScreeningPlayerCriteriaPanel(mainFrame, this);
		playerCriteriaPanel.setVisible(false);
		
		JLabel screeninglbl = new JLabel("筛选依据");
		screeninglbl.setBounds(355, 37, 57, 15);
		this.add(screeninglbl);

		screeningCriteriabtn = new JButton("");
		screeningCriteriabtn.setBounds(409, 33, 120, 23);
		screeningCriteriabtn.addActionListener(e -> showScreeningCriteria());
		add(screeningCriteriabtn);

		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e -> back());
		this.add(backbtn);

		JButton screeningbtn = new JButton("显示前50名");
		screeningbtn.setBounds(537, 33, 103, 23);
		screeningbtn.addActionListener(e -> screening());
		add(screeningbtn);


		mainFrame.getContentPane().add(this);

		JLabel label = new JLabel("球员位置");
		label.setBounds(60, 37, 54, 15);
		add(label);

		JLabel label_1 = new JLabel("球员联盟");
		label_1.setBounds(187, 37, 54, 15);
		add(label_1);

		positions = new String[4];
		positions[0] = "所有";
		positions[1] = "前锋";
		positions[2] = "中锋";
		positions[3] = "后卫";
		positionjcb = new JComboBox(positions);
		positionjcb.setBounds(117, 34, 60, 21);
		this.add(positionjcb);

		leagues = new String[7];
		leagues[0] = "所有";
		leagues[1] = "ATLANTIC";
		leagues[2] = "CENTRAL";
		leagues[3] = "SOUTHEAST";
		leagues[4] = "NORTHWEST";
		leagues[5] = "SOUTHWEST";
		leagues[6] = "PACIFIC";
		leaguejcb = new JComboBox(leagues);
		leaguejcb.setBounds(244, 34, 100, 21);
		this.add(leaguejcb);





	}

	public void showScreeningCriteria() {

		playerCriteriaPanel.setVisible(true);

	}

	public void screening() {
		String position="";
		String league="";
		String screeningCriteria="";
		

		switch (String.valueOf(positionjcb.getSelectedItem())) {
		case "前锋":
			position="F";
			break;
		case "中锋":
			position="C";
			break;
		case "后卫":
			position="G";
			break;
		case "所有":
			position="All";
			break;
		default:
			break;
		}

		switch (String.valueOf(leaguejcb.getSelectedItem())) {
		case "ATLANTIC":
			league="ATLANTIC";
			break;
		case "CENTRAL":
		    league="CENTRAL";
			break;
		case "SOUTHEAST":
			league="SOUTHEAST";
			break;
		case "NORTHWEST":
			league="NORTHWEST";
			break;
		case "SOUTHWEST":
			league="SOUTHWEST";
			break;
		case "PACIFIC":
			league="PACIFIC";
			break;
			
		case "所有":
			league="All";
			break;
		default:
			break;
		}
		
		
		
		switch (screeningCriteriabtn.getText()) {
		case "得分":
			screeningCriteria="score";
			break;
		case "篮板":
			screeningCriteria="reboundOverall";
			break;
		case "助攻":
			screeningCriteria="assistance";
			break;
		case "得分/篮板/助攻":
			screeningCriteria="weighted";
			break;
		case "盖帽":
			screeningCriteria="block";
			break;
		case "抢断":
			screeningCriteria="steal";
			break;
		case "犯规":
			screeningCriteria="foul";
			break;
		case "失误":
			screeningCriteria="turnover";
			break;
		case "分钟":
			screeningCriteria="time";
			break;
		case "效率":
			screeningCriteria="efficiency";
			break;
		case "投篮":
			screeningCriteria="hitNum";
			break;
		case "三分":
			screeningCriteria="threePointShotNum";
			break;
		case "罚球":
			screeningCriteria="freeThrowShotNum";
			break;
        case "两双":
        	screeningCriteria="twoTenNum";
			break;	
		default:
			break;
		}
		
		
		Vector<Vector<PlayerCardPanel>> rowData=new Vector<Vector<PlayerCardPanel>>();
		Vector<PlayerCardPanel> a=new Vector<PlayerCardPanel>();
		a.add(new PlayerCardPanel());
		rowData.add(a);
		Vector<PlayerCardPanel> b=new Vector<PlayerCardPanel>();
		b.add(new PlayerCardPanel());
		rowData.add(b);
		Vector<PlayerCardPanel> c=new Vector<PlayerCardPanel>();
		c.add(new PlayerCardPanel());
		rowData.add(c);
		Vector<PlayerCardPanel> d=new Vector<PlayerCardPanel>();
		d.add(new PlayerCardPanel());
		rowData.add(d);
		
		
		
		Vector<String> column=new Vector<String>();
		column.add("");
		DefaultTableModel dtm=new DefaultTableModel(rowData,column)
		{
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		}
		;
		table=new JTable(dtm);
		DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
		tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		table.setRowHeight(Y/8);
		table.setVisible(true);
		table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0)
		.setCellRenderer(new PlayerCardRenderer());
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(X/4, Y/4, X/2, Y/2);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
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
			this.setBounds(423, 56, 213, 108);

			ButtonGroup bg=new ButtonGroup();
			
			JRadioButton scorebtn = new JRadioButton("得分");
			scorebtn.setBounds(6, 6, 51, 23);
			scorebtn.addActionListener(new ScreeningCriteriaListener("得分"));
			add(scorebtn);
			bg.add(scorebtn);

			JRadioButton reboundbtn = new JRadioButton("篮板");
			reboundbtn.setBounds(6, 31, 51, 23);
			reboundbtn.addActionListener(new ScreeningCriteriaListener("篮板"));
			add(reboundbtn);
			bg.add(reboundbtn);

			JRadioButton assistancebtn = new JRadioButton("助攻");
			assistancebtn.setBounds(6, 56, 51, 23);
			assistancebtn.addActionListener(new ScreeningCriteriaListener("助攻"));
			add(assistancebtn);
			bg.add(assistancebtn);

			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("得分/篮板/助攻");
			rdbtnNewRadioButton_3.setBounds(56, 81, 150, 23);
			rdbtnNewRadioButton_3.addActionListener(new ScreeningCriteriaListener("得分/篮板/助攻"));
			add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("盖帽");
			rdbtnNewRadioButton_4.setBounds(6, 81, 51, 23);
			rdbtnNewRadioButton_4.addActionListener(new ScreeningCriteriaListener("盖帽"));
			add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("抢断");
			rdbtnNewRadioButton_5.setBounds(56, 6, 51, 23);
			rdbtnNewRadioButton_5.addActionListener(new ScreeningCriteriaListener("抢断"));
			add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("犯规");
			rdbtnNewRadioButton_6.setBounds(56, 31, 51, 23);
			rdbtnNewRadioButton_6.addActionListener(new ScreeningCriteriaListener("犯规"));
			add(rdbtnNewRadioButton_6);
			bg.add(rdbtnNewRadioButton_6);

			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("失误");
			rdbtnNewRadioButton_7.setBounds(56, 56, 51, 23);
			rdbtnNewRadioButton_7.addActionListener(new ScreeningCriteriaListener("失误"));
			add(rdbtnNewRadioButton_7);
			bg.add(rdbtnNewRadioButton_7);

			JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("分钟");
			rdbtnNewRadioButton_8.setBounds(106, 6, 51, 23);
			rdbtnNewRadioButton_8.addActionListener(new ScreeningCriteriaListener("分钟"));
			add(rdbtnNewRadioButton_8);
			bg.add(rdbtnNewRadioButton_8);
			
			JRadioButton radioButton = new JRadioButton("效率");
			radioButton.setBounds(106, 31, 51, 23);
			radioButton.addActionListener(new ScreeningCriteriaListener("效率"));
			add(radioButton);
			bg.add(radioButton);
			
			JRadioButton radioButton_1 = new JRadioButton("投篮");
			radioButton_1.setBounds(106, 56, 51, 23);
			radioButton_1.addActionListener(new ScreeningCriteriaListener("投篮"));
			add(radioButton_1);
			bg.add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("三分");
			radioButton_2.setBounds(156, 6, 51, 23);
			radioButton_2.addActionListener(new ScreeningCriteriaListener("三分"));
			add(radioButton_2);
			bg.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("罚球");
			radioButton_3.setBounds(156, 31, 51, 23);
			radioButton_3.addActionListener(new ScreeningCriteriaListener("罚球"));
			add(radioButton_3);
			bg.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("两双");
			radioButton_4.setBounds(156, 56, 51, 23);
			radioButton_4.addActionListener(new ScreeningCriteriaListener("两双"));
			add(radioButton_4);
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
	
	//class: TableRenderer
	class PlayerCardRenderer extends PlayerCardPanel implements TableCellRenderer{

		public PlayerCardRenderer() {
			super();
			
			// TODO Auto-generated constructor stub
		}

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			
			this.setBackground(Color.GRAY);
			// TODO Auto-generated method stub
			return this;
		}
		
	}
}
