package ui.analysis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import ui.MainFrame;
import ui.StartPanel;
import vo.chiquareout;
import vo.regAnalysisout;
import vo.varAnakysisout;
import businessLogic.ChartPanelMake;
import businessLogic.TableGet;

public class TypicalTeamAnalysisPanel extends JPanel {
	JFrame mainFrame;

	static int X;
	static int Y;
	JLabel bgLabel;
	JPanel previousPanel;
	JButton picturebtn;
	JButton kfTablebtn;
	JButton regTablebtn;
	JButton varTablebtn;
	JLabel picturelbl;
	JLabel chartlbl;
	JLabel table1lbl;
	JLabel table2lbl;
	JLabel table3lbl;
	String team;
	String currentPicCriteria = "";
	ChartPanelMake cpm = new ChartPanelMake();
	TableGet tg = new TableGet();
	chiquareout kfdatas = new chiquareout();
	varAnakysisout vardatas = new varAnakysisout();
	regAnalysisout regdatas = new regAnalysisout();
	JPanel firstChartPanel;
	JPanel secondChartPanel;
	JPanel thirdChartPanel;
	JPanel fourthChartPanel;
	JComboBox<String> seasonjcb;
	String season = "";
	JComboBox<String> sampleNumjcb;
	String sampleNum = "40";
	JTable kfTable;
	JTable regTable;
	JTable varTable1;
	JTable varTable2;
	DecimalFormat df;
	JLabel callbl1;
	JLabel callbl2;
	JLabel callbl3;

