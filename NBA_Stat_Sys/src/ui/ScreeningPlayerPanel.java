package ui;

import java.awt.TextField;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ScreeningPlayerPanel extends JPanel {
	private JTextField screeningtF;
	JFrame mainFrame;
	private String[] positions;
	private String[] leagues;
	private JTable table;
	private JScrollPane scrollPane;
	Vector<Vector<String>> rowData;
	private Vector<String> columnNames;

	public ScreeningPlayerPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		JLabel screeninglbl = new JLabel("筛选依据");
		screeninglbl.setBounds(338, 37, 57, 15);
		this.add(screeninglbl);

		screeningtF = new JTextField();
		screeningtF.setBounds(393, 34, 93, 21);
		this.add(screeningtF);
		screeningtF.setColumns(10);

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
		columnNames.add("具体信息");

		mainFrame.getContentPane().add(this);
		
		JLabel label = new JLabel("球员位置");
		label.setBounds(75, 37, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("球员联盟");
		label_1.setBounds(202, 37, 54, 15);
		add(label_1);
		
		
		positions=new String[4];
		positions[0]="所有";
		positions[1]="前锋";
		positions[2]="中锋";
		positions[3]="后卫";
		JComboBox positionjcb = new JComboBox(positions);
		positionjcb.setBounds(132, 34, 60, 21);
		this.add(positionjcb);
		
		leagues=new String[3];
		leagues[0]="所有";
		leagues[1]="东部";
		leagues[2]="西部";
		JComboBox leaguejcb = new JComboBox(leagues);
		leaguejcb.setBounds(259, 34, 60, 21);
		this.add(leaguejcb);

	}

	public void screening() {
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

		table.getColumn("具体信息").setCellEditor(new MyRender());
		table.getColumn("具体信息").setCellRenderer(new MyRender());
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
	}
}
