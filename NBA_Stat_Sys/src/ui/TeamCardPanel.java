package ui;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import po.Conference;
import po.Division;
import vo.TeamVo;

public class TeamCardPanel extends JPanel{
	private JTextField txtA;
	private JTextField textField;
	private JTextField txtDiv;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtBirthYear;
	private JTextField textField_6;
	private JTextField textField_8;
	
	
	private TeamVo teamInfo;
	private String criteria;
	private String criteriaValue;
	
	static int X;
	static int Y;
	
	public TeamCardPanel(int X,int Y,TeamVo teamInfo,String criteria,String criteriaValue) {
		this.X=X;
		this.Y=Y;
		
		this.setVisible(true);
		this.setLayout(null);
		this.teamInfo=teamInfo;
		this.criteria=criteria;
		this.criteriaValue=criteriaValue;
		
	}
	public void fillPanel(){
		JLabel label = new JLabel("球队全名");
		label.setBounds(X*180/1366, Y*10/768, X*55/1366, Y*15/768);
		add(label);
		
		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setText(teamInfo.getTeamName());
		txtA.setEditable(false);
		txtA.setBounds(X*243/1366, Y*6/768, X*120/1366, Y*23/768);
		add(txtA);
		txtA.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(criteria);
		lblNewLabel_1.setBounds(X*470/1366, Y*10/768, X*80/1366, Y*15/768);
		add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setText(criteriaValue);
		textField_8.setEditable(false);
		textField_8.setBounds(X*538/1366, Y*6/768, X*110/1366, Y*23/768);
		add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_3 = new JLabel("缩写");
		label_3.setBounds(X*180/1366, Y*40/768, X*55/1366, Y*15/768);
		add(label_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(teamInfo.getAbbreviation());
		textField.setEditable(false);
		textField.setBounds(X*214/1366, Y*36/768, X*110/1366, Y*23/768);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("所在地");
		label_4.setBounds(X*370/1366, Y*40/768, X*55/1366, Y*15/768);
		add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setText(teamInfo.getCity());
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(X*414/1366, Y*36/768, X*110/1366, Y*23/768);
		add(textField_2);
	
		
		JLabel label_2 = new JLabel("赛区");
		label_2.setBounds(X*580/1366, Y*40/768, X*55/1366, Y*15/768);
		add(label_2);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setText(teamInfo.getConference().name());
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(X*638/1366, Y*36/768, X*110/1366, Y*23/768);
		add(textField_6);
		
		JLabel label_5 = new JLabel("分区");
		label_5.setBounds(X*180/1366, Y*70/768, X*55/1366, Y*15/768);
		add(label_5);
		
		txtDiv = new JTextField();
		txtDiv.setHorizontalAlignment(SwingConstants.CENTER);
		txtDiv.setText(teamInfo.getDivision().name());
		txtDiv.setEditable(false);
		txtDiv.setColumns(10);
		txtDiv.setBounds(X*214/1366, Y*66/768, X*110/1366, Y*23/768);
		add(txtDiv);
		
		JLabel label_6 = new JLabel("主场");
		label_6.setBounds(X*370/1366, Y*70/768, X*55/1366, Y*15/768);
		add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setText(teamInfo.getHomeField());
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(X*414/1366, Y*66/768, X*110/1366, Y*23/768);
		add(textField_3);
		
		JLabel label_7 = new JLabel("建立时间");
		label_7.setBounds(X*580/1366, Y*70/768, X*55/1366, Y*15/768);
		add(label_7);
		
		txtBirthYear = new JTextField();
		txtBirthYear.setHorizontalAlignment(SwingConstants.CENTER);
		txtBirthYear.setText(teamInfo.getBirthYear());
		txtBirthYear.setEditable(false);
		txtBirthYear.setColumns(10);
		txtBirthYear.setBounds(X*638/1366, Y*66/768, X*110/1366, Y*23/768);
		add(txtBirthYear);
		
		JLabel lblNewLabel = new JLabel("Picture");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(X*70/1366, Y*6/768, X*99/1366, Y*80/768);
		add(lblNewLabel);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(X*6/1366, Y*6/768, X*63/1366, Y*80/768);
		add(lblNumber);
	}

	public TeamVo getTeamInfo() {
		return teamInfo;
	}
	public String getCriteria() {
		return criteria;
	}
	public String getCriteriaValue() {
		return criteriaValue;
	}
}
