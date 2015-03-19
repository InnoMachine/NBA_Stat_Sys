package ui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class PlayerCardPanel extends JPanel {
	private JTextField txtA;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	public PlayerCardPanel(String name, String criteria,String criteriaValue, String number,
			String position, String height, String weight, String birth,
			String age, String exp, String school) {
		this.setVisible(true);
		this.setLayout(null);

		JLabel lblNewLabel = new JLabel("Picture");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 6, 99, 80);
		add(lblNewLabel);

		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(6, 6, 63, 80);
		add(lblNumber);

		JLabel label = new JLabel("姓名");
		label.setBounds(170, 10, 54, 15);
		add(label);

		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText(name);
		txtA.setEditable(false);
		txtA.setBounds(204, 6, 184, 23);
		add(txtA);
		txtA.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setText(criteria);
		lblNewLabel_1.setBounds(444, 10, 54, 15);
		add(lblNewLabel_1);

		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setText(criteriaValue);
		textField_8.setEditable(false);
		textField_8.setBounds(508, 6, 76, 23);
		add(textField_8);
		textField_8.setColumns(10);

		JLabel label_1 = new JLabel("球衣号码");
		label_1.setBounds(530, 40, 54, 15);
		add(label_1);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setText(number);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(588, 36, 70, 23);
		add(textField_4);

		JLabel label_2 = new JLabel("位置");
		label_2.setBounds(410, 40, 35, 15);
		add(label_2);

		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText(position);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(444, 36, 72, 23);
		add(textField_6);

		JLabel label_3 = new JLabel("身高");
		label_3.setBounds(170, 40, 35, 15);
		add(label_3);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(height);
		textField.setEditable(false);
		textField.setBounds(204, 36, 72, 23);
		add(textField);
		textField.setColumns(10);

		JLabel label_4 = new JLabel("体重");
		label_4.setBounds(290, 40, 35, 15);
		add(label_4);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText(weight);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(324, 36, 72, 23);
		add(textField_2);

		JLabel label_5 = new JLabel("生日");
		label_5.setBounds(170, 70, 35, 15);
		add(label_5);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText(birth);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(204, 66, 72, 23);
		add(textField_1);

		JLabel label_6 = new JLabel("年龄");
		label_6.setBounds(290, 70, 35, 15);
		add(label_6);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText(age);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(324, 66, 72, 23);
		add(textField_3);

		JLabel label_7 = new JLabel("球龄");
		label_7.setBounds(410, 70, 35, 15);
		add(label_7);

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setText(exp);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(444, 66, 72, 23);
		add(textField_5);

		JLabel label_8 = new JLabel("毕业学校");
		label_8.setBounds(530, 70, 54, 15);
		add(label_8);

		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setText(school);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(588, 66, 70, 23);
		add(textField_7);

	}
}
