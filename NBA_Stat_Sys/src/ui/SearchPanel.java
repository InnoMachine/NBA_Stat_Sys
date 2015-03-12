package ui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class SearchPanel extends JPanel{
	
	JFrame mainFrame;
	private JTextField textField;
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
	
	public SearchPanel(String category,JFrame mainFrame){
		this.mainFrame=mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		
		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e -> back());
		this.add(backbtn);
		
		
		JButton teambtn_1 = new JButton("");
		teambtn_1.setBounds(169, 26, 59, 59);
		add(teambtn_1);
		
		JButton teambtn_2 = new JButton("");
		teambtn_2.setBounds(230, 26, 59, 59);
		add(teambtn_2);
		
		JButton teambtn_3 = new JButton("");
		teambtn_3.setBounds(291, 26, 59, 59);
		add(teambtn_3);
		
		JButton teambtn_4 = new JButton("");
		teambtn_4.setBounds(352, 26, 59, 59);
		add(teambtn_4);
		
		JButton teambtn_5 = new JButton("");
		teambtn_5.setBounds(413, 26, 59, 59);
		add(teambtn_5);
		
		JButton teambtn_6 = new JButton("");
		teambtn_6.setBounds(474, 26, 59, 59);
		add(teambtn_6);
		
		JButton teambtn_7 = new JButton("");
		teambtn_7.setBounds(535, 26, 59, 59);
		add(teambtn_7);
		
		JButton leftbtn = new JButton("L");
		leftbtn.setBounds(121, 26, 42, 59);
		add(leftbtn);
		
		JButton rightbtn = new JButton("R");
		rightbtn.setBounds(604, 26, 42, 59);
		add(rightbtn);
		
		JButton playerbtn_1 = new JButton("");
		playerbtn_1.setBounds(38, 97, 59, 59);
		add(playerbtn_1);
		
		JButton playerbtn_2 = new JButton("");
		playerbtn_2.setBounds(38, 158, 59, 59);
		add(playerbtn_2);
		
		JButton playerbtn_3 = new JButton("");
		playerbtn_3.setBounds(38, 219, 59, 59);
		add(playerbtn_3);
		
		JButton playerbtn_4 = new JButton("");
		playerbtn_4.setBounds(38, 341, 59, 59);
		add(playerbtn_4);
		
		JButton playerbtn_5 = new JButton("");
		playerbtn_5.setBounds(38, 280, 59, 59);
		add(playerbtn_5);
		
		JButton leftbtn_1 = new JButton("L");
		leftbtn_1.setBounds(38, 53, 59, 38);
		add(leftbtn_1);
		
		JButton rightbtn_1 = new JButton("R");
		rightbtn_1.setBounds(38, 403, 59, 38);
		add(rightbtn_1);
		
		
		if(category=="player"){
			
				
			
		}
		if(category=="team"){
			textField = new JTextField();
			textField.setText("                                                                                 信息区");
			textField.setBounds(74, 107, 555, 319);
			add(textField);
			textField.setColumns(10);
			
			JButton teambtn1 = new JButton("");
			teambtn1.setBounds(138, 26, 63, 59);
			add(teambtn1);
			
			JButton teambtn2 = new JButton("");
			teambtn2.setBounds(199, 26, 63, 59);
			add(teambtn2);
			
			JButton teambtn3 = new JButton("");
			teambtn3.setBounds(260, 26, 63, 59);
			add(teambtn3);
			
			JButton teambtn4 = new JButton("");
			teambtn4.setBounds(321, 26, 63, 59);
			add(teambtn4);
			
			JButton teambtn5 = new JButton("");
			teambtn5.setBounds(382, 26, 63, 59);
			add(teambtn5);
			
			JButton teambtn6 = new JButton("");
			teambtn6.setBounds(443, 26, 63, 59);
			add(teambtn6);
			
			JButton teambtn7 = new JButton("");
			teambtn7.setBounds(504, 26, 63, 59);
			add(teambtn7);
			
			JButton leftbtn1 = new JButton("L");
			leftbtn1.setBounds(91, 26, 42, 59);
			add(leftbtn1);
			
			JButton rightbtn1 = new JButton("R");
			rightbtn1.setBounds(573, 26, 42, 59);
			add(rightbtn1);
			
		}
		mainFrame.getContentPane().add(this);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("身高");
		textField_1.setBounds(131, 116, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("体重");
		textField_2.setEditable(false);
		textField_2.setBounds(131, 137, 66, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("年龄");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(131, 158, 66, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setBounds(197, 116, 66, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setBounds(197, 137, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setBounds(197, 158, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("生日");
		textField_7.setEditable(false);
		textField_7.setBounds(263, 116, 66, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("球龄");
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(263, 137, 66, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setBounds(329, 116, 66, 21);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setBounds(329, 137, 66, 21);
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("位置");
		textField_11.setEditable(false);
		textField_11.setBounds(395, 116, 66, 21);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setText("球衣号码");
		textField_12.setEditable(false);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(395, 137, 66, 21);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setBounds(461, 116, 66, 21);
		add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setBounds(461, 137, 66, 21);
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setText("毕业院校");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setBounds(263, 158, 66, 21);
		add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBounds(329, 158, 198, 21);
		add(textField_16);
		textField_16.setColumns(10);

	}
	public void back(){
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}
}