	public TypicalTeamAnalysisPanel(JFrame mainFrame, String team,
			JPanel previousPanel) {

		df = new DecimalFormat("0.0000");
		this.mainFrame = mainFrame;
		this.team = team;
		this.previousPanel = previousPanel;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		/*
		 * bgLabel = new JLabel(); bgLabel.setBounds(0, 0, X, Y);
		 * 
		 * this.add(bgLabel);
		 */
		this.setBackground(Color.BLACK);

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
		this.add(home);

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
		this.add(back);

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

		this.add(minimize);

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
		this.add(close);

		JLabel teamlbl = new JLabel();
		teamlbl.setBounds(0, 670, 1366, 80);
		teamlbl.setVisible(true);

		ImageIcon teamIcon = new ImageIcon(new ImageIcon("Image/teamstrip/"
				+ team + ".png").getImage().getScaledInstance(1366, 80,
				Image.SCALE_SMOOTH));
		teamlbl.setIcon(teamIcon);

		// teamlbl.setBackground(Color.BLUE);
		teamlbl.setOpaque(true);
		this.add(teamlbl);

		picturelbl = new JLabel();
		picturelbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		picturelbl.setVisible(false);
		this.add(picturelbl);

		table1lbl = new JLabel();
		table1lbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		table1lbl.setVisible(false);
		this.add(table1lbl);

		table2lbl = new JLabel();
		table2lbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		table2lbl.setVisible(false);
		this.add(table2lbl);

		table3lbl = new JLabel();
		table3lbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		table3lbl.setVisible(false);
		this.add(table3lbl);

		picturebtn = new MyButton("数据变化");
		picturebtn.setBounds(X * 183 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		picturebtn.addActionListener(e -> {
			showPicture();
		});
		this.add(picturebtn);

		kfTablebtn = new MyButton("卡方非参检验");
		kfTablebtn.setBounds(X * 333 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		kfTablebtn.addActionListener(e -> {
			showkfTable();
		});
		this.add(kfTablebtn);

		varTablebtn = new MyButton("单因素方差分析");
		varTablebtn.setBounds(X * 483 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		varTablebtn.addActionListener(e -> {
			showvarTable();
		});
		this.add(varTablebtn);

		regTablebtn = new MyButton("回归分析");
		regTablebtn.setBounds(X * 633 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		regTablebtn.addActionListener(e -> {
			showregTable();
		});
		this.add(regTablebtn);

		mainFrame.add(this);
	}

	public void showPicture() {
		picturelbl.setVisible(true);
		table1lbl.setVisible(false);
		table2lbl.setVisible(false);
		table3lbl.setVisible(false);

		ButtonGroup bg = new ButtonGroup();

		MyRadioButton pic1 = new MyRadioButton("场均得分");
		pic1.setBounds(6, 70, 110, 23);
		pic1.addActionListener(e -> {
			createChart1(1);
		});
		picturelbl.add(pic1);
		bg.add(pic1);

		MyRadioButton pic2 = new MyRadioButton("进攻回合数");
		pic2.setBounds(X * 6 / 1366, Y * 105 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic2.addActionListener(e -> {
			createChart1(2);
		});
		picturelbl.add(pic2);
		bg.add(pic2);

		MyRadioButton pic3 = new MyRadioButton("场均助攻");
		pic3.setBounds(X * 6 / 1366, Y * 140 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic3.addActionListener(e -> {
			createChart1(3);
		});
		picturelbl.add(pic3);
		bg.add(pic3);

		MyRadioButton pic4 = new MyRadioButton("场均罚球数");
		pic4.setBounds(X * 6 / 1366, Y * 175 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic4.addActionListener(e -> {
			createChart1(4);
		});
		picturelbl.add(pic4);
		bg.add(pic4);

		MyRadioButton pic5 = new MyRadioButton("三分占得分比");
		pic5.setBounds(X * 6 / 1366, Y * 210 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic5.addActionListener(e -> {
			createChart1(5);

		});
		picturelbl.add(pic5);
		bg.add(pic5);

		MyRadioButton pic6 = new MyRadioButton("助攻出手比");
		pic6.setBounds(X * 6 / 1366, Y * 245 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic6.addActionListener(e -> {
			createChart1(6);
		});
		picturelbl.add(pic6);
		bg.add(pic6);

		MyRadioButton pic7 = new MyRadioButton("首发得分方差");
		pic7.setBounds(X * 6 / 1366, Y * 280 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic7.addActionListener(e -> {
			createChart1(7);
		});
		picturelbl.add(pic7);
		bg.add(pic7);

		MyRadioButton pic8 = new MyRadioButton("胜率变化");
		pic8.setBounds(X * 6 / 1366, Y * 315 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic8.addActionListener(e -> {
			createChart1(8);
		});
		picturelbl.add(pic8);
		bg.add(pic8);

		MyRadioButton pic9 = new MyRadioButton("进攻效率");
		pic9.setBounds(X * 6 / 1366, Y * 350 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic9.addActionListener(e -> {
			createChart1(9);
		});
		picturelbl.add(pic9);
		bg.add(pic9);

		MyRadioButton pic10 = new MyRadioButton("防守效率");
		pic10.setBounds(X * 6 / 1366, Y * 385 / 768, X * 110 / 1366,
				Y * 23 / 768);
		pic10.addActionListener(e -> {
			createChart1(10);
		});
		picturelbl.add(pic10);
		bg.add(pic10);

	}

	public void showkfTable() {
		picturelbl.setVisible(false);
		table1lbl.setVisible(true);
		table2lbl.setVisible(false);
		table3lbl.setVisible(false);

		JLabel seasonlbl = new MyLabel(Color.WHITE, "赛季");
		seasonlbl.setBounds(6, 70, 70, 23);
		table1lbl.add(seasonlbl);

		Vector<String> seasons = new Vector<String>();
		seasons.addElement("14-15");
		seasons.addElement("13-14");
		seasons.addElement("12-13");
		seasons.addElement("11-12");
		seasons.addElement("10-11");
		seasons.addElement("09-10");
		seasons.addElement("08-09");
		seasons.addElement("07-08");
		seasons.addElement("06-07");
		seasons.addElement("05-06");
		seasons.addElement("04-05");
		seasons.addElement("03-04");
		seasons.addElement("02-03");
		seasons.addElement("01-02");
		seasons.addElement("00-01");
		seasonjcb = new JComboBox<String>(seasons);
		seasonjcb.setBounds(X * 6 / 1366, Y * 100 / 768, X * 70 / 1366,
				Y * 28 / 768);
		seasonjcb.setSelectedItem("13-14");
		seasonjcb.setForeground(Color.WHITE);
		seasonjcb.setBackground(Color.DARK_GRAY);
		seasonjcb.addActionListener(e -> {
			season = String.valueOf(seasonjcb.getSelectedItem());
			createChart2(1);

		});
		table1lbl.add(seasonjcb);

		JLabel sampleNumlbl = new MyLabel(Color.WHITE, "样本数");
		sampleNumlbl.setBounds(6, 160, 70, 23);
		table1lbl.add(sampleNumlbl);

		Vector<String> sampleNums = new Vector<String>();
		sampleNums.addElement("40");
		sampleNums.addElement("60");
		sampleNums.addElement("All");
		sampleNumjcb = new JComboBox<String>(sampleNums);
		sampleNumjcb.setBounds(X * 6 / 1366, Y * 190 / 768, X * 70 / 1366,
				Y * 28 / 768);
		sampleNumjcb.setForeground(Color.WHITE);
		sampleNumjcb.setBackground(Color.DARK_GRAY);
		sampleNumjcb.addActionListener(e -> {
			sampleNum = String.valueOf(sampleNumjcb.getSelectedItem());
			createChart2(1);

		});
		table1lbl.add(sampleNumjcb);

	}

	public void showvarTable() {
		picturelbl.setVisible(false);
		table1lbl.setVisible(false);
		table2lbl.setVisible(true);
		table3lbl.setVisible(false);

		JLabel seasonlbl = new MyLabel(Color.WHITE, "赛季");
		seasonlbl.setBounds(6, 70, 70, 23);
		table2lbl.add(seasonlbl);

		Vector<String> seasons = new Vector<String>();
		seasons.addElement("14-15");
		seasons.addElement("13-14");
		seasons.addElement("12-13");
		seasons.addElement("11-12");
		seasons.addElement("10-11");
		seasons.addElement("09-10");
		seasons.addElement("08-09");
		seasons.addElement("07-08");
		seasons.addElement("06-07");
		seasons.addElement("05-06");
		seasons.addElement("04-05");
		seasons.addElement("03-04");
		seasons.addElement("02-03");
		seasons.addElement("01-02");
		seasons.addElement("00-01");
		seasonjcb = new JComboBox<String>(seasons);
		seasonjcb.setBounds(X * 6 / 1366, Y * 100 / 768, X * 70 / 1366,
				Y * 28 / 768);
		seasonjcb.setSelectedItem("13-14");
		seasonjcb.setForeground(Color.WHITE);
		seasonjcb.setBackground(Color.DARK_GRAY);
		seasonjcb.addActionListener(e -> {
			season = String.valueOf(seasonjcb.getSelectedItem());
			createChart3(1);

		});
		table2lbl.add(seasonjcb);


	}

	public void showregTable() {
		picturelbl.setVisible(false);
		table1lbl.setVisible(false);
		table2lbl.setVisible(false);
		table3lbl.setVisible(true);

		JLabel seasonlbl = new MyLabel(Color.WHITE, "赛季");
		seasonlbl.setBounds(6, 70, 70, 23);
		table3lbl.add(seasonlbl);

		Vector<String> seasons = new Vector<String>();
		seasons.addElement("14-15");
		seasons.addElement("13-14");
		seasons.addElement("12-13");
		seasons.addElement("11-12");
		seasons.addElement("10-11");
		seasons.addElement("09-10");
		seasons.addElement("08-09");
		seasons.addElement("07-08");
		seasons.addElement("06-07");
		seasons.addElement("05-06");
		seasons.addElement("04-05");
		seasons.addElement("03-04");
		seasons.addElement("02-03");
		seasons.addElement("01-02");
		seasons.addElement("00-01");
		seasonjcb = new JComboBox<String>(seasons);
		seasonjcb.setBounds(X * 6 / 1366, Y * 100 / 768, X * 70 / 1366,
				Y * 28 / 768);
		seasonjcb.setSelectedItem("13-14");
		seasonjcb.setForeground(Color.WHITE);
		seasonjcb.setBackground(Color.DARK_GRAY);
		seasonjcb.addActionListener(e -> {
			season = String.valueOf(seasonjcb.getSelectedItem());
			createChart4(1);

		});
		table3lbl.add(seasonjcb);

	}

	public void createChart1(int i) {

		if (firstChartPanel != null) {
			firstChartPanel.setVisible(false);
		}
		firstChartPanel = new JPanel();
		firstChartPanel = cpm.getLineChartPanel(i, team);
		firstChartPanel.setBounds(170, 50, 700, 450);
		picturelbl.add(firstChartPanel);

	}

	public void createChart2(int i) {

		kfdatas = tg.getChiquareout(1, team, season, sampleNum);

		if (secondChartPanel != null) {
			secondChartPanel.setVisible(false);
		}
		secondChartPanel = new JPanel();
		secondChartPanel = kfdatas.cp;
		secondChartPanel.setBounds(200, 5, 700, 350);
		table1lbl.add(secondChartPanel);

		if (kfTable != null) {
			kfTable.setVisible(false);
		}
		kfTable = new JTable(kfdatas.ni.length + 1, 6) { // 设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		;
		kfTable.setRowHeight(120 / (kfdatas.ni.length + 1));

		DefaultTableModel model = new DefaultTableModel();
		Vector<String> columnName = new Vector<String>();
		columnName.add("分组");
		columnName.add("区间");
		columnName.add("ni");
		columnName.add("pi");
		columnName.add("npi");
		columnName.add("ni^2/npi");
		Vector<Vector> rowData = new Vector<Vector>();

		rowData.add(columnName);
		for (int j = 0; j < kfdatas.ni.length; j++) {
			Vector<String> a = new Vector<String>();

			a.add(kfdatas.fengzu[j]);
			a.add(kfdatas.qujian[j]);
			a.add(String.valueOf(kfdatas.ni[j]));
			a.add(df.format(kfdatas.pi[j]));
			a.add(df.format(kfdatas.npi[j]));
			a.add(df.format(kfdatas.zuihou[j]));

			rowData.add(a);
		}
		model.setDataVector(rowData, columnName);

		kfTable.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		kfTable.setDefaultRenderer(Object.class, tcr);
		kfTable.setBounds(200, 355, 700, 120);
		kfTable.setForeground(Color.WHITE);
		kfTable.setEnabled(false);
		kfTable.setOpaque(false);
		kfTable.setVisible(true);
		table1lbl.add(kfTable);

		if (callbl1 != null) {
			callbl1.setVisible(false);
		}
		callbl1 = new JLabel("X^2=" + df.format(kfdatas.kafang) + "    查表值："
				+ df.format(kfdatas.biaozhi) + "    均值："
				+ df.format(kfdatas.mean) + "    方差：" + df.format(kfdatas.var),
				JLabel.CENTER);
		callbl1.setBounds(200, 480, 700, 20);
		callbl1.setOpaque(false);
		callbl1.setForeground(Color.WHITE);
		callbl1.setFont(new Font("微软雅黑", 1, 16));
		callbl1.setVisible(true);
		table1lbl.add(callbl1);
		table1lbl.setVisible(false);
		table1lbl.setVisible(true);
	}

	public void createChart3(int i) {

		vardatas = tg.getVarAnakysisout(1, team);

		varTable1 = new JTable(6, 7) { // 设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		;
		varTable1.setRowHeight(180 / 6);
		DefaultTableModel model = new DefaultTableModel();
		Vector<String> columnName = new Vector<String>();
		columnName.add("方差来源");
		columnName.add("偏差平方和");
		columnName.add("自由度");
		columnName.add("方差");
		columnName.add("F值");
		columnName.add("Fα");
		columnName.add("显著性");
		Vector<Vector> rowData = new Vector<Vector>();
		
		Vector<String> a1 = new Vector<String>();
		a1.add("Ai");
		a1.add("1");
		a1.add("2");
		a1.add("3");
		a1.add("4");
		a1.add("xi");
		a1.add("xi^2");
		rowData.add(a1);

		Vector<String> a2 = new Vector<String>();
		a2.add("A1");
		a2.add(df.format(vardatas.xij[0][0]));
		a2.add(df.format(vardatas.xij[0][1]));
		a2.add(df.format(vardatas.xij[0][2]));
		a2.add(df.format(vardatas.xij[0][3]));
	    a2.add(df.format(vardatas.xi[0]));	
	    a2.add(df.format(vardatas.xi2[0]));
		rowData.add(a2);
		
		Vector<String> a3 = new Vector<String>();
		a3.add("A2");
		a3.add(df.format(vardatas.xij[1][0]));
		a3.add(df.format(vardatas.xij[1][1]));
		a3.add(df.format(vardatas.xij[1][2]));
		a3.add(df.format(vardatas.xij[1][3]));
	    a3.add(df.format(vardatas.xi[1]));	
	    a3.add(df.format(vardatas.xi2[1]));
		rowData.add(a3);
		
		Vector<String> a4 = new Vector<String>();
		a4.add("A3");
		a4.add(df.format(vardatas.xij[2][0]));
		a4.add(df.format(vardatas.xij[2][1]));
		a4.add(df.format(vardatas.xij[2][2]));
		a4.add(df.format(vardatas.xij[2][3]));
	    a4.add(df.format(vardatas.xi[2]));	
	    a4.add(df.format(vardatas.xi2[2]));
		rowData.add(a4);
		
		Vector<String> a5 = new Vector<String>();
		a5.add("A4");
		a5.add(df.format(vardatas.xij[3][0]));
		a5.add(df.format(vardatas.xij[3][1]));
		a5.add(df.format(vardatas.xij[3][2]));
		a5.add(df.format(vardatas.xij[3][3]));
	    a5.add(df.format(vardatas.xi[3]));	
	    a5.add(df.format(vardatas.xi2[3]));
		rowData.add(a5);
		
		Vector<String> a6 = new Vector<String>();
		a6.add("A5");
		a6.add(df.format(vardatas.xij[4][0]));
		a6.add(df.format(vardatas.xij[4][1]));
		a6.add(df.format(vardatas.xij[4][2]));
		a6.add(df.format(vardatas.xij[4][3]));
	    a6.add(df.format(vardatas.xi[4]));	
	    a6.add(df.format(vardatas.xi2[4]));
		rowData.add(a6);
		

		model.setDataVector(rowData, columnName);

		varTable1.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		varTable1.setDefaultRenderer(Object.class, tcr);
		varTable1.setBounds(200, 75, 700, 180);
		varTable1.setForeground(Color.WHITE);
		varTable1.setEnabled(false);
		varTable1.setOpaque(false);
		varTable1.setVisible(true);
		table2lbl.add(varTable1);
		
		varTable2 = new JTable(4, 7) { // 设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		;
		varTable2.setRowHeight(120 / 4);
		DefaultTableModel model2 = new DefaultTableModel();
		Vector<String> columnName2 = new Vector<String>();
		columnName2.add("方差来源");
		columnName2.add("偏差平方和");
		columnName2.add("自由度");
		columnName2.add("方差");
		columnName2.add("F值");
		columnName2.add("Fα");
		columnName2.add("显著性");
		Vector<Vector> rowData2 = new Vector<Vector>();

		Vector<String> a21 = new Vector<String>();
		a21.add("方差来源");
		a21.add("偏差平方和");
		a21.add("自由度");
		a21.add("方差");
		a21.add("F值");
		a21.add("Fα");
		a21.add("显著性");
		rowData2.add(a21);

		Vector<String> a22 = new Vector<String>();
		a22.add("因素（水平间）");
		a22.add(df.format(vardatas.SA));
		a22.add("4");
		a22.add(df.format(vardatas.VA));
		a22.add(df.format(vardatas.F));
	    a22.add(df.format(vardatas.F5));	
	    if (vardatas.F >= vardatas.F1) {
			a22.add("**");
		} else if (vardatas.F >= vardatas.F5 && vardatas.F < vardatas.F1) {
			a22.add("*");
		} else if (vardatas.F < vardatas.F5) {
			a22.add("");
		}
		rowData2.add(a22);
		
		Vector<String> a23 = new Vector<String>();
		a23.add("误差（水平内）");
		a23.add(df.format(vardatas.Se));
		a23.add("15");
		a23.add(df.format(vardatas.Ve));
		a23.add("");
	    a23.add(df.format(vardatas.F1));	
	    a23.add("");
		rowData2.add(a23);
		
		Vector<String> a24 = new Vector<String>();
		a24.add("总和");
		a24.add(df.format(vardatas.ST));
		a24.add("19");
		a24.add("");
		a24.add("");
	    a24.add("");	
	    a24.add("");
		rowData2.add(a24);
		
		model2.setDataVector(rowData2, columnName2);

		varTable2.setModel(model2);
		varTable2.setDefaultRenderer(Object.class, tcr);
		varTable2.setBounds(200, 320, 700, 120);
		varTable2.setForeground(Color.WHITE);
		varTable2.setEnabled(false);
		varTable2.setOpaque(false);
		varTable2.setVisible(true);
		table2lbl.add(varTable2);
		
		
		table2lbl.setVisible(false);
		table2lbl.setVisible(true);
		
		
	}

	public void createChart4(int i) {
		regdatas = tg.getRegAnalysisout(1, team, season);
		if (fourthChartPanel != null) {
			fourthChartPanel.setVisible(false);
		}
		fourthChartPanel = new JPanel();
		fourthChartPanel = regdatas.cp;
		fourthChartPanel.setBounds(200, 5, 700, 350);
		table3lbl.add(fourthChartPanel);

		if (regTable != null) {
			regTable.setVisible(false);
		}
		regTable = new JTable(4, 7) { // 设置jtable的单元格为透明的
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		;
		regTable.setRowHeight(120 / 4);

		DefaultTableModel model = new DefaultTableModel();
		Vector<String> columnName = new Vector<String>();
		columnName.add("方差来源");
		columnName.add("偏差平方和");
		columnName.add("自由度");
		columnName.add("方差");
		columnName.add("F值");
		columnName.add("Fα");
		columnName.add("显著性");
		Vector<Vector> rowData = new Vector<Vector>();
		rowData.add(columnName);

		Vector<String> a1 = new Vector<String>();
		a1.add("回归");
		a1.add(df.format(regdatas.SR));
		a1.add("1");
		a1.add(df.format(regdatas.VR));
		a1.add(df.format(regdatas.F));
		a1.add(df.format(regdatas.F5));
		if (regdatas.F >= regdatas.F1) {
			a1.add("**");
		} else if (regdatas.F >= regdatas.F5 && regdatas.F < regdatas.F1) {
			a1.add("*");
		} else if (regdatas.F < regdatas.F5) {
			a1.add("");
		}
		rowData.add(a1);

		Vector<String> a2 = new Vector<String>();
		a2.add("剩余");
		a2.add(df.format(regdatas.Se));
		a2.add(String.valueOf(regdatas.n - 2));
		a2.add(df.format(regdatas.Ve));
		a2.add("");
		a2.add(df.format(regdatas.F1));
		a2.add("");
		rowData.add(a2);

		Vector<String> a3 = new Vector<String>();
		a3.add("总和");
		a3.add(df.format(regdatas.ST));
		a3.add(String.valueOf(regdatas.n - 1));
		a3.add("");
		a3.add("");
		a3.add("");
		a3.add("");
		rowData.add(a3);

		model.setDataVector(rowData, columnName);

		regTable.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		regTable.setDefaultRenderer(Object.class, tcr);
		regTable.setBounds(200, 355, 700, 120);
		regTable.setForeground(Color.WHITE);
		regTable.setEnabled(false);
		regTable.setOpaque(false);
		regTable.setVisible(true);
		table3lbl.add(regTable);

		if (callbl3 != null) {
			callbl3.setVisible(false);
		}
		callbl3 = new JLabel("y=" + df.format(regdatas.a) + "+"
				+ df.format(regdatas.b) + "x" + "   r^2="
				+ df.format(regdatas.r2) + "   Sy=" + df.format(regdatas.Sy)+"   ρ="+df.format(regdatas.ρ+"   r="+df.format(regdatas.pearson_r)),
				JLabel.CENTER);
		callbl3.setBounds(200, 480, 700, 20);
		callbl3.setOpaque(false);
		callbl3.setForeground(Color.WHITE);
		callbl3.setFont(new Font("微软雅黑", 1, 16));
		callbl3.setVisible(true);
		table3lbl.add(callbl3);

		table3lbl.setVisible(false);
		table3lbl.setVisible(true);
	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame, MainFrame.analysisPanel,
				MainFrame.playerPanel, MainFrame.teamPanel, MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		mainFrame.add(previousPanel);
	}

	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton(String function) {
			super();
			this.setText(function);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑", 1, 15));
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					X * 150 / 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
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

	class MyLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("微软雅黑", 1, 14));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("微软雅黑", 1, 14));

		}
	}
}
