package ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.PlayerCardVo;
import vo.PlayerVo;
import vo.TeamVo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.JTextField;

import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class TopFivePlayerCardPanel extends JPanel {

	private ArrayList<PlayerCardVo> playerVos = new ArrayList<PlayerCardVo>();
	private String criteria;
	JFrame mainFrame;
	JPanel previousPanel;

	JButton firstPlayerbtn;
	JLabel firstPlayerNamelbl;
	JLabel firstPlayerInfolbl;
	JLabel firstPlayerValuelbl;
	JButton firstTeambtn;
	JButton secondPlayerbtn;
	JLabel secondPlayerNamelbl;
	JLabel secondPlayerInfolbl;
	JLabel secondPlayerValuelbl;
	JButton secondTeambtn;
	JButton thirdPlayerbtn;
	JLabel thirdPlayerNamelbl;
	JLabel thirdPlayerInfolbl;
	JLabel thirdPlayerValuelbl;
	JButton thirdTeambtn;
	JButton fourthPlayerbtn;
	JLabel fourthPlayerNamelbl;
	JLabel fourthPlayerInfolbl;
	JLabel fourthPlayerValuelbl;
	JButton fourthTeambtn;
	JButton fifthPlayerbtn;
	JLabel fifthPlayerNamelbl;
	JLabel fifthPlayerInfolbl;
	JLabel fifthPlayerValuelbl;
	JButton fifthTeambtn;
	Player_BS player_BS = new Player_BL_Stub();
	Team_BS team_BS = new Team_BL_Stub();
	int X;
	int Y;

	public TopFivePlayerCardPanel(int X, int Y,
			ArrayList<PlayerCardVo> hotPlayers, JFrame mainFrame,
			JPanel previousPanel) {
		// TODO Auto-generated constructor stub
		this.X = X;
		this.Y = Y;
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVos = playerVos;
		this.criteria = criteria;
		this.setBounds(0, 0, X * 967 / 1366, Y * 250 / 768);

		MyLabel secondlbl = new MyLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(X * 483 / 1366, Y * 25 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(secondlbl);

		MyLabel thirdlbl = new MyLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(X * 483 / 1366, Y * 75 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(thirdlbl);

		MyLabel fourthlbl = new MyLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(X * 483 / 1366, Y * 125 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(fourthlbl);

		MyLabel fifthlbl = new MyLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(X * 483 / 1366, Y * 175 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(fifthlbl);

		firstPlayerbtn = new JButton();
		firstPlayerbtn.setBounds(X * 50 / 1366, Y * 4 / 768, X * 126 / 1366,
				Y * 200 / 768);
		firstPlayerbtn.setContentAreaFilled(false);
		firstPlayerbtn.setBorderPainted(false);
		add(firstPlayerbtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("黑体", Font.BOLD, 50));
		firstlbl.setForeground(Color.RED);
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(X * 1 / 1366, Y * 4 / 768, X * 76 / 1366,
				Y * 200 / 768);
		add(firstlbl);

		firstPlayerNamelbl = new MyLabel();
		firstPlayerNamelbl.setBounds(X * 180 / 1366, Y * 35 / 768,
				X * 180 / 1366, Y * 50 / 768);
		firstPlayerNamelbl.setFont(new Font("黑体", Font.BOLD, 17));
		add(firstPlayerNamelbl);

		firstPlayerInfolbl = new MyLabel();
		firstPlayerInfolbl.setBounds(X * 180 / 1366, Y * 100 / 768,
				X * 180 / 1366, Y * 50 / 768);
		firstPlayerInfolbl.setFont(new Font("黑体", Font.BOLD, 17));
		add(firstPlayerInfolbl);

		firstPlayerValuelbl = new MyLabel();
		firstPlayerValuelbl.setFont(new Font("黑体", Font.BOLD, 17));
		firstPlayerValuelbl.setBounds(X * 180 / 1366, Y * 165 / 768,
				X * 180 / 1366, Y * 50 / 768);
		add(firstPlayerValuelbl);

		firstTeambtn = new JButton();
		firstTeambtn.setBounds(X * 310 / 1366, Y * 50 / 768, X * 160 / 1366,
				Y * 160 / 768);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		secondPlayerbtn = new JButton();
		secondPlayerbtn.setBounds(X * 532 / 1366, Y * 25 / 768, X * 35 / 1366,
				Y * 35 / 768);
		secondPlayerbtn.setContentAreaFilled(false);
		secondPlayerbtn.setBorderPainted(false);
		secondPlayerbtn.setOpaque(false);
		add(secondPlayerbtn);

		secondPlayerNamelbl = new MyLabel();
		secondPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerNamelbl.setBounds(X * 610 / 1366, Y * 25 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(secondPlayerNamelbl);

		secondPlayerInfolbl = new MyLabel();
		secondPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerInfolbl.setBounds(X * 610 / 1366, Y * 47 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(secondPlayerInfolbl);

		secondPlayerValuelbl = new MyLabel();
		secondPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerValuelbl.setBounds(X * 902 / 1366, Y * 25 / 768,
				X * 50 / 1366, Y * 35 / 768);
		add(secondPlayerValuelbl);

		secondTeambtn = new JButton();
		secondTeambtn.setBounds(X * 821 / 1366, Y * 25 / 768, X * 35 / 1366,
				Y * 35 / 768);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		thirdPlayerbtn = new JButton();
		thirdPlayerbtn.setBounds(X * 532 / 1366, Y * 75 / 768, X * 35 / 1366,
				Y * 35 / 768);
		thirdPlayerbtn.setContentAreaFilled(false);
		thirdPlayerbtn.setBorderPainted(false);
		thirdPlayerbtn.setOpaque(false);
		add(thirdPlayerbtn);

		thirdPlayerNamelbl = new MyLabel();
		thirdPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerNamelbl.setBounds(X * 610 / 1366, Y * 75 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(thirdPlayerNamelbl);

		thirdPlayerInfolbl = new MyLabel();
		thirdPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerInfolbl.setBounds(X * 610 / 1366, Y * 97 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(thirdPlayerInfolbl);

		thirdPlayerValuelbl = new MyLabel();
		thirdPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerValuelbl.setBounds(X * 902 / 1366, Y * 75 / 768,
				X * 50 / 1366, Y * 35 / 768);
		add(thirdPlayerValuelbl);

		thirdTeambtn = new JButton();
		thirdTeambtn.setBounds(X * 821 / 1366, Y * 75 / 768, X * 35 / 1366,
				Y * 35 / 768);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		fourthPlayerbtn = new JButton();
		fourthPlayerbtn.setBounds(X * 532 / 1366, Y * 125 / 768, X * 35 / 1366,
				Y * 35 / 768);
		fourthPlayerbtn.setContentAreaFilled(false);
		fourthPlayerbtn.setBorderPainted(false);
		fourthPlayerbtn.setOpaque(false);
		add(fourthPlayerbtn);

		fourthPlayerNamelbl = new MyLabel();
		fourthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerNamelbl.setBounds(X * 610 / 1366, Y * 125 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(fourthPlayerNamelbl);

		fourthPlayerInfolbl = new MyLabel();
		fourthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerInfolbl.setBounds(X * 610 / 1366, Y * 147 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(fourthPlayerInfolbl);

		fourthPlayerValuelbl = new MyLabel();
		fourthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerValuelbl.setBounds(X * 902 / 1366, Y * 125 / 768,
				X * 50 / 1366, Y * 35 / 768);
		add(fourthPlayerValuelbl);

		fourthTeambtn = new JButton();
		fourthTeambtn.setBounds(X * 821 / 1366, Y * 125 / 768, X * 35 / 1366,
				Y * 35 / 768);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fifthPlayerbtn = new JButton();
		fifthPlayerbtn.setBounds(X * 532 / 1366, Y * 175 / 768, X * 35 / 1366,
				Y * 35 / 768);
		fifthPlayerbtn.setContentAreaFilled(false);
		fifthPlayerbtn.setBorderPainted(false);
		fifthPlayerbtn.setOpaque(false);
		add(fifthPlayerbtn);

		fifthPlayerNamelbl = new MyLabel();
		fifthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerNamelbl.setBounds(X * 610 / 1366, Y * 175 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(fifthPlayerNamelbl);

		fifthPlayerInfolbl = new MyLabel();
		fifthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerInfolbl.setBounds(X * 610 / 1366, Y * 197 / 768,
				X * 145 / 1366, Y * 20 / 768);
		add(fifthPlayerInfolbl);

		fifthPlayerValuelbl = new MyLabel();
		fifthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerValuelbl.setBounds(X * 902 / 1366, Y * 175 / 768,
				X * 50 / 1366, Y * 35 / 768);
		add(fifthPlayerValuelbl);

		fifthTeambtn = new JButton();
		fifthTeambtn.setBounds(X * 821 / 1366, Y * 175 / 768, X * 35 / 1366,
				Y * 35 / 768);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
		add(fifthTeambtn);

		showTopFiveData(hotPlayers);

	}

	public void showTopFiveData(ArrayList<PlayerCardVo> hotPlayers) {

		// ArrayList<TeamVo> teams=new ArrayList<TeamVo>();
		// teams=team_BS.getAllTeam();
		// boolean hasTeamInfo = false;

		ImageIcon playerAction;
		if (hasAction(hotPlayers.get(0).getName() + ".png")) {
			playerAction = new ImageIcon(new ImageIcon(
					"CSEdata/players/action/" + hotPlayers.get(0).getName()
							+ ".png").getImage().getScaledInstance(
					X * 126 / 1366, Y * 200 / 768, Image.SCALE_AREA_AVERAGING));
		} else {
			playerAction = new ImageIcon(new ImageIcon(
					"CSEdata/players/action/" + "DefaultAction" + ".png")
					.getImage().getScaledInstance(X * 126 / 1366,
							Y * 200 / 768, Image.SCALE_AREA_AVERAGING));
		}
		firstPlayerbtn.setIcon(playerAction);
		firstPlayerbtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(hotPlayers
					.get(0).getName(), mainFrame, previousPanel);
		});

		firstPlayerNamelbl.setText(hotPlayers.get(0).getName());
		firstPlayerInfolbl.setText(hotPlayers.get(0).getNumber() + " "
				+ hotPlayers.get(0).getPosition() + "/"
				+ hotPlayers.get(0).getTeam());
		firstPlayerValuelbl.setText(String.valueOf(hotPlayers.get(0)
				.getSortvalue()));

		/*
		 * for (int i = 0; i < teams.size(); i++) { if
		 * (hotPlayers.get(0).getTeam() == teams.get(i).getTeamName()) {
		 * hasTeamInfo = true; break; } } ImageIcon teamImg1; if (hasTeamInfo ==
		 * true) { teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/" +
		 * hotPlayers.get(0).getTeam() + ".png").getImage() .getScaledInstance(X
		 * * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		 * hasTeamInfo = false; } else { teamImg1 = new ImageIcon(new ImageIcon(
		 * "CSEdata/teams_png/" + "DefaultTeam"+ ".png").getImage()
		 * .getScaledInstance(X * 160 / 1366, Y * 160 / 768,
		 * Image.SCALE_AREA_AVERAGING)); }
		 */
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotPlayers.get(0).getTeam() + ".png").getImage()
				.getScaledInstance(X * 160 / 1366, Y * 160 / 768,
						Image.SCALE_AREA_AVERAGING));
		firstTeambtn.setIcon(teamImg1);
		firstTeambtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(hotPlayers.get(0)
					.getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait2;
		if (hasPortrait(hotPlayers.get(1).getName() + ".png")) {
			playerPortrait2 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + hotPlayers.get(1).getName()
							+ ".png").getImage().getScaledInstance(
					X * 35 / 1366, Y * 35 / 768, Image.SCALE_AREA_AVERAGING));
		} else {
			playerPortrait2 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + "DefaultPortrait" + ".png")
					.getImage().getScaledInstance(X * 35 / 1366, Y * 35 / 768,
							Image.SCALE_AREA_AVERAGING));
		}

		secondPlayerbtn.setIcon(playerPortrait2);
		secondPlayerbtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(hotPlayers
					.get(1).getName(), mainFrame, previousPanel);
		});

		secondPlayerNamelbl.setText(hotPlayers.get(1).getName());
		secondPlayerInfolbl.setText(hotPlayers.get(1).getNumber() + " "
				+ hotPlayers.get(1).getPosition() + "/"
				+ hotPlayers.get(1).getTeam());
		;
		secondPlayerValuelbl.setText(String.valueOf(hotPlayers.get(1)
				.getSortvalue()));

		/*
		 * for (int i = 0; i < teams.size(); i++) { if
		 * (hotPlayers.get(1).getTeam() == teams.get(i).getTeamName()) {
		 * hasTeamInfo = true; break; } } ImageIcon teamImg2; if (hasTeamInfo ==
		 * true) { teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/" +
		 * hotPlayers.get(1).getTeam() + ".png").getImage() .getScaledInstance(X
		 * * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		 * hasTeamInfo = false; } else { teamImg2 = new ImageIcon(new ImageIcon(
		 * "CSEdata/teams_png/" + "DefaultTeam"+ ".png").getImage()
		 * .getScaledInstance(X * 160 / 1366, Y * 160 / 768,
		 * Image.SCALE_AREA_AVERAGING)); }
		 */
		ImageIcon teamImg2;
		teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotPlayers.get(1).getTeam() + ".png").getImage()
				.getScaledInstance(X * 35 / 1366, Y * 35 / 768,
						Image.SCALE_AREA_AVERAGING));
		secondTeambtn.setIcon(teamImg2);
		secondTeambtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(hotPlayers.get(1)
					.getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait3;
		if (hasPortrait(hotPlayers.get(2).getName() + ".png")) {
			playerPortrait3 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + hotPlayers.get(2).getName()
							+ ".png").getImage().getScaledInstance(
					X * 35 / 1366, Y * 35 / 768, Image.SCALE_AREA_AVERAGING));

		} else {
			playerPortrait3 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + "DefaultPortrait" + ".png")
					.getImage().getScaledInstance(X * 35 / 1366, Y * 35 / 768,
							Image.SCALE_AREA_AVERAGING));
		}
		thirdPlayerbtn.setIcon(playerPortrait3);
		thirdPlayerbtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(hotPlayers
					.get(2).getName(), mainFrame, previousPanel);
		});

		thirdPlayerNamelbl.setText(hotPlayers.get(2).getName());
		thirdPlayerInfolbl.setText(hotPlayers.get(2).getNumber() + " "
				+ hotPlayers.get(2).getPosition() + "/"
				+ hotPlayers.get(2).getTeam());
		thirdPlayerValuelbl.setText(String.valueOf(hotPlayers.get(2)
				.getSortvalue()));

		/*
		 * for (int i = 0; i < teams.size(); i++) { if
		 * (hotPlayers.get(2).getTeam() == teams.get(i).getTeamName()) {
		 * hasTeamInfo = true; break; } } ImageIcon teamImg3; if (hasTeamInfo ==
		 * true) { teamImg3 = new ImageIcon(new ImageIcon("CSEdata/teams_png/" +
		 * hotPlayers.get(2).getTeam() + ".png").getImage() .getScaledInstance(X
		 * * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		 * hasTeamInfo = false; } else { teamImg3 = new ImageIcon(new ImageIcon(
		 * "CSEdata/teams_png/" + "DefaultTeam"+ ".png").getImage()
		 * .getScaledInstance(X * 160 / 1366, Y * 160 / 768,
		 * Image.SCALE_AREA_AVERAGING)); }
		 */
		ImageIcon teamImg3 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotPlayers.get(2).getTeam() + ".png").getImage()
				.getScaledInstance(X * 35 / 1366, Y * 35 / 768,
						Image.SCALE_AREA_AVERAGING));
		thirdTeambtn.setIcon(teamImg3);
		thirdTeambtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(hotPlayers.get(2)
					.getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait4;
		if (hasPortrait(hotPlayers.get(3).getName() + ".png")) {
			playerPortrait4 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + hotPlayers.get(3).getName()
							+ ".png").getImage().getScaledInstance(
					X * 35 / 1366, Y * 35 / 768, Image.SCALE_AREA_AVERAGING));

		} else {
			playerPortrait4 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + "DefaultPortrait" + ".png")
					.getImage().getScaledInstance(X * 35 / 1366, Y * 35 / 768,
							Image.SCALE_AREA_AVERAGING));
		}
		fourthPlayerbtn.setIcon(playerPortrait4);
		fourthPlayerbtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(hotPlayers
					.get(3).getName(), mainFrame, previousPanel);
		});

		fourthPlayerNamelbl.setText(hotPlayers.get(3).getName());
		fourthPlayerInfolbl.setText(hotPlayers.get(3).getNumber() + " "
				+ hotPlayers.get(3).getPosition() + "/"
				+ hotPlayers.get(3).getTeam());
		fourthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(3)
				.getSortvalue()));

		/*
		 * for (int i = 0; i < teams.size(); i++) { if
		 * (hotPlayers.get(3).getTeam() == teams.get(i).getTeamName()) {
		 * hasTeamInfo = true; break; } } ImageIcon teamImg4; if (hasTeamInfo ==
		 * true) { teamImg4 = new ImageIcon(new ImageIcon("CSEdata/teams_png/" +
		 * hotPlayers.get(3).getTeam() + ".png").getImage() .getScaledInstance(X
		 * * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		 * hasTeamInfo = false; } else { teamImg4 = new ImageIcon(new ImageIcon(
		 * "CSEdata/teams_png/" + "DefaultTeam"+ ".png").getImage()
		 * .getScaledInstance(X * 160 / 1366, Y * 160 / 768,
		 * Image.SCALE_AREA_AVERAGING)); }
		 */

		ImageIcon teamImg4 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotPlayers.get(3).getTeam() + ".png").getImage()
				.getScaledInstance(X * 35 / 1366, Y * 35 / 768,
						Image.SCALE_AREA_AVERAGING));
		fourthTeambtn.setIcon(teamImg4);
		fourthTeambtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(hotPlayers.get(3)
					.getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait5;
		if (hasPortrait(hotPlayers.get(4).getName() + ".png")) {
			playerPortrait5 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + hotPlayers.get(4).getName()
							+ ".png").getImage().getScaledInstance(
					X * 35 / 1366, Y * 35 / 768, Image.SCALE_AREA_AVERAGING));
		} else {
			playerPortrait5 = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + "DefaultPortrait" + ".png")
					.getImage().getScaledInstance(X * 35 / 1366, Y * 35 / 768,
							Image.SCALE_AREA_AVERAGING));
		}
		fifthPlayerbtn.setIcon(playerPortrait5);
		fifthPlayerbtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel = new PlayerInfoPanel(hotPlayers
					.get(4).getName(), mainFrame, previousPanel);
		});

		fifthPlayerNamelbl.setText(hotPlayers.get(4).getName());
		fifthPlayerInfolbl.setText(hotPlayers.get(4).getNumber() + " "
				+ hotPlayers.get(4).getPosition() + "/"
				+ hotPlayers.get(4).getTeam());
		fifthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(4)
				.getSortvalue()));

		/*
		 * for (int i = 0; i < teams.size(); i++) { if
		 * (hotPlayers.get(4).getTeam() == teams.get(i).getTeamName()) {
		 * hasTeamInfo = true; break; } } ImageIcon teamImg5; if (hasTeamInfo ==
		 * true) { teamImg5 = new ImageIcon(new ImageIcon("CSEdata/teams_png/" +
		 * hotPlayers.get(4).getTeam() + ".png").getImage() .getScaledInstance(X
		 * * 160 / 1366, Y * 160 / 768, Image.SCALE_AREA_AVERAGING));
		 * hasTeamInfo = false; } else { teamImg5 = new ImageIcon(new ImageIcon(
		 * "CSEdata/teams_png/" + "DefaultTeam"+ ".png").getImage()
		 * .getScaledInstance(X * 160 / 1366, Y * 160 / 768,
		 * Image.SCALE_AREA_AVERAGING)); }
		 */
		ImageIcon teamImg5 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotPlayers.get(4).getTeam() + ".png").getImage()
				.getScaledInstance(X * 35 / 1366, Y * 35 / 768,
						Image.SCALE_AREA_AVERAGING));

		fifthTeambtn.setIcon(teamImg5);
		fifthTeambtn.addActionListener(e -> {
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel = new TeamInfoPanel(hotPlayers.get(4)
					.getTeam(), mainFrame, previousPanel);
		});
	}

	public boolean hasAction(String actionPath) {
		boolean hasAction = false;
		File actionFile = new File("CSEdata/players/action//");
		String action[];
		action = actionFile.list();
		for (int i = 0; i < action.length; i++) {
			if (actionPath.equals(action[i])) {
				hasAction = true;
				break;
			}
		}
		return hasAction;
	}

	public boolean hasPortrait(String portraitPath) {
		boolean hasPortrait = false;
		File portraitFile = new File("CSEdata/players/portrait//");
		String portrait[];
		portrait = portraitFile.list();
		for (int i = 0; i < portrait.length; i++) {
			if (portraitPath.equals( portrait[i])) {
				hasPortrait = true;
				break;
			}
		}
		
		return hasPortrait;
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
			this.setFont(new Font("微软雅黑", 1, 15));
		}

		public MyLabel(String s) {
			super();
			this.setText(s);
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑", 1, 17));
		}

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 11));

		}
	}
}
