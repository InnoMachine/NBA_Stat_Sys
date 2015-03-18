package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
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

	static JButton searchPlayerbtn;
	static JButton sortPlayerbtn;
	static JButton screeningPlayerbtn;
	static JButton searchTeambtn;
	static JButton sortTeambtn;
	
	JFrame mainFrame;
	static int X;
	static int Y;
	
	
	public StartPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X=mainFrame.getWidth();
		Y=mainFrame.getHeight();
		this.setBounds(0, 0, X,Y);
		this.setLayout(null);
		
		ImageIcon bgImage=new ImageIcon("/NBA_Stat_Sys/src/Image/startPanel.png");
		bgImage=new ImageIcon(bgImage.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT));
		JLabel bgLabel=new JLabel();
		bgLabel.setIcon(bgImage);
		bgLabel.setBounds(0, 0,this.getWidth(),this.getHeight());		
		this.add(bgLabel);
		
		JLabel titleLabel = new JLabel("NBA信息查询系统");
		titleLabel.setFont(new Font("宋体", Font.PLAIN, 50));
		titleLabel.setBounds(X/4,Y/3,X/3,Y/20);
		this.add(titleLabel);
		

		
	
		createFunctionButton();
		createUIButton();

	}

	public void createFunctionButton(){
		
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
		screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
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

	public void createUIButton(){
		
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

	public void toScreeningPlayerPanel() {
		this.setVisible(false);
		screeningPlayerPanel = new ScreeningPlayerPanel(mainFrame);

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
