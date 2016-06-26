package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;

import vo.GameVo;
import vo.PlayerVo;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;

public class GameCardPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameVo gameVo;
	int X;
	int Y;
	private JTextField teamName1tF;
	private JTextField score11tF;
	private JTextField score12tF;
	private JTextField score13tF;
	private JTextField score14tF;
	private JTextField scoreSumtF1;
	private JTextField teamName2tF;
	private JTextField score21tF;
	private JTextField score22tF;
	private JTextField score23tF;
	private JTextField score24tF;
	private JTextField scoreSumtF2;

	public GameCardPanel(int X, int Y, GameVo gameVo) {
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.gameVo = gameVo;
		this.setBounds(0, 0, X * 700 / 1366, Y * 100 / 768);

		JLabel statelbl = new MyLabel("结束");
		statelbl.setHorizontalAlignment(SwingConstants.CENTER);
		statelbl.setBounds(X * 310 / 1366, Y * 5 / 768, X * 80 / 1366,
				Y * 20 / 768);
		statelbl.setFont(new Font("黑体", 1, 14));
		statelbl.setBackground(Color.GRAY);
		statelbl.setOpaque(true);
		add(statelbl);

		JButton teambtn1 = new JButton();
		teambtn1.setBounds(X * 10 / 1366, Y * 0 / 768, X * 130 / 1366,
				Y * 130 / 768);
		teambtn1.setContentAreaFilled(false);
		teambtn1.setBorderPainted(false);
		teambtn1.setOpaque(false);
		add(teambtn1);

		JButton teambtn2 = new JButton();
		teambtn2.setBounds(X * 560 / 1366, Y * 0 / 768, X * 130 / 1366,
				Y * 130 / 768);
		teambtn2.setContentAreaFilled(false);
		teambtn2.setBorderPainted(false);
		teambtn2.setOpaque(false);
		add(teambtn2);
		/*
		 * JButton detailbtn = new JButton("D"); detailbtn.setBounds(X * 880 /
		 * 1366, Y * 70 / 768, X * 40 / 1366, Y * 40 / 768); add(detailbtn);
		 */
		JLabel teamlbl = new MyLabel("球队");
		teamlbl.setHorizontalAlignment(SwingConstants.CENTER);
		teamlbl.setBounds(X * 155 / 1366, Y * 25 / 768, X * 65 / 1366,
				Y * 28 / 768);
		teamlbl.setFont(new Font("黑体", 1, 14));
		add(teamlbl);

		JLabel score1stlbl = new MyLabel("1");
		score1stlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score1stlbl.setBounds(X * 220 / 1366, Y * 26 / 768, X * 65 / 1366,
				Y * 28 / 768);
		score1stlbl.setFont(new Font("黑体", 1, 14));
		add(score1stlbl);

		JLabel score2ndlbl = new MyLabel("2");
		score2ndlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score2ndlbl.setBounds(X * 285 / 1366, Y * 26 / 768, X * 65 / 1366,
				Y * 28 / 768);
		score2ndlbl.setFont(new Font("黑体", 1, 14));
		add(score2ndlbl);

		JLabel score3rdlbl = new MyLabel("3");
		score3rdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score3rdlbl.setBounds(X * 350 / 1366, Y * 26 / 768, X * 65 / 1366,
				Y * 28 / 768);
		score3rdlbl.setFont(new Font("黑体", 1, 14));
		add(score3rdlbl);

		JLabel score4thlbl = new MyLabel("4");
		score4thlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score4thlbl.setBounds(X * 415 / 1366, Y * 26 / 768, X * 65 / 1366,
				Y * 28 / 768);
		score4thlbl.setFont(new Font("黑体", 1, 14));
		add(score4thlbl);

		JLabel scoreSumlbl = new MyLabel("总数");
		scoreSumlbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumlbl.setBounds(X * 480 / 1366, Y * 25 / 768, X * 65 / 1366,
				Y * 28 / 768);
		scoreSumlbl.setFont(new Font("黑体", 1, 14));
		add(scoreSumlbl);

		teamName1tF = new MyTextField();
		teamName1tF.setText("teamName1");
		teamName1tF.setHorizontalAlignment(SwingConstants.CENTER);
		teamName1tF.setEditable(false);
		teamName1tF.setBounds(X * 155 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(teamName1tF);
		teamName1tF.setColumns(X * 10 / 1366);

		score11tF = new MyTextField();
		score11tF.setText("T1-1");
		score11tF.setHorizontalAlignment(SwingConstants.CENTER);
		score11tF.setEditable(false);
		score11tF.setColumns(X * 10 / 1366);
		score11tF.setBounds(X * 220 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score11tF);

		score12tF = new MyTextField();
		score12tF.setText("T1-2");
		score12tF.setHorizontalAlignment(SwingConstants.CENTER);
		score12tF.setEditable(false);
		score12tF.setColumns(X * 10 / 1366);
		score12tF.setBounds(X * 285 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score12tF);

		score13tF = new MyTextField();
		score13tF.setText("T1-3");
		score13tF.setHorizontalAlignment(SwingConstants.CENTER);
		score13tF.setEditable(false);
		score13tF.setColumns(X * 10 / 1366);
		score13tF.setBounds(X * 350 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score13tF);

		score14tF = new MyTextField();
		score14tF.setText("T1-4");
		score14tF.setHorizontalAlignment(SwingConstants.CENTER);
		score14tF.setEditable(false);
		score14tF.setColumns(X * 10 / 1366);
		score14tF.setBounds(X * 415 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score14tF);

		scoreSumtF1 = new MyTextField();
		scoreSumtF1.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumtF1.setText("scoreSum1");
		scoreSumtF1.setEditable(false);
		scoreSumtF1.setColumns(X * 10 / 1366);
		scoreSumtF1.setBounds(X * 480 / 1366, Y * 53 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(scoreSumtF1);

		teamName2tF = new MyTextField();
		teamName2tF.setText("teamName2");
		teamName2tF.setHorizontalAlignment(SwingConstants.CENTER);
		teamName2tF.setEditable(false);
		teamName2tF.setColumns(X * 10 / 1366);
		teamName2tF.setBounds(X * 155 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(teamName2tF);

		score21tF = new MyTextField();
		score21tF.setText("T2-1");
		score21tF.setHorizontalAlignment(SwingConstants.CENTER);
		score21tF.setEditable(false);
		score21tF.setColumns(X * 10 / 1366);
		score21tF.setBounds(X * 220 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score21tF);

		score22tF = new MyTextField();
		score22tF.setText("T2-2");
		score22tF.setHorizontalAlignment(SwingConstants.CENTER);
		score22tF.setEditable(false);
		score22tF.setColumns(X * 10 / 1366);
		score22tF.setBounds(X * 285 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score22tF);

		score23tF = new MyTextField();
		score23tF.setText("T2-3");
		score23tF.setHorizontalAlignment(SwingConstants.CENTER);
		score23tF.setEditable(false);
		score23tF.setColumns(X * 10 / 1366);
		score23tF.setBounds(X * 350 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score23tF);

		score24tF = new MyTextField();
		score24tF.setText("T2-4");
		score24tF.setHorizontalAlignment(SwingConstants.CENTER);
		score24tF.setEditable(false);
		score24tF.setColumns(X * 10 / 1366);
		score24tF.setBounds(X * 415 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(score24tF);

		scoreSumtF2 = new MyTextField();
		scoreSumtF2.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumtF2.setText("scoreSum2");
		scoreSumtF2.setEditable(false);
		scoreSumtF2.setColumns(X * 10 / 1366);
		scoreSumtF2.setBounds(X * 480 / 1366, Y * 81 / 768, X * 65 / 1366,
				Y * 28 / 768);
		add(scoreSumtF2);

		ImageIcon homeTeam = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getHomeTeam() + ".png").getImage().getScaledInstance(
				X * 85 / 1366, Y * 85 / 768, Image.SCALE_AREA_AVERAGING));
		teambtn1.setIcon(homeTeam);

		ImageIcon guestTeam = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getGuestTeam() + ".png").getImage().getScaledInstance(
				X * 85 / 1366, Y * 85 / 768, Image.SCALE_AREA_AVERAGING));
		teambtn2.setIcon(guestTeam);

		teamName1tF.setText(gameVo.getHomeTeam());
		teamName2tF.setText(gameVo.getGuestTeam());

		score11tF.setText(String.valueOf(gameVo.getScore1st().getHomeScore()));

		
		score12tF.setText(String.valueOf(gameVo.getScore2nd().getHomeScore()));
		
		score13tF.setText(String.valueOf(gameVo.getScore3rd().getHomeScore()));
		score14tF.setText(String.valueOf(gameVo.getScore4th().getHomeScore()));
		score21tF.setText(String.valueOf(gameVo.getScore1st().getGuestScore()));
		score22tF.setText(String.valueOf(gameVo.getScore2nd().getGuestScore()));
		score23tF.setText(String.valueOf(gameVo.getScore3rd().getGuestScore()));
		score24tF.setText(String.valueOf(gameVo.getScore4th().getGuestScore()));

		scoreSumtF1.setText(String.valueOf(gameVo.getScoreOverall()
				.getHomeScore()));
		scoreSumtF2.setText(String.valueOf(gameVo.getScoreOverall()
				.getGuestScore()));
	}

	public GameVo getGameVo() {
		return gameVo;
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
			this.setFont(new Font("黑体", 1, 14));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 14));
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
