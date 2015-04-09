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

	public TopFivePlayerCardPanel(int X,int Y,ArrayList<PlayerCardVo> hotPlayers) {
		// TODO Auto-generated constructor stub
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVos = playerVos;
		this.criteria = criteria;
		this.setBounds(0, 0, X*669/1366, Y*150/768);

	
		
		JLabel secondlbl = new JLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(X*334/669, Y*2/150, X*37/669, Y*37/150);
		add(secondlbl);

		JLabel thirdlbl = new JLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(X*334/669, Y*39/150, X*37/669, Y*37/150);
		add(thirdlbl);

		JLabel fourthlbl = new JLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(X*334/669, Y*76/150, X*37/669, Y*37/150);
		add(fourthlbl);

		JLabel fifthlbl = new JLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(X*334/669, Y*113/150, X*37/669, Y*37/150);
		add(fifthlbl);

		firstPlayerbtn = new JButton();
		firstPlayerbtn.setBounds(X*5/669, Y*5/150, X*88/669, Y*140/150);
		firstPlayerbtn.setContentAreaFilled(false);
		firstPlayerbtn.setBorderPainted(false);
		firstPlayerbtn.setOpaque(false);
		add(firstPlayerbtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("宋体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(X*92/669, Y*5/150, X*37/669, Y*140/150);
		add(firstlbl);

		firstPlayerNamelbl = new JLabel();
		firstPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerNamelbl.setBounds(X*135/669, Y*25/150, X*88/669, Y*45/150);
		add(firstPlayerNamelbl);

		firstPlayerInfolbl = new JLabel();
		firstPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerInfolbl.setBounds(X*137/669, Y*72/150, X*163/669, Y*23/150);
		add(firstPlayerInfolbl);

		firstPlayerValuelbl = new JLabel();
		firstPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerValuelbl.setBounds(X*137/669, Y*98/150, X*65/669, Y*47/150);
		add(firstPlayerValuelbl);

		firstTeambtn = new JButton();
		firstTeambtn.setBounds(X*267/669, Y*5/150, X*65/669, Y*65/150);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		secondPlayerbtn = new JButton();
		secondPlayerbtn.setBounds(X*368/669, Y*3/150, X*35/669, Y*35/150);
		secondPlayerbtn.setContentAreaFilled(false);
		secondPlayerbtn.setBorderPainted(false);
		secondPlayerbtn.setOpaque(false);
		add(secondPlayerbtn);

		secondPlayerNamelbl = new JLabel();
		secondPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerNamelbl.setBounds(X*413/669, Y*4/150, X*145/669, Y*15/150);
		add(secondPlayerNamelbl);

		secondPlayerInfolbl = new JLabel();
		secondPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerInfolbl.setBounds(X*413/669, Y*20/150, X*145/669, Y*15/150);
		add(secondPlayerInfolbl);

		secondPlayerValuelbl = new JLabel();
		secondPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerValuelbl.setBounds(X*568/669, Y*8/150, X*37/669, Y*25/150);
		add(secondPlayerValuelbl);

		secondTeambtn = new JButton();
		secondTeambtn.setBounds(X*624/669, Y*3/150, X*35/669, Y*35/150);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		thirdPlayerbtn = new JButton();
		thirdPlayerbtn.setBounds(X*368/669, Y*40/150, X*35/669, Y*35/150);
		thirdPlayerbtn.setContentAreaFilled(false);
		thirdPlayerbtn.setBorderPainted(false);
		thirdPlayerbtn.setOpaque(false);
		add(thirdPlayerbtn);

		thirdPlayerNamelbl = new JLabel();
		thirdPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerNamelbl.setBounds(X*413/669, Y*41/150, X*145/669, Y*15/150);
		add(thirdPlayerNamelbl);

		thirdPlayerInfolbl = new JLabel();
		thirdPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerInfolbl.setBounds(X*413/669, Y*57/150, X*145/669, Y*15/150);
		add(thirdPlayerInfolbl);

		thirdPlayerValuelbl = new JLabel();
		thirdPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerValuelbl.setBounds(X*568/669, Y*45/150, X*37/669, Y*25/150);
		add(thirdPlayerValuelbl);

		thirdTeambtn = new JButton();
		thirdTeambtn.setBounds(X*624/669, Y*40/150, X*35/669, Y*35/150);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		fourthPlayerbtn = new JButton();
		fourthPlayerbtn.setBounds(X*368/669, Y*77/150, X*35/669, Y*35/150);
		fourthPlayerbtn.setContentAreaFilled(false);
		fourthPlayerbtn.setBorderPainted(false);
		fourthPlayerbtn.setOpaque(false);
		add(fourthPlayerbtn);

		fourthPlayerNamelbl = new JLabel();
		fourthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerNamelbl.setBounds(X*413/669, Y*78/150, X*145/669, Y*15/150);
		add(fourthPlayerNamelbl);

		fourthPlayerInfolbl = new JLabel();
		fourthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerInfolbl.setBounds(X*413/669, Y*94/150, X*145/669, Y*15/150);
		add(fourthPlayerInfolbl);

		fourthPlayerValuelbl = new JLabel();
		fourthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerValuelbl.setBounds(X*568/669, Y*82/150, X*37/669, Y*25/150);
		add(fourthPlayerValuelbl);

		fourthTeambtn = new JButton();
		fourthTeambtn.setBounds(X*624/669, Y*77/150, X*35/669, Y*35/150);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fifthPlayerbtn = new JButton();
		fifthPlayerbtn.setBounds(X*368/669, Y*114/150, X*35/669, Y*35/150);
		fifthPlayerbtn.setContentAreaFilled(false);
		fifthPlayerbtn.setBorderPainted(false);
		fifthPlayerbtn.setOpaque(false);
		add(fifthPlayerbtn);

		fifthPlayerNamelbl = new JLabel();
		fifthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerNamelbl.setBounds(X*413/669, Y*115/150, X*145/669, Y*15/150);
		add(fifthPlayerNamelbl);

		fifthPlayerInfolbl = new JLabel();
		fifthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerInfolbl.setBounds(X*413/669, Y*131/150, X*145/669, Y*15/150);
		add(fifthPlayerInfolbl);

		fifthPlayerValuelbl = new JLabel();
		fifthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerValuelbl.setBounds(X*568/669, Y*119/150, X*37/669, Y*25/150);
		add(fifthPlayerValuelbl);

		fifthTeambtn = new JButton();
		fifthTeambtn.setBounds(X*624/669, Y*114/150, X*35/669, Y*35/150);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
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
