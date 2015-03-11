package ui;

import javax.swing.JFrame;

import javax.swing.JButton;

public class MainFrame extends JFrame {
	


	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}

	public MainFrame() {
		setTitle("NBA信息查询系统");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(200, 100, 692, 450);
		getContentPane().setLayout(null);
		StartPanel startPanel=new StartPanel(this);
        this.add(startPanel);
	}
}
