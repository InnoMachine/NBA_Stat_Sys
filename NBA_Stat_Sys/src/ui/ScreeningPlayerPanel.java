package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
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
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
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
	JFrame mainFrame;
	private String[] positions;
	private String[] leagues;
	private JTable table;
	private JScrollPane scrollPane;
	JComboBox positionjcb;
	JComboBox leaguejcb;
	ScreeningPlayerCriteriaPanel playerCriteriaPanel;
	Player_BS player_BS = new Player_BL();
	private JButton screeningCriteriabtn;
	Vector<Vector<PlayerCardPanel>> rowData;
	static int X;
	static int Y;
	JLabel bgLabel;

	public ScreeningPlayerPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPanel.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);
		playerCriteriaPanel = new ScreeningPlayerCriteriaPanel(mainFrame, this);
		playerCriteriaPanel.setVisible(false);

		MyLabel screeninglbl = new MyLabel(Color.WHITE, "筛选依据");
		screeninglbl.setFont(new Font("黑体", 1, 13));
		screeninglbl.setBounds(X * 640 / 1366, Y * 66 / 768, X * 60 / 1366,
				X / 50);
		bgLabel.add(screeninglbl);

		screeningCriteriabtn = new JButton("");
		screeningCriteriabtn.setBounds(X * 715 / 1366, Y * 66 / 768,
				X * 213 / 1366, X / 50);
		screeningCriteriabtn.addActionListener(e -> showScreeningCriteria());
		bgLabel.add(screeningCriteriabtn);

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
		

		JButton screeningbtn = new JButton("显示前50名");
		screeningbtn.setBounds(X * 990 / 1366, Y * 66 / 768, X * 103 / 1366,
				X / 50);
		screeningbtn.addActionListener(e -> screening());
		bgLabel.add(screeningbtn);
		mainFrame.getContentPane().add(this);

		MyLabel label = new MyLabel(Color.WHITE, "球员位置");
		label.setFont(new Font("黑体", 1, 13));
		label.setBounds(X * 265 / 1366, Y * 66 / 768, X * 60 / 1366, X / 50);
		bgLabel.add(label);

		MyLabel label_1 = new MyLabel(Color.WHITE, "球员联盟");
		label_1.setFont(new Font("黑体", 1, 13));
		label_1.setBounds(X * 455 / 1366, Y * 66 / 768, X * 60 / 1366, X / 50);
		bgLabel.add(label_1);

		positions = new String[4];
		positions[0] = "所有";
		positions[1] = "前锋";
		positions[2] = "中锋";
		positions[3] = "后卫";
		positionjcb = new JComboBox(positions);
		positionjcb.setBounds(X * 330 / 1366, Y * 66 / 768, X * 100 / 1366,
				X / 50);
		bgLabel.add(positionjcb);

		leagues = new String[7];
		leagues[0] = "所有";
		leagues[1] = "ATLANTIC";
		leagues[2] = "CENTRAL";
		leagues[3] = "SOUTHEAST";
		leagues[4] = "NORTHWEST";
		leagues[5] = "SOUTHWEST";
		leagues[6] = "PACIFIC";
		leaguejcb = new JComboBox(leagues);
		leaguejcb.setBounds(X * 520 / 1366, Y * 66 / 768, X * 100 / 1366,
				X / 50);
		bgLabel.add(leaguejcb);

	}

	public void showScreeningCriteria() {

		playerCriteriaPanel.setVisible(true);

	}

	public void screening() {
		String position = "";
		String league = "";
		String screeningCriteria = "";

		switch (String.valueOf(positionjcb.getSelectedItem())) {
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

		switch (String.valueOf(leaguejcb.getSelectedItem())) {
		case "ATLANTIC":
			league = "ATLANTIC";
			break;
		case "CENTRAL":
			league = "CENTRAL";
			break;
		case "SOUTHEAST":
			league = "SOUTHEAST";
			break;
		case "NORTHWEST":
			league = "NORTHWEST";
			break;
		case "SOUTHWEST":
			league = "SOUTHWEST";
			break;
		case "PACIFIC":
			league = "PACIFIC";
			break;

		case "所有":
			league = "All";
			break;
		default:
			break;
		}

		switch (screeningCriteriabtn.getText()) {
		case "得分":
			screeningCriteria = "score";
			break;
		case "篮板":
			screeningCriteria = "reboundOverall";
			break;
		case "助攻":
			screeningCriteria = "assistance";
			break;
		case "得分/篮板/助攻":
			screeningCriteria = "weighted";
			break;
		case "盖帽":
			screeningCriteria = "block";
			break;
		case "抢断":
			screeningCriteria = "steal";
			break;
		case "犯规":
			screeningCriteria = "foul";
			break;
		case "失误":
			screeningCriteria = "turnover";
			break;
		case "分钟":
			screeningCriteria = "time";
			break;
		case "效率":
			screeningCriteria = "efficiency";
			break;
		case "投篮":
			screeningCriteria = "shotNum";
			break;
		case "三分":
			screeningCriteria = "threePointShotNum";
			break;
		case "罚球":
			screeningCriteria = "freeThrowShotNum";
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
				case "score":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getScore())));

					break;
				case "reboundOverall":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getReboundOverall())));
					break;
				case "assistance":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getAssistance())));
					break;
				case "weighted":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getWeighted())));
					break;
				case "block":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getBlock())));
					break;
				case "steal":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getSteal())));
					break;
				case "foul":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getFoul())));
					break;
				case "turnover":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTurnover())));
					break;
				case "time":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getTime() / 60)));
					break;
				case "efficiency":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getEfficiency())));
					break;
				case "shotNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i).getShotNum())));
					break;
				case "threePointShotNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getThreePointHitNum())));
					break;
				case "freeThrowShotNum":
					a.add(new PlayerCardPanel(i + 1, X, Y, playerVos.get(i),
							screeningCriteriabtn.getText(), String
									.valueOf(playerVos.get(i)
											.getFreeThrowShotNum())));
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
			scrollPane.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
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
			this.setBounds(X * 715 / 1366, Y * 66 / 768 + X / 50,
					X * 213 / 1366, X * 108 / 1366);
			this.setBorder(new TitledBorder(new EtchedBorder()));

			ButtonGroup bg = new ButtonGroup();

			JRadioButton scorebtn = new JRadioButton("得分");
			scorebtn.setBounds(X * 6 / 1366, Y * 6 / 768, X * 51 / 1366,
					Y * 23 / 768);
			scorebtn.addActionListener(new ScreeningCriteriaListener("得分"));
			add(scorebtn);
			bg.add(scorebtn);

			JRadioButton reboundbtn = new JRadioButton("篮板");
			reboundbtn.setBounds(X * 6 / 1366, Y * 31 / 768, X * 51 / 1366,
					Y * 23 / 768);
			reboundbtn.addActionListener(new ScreeningCriteriaListener("篮板"));
			add(reboundbtn);
			bg.add(reboundbtn);

			JRadioButton assistancebtn = new JRadioButton("助攻");
			assistancebtn.setBounds(X * 6 / 1366, Y * 56 / 768, X * 51 / 1366,
					Y * 23 / 768);
			assistancebtn
					.addActionListener(new ScreeningCriteriaListener("助攻"));
			add(assistancebtn);
			bg.add(assistancebtn);

			JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("得分/篮板/助攻");
			rdbtnNewRadioButton_3.setBounds(X * 56 / 1366, Y * 81 / 768,
					X * 150 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_3
					.addActionListener(new ScreeningCriteriaListener("得分/篮板/助攻"));
			add(rdbtnNewRadioButton_3);
			bg.add(rdbtnNewRadioButton_3);

			JRadioButton rdbtnNewRadioButton_4 = new JRadioButton("盖帽");
			rdbtnNewRadioButton_4.setBounds(X * 6 / 1366, Y * 81 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_4
					.addActionListener(new ScreeningCriteriaListener("盖帽"));
			add(rdbtnNewRadioButton_4);
			bg.add(rdbtnNewRadioButton_4);

			JRadioButton rdbtnNewRadioButton_5 = new JRadioButton("抢断");
			rdbtnNewRadioButton_5.setBounds(X * 56 / 1366, Y * 6 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_5
					.addActionListener(new ScreeningCriteriaListener("抢断"));
			add(rdbtnNewRadioButton_5);
			bg.add(rdbtnNewRadioButton_5);

			JRadioButton rdbtnNewRadioButton_6 = new JRadioButton("犯规");
			rdbtnNewRadioButton_6.setBounds(X * 56 / 1366, Y * 31 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_6
					.addActionListener(new ScreeningCriteriaListener("犯规"));
			add(rdbtnNewRadioButton_6);
			bg.add(rdbtnNewRadioButton_6);

			JRadioButton rdbtnNewRadioButton_7 = new JRadioButton("失误");
			rdbtnNewRadioButton_7.setBounds(X * 56 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_7
					.addActionListener(new ScreeningCriteriaListener("失误"));
			add(rdbtnNewRadioButton_7);
			bg.add(rdbtnNewRadioButton_7);

			JRadioButton rdbtnNewRadioButton_8 = new JRadioButton("分钟");
			rdbtnNewRadioButton_8.setBounds(X * 106 / 1366, Y * 6 / 768,
					X * 51 / 1366, Y * 23 / 768);
			rdbtnNewRadioButton_8
					.addActionListener(new ScreeningCriteriaListener("分钟"));
			add(rdbtnNewRadioButton_8);
			bg.add(rdbtnNewRadioButton_8);

			JRadioButton radioButton = new JRadioButton("效率");
			radioButton.setBounds(X * 106 / 1366, Y * 31 / 768, X * 51 / 1366,
					Y * 23 / 768);
			radioButton.addActionListener(new ScreeningCriteriaListener("效率"));
			add(radioButton);
			bg.add(radioButton);

			JRadioButton radioButton_1 = new JRadioButton("投篮");
			radioButton_1.setBounds(X * 106 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_1
					.addActionListener(new ScreeningCriteriaListener("投篮"));
			add(radioButton_1);
			bg.add(radioButton_1);

			JRadioButton radioButton_2 = new JRadioButton("三分");
			radioButton_2.setBounds(X * 156 / 1366, Y * 6 / 768, X * 51 / 1366,
					Y * 23 / 768);
			radioButton_2
					.addActionListener(new ScreeningCriteriaListener("三分"));
			add(radioButton_2);
			bg.add(radioButton_2);

			JRadioButton radioButton_3 = new JRadioButton("罚球");
			radioButton_3.setBounds(X * 156 / 1366, Y * 31 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_3
					.addActionListener(new ScreeningCriteriaListener("罚球"));
			add(radioButton_3);
			bg.add(radioButton_3);

			JRadioButton radioButton_4 = new JRadioButton("两双");
			radioButton_4.setBounds(X * 156 / 1366, Y * 56 / 768,
					X * 51 / 1366, Y * 23 / 768);
			radioButton_4
					.addActionListener(new ScreeningCriteriaListener("两双"));
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
			renderer.setOpaque(false);
			// TODO Auto-generated method stub
			return renderer;

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
