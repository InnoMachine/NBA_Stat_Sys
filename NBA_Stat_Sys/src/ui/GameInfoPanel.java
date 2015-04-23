package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ui.GamePanel.GameCardRenderer;
import vo.GameVo;
import vo.PlayerPerformanceInSingleGame;
import vo.PlayerVo;
import vo.TeamPerformanceInSingleGame;
import businessLogic.Game_BL;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class GameInfoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	GameVo gameVo;
	JFrame mainFrame;
	JPanel previousPanel;

	Game_BS game_BS = new Game_BL_Stub();

	static int X;
	static int Y;

	JLabel bgLabel;
	private JButton guestTeambtn;
	private JButton hostTeambtn;
	private JTextField txtGTPoint;
	private JTextField txtHTPoint;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField guestTeamtF;
	private JTextField guestTeam1;
	private JTextField guestTeam2;
	private JTextField guestTeam3;
	private JTextField guestTeam4;
	private JTextField guestScoreSum;
	private JTextField txtState;
	private JTextField hostTeamtF;
	private JTextField hostScore1;
	private JTextField hostScore2;
	private JTextField hostScore3;
	private JTextField hostScore4;
	private JTextField hostScoreSum;
	private JLabel courtlbl;
	private JButton btnG1;
	private JButton btnG2;
	private JButton btnG3;
	private JButton btnG4;
	private JButton btnG5;
	private JButton btnH1;
	private JButton btnH2;
	private JButton btnH3;
	private JButton btnH4;
	private JButton btnH5;
	private JTextField textField_6;
	private JTextField txtGt;
	private JTextField txtHt;
	private JTextField FGtF;
	private JTextField FTtF;
	private JTextField ThreePtF;
	private JTextField ASTtF;
	private JTextField REBtF;
	private JTextField TOtF;
	private JTextField txtGTfg;
	private JTextField txtHTfg;
	private JTextField txtGTft;
	private JTextField txtHTft;
	private JTextField txtGT3p;
	private JTextField txtHT3p;
	private JTextField txtGTast;
	private JTextField txtHTast;
	private JTextField txtGTreb;
	private JTextField txtHTreb;
	private JTextField txtGTto;
	private JTextField txtHTto;

	private JLabel summarylbl;
	JLabel gameInfolbl;
	private JLabel leadinglbl;
	private JTextField txtGuestTeam;
	private JTextField txtHostTeam;
	private JTextField txtGTscorefirst;
	private JTextField txtGTscore;
	private JTextField txtScore;
	private JTextField txtHTscore;
	private JTextField txtHTscorefirst;
	private JTextField txtGTreboundfirst;
	private JTextField txtGTrebound;
	private JTextField txtRebound;
	private JTextField txtHTrebound;
	private JTextField txtHTreboundfirst;
	private JTextField txtGTassistancefirst;
	private JTextField txtGTassistance;
	private JTextField txtAssistance;
	private JTextField txtHTassistance;
	private JTextField txtHTassistancefirst;
	private JTextField txtGTblockfirst;
	private JTextField txtGTblock;
	private JTextField txtBlock;
	private JTextField txtHTblock;
	private JTextField txtHTblockfirst;

	private JLabel datalbl;
	private JLabel guestTeamDatalbl;
	private JLabel hostTeamDatalbl;
	private String[] guestCriterias;
	private String[] hostCriterias;
	JComboBox<String> guestCriteriajcb;
	JComboBox<String> hostCriteriajcb;

	Vector<Vector<String>> guestRowData;
	Vector<String> guestColumn;
	private JTable guestTable;
	private JScrollPane guestScrollPane;
	Vector<Vector<String>> hostRowData;
	Vector<String> hostColumn;
	private JTable hostTable;
	private JScrollPane hostScrollPane;

	public GameInfoPanel(GameVo gameVo, JFrame mainFrame, JPanel previousPanel) {
		previousPanel.setVisible(false);
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		this.gameVo = gameVo;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
	 this.setBounds(0, 0, X, Y);
		
	 
		System.out.println(X+"   "+Y);
	 
	 
	 
		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 15 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);

		JButton back = new JButton();
		back.setForeground(Color.WHITE);
	
		ImageIcon backIcon = new ImageIcon(new
		ImageIcon("Image/backIcon.png") .getImage().getScaledInstance(X / 25,
		X / 25, Image.SCALE_SMOOTH));
		
		back.setBounds(17 * X / 20, Y * 15 / 768, X / 25, X / 25);
		back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		bgLabel.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 15/ 768, X / 25, X / 25);
		minimize.setIcon(minimizeIcon);
		minimize.setOpaque(false);
		minimize.setContentAreaFilled(false);
		minimize.setBorderPainted(false);
		minimize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});

		bgLabel.add(minimize);

		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		close.setBounds(19 * X / 20, Y * 15 / 768, X / 25, X / 25);
		close.setIcon(closeIcon);
		close.setOpaque(false);
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainFrame.dispose();
			}
		});
		bgLabel.add(close);

		JButton fresh = new JButton();
		ImageIcon freshIcon = new ImageIcon(new ImageIcon("Image/freshIcon.png")
				.getImage().getScaledInstance(X / 40, X / 40,
						Image.SCALE_SMOOTH));
		fresh.setBounds( X*930 / 1366, Y * 150 / 768, X / 40, X / 40);
		fresh.setIcon(freshIcon);
		fresh.setOpaque(false);
		fresh.setContentAreaFilled(false);
		fresh.setBorderPainted(false);
		fresh.addActionListener(e -> fresh());
		bgLabel.add(fresh);
		
		
		mainFrame.getContentPane().add(this);

		guestTeambtn = new JButton();
		guestTeambtn.setHorizontalAlignment(SwingConstants.CENTER);
		
		guestTeambtn.setBounds(X*250/1366, Y*60/768, X*150/1366, Y*150/768);
		ImageIcon teamImg1 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getGuestTeam() + ".png").getImage()
				.getScaledInstance(X * 150 / 1366, Y * 150 / 768,
						Image.SCALE_AREA_AVERAGING));
		guestTeambtn.setIcon(teamImg1);
		guestTeambtn.setContentAreaFilled(false);
		guestTeambtn.setBorderPainted(false);
		guestTeambtn.setOpaque(false);
		guestTeambtn.addActionListener(e->{
			this.setVisible(false);
			TeamInfoPanel a = new TeamInfoPanel(gameVo.getGuestTeam(), mainFrame,this);
		});
		bgLabel.add(guestTeambtn);

		hostTeambtn = new JButton();
		hostTeambtn.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeambtn.setText(gameVo.getHomeTeam());
		hostTeambtn.setBounds(X*950/1366, Y*60/768,X*150/1366,Y*150/768);
		ImageIcon teamImg2 = new ImageIcon(new ImageIcon("CSEdata/teams_png/"
				+ gameVo.getHomeTeam() + ".png").getImage()
				.getScaledInstance(X * 150 / 1366, Y * 150 / 768,
						Image.SCALE_AREA_AVERAGING));
		hostTeambtn.setIcon(teamImg2);
		hostTeambtn.setContentAreaFilled(false);
		hostTeambtn.setBorderPainted(false);
		hostTeambtn.setOpaque(false);
		hostTeambtn.addActionListener(e->{
			this.setVisible(false);
			TeamInfoPanel a = new TeamInfoPanel(gameVo.getHomeTeam(), mainFrame,this);
		});
		bgLabel.add(hostTeambtn);

		txtGTPoint = new MyTextField();
		txtGTPoint.setText(String.valueOf(gameVo.getGuestTP().getScore()));
		txtGTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTPoint.setBounds(X*449/1366, Y*67/768, X*100/1366, Y*60/768);
		txtGTPoint.setFont(new Font("微软雅黑",1,30));
		bgLabel.add(txtGTPoint);
		txtGTPoint.setColumns(X*10/1366);

		txtHTPoint = new MyTextField();
		txtHTPoint.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTPoint.setText(String.valueOf(gameVo.getHomeTP().getScore()));
		txtHTPoint.setBounds(X*816/1366, Y*67/768, X*100/1366, Y*60/768);
		txtHTPoint.setFont(new Font("微软雅黑",1,30));
		bgLabel.add(txtHTPoint);
		txtHTPoint.setColumns(X*10/1366);

		txtState = new MyTextField();
		txtState.setText("结束");
		txtState.setHorizontalAlignment(SwingConstants.CENTER);
		txtState.setBounds(X*651/1366, Y*20/768, X*66/1366, Y*25/768);
		bgLabel.add(txtState);
		txtState.setColumns(X*10/1366);

		textField = new MyTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("球队");
		textField.setBounds(X*596/1366, Y*60/768, X*55/1366, Y*20/768);
		bgLabel.add(textField);
		textField.setColumns(X*10/1366);

		textField_1 = new MyTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText("1");
		textField_1.setBounds(X*651/1366, Y*60/768, X*21/1366, Y*20/768);
		bgLabel.add(textField_1);
		textField_1.setColumns(X*10/1366);

		textField_2 = new MyTextField();
		textField_2.setText("2");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(X*10/1366);
		textField_2.setBounds(X*672/1366,Y*60/768,X*21/1366,Y*20/768);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("3");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(X*10/1366);
		textField_3.setBounds(X*693/1366,Y*60/768,X*21/1366,Y*20/768);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setText("4");
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setColumns(X*10/1366);
		textField_4.setBounds(X*714/1366,Y*60/768,X*21/1366,Y*20/768);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("总分");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setColumns(X*10/1366);
		textField_5.setBounds(X*735/1366, Y*60/768, X*35/1366,Y*20/768);
		bgLabel.add(textField_5);

		guestTeamtF = new MyTextField();
		guestTeamtF.setText(gameVo.getGuestTeam());
		guestTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamtF.setColumns(X*10/1366);
		guestTeamtF.setBounds(X*596/1366, Y*80/768, X*55/1366,Y*20/768);
		bgLabel.add(guestTeamtF);

		guestTeam1 = new MyTextField();
		guestTeam1.setText(String.valueOf(gameVo.getScore1st().getGuestScore()));
		guestTeam1.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam1.setColumns(X*10/1366);
		guestTeam1.setBounds(X*651/1366, Y*80/768,X*21/1366,Y*20/768);
		bgLabel.add(guestTeam1);

		guestTeam2 = new MyTextField();
		guestTeam2.setText(String.valueOf(gameVo.getScore2nd().getGuestScore()));
		guestTeam2.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam2.setColumns(X*10/1366);
		guestTeam2.setBounds(X*672/1366, Y*80/768,X*21/1366,Y*20/768);
		bgLabel.add(guestTeam2);

		guestTeam3 = new MyTextField();
		guestTeam3.setText(String.valueOf(gameVo.getScore3rd().getGuestScore()));
		guestTeam3.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam3.setColumns(X*10/1366);
		guestTeam3.setBounds(X*693/1366, Y*80/768,X*21/1366,Y*20/768);
		bgLabel.add(guestTeam3);

		guestTeam4 = new MyTextField();
		guestTeam4.setText(String.valueOf(gameVo.getScore4th().getGuestScore()));
		guestTeam4.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeam4.setColumns(X*10/1366);
		guestTeam4.setBounds(X*714/1366, Y*80/768,X*21/1366,Y*20/768);
		bgLabel.add(guestTeam4);

		guestScoreSum = new MyTextField();
		guestScoreSum.setText(String.valueOf(gameVo.getScoreOverall().getGuestScore()));
		guestScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		guestScoreSum.setColumns(X*10/1366);
		guestScoreSum.setBounds(X*735/1366, Y*80/768, X*35/1366,Y*20/768);
		bgLabel.add(guestScoreSum);

		hostTeamtF = new MyTextField();
		hostTeamtF.setText(gameVo.getHomeTeam());
		hostTeamtF.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamtF.setColumns(X*10/1366);
		hostTeamtF.setBounds(X*596/1366, Y*100/768, X*55/1366,Y*20/768);
		bgLabel.add(hostTeamtF);

		hostScore1 = new MyTextField();
		hostScore1.setText(String.valueOf(gameVo.getScore1st().getHomeScore()));
		hostScore1.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore1.setColumns(X*10/1366);
		hostScore1.setBounds(X*651/1366, Y*100/768,X*21/1366,Y*20/768);
		bgLabel.add(hostScore1);

		hostScore2 = new MyTextField();
		hostScore2.setText(String.valueOf(gameVo.getScore2nd().getHomeScore()));
		hostScore2.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore2.setColumns(X*10/1366);
		hostScore2.setBounds(X*672/1366, Y*100/768,X*21/1366,Y*20/768);
		bgLabel.add(hostScore2);

		hostScore3 = new MyTextField();
		hostScore3.setText(String.valueOf(gameVo.getScore3rd().getHomeScore()));
		hostScore3.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore3.setColumns(X*10/1366);
		hostScore3.setBounds(X*693/1366, Y*100/768,X*21/1366,Y*20/768);
		bgLabel.add(hostScore3);

		hostScore4 = new MyTextField();
		hostScore4.setText(String.valueOf(gameVo.getScore4th().getHomeScore()));
		hostScore4.setHorizontalAlignment(SwingConstants.CENTER);
		hostScore4.setColumns(X*10/1366);
		hostScore4.setBounds(X*714/1366, Y*100/768,X*21/1366,Y*20/768);
		bgLabel.add(hostScore4);

		hostScoreSum = new MyTextField();
		hostScoreSum.setText(String.valueOf(gameVo.getScoreOverall().getHomeScore()));
		hostScoreSum.setHorizontalAlignment(SwingConstants.CENTER);
		hostScoreSum.setColumns(X*10/1366);
		hostScoreSum.setBounds(X*735/1366, Y*100/768, X*35/1366,Y*20/768);
		bgLabel.add(hostScoreSum);

		JButton startingbtn = new MyButton("首发");
		startingbtn.setBounds(X*450/1366, Y*155/768,X*155/1366,Y*23/768);
		startingbtn.addActionListener(e -> starting());
		bgLabel.add(startingbtn);

		JButton summarybtn = new MyButton("赛后总结");
		summarybtn.setBounds(X*605/1366, Y*155/768,X*155/1366,Y*23/768);
		summarybtn.addActionListener(e -> summary());
		bgLabel.add(summarybtn);

		JButton databtn = new MyButton("数据");
		databtn.setBounds(X*760/1366, Y*155/768,X*155/1366,Y*23/768);
		databtn.addActionListener(e -> showData());
		bgLabel.add(databtn);

		starting();

		mainFrame.getContentPane().add(this);
	}

	public void starting() {
		ArrayList<PlayerPerformanceInSingleGame> guestFirstPlayerList=new ArrayList<PlayerPerformanceInSingleGame>();
		guestFirstPlayerList=(gameVo.getGuestTP()).getFirstonList();
		ArrayList<PlayerPerformanceInSingleGame> hostFirstPlayerList=new ArrayList<PlayerPerformanceInSingleGame>();
		hostFirstPlayerList=(gameVo.getHomeTP()).getFirstonList();
		
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		courtlbl = new MyLabel();
		courtlbl.setHorizontalAlignment(SwingConstants.CENTER);
		courtlbl.setBounds(X*131/1366, Y*194/768, X*1100/1366, Y*500/768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
				"CSEdata/court_png/"+gameVo.getHomeTeam()+"_court.png").getImage().getScaledInstance(  X*1100/1366, Y*500/768,
						 Image.SCALE_SMOOTH));
		
		courtlbl.setIcon(buttonIcon);
		courtlbl.setBackground(Color.blue);

		btnG1 = new MyButton();
		btnG1.setBounds(X*390/1366, Y*215/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitG1 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ guestFirstPlayerList.get(0).getName() + ".png").getImage().getScaledInstance(X * 80/ 1366,
						Y * 80 / 768, Image.SCALE_AREA_AVERAGING));
		btnG1.setOpaque(false);
		btnG1.setIcon(playerPortraitG1);
		courtlbl.add(btnG1);

		btnG2 = new MyButton();
		btnG2.setBounds(X*310/1366, Y*80/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitG2 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ guestFirstPlayerList.get(1).getName() + ".png").getImage().getScaledInstance(X * 80/ 1366,
						Y * 70/ 768, Image.SCALE_AREA_AVERAGING));
		btnG2.setIcon(playerPortraitG2);
		btnG2.setOpaque(false);
		courtlbl.add(btnG2);

		btnG3 = new MyButton();
		btnG3.setBounds(X*150/1366, Y*350/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitG3 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ guestFirstPlayerList.get(2).getName() + ".png").getImage().getScaledInstance(X *80 / 1366,
						Y * 80/ 768, Image.SCALE_AREA_AVERAGING));
		btnG3.setIcon(playerPortraitG3);
		btnG3.setOpaque(false);
		courtlbl.add(btnG3);

		btnG4 = new MyButton();
		btnG4.setBounds(X*180/1366, Y*173/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitG4 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ guestFirstPlayerList.get(3).getName() + ".png").getImage().getScaledInstance(X * 80/ 1366,
						Y * 80/ 768, Image.SCALE_AREA_AVERAGING));
		btnG4.setIcon(playerPortraitG4);
		btnG4.setOpaque(false);
		courtlbl.add(btnG4);

		btnG5 = new MyButton();
		btnG5.setBounds(X*290/1366, Y*320/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitG5 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ guestFirstPlayerList.get(4).getName() + ".png").getImage().getScaledInstance(X * 80/ 1366,
						Y * 80 / 768, Image.SCALE_AREA_AVERAGING));
		btnG5.setIcon(playerPortraitG5);
		btnG5.setOpaque(false);
		courtlbl.add(btnG5);

		btnH1 = new MyButton();
		btnH1.setBounds(X*590/1366, Y*215/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitH1 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ hostFirstPlayerList.get(0).getName() + ".png").getImage().getScaledInstance(X *80/ 1366,
						Y * 80 / 768, Image.SCALE_AREA_AVERAGING));
		btnH1.setIcon(playerPortraitH1);
		btnH1.setOpaque(false);
		courtlbl.add(btnH1);

		btnH2 = new MyButton();
		btnH2.setBounds(X*700/1366, Y*350/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitH2 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ hostFirstPlayerList.get(1).getName() + ".png").getImage().getScaledInstance(X * 80 / 1366,
						Y * 80/ 768, Image.SCALE_AREA_AVERAGING));
		btnH2.setIcon(playerPortraitH2);
		btnH2.setOpaque(false);
		courtlbl.add(btnH2);

		btnH3 = new MyButton();
		btnH3.setBounds(X*800/1366, Y*80/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitH3 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ hostFirstPlayerList.get(2).getName() + ".png").getImage().getScaledInstance(X * 80 / 1366,
						Y * 70/ 768, Image.SCALE_AREA_AVERAGING));
		btnH3.setIcon(playerPortraitH3);
		btnH3.addActionListener(e->{System.out.println("click H3!!!");});
		btnH3.setOpaque(false);
		courtlbl.add(btnH3);

		btnH4 = new MyButton();
		btnH4.setBounds(X*820/1366, Y*257/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitH4 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ hostFirstPlayerList.get(3).getName() + ".png").getImage().getScaledInstance(X *80/ 1366,
						Y * 80/ 768, Image.SCALE_AREA_AVERAGING));
		btnH4.setIcon(playerPortraitH4);
		btnH4.setOpaque(false);
		courtlbl.add(btnH4);

		btnH5 = new MyButton();
		btnH5.setBounds(X*650/1366, Y*105/768, X*80/1366,Y*80/768);
		ImageIcon playerPortraitH5 = new ImageIcon(new ImageIcon("CSEdata/players/portrait/"
				+ hostFirstPlayerList.get(4).getName() + ".png").getImage().getScaledInstance(X * 80 / 1366,
						Y * 80/ 768, Image.SCALE_AREA_AVERAGING));
		btnH5.setIcon(playerPortraitH5);
		btnH5.setOpaque(false);
		courtlbl.add(btnH5);

		bgLabel.add(courtlbl);

	}

	public void summary() {
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		summarylbl = new MyLabel();
		summarylbl.setHorizontalAlignment(SwingConstants.CENTER);
		summarylbl.setBounds(X*131/1366, Y*194/768, X*1100/1366, Y*500/768);
		summarylbl.setBackground(Color.blue);

		gameInfolbl = new MyLabel("比赛概览");
		gameInfolbl.setHorizontalAlignment(SwingConstants.CENTER);
		gameInfolbl.setFont(new Font("微软雅黑",1,20));
		gameInfolbl.setBounds(X*97/1366, Y*30/768, X*100/1366,Y*30/768);
		summarylbl.add(gameInfolbl);

		textField_6 = new MyTextField();
		textField_6.setEditable(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBounds(X*97/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(textField_6);
		textField_6.setColumns(X*10/1366);

		txtGt = new MyTextField();
		txtGt.setEditable(false);
		txtGt.setText(gameVo.getGuestTeam());
		txtGt.setHorizontalAlignment(SwingConstants.CENTER);
		txtGt.setColumns(X*10/1366);
		txtGt.setBounds(X*97/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGt);

		txtHt = new MyTextField();
		txtHt.setEditable(false);
		txtHt.setText(gameVo.getHomeTeam());
		txtHt.setHorizontalAlignment(SwingConstants.CENTER);
		txtHt.setColumns(X*10/1366);
		txtHt.setBounds(X*97/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHt);

		FGtF = new MyTextField();
		FGtF.setText("投篮命中率");
		FGtF.setEditable(false);
		FGtF.setHorizontalAlignment(SwingConstants.CENTER);
		FGtF.setColumns(X*10/1366);
		FGtF.setBounds(227, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(FGtF);

		FTtF = new MyTextField();
		FTtF.setText("罚球命中率");
		FTtF.setEditable(false);
		FTtF.setHorizontalAlignment(SwingConstants.CENTER);
		FTtF.setColumns(X*10/1366);
		FTtF.setBounds(X*357/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(FTtF);

		ThreePtF = new MyTextField();
		ThreePtF.setText("三分命中率");
		ThreePtF.setEditable(false);
		ThreePtF.setHorizontalAlignment(SwingConstants.CENTER);
		ThreePtF.setColumns(X*10/1366);
		ThreePtF.setBounds(X*487/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(ThreePtF);

		ASTtF = new MyTextField();
		ASTtF.setText("助攻");
		ASTtF.setEditable(false);
		ASTtF.setHorizontalAlignment(SwingConstants.CENTER);
		ASTtF.setColumns(X*10/1366);
		ASTtF.setBounds(X*617/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(ASTtF);

		REBtF = new MyTextField();
		REBtF.setText("篮板");
		REBtF.setEditable(false);
		REBtF.setHorizontalAlignment(SwingConstants.CENTER);
		REBtF.setColumns(X*10/1366);
		REBtF.setBounds(X*747/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(REBtF);

		TOtF = new MyTextField();
		TOtF.setText("失误");
		TOtF.setEditable(false);
		TOtF.setHorizontalAlignment(SwingConstants.CENTER);
		TOtF.setColumns(X*10/1366);
		TOtF.setBounds(X*877/1366, Y*70/768, X*130/1366,Y*40/768);
		summarylbl.add(TOtF);

		txtGTfg = new MyTextField();
		txtGTfg.setText(String.valueOf(gameVo.getGuestTP().getHitRate()));
		txtGTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTfg.setEditable(false);
		txtGTfg.setColumns(X*10/1366);
		txtGTfg.setBounds(X*227/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTfg);

		txtHTfg = new MyTextField();
		txtHTfg.setText(String.valueOf(gameVo.getHomeTP().getHitRate()));
		txtHTfg.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTfg.setEditable(false);
		txtHTfg.setColumns(X*10/1366);
		txtHTfg.setBounds(X*227/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTfg);

		txtGTft = new MyTextField();
		txtGTft.setText(String.valueOf(gameVo.getGuestTP().getFreeThrowRate()));
		txtGTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTft.setEditable(false);
		txtGTft.setColumns(X*10/1366);
		txtGTft.setBounds(X*357/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTft);

		txtHTft = new MyTextField();
		txtHTft.setText(String.valueOf(gameVo.getHomeTP().getFreeThrowRate()));
		txtHTft.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTft.setEditable(false);
		txtHTft.setColumns(X*10/1366);
		txtHTft.setBounds(X*357/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTft);

		txtGT3p = new MyTextField();
		txtGT3p.setText(String.valueOf(gameVo.getGuestTP().getThreePointHitRate()));
		txtGT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtGT3p.setEditable(false);
		txtGT3p.setColumns(X*10/1366);
		txtGT3p.setBounds(X*487/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGT3p);

		txtHT3p = new MyTextField();
		txtHT3p.setText(String.valueOf(gameVo.getHomeTP().getThreePointHitRate()));
		txtHT3p.setHorizontalAlignment(SwingConstants.CENTER);
		txtHT3p.setEditable(false);
		txtHT3p.setColumns(X*10/1366);
		txtHT3p.setBounds(X*487/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHT3p);

		txtGTast = new MyTextField();
		txtGTast.setText(String.valueOf(gameVo.getGuestTP().getAssistance()));
		txtGTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTast.setEditable(false);
		txtGTast.setColumns(X*10/1366);
		txtGTast.setBounds(X*617/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTast);

		txtHTast = new MyTextField();
		txtHTast.setText(String.valueOf(gameVo.getHomeTP().getAssistance()));
		txtHTast.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTast.setEditable(false);
		txtHTast.setColumns(X*10/1366);
		txtHTast.setBounds(X*617/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTast);

		txtGTreb = new MyTextField();
		txtGTreb.setText(String.valueOf(gameVo.getGuestTP().getReboundOverall()));
		txtGTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreb.setEditable(false);
		txtGTreb.setColumns(X*10/1366);
		txtGTreb.setBounds(X*747/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTreb);

		txtHTreb = new MyTextField();
		txtHTreb.setText(String.valueOf(gameVo.getHomeTP().getReboundOverall()));
		txtHTreb.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreb.setEditable(false);
		txtHTreb.setColumns(X*10/1366);
		txtHTreb.setBounds(X*747/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTreb);

		txtGTto = new MyTextField();
		txtGTto.setText(String.valueOf(gameVo.getGuestTP().getTurnover()));
		txtGTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTto.setEditable(false);
		txtGTto.setColumns(X*10/1366);
		txtGTto.setBounds(X*877/1366, Y*110/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTto);

		txtHTto = new MyTextField();
		txtHTto.setText(String.valueOf(gameVo.getHomeTP().getTurnover()));
		txtHTto.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTto.setEditable(false);
		txtHTto.setColumns(X*10/1366);
		txtHTto.setBounds(X*877/1366, Y*150/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTto);

		leadinglbl = new MyLabel("数据领跑者");
		leadinglbl.setFont(new Font("微软雅黑",1,20));
		leadinglbl.setBounds(X*97/1366, Y*210/768, X*200/1366, Y*30/768);
		summarylbl.add(leadinglbl);

		txtGuestTeam = new MyTextField();
		txtGuestTeam.setEditable(false);
		txtGuestTeam.setText(gameVo.getGuestTeam());
		txtGuestTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtGuestTeam.setBounds(X*97/1366, Y*250/768, X*455/1366,Y*40/768);
		summarylbl.add(txtGuestTeam);
		txtGuestTeam.setColumns(X*10/1366);

		txtHostTeam = new MyTextField();
		txtHostTeam.setEditable(false);
		txtHostTeam.setText(gameVo.getHomeTeam());
		txtHostTeam.setHorizontalAlignment(SwingConstants.CENTER);
		txtHostTeam.setColumns(X*10/1366);
		txtHostTeam.setBounds(552, 250, X*455/1366,Y*40/768);
		summarylbl.add(txtHostTeam);

		txtGTscorefirst = new MyTextField();
		txtGTscorefirst.setText(gameVo.getGuestTP().getHighestScorePlayer());
		txtGTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscorefirst.setEditable(false);
		txtGTscorefirst.setColumns(X*10/1366);
		txtGTscorefirst.setBounds(X*97/1366, Y*290/768, X*260/1366,Y*40/768);
		summarylbl.add(txtGTscorefirst);

		txtGTscore = new MyTextField();
		txtGTscore.setText(String.valueOf(gameVo.getGuestTP().getHighestScore()));
		txtGTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTscore.setEditable(false);
		txtGTscore.setColumns(X*10/1366);
		txtGTscore.setBounds(X*357/1366, Y*290/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTscore);

		txtScore = new MyTextField();
		txtScore.setText("得分");
		txtScore.setHorizontalAlignment(SwingConstants.CENTER);
		txtScore.setEditable(false);
		txtScore.setColumns(X*10/1366);
		txtScore.setBounds(X*487/1366, Y*290/768, X*130/1366,Y*40/768);
		summarylbl.add(txtScore);

		txtHTscore = new MyTextField();
		txtHTscore.setText(String.valueOf(gameVo.getHomeTP().getHighestScore()));
		txtHTscore.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscore.setEditable(false);
		txtHTscore.setColumns(X*10/1366);
		txtHTscore.setBounds(X*617/1366, Y*290/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTscore);

		txtHTscorefirst = new MyTextField();
		txtHTscorefirst.setText(gameVo.getHomeTP().getHighestScorePlayer());
		txtHTscorefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTscorefirst.setEditable(false);
		txtHTscorefirst.setColumns(X*10/1366);
		txtHTscorefirst.setBounds(X*747/1366, Y*290/768, X*260/1366,Y*40/768);
		summarylbl.add(txtHTscorefirst);

		txtGTreboundfirst = new MyTextField();
		txtGTreboundfirst.setText(gameVo.getGuestTP().getHighestReboundPlayer());
		txtGTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTreboundfirst.setEditable(false);
		txtGTreboundfirst.setColumns(X*10/1366);
		txtGTreboundfirst.setBounds(X*97/1366, Y*330/768, X*260/1366,Y*40/768);
		summarylbl.add(txtGTreboundfirst);

		txtGTrebound = new MyTextField();
		txtGTrebound.setText(String.valueOf(gameVo.getGuestTP().getHighestRebound()));
		txtGTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTrebound.setEditable(false);
		txtGTrebound.setColumns(X*10/1366);
		txtGTrebound.setBounds(X*357/1366, Y*330/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTrebound);

		txtRebound = new MyTextField();
		txtRebound.setText("篮板");
		txtRebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtRebound.setEditable(false);
		txtRebound.setColumns(X*10/1366);
		txtRebound.setBounds(X*487/1366, Y*330/768, X*130/1366,Y*40/768);
		summarylbl.add(txtRebound);

		txtHTrebound = new MyTextField();
		txtHTrebound.setText(String.valueOf(gameVo.getHomeTP().getHighestRebound()));
		txtHTrebound.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTrebound.setEditable(false);
		txtHTrebound.setColumns(X*10/1366);
		txtHTrebound.setBounds(X*617/1366, Y*330/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTrebound);

		txtHTreboundfirst = new MyTextField();
		txtHTreboundfirst.setText(gameVo.getHomeTP().getHighestReboundPlayer());
		txtHTreboundfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTreboundfirst.setEditable(false);
		txtHTreboundfirst.setColumns(X*10/1366);
		txtHTreboundfirst.setBounds(X*747/1366, Y*330/768, X*260/1366,Y*40/768);
		summarylbl.add(txtHTreboundfirst);

		txtGTassistancefirst = new MyTextField();
		txtGTassistancefirst.setText(gameVo.getGuestTP().getHighestassistPlayer());
		txtGTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistancefirst.setEditable(false);
		txtGTassistancefirst.setColumns(X*10/1366);
		txtGTassistancefirst.setBounds(X*97/1366, Y*370/768, X*260/1366,Y*40/768);
		summarylbl.add(txtGTassistancefirst);

		txtGTassistance = new MyTextField();
		txtGTassistance.setText(String.valueOf(gameVo.getGuestTP().getHighestassist()));
		txtGTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTassistance.setEditable(false);
		txtGTassistance.setColumns(X*10/1366);
		txtGTassistance.setBounds(X*357/1366, Y*370/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTassistance);

		txtAssistance = new MyTextField();
		txtAssistance.setText("助攻");
		txtAssistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtAssistance.setEditable(false);
		txtAssistance.setColumns(X*10/1366);
		txtAssistance.setBounds(X*487/1366, Y*370/768, X*130/1366,Y*40/768);
		summarylbl.add(txtAssistance);

		txtHTassistance = new MyTextField();
		txtHTassistance.setText(String.valueOf(gameVo.getHomeTP().getHighestassist()));
		txtHTassistance.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistance.setEditable(false);
		txtHTassistance.setColumns(X*10/1366);
		txtHTassistance.setBounds(X*617/1366, Y*370/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTassistance);

		txtHTassistancefirst = new MyTextField();
		txtHTassistancefirst.setText(gameVo.getHomeTP().getHighestassistPlayer());
		txtHTassistancefirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTassistancefirst.setEditable(false);
		txtHTassistancefirst.setColumns(X*10/1366);
		txtHTassistancefirst.setBounds(X*747/1366, Y*370/768, X*260/1366,Y*40/768);
		summarylbl.add(txtHTassistancefirst);

		txtGTblockfirst = new MyTextField();
		txtGTblockfirst.setText(gameVo.getGuestTP().getHighestblockPlayer());
		txtGTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblockfirst.setEditable(false);
		txtGTblockfirst.setColumns(X*10/1366);
		txtGTblockfirst.setBounds(X*97/1366,Y*410/768, X*260/1366,Y*40/768);
		summarylbl.add(txtGTblockfirst);

		txtGTblock = new MyTextField();
		txtGTblock.setText(String.valueOf(gameVo.getHomeTP().getHighestblock()));
		txtGTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtGTblock.setEditable(false);
		txtGTblock.setColumns(X*10/1366);
		txtGTblock.setBounds(X*357/1366,Y*410/768, X*130/1366,Y*40/768);
		summarylbl.add(txtGTblock);

		txtBlock = new MyTextField();
		txtBlock.setText("盖帽");
		txtBlock.setHorizontalAlignment(SwingConstants.CENTER);
		txtBlock.setEditable(false);
		txtBlock.setColumns(X*10/1366);
		txtBlock.setBounds(X*487/1366,Y*410/768, X*130/1366,Y*40/768);
		summarylbl.add(txtBlock);

		txtHTblock = new MyTextField();
		txtHTblock.setText(String.valueOf(gameVo.getHomeTP().getHighestblock()));
		txtHTblock.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblock.setEditable(false);
		txtHTblock.setColumns(X*10/1366);
		txtHTblock.setBounds(X*617/1366,Y*410/768, X*130/1366,Y*40/768);
		summarylbl.add(txtHTblock);

		txtHTblockfirst = new MyTextField();
		txtHTblockfirst.setText(gameVo.getHomeTP().getHighestblockPlayer());
		txtHTblockfirst.setHorizontalAlignment(SwingConstants.CENTER);
		txtHTblockfirst.setEditable(false);
		txtHTblockfirst.setColumns(X*10/1366);
		txtHTblockfirst.setBounds(X*747/1366,Y*410/768, X*260/1366,Y*40/768);
		summarylbl.add(txtHTblockfirst);

		bgLabel.add(summarylbl);
	}

	public void showData() {
		if (courtlbl != null) {
			courtlbl.setVisible(false);
		}
		if (summarylbl != null) {
			summarylbl.setVisible(false);
		}
		if (datalbl != null) {
			datalbl.setVisible(false);
		}

		datalbl = new JLabel();
		datalbl.setHorizontalAlignment(SwingConstants.CENTER);
		datalbl.setBounds(131, 194, 1100, 500);
		datalbl.setBackground(Color.blue);

		guestTeamDatalbl = new JLabel();
		guestTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		guestTeamDatalbl.setBounds(0, 0, 550, 100);
		guestTeamDatalbl.setBackground(Color.blue);
		datalbl.add(guestTeamDatalbl);

		guestCriterias = new String[4];
		guestCriterias[0] = "BASIC";
		guestCriterias[1] = "SHOOTING";
		guestCriterias[2] = "REBOUNDS";
		guestCriterias[3] = "X-FACTOR";
		guestCriteriajcb = new JComboBox<String>(guestCriterias);

		guestCriteriajcb.setBounds(400, 50, 100, 30);
		guestCriteriajcb.setForeground(Color.WHITE);
		guestCriteriajcb.setBackground(Color.GRAY);
		guestCriteriajcb
				.addItemListener(e -> guestCriteriaSelected(guestCriteriajcb
						.getSelectedItem().toString()));
		guestTeamDatalbl.add(guestCriteriajcb);

		hostTeamDatalbl = new JLabel();
		hostTeamDatalbl.setHorizontalAlignment(SwingConstants.CENTER);
		hostTeamDatalbl.setBounds(550, 0, 550, 100);
		hostTeamDatalbl.setBackground(Color.blue);
		datalbl.add(hostTeamDatalbl);

		hostCriterias = new String[4];
		hostCriterias[0] = "BASIC";
		hostCriterias[1] = "SHOOTING";
		hostCriterias[2] = "REBOUNDS";
		hostCriterias[3] = "X-FACTOR";
		hostCriteriajcb = new JComboBox<String>(hostCriterias);

		hostCriteriajcb.setBounds(400, 50, 100, 30);
		hostCriteriajcb.setForeground(Color.WHITE);
		hostCriteriajcb.setBackground(Color.GRAY);
		hostCriteriajcb
				.addItemListener(e -> hostCriteriaSelected(hostCriteriajcb
						.getSelectedItem().toString()));
		hostTeamDatalbl.add(hostCriteriajcb);

		ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
				.getGuestTP();
		guestPlayerVos = guestTeamPerformanceInSingleGame.getPlayerList();
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		guestColumn = new Vector<String>();
		guestColumn.add("球员");
		guestColumn.add("姓名");
		guestColumn.add("号码");
		guestColumn.add("分钟");
		guestColumn.add("得分");
		guestColumn.add("助攻");
		guestColumn.add("个人犯规");
		for (int i = 0; i < guestPlayerVos.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add(String.valueOf(guestPlayerVos.get(i).getName()));
			a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
			a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
			a.add(String.valueOf(guestPlayerVos.get(i).getScore()));
			a.add(String.valueOf(guestPlayerVos.get(i).getAssistance()));
			a.add(String.valueOf(guestPlayerVos.get(i).getFoul()));
			guestRowData.add(a);
		}
		if (guestTable != null) {
			guestTable.setVisible(false);
		}

		if (guestScrollPane != null) {
			guestScrollPane.setVisible(false);
		}
		
		guestTable = new JTable(guestRowData, guestColumn){ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		guestTable = new JTable(guestRowData, guestColumn){ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		
		DefaultTableCellRenderer guestTableHeaderRenderer = new DefaultTableCellRenderer();
		guestTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		guestTableHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		guestTableHeaderRenderer.setOpaque(false);
		guestTable.getTableHeader()
				.setDefaultRenderer(guestTableHeaderRenderer);

		
		guestTable.setForeground(Color.WHITE);
		guestTable.getTableHeader().setBackground(Color.BLACK);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		guestTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		guestTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		guestTable.setDefaultRenderer(Object.class, r);
		guestTable.setRowHeight(70);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		guestTable.setOpaque(false);
		guestTable.getColumnModel().getColumn(0).setCellRenderer(new PlayerRenderer("guest"));
		
		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		guestScrollPane.setBounds(0, 100, 550, 400);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);

		datalbl.add(guestScrollPane);

		ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo
				.getHomeTP();
		hostPlayerVos = hostTeamPerformanceInSingleGame.getPlayerList();
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		hostColumn = new Vector<String>();
		hostColumn.add("球员");
		hostColumn.add("姓名");
		hostColumn.add("号码");
		hostColumn.add("分钟");
		hostColumn.add("得分");
		hostColumn.add("助攻");
		hostColumn.add("个人犯规");
		for (int i = 0; i < hostPlayerVos.size(); i++) {
			Vector<String> a = new Vector<String>();
			a.add("");
			a.add(String.valueOf(hostPlayerVos.get(i).getName()));
			a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
			a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
			a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
			a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
			a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
			hostRowData.add(a);
		}

		if (hostTable != null) {
			hostTable.setVisible(false);
		}

		if (hostScrollPane != null) {
			hostScrollPane.setVisible(false);
		}
		
		hostTable = new JTable(hostRowData, hostColumn) { 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		
		
		guestTable = new JTable(guestRowData, guestColumn){ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		
		DefaultTableCellRenderer hostTableHeaderRenderer = new DefaultTableCellRenderer();
		hostTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		hostTableHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		hostTableHeaderRenderer.setOpaque(false);
		hostTable.getTableHeader()
				.setDefaultRenderer(hostTableHeaderRenderer);

		
		hostTable.setForeground(Color.WHITE);
		hostTable.getTableHeader().setBackground(Color.BLACK);
		DefaultTableCellRenderer r5 = new DefaultTableCellRenderer();
		r5.setHorizontalAlignment(JLabel.CENTER);
		hostTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		hostTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		hostTable.setDefaultRenderer(Object.class, r5);
		hostTable.setRowHeight(70);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		hostTable.setOpaque(false);
		hostTable.getColumnModel().getColumn(0).setCellRenderer(new PlayerRenderer("host"));
		
		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		hostScrollPane.setBounds(550, 100, 550, 400);
		hostScrollPane.setVisible(true);
		hostScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hostScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hostScrollPane.getViewport().setOpaque(false);
		hostScrollPane.setOpaque(false);

		datalbl.add(hostScrollPane);

		bgLabel.add(datalbl);
	}

	public void guestCriteriaSelected(String guestDataCriteria) {
		ArrayList<PlayerPerformanceInSingleGame> guestPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame guestTeamPerformanceInSingleGame = gameVo
				.getGuestTP();
		guestPlayerVos = guestTeamPerformanceInSingleGame.getPlayerList();
		if (guestRowData == null) {
			guestRowData = new Vector<Vector<String>>();
		} else {
			guestRowData.clear();
		}
		if (guestDataCriteria == "BASIC") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("分钟");
			guestColumn.add("得分");
			guestColumn.add("助攻");
			guestColumn.add("个人犯规");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getScore()));
				a.add(String.valueOf(guestPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(guestPlayerVos.get(i).getFoul()));
				guestRowData.add(a);
			}
		} else if (guestDataCriteria == "SHOOTING") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("分钟");
			guestColumn.add("命中数");
			guestColumn.add("三分命中数");
			guestColumn.add("罚球命中数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getHitNum()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getThreePointHitNum()));
				a.add(String
						.valueOf(guestPlayerVos.get(i).getFreeThrowHitNum()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "REBOUNDS") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("分钟");
			guestColumn.add("进攻篮板");
			guestColumn.add("防守篮板");
			guestColumn.add("总篮板数");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getOffensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i)
						.getDefensiveRebound()));
				a.add(String.valueOf(guestPlayerVos.get(i).getReboundOverall()));
				guestRowData.add(a);
			}

		} else if (guestDataCriteria == "X-FACTOR") {
			guestColumn = new Vector<String>();
			guestColumn.add("球员");
			guestColumn.add("姓名");
			guestColumn.add("号码");
			guestColumn.add("分钟");
			guestColumn.add("抢断");
			guestColumn.add("盖帽");
			guestColumn.add("失误");
			for (int i = 0; i < guestPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(guestPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(guestPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTime()));
				a.add(String.valueOf(guestPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(guestPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(guestPlayerVos.get(i).getTurnover()));
				guestRowData.add(a);
			}

		} else {
			System.out.println("guestDataCriteria in GameInfoPanel！！！");
		}

		if (guestTable != null) {
			guestTable.setVisible(false);
		}

		if (guestScrollPane != null) {
			guestScrollPane.setVisible(false);
		}
		
		guestTable = new JTable(guestRowData, guestColumn){ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		
		DefaultTableCellRenderer guestTableHeaderRenderer = new DefaultTableCellRenderer();
		guestTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		guestTableHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		guestTableHeaderRenderer.setOpaque(false);
		guestTable.getTableHeader()
				.setDefaultRenderer(guestTableHeaderRenderer);

		
		guestTable.setForeground(Color.WHITE);
		guestTable.getTableHeader().setBackground(Color.BLACK);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		guestTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		guestTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		guestTable.setDefaultRenderer(Object.class, r);
		guestTable.setRowHeight(70);
		guestTable.setVisible(true);
		guestTable.setCellSelectionEnabled(true);
		guestTable.setOpaque(false);
		guestTable.getColumnModel().getColumn(0).setCellRenderer(new PlayerRenderer("guest"));
		
		guestScrollPane = new JScrollPane(guestTable);
		guestScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		guestScrollPane.setBounds(0, 100, 550, 400);
		guestScrollPane.setVisible(true);
		guestScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		guestScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		guestScrollPane.getViewport().setOpaque(false);
		guestScrollPane.setOpaque(false);

		datalbl.add(guestScrollPane);

	}

	public void hostCriteriaSelected(String hostDataCriteria) {

		ArrayList<PlayerPerformanceInSingleGame> hostPlayerVos = new ArrayList<PlayerPerformanceInSingleGame>();
		TeamPerformanceInSingleGame hostTeamPerformanceInSingleGame = gameVo
				.getHomeTP();
		hostPlayerVos = hostTeamPerformanceInSingleGame.getPlayerList();
		if (hostRowData == null) {
			hostRowData = new Vector<Vector<String>>();
		} else {
			hostRowData.clear();
		}
		if (hostDataCriteria == "BASIC") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("分钟");
			hostColumn.add("得分");
			hostColumn.add("助攻");
			hostColumn.add("个人犯规");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getScore()));
				a.add(String.valueOf(hostPlayerVos.get(i).getAssistance()));
				a.add(String.valueOf(hostPlayerVos.get(i).getFoul()));
				hostRowData.add(a);
			}
		} else if (hostDataCriteria == "SHOOTING") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("分钟");
			hostColumn.add("命中数");
			hostColumn.add("三分命中数");
			hostColumn.add("罚球命中数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getHitNum()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getThreePointHitNum()));
				a.add(String.valueOf(hostPlayerVos.get(i).getFreeThrowHitNum()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "REBOUNDS") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("分钟");
			hostColumn.add("进攻篮板");
			hostColumn.add("防守篮板");
			hostColumn.add("总篮板数");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getOffensiveRebound()));
				a.add(String
						.valueOf(hostPlayerVos.get(i).getDefensiveRebound()));
				a.add(String.valueOf(hostPlayerVos.get(i).getReboundOverall()));
				hostRowData.add(a);
			}

		} else if (hostDataCriteria == "X-FACTOR") {
			hostColumn = new Vector<String>();
			hostColumn.add("球员");
			hostColumn.add("姓名");
			hostColumn.add("号码");
			hostColumn.add("分钟");
			hostColumn.add("抢断");
			hostColumn.add("盖帽");
			hostColumn.add("失误");
			for (int i = 0; i < hostPlayerVos.size(); i++) {
				Vector<String> a = new Vector<String>();
				a.add("");
				a.add(String.valueOf(hostPlayerVos.get(i).getName()));
				a.add("#" + String.valueOf(hostPlayerVos.get(i).getNumber()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTime()));
				a.add(String.valueOf(hostPlayerVos.get(i).getSteal()));
				a.add(String.valueOf(hostPlayerVos.get(i).getBlock()));
				a.add(String.valueOf(hostPlayerVos.get(i).getTurnover()));
				hostRowData.add(a);
			}

		} else {
			System.out.println("hostDataCriteria in GameInfoPanel！！！");
		}

		if (hostTable != null) {
			hostTable.setVisible(false);
		}

		if (hostScrollPane != null) {
			hostScrollPane.setVisible(false);
		}

		
		hostTable = new JTable(hostRowData, hostColumn) 
		{ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		}
		;

		guestTable = new JTable(guestRowData, guestColumn){ 
			public Component prepareRenderer(TableCellRenderer renderer,
					int row, int column) {
				Component c = super.prepareRenderer(renderer, row, column);
				if (c instanceof JComponent) {
					((JComponent) c).setOpaque(false);
				}
				return c;
			}
		};
		
		DefaultTableCellRenderer hostTableHeaderRenderer = new DefaultTableCellRenderer();
		hostTableHeaderRenderer.setPreferredSize(new Dimension(550, 50));
		hostTableHeaderRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		hostTableHeaderRenderer.setOpaque(false);
		hostTable.getTableHeader()
				.setDefaultRenderer(hostTableHeaderRenderer);

		
		hostTable.setForeground(Color.WHITE);
		hostTable.getTableHeader().setBackground(Color.BLACK);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		hostTable.getColumnModel().getColumn(0).setPreferredWidth(70);
		hostTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		hostTable.setDefaultRenderer(Object.class, r);
		hostTable.setRowHeight(70);
		hostTable.setVisible(true);
		hostTable.setCellSelectionEnabled(true);
		hostTable.setOpaque(false);
		hostTable.getColumnModel().getColumn(0).setCellRenderer(new PlayerRenderer("host"));
		
		hostScrollPane = new JScrollPane(hostTable);
		hostScrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		hostScrollPane.setBounds(550, 100, 550, 400);
		hostScrollPane.setVisible(true);
		hostScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		hostScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		hostScrollPane.getViewport().setOpaque(false);
		hostScrollPane.setOpaque(false);

		datalbl.add(hostScrollPane);

	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
	}
	
	public void fresh(){
		
	}

	class PlayerRenderer extends JButton implements TableCellRenderer{
		String name;
		boolean isGuest;
		public PlayerRenderer(String s){
			if(s.endsWith("guest")){
				isGuest=true;
			}else{
				isGuest=false;
			}
		}
		@Override
		public Component getTableCellRendererComponent(JTable arg0,
				Object arg1, boolean arg2, boolean isSelected, int row, int column) {
			// TODO Auto-generated method stub
			if(isGuest){
				this.name=(String)guestTable.getValueAt(row, 1);
			}else{
				this.name=(String)hostTable.getValueAt(row, 1);
			}
			
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"CSEdata/players/portrait/"+this.name+".png").getImage().getScaledInstance( 70, 70,
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			if(isSelected){
				System.out.println("11111");
			}
			return this;
		}
		
	}
	
	class MyButton extends JButton{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton(){
			super();
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			
		}
		public MyButton(String s){
			super();
			this.setText(s);
			this.setHorizontalTextPosition(SwingConstants.CENTER);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("微软雅黑",1,15));
			ImageIcon buttonIcon = new ImageIcon(new ImageIcon(
					"Image/mainButton.png").getImage().getScaledInstance(  X*155/1366, Y*23/768,
							 Image.SCALE_SMOOTH));
			
			this.setIcon(buttonIcon);
			this.setOpaque(false);
			this.setContentAreaFilled(false);
			this.setBorderPainted(false);
			
		}
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
			this.setFont(new Font("黑体", 1, 13));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}
		
		
		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 13));
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
