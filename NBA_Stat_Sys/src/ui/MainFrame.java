package ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Timer;

import javax.swing.JFrame;

import businessLogic.DataUpdate;

public class MainFrame extends JFrame {
	

	private static final long serialVersionUID = 1L;
	static StartPanel startPanel=null;
	public static void main(String[] args) {
		Timer timer = new Timer();
		DataUpdate du = new DataUpdate();
		timer.schedule(du,1000,3000);
		MainFrame mf = new MainFrame();	
		mf.setVisible(true);
	}

	public MainFrame() {
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle( screenSize );  
		this.setBounds(bounds);
        startPanel=new StartPanel(this);
        this.getContentPane().add(startPanel);
        
 
        
	}
}
