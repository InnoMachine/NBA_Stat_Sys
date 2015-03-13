package ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {
	SearchPanel searchPlayerPanel;
	SortPanel sortPlayerPanel;
	SearchPanel searchTeamPanel;
	SortPanel sortTeamPanel;
    ScreeningPlayerPanel screeningPlayerPanel;
	
static	JButton searchPlayerbtn;
static	JButton sortPlayerbtn;
static	JButton screeningPlayerbtn;
static	JButton searchTeambtn;
static	JButton sortTeambtn;
  	    JFrame mainFrame;

	public StartPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setBounds(0, 0, 692, 450);
		this.setLayout(null);

		JLabel syslbl = new JLabel("NBA信息查询系统");
		syslbl.setFont(new Font("宋体", Font.PLAIN, 15));
		syslbl.setBounds(272, 33, 122, 39);
		this.add(syslbl);

		JButton playerInfobtn = new JButton("球员信息");
		playerInfobtn.setBounds(283, 175, 93, 23);
		playerInfobtn.addActionListener(e -> playerOpe());
		this.add(playerInfobtn);

		JButton teamInfobtn = new JButton("球队信息");
		teamInfobtn.setBounds(283, 263, 93, 23);
		teamInfobtn.addActionListener(e -> teamOpe());
		this.add(teamInfobtn);

		
		searchPlayerbtn = new JButton("球员查看");
		searchPlayerbtn.setBounds(380, 150, 93, 23);
		searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
		searchPlayerbtn.setVisible(false);
		this.add(searchPlayerbtn);

		sortPlayerbtn = new JButton("球员排序");
		sortPlayerbtn.setBounds(380, 175, 93, 23);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		sortPlayerbtn.setVisible(false);
		this.add(sortPlayerbtn);
		
		
		screeningPlayerbtn = new JButton("球员筛选");
		screeningPlayerbtn.setBounds(380, 200, 93, 23);
		screeningPlayerbtn.addActionListener(e->toScreeningPlayerPanel());
		screeningPlayerbtn.setVisible(false);
		this.add(screeningPlayerbtn);

		searchTeambtn = new JButton("球队查看");
		searchTeambtn.setBounds(380, 250, 93, 23);
		searchTeambtn.addActionListener(e -> toSearchTeamPanel());
		searchTeambtn.setVisible(false);
		this.add(searchTeambtn);

		sortTeambtn = new JButton("球队排序");
		sortTeambtn.setBounds(380, 275, 93, 23);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		sortTeambtn.setVisible(false);
		this.add(sortTeambtn);
		
		
	}

	public void playerOpe() {


			searchTeambtn.setVisible(false);
			sortTeambtn.setVisible(false);


			searchPlayerbtn.setVisible(true);
			sortPlayerbtn.setVisible(true);
			screeningPlayerbtn.setVisible(true);
	

			
			
		
	}

	public void teamOpe() {
	
			searchPlayerbtn.setVisible(false);
			sortPlayerbtn.setVisible(false);
			screeningPlayerbtn.setVisible(false);
		
	
			searchTeambtn.setVisible(true);
			sortTeambtn.setVisible(true);
		
	}

	public void toSearchPlayerPanel() {
		this.setVisible(false);
		searchPlayerPanel = new SearchPanel("player", mainFrame);

	}

	public void toSortPlayerPanel() {
		this.setVisible(false);
		sortPlayerPanel = new SortPanel("player", mainFrame);

	}

	public void toScreeningPlayerPanel(){
		this.setVisible(false);
		screeningPlayerPanel=new ScreeningPlayerPanel(mainFrame);
		
	}
	
	public void toSearchTeamPanel() {
		this.setVisible(false);
		searchTeamPanel = new SearchPanel("team", mainFrame);

	}

	public void toSortTeamPanel() {
		this.setVisible(false);
		sortTeamPanel = new SortPanel("team", mainFrame);

	}

}
