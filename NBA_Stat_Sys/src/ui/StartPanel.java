package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

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

	JLabel bgLabel;
	// Image bgImage;
	JFrame mainFrame;
	static int X;
	static int Y;

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
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/mainImage.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel = new JLabel();
		bgLabel.setIcon(bg);
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		createButton();

		JButton minimize = new JButton();
		minimize.setBounds(X - X * 70 / 1366, Y * 6 / 768, X * 25 / 1366,
				Y * 25 / 768);
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		bgLabel.add(minimize);
		
		JButton close = new JButton();
		close.setBounds(X - X * 35 / 1366, Y * 6 / 768, X * 25 / 1366,
				Y * 25 / 768);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
		});
		bgLabel.add(close);

	}

	// protected void paintComponent(Graphics g) {
	// super.paintComponent(g);
	// g.drawImage(bgImage, 0, 0, X, Y, this);
	// };

	public void createButton() {

		JButton playerInfobtn = new JButton("球员信息");
		playerInfobtn.setBounds(283, 175, 93, 23);
		playerInfobtn.addActionListener(e -> playerOpe());
		bgLabel.add(playerInfobtn);

		JButton teamInfobtn = new JButton("球队信息");
		teamInfobtn.setBounds(283, 263, 93, 23);
		teamInfobtn.addActionListener(e -> teamOpe());
		bgLabel.add(teamInfobtn);

		searchPlayerbtn = new JButton("球员查看");
		searchPlayerbtn.setBounds(380, 150, 93, 23);
		searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
		searchPlayerbtn.setVisible(false);
		bgLabel.add(searchPlayerbtn);

		sortPlayerbtn = new JButton("球员排序");
		sortPlayerbtn.setBounds(380, 175, 93, 23);
		sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
		sortPlayerbtn.setVisible(false);
		bgLabel.add(sortPlayerbtn);

		screeningPlayerbtn = new JButton("球员筛选");
		screeningPlayerbtn.setBounds(380, 200, 93, 23);
		screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
		screeningPlayerbtn.setVisible(false);
		bgLabel.add(screeningPlayerbtn);

		searchTeambtn = new JButton("球队查看");
		searchTeambtn.setBounds(380, 250, 93, 23);
		searchTeambtn.addActionListener(e -> toSearchTeamPanel());
		searchTeambtn.setVisible(false);
		bgLabel.add(searchTeambtn);

		sortTeambtn = new JButton("球队排序");
		sortTeambtn.setBounds(380, 275, 93, 23);
		sortTeambtn.addActionListener(e -> toSortTeamPanel());
		sortTeambtn.setVisible(false);
		bgLabel.add(sortTeambtn);

		JButton exitButton = new JButton();
		exitButton.setBounds(85 * X / 99, 85 * Y / 100, 13 * X / 100,
				11 * Y / 100);
		ImageIcon exitground = new ImageIcon(
				"Image/exit.png");
		exitground = new ImageIcon(exitground.getImage().getScaledInstance(
				exitButton.getWidth(), exitButton.getHeight(),
				Image.SCALE_SMOOTH));
		exitButton.setIcon(exitground);
		exitButton.setOpaque(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setBorderPainted(false);
		exitButton.addActionListener(e -> mainFrame.dispose());

		bgLabel.add(exitButton);
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
