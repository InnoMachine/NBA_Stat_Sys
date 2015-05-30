package ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;

import org.apache.tools.ant.types.FileList;

import vo.GameVo;
import vo.TeamPerformanceInSingleGame;
import businessLogic.DataUpdate;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	static StartPanel startPanel = null;
	public static LivePanel livePanel;
	public static PlayerPanel playerPanel;
	public static TeamPanel teamPanel;
	public static GamePanel gamePanel;
	public static LiveInfoPanel liveInfoPanel;
	public static PlayerInfoPanel playerInfoPanel;
	public static TeamInfoPanel teamInfoPanel;
	public static GameInfoPanel gameInfoPanel;
	public static SearchPanel searchPanel;
	public static SortPanel sortPlayerPanel;
	public static ScreeningPlayerPanel screeningPlayerPanel;
	public static SortPanel sortTeamPanel;
	
	
	public static String currentPanel="";
	
	
	public static void main(String[] args) {
		 
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		 Timer timer = new Timer(); DataUpdate du = new DataUpdate(mf);
		 timer.schedule(du,1000,3000);
		
	}

	public MainFrame() {
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		this.setBounds(bounds);

		livePanel = new LivePanel(this);
		livePanel.setVisible(false);
		playerPanel = new PlayerPanel(this);
		playerPanel.setVisible(false);
		teamPanel = new TeamPanel(this);
		teamPanel.setVisible(false);
		gamePanel = new GamePanel(this);
		gamePanel.setVisible(false);
		
//		liveInfoPanel=new LiveInfoPanel(new GameVo(), this, livePanel, "LivePanel");
		
		playerInfoPanel = new PlayerInfoPanel("Aaron Brooks", this, playerPanel, "PlayerPanel");
		playerInfoPanel.setVisible(false);
		teamInfoPanel = new TeamInfoPanel("ATL", this,teamPanel, "TeamPanel");
		teamInfoPanel.setVisible(false);
		GameVo gameVo=new GameVo();
		gameVo.setGuestTP(new TeamPerformanceInSingleGame());
		gameVo.setHomeTP(new TeamPerformanceInSingleGame());
//		gameInfoPanel = new GameInfoPanel(gameVo, this,gamePanel,"GamePanel");
//		gameInfoPanel.setVisible(false);
		searchPanel=new SearchPanel(this, playerPanel);
		searchPanel.setVisible(false);
		sortPlayerPanel=new SortPanel("player", this, playerPanel);
		sortPlayerPanel.setVisible(false);
		screeningPlayerPanel=new ScreeningPlayerPanel(this, playerPanel);
		screeningPlayerPanel.setVisible(false);
		sortTeamPanel=new SortPanel("team", this, teamPanel);
		sortTeamPanel.setVisible(false);
		
		
		startPanel = new StartPanel(this, livePanel,playerPanel, teamPanel, gamePanel);
		this.getContentPane().add(startPanel);
		MainFrame.currentPanel="StartPanel";
		// this.getContentPane()

	}
	public void update(){
		playerPanel.refresh();
		teamPanel.refresh();
		gamePanel.refresh();
		playerInfoPanel.refresh();
		teamInfoPanel.refresh();
//		gameInfoPanel.refresh();
		searchPanel.refresh();
		sortPlayerPanel.refresh();;
		screeningPlayerPanel.refresh();
		sortTeamPanel.refresh();

//		liveInfoPanel.refresh();
	}

}