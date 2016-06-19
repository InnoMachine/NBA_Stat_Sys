package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		
//		MyButton analysisbtn = new MyButton("数据分析");
//		analysisbtn.setBounds(3*X/20, 12*Y/24, X/8, Y/12);
//		analysisbtn.addActionListener(e -> toAnalysisPanel());
//		bgLabel.add(analysisbtn);
//		
//		JLabel analysisLabel=new JLabel();
//		analysisLabel.setBounds(2*X/20, 12*Y/24, Y/12, Y/12);
//		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
//				"Image/shujufenxi.png").getImage().getScaledInstance(Y/12,  Y/12,
//						 Image.SCALE_SMOOTH));
//		
//		analysisLabel.setIcon(buttonIcon);
//		bgLabel.add(analysisLabel);
		
		MyButton playerInfobtn = new MyButton("球员信息");
		playerInfobtn.setBounds(3*X/20, 15*Y/24, X/8, Y/12);
//		playerInfobtn.addActionListener(e -> playerOpe());
		playerInfobtn.addActionListener(e -> toPlayerPanel());
		playerInfobtn.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				playerInfobtn.MouseReleased();
			}
			public void mousePressed(MouseEvent e) {
				playerInfobtn.MousePressed();
			}
			public void mouseExited(MouseEvent e) {
				playerInfobtn.MouseExit();
			}
			public void mouseEntered(MouseEvent e) {
				playerInfobtn.MouseEnter();
			}
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		bgLabel.add(playerInfobtn);
		
		JLabel playerLabel=new JLabel();
		playerLabel.setBounds(2*X/20, 15*Y/24, Y/12, Y/12);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"Image/qiuyuanxinxi.png").getImage().getScaledInstance( Y/12,  Y/12,
						 Image.SCALE_SMOOTH));
		
		playerLabel.setIcon(buttonIcon);
		
		bgLabel.add(playerLabel);

		MyButton teamInfobtn = new MyButton("球队信息");
		teamInfobtn.setBounds(3*X/20, 18*Y/24, X/8,  Y/12);
		teamInfobtn.addActionListener(e -> toTeamPanel());
		teamInfobtn.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				teamInfobtn.MouseReleased();
			}
			public void mousePressed(MouseEvent e) {
				teamInfobtn.MousePressed();
			}
			public void mouseExited(MouseEvent e) {
				teamInfobtn.MouseExit();
			}
			public void mouseEntered(MouseEvent e) {
				teamInfobtn.MouseEnter();
			}
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		bgLabel.add(teamInfobtn);
		
		JLabel teamLabel=new JLabel();
		teamLabel.setBounds(2*X/20, 18*Y/24, Y/12, Y/12);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/qiuduixinxi.png").getImage().getScaledInstance( Y/12,  Y/12,
						 Image.SCALE_SMOOTH));
		
		teamLabel.setIcon(buttonIcon);
		
		bgLabel.add(teamLabel);

		MyButton gameInfobtn = new MyButton("比赛信息");
		gameInfobtn.setBounds(3*X/20, 21*Y/24, X/8,  Y/12);
		gameInfobtn.addActionListener(e -> toGamePanel());
		gameInfobtn.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
				gameInfobtn.MouseReleased();
			}
			public void mousePressed(MouseEvent e) {
				gameInfobtn.MousePressed();
			}
			public void mouseExited(MouseEvent e) {
				gameInfobtn.MouseExit();
			}
			public void mouseEntered(MouseEvent e) {
				gameInfobtn.MouseEnter();
			}
			public void mouseClicked(MouseEvent e) {
			
			}
		});
		bgLabel.add(gameInfobtn);
		
		JLabel gameLabel=new JLabel();
		gameLabel.setBounds(2*X/20, 21*Y/24, Y/12, Y/12);
		buttonIcon = new ImageIcon(new ImageIcon(
				"Image/bisaixinxi.png").getImage().getScaledInstance( Y/12,  Y/12,
						 Image.SCALE_SMOOTH));
		
		gameLabel.setIcon(buttonIcon);
		bgLabel.add(gameLabel);
		
		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X * 1180 / 1366, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		bgLabel.add(home);
		
		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds( X * 1240 / 1366, Y * 20 / 768, X / 25, X / 25);
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
		close.setBounds(X * 1300 / 1366, Y * 20 / 768, X / 25, X / 25);
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
					"Image/mainButton.png").getImage().getScaledInstance( X/8,  Y/12,
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			
		}
		
		public void MouseEnter(){
			this.setFont(new Font("微软雅黑",Font.ITALIC,20));
		}
		
		public void MouseExit(){
			this.setFont(new Font("微软雅黑",1,20));
		}
		
		public void MousePressed(){
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance( X/8,  Y/12,
							 Image.SCALE_AREA_AVERAGING));
			this.setIcon(buttonIcon);
		}
		
		public void MouseReleased(){
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance( X/8,  Y/12,
							 Image.SCALE_SMOOTH));
			this.setIcon(buttonIcon);
		}
	}
}
