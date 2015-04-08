package ui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SearchPanel extends JPanel{
	
	static int X;
	static int Y;
	
	JLabel bgLabel;
	public static void main(String[] args){
		
	}
	public SearchPanel(JFrame mainFrame){
		mainFrame.getContentPane().add(this);
		X=mainFrame.getWidth();
		Y=mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		
		ImageIcon bg;
		bgLabel=new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		addInitialSearch();
		addAmbiguousSearch();
	}
	
	public void addInitialSearch(){
		
	}
	
	public void addAmbiguousSearch(){
		
	}
}
