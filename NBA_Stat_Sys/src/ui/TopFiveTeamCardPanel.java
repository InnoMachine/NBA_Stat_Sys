package ui;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import vo.TeamVo;

public class TopFiveTeamCardPanel extends JPanel{
	private ArrayList<TeamVo> TeamVos = new ArrayList<TeamVo>();
	private String criteria;
	int X;
	int Y;

	public TopFiveTeamCardPanel(ArrayList<TeamVo> TeamVos,
			String criteria) {
		this.X = X;
		this.Y = Y;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.TeamVos = TeamVos;
		this.criteria = criteria;
		this.setBounds(0, 0, 598, 150);

		JLabel secondlbl = new JLabel("2");
		secondlbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondlbl.setBounds(299, 2, 37, 37);
		add(secondlbl);

		JLabel thirdlbl = new JLabel("3");
		thirdlbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdlbl.setBounds(299, 39, 37, 37);
		add(thirdlbl);

		JLabel fourthlbl = new JLabel("4");
		fourthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthlbl.setBounds(299, 76, 37, 37);
		add(fourthlbl);

		JLabel fifthlbl = new JLabel("5");
		fifthlbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthlbl.setBounds(299, 113, 37, 37);
		add(fifthlbl);

		JButton firstTeambtn = new JButton("Team1-action");
		firstTeambtn.setBounds(5, 5, 88, 140);
		add(firstTeambtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("宋体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(92, 5, 37, 140);
		add(firstlbl);
		
		JLabel firstTeamNamelbl = new JLabel("city&name1");
		firstTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamNamelbl.setBounds(132, 25, 132, 45);
		add(firstTeamNamelbl);

		JLabel firstTeamInfolbl = new JLabel("Info1");
		firstTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamInfolbl.setBounds(132, 72, 163, 23);
		add(firstTeamInfolbl);

		JLabel firstTeamValuelbl = new JLabel("Value1");
		firstTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstTeamValuelbl.setBounds(132, 98, 65, 47);
		add(firstTeamValuelbl);

		

		JButton secondTeambtn = new JButton("Team2");
		secondTeambtn.setBounds(333, 3, 35, 35);
		add(secondTeambtn);

		JLabel secondTeamNamelbl = new JLabel("city&name2");
		secondTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamNamelbl.setBounds(378, 4, 150, 15);
		add(secondTeamNamelbl);

		JLabel secondTeamInfolbl = new JLabel("Info2");
		secondTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamInfolbl.setBounds(378, 20, 150, 15);
		add(secondTeamInfolbl);
		
		JLabel secondTeamValuelbl = new JLabel("Value2");
		secondTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondTeamValuelbl.setBounds(530, 7, 37, 25);
		add(secondTeamValuelbl);

		
		JButton thirdTeambtn = new JButton("Team3");
		thirdTeambtn.setBounds(333, 40, 35, 35);
		add(thirdTeambtn);

		JLabel thirdTeamNamelbl = new JLabel("city&name3");
		thirdTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamNamelbl.setBounds(378, 41, 150, 15);
		add(thirdTeamNamelbl);

		JLabel thirdTeamInfolbl = new JLabel("Info3");
		thirdTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamInfolbl.setBounds(378, 57, 150, 15);
		add(thirdTeamInfolbl);

		JLabel thirdTeamValuelbl = new JLabel("Value3");
		thirdTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdTeamValuelbl.setBounds(530, 44, 37, 25);
		add(thirdTeamValuelbl);
		

		JButton fourthTeambtn = new JButton("Team4");
		fourthTeambtn.setBounds(333, 77, 35, 35);
		add(fourthTeambtn);
		
		JLabel fourthTeamNamelbl = new JLabel("city&name4");
		fourthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamNamelbl.setBounds(378, 78, 150, 15);
		add(fourthTeamNamelbl);

		JLabel fourthTeamInfolbl = new JLabel("Info4");
		fourthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamInfolbl.setBounds(378, 94, 150, 15);
		add(fourthTeamInfolbl);

		JLabel fourthTeamValuelbl = new JLabel("Value4");
		fourthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthTeamValuelbl.setBounds(530, 81, 37, 25);
		add(fourthTeamValuelbl);
			

		JButton fifthTeambtn = new JButton("Team5");
		fifthTeambtn.setBounds(333, 114, 35, 35);
		add(fifthTeambtn);

		JLabel fifthTeamNamelbl = new JLabel("city&name5");
		fifthTeamNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamNamelbl.setBounds(378, 115, 150, 15);
		add(fifthTeamNamelbl);

		JLabel fifthTeamInfolbl = new JLabel("Info5");
		fifthTeamInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamInfolbl.setBounds(378, 131, 150, 15);
		add(fifthTeamInfolbl);

		JLabel fifthTeamValuelbl = new JLabel("Value5");
		fifthTeamValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthTeamValuelbl.setBounds(530, 118, 37, 25);
		add(fifthTeamValuelbl);







	}
}
