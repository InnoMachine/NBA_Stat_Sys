package ui;

import java.util.ArrayList;

import javax.swing.JPanel;

import vo.PlayerVo;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

public class TopFiveCardPanel extends JPanel {

	private ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
	private String criteria;
	String category = "";
	int X;
	int Y;

	public TopFiveCardPanel(String category, ArrayList<PlayerVo> playerVos,
			String criteria) {
		this.X = X;
		this.Y = Y;
		this.category = category;
		this.setVisible(true);
		this.setLayout(null);
		this.setOpaque(false);
		this.playerVos = playerVos;
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

		JButton firstPlayerbtn = new JButton("Player1-action");
		firstPlayerbtn.setBounds(5, 5, 88, 140);
		add(firstPlayerbtn);

		JLabel firstlbl = new JLabel("1");
		firstlbl.setFont(new Font("宋体", Font.PLAIN, 20));
		firstlbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstlbl.setBounds(92, 5, 37, 140);
		add(firstlbl);
		
		JLabel firstPlayerNamelbl = new JLabel("name1");
		firstPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerNamelbl.setBounds(132, 25, 88, 45);
		add(firstPlayerNamelbl);

		JLabel firstPlayerInfolbl = new JLabel("Info1");
		firstPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerInfolbl.setBounds(132, 72, 163, 23);
		add(firstPlayerInfolbl);

		JLabel firstPlayerValuelbl = new JLabel("Value1");
		firstPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		firstPlayerValuelbl.setBounds(132, 98, 65, 47);
		add(firstPlayerValuelbl);

		JButton firstTeambtn = new JButton("Team1");
		firstTeambtn.setBounds(230, 5, 65, 65);
		add(firstTeambtn);
		

		JButton secondPlayerbtn = new JButton("Player2");
		secondPlayerbtn.setBounds(333, 3, 35, 35);
		add(secondPlayerbtn);

		JLabel secondPlayerNamelbl = new JLabel("name2");
		secondPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerNamelbl.setBounds(378, 4, 130, 15);
		add(secondPlayerNamelbl);

		JLabel secondPlayerInfolbl = new JLabel("Info2");
		secondPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerInfolbl.setBounds(378, 20, 130, 15);
		add(secondPlayerInfolbl);
		
		JLabel secondPlayerValuelbl = new JLabel("Value2");
		secondPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		secondPlayerValuelbl.setBounds(510, 7, 37, 25);
		add(secondPlayerValuelbl);

		JButton secondTeambtn = new JButton("Team2");
		secondTeambtn.setBounds(555, 3, 35, 35);
		add(secondTeambtn);

		
		JButton thirdPlayerbtn = new JButton("Player3");
		thirdPlayerbtn.setBounds(333, 40, 35, 35);
		add(thirdPlayerbtn);

		JLabel thirdPlayerNamelbl = new JLabel("name3");
		thirdPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerNamelbl.setBounds(378, 41, 130, 15);
		add(thirdPlayerNamelbl);

		JLabel thirdPlayerInfolbl = new JLabel("Info3");
		thirdPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerInfolbl.setBounds(378, 57, 130, 15);
		add(thirdPlayerInfolbl);

		JLabel thirdPlayerValuelbl = new JLabel("Value3");
		thirdPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		thirdPlayerValuelbl.setBounds(510, 44, 37, 25);
		add(thirdPlayerValuelbl);
		
		JButton thirdTeambtn = new JButton("Team3");
		thirdTeambtn.setBounds(555, 40, 35, 35);
		add(thirdTeambtn);
		

		JButton fourthPlayerbtn = new JButton("Player4");
		fourthPlayerbtn.setBounds(333, 77, 35, 35);
		add(fourthPlayerbtn);
		
		JLabel fourthPlayerNamelbl = new JLabel("name4");
		fourthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerNamelbl.setBounds(378, 78, 130, 15);
		add(fourthPlayerNamelbl);

		JLabel fourthPlayerInfolbl = new JLabel("Info4");
		fourthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerInfolbl.setBounds(378, 94, 130, 15);
		add(fourthPlayerInfolbl);

		JLabel fourthPlayerValuelbl = new JLabel("Value4");
		fourthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fourthPlayerValuelbl.setBounds(510, 81, 37, 25);
		add(fourthPlayerValuelbl);

		JButton fourthTeambtn = new JButton("Team4");
		fourthTeambtn.setBounds(555, 77, 35, 35);
		add(fourthTeambtn);	
			

		JButton fifthPlayerbtn = new JButton("Player5");
		fifthPlayerbtn.setBounds(333, 114, 35, 35);
		add(fifthPlayerbtn);

		JLabel fifthPlayerNamelbl = new JLabel("name5");
		fifthPlayerNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerNamelbl.setBounds(378, 115, 130, 15);
		add(fifthPlayerNamelbl);

		JLabel fifthPlayerInfolbl = new JLabel("Info5");
		fifthPlayerInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerInfolbl.setBounds(378, 131, 130, 15);
		add(fifthPlayerInfolbl);

		JLabel fifthPlayerValuelbl = new JLabel("Value5");
		fifthPlayerValuelbl.setHorizontalAlignment(SwingConstants.CENTER);
		fifthPlayerValuelbl.setBounds(510, 118, 37, 25);
		add(fifthPlayerValuelbl);
		
		JButton fifthTeambtn = new JButton("Team5");
		fifthTeambtn.setBounds(555, 114, 35, 35);
		add(fifthTeambtn);







	}
}