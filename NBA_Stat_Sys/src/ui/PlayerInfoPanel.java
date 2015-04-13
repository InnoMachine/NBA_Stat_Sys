package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import ui.ShowPanel.MyTextField;
import vo.PlayerVo;

public class PlayerInfoPanel extends JPanel {
	
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
	
	private DefaultTableModel dtm;
	private JScrollPane infoJSP;
	private JTable infoTable;
	
	private Vector<String> historicalDataColumn;
	private Vector<String> currentDataColumn;
	private Vector<Vector<String>> historicalData;
	private Vector<Vector<String>> currentData;
	
	Player_BS player_BS = new Player_BL_Stub();
	
	public PlayerInfoPanel(String PlayerName,JFrame mainFrame) {
		
		this.playerName=PlayerName;
		this.setBounds(0, 0, 1000, 1000);
		this.setVisible(true);
		this.setLayout(null);
		X = this.getWidth();
		Y = this.getHeight();

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		
//		playerPortrait=new JLabel();
//		playerPortrait.setOpaque(false);
////		playerPortrait.setBounds(x, y, width, height);
//		ImageIcon portrait=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(playerPortrait.getWidth(), playerPortrait.getHeight(), Image.SCALE_SMOOTH));
//		playerPortrait.setIcon(portrait);
//		bgLabel.add(playerPortrait);
		
//		playerAction=new JLabel();
//		playerAction.setOpaque(false);
////		playerAction.setBounds(x, y, width, height);
//		ImageIcon action=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(playerAction.getWidth(), playerAction.getHeight(), Image.SCALE_SMOOTH));
//		playerAction.setIcon(action);
//		bgLabel.add(playerAction);
		
		JButton close = new JButton();
		ImageIcon closeIcon=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
		close.setBounds(19*X/20,Y/18, X/25,X/25);
		close.setIcon(closeIcon);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		bgLabel.add(close);
		
		historicalDataColumn=new Vector<String>();
		historicalDataColumn.add("");
		
		currentDataColumn=new Vector<String>();
		currentDataColumn.add("");
		
		dtm=new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		infoTable=new JTable(dtm);
		infoJSP = new JScrollPane(infoTable);
		infoJSP.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
				Y * 600 / 768);
		infoJSP.setVisible(true);
		bgLabel.add(infoJSP);

		
		addBasicInfo();
//		addHistoricalData();
//		addCurrentData();

	}

	private void addHistoricalData(){
		dtm.setDataVector(historicalDataColumn, historicalData);
	}
	
	private void addCurrentData(){
		dtm.setDataVector(currentDataColumn, currentData);
	}
	
	private void addBasicData(){
		PlayerVo one=player_BS.getPlayerByName(playerName);
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
		
		int tempX = 2 * X / 11;
		int tempY = 27 * Y / 100;
		int spaceX = X / 10;
		int spaceY = Y / 18;

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

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setColumns(10);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
