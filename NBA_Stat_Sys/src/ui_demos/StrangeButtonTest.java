package ui_demos;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StrangeButtonTest extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrangeButtonTest sbt = new StrangeButtonTest();
		sbt.setVisible(true);
	}

	public StrangeButtonTest() {
		this.setBounds(0, 0, 1366, 768);
		this.setVisible(true);
		this.setLayout(null);
		StrangeButtonPanel panel = new StrangeButtonPanel();
		this.add(panel);
	}

}
