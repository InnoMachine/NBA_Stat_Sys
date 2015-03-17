package ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TeamCardPanel extends JPanel{
	private JTextField txtA;
	private JTextField textField;
	private JTextField txtAaaaaaaaa;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtAaaaaaaaaaaaaaa;
	private JTextField textField_6;
	private JTextField textField_8;
	public TeamCardPanel() {
		this.setBounds(0, 0, 674, 94);
		this.setVisible(true);
		this.setLayout(null);
		
		JLabel label = new JLabel("球队全名");
		label.setBounds(170, 10, 55, 15);
		add(label);
		
		JLabel label_2 = new JLabel("赛区");
		label_2.setBounds(470, 40, 55, 15);
		add(label_2);
		
		JLabel label_3 = new JLabel("缩写");
		label_3.setBounds(170, 40, 35, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("所在地");
		label_4.setBounds(310, 40, 46, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("分区");
		label_5.setBounds(170, 70, 35, 15);
		add(label_5);
		
		JLabel label_6 = new JLabel("主场");
		label_6.setBounds(310, 70, 35, 15);
		add(label_6);
		
		JLabel label_7 = new JLabel("建立时间");
		label_7.setBounds(470, 70, 55, 15);
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("Picture");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 6, 99, 80);
		add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(6, 6, 63, 80);
		add(lblNumber);
		
		txtA = new JTextField();
		txtA.setEditable(false);
		txtA.setBounds(233, 6, 120, 23);
		add(txtA);
		txtA.setColumns(10);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setBounds(204, 36, 80, 23);
		add(textField);
		textField.setColumns(10);
		
		txtAaaaaaaaa = new JTextField();
		txtAaaaaaaaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAaaaaaaaa.setEditable(false);
		txtAaaaaaaaa.setColumns(10);
		txtAaaaaaaaa.setBounds(204, 66, 80, 23);
		add(txtAaaaaaaaa);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(354, 36, 80, 23);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(355, 66, 110, 23);
		add(textField_3);
		
		txtAaaaaaaaaaaaaaa = new JTextField();
		txtAaaaaaaaaaaaaaa.setHorizontalAlignment(SwingConstants.CENTER);
		txtAaaaaaaaaaaaaaa.setEditable(false);
		txtAaaaaaaaaaaaaaa.setColumns(10);
		txtAaaaaaaaaaaaaaa.setBounds(528, 66, 80, 23);
		add(txtAaaaaaaaaaaaaaa);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(528, 36, 80, 23);
		add(textField_6);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setBounds(528, 6, 80, 23);
		add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("(依据)");
		lblNewLabel_1.setBounds(470, 10, 55, 15);
		add(lblNewLabel_1);
		
	}
}
