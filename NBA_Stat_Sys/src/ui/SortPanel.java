package ui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.AbstractCellEditor;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class SortPanel extends JPanel {
	private JTextField criteriatF;
	JFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;
	Vector<Vector<String>> rowData;
	private Vector<String> columnNames;

	public SortPanel(String category, JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		JLabel criterialbl = new JLabel("排序依据");
		criterialbl.setBounds(99, 37, 57, 15);
		this.add(criterialbl);

		criteriatF = new JTextField();
		criteriatF.setBounds(158, 34, 287, 21);
		this.add(criteriatF);
		criteriatF.setColumns(10);

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
			columnNames.add("具体信息");
			

			
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
			columnNames.add("具体信息");
		
		
		
			
			
		
		}

	

		mainFrame.add(this);

	}

	public void sortPlayer() {

		
		rowData = new Vector<Vector<String>>();
//		Vector<String> test=new Vector<String>();
//		test.add(null);
//		test.add(null);
//		test.add(null);
//		test.add(null);			
//		rowData.add(test);
		
		
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		table.getColumn("具体信息").setCellEditor(new MyRender());
		table.getColumn("具体信息").setCellRenderer(new MyRender());
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);
	
	}

	public void showTopFifty() {

		rowData = new Vector<Vector<String>>();
//		Vector<String> test=new Vector<String>();
//		test.add(null);
//		test.add(null);
//		test.add(null);
//		test.add(null);			
//		rowData.add(test);
		
		
		
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		table.getColumn("具体信息").setCellEditor(new MyRender());
		table.getColumn("具体信息").setCellRenderer(new MyRender());
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
//		Vector<String> test=new Vector<String>();
//		test.add(null);
//		test.add(null);
//		test.add(null);
//		test.add(null);			
//		rowData.add(test);
		
		
		
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		table.getColumn("具体信息").setCellEditor(new MyRender());
		table.getColumn("具体信息").setCellRenderer(new MyRender());
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);

	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.add(sp);
	}
}

class MyRender extends AbstractCellEditor implements TableCellRenderer,
		ActionListener, TableCellEditor {

	private static final long serialVersionUID = 1L;
	private JButton button = null;

	public MyRender() {
		button = new JButton();
		button.addActionListener(this);
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
        //show the player's details
 		
		
		
		
		
		
		
		
		

	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return button;
	}

}
