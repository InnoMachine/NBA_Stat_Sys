package ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.PlayerCardVo;
import vo.PlayerVo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

public class TopFivePlayerCardPanel extends JPanel {

	private ArrayList<PlayerCardVo> playerVos = new ArrayList<PlayerCardVo>();
	private String criteria;

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

	int X;
	int Y;

	public TopFivePlayerCardPanel(ArrayList<PlayerCardVo> hotPlayers) {
		// TODO Auto-generated constructor stub
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVos = playerVos;
		this.criteria = criteria;
		this.setBounds(0, 0, 669, 150);

		JLabel secondlbl = new JLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(334, 2, 37, 37);
		add(secondlbl);

		JLabel thirdlbl = new JLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(334, 39, 37, 37);
		add(thirdlbl);

		JLabel fourthlbl = new JLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(334, 76, 37, 37);
		add(fourthlbl);

		JLabel fifthlbl = new JLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(334, 113, 37, 37);
		add(fifthlbl);

		firstPlayerbtn = new JButton("Player1-action");
		firstPlayerbtn.setBounds(5, 5, 88, 140);
		firstPlayerbtn.setContentAreaFilled(false);
		firstPlayerbtn.setBorderPainted(false);
		firstPlayerbtn.setOpaque(false);
		add(firstPlayerbtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("宋体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(92, 5, 37, 140);
		add(firstlbl);

		firstPlayerNamelbl = new JLabel("name1");
		firstPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerNamelbl.setBounds(135, 25, 88, 45);
		add(firstPlayerNamelbl);

		firstPlayerInfolbl = new JLabel("Info1");
		firstPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerInfolbl.setBounds(137, 72, 163, 23);
		add(firstPlayerInfolbl);

		firstPlayerValuelbl = new JLabel("Value1");
		firstPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerValuelbl.setBounds(137, 98, 65, 47);
		add(firstPlayerValuelbl);

		firstTeambtn = new JButton("Team1");
		firstTeambtn.setBounds(267, 5, 65, 65);
		firstPlayerbtn.setContentAreaFilled(false);
		firstPlayerbtn.setBorderPainted(false);
		firstPlayerbtn.setOpaque(false);
		add(firstTeambtn);

		secondPlayerbtn = new JButton("Player2");
		secondPlayerbtn.setBounds(368, 3, 35, 35);
		add(secondPlayerbtn);

		secondPlayerNamelbl = new JLabel("name2");
		secondPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerNamelbl.setBounds(413, 4, 145, 15);
		add(secondPlayerNamelbl);

		secondPlayerInfolbl = new JLabel("Info2");
		secondPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerInfolbl.setBounds(413, 20, 145, 15);
		add(secondPlayerInfolbl);

		secondPlayerValuelbl = new JLabel("Value2");
		secondPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerValuelbl.setBounds(568, 8, 37, 25);
		add(secondPlayerValuelbl);

		secondTeambtn = new JButton("Team2");
		secondTeambtn.setBounds(624, 3, 35, 35);
		add(secondTeambtn);

		thirdPlayerbtn = new JButton("Player3");
		thirdPlayerbtn.setBounds(368, 40, 35, 35);
		add(thirdPlayerbtn);

		thirdPlayerNamelbl = new JLabel("name3");
		thirdPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerNamelbl.setBounds(413, 41, 145, 15);
		add(thirdPlayerNamelbl);

		thirdPlayerInfolbl = new JLabel("Info3");
		thirdPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerInfolbl.setBounds(413, 57, 145, 15);
		add(thirdPlayerInfolbl);

		thirdPlayerValuelbl = new JLabel("Value3");
		thirdPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerValuelbl.setBounds(568, 45, 37, 25);
		add(thirdPlayerValuelbl);

		thirdTeambtn = new JButton("Team3");
		thirdTeambtn.setBounds(624, 40, 35, 35);
		add(thirdTeambtn);

		fourthPlayerbtn = new JButton("Player4");
		fourthPlayerbtn.setBounds(368, 77, 35, 35);
		add(fourthPlayerbtn);

		fourthPlayerNamelbl = new JLabel("name4");
		fourthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerNamelbl.setBounds(413, 78, 145, 15);
		add(fourthPlayerNamelbl);

		fourthPlayerInfolbl = new JLabel("Info4");
		fourthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerInfolbl.setBounds(413, 94, 145, 15);
		add(fourthPlayerInfolbl);

		fourthPlayerValuelbl = new JLabel("Value4");
		fourthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerValuelbl.setBounds(568, 82, 37, 25);
		add(fourthPlayerValuelbl);

		fourthTeambtn = new JButton("Team4");
		fourthTeambtn.setBounds(624, 77, 35, 35);
		add(fourthTeambtn);

		fifthPlayerbtn = new JButton("Player5");
		fifthPlayerbtn.setBounds(368, 114, 35, 35);
		add(fifthPlayerbtn);

		fifthPlayerNamelbl = new JLabel("name5");
		fifthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerNamelbl.setBounds(413, 115, 145, 15);
		add(fifthPlayerNamelbl);

		fifthPlayerInfolbl = new JLabel("Info5");
		fifthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerInfolbl.setBounds(413, 131, 145, 15);
		add(fifthPlayerInfolbl);

		fifthPlayerValuelbl = new JLabel("Value5");
		fifthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerValuelbl.setBounds(568, 119, 37, 25);
		add(fifthPlayerValuelbl);

		fifthTeambtn = new JButton("Team5");
		fifthTeambtn.setBounds(624, 114, 35, 35);
		add(fifthTeambtn);

		showTopFiveData(hotPlayers);

	}

	public void showTopFiveData(ArrayList<PlayerCardVo> hotPlayers) {
		ImageIcon playerAction = new ImageIcon(new ImageIcon(
				"CSEdata/players/action/" + hotPlayers.get(0).getName()
						+ ".png").getImage().getScaledInstance(88, 140,
				Image.SCALE_AREA_AVERAGING));
		firstPlayerbtn.setIcon(playerAction);		
		firstPlayerNamelbl.setText(hotPlayers.get(0).getName());
		firstPlayerInfolbl.setText(hotPlayers.get(0).getNumber() + " "
				+ hotPlayers.get(0).getPosition() + "/"
				+ hotPlayers.get(0).getTeam());
		firstPlayerValuelbl.setText(String.valueOf(hotPlayers.get(0)
				.getSortvalue()));
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(0).getTeam() + ".png").getImage().getScaledInstance(65,65,
				Image.SCALE_AREA_AVERAGING));
		firstTeambtn.setIcon(teamImg1);
		
		
		
		ImageIcon playerPortrait2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(1).getName()
						+ ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		secondPlayerbtn.setIcon(playerPortrait2);
		
		secondPlayerNamelbl.setText(hotPlayers.get(1).getName());
		secondPlayerInfolbl.setText(hotPlayers.get(1).getNumber() + " "
				+ hotPlayers.get(1).getPosition() + "/"
				+ hotPlayers.get(1).getTeam());
		;
		secondPlayerValuelbl.setText(String.valueOf(hotPlayers.get(1)
				.getSortvalue()));
		ImageIcon teamImg2 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(1).getTeam() + ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		secondTeambtn.setIcon(teamImg2);


		ImageIcon playerPortrait3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(2).getName()
						+ ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		thirdPlayerbtn.setIcon(playerPortrait3);
		thirdPlayerNamelbl.setText(hotPlayers.get(2).getName());
		thirdPlayerInfolbl.setText(hotPlayers.get(2).getNumber() + " "
				+ hotPlayers.get(2).getPosition() + "/"
				+ hotPlayers.get(2).getTeam());
		thirdPlayerValuelbl.setText(String.valueOf(hotPlayers.get(2)
				.getSortvalue()));
		ImageIcon teamImg3 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(2).getTeam() + ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		thirdTeambtn.setIcon(teamImg3);


		ImageIcon playerPortrait4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(3).getName()
						+ ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		fourthPlayerbtn.setIcon(playerPortrait4);
		fourthPlayerNamelbl.setText(hotPlayers.get(3).getName());
		fourthPlayerInfolbl.setText(hotPlayers.get(3).getNumber() + " "
				+ hotPlayers.get(3).getPosition() + "/"
				+ hotPlayers.get(3).getTeam());
		fourthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(3)
				.getSortvalue()));
		ImageIcon teamImg4 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(3).getTeam() + ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		fourthTeambtn.setIcon(teamImg4);


		ImageIcon playerPortrait5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(4).getName()
						+ ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		fifthPlayerbtn.setIcon(playerPortrait5);
		fifthPlayerNamelbl.setText(hotPlayers.get(4).getName());
		fifthPlayerInfolbl.setText(hotPlayers.get(4).getNumber() + " "
				+ hotPlayers.get(4).getPosition() + "/"
				+ hotPlayers.get(4).getTeam());
		fifthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(4)
				.getSortvalue()));
		ImageIcon teamImg5 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(4).getTeam() + ".png").getImage().getScaledInstance(35,35,
				Image.SCALE_AREA_AVERAGING));
		fifthTeambtn.setIcon(teamImg5);
	}
}
