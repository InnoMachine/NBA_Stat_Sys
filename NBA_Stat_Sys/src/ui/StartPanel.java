package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.tools.ant.taskdefs.Sleep;

import ui.analysis.AnalysisPanel;

public class StartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ShowPanel searchPlayerPanel;
	static SortPanel sortPlayerPanel;
	static ShowPanel searchTeamPanel;
	static SortPanel sortTeamPanel;
	static ScreeningPlayerPanel screeningPlayerPanel;
	
	AnalysisPanel analysisPanel;
//	LivePanel livePanel;
	PlayerPanel playerPanel;
	TeamPanel teamPanel;
	GamePanel gamePanel;
	

	static JButton searchPlayerbtn;
	static JButton sortPlayerbtn;
	static JButton screeningPlayerbtn;
	static JButton searchTeambtn;
	static JButton sortTeambtn;

	JLabel bgLabel;
	// Image bgImage;
	JFrame mainFrame;
	int X;
	int Y;

	public StartPanel(JFrame mainFrame,AnalysisPanel analysisPanel,PlayerPanel playerPanel,TeamPanel teamPanel,GamePanel gamePanel) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.analysisPanel=analysisPanel;
//		this.livePanel=livePanel;
		this.playerPanel=playerPanel;
		this.teamPanel=teamPanel;
		this.gamePanel=gamePanel;
		
		this.setBounds(0, 0, X, Y);
		this.setLayout(null);
		this.setVisible(true);
		this.setOpaque(true);
		// bgImage = Toolkit.getDefaultToolkit().getImage(
		// "Image/mainImage.png").getScaledInstance(X, Y,Image.SCALE_SMOOTH);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/startPanel.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel = new JLabel();
		bgLabel.setIcon(bg);
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		createButton();


	}
	


	public void createButton() {
		int subX=55*X/100;
		
		MyButton analysisbtn = new MyButton("数据分析");
		analysisbtn.setBounds(3*X/20, 8*Y/20, X/6, Y/10);
		analysisbtn.addActionListener(e -> toAnalysisPanel());
		bgLabel.add(analysisbtn);
		
		MyButton playerInfobtn = new MyButton("球员信息");
		playerInfobtn.setBounds(3*X/20, 11*Y/20, X/6, Y/10);
//		playerInfobtn.addActionListener(e -> playerOpe());
		playerInfobtn.addActionListener(e -> toPlayerPanel());
		bgLabel.add(playerInfobtn);

		MyButton teamInfobtn = new MyButton("球队信息");
		teamInfobtn.setBounds(3*X/20, 14*Y/20, X/6,  Y/10);
		teamInfobtn.addActionListener(e -> toTeamPanel());
		bgLabel.add(teamInfobtn);
		

		MyButton gameInfobtn = new MyButton("比赛信息");
		gameInfobtn.setBounds(3*X/20, 17*Y/20, X/6,  Y/10);
		gameInfobtn.addActionListener(e -> toGamePanel());
		bgLabel.add(gameInfobtn);
		
/*
		searchPlayerbtn = new MyButton("球员查看");
		searchPlayerbtn.setBounds(subX, 35*Y/100, X/6,  Y/10);
		searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
		searchPlayerbtn.setVisible(false);
		bgLabel.add(searchPlayerbtn);

		sortPlayerbtn = new MyButton("球员排序");
		sortPlayerbtn.setBounds(subX, 47*Y/100,X/6, Y/10);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		sortPlayerbtn.setVisible(false);
		bgLabel.add(sortPlayerbtn);

		screeningPlayerbtn = new MyButton("球员筛选");
		screeningPlayerbtn.setBounds(subX, 59*Y/100,  X/6,  Y/10);
		screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
		screeningPlayerbtn.setVisible(false);
		bgLabel.add(screeningPlayerbtn);

		searchTeambtn = new MyButton("球队查看");
		searchTeambtn.setBounds(subX, 60*Y/100, X/6,  Y/10);
		searchTeambtn.addActionListener(e -> toSearchTeamPanel());
		searchTeambtn.setVisible(false);
		bgLabel.add(searchTeambtn);

		sortTeambtn = new MyButton("球队排序");
		sortTeambtn.setBounds(subX, 72*Y/100, X/6,  Y/10);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		sortTeambtn.setVisible(false);
		bgLabel.add(sortTeambtn);
*/
	
		
		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds( X*17/ 20, Y * 20 / 768, X / 25, X / 25);
		minimize.setIcon(minimizeIcon);
		minimize.setOpaque(false);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		bgLabel.add(minimize);

		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		close.setBounds(19 * X / 20, Y * 20 / 768, X / 25, X / 25);
		close.setIcon(closeIcon);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
		});
		bgLabel.add(close);
		
		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(15 * X / 20, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		bgLabel.add(home);
		
	}
	public void toAnalysisPanel() {
		this.setVisible(false);
		analysisPanel.setVisible(true);
        MainFrame.currentPanel="analysisPanel";
	}
	/*
	public void toLivePanel() {
		this.setVisible(false);
		livePanel.setVisible(true);
        MainFrame.currentPanel="livePanel";
	}
	*/
	
	public void toPlayerPanel() {
		this.setVisible(false);
		playerPanel.setVisible(true);
        MainFrame.currentPanel="PlayerPanel";
	}
	
	public void toTeamPanel() {
		this.setVisible(false);
		teamPanel.setVisible(true);
		MainFrame.currentPanel="TeamPanel";
	}
	public void toGamePanel() {
		this.setVisible(false);
		gamePanel.setVisible(true);
		MainFrame.currentPanel="GamePanel";
	}
	/*
	public void toSearchPlayerPanel() {
		this.setVisible(false);
		searchPlayerPanel = new ShowPanel("player", mainFrame);

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
		searchTeamPanel = new ShowPanel("team", mainFrame);

	}

	public void toSortTeamPanel() {
		this.setVisible(false);
		sortTeamPanel = new SortPanel("team", mainFrame);
	}
	*/
	
	class MyButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton(String function){
			super();
			this.setText(function);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,20));
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance( X/6,  Y/10,
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			
		}
	}
}
