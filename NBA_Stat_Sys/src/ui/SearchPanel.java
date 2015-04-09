package ui;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		JButton AButton=new MyButton("A");
		JButton BButton=new MyButton("B");
		JButton CButton=new MyButton("C");
		JButton DButton=new MyButton("D");
		JButton EButton=new MyButton("E");
		JButton FButton=new MyButton("F");
		JButton GButton=new MyButton("G");
		JButton HButton=new MyButton("H");
		JButton IButton=new MyButton("I");
		JButton JButton=new MyButton("G");
		JButton KButton=new MyButton("K");
		JButton LButton=new MyButton("L");
		JButton MButton=new MyButton("M");
		JButton NButton=new MyButton("N");	
		JButton OButton=new MyButton("O");
		JButton PButton=new MyButton("P");
		JButton QButton=new MyButton("Q");
		JButton RButton=new MyButton("R");	
		JButton SButton=new MyButton("S");
		JButton TButton=new MyButton("T");
		JButton UButton=new MyButton("U");
		JButton VButton=new MyButton("V");
		JButton WButton=new MyButton("W");
		JButton XButton=new MyButton("X");
		JButton YButton=new MyButton("Y");
		JButton ZButton=new MyButton("Z");
		
		
	}
	
	public void addAmbiguousSearch(){
		
	}
	
	class MyButton extends JButton{
		public MyButton(String text){
			super();
			this.setText(text);
			bgLabel.add(this);
		}
	}
}
