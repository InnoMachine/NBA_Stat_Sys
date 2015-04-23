package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.PlayerCardVo;
import vo.TeamCardVo;
import vo.TeamVo;

public class TopFiveTeamCardPanel extends JPanel {
	private ArrayList<TeamVo> TeamVos = new ArrayList<TeamVo>();
	private String criteria;
    JFrame mainFrame;
    JPanel previousPanel;
	
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

	public TopFiveTeamCardPanel(int X, int Y, ArrayList<TeamCardVo> hotTeams,JFrame mainFrame,JPanel previousPanel) {
		this.X = X;
		this.Y = Y;
		this.mainFrame=mainFrame;
		this.previousPanel=previousPanel;
		
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.TeamVos = TeamVos;
		this.criteria = criteria;
		this.setBounds(0, 0, X * 967 / 1366, Y * 250 / 768);
		
		MyLabel secondlbl = new MyLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(X * 460 / 1366, Y * 40 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(secondlbl);

		MyLabel thirdlbl = new MyLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(X * 460/ 1366, Y * 90 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(thirdlbl);

		MyLabel fourthlbl = new MyLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(X * 460 / 1366, Y * 140 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(fourthlbl);

		MyLabel fifthlbl = new MyLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(X * 460 / 1366, Y * 190 / 768, X * 35 / 1366,
				Y * 35 / 768);
		add(fifthlbl);

		firstTeambtn = new JButton();
		firstTeambtn.setBounds(X * 60/ 1366, Y * 50 / 768, X * 160 / 1366,
				Y * 160 / 768);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		MyLabel firstlbl = new MyLabel("1");
		firstlbl.setFont(new Font("微软雅黑", Font.PLAIN, 50));
		firstlbl.setForeground(Color.red);
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(X * 1/ 1366, Y *100 / 768, X * 50/ 1366,
				Y * 50 / 768);
		add(firstlbl);

		firstTeamNamelbl = new MyLabel("");
		firstTeamNamelbl.setBounds(X * 242 / 1366, Y * 50 / 768,
				X * 180 / 1366, Y * 50 / 1366);
		add(firstTeamNamelbl);

		firstTeamInfolbl = new MyLabel("");
		firstTeamInfolbl.setBounds(X * 242 / 1366, Y * 120 / 768,
				X * 180 / 1366, Y * 50 / 768);
		add(firstTeamInfolbl);

		firstTeamValuelbl = new MyLabel("");
		firstTeamValuelbl.setFont(new Font("黑体", Font.BOLD, 20));
		firstTeamValuelbl.setBounds(X * 242 / 1366, Y * 190 / 768,
				X * 180 / 1366, Y *50 / 768);
		add(firstTeamValuelbl);

		secondTeambtn = new JButton("");
		secondTeambtn.setBounds(X * 532 / 1366, Y * 40 / 768, X * 40 / 1366,
				Y * 40 / 768);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		secondTeamNamelbl = new MyLabel("");
		secondTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamNamelbl.setBounds(X * 610 / 1366, Y *40 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(secondTeamNamelbl);

		secondTeamInfolbl = new MyLabel("");
		secondTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamInfolbl.setBounds(X * 610 / 1366, Y *60/ 768,
				X * 145 / 1366, Y * 15 / 768);
		add(secondTeamInfolbl);

		secondTeamValuelbl = new MyLabel("");
		secondTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamValuelbl.setBounds(X * 800 / 1366, Y *40 / 768,
				X * 100 / 1366, Y * 35 / 768);
		add(secondTeamValuelbl);

		thirdTeambtn = new JButton("");
		thirdTeambtn.setBounds(X * 532 / 1366, Y *90 / 768, X * 40 / 1366,
				Y * 40 / 768);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		thirdTeamNamelbl = new MyLabel("");
		thirdTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamNamelbl.setBounds(X * 610 / 1366, Y * 90 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(thirdTeamNamelbl);

		thirdTeamInfolbl = new MyLabel("");
		thirdTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamInfolbl.setBounds(X * 610 / 1366, Y * 110 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(thirdTeamInfolbl);

		thirdTeamValuelbl = new MyLabel("");
		thirdTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamValuelbl.setBounds(X * 800 / 1366, Y * 90 / 768,
				X * 100 / 1366, Y * 35 / 768);
		add(thirdTeamValuelbl);

		fourthTeambtn = new JButton("");
		fourthTeambtn.setBounds(X * 532 / 1366, Y *140 / 768, X * 40 / 1366,
				Y * 40 / 768);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fourthTeamNamelbl = new MyLabel("c");
		fourthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamNamelbl.setBounds(X * 610 / 1366, Y * 140 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(fourthTeamNamelbl);

		fourthTeamInfolbl = new MyLabel("");
		fourthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamInfolbl.setBounds(X * 610 / 1366, Y * 160 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(fourthTeamInfolbl);

		fourthTeamValuelbl = new MyLabel("");
		fourthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamValuelbl.setBounds(X * 800/ 1366, Y *140 / 768,
				X * 100 / 1366, Y * 35 / 768);
		add(fourthTeamValuelbl);

		fifthTeambtn = new JButton("");
		fifthTeambtn.setBounds(X * 532 / 1366, Y * 190 / 768, X * 40 / 1366,
				Y * 40 / 768);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
		add(fifthTeambtn);

		fifthTeamNamelbl = new MyLabel("");
		fifthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamNamelbl.setBounds(X * 610 / 1366, Y * 190 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(fifthTeamNamelbl);

		fifthTeamInfolbl = new MyLabel("");
		fifthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamInfolbl.setBounds(X * 610 / 1366, Y * 210 / 768,
				X * 145 / 1366, Y * 15 / 768);
		add(fifthTeamInfolbl);

		fifthTeamValuelbl = new MyLabel("");
		fifthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamValuelbl.setBounds(X * 800 / 1366, Y * 190 / 768,
				X * 100 / 1366, Y * 35 / 768);
		add(fifthTeamValuelbl);

		showTopFiveData(hotTeams);

	}

	public void showTopFiveData(ArrayList<TeamCardVo> hotTeams) {
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(0).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X * 160 / 1366, Y * 160 / 768,
						Image.SCALE_AREA_AVERAGING));
		firstTeambtn.setIcon(teamImg1);
		firstTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotTeams.get(0).getAbbreviation(), mainFrame, previousPanel);
		});
		firstTeamNamelbl.setText(hotTeams.get(0).getCity() + " "
				+ hotTeams.get(0).getTeamName());
		firstTeamInfolbl.setText(String
				.valueOf(hotTeams.get(0).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(0).getDivision()));
		firstTeamValuelbl.setText(String
				.valueOf(hotTeams.get(0).getSortValue()));

		ImageIcon teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(1).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X * 40 / 1366, Y * 40 / 768,
						Image.SCALE_AREA_AVERAGING));
		secondTeambtn.setIcon(teamImg2);
		secondTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotTeams.get(1).getAbbreviation(), mainFrame, previousPanel);
		});
		secondTeamNamelbl.setText(hotTeams.get(1).getCity() + " "
				+ hotTeams.get(1).getTeamName());
		secondTeamInfolbl.setText(String.valueOf(hotTeams.get(1)
				.getConference())
				+ " "
				+ String.valueOf(hotTeams.get(1).getDivision()));
		secondTeamValuelbl.setText(String.valueOf(hotTeams.get(1)
				.getSortValue()));

