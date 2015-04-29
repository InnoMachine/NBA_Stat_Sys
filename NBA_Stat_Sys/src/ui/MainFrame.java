package ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.JFrame;

import org.apache.tools.ant.types.FileList;

import businessLogic.DataUpdate;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	static StartPanel startPanel = null;
	public static PlayerPanel playerPanel;
	public static TeamPanel teamPanel;
	public static GamePanel gamePanel;
	public static PlayerInfoPanel playerInfoPanel;
	public static TeamInfoPanel teamInfoPanel;
	public static GameInfoPanel gameInfoPanel;
	
	
	public static void main(String[] args) {
		 
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		 Timer timer = new Timer(); DataUpdate du = new DataUpdate(mf);
		 timer.schedule(du,1000,5000);
		
	}

	public MainFrame() {
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle(screenSize);
		this.setBounds(bounds);

		playerPanel = new PlayerPanel(this);
		playerPanel.setVisible(false);
		teamPanel = new TeamPanel(this);
		teamPanel.setVisible(false);
		gamePanel = new GamePanel(this);
		gamePanel.setVisible(false);
		startPanel = new StartPanel(this, playerPanel, teamPanel, gamePanel);
		this.getContentPane().add(startPanel);
		// this.getContentPane()

	}
	public void update(){
		playerPanel = new PlayerPanel(this);
		playerPanel.setVisible(false);
		teamPanel = new TeamPanel(this);
		teamPanel.setVisible(false);
		gamePanel = new GamePanel(this);
		gamePanel.setVisible(false);
	}

}