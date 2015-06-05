package ui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AnalysisPanel extends JPanel{
	JFrame mainFrame;
	static int X;
	static int Y;
	JLabel bgLabel;
	
	public AnalysisPanel(JFrame mainFrame){
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/playerPanel.png")
				.getImage().getScaledInstance(this.getWidth(),
						this.getHeight(), Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		this.add(bgLabel);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X*1180/1366, Y*20/768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		bgLabel.add(home);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25, X / 25,Image.SCALE_SMOOTH));
		minimize.setBounds(X*1240/1366, Y*20/768, X / 25, X / 25);
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
		close.setBounds(X*1300/1366, Y*20/768, X / 25, X / 25);
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

		mainFrame.add(this);
		
	}
	
	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.analysisPanel,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel="StartPanel";
		// playerCriteriaPanel.setVisible(false);
	}
}
