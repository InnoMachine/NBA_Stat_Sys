package ui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import vo.PlayerVo;
import vo.TeamVo;
import businessLogic.Player_BS;
import businessLogic.Team_BS;


public class SortPanel extends JPanel {
	JFrame mainFrame;
	private JTable table;
	private JScrollPane scrollPane;
	Vector<Vector<String>> rowData;
	private Vector<String> columnNames;
	JButton criteriabtn;
//	ScreeningPlayerCriteriaPanel playerCriteriaPanel;
	TeamCriteriaPanel teamCriteriaPanel;
	
	Player_BS player_BS;
	Team_BS team_BS;

	public SortPanel(String category, JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setVisible(true);
		this.setLayout(null);

		JLabel criterialbl = new JLabel("排序依据");
		criterialbl.setBounds(99, 37, 57, 15);
		this.add(criterialbl);
		

		
		

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
//			columnNames.add("具体信息");
			
			criteriabtn = new JButton("");
			criteriabtn.setBounds(166, 33, 271, 23);
			criteriabtn.addActionListener(e->playerCriteriaShow());
			add(criteriabtn);
			
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
//			columnNames.add("具体信息");
		
			criteriabtn = new JButton("");
			criteriabtn.setBounds(166, 33, 271, 23);
			criteriabtn.addActionListener(e->teamCriteriaShow());
		
			
			
		
		}

		
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

//		table.getColumn("具体信息").setCellEditor(new MyRender());
//		table.getColumn("具体信息").setCellRenderer(new MyRender());
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 338);
		scrollPane.setVisible(true);
		this.add(scrollPane);

		mainFrame.getContentPane().add(this);
		


	}

	public void sortPlayer() {

		
		rowData = new Vector<Vector<String>>();
		Vector<String> playerInfo=new Vector<String>();
	
		ArrayList<PlayerVo> player = player_BS.sortPlayerBy(criteriabtn.getText());
		for (int i = 0; i < player.size(); i++) {
			playerInfo.add(player.get(i).getName());
			playerInfo.add(String.valueOf(player.get(i).getNumber()));
			playerInfo.add(player.get(i).getPosition());
			playerInfo.add(player.get(i).getHeight());
			playerInfo.add(player.get(i).getWeight());
			playerInfo.add(player.get(i).getBirth());
			playerInfo.add(String.valueOf(player.get(i).getAge()));
			playerInfo.add(String.valueOf(player.get(i).getExp()));
			playerInfo.add(player.get(i).getSchool());
			rowData.add(playerInfo);
		}
		
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

//		table.getColumn("具体信息").setCellEditor(new MyRender());
//		table.getColumn("具体信息").setCellRenderer(new MyRender());
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);
	
	}

	public void showTopFifty() {

		//rowData = new Vector<Vector<String>>();
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
        
		Vector<String> teamInfo=new Vector<String>();
	
		ArrayList<TeamVo> team = team_BS.sortTeamBy(criteriabtn.getText());
		
		for (int i = 0; i < team.size(); i++) {
			teamInfo.add(team.get(i).getTeamName());
			teamInfo.add(team.get(i).getAbbreviation());
			teamInfo.add(team.get(i).getCity());
			teamInfo.add(team.get(i).getConference().toString());
			teamInfo.add(team.get(i).getDivision().toString());
			teamInfo.add(team.get(i).getHomeField());
			teamInfo.add(team.get(i).getBirthYear());
			rowData.add(teamInfo);
		}
		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(rowData, columnNames);
		this.add(table);
		table.setVisible(true);
		table.setBounds(98, 75, 517, 284);

		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(98, 75, 517, 284);
		scrollPane.setVisible(true);
		this.add(scrollPane);

	}

	public void playerCriteriaShow(){
		

	}

	public void teamCriteriaShow(){
		
		
	}
	
	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}
}
