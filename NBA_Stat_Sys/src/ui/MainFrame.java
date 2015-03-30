package ui;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//test
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		

	      
	}

	public MainFrame() {
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle bounds = new Rectangle( screenSize );  
		this.setBounds(bounds);
		
 //     int X=this.getWidth();
 //     int Y=this.getHeight();
        StartPanel startPanel=new StartPanel(this);
        this.getContentPane().add(startPanel);
        
 
        
	}
}
