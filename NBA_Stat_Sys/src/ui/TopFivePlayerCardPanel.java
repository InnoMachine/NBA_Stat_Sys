package ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.PlayerCardVo;
import vo.PlayerVo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

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

	int X;
	int Y;

	public TopFivePlayerCardPanel(int X,int Y,ArrayList<PlayerCardVo> hotPlayers,JFrame mainFrame,JPanel previousPanel) {
		// TODO Auto-generated constructor stub
		this.X = X;
		this.Y = Y;
		this.mainFrame=mainFrame;
		this.previousPanel=previousPanel;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVos = playerVos;
		this.criteria = criteria;
		this.setBounds(0, 0, X*967/1366, Y*208/768);
	
		
		JLabel secondlbl = new JLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(X*483/1366, Y*15/768, X*35/1366, Y*35/768);
		add(secondlbl);

		JLabel thirdlbl = new JLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(X*483/1366, Y*62/768, X*35/1366, Y*35/768);
		add(thirdlbl);

		JLabel fourthlbl = new JLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(X*483/1366, Y*109/768, X*35/1366, Y*35/768);
		add(fourthlbl);

		JLabel fifthlbl = new JLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(X*483/1366, Y*156/768, X*35/1366, Y*35/768);
		add(fifthlbl);

		firstPlayerbtn = new JButton();
		firstPlayerbtn.setBounds(X*5/1366, Y*4/768, X*126/1366, Y*200/768);
		firstPlayerbtn.setContentAreaFilled(false);
		firstPlayerbtn.setBorderPainted(false);
		add(firstPlayerbtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("黑体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(X*132/1366, Y*4/768, X*76/1366, Y*200/768);
		add(firstlbl);

		firstPlayerNamelbl = new JLabel();
		firstPlayerNamelbl.setBounds(X*208/1366, Y*35/768, X*180/1366, Y*62/768);
		add(firstPlayerNamelbl);

		firstPlayerInfolbl = new JLabel();
		firstPlayerInfolbl.setBounds(X*208/1366, Y*100/768, X*180/1366, Y*31/768);
		add(firstPlayerInfolbl);

		firstPlayerValuelbl = new JLabel();
		firstPlayerValuelbl.setFont(new Font("黑体", Font.PLAIN, 20));
		firstPlayerValuelbl.setBounds(X*208/1366, Y*134/768, X*180/1366, Y*47/768);
		add(firstPlayerValuelbl);

		firstTeambtn = new JButton();
		firstTeambtn.setBounds(X*410/1366, Y*5/768, X*65/1366, Y*65/768);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		secondPlayerbtn = new JButton();
		secondPlayerbtn.setBounds(X*532/1366, Y*15/768, X*35/1366, Y*35/768);
		secondPlayerbtn.setContentAreaFilled(false);
		secondPlayerbtn.setBorderPainted(false);
		secondPlayerbtn.setOpaque(false);
		add(secondPlayerbtn);

		secondPlayerNamelbl = new JLabel();
		secondPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerNamelbl.setBounds(X*610/1366, Y*17/768, X*145/1366, Y*15/768);
		add(secondPlayerNamelbl);

		secondPlayerInfolbl = new JLabel();
		secondPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerInfolbl.setBounds(X*610/1366, Y*33/768, X*145/1366, Y*15/768);
		add(secondPlayerInfolbl);

		secondPlayerValuelbl = new JLabel();
		secondPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerValuelbl.setBounds(X*902/1366, Y*15/768, X*35/1366, Y*35/768);
		add(secondPlayerValuelbl);

		secondTeambtn = new JButton();
		secondTeambtn.setBounds(X*821/1366, Y*15/768, X*35/1366, Y*35/768);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		thirdPlayerbtn = new JButton();
		thirdPlayerbtn.setBounds(X*532/1366, Y*62/768, X*35/1366, Y*35/768);
		thirdPlayerbtn.setContentAreaFilled(false);
		thirdPlayerbtn.setBorderPainted(false);
		thirdPlayerbtn.setOpaque(false);
		add(thirdPlayerbtn);

		thirdPlayerNamelbl = new JLabel();
		thirdPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerNamelbl.setBounds(X*610/1366, Y*64/768, X*145/1366, Y*15/768);
		add(thirdPlayerNamelbl);

		thirdPlayerInfolbl = new JLabel();
		thirdPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerInfolbl.setBounds(X*610/1366, Y*80/768, X*145/1366, Y*15/768);
		add(thirdPlayerInfolbl);

		thirdPlayerValuelbl = new JLabel();
		thirdPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerValuelbl.setBounds(X*902/1366, Y*62/768, X*35/1366, Y*35/768);
		add(thirdPlayerValuelbl);

		thirdTeambtn = new JButton();
		thirdTeambtn.setBounds(X*821/1366, Y*62/768, X*35/1366, Y*35/768);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		fourthPlayerbtn = new JButton();
		fourthPlayerbtn.setBounds(X*532/1366, Y*109/768, X*35/1366, Y*35/768);
		fourthPlayerbtn.setContentAreaFilled(false);
		fourthPlayerbtn.setBorderPainted(false);
		fourthPlayerbtn.setOpaque(false);
		add(fourthPlayerbtn);

		fourthPlayerNamelbl = new JLabel();
		fourthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerNamelbl.setBounds(X*610/1366, Y*111/768, X*145/1366, Y*15/768);
		add(fourthPlayerNamelbl);

		fourthPlayerInfolbl = new JLabel();
		fourthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerInfolbl.setBounds(X*610/1366, Y*127/768, X*145/1366, Y*15/768);
		add(fourthPlayerInfolbl);

		fourthPlayerValuelbl = new JLabel();
		fourthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerValuelbl.setBounds(X*902/1366, Y*109/768, X*35/1366, Y*35/768);
		add(fourthPlayerValuelbl);

		fourthTeambtn = new JButton();
		fourthTeambtn.setBounds(X*821/1366, Y*109/768, X*35/1366, Y*35/768);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fifthPlayerbtn = new JButton();
		fifthPlayerbtn.setBounds(X*532/1366, Y*156/768, X*35/1366, Y*35/768);
		fifthPlayerbtn.setContentAreaFilled(false);
		fifthPlayerbtn.setBorderPainted(false);
		fifthPlayerbtn.setOpaque(false);
		add(fifthPlayerbtn);

		fifthPlayerNamelbl = new JLabel();
		fifthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerNamelbl.setBounds(X*610/1366, Y*158/768, X*145/1366, Y*15/768);
		add(fifthPlayerNamelbl);

		fifthPlayerInfolbl = new JLabel();
		fifthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerInfolbl.setBounds(X*610/1366, Y*174/768, X*145/1366, Y*15/768);
		add(fifthPlayerInfolbl);

		fifthPlayerValuelbl = new JLabel();
		fifthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerValuelbl.setBounds(X*902/1366, Y*156/768, X*35/1366, Y*35/768);
		add(fifthPlayerValuelbl);

		fifthTeambtn = new JButton();
		fifthTeambtn.setBounds(X*821/1366, Y*156/768, X*35/1366, Y*35/768);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
		add(fifthTeambtn);

		showTopFiveData(hotPlayers);

	}

	public void showTopFiveData(ArrayList<PlayerCardVo> hotPlayers) {
		ImageIcon playerAction = new ImageIcon(new ImageIcon(
				"CSEdata/players/action/" + hotPlayers.get(0).getName()
						+ ".png").getImage().getScaledInstance(X*126/1366, Y*200/768,
				Image.SCALE_AREA_AVERAGING));
		firstPlayerbtn.setIcon(playerAction);
		firstPlayerbtn.addActionListener(e->{
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel=new PlayerInfoPanel(hotPlayers.get(0).getName(), mainFrame, previousPanel);
		});
		
		firstPlayerNamelbl.setText(hotPlayers.get(0).getName());
		firstPlayerInfolbl.setText(hotPlayers.get(0).getNumber() + " "
				+ hotPlayers.get(0).getPosition() + "/"
				+ hotPlayers.get(0).getTeam());
		firstPlayerValuelbl.setText(String.valueOf(hotPlayers.get(0)
				.getSortvalue()));
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(0).getTeam() + ".png").getImage().getScaledInstance(X*65/1366,Y*65/768,
				Image.SCALE_AREA_AVERAGING));
		firstTeambtn.setIcon(teamImg1);
		firstTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotPlayers.get(0).getTeam(), mainFrame, previousPanel);
		});
		
		
		ImageIcon playerPortrait2 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(1).getName()
						+ ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		secondPlayerbtn.setIcon(playerPortrait2);
		secondPlayerbtn.addActionListener(e->{
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel=new PlayerInfoPanel(hotPlayers.get(1).getName(), mainFrame, previousPanel);
		});
		
		secondPlayerNamelbl.setText(hotPlayers.get(1).getName());
		secondPlayerInfolbl.setText(hotPlayers.get(1).getNumber() + " "
				+ hotPlayers.get(1).getPosition() + "/"
				+ hotPlayers.get(1).getTeam());
		;
		secondPlayerValuelbl.setText(String.valueOf(hotPlayers.get(1)
				.getSortvalue()));
		ImageIcon teamImg2 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(1).getTeam() + ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		secondTeambtn.setIcon(teamImg2);
		secondTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotPlayers.get(1).getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait3 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(2).getName()
						+ ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		thirdPlayerbtn.setIcon(playerPortrait3);
		thirdPlayerbtn.addActionListener(e->{
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel=new PlayerInfoPanel(hotPlayers.get(2).getName(), mainFrame, previousPanel);
		});
		
		thirdPlayerNamelbl.setText(hotPlayers.get(2).getName());
		thirdPlayerInfolbl.setText(hotPlayers.get(2).getNumber() + " "
				+ hotPlayers.get(2).getPosition() + "/"
				+ hotPlayers.get(2).getTeam());
		thirdPlayerValuelbl.setText(String.valueOf(hotPlayers.get(2)
				.getSortvalue()));
		ImageIcon teamImg3 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(2).getTeam() + ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		thirdTeambtn.setIcon(teamImg3);
		thirdTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotPlayers.get(2).getTeam(), mainFrame, previousPanel);
		});


		ImageIcon playerPortrait4 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(3).getName()
						+ ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		fourthPlayerbtn.setIcon(playerPortrait4);
		fourthPlayerbtn.addActionListener(e->{
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel=new PlayerInfoPanel(hotPlayers.get(3).getName(), mainFrame, previousPanel);
		});
		
		fourthPlayerNamelbl.setText(hotPlayers.get(3).getName());
		fourthPlayerInfolbl.setText(hotPlayers.get(3).getNumber() + " "
				+ hotPlayers.get(3).getPosition() + "/"
				+ hotPlayers.get(3).getTeam());
		fourthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(3)
				.getSortvalue()));
		ImageIcon teamImg4 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(3).getTeam() + ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		fourthTeambtn.setIcon(teamImg4);
		fourthTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotPlayers.get(3).getTeam(), mainFrame, previousPanel);
		});

		ImageIcon playerPortrait5 = new ImageIcon(new ImageIcon(
				"CSEdata/players/portrait/" + hotPlayers.get(4).getName()
						+ ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		fifthPlayerbtn.setIcon(playerPortrait5);
		fifthPlayerbtn.addActionListener(e->{
			previousPanel.setVisible(false);
			PlayerInfoPanel playerInfoPanel=new PlayerInfoPanel(hotPlayers.get(4).getName(), mainFrame, previousPanel);
		});
		
		fifthPlayerNamelbl.setText(hotPlayers.get(4).getName());
		fifthPlayerInfolbl.setText(hotPlayers.get(4).getNumber() + " "
				+ hotPlayers.get(4).getPosition() + "/"
				+ hotPlayers.get(4).getTeam());
		fifthPlayerValuelbl.setText(String.valueOf(hotPlayers.get(4)
				.getSortvalue()));
		ImageIcon teamImg5 = new ImageIcon(new ImageIcon(
				"CSEdata/teams_png/"
				+ hotPlayers.get(4).getTeam() + ".png").getImage().getScaledInstance(X*35/1366,Y*35/768,
				Image.SCALE_AREA_AVERAGING));
		fifthTeambtn.setIcon(teamImg5);
		fifthTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotPlayers.get(4).getTeam(), mainFrame, previousPanel);
		});
	}
}
