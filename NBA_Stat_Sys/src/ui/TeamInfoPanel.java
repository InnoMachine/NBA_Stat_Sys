package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import businessLogic.Team_BL;
import businessLogic.Team_BL_Stub;
import businessLogic.Team_BS;

public class TeamInfoPanel extends JPanel{
	
	String teamABBR;
	JFrame mainFrame;
	JPanel previousPanel;
	static int X;
	static int Y;
	JLabel bgLabel;
	
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;

	private JTabbedPane JTP;
	
	private DefaultTableModel teamPlayersDTM;
	private DefaultTableModel currentMatchesDTM;
	private DefaultTableModel historicalMatchesDTM;
	private JTable teamPlayersTable;
	private JTable currentMatchesTable;
	private JTable historicalMatchesTable;
	private JScrollPane teamPlayersJSP;
	private JScrollPane currentMatchesJSP;
	private JScrollPane historicalMatchesJSP;
	private Vector<String> teamPlayersColumn;
	private Vector<String> currentMatchesColumn;
	private Vector<String> historicalMatchesColumn;
	private Vector<Vector<String>> teamPlayersData;
	private Vector<Vector<String>> currentMatchesData;
	private Vector<Vector<String>> historicalMatchesData;
	
	private JLabel TeamBadge;

	Team_BS team_BS = new Team_BL_Stub();
	
	public TeamInfoPanel(String abbr,JFrame mainFrame,JPanel previousPanel){
		this.mainFrame=mainFrame;
		this.teamABBR=abbr;
		this.previousPanel=previousPanel;
		previousPanel.setVisible(false);
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		
		JButton close = new JButton();
		ImageIcon closeIcon=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
		close.setBounds(19*X/20,Y/18, X/25,X/25);
		close.setIcon(closeIcon);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
			
		});
		bgLabel.add(close);
		
		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 10 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);
		
		TeamBadge=new JLabel();
		TeamBadge.setOpaque(false);
		TeamBadge.setBounds(X/20, Y/20, X/5, X/5);
		ImageIcon portrait=new ImageIcon(new ImageIcon("CSEdata/teams_png/"+this.teamABBR+".png").getImage().getScaledInstance(TeamBadge.getWidth(), TeamBadge.getHeight(), Image.SCALE_SMOOTH));
		TeamBadge.setIcon(portrait);
		bgLabel.add(TeamBadge);
				
		teamPlayersDTM=new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		teamPlayersTable=new JTable(teamPlayersDTM);
		teamPlayersJSP = new JScrollPane(teamPlayersTable);
		teamPlayersJSP.setVisible(true);
		
		currentMatchesDTM=new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		currentMatchesTable=new JTable(currentMatchesDTM);
		currentMatchesJSP = new JScrollPane(currentMatchesTable);
		currentMatchesJSP.setVisible(true);
		
		historicalMatchesDTM=new DefaultTableModel(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		historicalMatchesTable=new JTable(historicalMatchesDTM);
		historicalMatchesJSP = new JScrollPane(historicalMatchesTable);
		historicalMatchesJSP.setVisible(true);
		
		JTP=new JTabbedPane();
		JTP.addTab("teamPlayers", teamPlayersJSP);
		JTP.addTab("currentMatches", currentMatchesJSP);
		JTP.addTab("historicalMatches",historicalMatchesJSP);
		JTP.setBounds(X/4, Y/3, X/2, Y/3);
		bgLabel.add(JTP);
		
		addBasicInfo();
		addBasicData();
		addTeamPlayersData();
		addCurrentMatchesData();
		addHistoricalMatchesData();
		mainFrame.getContentPane().add(this);
	}
	
	private void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}
	
	private void addBasicData(){
		
	}
	
	private void addTeamPlayersData(){
		teamPlayersColumn=new Vector<String>();
		teamPlayersColumn.add("teamPlayers");
		teamPlayersData=new Vector<Vector<String>>();
		Vector<String> test=new Vector<String>();
		test.add("teamPlayersTest");
		teamPlayersData.add(test);
	}
	
	private void addCurrentMatchesData(){
		currentMatchesColumn=new Vector<String>();
		currentMatchesColumn.add("currentMatches");
		currentMatchesData=new Vector<Vector<String>>();
		Vector<String> test=new Vector<String>();
		test.add("currentMatchesTest");
		currentMatchesData.add(test);
	}
	
	private void addHistoricalMatchesData(){
		historicalMatchesData=new Vector<Vector<String>>();
		historicalMatchesColumn=new Vector<String>();
		historicalMatchesColumn.add("historicalMatches");
		Vector<String> test=new Vector<String>();
		test.add("historicalMatchesTest");
		historicalMatchesData.add(test);
	}
	
	private void addBasicInfo(){
		int tempX = X / 4;
		int tempY = Y / 8;
		int spaceX = X / 12;
		int spaceY = Y / 12;
		
		textField_1 = new MyTextField();
		textField_1.setText("球队全名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("缩写");
		textField_3.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("所在地");
		textField_5.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_5);

		textField_6 = new MyTextField();
		textField_6.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_6);

		textField_7 = new MyTextField();
		textField_7.setText("赛区");
		textField_7.setBounds(tempX+6*spaceX, tempY , spaceX, spaceY);
		bgLabel.add(textField_7);

		textField_8 = new MyTextField();
		textField_8.setBounds(tempX +7* spaceX, tempY , spaceX, spaceY);
		bgLabel.add(textField_8);

		textField_9 = new MyTextField();
		textField_9.setText("分区");
		textField_9.setBounds(tempX , tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_9);

		textField_10 = new MyTextField();
		textField_10.setBounds(tempX + 1 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_10);

		textField_11 = new MyTextField();
		textField_11.setText("主场");
		textField_11.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_11);

		textField_12 = new MyTextField();
		textField_12.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_12);

		textField_13 = new MyTextField();
		textField_13.setText("建立时间");
		textField_13.setBounds(tempX+4*spaceX, tempY +  spaceY, spaceX, spaceY);
		bgLabel.add(textField_13);

		textField_14 = new MyTextField();
		textField_14.setBounds(tempX + 5*spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_14);

		textField_15 = new MyTextField();
		textField_15.setText("比赛场数");
		textField_15.setBounds(tempX + 6 * spaceX, tempY +spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_15);

		textField_16 = new MyTextField();
		textField_16.setBounds(tempX + 7*spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_16);

	}
	
	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setForeground(Color.BLACK);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setColumns(10);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
