package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
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
import vo.liveText;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import po.GamePO;
import po.PlayerPO;
import po.TeamPO;

public class LiveInfoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	static GameVo gameVo =null;
	JFrame mainFrame;
	// JPanel previousPanel;
	// String previouspanel;

	String currentState = "live";
	static ArrayList<liveText> liveTextList = null;
	static ArrayList<TeamPO> teamDataList = null;
	static ArrayList<PlayerPO> guestPlayerDataList = null;
	static ArrayList<PlayerPO> hostPlayerDataList = null;

	TeamPO guestTeamPo = null;
	TeamPO hostTeamPo = null;

	Game_BS game_BS = new Game_BL_Stub();

	private JTable liveTable;
	private JScrollPane liveScrollPane;
	Vector<Vector<String>> liveRowData;

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
	private JLabel liveTextlbl;
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

	ArrayList<PlayerPerformanceInSingleGame> guestFirstPlayerList;
	ArrayList<PlayerPerformanceInSingleGame> hostFirstPlayerList;

	private JLabel summarylbl;
	JLabel gameInfolbl;

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


	public LiveInfoPanel(JFrame mainFrame) {
		// previousPanel.setVisible(false);
		this.mainFrame = mainFrame;
		
		
		
		
	    //------------------------------初始gameVo，先用原先的桩测试-----------------------------
		gameVo=game_BS.getAllGames().get(0);
		//------------------------------------------------------------------------------------
		
		
		
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);

		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);

		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);

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

		txtState = new MyTextField();
		txtState.setText("进行中");
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

		JButton startingbtn = new ChooseButton("文字直播");
		startingbtn.setBounds(X * 450 / 1366, Y * 155 / 768, X * 155 / 1366,
				Y * 30 / 768);
		startingbtn.addActionListener(e -> {
			currentState = "live";
			live(liveTextList);
		});
		bgLabel.add(startingbtn);

		JButton summarybtn = new ChooseButton("球队数据");
		summarybtn.setBounds(X * 605 / 1366, Y * 155 / 768, X * 155 / 1366,
				Y * 30 / 768);
		summarybtn.addActionListener(e -> {
			currentState = "teamDataLive";
			teamDataLive(guestTeamPo, hostTeamPo);
		});
		bgLabel.add(summarybtn);

		JButton databtn = new ChooseButton("球员数据");
		databtn.setBounds(X * 760 / 1366, Y * 155 / 768, X * 155 / 1366,
				Y * 30 / 768);
		databtn.addActionListener(e -> {
			currentState = "playerDataLive";
			playerDataLive(guestPlayerDataList, hostPlayerDataList);
		});
		bgLabel.add(databtn);

		gameDataLive(gameVo);
		live(liveTextList);

		mainFrame.getContentPane().add(this);

	}

	public void gameDataLive(GameVo gameVo) {
		int spaceX = 565;
		int spaceY = 50;
		int tempX = 30;
		int tempY = 25;

		guestTeambtn = new JButton();
		guestTeambtn.setHorizontalAlignment(SwingConstants.CENTER);

		guestTeambtn.setBounds(X * 230 / 1366, Y * 34 / 768, X * 160 / 1366,
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
					mainFrame, this, "LiveInfoPanel");
		});
		bgLabel.add(guestTeambtn);

		hostTeambtn = new JButton();
		hostTeambtn.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeambtn.setText(gameVo.getHomeTeam());
		hostTeambtn.setBounds(X * 970 / 1366, Y * 34 / 768, X * 160 / 1366,
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
					mainFrame, this, "LiveInfoPanel");
		});
		bgLabel.add(hostTeambtn);

		txtGTPoint = new MyTextField();
		txtGTPoint.setText(String.valueOf(gameVo.getGuestTP().getScore()));
		txtGTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTPoint.setBounds(X * 430 / 1366, Y * 67 / 768, X * 120 / 1366,
				Y * 60 / 768);
		txtGTPoint.setFont(new Font("微软雅黑", 1, 40));
		// txtGTPoint.setBorder(null);
		bgLabel.add(txtGTPoint);

		txtHTPoint = new MyTextField();
		txtHTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTPoint.setText(String.valueOf(gameVo.getHomeTP().getScore()));
		txtHTPoint.setBounds(X * 830 / 1366, Y * 67 / 768, X * 120 / 1366,
				Y * 60 / 768);
		txtHTPoint.setFont(new Font("微软雅黑", 1, 40));
		// txtHTPoint.setBorder(null);
		bgLabel.add(txtHTPoint);

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

	}

	public void live(ArrayList<liveText> liveTextList) {
	
		currentState = "live";
		System.out.println(currentState);
		
		//---------------------------------------Steve Jin(在场队员）liveText里须加属性：是否为替换队员，我才能替换掉在场队员！！！--------------------------------------------
		guestFirstPlayerList = new ArrayList<PlayerPerformanceInSingleGame>();
		guestFirstPlayerList = (gameVo.getGuestTP()).getFirstonList();
		hostFirstPlayerList = new ArrayList<PlayerPerformanceInSingleGame>();
		hostFirstPlayerList = (gameVo.getHomeTP()).getFirstonList();

		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (liveTextlbl != null) {
			liveTextlbl.setVisible(false);
		}
		if (liveScrollPane != null) {
			liveScrollPane.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		courtlbl = new MyLabel();
		courtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		courtlbl.setBounds(X * 0 / 1366, Y * 234 / 768, X * 850 / 1366,
				Y * 386 / 768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon("CSEdata/court_png/"
				+ gameVo.getHomeTeam() + "_court.png").getImage()
				.getScaledInstance(X * 850 / 1366, Y * 386 / 768,
						Image.SCALE_SMOOTH));
		courtlbl.setIcon(buttonIcon);

		liveTextlbl = new MyLabel();
		liveTextlbl.setHorizontalAlignment(SwingConstants.CENTER);
		liveTextlbl.setBounds(X * 210 / 1366, Y * 670 / 768, X * 430 / 1366,
				Y * 30 / 768);
		liveTextlbl.setOpaque(false);
		// liveTextlbl.setBackground(Color.WHITE);
		liveTextlbl.setVisible(true);
		if (liveTextList != null) {
			liveTextlbl.setText(liveTextList.get(0).getEvent());
		}

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
		btnG1.setBounds(X * 340 / 1366, Y * 165 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitG1 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(0).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerG1Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

				playerG1Panel.setVisible(false);
				// selfClose();
				/*
				 * MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * guestFirstPlayerList.get(0).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnG1);

		btnG2 = new MyButton();
		btnG2.setBounds(X * 260 / 1366, Y * 45 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitG2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(1).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerG2Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG2Panel.setVisible(false);
				// selfClose();
				/*
				 * MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * guestFirstPlayerList.get(1).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnG2);

		btnG3 = new MyButton();
		btnG3.setBounds(X * 100 / 1366, Y * 295 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitG3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(2).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerG3Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG3Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * guestFirstPlayerList.get(2).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnG3);

		btnG4 = new MyButton();
		btnG4.setBounds(X * 130 / 1366, Y * 123 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitG4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(3).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerG4Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG4Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * guestFirstPlayerList.get(3).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnG4);

		btnG5 = new MyButton();
		btnG5.setBounds(X * 260 / 1366, Y * 270 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitG5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ guestFirstPlayerList.get(4).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerG5Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerG5Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * guestFirstPlayerList.get(4).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnG5);

		btnH1 = new MyButton();
		btnH1.setBounds(X * 440 / 1366, Y * 165 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitH1 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(0).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerH1Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH1Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * hostFirstPlayerList.get(0).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnH1);

		btnH2 = new MyButton();
		btnH2.setBounds(X * 550 / 1366, Y * 285 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitH2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(1).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerH2Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH2Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * hostFirstPlayerList.get(1).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnH2);

		btnH3 = new MyButton();
		btnH3.setBounds(X * 640 / 1366, Y * 35 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitH3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(2).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerH3Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH3Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * hostFirstPlayerList.get(2).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnH3);

		btnH4 = new MyButton();
		btnH4.setBounds(X * 670 / 1366, Y * 207 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitH4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(3).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerH4Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH4Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * hostFirstPlayerList.get(3).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnH4);

		btnH5 = new MyButton();
		btnH5.setBounds(X * 505 / 1366, Y * 60 / 768, X * 60 / 1366,
				Y * 60 / 768);
		ImageIcon playerPortraitH5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/"
						+ hostFirstPlayerList.get(4).getName() + ".png")
				.getImage().getScaledInstance(X * 60 / 1366, Y * 60 / 768,
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
				// playerH5Panel.setVisible(true);

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				playerH5Panel.setVisible(false);
				/*
				 * selfClose(); MainFrame.playerInfoPanel = new PlayerInfoPanel(
				 * hostFirstPlayerList.get(4).getName(), mainFrame, new
				 * LiveInfoPanel(gameVo, mainFrame, previousPanel,
				 * previouspanel), "LiveInfoPanel");
				 * mainFrame.add(MainFrame.playerInfoPanel);
				 */
			}
		});
		courtlbl.add(btnH5);

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		for (int i = 0; i < 10; i++) {
			gameVos.add(game_BS.getAllGames().get(i));
		}
		if (liveRowData == null) {
			liveRowData = new Vector<Vector<String>>();
		} else {
			liveRowData.clear();
		}

		Vector<String> a;
		if (liveTextList != null) {
			for (int i = 0; i < liveTextList.size(); i++) {
				a = new Vector<String>();
				a.add(liveTextList.get(i).getTime());
				a.add(liveTextList.get(i).getTeam());
				a.add(liveTextList.get(i).getPlayer());
				a.add(liveTextList.get(i).getEvent());
				liveRowData.add(a);
			}
		}
		Vector<String> column = new Vector<String>();
		column.add("时间");
		column.add("球队");
		column.add("参与球员");
		column.add("文字直播");
		/*
		 * DefaultTableModel dtm = new DefaultTableModel(liveRowData, column) {
		 * 
		 * private static final long serialVersionUID = 1L;
		 * 
		 * public boolean isCellEditable(int row, int column) { return false; }
		 * };
		 * 
		 * if (liveTable != null) { liveTable.setVisible(false); } liveTable =
		 * new JTable(dtm);
		 */
		liveTable = new JTable(liveRowData, column);
		JTableHeader header = liveTable.getTableHeader();
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
		MyTableRenderer r3 = new MyTableRenderer();
		r3.setHorizontalAlignment(JLabel.CENTER);
		liveTable.setDefaultRenderer(Object.class, r3);

		liveTable.setRowHeight(Y * 30 / 768);
		liveTable.getColumnModel().getColumn(0)
				.setPreferredWidth(X * 70 / 1366);
		liveTable.getColumnModel().getColumn(1)
				.setPreferredWidth(X * 40 / 1366);
		liveTable.getColumnModel().getColumn(2)
				.setPreferredWidth(X * 60 / 1366);
		liveTable.getColumnModel().getColumn(3)
				.setPreferredWidth(X * 315 / 1366);
		liveTable.setForeground(Color.WHITE);
		liveTable.setVisible(true);
		liveTable.setCellSelectionEnabled(true);
		liveTable.setOpaque(false);
		if (liveScrollPane != null) {
			liveScrollPane.setVisible(false);
		}
		liveScrollPane = new JScrollPane(liveTable);
		liveScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		liveScrollPane.setBounds(X * 865 / 1366, Y * 220 / 768, X * 485 / 1366,
				Y * 500 / 768);
		liveScrollPane.setVisible(true);
		liveScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		liveScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		liveScrollPane.getViewport().setOpaque(false);
		liveScrollPane.setOpaque(false);

		bgLabel.add(courtlbl);
		bgLabel.add(liveTextlbl);
		bgLabel.add(liveScrollPane);

	}

	public void teamDataLive(TeamPO guestTeamPo, TeamPO hostTeamPo) {

		currentState = "teamDataLive";
		System.out.println(currentState);
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (liveTextlbl != null) {
			liveTextlbl.setVisible(false);
		}
		if (liveScrollPane != null) {
			liveScrollPane.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		summarylbl = new MyLabel();
		summarylbl.setHorizontalAlignment(SwingConstants.CENTER);
		summarylbl.setBounds(X * 0 / 1366, Y * 194 / 768, X * 1231 / 1366,
				Y * 560 / 768);

		MyLabel hitRatelbl = new MyLabel("命中率");
		hitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		hitRatelbl.setBounds(X * 607 / 1366, Y * 100 / 768, X * 150 / 1366,
				Y * 68 / 768);
		hitRatelbl.setFont(new Font("微软雅黑", 1, 16));
		summarylbl.add(hitRatelbl);
		
		
		 JLabel guestHitRatelbl = new JLabel();
		 guestHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		 /*
		 guestHitRatelbl.setBounds(X * (607 - guestTeamPo.get??? * 3) /
		 1366, Y * 175 / 768, X * (playerInfo.getGameNum() * 3) / 1366, Y * 24
		  / 768); 
		 if (playerInfo.getGameNum() >= aveInfo.getGamenumField()) {
			  guestHitRatelbl.setBackground(Color.BLUE); 
			  } else {
				  guestHitRatelbl.setBackground(Color.LIGHT_GRAY); 
				  }*/
		  guestHitRatelbl.setOpaque(true); 
		  summarylbl.add(guestHitRatelbl);

		  
		  JLabel hostHitRatelbl = new JLabel();
		  hostHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		  /*
		  hostHitRatelbl .setBounds( X * 757 / 1366, Y * 175 / 768, X *(Integer
			  .parseInt(new java.text.DecimalFormat( "0").format(aveInfo
			  .getGamenumField())) * 3) / 1366, Y * 24 / 768); 
		  if(playerInfo.getGameNum() >= aveInfo.getGamenumField()) {
				  hostHitRatelbl.setBackground(Color.LIGHT_GRAY); 
				  } else {
					  hostHitRatelbl.setBackground(Color.BLUE); 
					  }*/
			  hostHitRatelbl.setOpaque(true); summarylbl.add(hostHitRatelbl);
		  
		  

		MyLabel threePointHitRatelbl = new MyLabel("三分命中率");
		threePointHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		threePointHitRatelbl.setBounds(X * 607 / 1366, Y * 168 / 768, X * 150 / 1366,
				Y * 68 / 768);
		threePointHitRatelbl.setFont(new Font("微软雅黑", 1, 16));
		summarylbl.add(threePointHitRatelbl);

		
		 JLabel guestThreePointHitRatelbl = new JLabel();
		 guestThreePointHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		 /*
		 guestThreePointHitRatelbl.setBounds( X (607 - Integer.parseInt(new
		  java.text.DecimalFormat( "0").format(playerInfo.getScoreField())) *
		  3) / 1366, Y * 243 / 768, X *(Integer.parseInt(new
		  java.text.DecimalFormat("0") .format(playerInfo.getScoreField())) *
		  3) / 1366, Y * 24 / 768); 
		 if (playerInfo.getScoreField() >=aveInfo.getScoreField()) {
			  guestThreePointHitRatelbl.setBackground(Color.BLUE); 
			  } else {
				  guestThreePointHitRatelbl.setBackground(Color.LIGHT_GRAY); 
				  }*/
		  guestThreePointHitRatelbl.setOpaque(true);
		  summarylbl.add(guestThreePointHitRatelbl);
		
		  JLabel hostThreePointHitRatelbl = new JLabel();
		  hostThreePointHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		  /*
		  hostThreePointHitRatelbl.setBounds( X * 757 / 1366, Y * 243 / 768, X*(Integer.parseInt(new java.text.DecimalFormat("0")
			 .format(aveInfo.getScoreField())) * 3) / 1366, Y * 24 / 768); 
		  if(playerInfo.getScoreField() >= aveInfo.getScoreField()) {
				 hostThreePointHitRatelbl.setBackground(Color.LIGHT_GRAY);
				 } else {
					 hostThreePointHitRatelbl.setBackground(Color.BLUE); 
					 }*/
			 hostThreePointHitRatelbl.setOpaque(true); summarylbl.add(hostThreePointHitRatelbl);
			 
		  
		  
		  
		  

		MyLabel freeThrowHitRatelbl = new MyLabel("罚球命中率");
		freeThrowHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		freeThrowHitRatelbl.setBounds(X * 607 / 1366, Y * 236 / 768,
				X * 150 / 1366, Y *68 / 768);
		freeThrowHitRatelbl.setFont(new Font("微软雅黑", 1, 16));
		summarylbl.add(freeThrowHitRatelbl);

		
		JLabel guestFreeThrowHitRatelbl = new JLabel();
		guestFreeThrowHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		/*
		guestFreeThrowHitRatelbl .setBounds( X (607 - Integer .parseInt(new
		  java.text.DecimalFormat( "0").format(playerInfo.getReboundOverallField())) * 3) / 1366, Y * 311 / 768, X *(Integer
		  .parseInt(new java.text.DecimalFormat( "0").format(playerInfo
		  .getReboundOverallField())) * 3) / 1366, Y * 24 / 768); 
		if(playerInfo.getReboundOverallField() >= aveInfo.getReboundField()) {
			  guestFreeThrowHitRatelbl.setBackground(Color.BLUE); 
			  } else {
				  guestFreeThrowHitRatelbl.setBackground(Color.LIGHT_GRAY); 
				  }*/
		  guestFreeThrowHitRatelbl.setOpaque(true);
		  summarylbl.add(guestFreeThrowHitRatelbl);
		 
		   JLabel hostFreeThrowHitRatelbl = new JLabel();
		   hostFreeThrowHitRatelbl.setHorizontalAlignment(SwingConstants.CENTER);
		   /*
		   hostFreeThrowHitRatelbl .setBounds( X * 757 / 1366, Y * 311 / 768, X*(Integer .parseInt(new java.text.DecimalFormat( "0").format(aveInfo.getReboundField())) * 3) / 1366, Y * 24 / 768); 
		   if (playerInfo.getReboundOverallField() >= aveInfo.getReboundField()) {
				 hostFreeThrowHitRatelbl.setBackground(Color.LIGHT_GRAY); 
				 } else {
					 hostFreeThrowHitRatelbl.setBackground(Color.BLUE); 
					 }*/
			 hostFreeThrowHitRatelbl.setOpaque(true);
			  summarylbl.add(hostFreeThrowHitRatelbl);
		 
		
		
		

		MyLabel reboundlbl = new MyLabel("篮板");
		reboundlbl.setHorizontalAlignment(SwingConstants.CENTER);
		reboundlbl.setBounds(X * 607 / 1366, Y * 304 / 768, X * 150 / 1366,
				Y * 68 / 768);
		reboundlbl.setFont(new Font("微软雅黑", 1, 16));
		summarylbl.add(reboundlbl);

		
		 JLabel guestReboundlbl = new JLabel();
		 guestReboundlbl.setHorizontalAlignment(SwingConstants.CENTER);
		 /*
		 guestReboundlbl .setBounds( X (607 - Integer .parseInt(new
		  java.text.DecimalFormat( "0").format(playerInfo
		  .getThreePointHitRate() * 100)) * 3) / 1366, Y * 379 / 768, X*
		  (Integer .parseInt(new java.text.DecimalFormat(
		  "0").format(playerInfo .getThreePointHitRate() * 100)) * 3) / 1366, Y * 24 / 768); 
		 if (playerInfo.getThreePointHitRate() >=aveInfo.getThreeRate()) { 
			 lblPlayer3prate.setBackground(Color.BLUE);
		  } else { 
			  guestReboundlbl.setBackground(Color.LIGHT_GRAY); 
			  }
		 */
		  guestReboundlbl.setOpaque(true); summarylbl.add(guestReboundlbl);
		 
		 
		  
		  JLabel hostReboundlbl = new JLabel();
		  hostReboundlbl.setHorizontalAlignment(SwingConstants.CENTER);
		  /*
		  hostReboundlbl.setBounds( X * 757 / 1366, Y * 379 / 768, X*
		  (Integer.parseInt(new java.text.DecimalFormat("0")
		  .format(aveInfo.getThreeRate() * 100)) * 3) / 1366, Y * 24 / 768); 
		  if(playerInfo.getThreePointHitRate() >= aveInfo.getThreeRate()) {
			  hostReboundlbl.setBackground(Color.LIGHT_GRAY); 
			  } else {
				  hostReboundlbl.setBackground(Color.BLUE); 
				  }
				  */
		  hostReboundlbl.setOpaque(true); 
		  summarylbl.add(hostReboundlbl);
		

		MyLabel assistancelbl = new MyLabel("助攻");
		assistancelbl.setHorizontalAlignment(SwingConstants.CENTER);
		assistancelbl.setBounds(X * 607 / 1366, Y * 372 / 768, X * 150 / 1366,
				Y * 68 / 768);
		assistancelbl.setFont(new Font("微软雅黑", 1, 16));
		summarylbl.add(assistancelbl);

		 JLabel guestAssistancelbl = new JLabel();
		 guestAssistancelbl.setHorizontalAlignment(SwingConstants.CENTER);
		 /*
		 guestAssistancelbl.setBounds( X (607 - Integer.parseInt(new
		  java.text.DecimalFormat( "0").format(playerInfo.getStealField())) *
		  3) / 1366, Y * 447 / 768, X *(Integer.parseInt(new
		  java.text.DecimalFormat("0") .format(playerInfo.getStealField())) *
		  3) / 1366, Y * 24 / 768);  
		 if (playerInfo.getStealField() >= aveInfo.getStealField()) { guestAssistancelbl.setBackground(Color.BLUE);
		  } else {
			  guestAssistancelbl.setBackground(Color.LIGHT_GRAY); 
		   }
		   */
		  guestAssistancelbl.setOpaque(true); 
		  summarylbl.add(guestAssistancelbl);

		 
		 
		  JLabel hostAssistancelbl = new JLabel();
		  hostAssistancelbl.setHorizontalAlignment(SwingConstants.CENTER);
		/*
		  hostAssistancelbl.setBounds( X * 757 / 1366, Y * 447 / 768, X*
		  (Integer.parseInt(new java.text.DecimalFormat("0")
		  .format(aveInfo.getStealField())) * 3) / 1366, Y * 24 / 768);
		  if(playerInfo.getStealField() >= aveInfo.getStealField()) {
			  hostAssistancelbl.setBackground(Color.LIGHT_GRAY); } else {
				  hostAssistancelbl.setBackground(Color.BLUE); 
		  }*/
		  hostAssistancelbl.setOpaque(true);
		 summarylbl.add(hostAssistancelbl);
		

		bgLabel.add(summarylbl);
	}

	public void playerDataLive(ArrayList<PlayerPO> guestPlayerDataList,
			ArrayList<PlayerPO> hostPlayerDataList) {
		currentState = "playerDataLive";
		System.out.println(currentState);
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (liveTextlbl != null) {
			liveTextlbl.setVisible(false);
		}
		if (liveScrollPane != null) {
			liveScrollPane.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		datalbl = new JLabel();
		datalbl.setHorizontalAlignment(SwingConstants.CENTER);
		datalbl.setBounds(X * 0 / 1366, Y * 194 / 768, X * 1331 / 1366,
				Y * 560 / 768);
		datalbl.setBackground(Color.blue);

		compareCriterias = new String[4];
		compareCriterias[0] = "BASIC";
		compareCriterias[1] = "SHOOTING";
		compareCriterias[2] = "REBOUNDS";
		compareCriterias[3] = "X-FACTOR";


		guestTeamDatalbl = new JLabel();
		guestTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamDatalbl.setBounds(131, 0, 550, 100);
		guestTeamDatalbl.setBackground(Color.blue);
		datalbl.add(guestTeamDatalbl);

		hostTeamDatalbl = new JLabel();
		hostTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamDatalbl.setBounds(681, 0, 550, 100);
		hostTeamDatalbl.setBackground(Color.blue);
		datalbl.add(hostTeamDatalbl);

		/*
		 * ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new
		 * ArrayList<PlayerPerformanceInSingleGame>();
		 * TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
		 * .getGuestTP(); guestPlayerVos =
		 * guestTeamPerformanceInSingleGame.getPlayerList();
		 */
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		guestColumn = new Vector<String>();
		guestColumn.add("球员");
		guestColumn.add("姓名");
		guestColumn.add("位置");
		guestColumn.add("分钟");
		guestColumn.add("命中率");
		guestColumn.add("命中");
		guestColumn.add("出手");
		guestColumn.add("三分%");
		guestColumn.add("三分命中");
		guestColumn.add("三分出手");
		guestColumn.add("罚球%");
		guestColumn.add("罚球命中");
		guestColumn.add("罚球出手");		
		guestColumn.add("进攻");
		guestColumn.add("防守");
		guestColumn.add("篮板");
		guestColumn.add("助攻");
		guestColumn.add("犯规");
		guestColumn.add("抢断");	
		guestColumn.add("失误");
		guestColumn.add("盖帽");
		guestColumn.add("得分");
		if (guestPlayerDataList != null) {
			for (int i = 0; i < guestPlayerDataList.size(); i++) {
				// -------------------steven Jin!!!------------------
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(guestPlayerDataList.get(i).getName());
				a.add(guestPlayerDataList.get(i).getPosition());
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				// ------------------------------------------------
				/*
				 * a.add(String.valueOf(guestPlayerDataList.get(i).getName()));
				 * a.add("#" +
				 * String.valueOf(guestPlayerDataList.get(i).getNumber()));
				 * a.add(String.valueOf(guestPlayerDataList.get(i).getTime()));
				 * a.add(String.valueOf(guestPlayerDataList.get(i).getScore()));
				 * a
				 * .add(String.valueOf(guestPlayerDataList.get(i).getAssistance(
				 * )));
				 * a.add(String.valueOf(guestPlayerDataList.get(i).getFoul()));
				 */
				guestRowData.add(a);
			}
		}else{
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
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
				.setPreferredSize(new Dimension(550, 20));
		((DefaultTableCellRenderer) header.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r2 = new MyTableRenderer();
		r2.setHorizontalAlignment(JLabel.CENTER);
		guestTable.setDefaultRenderer(Object.class, r2);

		guestTable.setForeground(Color.WHITE);

		guestTable.setIntercellSpacing(new Dimension(0, 0));
		guestTable.getColumnModel().getColumn(0).setPreferredWidth(65);
		guestTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		guestTable.setRowHeight(48);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		guestTable.setOpaque(false);
		guestTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("guest"));

		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		guestScrollPane.setBounds(81, 20, 1200, 260);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);

		datalbl.add(guestScrollPane);
                                                                                                      
		/*
		 * ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new
		 * ArrayList<PlayerPerformanceInSingleGame>();
		 * TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo
		 * .getHomeTP(); hostPlayerVos =
		 * hostTeamPerformanceInSingleGame.getPlayerList();
		 */
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		hostColumn = new Vector<String>();
		hostColumn.add("球员");
		hostColumn.add("姓名");
		hostColumn.add("位置");
		hostColumn.add("分钟");
		hostColumn.add("命中率");
		hostColumn.add("命中");
		hostColumn.add("出手");
		hostColumn.add("三分%");
		hostColumn.add("三分命中");
		hostColumn.add("三分出手");
		hostColumn.add("罚球%");
		hostColumn.add("罚球命中");
		hostColumn.add("罚球出手");		
		hostColumn.add("进攻");
		hostColumn.add("防守");
		hostColumn.add("篮板");
		hostColumn.add("助攻");
		hostColumn.add("犯规");
		hostColumn.add("抢断");	
		hostColumn.add("失误");
		hostColumn.add("盖帽");
		hostColumn.add("得分");
		if (hostPlayerDataList != null) {
			for (int i = 0; i < hostPlayerDataList.size(); i++) {
				Vector<String> a = new Vector<String>();
				// -------------------steven Jin!!!------------------
				a.add("");
				a.add(hostPlayerDataList.get(i).getName());
				a.add(hostPlayerDataList.get(i).getPosition());
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				a.add("");
				// -----------------------------------------------
				/*
				 * a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				 * a.add("#" +
				 * String.valueOf(hostPlayerVos.get(i).getNumber()));
				 * a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				 * a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
				 * a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
				 * a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
				 */
				hostRowData.add(a);
			}
		}else{
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
			a.add("");
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
				.setPreferredSize(new Dimension(550, 20));
		((DefaultTableCellRenderer) header1.getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		MyTableRenderer r3 = new MyTableRenderer();
		r3.setHorizontalAlignment(JLabel.CENTER);
		hostTable.setDefaultRenderer(Object.class, r3);

		hostTable.setForeground(Color.WHITE);
		hostTable.setIntercellSpacing(new Dimension(0, 0));
		hostTable.getColumnModel().getColumn(0).setPreferredWidth(65);
		hostTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		hostTable.setRowHeight(48);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		hostTable.setOpaque(false);
		hostTable.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerRenderer("host"));

		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		hostScrollPane.setBounds(81, 300, 1200, 260);
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

	/*
	 * public void selfClose() { this.setVisible(false); }
	 */
	public LiveInfoPanel getSelf() {
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
					.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH));

			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			if (isSelected) {
				// previousPanel.setVisible(false);
				/*
				 * PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(
				 * this.name, mainFrame, getSelf(), previouspanel);
				 * MainFrame.currentPanel = "PlayerInfoPanel"; selfClose();
				 */
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

	public class GameDataObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			gameVo = (GameVo) arg;
			gameDataLive(gameVo);
		}

	}

	public class LiveTextObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			liveTextList = (ArrayList<liveText>) arg;
			live(liveTextList);

		}

	}

	public class TeamDataObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			guestTeamPo = ((ArrayList<TeamPO>) arg).get(0);
			hostTeamPo = ((ArrayList<TeamPO>) arg).get(1);
			teamDataLive(guestTeamPo, hostTeamPo);

		}

	}

	public class PlayerDataObserver implements Observer {

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
			guestPlayerDataList = (ArrayList<PlayerPO>) arg;
			hostPlayerDataList = (ArrayList<PlayerPO>) arg;
			playerDataLive(guestPlayerDataList, hostPlayerDataList);
		}

	}

}
