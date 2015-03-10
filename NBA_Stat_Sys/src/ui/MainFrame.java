package ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;

import javax.swing.JButton;

public class MainFrame extends JFrame {

	JPanel panel;
	JButton searchPlayerbtn;
	JButton sortPlayerbtn;
	JButton searchTeambtn;
	JButton sortTeambtn;

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}

	public MainFrame() {
		setTitle("NBA信息查询系统");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 100, 692, 450);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("NBA信息查询系统");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel.setBounds(272, 33, 122, 39);
		getContentPane().add(lblNewLabel);

		JButton playerInfobtn = new JButton("球员信息");
		playerInfobtn.setBounds(283, 175, 93, 23);
		playerInfobtn.addActionListener(e -> playerOpe());
		getContentPane().add(playerInfobtn);

		JButton teamInfobtn = new JButton("球队信息");
		teamInfobtn.setBounds(283, 263, 93, 23);
		teamInfobtn.addActionListener(e -> teamOpe());
		getContentPane().add(teamInfobtn);

	}

	public void playerOpe() {

		if (searchTeambtn instanceof JButton) {
			searchTeambtn.setVisible(false);
			sortTeambtn.setVisible(false);
		}
        
		if(searchPlayerbtn instanceof JButton){
			searchPlayerbtn.setVisible(true);
			sortPlayerbtn.setVisible(true);
		}else{
		searchPlayerbtn = new JButton("球员查看");
		searchPlayerbtn.setBounds(380, 162, 93, 23);
		searchPlayerbtn.addActionListener(e -> tSearchPlayerPanel());
		getContentPane().add(searchPlayerbtn);

		sortPlayerbtn = new JButton("球员排序");
		sortPlayerbtn.setBounds(380, 187, 93, 23);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		getContentPane().add(sortPlayerbtn);
		}
	}

	public void teamOpe() {
		if (searchPlayerbtn instanceof JButton) {
			searchPlayerbtn.setVisible(false);
			sortPlayerbtn.setVisible(false);
		}
		if(searchTeambtn instanceof JButton){
			searchTeambtn.setVisible(true);
			sortTeambtn.setVisible(true);
		}else{
		searchTeambtn = new JButton("球队查看");
		searchTeambtn.setBounds(380, 250, 93, 23);
		searchTeambtn.addActionListener(e -> toSearchTeamPanel());
		getContentPane().add(searchTeambtn);

		sortTeambtn = new JButton("球队排序");
		sortTeambtn.setBounds(380, 275, 93, 23);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		getContentPane().add(sortTeambtn);
		}
	}
	public void tSearchPlayerPanel(){
		if (panel!=null){
			panel.setVisible(false);
			remove(panel);	
		}
		panel=new SearchPanel("player");
		panel.setBounds(200, 100, 692, 450);
		this.add(panel);
		
	}
	public void toSortPlayerPanel(){
		if (panel!=null){
			panel.setVisible(false);
			remove(panel);	
		}
		panel=new SortPanel("player");
		panel.setBounds(200, 100, 692, 450);
		this.add(panel);
	}
	public void toSearchTeamPanel(){
		if (panel!=null){
			panel.setVisible(false);
			remove(panel);	
		}
		panel=new SearchPanel("team");
		panel.setBounds(200, 100, 692, 450);
		this.add(panel);
	}
	public void toSortTeamPanel(){
		if (panel!=null){
			panel.setVisible(false);
			remove(panel);	
		}
		panel=new SortPanel("team");
		panel.setBounds(200, 100, 692, 450);
		this.add(panel);
	}
}
