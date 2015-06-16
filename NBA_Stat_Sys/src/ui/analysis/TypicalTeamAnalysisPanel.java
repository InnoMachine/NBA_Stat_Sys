package ui.analysis;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JLabel tablelbl;
	String team;
	String currentPicCriteria = "";
	ChartPanelMake cpm = new ChartPanelMake();
	TableGet tg = new TableGet();
	chiquareout kfdatas = new chiquareout();
	regAnalysisout regdatas=new regAnalysisout();
	JPanel firstChartPanel;
	JPanel secondChartPanel;
	JPanel thirdChartPanel;
	JComboBox<String> seasonjcb;
	String season = "";
	JComboBox<String> sampleNumjcb;
	String sampleNum = "40";

	public TypicalTeamAnalysisPanel(JFrame mainFrame, String team,
			JPanel previousPanel) {

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

		tablelbl = new JLabel();
		tablelbl.setBounds(X * 183 / 1366, Y * 100 / 768, X * 1000 / 1366,
				Y * 550 / 768);
		tablelbl.setVisible(false);
		this.add(tablelbl);

		picturebtn = new MyButton("数据变化");
		picturebtn.setBounds(X * 183 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		picturebtn.addActionListener(e -> {
			showPicture();
		});
		this.add(picturebtn);

		kfTablebtn = new MyButton("");
		kfTablebtn.setBounds(X * 333 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		kfTablebtn.addActionListener(e -> {
			showkfTable();
		});
		this.add(kfTablebtn);
		
		regTablebtn = new MyButton("");
		regTablebtn.setBounds(X * 483 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		regTablebtn.addActionListener(e -> {
			showkfTable();
		});
		this.add(regTablebtn);
		
		varTablebtn = new MyButton("");
		varTablebtn.setBounds(X * 633 / 1366, Y * 70 / 768, X * 150 / 1366,
				Y * 30 / 768);
		varTablebtn.addActionListener(e -> {
			showkfTable();
		});
		this.add(varTablebtn);

		mainFrame.add(this);
	}

	public void showPicture() {
		tablelbl.setVisible(false);
		picturelbl.setVisible(true);

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
		tablelbl.setVisible(true);

		JLabel seasonlbl = new MyLabel(Color.WHITE, "赛季");
		seasonlbl.setBounds(6, 70, 70, 23);
		tablelbl.add(seasonlbl);

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
		tablelbl.add(seasonjcb);

		JLabel sampleNumlbl = new MyLabel(Color.WHITE, "样本数");
		sampleNumlbl.setBounds(6, 160, 70, 23);
		tablelbl.add(sampleNumlbl);

		Vector<String> sampleNums = new Vector<String>();
		sampleNums.addElement("40");
		sampleNums.addElement("60");
		sampleNums.addElement("All");
		sampleNumjcb = new JComboBox<String>(sampleNums);
		sampleNumjcb.setBounds(X * 6 / 1366, Y * 190 / 768, X * 70 / 1366,
				Y * 28 / 768);
		sampleNumjcb.setSelectedItem("40");
		sampleNumjcb.setForeground(Color.WHITE);
		sampleNumjcb.setBackground(Color.DARK_GRAY);
		sampleNumjcb.addActionListener(e -> {
			sampleNum = String.valueOf(sampleNumjcb.getSelectedItem());
			createChart2(1);

		});
		tablelbl.add(sampleNumjcb);

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
		secondChartPanel.setBounds(200, 10, 700, 350);
		tablelbl.add(secondChartPanel);
		/*
		JTable kfTable = new JTable(kfdatas.ni.length + 1, 6) { // 设置jtable的单元格为透明的
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
		kfTable.setRowHeight(120 / 5);

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

			a.add(kfdatas.fengzu[i]);
			a.add(kfdatas.qujian[i]);
			a.add(String.valueOf(kfdatas.ni[i]));
			a.add(String.valueOf(kfdatas.pi[i]));
			a.add(String.valueOf(kfdatas.npi[i]));
			a.add(String.valueOf(kfdatas.zuihou[i]));

			rowData.add(a);
		}
		model.setDataVector(rowData, columnName);

		kfTable.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		kfTable.setDefaultRenderer(Object.class, tcr);
		kfTable.setBounds(200, 380, 700, 120);
		kfTable.setForeground(Color.WHITE);
		kfTable.setEnabled(false);
		kfTable.setOpaque(false);
		kfTable.setVisible(true);
		tablelbl.add(kfTable);
		*/
	}

	public void createChart3(int i) {
		regdatas = tg.getRegAnalysisout(1, team, season);
		if (thirdChartPanel != null) {
			thirdChartPanel.setVisible(false);
		}
		thirdChartPanel = new JPanel();
		thirdChartPanel = kfdatas.cp;
		thirdChartPanel.setBounds(200, 10, 700, 350);
		tablelbl.add(thirdChartPanel);
		
		JTable kfTable = new JTable(4, 7) { // 设置jtable的单元格为透明的
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
		kfTable.setRowHeight(120 / 4);

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

			a.add(kfdatas.fengzu[i]);
			a.add(kfdatas.qujian[i]);
			a.add(String.valueOf(kfdatas.ni[i]));
			a.add(String.valueOf(kfdatas.pi[i]));
			a.add(String.valueOf(kfdatas.npi[i]));
			a.add(String.valueOf(kfdatas.zuihou[i]));

			rowData.add(a);
		}
		model.setDataVector(rowData, columnName);

		kfTable.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样
		kfTable.setDefaultRenderer(Object.class, tcr);
		kfTable.setBounds(200, 380, 700, 120);
		kfTable.setForeground(Color.WHITE);
		kfTable.setEnabled(false);
		kfTable.setOpaque(false);
		kfTable.setVisible(true);
		tablelbl.add(kfTable);
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
