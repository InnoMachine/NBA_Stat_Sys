package ui;

import java.awt.Image;

import javax.swing.JPanel;

import vo.GameVo;

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
		this.setBounds(0, 0, X*930/1366, Y*120/768);

		JLabel statelbl = new JLabel("结束");
		statelbl.setHorizontalAlignment(SwingConstants.CENTER);
		statelbl.setBounds(0, 0, X*930/1366, Y*20/768);
		add(statelbl);

		JButton teambtn1 = new JButton("Team1");
		teambtn1.setBounds(X*20/1366, Y*25/768, X*85/1366, Y*85/768);
		add(teambtn1);

		JButton teambtn2 = new JButton("Team2");
		teambtn2.setBounds(X*785/1366, Y*25/768, X*85/1366, Y*85/768);
		add(teambtn2);

		JButton detailbtn = new JButton("D");
		detailbtn.setBounds(X*880/1366, Y*70/768, X*40/1366, Y*40/768);
		add(detailbtn);

		JLabel teamlbl = new JLabel("球队");
		teamlbl.setHorizontalAlignment(SwingConstants.CENTER);
		teamlbl.setBounds(X*190/1366, Y*25/768, X*85/1366, Y*28/768);
		add(teamlbl);

		JLabel score1stlbl = new JLabel("1");
		score1stlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score1stlbl.setBounds(X*275/1366, Y*26/768, X*85/1366,Y*28/768);
		add(score1stlbl);

		JLabel score2ndlbl = new JLabel("2");
		score2ndlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score2ndlbl.setBounds(X*360/1366, Y*26/768, X*85/1366,Y*28/768);
		add(score2ndlbl);

		JLabel score3rdlbl = new JLabel("3");
		score3rdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score3rdlbl.setBounds(X*445/1366, Y*26/768, X*85/1366,Y*28/768);
		add(score3rdlbl);

		JLabel score4thlbl = new JLabel("4");
		score4thlbl.setHorizontalAlignment(SwingConstants.CENTER);
		score4thlbl.setBounds(X*530/1366, Y*26/768, X*85/1366,Y*28/768);
		add(score4thlbl);

		JLabel scoreSumlbl = new JLabel("总数");
		scoreSumlbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumlbl.setBounds(X*615/1366, Y*25/768, X*85/1366,Y*28/768);
		add(scoreSumlbl);

		teamName1tF = new JTextField();
		teamName1tF.setText("teamName1");
		teamName1tF.setHorizontalAlignment(SwingConstants.CENTER);
		teamName1tF.setEditable(false);
		teamName1tF.setBounds(X*190/1366, Y*53/768, X*85/1366,Y*28/768);
		add(teamName1tF);
		teamName1tF.setColumns(10);

		score11tF = new JTextField();
		score11tF.setText("T1-1");
		score11tF.setHorizontalAlignment(SwingConstants.CENTER);
		score11tF.setEditable(false);
		score11tF.setColumns(10);
		score11tF.setBounds(X*275/1366, Y*53/768, X*85/1366,Y*28/768);
		add(score11tF);

		score12tF = new JTextField();
		score12tF.setText("T1-2");
		score12tF.setHorizontalAlignment(SwingConstants.CENTER);
		score12tF.setEditable(false);
		score12tF.setColumns(10);
		score12tF.setBounds(X*360/1366, Y*53/768, X*85/1366,Y*28/768);
		add(score12tF);

		score13tF = new JTextField();
		score13tF.setText("T1-3");
		score13tF.setHorizontalAlignment(SwingConstants.CENTER);
		score13tF.setEditable(false);
		score13tF.setColumns(10);
		score13tF.setBounds(X*445/1366, Y*53/768, X*85/1366,Y*28/768);
		add(score13tF);

		score14tF = new JTextField();
		score14tF.setText("T1-4");
		score14tF.setHorizontalAlignment(SwingConstants.CENTER);
		score14tF.setEditable(false);
		score14tF.setColumns(10);
		score14tF.setBounds(X*530/1366, Y*53/768, X*85/1366,Y*28/768);
		add(score14tF);

		scoreSumtF1 = new JTextField();
		scoreSumtF1.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumtF1.setText("scoreSum1");
		scoreSumtF1.setEditable(false);
		scoreSumtF1.setColumns(10);
		scoreSumtF1.setBounds(X*615/1366, Y*53/768, X*85/1366,Y*28/768);
		add(scoreSumtF1);

		teamName2tF = new JTextField();
		teamName2tF.setText("teamName2");
		teamName2tF.setHorizontalAlignment(SwingConstants.CENTER);
		teamName2tF.setEditable(false);
		teamName2tF.setColumns(10);
		teamName2tF.setBounds(X*190/1366, Y*81/768, X*85/1366,Y*28/768);
		add(teamName2tF);

		score21tF = new JTextField();
		score21tF.setText("T2-1");
		score21tF.setHorizontalAlignment(SwingConstants.CENTER);
		score21tF.setEditable(false);
		score21tF.setColumns(10);
		score21tF.setBounds(X*275/1366, Y*81/768, X*85/1366,Y*28/768);
		add(score21tF);

		score22tF = new JTextField();
		score22tF.setText("T2-2");
		score22tF.setHorizontalAlignment(SwingConstants.CENTER);
		score22tF.setEditable(false);
		score22tF.setColumns(10);
		score22tF.setBounds(X*360/1366, Y*81/768, X*85/1366,Y*28/768);
		add(score22tF);

		score23tF = new JTextField();
		score23tF.setText("T2-3");
		score23tF.setHorizontalAlignment(SwingConstants.CENTER);
		score23tF.setEditable(false);
		score23tF.setColumns(10);
		score23tF.setBounds(X*445/1366, Y*81/768, X*85/1366,Y*28/768);
		add(score23tF);

		score24tF = new JTextField();
		score24tF.setText("T2-4");
		score24tF.setHorizontalAlignment(SwingConstants.CENTER);
		score24tF.setEditable(false);
		score24tF.setColumns(10);
		score24tF.setBounds(X*530/1366, Y*81/768, X*85/1366,Y*28/768);
		add(score24tF);

		scoreSumtF2 = new JTextField();
		scoreSumtF2.setHorizontalAlignment(SwingConstants.CENTER);
		scoreSumtF2.setText("scoreSum2");
		scoreSumtF2.setEditable(false);
		scoreSumtF2.setColumns(10);
		scoreSumtF2.setBounds(X*615/1366, Y*81/768, X*85/1366,Y*28/768);
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

		// score11tF.setText(gameVo.get);
		// score12tF.setText(gameVo.get);
		// score13tF.setText(gameVo.get);
		// score14tF.setText(gameVo.get);
		// score21tF.setText(gameVo.get);
		// score22tF.setText(gameVo.get);
		// score23tF.setText(gameVo.get);
		// score24tF.setText(gameVo.get);

		// scoreSumtF1.setText(gameVo.get);
		// scoreSumtF2.setText(gameVo.get);
	}

}
