package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import vo.GameVo;
import vo.PlayerVo;

public class PlayerBasicInfoCardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PlayerVo playerVo;
	int X;
	int Y;
	private JButton playerbtn;
	private JButton teambtn;
	
	public PlayerBasicInfoCardPanel(int X, int Y, PlayerVo playerVo) {
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVo = playerVo;
		this.setBounds(0, 0, X * 930 / 1366, Y * 120 / 768);

		playerbtn = new JButton();
		playerbtn.setBounds(X * 30 / 1366, Y * 10 / 768, X * 100 / 1366,
				Y * 100 / 768);
		playerbtn.setContentAreaFilled(false);
		playerbtn.setBorderPainted(false);
		playerbtn.setVisible(true);
		add(playerbtn);

		MyLabel lblNumber = new MyLabel();
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setBounds(X * 153 / 1366, Y * 10 / 768, X * 62 / 1366,
				Y * 100 / 768);
		lblNumber.setFont(new Font("黑体", 1, 16));
		add(lblNumber);

		MyLabel lblPname = new MyLabel();
		lblPname.setHorizontalAlignment(SwingConstants.CENTER);
		lblPname.setBounds(X * 260 / 1366, Y * 10 / 768, X * 160 / 1366,
				Y * 20 / 768);
		add(lblPname);

		MyLabel lblPinfo = new MyLabel();
		lblPinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinfo.setBounds(X * 260 / 1366, Y * 30 / 768, X * 160 / 1366,
				Y * 20 / 768);
		add(lblPinfo);

		MyLabel lblNewLabel = new MyLabel("H&W：");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(X * 450 / 1366, Y * 10 / 768, X * 40 / 1366,
				Y * 20 / 768);
		add(lblNewLabel);

		MyLabel heightAweightlbl = new MyLabel();
		heightAweightlbl.setHorizontalAlignment(SwingConstants.CENTER);
		heightAweightlbl.setBounds(X * 490 / 1366, Y * 10 / 768,
				X * 120 / 1366, Y * 20 / 768);
		add(heightAweightlbl);

		MyLabel lblNewLabel_1 = new MyLabel("生日：");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(X * 450 / 1366, Y * 30 / 768, X * 40 / 1366,
				Y * 20 / 768);
		add(lblNewLabel_1);

		MyLabel lblBirth = new MyLabel();
		lblBirth.setHorizontalAlignment(SwingConstants.CENTER);
		lblBirth.setBounds(X * 490 / 1366, Y * 30 / 768, X * 120 / 1366,
				Y * 20 / 768);
		add(lblBirth);

		MyLabel lblNewLabel_2 = new MyLabel("球龄：");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(X * 640 / 1366, Y * 10 / 768, X * 40 / 1366,
				Y * 20 / 768);
		add(lblNewLabel_2);

		MyLabel lblExp = new MyLabel();
		lblExp.setHorizontalAlignment(SwingConstants.CENTER);
		lblExp.setBounds(X * 680 / 1366, Y * 10 / 768, X * 120 / 1366,
				Y * 20 / 768);
		add(lblExp);

		MyLabel label = new MyLabel("院校：");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(X * 640 / 1366, Y * 30 / 768, X * 40 / 1366,
				Y * 20 / 768);
		add(label);

		MyLabel lblSchool = new MyLabel();
		lblSchool.setHorizontalAlignment(SwingConstants.CENTER);
		lblSchool.setBounds(X * 680 / 1366, Y * 30 / 768, X * 145 / 1366,
				Y * 20 / 768);
		add(lblSchool);

		MyLabel scoreFieldlbl = new MyLabel("场均得分");
		scoreFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreFieldlbl.setBounds(X * 260 / 1366, Y * 60 / 768, X * 130 / 1366,
				Y * 20 / 768);
		add(scoreFieldlbl);

		MyLabel reboundFieldlbl = new MyLabel("场均篮板");
		reboundFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		reboundFieldlbl.setBounds(X * 390 / 1366, Y * 60 / 768, X * 130 / 1366,
				Y * 20 / 768);
		add(reboundFieldlbl);

		MyLabel assistanceFieldlbl = new MyLabel("场均助攻");
		assistanceFieldlbl.setHorizontalAlignment(SwingConstants.CENTER);
		assistanceFieldlbl.setBounds(X * 520 / 1366, Y * 60 / 768,
				X * 130 / 1366, Y * 20 / 768);
		add(assistanceFieldlbl);

		MyLabel scoreFieldValuelbl = new MyLabel();
		scoreFieldValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		scoreFieldValuelbl.setBounds(X * 260 / 1366, Y * 80 / 768,
				X * 130 / 1366, Y * 20 / 768);
		add(scoreFieldValuelbl);

		MyLabel reboundFieldValuelbl = new MyLabel();
		reboundFieldValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		reboundFieldValuelbl.setBounds(X * 390 / 1366, Y * 80 / 768,
				X * 130 / 1366, Y * 20 / 768);
		add(reboundFieldValuelbl);

		MyLabel assistanceFieldValuelbl = new MyLabel();
		assistanceFieldValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		assistanceFieldValuelbl.setBounds(X * 520 / 1366, Y * 80 / 768,
				X * 130 / 1366, Y * 20 / 768);
		add(assistanceFieldValuelbl);

		teambtn = new JButton();
		teambtn.setBounds(X * 830 / 1366, Y * 20 / 768, X * 80 / 1366,
				Y * 80 / 768);
//		teambtn.addActionListener(e->{System.out.println("click teambtn");});
		teambtn.setContentAreaFilled(false);
		teambtn.setBorderPainted(false);
		teambtn.setVisible(true);
		add(teambtn);

		ImageIcon playerImg;
		if (hasPortrait( playerVo.getName() + ".png")) {
			playerImg = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" + playerVo.getName() + ".png")
			.getImage().getScaledInstance(X * 100 / 1366, Y * 100 / 768,
					Image.SCALE_AREA_AVERAGING));
		} else {
			playerImg = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/" +"DefaultPortrait" + ".png")
			.getImage().getScaledInstance(X * 100 / 1366, Y * 100 / 768,
					Image.SCALE_AREA_AVERAGING));
		}
		playerbtn.setIcon(playerImg);

		lblNumber.setText(playerVo.getNumber());
		lblPname.setText(playerVo.getName());
		lblPinfo.setText(playerVo.getPosition() + "/" + playerVo.getTeam());
		heightAweightlbl.setText(playerVo.getHeight() + "/"
				+ playerVo.getWeight());
		lblBirth.setText(playerVo.getBirth());
		lblExp.setText(String.valueOf(playerVo.getExp()));
		lblSchool.setText(playerVo.getSchool());
		scoreFieldValuelbl.setText(String.valueOf(playerVo.getScoreField()));
		reboundFieldValuelbl.setText(String.valueOf(playerVo
				.getReboundOverallField()));
		assistanceFieldValuelbl.setText(String.valueOf(playerVo
				.getAssistanceField()));

		ImageIcon teamImg = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ playerVo.getTeam() + ".png").getImage().getScaledInstance(
				X * 80 / 1366, Y * 80 / 768, Image.SCALE_AREA_AVERAGING));
		teambtn.setIcon(teamImg);

	}
	
	public JButton getPlayerBTN(){
		return this.playerbtn;
	}
	
	public JButton getTeamBTN(){
		return this.teambtn;
	}
	
	public PlayerVo getPlayerVo() {
		return playerVo;
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
			if (portraitPath.equals(portrait[i])) {
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
			this.setFont(new Font("黑体", 1, 11));
			this.setForeground(Color.WHITE);
		}

		public MyLabel(String text) {
			super();
			this.setText(text);
			this.setOpaque(false);
			this.setFont(new Font("黑体", 1, 11));
			this.setForeground(Color.WHITE);
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
