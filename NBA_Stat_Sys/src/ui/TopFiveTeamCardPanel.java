package ui;

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.PlayerCardVo;
import vo.TeamCardVo;
import vo.TeamVo;

public class TopFiveTeamCardPanel extends JPanel {
	private ArrayList<TeamVo> TeamVos = new ArrayList<TeamVo>();
	private String criteria;
	int X;
	int Y;

	JButton firstTeambtn;
	JLabel firstTeamNamelbl;
	JLabel firstTeamInfolbl;
	JLabel firstTeamValuelbl;
	JButton secondTeambtn;
	JLabel secondTeamNamelbl;
	JLabel secondTeamInfolbl;
	JLabel secondTeamValuelbl;
	JButton thirdTeambtn;
	JLabel thirdTeamNamelbl;
	JLabel thirdTeamInfolbl;
	JLabel thirdTeamValuelbl;
	JButton fourthTeambtn;
	JLabel fourthTeamNamelbl;
	JLabel fourthTeamInfolbl;
	JLabel fourthTeamValuelbl;
	JButton fifthTeambtn;
	JLabel fifthTeamNamelbl;
	JLabel fifthTeamInfolbl;
	JLabel fifthTeamValuelbl;

	public TopFiveTeamCardPanel(ArrayList<TeamCardVo> hotTeams) {
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.TeamVos = TeamVos;
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

		firstTeambtn = new JButton("Team1-action");
		firstTeambtn.setBounds(5, 5, 140, 140);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("宋体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(145, 5, 37, 140);
		add(firstlbl);

		firstTeamNamelbl = new JLabel("city&name1");
		firstTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamNamelbl.setBounds(186, 24, 150, 45);
		add(firstTeamNamelbl);

		firstTeamInfolbl = new JLabel("Info1");
		firstTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamInfolbl.setBounds(186, 72, 150, 23);
		add(firstTeamInfolbl);

		firstTeamValuelbl = new JLabel("Value1");
		firstTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamValuelbl.setBounds(186, 96, 150, 47);
		add(firstTeamValuelbl);

		secondTeambtn = new JButton("Team2");
		secondTeambtn.setBounds(368, 3, 35, 35);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		secondTeamNamelbl = new JLabel("city&name2");
		secondTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamNamelbl.setBounds(425, 4, 150, 15);
		add(secondTeamNamelbl);

		secondTeamInfolbl = new JLabel("Info2");
		secondTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamInfolbl.setBounds(425, 24, 150, 15);
		add(secondTeamInfolbl);

		secondTeamValuelbl = new JLabel("Value2");
		secondTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamValuelbl.setBounds(606, 8, 47, 25);
		add(secondTeamValuelbl);

		thirdTeambtn = new JButton("Team3");
		thirdTeambtn.setBounds(368, 40, 35, 35);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		thirdTeamNamelbl = new JLabel("city&name3");
		thirdTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamNamelbl.setBounds(425, 41, 150, 15);
		add(thirdTeamNamelbl);

		thirdTeamInfolbl = new JLabel("Info3");
		thirdTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamInfolbl.setBounds(425, 57, 150, 15);
		add(thirdTeamInfolbl);

		thirdTeamValuelbl = new JLabel("Value3");
		thirdTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamValuelbl.setBounds(606, 45, 47, 25);
		add(thirdTeamValuelbl);

		fourthTeambtn = new JButton("Team4");
		fourthTeambtn.setBounds(368, 77, 35, 35);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fourthTeamNamelbl = new JLabel("city&name4");
		fourthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamNamelbl.setBounds(425, 78, 150, 15);
		add(fourthTeamNamelbl);

		fourthTeamInfolbl = new JLabel("Info4");
		fourthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamInfolbl.setBounds(425, 94, 150, 15);
		add(fourthTeamInfolbl);

		fourthTeamValuelbl = new JLabel("Value4");
		fourthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamValuelbl.setBounds(606, 82, 47, 25);
		add(fourthTeamValuelbl);

		fifthTeambtn = new JButton("Team5");
		fifthTeambtn.setBounds(368, 114, 35, 35);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
		add(fifthTeambtn);

		fifthTeamNamelbl = new JLabel("city&name5");
		fifthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamNamelbl.setBounds(425, 115, 150, 15);
		add(fifthTeamNamelbl);

		fifthTeamInfolbl = new JLabel("Info5");
		fifthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamInfolbl.setBounds(425, 131, 150, 15);
		add(fifthTeamInfolbl);

		fifthTeamValuelbl = new JLabel("Value5");
		fifthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamValuelbl.setBounds(606, 119, 47, 25);
		add(fifthTeamValuelbl);

		showTopFiveData(hotTeams);

	}

	public void showTopFiveData(ArrayList<TeamCardVo> hotTeams) {
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(0).getAbbreviation() + ".png").getImage()
				.getScaledInstance(140, 140, Image.SCALE_AREA_AVERAGING));
		firstTeambtn.setIcon(teamImg1);
		firstTeamNamelbl.setText(hotTeams.get(0).getCity()+" "+hotTeams.get(0).getTeamName());
		firstTeamInfolbl.setText(String
				.valueOf(hotTeams.get(0).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(0).getDivision()));
		firstTeamValuelbl.setText(String
				.valueOf(hotTeams.get(0).getSortValue()));

		ImageIcon teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(1).getAbbreviation() + ".png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING));
		secondTeambtn.setIcon(teamImg2);
		secondTeamNamelbl.setText(hotTeams.get(1).getCity()+" "+hotTeams.get(1).getTeamName());
		secondTeamInfolbl.setText(String.valueOf(hotTeams.get(1)
				.getConference())
				+ " "
				+ String.valueOf(hotTeams.get(1).getDivision()));
		secondTeamValuelbl.setText(String.valueOf(hotTeams.get(1)
				.getSortValue()));

		ImageIcon teamImg3 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(2).getAbbreviation() + ".png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING));
		thirdTeambtn.setIcon(teamImg3);
		thirdTeamNamelbl.setText(hotTeams.get(2).getCity()+" "+hotTeams.get(2).getTeamName());
		thirdTeamInfolbl.setText(String
				.valueOf(hotTeams.get(2).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(2).getDivision()));
		thirdTeamValuelbl.setText(String
				.valueOf(hotTeams.get(2).getSortValue()));

		ImageIcon teamImg4 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(3).getAbbreviation() + ".png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING));
		fourthTeambtn.setIcon(teamImg4);
		fourthTeamNamelbl.setText(hotTeams.get(3).getCity()+" "+hotTeams.get(3).getTeamName());
		fourthTeamInfolbl.setText(String.valueOf(hotTeams.get(3)
				.getConference())
				+ " "
				+ String.valueOf(hotTeams.get(3).getDivision()));
		fourthTeamValuelbl.setText(String.valueOf(hotTeams.get(3)
				.getSortValue()));

		ImageIcon teamImg5 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(4).getAbbreviation() + ".png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_AREA_AVERAGING));
		fifthTeambtn.setIcon(teamImg5);
		fifthTeamNamelbl.setText(hotTeams.get(4).getCity()+" "+hotTeams.get(4).getTeamName());
		fifthTeamInfolbl.setText(String
				.valueOf(hotTeams.get(4).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(4).getDivision()));
		fifthTeamValuelbl.setText(String
				.valueOf(hotTeams.get(4).getSortValue()));

	}
}