		ImageIcon teamImg3 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(2).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X * 40 / 1366, Y * 40 / 768,
						Image.SCALE_AREA_AVERAGING));
		thirdTeambtn.setIcon(teamImg3);
		thirdTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotTeams.get(2).getAbbreviation(), mainFrame, previousPanel);
		});
		thirdTeamNamelbl.setText(hotTeams.get(2).getCity() + " "
				+ hotTeams.get(2).getTeamName());
		thirdTeamInfolbl.setText(String
				.valueOf(hotTeams.get(2).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(2).getDivision()));
		thirdTeamValuelbl.setText(String
				.valueOf(hotTeams.get(2).getSortValue()));

		ImageIcon teamImg4 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(3).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X * 40 / 1366, Y *40 / 768,
						Image.SCALE_AREA_AVERAGING));
		fourthTeambtn.setIcon(teamImg4);
		fourthTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotTeams.get(3).getAbbreviation(), mainFrame, previousPanel);
		});
		fourthTeamNamelbl.setText(hotTeams.get(3).getCity() + " "
				+ hotTeams.get(3).getTeamName());
		fourthTeamInfolbl.setText(String.valueOf(hotTeams.get(3)
				.getConference())
				+ " "
				+ String.valueOf(hotTeams.get(3).getDivision()));
		fourthTeamValuelbl.setText(String.valueOf(hotTeams.get(3)
				.getSortValue()));

		ImageIcon teamImg5 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(4).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X * 40 / 1366, Y * 40 / 768,
						Image.SCALE_AREA_AVERAGING));
		fifthTeambtn.setIcon(teamImg5);
		fifthTeambtn.addActionListener(e->{
			previousPanel.setVisible(false);
			TeamInfoPanel teamInfoPanel=new TeamInfoPanel(hotTeams.get(4).getAbbreviation(), mainFrame, previousPanel);
		});
		fifthTeamNamelbl.setText(hotTeams.get(4).getCity() + " "
				+ hotTeams.get(4).getTeamName());
		fifthTeamInfolbl.setText(String
				.valueOf(hotTeams.get(4).getConference())
				+ " "
				+ String.valueOf(hotTeams.get(4).getDivision()));
		fifthTeamValuelbl.setText(String
				.valueOf(hotTeams.get(4).getSortValue()));

	}
	class MyLabel extends JLabel {
		/**
			 * 
			 */
		private static final long serialVersionUID = 1L;

		public MyLabel(){
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
		}
		
		public MyLabel(String s){
			super();
			this.setText(s);
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
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
