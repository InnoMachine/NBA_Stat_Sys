package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

import vo.PlayerVo;

public class PlayerCardPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MyTextField txtA;
	private MyTextField textField;
	private MyTextField textField_1;
	private MyTextField textField_2;
	private MyTextField textField_3;
	private MyTextField textField_4;
	private MyTextField textField_5;
	private MyTextField textField_6;
	private MyTextField textField_7;
	private MyTextField textField_8;

	private PlayerVo playerInfo;
	private String criteria;
	private String criteriaValue;
	int X;
	int Y;
	int number;

	public PlayerCardPanel(int number, int X, int Y, PlayerVo playerInfo,
			String criteria, String criteriaValue) {
		this.X = X;
		this.Y = Y;
		this.number = number;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerInfo = playerInfo;
		this.criteria = criteria;
		this.criteriaValue = criteriaValue;
	}

	public void fillPanel() {

		JLabel lblNumber = null;
		if (number == 1) {
			lblNumber = new JLabel(String.valueOf(number) + "st");
		} else if (number == 2) {
			lblNumber = new JLabel(String.valueOf(number) + "nd");
		} else if (number == 3) {
			lblNumber = new JLabel(String.valueOf(number) + "rd");
		} else if (number > 3) {
			lblNumber = new JLabel(String.valueOf(number) + "th");
		} else {
//			System.out.println("球员名片显示中的排名Bug！！！" + number);
		}
		lblNumber.setBounds(X * 6 / 1366, Y * 6 / 768, X * 63 / 1366,
				Y * 108 / 768);
		lblNumber.setOpaque(true);
		lblNumber.setBackground(Color.gray);
		if (number < 4) {
			lblNumber.setFont(new java.awt.Font("Dialog", 1, 25));
			lblNumber.setForeground(Color.yellow);
		} else {
			lblNumber.setFont(new java.awt.Font("Dialog", 1, 18));
		}
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNumber);

		// 放球员头像
		JButton playerButton = new JButton();
		playerButton.setBounds(X * 77 / 1366, Y * 6 / 768, X * 134 / 1366,
				Y * 108 / 768);
		playerButton.setContentAreaFilled(false);
		playerButton.setBorderPainted(false);
		playerButton.setOpaque(false);
		add(playerButton);
		
		
		ImageIcon playerPortrait;
		if (hasPortrait(playerInfo.getName() + ".png")) {
			playerPortrait = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + playerInfo.getName() + ".png").getImage().getScaledInstance(
							X * 134 / 1366,
							Y * 108 / 768, Image.SCALE_AREA_AVERAGING));
		} else {
			playerPortrait = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + "DefaultPortrait" + ".png")
					.getImage().getScaledInstance(X * 134 / 1366,
							Y * 108 / 768,
							Image.SCALE_AREA_AVERAGING));
		}
		

		playerButton.setIcon(playerPortrait);
		
		
		
		

		MyLabel label = new MyLabel(Color.WHITE, "姓名");
		label.setBounds(X * 220 / 1366, Y * 21 / 768, X * 54 / 1366,
				Y * 15 / 768);
		add(label);

		txtA = new MyTextField(Color.WHITE);
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText(playerInfo.getName());
		txtA.setEditable(false);
		txtA.setBounds(X * 254 / 1366, Y * 17 / 768, X * 184 / 1366,
				Y * 23 / 768);
		add(txtA);
		txtA.setColumns(10);

		MyLabel lblNewLabel_1 = new MyLabel(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setText(criteria);
		lblNewLabel_1.setBounds(X * 529 / 1366, Y * 21 / 768, X * 90 / 1366,
				Y * 15 / 768);
		add(lblNewLabel_1);

		textField_8 = new MyTextField(Color.WHITE);
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setText(criteriaValue);
		textField_8.setEditable(false);
		textField_8.setBounds(X * 626 / 1366, Y * 17 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_8);
		textField_8.setColumns(10);

		MyLabel label_1 = new MyLabel(Color.WHITE, "球衣号码");
		label_1.setBounds(X * 670 / 1366, Y * 56 / 768, X * 60 / 1366,
				Y * 15 / 768);
		add(label_1);

		textField_4 = new MyTextField(Color.WHITE);
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText(String.valueOf(playerInfo.getNumber()));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(X * 728 / 1366, Y * 52 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_4);

		MyLabel label_2 = new MyLabel(Color.WHITE, "位置");
		label_2.setBounds(X * 520 / 1366, Y * 56 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_2);

		textField_6 = new MyTextField(Color.WHITE);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText(playerInfo.getPosition());
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(X * 554 / 1366, Y * 52 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_6);

		MyLabel label_3 = new MyLabel(Color.WHITE, "身高");
		label_3.setBounds(X * 220 / 1366, Y * 56 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_3);

		textField = new MyTextField(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(playerInfo.getHeight());
		textField.setEditable(false);
		textField.setBounds(X * 254 / 1366, Y * 52 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField);
		textField.setColumns(10);

		MyLabel label_4 = new MyLabel(Color.WHITE, "体重");
		label_4.setBounds(X * 370 / 1366, Y * 56 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_4);

		textField_2 = new MyTextField(Color.WHITE);
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText(playerInfo.getWeight());
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(X * 404 / 1366, Y * 52 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_2);

		MyLabel label_5 = new MyLabel(Color.WHITE, "生日");
		label_5.setBounds(X * 220 / 1366, Y * 91 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_5);

		textField_1 = new MyTextField(Color.WHITE);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText(playerInfo.getBirth());
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(X * 254 / 1366, Y * 87 / 768, X * 90 / 1366,
				Y * 23 / 768);
		textField_1.setFont(new Font("黑体",1,11));
		add(textField_1);

		MyLabel label_6 = new MyLabel(Color.WHITE, "年龄");
		label_6.setBounds(X * 370 / 1366, Y * 91 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_6);

		textField_3 = new MyTextField(Color.WHITE);
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText(String.valueOf(playerInfo.getAge()));
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(X * 404 / 1366, Y * 87 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_3);

		MyLabel label_7 = new MyLabel(Color.WHITE, "球龄");
		label_7.setBounds(X * 520 / 1366, Y * 91 / 768, X * 35 / 1366,
				Y * 15 / 768);
		add(label_7);

		textField_5 = new MyTextField(Color.WHITE);
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText(String.valueOf(playerInfo.getExp()));
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(X * 554 / 1366, Y * 87 / 768, X * 80 / 1366,
				Y * 23 / 768);
		add(textField_5);

		MyLabel label_8 = new MyLabel(Color.WHITE, "毕业学校");
		label_8.setBounds(X * 670 / 1366, Y * 91 / 768, X * 60 / 1366,
				Y * 15 / 768);
		add(label_8);

		textField_7 = new MyTextField(Color.WHITE);
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText(playerInfo.getSchool());
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(X * 728 / 1366, Y * 87 / 768, X * 160 / 1366,
				Y * 23 / 768);
		textField_7.setFont(new Font("黑体",1,9));
		add(textField_7);

	}

	public PlayerVo getPlayerInfo() {
		return playerInfo;
	}

	public String getCriteria() {
		return criteria;
	}

	public String getCriteriaValue() {
		return criteriaValue;
	}
	public boolean hasAction(String actionPath) {
		boolean hasAction = false;
		File actionFile = new File("CSEdata/players/action//");
		String action[];
		action = actionFile.list();
		for (int i = 0; i < action.length; i++) {
			if (actionPath.equals(action[i])) {
				hasAction = true;
				break;
			}
		}
		return hasAction;
	}

	public boolean hasPortrait(String portraitPath) {
		boolean hasPortrait = false;
		File portraitFile = new File("CSEdata/players/portrait//");
		String portrait[];
		portrait = portraitFile.list();
		for (int i = 0; i < portrait.length; i++) {
			if (portraitPath.equals(portrait[i])) {
				hasPortrait = true;
				break;
			}
		}
		return hasPortrait;
	}
	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 13));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
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
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 13));

		}
	}
}
