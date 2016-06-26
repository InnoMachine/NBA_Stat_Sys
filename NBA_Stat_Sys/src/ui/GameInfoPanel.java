package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import vo.GameVo;
import vo.PlayerPerformanceInSingleGame;
import vo.TeamPerformanceInSingleGame;
import businessLogic.Game_BL;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class GameInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	GameVo gameVo;
	JFrame mainFrame;
	JPanel previousPanel;
	String previouspanel;

	Game_BS game_BS = new Game_BL_Stub();

	static int X;
	static int Y;

	JLabel bgLabel;
	private JButton guestTeambtn;
	private JButton hostTeambtn;
	private JTextField txtGTPoint;
	private JTextField txtHTPoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField guestTeamtF;
	private JTextField guestTeam1;
	private JTextField guestTeam2;
	private JTextField guestTeam3;
	private JTextField guestTeam4;
	private JTextField guestScoreSum;
	private JTextField txtState;
	private JTextField hostTeamtF;
	private JTextField hostScore1;
	private JTextField hostScore2;
	private JTextField hostScore3;
	private JTextField hostScore4;
	private JTextField hostScoreSum;
	private JLabel courtlbl;
	private JButton btnG1;
	private JButton btnG2;
	private JButton btnG3;
	private JButton btnG4;
	private JButton btnG5;
	private JButton btnH1;
	private JButton btnH2;
	private JButton btnH3;
	private JButton btnH4;
	private JButton btnH5;
	private JTextField textField_6;
	private JTextField txtGt;
	private JTextField txtHt;
	private JTextField FGtF;
	private JTextField FTtF;
	private JTextField ThreePtF;
	private JTextField ASTtF;
	private JTextField REBtF;
	private JTextField TOtF;
	private JTextField txtGTfg;
	private JTextField txtHTfg;
	private JTextField txtGTft;
	private JTextField txtHTft;
	private JTextField txtGT3p;
	private JTextField txtHT3p;
	private JTextField txtGTast;
	private JTextField txtHTast;
	private JTextField txtGTreb;
	private JTextField txtHTreb;
	private JTextField txtGTto;
	private JTextField txtHTto;
	ArrayList<PlayerPerformanceInSingleGame> guestFirstPlayerList;
	ArrayList<PlayerPerformanceInSingleGame> hostFirstPlayerList;

	private JLabel summarylbl;
	JLabel gameInfolbl;
	private JLabel leadinglbl;
	private JTextField txtGuestTeam;
	private JTextField txtHostTeam;
	private JTextField txtGTscorefirst;
	private JTextField txtGTscore;
	private JTextField txtScore;
	private JTextField txtHTscore;
	private JTextField txtHTscorefirst;
	private JTextField txtGTreboundfirst;
	private JTextField txtGTrebound;
	private JTextField txtRebound;
	private JTextField txtHTrebound;
	private JTextField txtHTreboundfirst;
	private JTextField txtGTassistancefirst;
	private JTextField txtGTassistance;
	private JTextField txtAssistance;
	private JTextField txtHTassistance;
	private JTextField txtHTassistancefirst;
	private JTextField txtGTblockfirst;
	private JTextField txtGTblock;
	private JTextField txtBlock;
	private JTextField txtHTblock;
	private JTextField txtHTblockfirst;

	private JLabel datalbl;
	private JLabel guestTeamDatalbl;
	private JLabel hostTeamDatalbl;
	private String[] compareCriterias;

	Vector<Vector<String>> guestRowData;
	Vector<String> guestColumn;
	private JTable guestTable;
	private JScrollPane guestScrollPane;
	Vector<Vector<String>> hostRowData;
	Vector<String> hostColumn;
	private JTable hostTable;
	private JScrollPane hostScrollPane;
	PlayerBasicInfoPanel playerG1Panel;
	PlayerBasicInfoPanel playerG2Panel;
	PlayerBasicInfoPanel playerG3Panel;
	PlayerBasicInfoPanel playerG4Panel;
	PlayerBasicInfoPanel playerG5Panel;
	PlayerBasicInfoPanel playerH1Panel;
	PlayerBasicInfoPanel playerH2Panel;
	PlayerBasicInfoPanel playerH3Panel;
	PlayerBasicInfoPanel playerH4Panel;
	PlayerBasicInfoPanel playerH5Panel;

	private ChooseButton basicButton;
	private ChooseButton shootingButton;
	private ChooseButton reboundsButton;
	private ChooseButton XfactorButton;

	public GameInfoPanel(GameVo gameVo, JFrame mainFrame, JPanel previousPanel,
			String previouspanel) {
		previousPanel.setVisible(false);
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		this.previouspanel = previouspanel;
		this.gameVo = gameVo;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);

		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		/*
		 * ImageIcon bg = new ImageIcon(new
		 * ImageIcon("Image/screeningPlayer.png")
		 * .getImage().getScaledInstance(this.getWidth(), this.getHeight(),
		 * Image.SCALE_SMOOTH)); bgLabel.setIcon(bg);
		 */
		bgLabel.setOpaque(false);
		this.add(bgLabel);
		this.setBackground(Color.BLACK);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 15 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);

		JButton back = new JButton();
		back.setForeground(Color.WHITE);

		ImageIcon backIcon = new ImageIcon(new ImageIcon("Image/backIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));

		back.setBounds(17 * X / 20, Y * 15 / 768, X / 25, X / 25);
		back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		bgLabel.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 15 / 768, X / 25, X / 25);
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
		close.setBounds(19 * X / 20, Y * 15 / 768, X / 25, X / 25);
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

		mainFrame.getContentPane().add(this);

		guestTeambtn = new JButton();
		guestTeambtn.setHorizontalAlignment(SwingConstants.CENTER);

		guestTeambtn.setBounds(X * 230 / 1366, Y * 55 / 768, X * 160 / 1366,
				Y * 160 / 768);
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getGuestTeam() + ".png").getImage().getScaledInstance(
				X * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		guestTeambtn.setIcon(teamImg1);
		guestTeambtn.setContentAreaFilled(false);
		guestTeambtn.setBorderPainted(false);
		guestTeambtn.setOpaque(false);
		guestTeambtn.addActionListener(e -> {
			this.setVisible(false);
			MainFrame.teamInfoPanel = new TeamInfoPanel(gameVo.getGuestTeam(),
					mainFrame, this, "GameInfoPanel");
		});
		bgLabel.add(guestTeambtn);

		hostTeambtn = new JButton();
		hostTeambtn.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeambtn.setText(gameVo.getHomeTeam());
		hostTeambtn.setBounds(X * 970 / 1366, Y * 55 / 768, X * 160 / 1366,
				Y * 160 / 768);
		ImageIcon teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getHomeTeam() + ".png").getImage().getScaledInstance(
				X * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		hostTeambtn.setIcon(teamImg2);
		hostTeambtn.setContentAreaFilled(false);
		hostTeambtn.setBorderPainted(false);
		hostTeambtn.setOpaque(false);
		hostTeambtn.addActionListener(e -> {
			this.setVisible(false);
			MainFrame.teamInfoPanel = new TeamInfoPanel(gameVo.getHomeTeam(),
					mainFrame, this, "GameInfoPanel");
		});
		bgLabel.add(hostTeambtn);

		txtGTPoint = new MyTextField();
		txtGTPoint.setText(String.valueOf(gameVo.getGuestTP().getScore()));
		txtGTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTPoint.setBounds(X * 430 / 1366, Y * 67 / 768, X * 120 / 1366,
				Y * 60 / 768);
		txtGTPoint.setFont(new Font("微软雅黑", 1, 40));
		txtGTPoint.setBorder(null);
		bgLabel.add(txtGTPoint);

		txtHTPoint = new MyTextField();
		txtHTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTPoint.setText(String.valueOf(gameVo.getHomeTP().getScore()));
		txtHTPoint.setBounds(X * 830 / 1366, Y * 67 / 768, X * 120 / 1366,
				Y * 60 / 768);
		txtHTPoint.setFont(new Font("微软雅黑", 1, 40));
		txtHTPoint.setBorder(null);
		bgLabel.add(txtHTPoint);

		txtState = new MyTextField();
		txtState.setText("已结束");
		txtState.setHorizontalAlignment(SwingConstants.CENTER);
		txtState.setBounds(X * 651 / 1366, Y * 25 / 768, X * 66 / 1366,
				Y * 25 / 768);
		txtState.setFont(new Font("幼圆", 1, 15));
		txtState.setBorder(null);
		bgLabel.add(txtState);

		int spaceX = 565;
		int spaceY = 50;
		int tempX = 30;
		int tempY = 25;
		textField = new MyTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("球队");
		textField.setBounds(spaceX, spaceY, 60, tempY);
		textField.setOpaque(false);
		textField.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField);

		textField_1 = new MyTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("1");
		textField_1.setBounds(spaceX + 60, spaceY, tempX, tempY);
		textField_1.setOpaque(false);
		textField_1.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setText("2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(spaceX + 60 + tempX, spaceY, tempX, tempY);
		textField_2.setOpaque(false);
		textField_2.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(spaceX + 60 + 2 * tempX, spaceY, tempX, tempY);
		textField_3.setOpaque(false);
		textField_3.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setText("4");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBounds(spaceX + 60 + 3 * tempX, spaceY, tempX, tempY);
		textField_4.setOpaque(false);
		textField_4.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("总分");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBounds(spaceX + 60 + 4 * tempX, spaceY, 60, tempY);
		textField_5.setOpaque(false);
		textField_5.setBorder(BorderFactory.createEmptyBorder());
		bgLabel.add(textField_5);

		guestTeamtF = new MyTextField();
		guestTeamtF.setText(gameVo.getGuestTeam());
		guestTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamtF.setColumns(X * 10 / 1366);
		guestTeamtF.setBounds(spaceX, spaceY + tempY, 60, tempY);
		guestTeamtF.setBackground(Color.DARK_GRAY);
		guestTeamtF.setOpaque(true);

		bgLabel.add(guestTeamtF);

		guestTeam1 = new MyTextField();
		guestTeam1
				.setText(String.valueOf(gameVo.getScore1st().getGuestScore()));

		guestTeam1.setBackground(Color.DARK_GRAY);
		guestTeam1.setOpaque(true);

		guestTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam1.setBounds(spaceX + 60, spaceY + tempY, tempX, tempY);
		bgLabel.add(guestTeam1);

		guestTeam2 = new MyTextField();
		guestTeam2
				.setText(String.valueOf(gameVo.getScore2nd().getGuestScore()));

		guestTeam2.setBackground(Color.DARK_GRAY);
		guestTeam2.setOpaque(true);

		guestTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam2.setBounds(spaceX + 60 + tempX, spaceY + tempY, tempX, tempY);
		bgLabel.add(guestTeam2);

		guestTeam3 = new MyTextField();
		guestTeam3
				.setText(String.valueOf(gameVo.getScore3rd().getGuestScore()));

		guestTeam3.setBackground(Color.DARK_GRAY);
		guestTeam3.setOpaque(true);

		guestTeam3.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam3.setBounds(spaceX + 60 + 2 * tempX, spaceY + tempY, tempX,
				tempY);
		bgLabel.add(guestTeam3);

		guestTeam4 = new MyTextField();
		guestTeam4
				.setText(String.valueOf(gameVo.getScore4th().getGuestScore()));

		guestTeam4.setBackground(Color.DARK_GRAY);
		guestTeam4.setOpaque(true);

		guestTeam4.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam4.setBounds(spaceX + 60 + 3 * tempX, spaceY + tempY, tempX,
				tempY);
		bgLabel.add(guestTeam4);

		guestScoreSum = new MyTextField();
		guestScoreSum.setText(String.valueOf(gameVo.getScoreOverall()
				.getGuestScore()));

		guestScoreSum.setBackground(Color.DARK_GRAY);
		guestScoreSum.setOpaque(true);

		guestScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		guestScoreSum.setBounds(spaceX + 60 + 4 * tempX, spaceY + tempY, 60,
				tempY);
		bgLabel.add(guestScoreSum);

		hostTeamtF = new MyTextField();
		hostTeamtF.setText(gameVo.getHomeTeam());
		hostTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamtF.setBounds(spaceX, spaceY + 2 * tempY, 60, tempY);

		hostTeamtF.setBackground(Color.GRAY);
		hostTeamtF.setOpaque(true);

		bgLabel.add(hostTeamtF);

		hostScore1 = new MyTextField();
		hostScore1.setText(String.valueOf(gameVo.getScore1st().getHomeScore()));

		hostScore1.setBackground(Color.GRAY);
		hostScore1.setOpaque(true);

		hostScore1.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore1.setBounds(spaceX + 60, spaceY + 2 * tempY, tempX, tempY);
		bgLabel.add(hostScore1);

		hostScore2 = new MyTextField();
		hostScore2.setText(String.valueOf(gameVo.getScore2nd().getHomeScore()));
		hostScore2.setBackground(Color.GRAY);
		hostScore2.setOpaque(true);

		hostScore2.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore2.setBounds(spaceX + 60 + tempX, spaceY + 2 * tempY, tempX,
				tempY);
		bgLabel.add(hostScore2);

		hostScore3 = new MyTextField();
		hostScore3.setText(String.valueOf(gameVo.getScore3rd().getHomeScore()));

		hostScore3.setBackground(Color.GRAY);
		hostScore3.setOpaque(true);

		hostScore3.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore3.setBounds(spaceX + 60 + 2 * tempX, spaceY + 2 * tempY,
				tempX, tempY);
		bgLabel.add(hostScore3);

		hostScore4 = new MyTextField();
		hostScore4.setText(String.valueOf(gameVo.getScore4th().getHomeScore()));

		hostScore4.setBackground(Color.GRAY);
		hostScore4.setOpaque(true);

		hostScore4.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore4.setBounds(spaceX + 60 + 3 * tempX, spaceY + 2 * tempY,
				tempX, tempY);
		bgLabel.add(hostScore4);

		hostScoreSum = new MyTextField();
		hostScoreSum.setText(String.valueOf(gameVo.getScoreOverall()
				.getHomeScore()));

		hostScoreSum.setBackground(Color.GRAY);
		hostScoreSum.setOpaque(true);

		hostScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		hostScoreSum.setBounds(spaceX + 60 + 4 * tempX, spaceY + 2 * tempY, 60,
				tempY);
		bgLabel.add(hostScoreSum);

		JButton startingbtn = new ChooseButton("首发");
		startingbtn.setBounds(X * 450 / 1366, Y * 155 / 768, X * 116 / 1366,
				Y * 30 / 768);
		startingbtn.addActionListener(e -> starting());
		bgLabel.add(startingbtn);

		JButton summarybtn = new ChooseButton("赛后总结");
		summarybtn.setBounds(X * 566 / 1366, Y * 155 / 768, X * 116 / 1366,
				Y * 30 / 768);
		summarybtn.addActionListener(e -> summary());
		bgLabel.add(summarybtn);

		JButton databtn = new ChooseButton("数据");
		databtn.setBounds(X * 682 / 1366, Y * 155 / 768, X * 116 / 1366,
				Y * 30 / 768);
		databtn.addActionListener(e -> showData());
		bgLabel.add(databtn);
		
		
		JButton videobtn = new ChooseButton("精彩视频");
		videobtn.setBounds(X * 798 / 1366, Y * 155 / 768, X * 116 / 1366,
				Y * 30 / 768);
		videobtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160514/022187.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		bgLabel.add(videobtn);

		starting();

		mainFrame.getContentPane().add(this);
	}

	public void starting() {
		guestFirstPlayerList = new ArrayList<PlayerPerformanceInSingleGame>();
		guestFirstPlayerList = (gameVo.getGuestTP()).getFirstonList();
		hostFirstPlayerList = new ArrayList<PlayerPerformanceInSingleGame>();
		hostFirstPlayerList = (gameVo.getHomeTP()).getFirstonList();

		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		courtlbl = new MyLabel();
		courtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		courtlbl.setBounds(X * 131 / 1366, Y * 194 / 768, X * 1100 / 1366,
				Y * 500 / 768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon("CSEdata/court_png/"
				+ gameVo.getHomeTeam() + "_court.png").getImage()
				.getScaledInstance(X * 1100 / 1366, Y * 500 / 768,
						Image.SCALE_SMOOTH));

		courtlbl.setIcon(buttonIcon);

		playerG1Panel = new PlayerBasicInfoPanel(guestFirstPlayerList.get(0),
				X * 445 / 1366, Y * 175 / 768);
		playerG1Panel.setVisible(false);
		courtlbl.add(playerG1Panel);
		playerG2Panel = new PlayerBasicInfoPanel(guestFirstPlayerList.get(1),
				X * 365 / 1366, Y * 40 / 768);
		playerG2Panel.setVisible(false);
		courtlbl.add(playerG2Panel);
		playerG3Panel = new PlayerBasicInfoPanel(guestFirstPlayerList.get(2),
				X * 205 / 1366, Y * 310 / 768);
		playerG3Panel.setVisible(false);
		courtlbl.add(playerG3Panel);
		playerG4Panel = new PlayerBasicInfoPanel(guestFirstPlayerList.get(3),
				X * 235 / 1366, Y * 133 / 768);
		playerG4Panel.setVisible(false);
		courtlbl.add(playerG4Panel);
		playerG5Panel = new PlayerBasicInfoPanel(guestFirstPlayerList.get(4),
				X * 345 / 1366, Y * 280 / 768);
		playerG5Panel.setVisible(false);
		courtlbl.add(playerG5Panel);
		playerH1Panel = new PlayerBasicInfoPanel(hostFirstPlayerList.get(0),
				X * 645 / 1366, Y * 175 / 768);
		playerH1Panel.setVisible(false);
		courtlbl.add(playerH1Panel);
		playerH2Panel = new PlayerBasicInfoPanel(hostFirstPlayerList.get(1),
				X * 755 / 1366, Y * 310 / 768);
		playerH2Panel.setVisible(false);
		courtlbl.add(playerH2Panel);
		playerH3Panel = new PlayerBasicInfoPanel(hostFirstPlayerList.get(2),
				X * 855 / 1366, Y * 40 / 768);
		playerH3Panel.setVisible(false);
		courtlbl.add(playerH3Panel);
		playerH4Panel = new PlayerBasicInfoPanel(hostFirstPlayerList.get(3),
				X * 875 / 1366, Y * 217 / 768);
		playerH4Panel.setVisible(false);
		courtlbl.add(playerH4Panel);
		playerH5Panel = new PlayerBasicInfoPanel(hostFirstPlayerList.get(4),
				X * 705 / 1366, Y * 65 / 768);
		playerH5Panel.setVisible(false);
		courtlbl.add(playerH5Panel);

		btnG1 = new MyButton();
		btnG1.setBounds(X * 390 / 1366, Y * 215 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitG1 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(0).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_SMOOTH));
		btnG1.setOpaque(false);
		btnG1.setIcon(playerPortraitG1);
		btnG1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG1Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG1Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG1Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						guestFirstPlayerList.get(0).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});

		courtlbl.add(btnG1);

		btnG2 = new MyButton();
		btnG2.setBounds(X * 310 / 1366, Y * 80 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitG2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(1).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnG2.setIcon(playerPortraitG2);
		btnG2.setOpaque(false);
		btnG2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG2Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG2Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG2Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						guestFirstPlayerList.get(1).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnG2);

		btnG3 = new MyButton();
		btnG3.setBounds(X * 150 / 1366, Y * 350 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitG3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(2).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnG3.setIcon(playerPortraitG3);
		btnG3.setOpaque(false);
		btnG3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG3Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG3Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG3Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						guestFirstPlayerList.get(2).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnG3);

		btnG4 = new MyButton();
		btnG4.setBounds(X * 180 / 1366, Y * 173 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitG4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(3).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnG4.setIcon(playerPortraitG4);
		btnG4.setOpaque(false);
		btnG4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG4Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG4Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG4Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						guestFirstPlayerList.get(3).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnG4);

		btnG5 = new MyButton();
		btnG5.setBounds(X * 290 / 1366, Y * 320 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitG5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(4).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnG5.setIcon(playerPortraitG5);
		btnG5.setOpaque(false);
		btnG5.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG5Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG5Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG5Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						guestFirstPlayerList.get(4).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnG5);

		btnH1 = new MyButton();
		btnH1.setBounds(X * 590 / 1366, Y * 215 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitH1 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(0).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnH1.setIcon(playerPortraitH1);
		btnH1.setOpaque(false);
		btnH1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH1Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH1Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH1Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						hostFirstPlayerList.get(0).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnH1);

		btnH2 = new MyButton();
		btnH2.setBounds(X * 700 / 1366, Y * 350 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitH2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(1).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnH2.setIcon(playerPortraitH2);
		btnH2.setOpaque(false);
		btnH2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH2Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH2Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH2Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						hostFirstPlayerList.get(1).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnH2);

		btnH3 = new MyButton();
		btnH3.setBounds(X * 800 / 1366, Y * 80 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitH3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(2).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnH3.setIcon(playerPortraitH3);
		btnH3.addActionListener(e -> {
			System.out.println("click H3!!!");
		});
		btnH3.setOpaque(false);
		btnH3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH3Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH3Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH3Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						hostFirstPlayerList.get(2).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnH3);

		btnH4 = new MyButton();
		btnH4.setBounds(X * 820 / 1366, Y * 257 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitH4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(3).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnH4.setIcon(playerPortraitH4);
		btnH4.setOpaque(false);
		btnH4.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH4Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH4Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH4Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						hostFirstPlayerList.get(3).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnH4);

		btnH5 = new MyButton();
		btnH5.setBounds(X * 650 / 1366, Y * 105 / 768, X * 80 / 1366,
				Y * 80 / 768);
		ImageIcon playerPortraitH5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(4).getName() + ".png")
				.getImage().getScaledInstance(X * 80 / 1366, Y * 80 / 768,
						Image.SCALE_AREA_AVERAGING));
		btnH5.setIcon(playerPortraitH5);
		btnH5.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH5Panel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH5Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH5Panel.setVisible(false);
				selfClose();
				MainFrame.playerInfoPanel = new PlayerInfoPanel(
						hostFirstPlayerList.get(4).getName(), mainFrame,
						new GameInfoPanel(gameVo, mainFrame, previousPanel,
								previouspanel), "GameInfoPanel");
				mainFrame.add(MainFrame.playerInfoPanel);
			}
		});
		courtlbl.add(btnH5);

		bgLabel.add(courtlbl);

	}

	public void summary() {
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		summarylbl = new MyLabel();
		summarylbl.setHorizontalAlignment(SwingConstants.CENTER);
		summarylbl.setBounds(X * 131 / 1366, Y * 194 / 768, X * 1100 / 1366,
				Y * 500 / 768);
		summarylbl.setBackground(Color.blue);

		gameInfolbl = new MyLabel("比赛概览");
		gameInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameInfolbl.setFont(new Font("微软雅黑", 1, 20));
		gameInfolbl.setBounds(X * 97 / 1366, Y * 30 / 768, X * 100 / 1366,
				Y * 30 / 768);
		summarylbl.add(gameInfolbl);

		textField_6 = new MyTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(X * 97 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		textField_6.setBackground(Color.DARK_GRAY);
		textField_6.setOpaque(true);
		summarylbl.add(textField_6);
		textField_6.setColumns(X * 10 / 1366);

		txtGt = new MyTextField();
		txtGt.setEditable(false);
		txtGt.setText(gameVo.getGuestTeam());
		txtGt.setHorizontalAlignment(SwingConstants.CENTER);
		txtGt.setColumns(X * 10 / 1366);
		txtGt.setBounds(X * 97 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		// txtGt.setBackground(Color.DARK_GRAY);
		// txtGt.setOpaque(true);
		summarylbl.add(txtGt);

		txtHt = new MyTextField();
		txtHt.setEditable(false);
		txtHt.setText(gameVo.getHomeTeam());
		txtHt.setHorizontalAlignment(SwingConstants.CENTER);
		txtHt.setColumns(X * 10 / 1366);
		txtHt.setBounds(X * 97 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		// txtHt.setBackground(Color.DARK_GRAY);
		// txtHt.setOpaque(true);
		summarylbl.add(txtHt);

		FGtF = new MyTextField();
		FGtF.setText("投篮命中率");
		FGtF.setEditable(false);
		FGtF.setHorizontalAlignment(SwingConstants.CENTER);
		FGtF.setColumns(X * 10 / 1366);
		FGtF.setBounds(227, Y * 70 / 768, X * 130 / 1366, Y * 40 / 768);
		FGtF.setBackground(Color.DARK_GRAY);
		FGtF.setOpaque(true);
		summarylbl.add(FGtF);

		FTtF = new MyTextField();
		FTtF.setText("罚球命中率");
		FTtF.setEditable(false);
		FTtF.setHorizontalAlignment(SwingConstants.CENTER);
		FTtF.setColumns(X * 10 / 1366);
		FTtF.setBounds(X * 357 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		FTtF.setBackground(Color.DARK_GRAY);
		FTtF.setOpaque(true);
		summarylbl.add(FTtF);

		ThreePtF = new MyTextField();
		ThreePtF.setText("三分命中率");
		ThreePtF.setEditable(false);
		ThreePtF.setHorizontalAlignment(SwingConstants.CENTER);
		ThreePtF.setColumns(X * 10 / 1366);
		ThreePtF.setBounds(X * 487 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		ThreePtF.setBackground(Color.DARK_GRAY);
		ThreePtF.setOpaque(true);
		summarylbl.add(ThreePtF);

		ASTtF = new MyTextField();
		ASTtF.setText("助攻");
		ASTtF.setEditable(false);
		ASTtF.setHorizontalAlignment(SwingConstants.CENTER);
		ASTtF.setColumns(X * 10 / 1366);
		ASTtF.setBounds(X * 617 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		ASTtF.setBackground(Color.DARK_GRAY);
		ASTtF.setOpaque(true);
		summarylbl.add(ASTtF);

		REBtF = new MyTextField();
		REBtF.setText("篮板");
		REBtF.setEditable(false);
		REBtF.setHorizontalAlignment(SwingConstants.CENTER);
		REBtF.setColumns(X * 10 / 1366);
		REBtF.setBounds(X * 747 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		REBtF.setBackground(Color.DARK_GRAY);
		REBtF.setOpaque(true);
		summarylbl.add(REBtF);

		TOtF = new MyTextField();
		TOtF.setText("失误");
		TOtF.setEditable(false);
		TOtF.setHorizontalAlignment(SwingConstants.CENTER);
		TOtF.setColumns(X * 10 / 1366);
		TOtF.setBounds(X * 877 / 1366, Y * 70 / 768, X * 130 / 1366,
				Y * 40 / 768);
		TOtF.setBackground(Color.DARK_GRAY);
		TOtF.setOpaque(true);
		summarylbl.add(TOtF);

		txtGTfg = new MyTextField();
		txtGTfg.setText(String.valueOf(gameVo.getGuestTP().getHitRate()));
		txtGTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTfg.setEditable(false);
		txtGTfg.setColumns(X * 10 / 1366);
		txtGTfg.setBounds(X * 227 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getHitRate() >=
		 * gameVo.getHomeTP().getHitRate()) {
		 * txtGTfg.setBackground(Color.DARK_GRAY); txtGTfg.setOpaque(true); }
		 * else {
		 * 
		 * txtGTfg.setBackground(Color.LIGHT_GRAY); txtGTfg.setOpaque(true); }
		 */
		summarylbl.add(txtGTfg);

		txtHTfg = new MyTextField();
		txtHTfg.setText(String.valueOf(gameVo.getHomeTP().getHitRate()));
		txtHTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTfg.setEditable(false);
		txtHTfg.setColumns(X * 10 / 1366);
		txtHTfg.setBounds(X * 227 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getHitRate() <
		 * gameVo.getHomeTP().getHitRate()) {
		 * txtHTfg.setBackground(Color.DARK_GRAY); txtHTfg.setOpaque(true); }
		 * else {
		 * 
		 * txtHTfg.setBackground(Color.LIGHT_GRAY); txtHTfg.setOpaque(true); }
		 */
		summarylbl.add(txtHTfg);

		txtGTft = new MyTextField();
		txtGTft.setText(String.valueOf(gameVo.getGuestTP().getFreeThrowRate()));
		txtGTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTft.setEditable(false);
		txtGTft.setColumns(X * 10 / 1366);
		txtGTft.setBounds(X * 357 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getFreeThrowRate() >= gameVo.getHomeTP()
		 * .getFreeThrowRate()) { txtGTft.setBackground(Color.DARK_GRAY);
		 * txtGTft.setOpaque(true); } else {
		 * 
		 * txtGTft.setBackground(Color.LIGHT_GRAY); txtGTft.setOpaque(true); }
		 */
		summarylbl.add(txtGTft);

		txtHTft = new MyTextField();
		txtHTft.setText(String.valueOf(gameVo.getHomeTP().getFreeThrowRate()));
		txtHTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTft.setEditable(false);
		txtHTft.setColumns(X * 10 / 1366);
		txtHTft.setBounds(X * 357 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getFreeThrowRate() < gameVo.getHomeTP()
		 * .getFreeThrowRate()) { txtHTft.setBackground(Color.DARK_GRAY);
		 * txtHTft.setOpaque(true); } else {
		 * 
		 * txtHTft.setBackground(Color.LIGHT_GRAY); txtHTft.setOpaque(true); }
		 */
		summarylbl.add(txtHTft);

		txtGT3p = new MyTextField();
		txtGT3p.setText(String.valueOf(gameVo.getGuestTP()
				.getThreePointHitRate()));
		txtGT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtGT3p.setEditable(false);
		txtGT3p.setColumns(X * 10 / 1366);
		txtGT3p.setBounds(X * 487 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getThreePointHitRate() >= gameVo.getHomeTP()
		 * .getThreePointHitRate()) { txtGT3p.setBackground(Color.DARK_GRAY);
		 * txtGT3p.setOpaque(true); } else {
		 * 
		 * txtGT3p.setBackground(Color.LIGHT_GRAY); txtGT3p.setOpaque(true); }
		 */
		summarylbl.add(txtGT3p);

		txtHT3p = new MyTextField();
		txtHT3p.setText(String.valueOf(gameVo.getHomeTP()
				.getThreePointHitRate()));
		txtHT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtHT3p.setEditable(false);
		txtHT3p.setColumns(X * 10 / 1366);
		txtHT3p.setBounds(X * 487 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getThreePointHitRate() < gameVo.getHomeTP()
		 * .getThreePointHitRate()) { txtHT3p.setBackground(Color.DARK_GRAY);
		 * txtHT3p.setOpaque(true); } else {
		 * 
		 * txtHT3p.setBackground(Color.LIGHT_GRAY); txtHT3p.setOpaque(true); }
		 */
		summarylbl.add(txtHT3p);

		txtGTast = new MyTextField();
		txtGTast.setText(String.valueOf(gameVo.getGuestTP().getAssistance()));
		txtGTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTast.setEditable(false);
		txtGTast.setColumns(X * 10 / 1366);
		txtGTast.setBounds(X * 617 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getAssistance() >= gameVo.getHomeTP()
		 * .getAssistance()) { txtGTast.setBackground(Color.DARK_GRAY);
		 * txtGTast.setOpaque(true); } else {
		 * 
		 * txtGTast.setBackground(Color.LIGHT_GRAY); txtGTast.setOpaque(true); }
		 */
		summarylbl.add(txtGTast);

		txtHTast = new MyTextField();
		txtHTast.setText(String.valueOf(gameVo.getHomeTP().getAssistance()));
		txtHTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTast.setEditable(false);
		txtHTast.setColumns(X * 10 / 1366);
		txtHTast.setBounds(X * 617 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getAssistance() < gameVo.getHomeTP()
		 * .getAssistance()) { txtHTast.setBackground(Color.DARK_GRAY);
		 * txtHTast.setOpaque(true); } else {
		 * 
		 * txtHTast.setBackground(Color.LIGHT_GRAY); txtHTast.setOpaque(true); }
		 */
		summarylbl.add(txtHTast);

		txtGTreb = new MyTextField();
		txtGTreb.setText(String
				.valueOf(gameVo.getGuestTP().getReboundOverall()));
		txtGTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreb.setEditable(false);
		txtGTreb.setColumns(X * 10 / 1366);
		txtGTreb.setBounds(X * 747 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getReboundOverall() >= gameVo.getHomeTP()
		 * .getReboundOverall()) { txtGTreb.setBackground(Color.DARK_GRAY);
		 * txtGTreb.setOpaque(true); } else {
		 * 
		 * txtGTreb.setBackground(Color.LIGHT_GRAY); txtGTreb.setOpaque(true); }
		 */
		summarylbl.add(txtGTreb);

		txtHTreb = new MyTextField();
		txtHTreb.setText(String.valueOf(gameVo.getHomeTP().getReboundOverall()));
		txtHTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreb.setEditable(false);
		txtHTreb.setColumns(X * 10 / 1366);
		txtHTreb.setBounds(X * 747 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getReboundOverall() < gameVo.getHomeTP()
		 * .getReboundOverall()) { txtHTreb.setBackground(Color.DARK_GRAY);
		 * txtHTreb.setOpaque(true); } else {
		 * 
		 * txtHTreb.setBackground(Color.LIGHT_GRAY); txtHTreb.setOpaque(true); }
		 */
		summarylbl.add(txtHTreb);

		txtGTto = new MyTextField();
		txtGTto.setText(String.valueOf(gameVo.getGuestTP().getTurnover()));
		txtGTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTto.setEditable(false);
		txtGTto.setColumns(X * 10 / 1366);
		txtGTto.setBounds(X * 877 / 1366, Y * 110 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getTurnover() >= gameVo.getHomeTP()
		 * .getTurnover()) { txtGTto.setBackground(Color.DARK_GRAY);
		 * txtGTto.setOpaque(true); } else {
		 * 
		 * txtGTto.setBackground(Color.LIGHT_GRAY); txtGTto.setOpaque(true); }
		 */
		summarylbl.add(txtGTto);

		txtHTto = new MyTextField();
		txtHTto.setText(String.valueOf(gameVo.getHomeTP().getTurnover()));
		txtHTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTto.setEditable(false);
		txtHTto.setColumns(X * 10 / 1366);
		txtHTto.setBounds(X * 877 / 1366, Y * 150 / 768, X * 130 / 1366,
				Y * 40 / 768);
		/*
		 * if (gameVo.getGuestTP().getTurnover() < gameVo.getHomeTP()
		 * .getTurnover()) { txtHTto.setBackground(Color.DARK_GRAY);
		 * txtHTto.setOpaque(true); } else {
		 * 
		 * txtHTto.setBackground(Color.LIGHT_GRAY); txtHTto.setOpaque(true); }
		 */
		summarylbl.add(txtHTto);

		leadinglbl = new MyLabel("数据领跑者");
		leadinglbl.setFont(new Font("微软雅黑", 1, 20));
		leadinglbl.setBounds(X * 97 / 1366, Y * 210 / 768, X * 200 / 1366,
				Y * 30 / 768);
		summarylbl.add(leadinglbl);

		txtGuestTeam = new MyTextField();
		txtGuestTeam.setEditable(false);
		txtGuestTeam.setText(gameVo.getGuestTeam());
		txtGuestTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuestTeam.setBounds(X * 97 / 1366, Y * 250 / 768, X * 455 / 1366,
				Y * 40 / 768);
		txtGuestTeam.setBackground(Color.DARK_GRAY);
		txtGuestTeam.setOpaque(true);
		summarylbl.add(txtGuestTeam);
		txtGuestTeam.setColumns(X * 10 / 1366);

		txtHostTeam = new MyTextField();
		txtHostTeam.setEditable(false);
		txtHostTeam.setText(gameVo.getHomeTeam());
		txtHostTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtHostTeam.setColumns(X * 10 / 1366);
		txtHostTeam.setBounds(552, 250, X * 455 / 1366, Y * 40 / 768);
		txtHostTeam.setBackground(Color.DARK_GRAY);
		txtHostTeam.setOpaque(true);
		summarylbl.add(txtHostTeam);

		txtGTscorefirst = new MyTextField();
		txtGTscorefirst.setText(gameVo.getGuestTP().getHighestScorePlayer());
		txtGTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscorefirst.setEditable(false);
		txtGTscorefirst.setColumns(X * 10 / 1366);
		txtGTscorefirst.setBounds(X * 97 / 1366, Y * 290 / 768, X * 260 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtGTscorefirst);

		txtGTscore = new MyTextField();
		txtGTscore.setText(String
				.valueOf(gameVo.getGuestTP().getHighestScore()));
		txtGTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscore.setEditable(false);
		txtGTscore.setColumns(X * 10 / 1366);
		txtGTscore.setBounds(X * 357 / 1366, Y * 290 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtGTscore);

		txtScore = new MyTextField();
		txtScore.setText("得分");
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setEditable(false);
		txtScore.setColumns(X * 10 / 1366);
		txtScore.setBounds(X * 487 / 1366, Y * 290 / 768, X * 130 / 1366,
				Y * 40 / 768);
		txtScore.setBackground(Color.GRAY);
		txtScore.setOpaque(true);
		summarylbl.add(txtScore);

		txtHTscore = new MyTextField();
		txtHTscore
				.setText(String.valueOf(gameVo.getHomeTP().getHighestScore()));
		txtHTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscore.setEditable(false);
		txtHTscore.setColumns(X * 10 / 1366);
		txtHTscore.setBounds(X * 617 / 1366, Y * 290 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtHTscore);

		txtHTscorefirst = new MyTextField();
		txtHTscorefirst.setText(gameVo.getHomeTP().getHighestScorePlayer());
		txtHTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscorefirst.setEditable(false);
		txtHTscorefirst.setColumns(X * 10 / 1366);
		txtHTscorefirst.setBounds(X * 747 / 1366, Y * 290 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtHTscorefirst);

		txtGTreboundfirst = new MyTextField();
		txtGTreboundfirst
				.setText(gameVo.getGuestTP().getHighestReboundPlayer());
		txtGTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreboundfirst.setEditable(false);
		txtGTreboundfirst.setColumns(X * 10 / 1366);
		txtGTreboundfirst.setBounds(X * 97 / 1366, Y * 330 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtGTreboundfirst);

		txtGTrebound = new MyTextField();
		txtGTrebound.setText(String.valueOf(gameVo.getGuestTP()
				.getHighestRebound()));
		txtGTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTrebound.setEditable(false);
		txtGTrebound.setColumns(X * 10 / 1366);
		txtGTrebound.setBounds(X * 357 / 1366, Y * 330 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtGTrebound);

		txtRebound = new MyTextField();
		txtRebound.setText("篮板");
		txtRebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtRebound.setEditable(false);
		txtRebound.setColumns(X * 10 / 1366);
		txtRebound.setBounds(X * 487 / 1366, Y * 330 / 768, X * 130 / 1366,
				Y * 40 / 768);
		txtRebound.setBackground(Color.GRAY);
		txtRebound.setOpaque(true);
		summarylbl.add(txtRebound);

		txtHTrebound = new MyTextField();
		txtHTrebound.setText(String.valueOf(gameVo.getHomeTP()
				.getHighestRebound()));
		txtHTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTrebound.setEditable(false);
		txtHTrebound.setColumns(X * 10 / 1366);
		txtHTrebound.setBounds(X * 617 / 1366, Y * 330 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtHTrebound);

		txtHTreboundfirst = new MyTextField();
		txtHTreboundfirst.setText(gameVo.getHomeTP().getHighestReboundPlayer());
		txtHTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreboundfirst.setEditable(false);
		txtHTreboundfirst.setColumns(X * 10 / 1366);
		txtHTreboundfirst.setBounds(X * 747 / 1366, Y * 330 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtHTreboundfirst);

		txtGTassistancefirst = new MyTextField();
		txtGTassistancefirst.setText(gameVo.getGuestTP()
				.getHighestassistPlayer());
		txtGTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistancefirst.setEditable(false);
		txtGTassistancefirst.setColumns(X * 10 / 1366);
		txtGTassistancefirst.setBounds(X * 97 / 1366, Y * 370 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtGTassistancefirst);

		txtGTassistance = new MyTextField();
		txtGTassistance.setText(String.valueOf(gameVo.getGuestTP()
				.getHighestassist()));
		txtGTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistance.setEditable(false);
		txtGTassistance.setColumns(X * 10 / 1366);
		txtGTassistance.setBounds(X * 357 / 1366, Y * 370 / 768,
				X * 130 / 1366, Y * 40 / 768);
		summarylbl.add(txtGTassistance);

		txtAssistance = new MyTextField();
		txtAssistance.setText("助攻");
		txtAssistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssistance.setEditable(false);
		txtAssistance.setColumns(X * 10 / 1366);
		txtAssistance.setBounds(X * 487 / 1366, Y * 370 / 768, X * 130 / 1366,
				Y * 40 / 768);
		txtAssistance.setBackground(Color.GRAY);
		txtAssistance.setOpaque(true);
		summarylbl.add(txtAssistance);

		txtHTassistance = new MyTextField();
		txtHTassistance.setText(String.valueOf(gameVo.getHomeTP()
				.getHighestassist()));
		txtHTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistance.setEditable(false);
		txtHTassistance.setColumns(X * 10 / 1366);
		txtHTassistance.setBounds(X * 617 / 1366, Y * 370 / 768,
				X * 130 / 1366, Y * 40 / 768);
		summarylbl.add(txtHTassistance);

		txtHTassistancefirst = new MyTextField();
		txtHTassistancefirst.setText(gameVo.getHomeTP()
				.getHighestassistPlayer());
		txtHTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistancefirst.setEditable(false);
		txtHTassistancefirst.setColumns(X * 10 / 1366);
		txtHTassistancefirst.setBounds(X * 747 / 1366, Y * 370 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtHTassistancefirst);

		txtGTblockfirst = new MyTextField();
		txtGTblockfirst.setText(gameVo.getGuestTP().getHighestblockPlayer());
		txtGTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblockfirst.setEditable(false);
		txtGTblockfirst.setColumns(X * 10 / 1366);
		txtGTblockfirst.setBounds(X * 97 / 1366, Y * 410 / 768, X * 260 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtGTblockfirst);

		txtGTblock = new MyTextField();
		txtGTblock
				.setText(String.valueOf(gameVo.getHomeTP().getHighestblock()));
		txtGTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblock.setEditable(false);
		txtGTblock.setColumns(X * 10 / 1366);
		txtGTblock.setBounds(X * 357 / 1366, Y * 410 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtGTblock);

		txtBlock = new MyTextField();
		txtBlock.setText("盖帽");
		txtBlock.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlock.setEditable(false);
		txtBlock.setColumns(X * 10 / 1366);
		txtBlock.setBounds(X * 487 / 1366, Y * 410 / 768, X * 130 / 1366,
				Y * 40 / 768);
		txtBlock.setBackground(Color.GRAY);
		txtBlock.setOpaque(true);
		summarylbl.add(txtBlock);

		txtHTblock = new MyTextField();
		txtHTblock
				.setText(String.valueOf(gameVo.getHomeTP().getHighestblock()));
		txtHTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblock.setEditable(false);
		txtHTblock.setColumns(X * 10 / 1366);
		txtHTblock.setBounds(X * 617 / 1366, Y * 410 / 768, X * 130 / 1366,
				Y * 40 / 768);
		summarylbl.add(txtHTblock);

		txtHTblockfirst = new MyTextField();
		txtHTblockfirst.setText(gameVo.getHomeTP().getHighestblockPlayer());
		txtHTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblockfirst.setEditable(false);
		txtHTblockfirst.setColumns(X * 10 / 1366);
		txtHTblockfirst.setBounds(X * 747 / 1366, Y * 410 / 768,
				X * 260 / 1366, Y * 40 / 768);
		summarylbl.add(txtHTblockfirst);

		bgLabel.add(summarylbl);
	}

	public void showData() {
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		datalbl = new JLabel();
		datalbl.setHorizontalAlignment(SwingConstants.CENTER);
		datalbl.setBounds(131, 194, 1100, 500);
		datalbl.setBackground(Color.blue);

		compareCriterias = new String[4];
		compareCriterias[0] = "BASIC";
		compareCriterias[1] = "SHOOTING";
		compareCriterias[2] = "REBOUNDS";
		compareCriterias[3] = "X-FACTOR";

		basicButton = new ChooseButton("基本数据⊙");
		basicButton.setLocation(0, 70);
		basicButton.addActionListener(e -> {
			basicButton.setText("基本数据⊙");
			shootingButton.setText("投篮数据");
			reboundsButton.setText("篮板数据");
			XfactorButton.setText("X-因素");
			guestCriteriaSelected("BASIC");
			hostCriteriaSelected("BASIC");
		});
		datalbl.add(basicButton);
		shootingButton = new ChooseButton("投篮数据");
		shootingButton.setLocation(155, 70);
		shootingButton.addActionListener(e -> {
			basicButton.setText("基本数据");
			shootingButton.setText("投篮数据⊙");
			reboundsButton.setText("篮板数据");
			XfactorButton.setText("X-因素");
			guestCriteriaSelected("SHOOTING");
			hostCriteriaSelected("SHOOTING");
		});
		datalbl.add(shootingButton);
		reboundsButton = new ChooseButton("篮板数据");
		reboundsButton.setLocation(310, 70);
		reboundsButton.addActionListener(e -> {
			basicButton.setText("基本数据");
			shootingButton.setText("投篮数据");
			reboundsButton.setText("篮板数据⊙");
			XfactorButton.setText("X-因素");
			guestCriteriaSelected("REBOUNDS");
			hostCriteriaSelected("REBOUNDS");
		});
		datalbl.add(reboundsButton);
		XfactorButton = new ChooseButton("X-因素");
		XfactorButton.setLocation(465, 70);
		XfactorButton.addActionListener(e -> {
			basicButton.setText("基本数据");
			shootingButton.setText("投篮数据");
			reboundsButton.setText("篮板数据");
			XfactorButton.setText("X-因素⊙");
			guestCriteriaSelected("X-FACTOR");
			hostCriteriaSelected("X-FACTOR");
		});
		datalbl.add(XfactorButton);

		guestTeamDatalbl = new JLabel();
		guestTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamDatalbl.setBounds(0, 0, 550, 100);
		guestTeamDatalbl.setBackground(Color.blue);
		datalbl.add(guestTeamDatalbl);

		hostTeamDatalbl = new JLabel();
		hostTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamDatalbl.setBounds(550, 0, 550, 100);
		hostTeamDatalbl.setBackground(Color.blue);
		datalbl.add(hostTeamDatalbl);

		ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
				.getGuestTP();
		guestPlayerVos = guestTeamPerformanceInSingleGame.getPlayerList();
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		guestColumn = new Vector<String>();
		guestColumn.add("球员");
		guestColumn.add("姓名");
		guestColumn.add("号码");
		guestColumn.add("时间");
		guestColumn.add("得分");
		guestColumn.add("助攻");
		guestColumn.add("个人犯规");
		for (int i = 0; i < guestPlayerVos.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add(String.valueOf(guestPlayerVos.get(i).getName()));
			a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
			a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
			a.add(String.valueOf(guestPlayerVos.get(i).getScore()));
			a.add(String.valueOf(guestPlayerVos.get(i).getAssistance()));
			a.add(String.valueOf(guestPlayerVos.get(i).getFoul()));
			guestRowData.add(a);
		}
		if (guestTable != null) {
			guestTable.setVisible(false);
		}

		if (guestScrollPane != null) {
			guestScrollPane.setVisible(false);
		}

		guestTable = new JTable(guestRowData, guestColumn);
		JTableHeader header = guestTable.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setPreferredSize(new Dimension(550, 50));
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		guestTable.setDefaultRenderer(Object.class, r2);

		guestTable.setForeground(Color.WHITE);
		/*
		 * DefaultTableCellRenderer guestTableHeaderRenderer = new
		 * DefaultTableCellRenderer();
		 * guestTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		 * guestTableHeaderRenderer
		 * .setHorizontalAlignment(SwingConstants.CENTER);
		 * guestTableHeaderRenderer.setOpaque(false);
		 * guestTable.getTableHeader()
		 * .setDefaultRenderer(guestTableHeaderRenderer);
		 * 
		 * guestTable.setForeground(Color.WHITE);
		 */
		// guestTable.setShowVerticalLines(false);
		guestTable.setIntercellSpacing(new Dimension(0, 0));
		guestTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		guestTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		guestTable.setRowHeight(70);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		guestTable.setOpaque(false);
		guestTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("guest"));

		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		guestScrollPane.setBounds(0, 100, 550, 400);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);

		datalbl.add(guestScrollPane);

		ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo
				.getHomeTP();
		hostPlayerVos = hostTeamPerformanceInSingleGame.getPlayerList();
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		hostColumn = new Vector<String>();
		hostColumn.add("球员");
		hostColumn.add("姓名");
		hostColumn.add("号码");
		hostColumn.add("时间");
		hostColumn.add("得分");
		hostColumn.add("助攻");
		hostColumn.add("个人犯规");
		for (int i = 0; i < hostPlayerVos.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add(String.valueOf(hostPlayerVos.get(i).getName()));
			a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
			a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
			a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
			a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
			a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
			hostRowData.add(a);
		}

		if (hostTable != null) {
			hostTable.setVisible(false);
		}

		if (hostScrollPane != null) {
			hostScrollPane.setVisible(false);
		}

		hostTable = new JTable(hostRowData, hostColumn);
		JTableHeader header1 = hostTable.getTableHeader();
		header1.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header1.getDefaultRenderer())
				.setPreferredSize(new Dimension(550, 50));
		((DefaultTableCellRenderer) header1.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r3 = new MyTableRenderer();
		r3.setHorizontalAlignment(JLabel.CENTER);
		hostTable.setDefaultRenderer(Object.class, r3);

		hostTable.setForeground(Color.WHITE);
		// hostTable.getTableHeader().setBackground(Color.BLACK);
		hostTable.setIntercellSpacing(new Dimension(0, 0));
		hostTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		hostTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		hostTable.setRowHeight(70);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		hostTable.setOpaque(false);
		hostTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("host"));

		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		hostScrollPane.setBounds(550, 100, 550, 400);
		hostScrollPane.setVisible(true);
		hostScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hostScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hostScrollPane.getViewport().setOpaque(false);
		hostScrollPane.setOpaque(false);

		datalbl.add(hostScrollPane);

		bgLabel.add(datalbl);
	}

	public void guestCriteriaSelected(String guestDataCriteria) {
		ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
				.getGuestTP();
		guestPlayerVos = guestTeamPerformanceInSingleGame.getPlayerList();
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		if (guestDataCriteria == "BASIC") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("时间");
			guestColumn.add("得分");
			guestColumn.add("助攻");
			guestColumn.add("个人犯规");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getScore()));
				a.add(String.valueOf(guestPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(guestPlayerVos.get(i).getFoul()));
				guestRowData.add(a);
			}
		} else if (guestDataCriteria == "SHOOTING") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("时间");
			guestColumn.add("命中数");
			guestColumn.add("三分命中数");
			guestColumn.add("罚球命中数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getHitNum()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getThreePointHitNum()));
				a.add(String
						.valueOf(guestPlayerVos.get(i).getFreeThrowHitNum()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "REBOUNDS") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("时间");
			guestColumn.add("进攻篮板");
			guestColumn.add("防守篮板");
			guestColumn.add("总篮板数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getOffensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getDefensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i).getReboundOverall()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "X-FACTOR") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("时间");
			guestColumn.add("抢断");
			guestColumn.add("盖帽");
			guestColumn.add("失误");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(guestPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTurnover()));
				guestRowData.add(a);
			}

		} else {
			System.out.println("guestDataCriteria in GameInfoPanel！！！");
		}

		if (guestTable != null) {
			guestTable.setVisible(false);
		}

		if (guestScrollPane != null) {
			guestScrollPane.setVisible(false);
		}

		guestTable = new JTable(guestRowData, guestColumn);
		JTableHeader header = guestTable.getTableHeader();
		header.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setPreferredSize(new Dimension(550, 50));
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		guestTable.setDefaultRenderer(Object.class, r2);

		guestTable.setForeground(Color.WHITE);
		/*
		 * DefaultTableCellRenderer guestTableHeaderRenderer = new
		 * DefaultTableCellRenderer();
		 * guestTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		 * guestTableHeaderRenderer
		 * .setHorizontalAlignment(SwingConstants.CENTER);
		 * guestTableHeaderRenderer.setOpaque(false);
		 * guestTable.getTableHeader()
		 * .setDefaultRenderer(guestTableHeaderRenderer);
		 * 
		 * guestTable.setForeground(Color.WHITE);
		 */

		guestTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		guestTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		guestTable.setRowHeight(70);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		guestTable.setOpaque(false);
		guestTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("guest"));

		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		guestScrollPane.setBounds(0, 100, 550, 400);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);

		datalbl.add(guestScrollPane);

	}

	public void hostCriteriaSelected(String hostDataCriteria) {

		ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo
				.getHomeTP();
		hostPlayerVos = hostTeamPerformanceInSingleGame.getPlayerList();
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		if (hostDataCriteria == "BASIC") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("时间");
			hostColumn.add("得分");
			hostColumn.add("助攻");
			hostColumn.add("个人犯规");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
				a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
				hostRowData.add(a);
			}
		} else if (hostDataCriteria == "SHOOTING") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("时间");
			hostColumn.add("命中数");
			hostColumn.add("三分命中数");
			hostColumn.add("罚球命中数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getHitNum()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getThreePointHitNum()));
				a.add(String.valueOf(hostPlayerVos.get(i).getFreeThrowHitNum()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "REBOUNDS") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("时间");
			hostColumn.add("进攻篮板");
			hostColumn.add("防守篮板");
			hostColumn.add("总篮板数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getOffensiveRebound()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getDefensiveRebound()));
				a.add(String.valueOf(hostPlayerVos.get(i).getReboundOverall()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "X-FACTOR") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("时间");
			hostColumn.add("抢断");
			hostColumn.add("盖帽");
			hostColumn.add("失误");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(hostPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTurnover()));
				hostRowData.add(a);
			}

		} else {
			System.out.println("hostDataCriteria in GameInfoPanel！！！");
		}

		if (hostTable != null) {
			hostTable.setVisible(false);
		}

		if (hostScrollPane != null) {
			hostScrollPane.setVisible(false);
		}

		hostTable = new JTable(hostRowData, hostColumn);
		JTableHeader header1 = hostTable.getTableHeader();
		header1.setDefaultRenderer(new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				Component cell = super.getTableCellRendererComponent(table,
						value, isSelected, hasFocus, row, column);
				cell.setBackground(Color.DARK_GRAY);
				return cell;
			}

		});
		((DefaultTableCellRenderer) header1.getDefaultRenderer())
				.setPreferredSize(new Dimension(550, 50));
		((DefaultTableCellRenderer) header1.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r3 = new MyTableRenderer();
		r3.setHorizontalAlignment(JLabel.CENTER);
		hostTable.setDefaultRenderer(Object.class, r3);
		;

		hostTable.setForeground(Color.WHITE);
		hostTable.getTableHeader().setBackground(Color.BLACK);
		hostTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		hostTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		hostTable.setRowHeight(70);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		hostTable.setOpaque(false);
		hostTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("host"));

		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		hostScrollPane.setBounds(550, 100, 550, 400);
		hostScrollPane.setVisible(true);
		hostScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hostScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hostScrollPane.getViewport().setOpaque(false);
		hostScrollPane.setOpaque(false);

		datalbl.add(hostScrollPane);

	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame, MainFrame.analysisPanel,
				MainFrame.playerPanel, MainFrame.teamPanel, MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel = "StartPanel";
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		mainFrame.add(previousPanel);
		MainFrame.currentPanel = previouspanel;
	}

	public void refresh() {
		mainFrame.remove(this);
		MainFrame.gameInfoPanel = new GameInfoPanel(gameVo, mainFrame,
				previousPanel, previouspanel);
		if (MainFrame.currentPanel == "PlayerInfoPanel") {
			MainFrame.playerInfoPanel.setVisible(true);
		} else {
			MainFrame.playerInfoPanel.setVisible(false);
		}

	}

	public void selfClose() {
		this.setVisible(false);
	}

	public GameInfoPanel getSelf() {
		return this;
	}

	class PlayerRenderer extends JButton implements TableCellRenderer {
		String name;
		boolean isGuest;

		public PlayerRenderer(String s) {
			if (s.endsWith("guest")) {
				isGuest = true;
			} else {
				isGuest = false;
			}
		}

		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object arg1, boolean arg2, boolean isSelected, int row,
				int column) {
			// TODO Auto-generated method stub
			if (isGuest) {
				this.name = (String) guestTable.getValueAt(row, 1);
			} else {
				this.name = (String) hostTable.getValueAt(row, 1);
			}

			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + this.name + ".png")
					.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			if (isSelected) {
				previousPanel.setVisible(false);
				PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(
						this.name, mainFrame, getSelf(), previouspanel);
				MainFrame.currentPanel = "PlayerInfoPanel";
				selfClose();
			}
			return this;
		}

	}

	class PlayerBasicInfoPanel extends JPanel {
		public PlayerBasicInfoPanel(PlayerPerformanceInSingleGame pp, int x,
				int y) {
			this.setVisible(true);
			this.setLayout(null);
			// this.setOpaque(false);
			this.setBackground(Color.DARK_GRAY);
			this.setBounds(x, y, X * 125 / 1366, Y * 80 / 768);
			JLabel bgLabel = new JLabel();
			/*
			 * ImageIcon bgIcon = new ImageIcon(new ImageIcon(
			 * "CSEdata/court_png/"
			 * +gameVo.getHomeTeam()+"_court.png").getImage().getScaledInstance(
			 * X*1100/1366, Y*500/768, Image.SCALE_SMOOTH));
			 * 
			 * bgLabel.setIcon(bgIcon);
			 */
			bgLabel.setBackground(Color.DARK_GRAY);
			bgLabel.setBounds(0, 0, X * 125 / 1366, Y * 80 / 768);
			this.add(bgLabel);

			JLabel namelbl = new MyLabel("姓名：");
			namelbl.setHorizontalAlignment(SwingConstants.CENTER);
			namelbl.setBounds(X * 2 / 1366, Y * 5 / 768, X * 33 / 1366,
					Y * 16 / 768);
			// namelbl.setOpaque(false);
			namelbl.setFont(new Font("黑体", 1, 10));
			bgLabel.add(namelbl);

			JTextField nametF = new MyTextField();
			nametF.setText(pp.getName());
			nametF.setHorizontalAlignment(SwingConstants.CENTER);
			nametF.setBounds(X * 35 / 1366, Y * 5 / 768, X * 90 / 1366,
					Y * 16 / 768);
			nametF.setFont(new Font("黑体", 1, 9));
			nametF.setBorder(null);
			bgLabel.add(nametF);

			JLabel numberlbl = new MyLabel("号码：");
			numberlbl.setHorizontalAlignment(SwingConstants.CENTER);
			numberlbl.setBounds(X * 2 / 1366, Y * 23 / 768, X * 33 / 1366,
					Y * 16 / 768);
			// numberlbl.setOpaque(false);
			numberlbl.setFont(new Font("黑体", 1, 10));
			bgLabel.add(numberlbl);

			JTextField numbertF = new MyTextField();
			numbertF.setText(pp.getNumber());
			numbertF.setHorizontalAlignment(SwingConstants.CENTER);
			numbertF.setBounds(X * 37 / 1366, Y * 23 / 768, X * 90 / 1366,
					Y * 16 / 768);
			numbertF.setFont(new Font("黑体", 1, 10));
			numbertF.setBorder(null);
			bgLabel.add(numbertF);

			JLabel positionlbl = new MyLabel("位置：");
			positionlbl.setHorizontalAlignment(SwingConstants.CENTER);
			positionlbl.setBounds(X * 2 / 1366, Y * 41 / 768, X * 33 / 1366,
					Y * 16 / 768);
			// positionlbl.setOpaque(false);
			positionlbl.setFont(new Font("黑体", 1, 10));
			bgLabel.add(positionlbl);

			JTextField positiontF = new MyTextField();
			positiontF.setText(pp.getPosition());
			positiontF.setHorizontalAlignment(SwingConstants.CENTER);
			positiontF.setBounds(X * 37 / 1366, Y * 41 / 768, X * 90 / 1366,
					Y * 16 / 768);
			positiontF.setFont(new Font("黑体", 1, 10));
			positiontF.setBorder(null);
			bgLabel.add(positiontF);

			JLabel scorelbl = new MyLabel("得分：");
			scorelbl.setHorizontalAlignment(SwingConstants.CENTER);
			scorelbl.setBounds(X * 2 / 1366, Y * 59 / 768, X * 33 / 1366,
					Y * 16 / 768);
			// scorelbl.setOpaque(false);
			scorelbl.setFont(new Font("黑体", 1, 10));
			bgLabel.add(scorelbl);

			JTextField scoretF = new MyTextField();
			scoretF.setText(String.valueOf(pp.getScore()));
			scoretF.setHorizontalAlignment(SwingConstants.CENTER);
			scoretF.setBounds(X * 37 / 1366, Y * 59 / 768, X * 90 / 1366,
					Y * 16 / 768);
			scoretF.setFont(new Font("黑体", 1, 10));
			scoretF.setBorder(null);
			bgLabel.add(scoretF);

			this.add(bgLabel);
		}

	}

	public class MyTableRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean cellHasFocus,
				int row, int col) {

			if ((row % 2) == 1)
				setOpaque(false);
			else
				setOpaque(false);

			setText((value == null) ? "" : value.toString());

			return this;
		}
	}

	class MyButton extends JButton {
		/**
		 * 
		 */
		Shape shape;
		private static final long serialVersionUID = 1L;

		public MyButton() {
			super();
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setFont(new Font("微软雅黑", 1, 15));
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
		}

		public MyButton(String s) {
			super();
			this.setText(s);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setFont(new Font("微软雅黑", 1, 15));
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
		}

		protected void paintComponent(Graphics g) {
			Image oval = new ImageIcon("Image/Oval.png").getImage();
			oval.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
			g.drawImage(oval, 0, 0, 80, 80, null);
			super.paintComponent(g);
		}
	}

	class ChooseButton extends JButton {
		public ChooseButton(String s) {
			super();
			this.setText(s);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑", 1, 15));
			this.setSize(155, 30);
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(
					X * 155 / 1366, Y * 30 / 768, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
		}

	}

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

	}

	class MyLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyLabel() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(String text) {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 13));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 13));

		}
	}
}
