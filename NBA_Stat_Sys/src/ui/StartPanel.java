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
	static PlayerPanel playerPanel;
	static TeamPanel teamPanel;
	static GamePanel gamePanel;

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

	public StartPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
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
		MyButton playerInfobtn = new MyButton("球员信息");
		playerInfobtn.setBounds(7*X/20, 9*Y/20, X/6, Y/10);
//		playerInfobtn.addActionListener(e -> playerOpe());
		playerInfobtn.addActionListener(e -> toPlayerPanel());
		bgLabel.add(playerInfobtn);

		MyButton teamInfobtn = new MyButton("球队信息");
		teamInfobtn.setBounds(7*X/20, 2*Y/3, X/6,  Y/10);
		teamInfobtn.addActionListener(e -> toTeamPanel());
		bgLabel.add(teamInfobtn);
		

		MyButton gameInfobtn = new MyButton("比赛信息");
		gameInfobtn.setBounds(7*X/20, 53*Y/60, X/6,  Y/10);
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
		minimize.setBounds(18 * X / 20, Y * 10 / 768, X / 25, X / 25);
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
		close.setBounds(19 * X / 20, Y * 10 / 768, X / 25, X / 25);
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

	
	public void toPlayerPanel() {
		this.setVisible(false);
		playerPanel = new PlayerPanel(mainFrame);

	}
	
	public void toTeamPanel() {
		this.setVisible(false);
		teamPanel = new TeamPanel(mainFrame);

	}
	public void toGamePanel() {
		this.setVisible(false);
		gamePanel = new GamePanel(mainFrame);

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
