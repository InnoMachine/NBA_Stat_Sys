package ui;

import java.awt.Color;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField txtGmsc;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_69;
	
	public SearchPanel(String category,JFrame mainFrame){
		this.mainFrame=mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		
		JButton backbtn = new JButton("返回");
		backbtn.setBounds(0, 2, 73, 23);
		backbtn.addActionListener(e -> back());
		this.add(backbtn);
		
		
		JButton teambtn_1 = new JButton();
		teambtn_1.setVerticalTextPosition(SwingConstants.BOTTOM);
		teambtn_1.setHorizontalTextPosition(SwingConstants.CENTER);
		teambtn_1.setText("!!!");
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
		rightbtn.setBounds(600, 26, 42, 59);
		add(rightbtn);
		
		JButton playerbtn_1 = new JButton("");
		playerbtn_1.setBounds(38, 97, 62, 50);
		add(playerbtn_1);
		
		JButton playerbtn_2 = new JButton("");
		playerbtn_2.setBounds(38, 158, 62, 50);
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
			
			JButton teambtn1 = new JButton("!!!!");
			
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
		textField_1.setText("姓名");
		textField_1.setBounds(181, 116, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText("体重");
		textField_2.setEditable(false);
		textField_2.setBounds(181, 137, 66, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setText("年龄");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(181, 158, 66, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setEditable(false);
		textField_4.setBounds(247, 116, 66, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setBounds(247, 137, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setBounds(247, 158, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText("生日");
		textField_7.setEditable(false);
		textField_7.setBounds(313, 116, 66, 21);
		add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setText("球龄");
		textField_8.setEditable(false);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBounds(313, 137, 66, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setEditable(false);
		textField_9.setBounds(379, 116, 66, 21);
		add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setEditable(false);
		textField_10.setBounds(379, 137, 66, 21);
		add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("位置");
		textField_11.setEditable(false);
		textField_11.setBounds(445, 116, 66, 21);
		add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setText("球衣号码");
		textField_12.setEditable(false);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBounds(445, 137, 66, 21);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setEditable(false);
		textField_13.setBounds(511, 116, 66, 21);
		add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setEditable(false);
		textField_14.setBounds(511, 137, 66, 21);
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setText("毕业院校");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setEditable(false);
		textField_15.setBounds(445, 158, 66, 21);
		add(textField_15);
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBounds(511, 158, 66, 21);
		add(textField_16);
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setEditable(false);
		textField_17.setText("参赛场数");
		textField_17.setBounds(181, 179, 66, 21);
		add(textField_17);
		textField_17.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setEditable(false);
		textField_18.setBounds(247, 179, 66, 21);
		add(textField_18);
		textField_18.setColumns(10);
		
		textField_19 = new JTextField();
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setText("先发场数");
		textField_19.setEditable(false);
		textField_19.setBounds(313, 179, 66, 21);
		add(textField_19);
		textField_19.setColumns(10);
		
		textField_20 = new JTextField();
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setEditable(false);
		textField_20.setBounds(379, 179, 66, 21);
		add(textField_20);
		textField_20.setColumns(10);
		
		textField_21 = new JTextField();
		textField_21.setHorizontalAlignment(SwingConstants.CENTER);
		textField_21.setText("篮板数");
		textField_21.setEditable(false);
		textField_21.setBounds(181, 200, 66, 21);
		add(textField_21);
		textField_21.setColumns(10);
		
		textField_22 = new JTextField();
		textField_22.setHorizontalAlignment(SwingConstants.CENTER);
		textField_22.setEditable(false);
		textField_22.setBounds(379, 347, 66, 21);
		add(textField_22);
		textField_22.setColumns(10);
		
		textField_23 = new JTextField();
		textField_23.setHorizontalAlignment(SwingConstants.CENTER);
		textField_23.setText("助攻数");
		textField_23.setEditable(false);
		textField_23.setBounds(313, 200, 66, 21);
		add(textField_23);
		textField_23.setColumns(10);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setHorizontalAlignment(SwingConstants.CENTER);
		textField_24.setBounds(247, 200, 66, 21);
		add(textField_24);
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		textField_25.setText("在场时间");
		textField_25.setHorizontalAlignment(SwingConstants.CENTER);
		textField_25.setEditable(false);
		textField_25.setBounds(181, 221, 66, 21);
		add(textField_25);
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		textField_26.setHorizontalAlignment(SwingConstants.CENTER);
		textField_26.setEditable(false);
		textField_26.setBounds(379, 200, 66, 21);
		add(textField_26);
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		textField_27.setText("投篮命中率");
		textField_27.setHorizontalAlignment(SwingConstants.CENTER);
		textField_27.setEditable(false);
		textField_27.setBounds(313, 219, 66, 21);
		add(textField_27);
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		textField_28.setText("三分命中率");
		textField_28.setHorizontalAlignment(SwingConstants.CENTER);
		textField_28.setEditable(false);
		textField_28.setBounds(181, 242, 66, 21);
		add(textField_28);
		textField_28.setColumns(10);
		
		textField_29 = new JTextField();
		textField_29.setText("罚球命中率");
		textField_29.setHorizontalAlignment(SwingConstants.CENTER);
		textField_29.setEditable(false);
		textField_29.setBounds(313, 242, 66, 21);
		add(textField_29);
		textField_29.setColumns(10);
		
		textField_30 = new JTextField();
		textField_30.setHorizontalAlignment(SwingConstants.CENTER);
		textField_30.setEditable(false);
		textField_30.setBounds(247, 221, 66, 21);
		add(textField_30);
		textField_30.setColumns(10);
		
		textField_31 = new JTextField();
		textField_31.setEditable(false);
		textField_31.setHorizontalAlignment(SwingConstants.CENTER);
		textField_31.setBounds(379, 368, 66, 21);
		add(textField_31);
		textField_31.setColumns(10);
		
		textField_32 = new JTextField();
		textField_32.setHorizontalAlignment(SwingConstants.CENTER);
		textField_32.setEditable(false);
		textField_32.setBounds(379, 221, 66, 21);
		add(textField_32);
		textField_32.setColumns(10);
		
		textField_33 = new JTextField();
		textField_33.setText("进攻数");
		textField_33.setEditable(false);
		textField_33.setHorizontalAlignment(SwingConstants.CENTER);
		textField_33.setBounds(181, 263, 66, 21);
		add(textField_33);
		textField_33.setColumns(10);
		
		textField_34 = new JTextField();
		textField_34.setEditable(false);
		textField_34.setHorizontalAlignment(SwingConstants.CENTER);
		textField_34.setBounds(247, 368, 66, 21);
		add(textField_34);
		textField_34.setColumns(10);
		
		textField_35 = new JTextField();
		textField_35.setText("防守数");
		textField_35.setHorizontalAlignment(SwingConstants.CENTER);
		textField_35.setEditable(false);
		textField_35.setBounds(313, 263, 66, 21);
		add(textField_35);
		textField_35.setColumns(10);
		
		textField_36 = new JTextField();
		textField_36.setHorizontalAlignment(SwingConstants.CENTER);
		textField_36.setEditable(false);
		textField_36.setBounds(247, 242, 66, 21);
		add(textField_36);
		textField_36.setColumns(10);
		
		textField_37 = new JTextField();
		textField_37.setText("抢断数");
		textField_37.setHorizontalAlignment(SwingConstants.CENTER);
		textField_37.setEditable(false);
		textField_37.setBounds(181, 284, 66, 21);
		add(textField_37);
		textField_37.setColumns(10);
		
		textField_38 = new JTextField();
		textField_38.setHorizontalAlignment(SwingConstants.CENTER);
		textField_38.setEditable(false);
		textField_38.setBounds(379, 242, 66, 21);
		add(textField_38);
		textField_38.setColumns(10);
		
		textField_39 = new JTextField();
		textField_39.setText("盖帽数");
		textField_39.setHorizontalAlignment(SwingConstants.CENTER);
		textField_39.setEditable(false);
		textField_39.setBounds(313, 284, 66, 21);
		add(textField_39);
		textField_39.setColumns(10);
		
		textField_40 = new JTextField();
		textField_40.setHorizontalAlignment(SwingConstants.CENTER);
		textField_40.setEditable(false);
		textField_40.setBounds(247, 389, 66, 21);
		add(textField_40);
		textField_40.setColumns(10);
		
		textField_41 = new JTextField();
		textField_41.setText("失误数");
		textField_41.setEditable(false);
		textField_41.setHorizontalAlignment(SwingConstants.CENTER);
		textField_41.setBounds(181, 305, 66, 21);
		add(textField_41);
		textField_41.setColumns(10);
		
		textField_42 = new JTextField();
		textField_42.setHorizontalAlignment(SwingConstants.CENTER);
		textField_42.setEditable(false);
		textField_42.setBounds(247, 263, 66, 21);
		add(textField_42);
		textField_42.setColumns(10);
		
		textField_43 = new JTextField();
		textField_43.setText("犯规数");
		textField_43.setEditable(false);
		textField_43.setHorizontalAlignment(SwingConstants.CENTER);
		textField_43.setBounds(313, 305, 66, 21);
		add(textField_43);
		textField_43.setColumns(10);
		
		textField_44 = new JTextField();
		textField_44.setHorizontalAlignment(SwingConstants.CENTER);
		textField_44.setEditable(false);
		textField_44.setBounds(379, 263, 66, 21);
		add(textField_44);
		textField_44.setColumns(10);
		
		textField_45 = new JTextField();
		textField_45.setText("得分");
		textField_45.setHorizontalAlignment(SwingConstants.CENTER);
		textField_45.setEditable(false);
		textField_45.setBounds(181, 326, 66, 21);
		add(textField_45);
		textField_45.setColumns(10);
		
		textField_46 = new JTextField();
		textField_46.setText("效率");
		textField_46.setHorizontalAlignment(SwingConstants.CENTER);
		textField_46.setEditable(false);
		textField_46.setBounds(313, 326, 66, 21);
		add(textField_46);
		textField_46.setColumns(10);
		
		txtGmsc = new JTextField();
		txtGmsc.setText("GmSc效率值");
		txtGmsc.setHorizontalAlignment(SwingConstants.CENTER);
		txtGmsc.setEditable(false);
		txtGmsc.setBounds(181, 347, 66, 21);
		add(txtGmsc);
		txtGmsc.setColumns(10);
		
		textField_47 = new JTextField();
		textField_47.setEditable(false);
		textField_47.setHorizontalAlignment(SwingConstants.CENTER);
		textField_47.setBounds(247, 284, 66, 21);
		add(textField_47);
		textField_47.setColumns(10);
		
		textField_48 = new JTextField();
		textField_48.setText("真实命中率");
		textField_48.setHorizontalAlignment(SwingConstants.CENTER);
		textField_48.setEditable(false);
		textField_48.setBounds(313, 347, 66, 21);
		add(textField_48);
		textField_48.setColumns(10);
		
		textField_49 = new JTextField();
		textField_49.setHorizontalAlignment(SwingConstants.CENTER);
		textField_49.setEditable(false);
		textField_49.setBounds(379, 284, 66, 21);
		add(textField_49);
		textField_49.setColumns(10);
		
		textField_50 = new JTextField();
		textField_50.setText("投篮效率");
		textField_50.setHorizontalAlignment(SwingConstants.CENTER);
		textField_50.setEditable(false);
		textField_50.setBounds(181, 368, 66, 21);
		add(textField_50);
		textField_50.setColumns(10);
		
		textField_51 = new JTextField();
		textField_51.setHorizontalAlignment(SwingConstants.CENTER);
		textField_51.setEditable(false);
		textField_51.setBounds(247, 410, 66, 21);
		add(textField_51);
		textField_51.setColumns(10);
		
		textField_52 = new JTextField();
		textField_52.setText("篮板率");
		textField_52.setHorizontalAlignment(SwingConstants.CENTER);
		textField_52.setEditable(false);
		textField_52.setBounds(313, 368, 66, 21);
		add(textField_52);
		textField_52.setColumns(10);
		
		textField_53 = new JTextField();
		textField_53.setEditable(false);
		textField_53.setHorizontalAlignment(SwingConstants.CENTER);
		textField_53.setBounds(247, 305, 66, 21);
		add(textField_53);
		textField_53.setColumns(10);
		
		textField_54 = new JTextField();
		textField_54.setText("进攻篮板率");
		textField_54.setHorizontalAlignment(SwingConstants.CENTER);
		textField_54.setEditable(false);
		textField_54.setBounds(445, 368, 66, 21);
		add(textField_54);
		textField_54.setColumns(10);
		
		textField_55 = new JTextField();
		textField_55.setHorizontalAlignment(SwingConstants.CENTER);
		textField_55.setEditable(false);
		textField_55.setBounds(379, 305, 66, 21);
		add(textField_55);
		textField_55.setColumns(10);
		
		textField_56 = new JTextField();
		textField_56.setText("防守篮板率");
		textField_56.setHorizontalAlignment(SwingConstants.CENTER);
		textField_56.setEditable(false);
		textField_56.setBounds(181, 389, 66, 21);
		add(textField_56);
		textField_56.setColumns(10);
		
		textField_57 = new JTextField();
		textField_57.setHorizontalAlignment(SwingConstants.CENTER);
		textField_57.setEditable(false);
		textField_57.setBounds(379, 410, 66, 21);
		add(textField_57);
		textField_57.setColumns(10);
		
		textField_58 = new JTextField();
		textField_58.setText("助攻率");
		textField_58.setHorizontalAlignment(SwingConstants.CENTER);
		textField_58.setEditable(false);
		textField_58.setBounds(313, 389, 66, 21);
		add(textField_58);
		textField_58.setColumns(10);
		
		textField_59 = new JTextField();
		textField_59.setHorizontalAlignment(SwingConstants.CENTER);
		textField_59.setEditable(false);
		textField_59.setBounds(247, 326, 66, 21);
		add(textField_59);
		textField_59.setColumns(10);
		
		textField_60 = new JTextField();
		textField_60.setText("抢断率");
		textField_60.setEditable(false);
		textField_60.setHorizontalAlignment(SwingConstants.CENTER);
		textField_60.setBounds(445, 389, 66, 21);
		add(textField_60);
		textField_60.setColumns(10);
		
		textField_61 = new JTextField();
		textField_61.setHorizontalAlignment(SwingConstants.CENTER);
		textField_61.setEditable(false);
		textField_61.setBounds(379, 326, 66, 21);
		add(textField_61);
		textField_61.setColumns(10);
		
		textField_62 = new JTextField();
		textField_62.setText("盖帽率");
		textField_62.setEditable(false);
		textField_62.setHorizontalAlignment(SwingConstants.CENTER);
		textField_62.setBounds(181, 410, 66, 21);
		add(textField_62);
		textField_62.setColumns(10);
		
		textField_63 = new JTextField();
		textField_63.setHorizontalAlignment(SwingConstants.CENTER);
		textField_63.setEditable(false);
		textField_63.setBounds(379, 389, 66, 21);
		add(textField_63);
		textField_63.setColumns(10);
		
		textField_64 = new JTextField();
		textField_64.setText("失误率");
		textField_64.setHorizontalAlignment(SwingConstants.CENTER);
		textField_64.setEditable(false);
		textField_64.setBounds(313, 410, 66, 21);
		add(textField_64);
		textField_64.setColumns(10);
		
		textField_65 = new JTextField();
		textField_65.setEnabled(true);
		textField_65.setEditable(false);
		textField_65.setText("");
		textField_65.setBounds(247, 347, 66, 21);
		add(textField_65);
		textField_65.setColumns(10);
		
		textField_66 = new JTextField();
		textField_66.setText("使用率");
		textField_66.setHorizontalAlignment(SwingConstants.CENTER);
		textField_66.setEditable(false);
		textField_66.setBounds(445, 410, 66, 21);
		add(textField_66);
		textField_66.setColumns(10);
		
		textField_67 = new JTextField();
		textField_67.setEditable(false);
		textField_67.setHorizontalAlignment(SwingConstants.CENTER);
		textField_67.setBounds(379, 347, 66, 21);
		add(textField_67);
		textField_67.setColumns(10);
		
		textField_68 = new JTextField();
		textField_68.setBounds(445, 178, 132, 190);
		add(textField_68);
		textField_68.setColumns(10);
		
		textField_70 = new JTextField();
		textField_70.setHorizontalAlignment(SwingConstants.CENTER);
		textField_70.setEditable(false);
		textField_70.setBounds(511, 389, 66, 21);
		add(textField_70);
		textField_70.setColumns(10);
		
		textField_71 = new JTextField();
		textField_71.setHorizontalAlignment(SwingConstants.CENTER);
		textField_71.setEditable(false);
		textField_71.setBounds(511, 410, 66, 21);
		add(textField_71);
		textField_71.setColumns(10);
		
		textField_69 = new JTextField();
		textField_69.setHorizontalAlignment(SwingConstants.CENTER);
		textField_69.setEditable(false);
		textField_69.setBounds(511, 368, 66, 21);
		add(textField_69);
		textField_69.setColumns(10);

	}
	public void back(){
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}
}
