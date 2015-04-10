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

	public TopFiveTeamCardPanel(int X,int Y,ArrayList<TeamCardVo> hotTeams) {
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.TeamVos = TeamVos;
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

		
		
		firstTeambtn = new JButton("");
		firstTeambtn.setBounds(X*5/1366, Y*24/768, X*160/1366, Y*160/768);
		firstTeambtn.setContentAreaFilled(false);
		firstTeambtn.setBorderPainted(false);
		firstTeambtn.setOpaque(false);
		add(firstTeambtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("黑体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(X*166/1366, Y*4/768, X*76/1366, Y*200/768);
		add(firstlbl);

		firstTeamNamelbl = new JLabel("");	
		firstTeamNamelbl.setBounds(X*242/1366, Y*35/768, X*180/1366, Y*62/1366);
		add(firstTeamNamelbl);

		firstTeamInfolbl = new JLabel("");	
		firstTeamInfolbl.setBounds(X*242/1366, Y*100/768, X*180/1366, Y*31/768);
		add(firstTeamInfolbl);

		firstTeamValuelbl = new JLabel("");
		firstTeamValuelbl.setFont(new Font("黑体", Font.PLAIN, 20));
		firstTeamValuelbl.setBounds(X*242/1366,Y*134/768, X*180/1366, Y*47/768);
		add(firstTeamValuelbl);

		secondTeambtn = new JButton("");
		secondTeambtn.setBounds(X*532/1366, Y*15/768, X*35/1366, Y*35/768);
		secondTeambtn.setContentAreaFilled(false);
		secondTeambtn.setBorderPainted(false);
		secondTeambtn.setOpaque(false);
		add(secondTeambtn);

		secondTeamNamelbl = new JLabel("");
		secondTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamNamelbl.setBounds(X*610/1366, Y*17/768, X*145/1366, Y*15/768);
		add(secondTeamNamelbl);

		secondTeamInfolbl = new JLabel("");
		secondTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamInfolbl.setBounds(X*610/1366, Y*33/768, X*145/1366, Y*15/768);
		add(secondTeamInfolbl);

		secondTeamValuelbl = new JLabel("");
		secondTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamValuelbl.setBounds(X*902/1366, Y*15/768, X*35/1366, Y*35/768);
		add(secondTeamValuelbl);

		thirdTeambtn = new JButton("");
		thirdTeambtn.setBounds(X*532/1366, Y*62/768, X*35/1366, Y*35/768);
		thirdTeambtn.setContentAreaFilled(false);
		thirdTeambtn.setBorderPainted(false);
		thirdTeambtn.setOpaque(false);
		add(thirdTeambtn);

		thirdTeamNamelbl = new JLabel("");
		thirdTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamNamelbl.setBounds(X*610/1366, Y*64/768, X*145/1366, Y*15/768);
		add(thirdTeamNamelbl);

		thirdTeamInfolbl = new JLabel("");
		thirdTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamInfolbl.setBounds(X*610/1366, Y*80/768, X*145/1366, Y*15/768);
		add(thirdTeamInfolbl);

		thirdTeamValuelbl = new JLabel("");
		thirdTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamValuelbl.setBounds(X*902/1366, Y*62/768, X*35/1366, Y*35/768);
		add(thirdTeamValuelbl);

		fourthTeambtn = new JButton("");
		fourthTeambtn.setBounds(X*532/1366, Y*109/768, X*35/1366, Y*35/768);
		fourthTeambtn.setContentAreaFilled(false);
		fourthTeambtn.setBorderPainted(false);
		fourthTeambtn.setOpaque(false);
		add(fourthTeambtn);

		fourthTeamNamelbl = new JLabel("c");
		fourthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamNamelbl.setBounds(X*610/1366, Y*111/768, X*145/1366, Y*15/768);
		add(fourthTeamNamelbl);

		fourthTeamInfolbl = new JLabel("");
		fourthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamInfolbl.setBounds(X*610/1366, Y*127/768, X*145/1366, Y*15/768);
		add(fourthTeamInfolbl);

		fourthTeamValuelbl = new JLabel("");
		fourthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamValuelbl.setBounds(X*902/1366, Y*109/768, X*35/1366, Y*35/768);
		add(fourthTeamValuelbl);

		fifthTeambtn = new JButton("");
		fifthTeambtn.setBounds(X*532/1366, Y*156/768, X*35/1366, Y*35/768);
		fifthTeambtn.setContentAreaFilled(false);
		fifthTeambtn.setBorderPainted(false);
		fifthTeambtn.setOpaque(false);
		add(fifthTeambtn);

		fifthTeamNamelbl = new JLabel("");
		fifthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamNamelbl.setBounds(X*610/1366, Y*158/768, X*145/1366, Y*15/768);
		add(fifthTeamNamelbl);

		fifthTeamInfolbl = new JLabel("");
		fifthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamInfolbl.setBounds(X*610/1366, Y*174/768, X*145/1366, Y*15/768);
		add(fifthTeamInfolbl);

		fifthTeamValuelbl = new JLabel("");
		fifthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamValuelbl.setBounds(X*902/1366, Y*156/768, X*35/1366, Y*35/768);
		add(fifthTeamValuelbl);

		showTopFiveData(hotTeams);

	}

	public void showTopFiveData(ArrayList<TeamCardVo> hotTeams) {
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ hotTeams.get(0).getAbbreviation() + ".png").getImage()
				.getScaledInstance(X*160/1366, Y*160/768, Image.SCALE_AREA_AVERAGING));
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
				.getScaledInstance(X*35/1366, Y*35/768, Image.SCALE_AREA_AVERAGING));
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
				.getScaledInstance(X*35/1366, Y*35/768, Image.SCALE_AREA_AVERAGING));
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
				.getScaledInstance(X*35/1366, Y*35/768, Image.SCALE_AREA_AVERAGING));
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
				.getScaledInstance(X*35/1366, Y*35/768, Image.SCALE_AREA_AVERAGING));
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
