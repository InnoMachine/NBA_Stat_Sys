package ui.analysis;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ui.MainFrame;
import ui.StartPanel;
import ui_demos.StrangeButtonPanel;

public class AnalysisPanel extends JPanel {
	JFrame mainFrame;
	static int X;
	static int Y;
	JLabel bgLabel;
	String currentTeam = "ATL";
	String currentPicCriteria = "";
	TeamChartPanel teamChartPanel;

	public AnalysisPanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(new Color(21,21,21));

		JLabel titlelbl=new JLabel("NBA球队球风变化分析",JLabel.CENTER);
		titlelbl.setBounds(186, 0, 994, 132);
		titlelbl.setVisible(true);
		titlelbl.setOpaque(false);
		titlelbl.setFont(new Font("微软雅黑", 1, 24));
		titlelbl.setForeground(Color.WHITE);
		this.add(titlelbl);
		
		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(X * 1180 / 1366, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		this.add(home);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(X * 1240 / 1366, Y * 20 / 768, X / 25, X / 25);
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
		this.add(minimize);

		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage()
						.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		close.setBounds(X * 1300 / 1366, Y * 20 / 768, X / 25, X / 25);
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
		this.add(close);
		
		
		JLabel label = new JLabel();
		label.setBounds(117, 132, 1131, 636);
		label.setVisible(true);
		ImageIcon mapIcon = new ImageIcon(new ImageIcon(
				"Image/nba-full-map.jpg").getImage().getScaledInstance(1131,
				636, Image.SCALE_SMOOTH));
		label.setIcon(mapIcon);

		JLabel currentTeamlbl = new JLabel();
		currentTeamlbl.setBounds(1020, 550, 240, 84);
		// currentTeamlbl.setBackground(Color.yellow);
		ImageIcon wordmarkIcon = new ImageIcon(new ImageIcon(
				"Image/wordmark_png/ATL_wordmark.png").getImage()
				.getScaledInstance(200, 70, Image.SCALE_SMOOTH));
		currentTeamlbl.setIcon(wordmarkIcon);
		currentTeamlbl.setVisible(true);

	//	label.add(teamChartPanel);

		JButton MEM = new JButton();
		MEM.setBounds(140, 0, 80, 14);
		MEM.setContentAreaFilled(false);
		MEM.setBorderPainted(false);
		MEM.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MEM";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		MEM.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MEM", this);
		});
		MEM.setVisible(true);
		// MEM.setOpaque(false);
		label.add(MEM);

		JButton TOR1 = new JButton();
		TOR1.setBounds(234, 0, 831, 34);
		TOR1.setContentAreaFilled(false);
		TOR1.setBorderPainted(false);
		TOR1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "TOR";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		TOR1.addActionListener(e->{
		
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "TOR", this);
		});
		TOR1.setVisible(true);
		label.add(TOR1);

		JButton TOR2 = new JButton();
		TOR2.setBounds(421, 35, 239, 24);
		TOR2.setContentAreaFilled(false);
		TOR2.setBorderPainted(false);
		TOR2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "TOR";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		TOR2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "TOR", this);
		});
		TOR2.setVisible(true);
		label.add(TOR2);

		JButton TOR3 = new JButton();
		TOR3.setBounds(664, 34, 323, 75);
		TOR3.setContentAreaFilled(false);
		TOR3.setBorderPainted(false);
		TOR3.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "TOR";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		TOR3.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "TOR", this);
		});
		TOR3.setVisible(true);
		label.add(TOR3);

		JButton MIN1 = new JButton();
		MIN1.setBounds(418, 73, 220, 113);
		MIN1.setVisible(true);
		MIN1.setContentAreaFilled(false);
		MIN1.setBorderPainted(false);
		MIN1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MIN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		MIN1.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MIN", this);
		});
		label.add(MIN1);

		JButton MIN2 = new JButton();
		MIN2.setBounds(462, 187, 159, 28);
		MIN2.setContentAreaFilled(false);
		MIN2.setBorderPainted(false);
		MIN2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MIN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		MIN2.addActionListener(e->{
		
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MIN", this);
		});
		MIN2.setVisible(true);
		label.add(MIN2);

		JButton POR = new JButton();
		POR.setBounds(122, 95, 200, 83);
		POR.setContentAreaFilled(false);
		POR.setBorderPainted(false);
		POR.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "POR";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		POR.addActionListener(e->{
		
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "POR", this);
		});
		POR.setVisible(true);
		label.add(POR);

		JButton MIL = new JButton();
		MIL.setBounds(660, 134, 54, 75);
		MIL.setContentAreaFilled(false);
		MIL.setBorderPainted(false);
		MIL.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MIL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		MIL.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MIL", this);
		});
		MIL.setVisible(true);
		label.add(MIL);

		JButton DET = new JButton();
		DET.setBounds(744, 159, 65, 63);
		DET.setContentAreaFilled(false);
		DET.setBorderPainted(false);
		DET.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DET";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		DET.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DET", this);
		});
		DET.setVisible(true);
		label.add(DET);

		JButton NYK = new JButton();
		NYK.setBounds(870, 151, 96, 41);
		NYK.setContentAreaFilled(false);
		NYK.setBorderPainted(false);
		NYK.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "NYK";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		NYK.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "NYK", this);
		});
		NYK.setVisible(true);
		label.add(NYK);

		JButton BOS1 = new JButton();
		BOS1.setBounds(966, 123, 87, 58);
		BOS1.setContentAreaFilled(false);
		BOS1.setBorderPainted(false);
		BOS1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "BOS";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		BOS1.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "BOS", this);
		});
		BOS1.setVisible(true);
		label.add(BOS1);

		JButton BOS2 = new JButton();
		BOS2.setBounds(1003, 65, 45, 54);
		BOS2.setContentAreaFilled(false);
		BOS2.setBorderPainted(false);
		BOS2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "BOS";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		BOS2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "BOS", this);
		});
		BOS2.setVisible(true);
		label.add(BOS2);

		JButton GSW = new JButton();
		GSW.setBounds(79, 167, 46, 118);
		GSW.setContentAreaFilled(false);
		GSW.setBorderPainted(false);
		GSW.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "GSW";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		GSW.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "GSW", this);
		});
		GSW.setVisible(true);
		label.add(GSW);

		JButton SAC = new JButton();
		SAC.setBounds(120, 190, 91, 62);
		SAC.setContentAreaFilled(false);
		SAC.setBorderPainted(false);
		SAC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
		//		teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "SAC";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		SAC.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "SAC", this);
		});
		SAC.setVisible(true);
		label.add(SAC);

		JButton UTA = new JButton();
		UTA.setBounds(232, 211, 98, 104);
		UTA.setContentAreaFilled(false);
		UTA.setBorderPainted(false);
		UTA.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
		//		teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "UTA";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		UTA.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "UTA", this);
		});
		UTA.setVisible(true);
		label.add(UTA);

		JButton LAL1 = new JButton();
		LAL1.setBounds(100, 289, 132, 53);
		LAL1.setContentAreaFilled(false);
		LAL1.setBorderPainted(false);
		LAL1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "LAL";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		LAL1.addActionListener(e -> {
		
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "LAL", this);

		});
		LAL1.setVisible(true);
		label.add(LAL1);

		JButton LAL2 = new JButton();
		LAL2.setBounds(160, 332, 51, 69);
		LAL2.setContentAreaFilled(false);
		LAL2.setBorderPainted(false);
		LAL2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "LAL";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		LAL2.addActionListener(e -> {
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "LAL", this);
		});
		LAL2.setVisible(true);
		label.add(LAL2);

		JButton LAC = new JButton();
		LAC.setBounds(111, 343, 47, 46);
		LAC.setContentAreaFilled(false);
		LAC.setBorderPainted(false);
		LAC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "LAC";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		LAC.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "LAC", this);
		});
		LAC.setVisible(true);
		label.add(LAC);

		JButton DEN1 = new JButton();
		DEN1.setBounds(330, 198, 131, 147);
		DEN1.setContentAreaFilled(false);
		DEN1.setBorderPainted(false);
		DEN1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DEN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		DEN1.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DEN", this);
		});
		DEN1.setVisible(true);
		label.add(DEN1);

		JButton DEN2 = new JButton();
		DEN2.setBounds(328, 130, 88, 65);
		DEN2.setContentAreaFilled(false);
		DEN2.setBorderPainted(false);
		DEN2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DEN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		DEN2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DEN", this);
		});
		DEN2.setVisible(true);
		label.add(DEN2);

		JButton DEN3 = new JButton();
		DEN3.setBounds(359, 347, 83, 43);
		DEN3.setContentAreaFilled(false);
		DEN3.setBorderPainted(false);
		DEN2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DEN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		DEN3.addActionListener(e -> {
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DEN", this);
		});
		DEN3.setVisible(true);
		label.add(DEN3);

		JButton OKC = new JButton();
		OKC.setBounds(501, 255, 126, 158);
		OKC.setContentAreaFilled(false);
		OKC.setBorderPainted(false);
		OKC.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "OKC";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		OKC.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "OKC", this);
		});
		OKC.setVisible(true);
		label.add(OKC);

		JButton CHI = new JButton();
		CHI.setBounds(629, 225, 98, 99);
		CHI.setContentAreaFilled(false);
		CHI.setBorderPainted(false);
		CHI.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "CHI";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		CHI.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "CHI", this);
		});
		CHI.setVisible(true);
		label.add(CHI);

		JButton IND = new JButton();
		IND.setBounds(734, 242, 43, 62);
		IND.setContentAreaFilled(false);
		IND.setBorderPainted(false);
		IND.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "IND";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		IND.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "IND", this);
		});
		IND.setVisible(true);
		label.add(IND);

		JButton CLE = new JButton();
		CLE.setBounds(782, 232, 75, 85);
		CLE.setContentAreaFilled(false);
		CLE.setBorderPainted(false);
		CLE.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "CLE";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		CLE.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "CLE", this);
		});
		CLE.setVisible(true);
		label.add(CLE);

		JButton PHI = new JButton();
		PHI.setBounds(857, 209, 91, 36);
		PHI.setContentAreaFilled(false);
		PHI.setBorderPainted(false);
		PHI.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "PHI";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		PHI.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "PHI", this);
		});
		PHI.setVisible(true);
		label.add(PHI);

		JButton WAS = new JButton();
		WAS.setBounds(875, 257, 81, 52);
		WAS.setContentAreaFilled(false);
		WAS.setBorderPainted(false);
		WAS.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "WAS";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		WAS.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "WAS", this);
		});
		WAS.setVisible(true);
		label.add(WAS);

		JButton PHX1 = new JButton();
		PHX1.setBounds(218, 393, 217, 63);
		PHX1.setContentAreaFilled(false);
		PHX1.setBorderPainted(false);
		PHX1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "PHX";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		PHX1.addActionListener(e -> {
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "PHX", this);
		});
		PHX1.setVisible(true);
		label.add(PHX1);

		JButton PHX2 = new JButton();
		PHX2.setBounds(225, 344, 126, 45);
		PHX2.setContentAreaFilled(false);
		PHX2.setBorderPainted(false);
		PHX2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "PHX";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		PHX2.addActionListener(e -> {
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "PHX", this);
		});
		PHX2.setVisible(true);
		label.add(PHX2);

		JButton CHA = new JButton();
		CHA.setBounds(831, 324, 114, 69);
		CHA.setContentAreaFilled(false);
		CHA.setBorderPainted(false);
		CHA.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "CHA";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		CHA.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "CHA", this);
		});
		CHA.setVisible(true);
		label.add(CHA);

		JButton MEM2 = new JButton();
		MEM2.setBounds(666, 336, 116, 77);
		MEM2.setContentAreaFilled(false);
		MEM2.setBorderPainted(false);
		MEM2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MEM";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		MEM2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MEM", this);
		});
		MEM2.setVisible(true);
		label.add(MEM2);

		JButton ATL = new JButton();
		ATL.setBounds(780, 414, 87, 61);
		ATL.setContentAreaFilled(false);
		ATL.setBorderPainted(false);
		ATL.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "ATL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		ATL.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "ATL", this);
		});
		ATL.setVisible(true);
		label.add(ATL);

		JButton NOH = new JButton();
		NOH.setBounds(622, 435, 121, 88);
		NOH.setContentAreaFilled(false);
		NOH.setBorderPainted(false);
		NOH.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "NOH";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + "NOP" + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		NOH.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "NOH", this);
		});
		NOH.setVisible(true);
		label.add(NOH);

		JButton HOU = new JButton();
		HOU.setBounds(562, 469, 61, 58);
		HOU.setContentAreaFilled(false);
		HOU.setBorderPainted(false);
		HOU.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "HOU";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			
			}
		});
		HOU.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "HOU", this);
		});
		HOU.setVisible(true);
		label.add(HOU);

		JButton SAS1 = new JButton();
		SAS1.setBounds(365, 491, 191, 89);
		SAS1.setContentAreaFilled(false);
		SAS1.setBorderPainted(false);
		SAS1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "SAS";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		SAS1.addActionListener(e -> {
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "SAS", this);
		});
		SAS1.setVisible(true);
		label.add(SAS1);

		JButton SAS2 = new JButton();
		SAS2.setBounds(395, 471, 79, 17);
		SAS2.setContentAreaFilled(false);
		SAS2.setBorderPainted(false);
		SAS2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "SAS";
				currentTeamlbl
						.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
								+ currentTeam + "_wordmark.png").getImage()
								.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		SAS2.addActionListener(e -> {
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "SAS", this);
		});
		SAS2.setVisible(true);
		label.add(SAS2);

		JButton ORL1 = new JButton();
		ORL1.setBounds(755, 483, 124, 20);
		ORL1.setContentAreaFilled(false);
		ORL1.setBorderPainted(false);
		ORL1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "ORL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		ORL1.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "ORL", this);
		});
		ORL1.setVisible(true);
		label.add(ORL1);

		JButton ORL2 = new JButton();
		ORL2.setBounds(866, 504, 23, 22);
		ORL2.setContentAreaFilled(false);
		ORL2.setBorderPainted(false);
		ORL2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "ORL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		ORL2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "ORL", this);
		});
		ORL2.setVisible(true);
		label.add(ORL2);

		JButton MIA = new JButton();
		MIA.setBounds(860, 532, 56, 63);
		MIA.setContentAreaFilled(false);
		MIA.setBorderPainted(false);
		MIA.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "MIA";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		MIA.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "MIA", this);
		});
		MIA.setVisible(true);
		label.add(MIA);

		JButton DAL1 = new JButton();
		DAL1.setBounds(441, 425, 163, 37);
		DAL1.setContentAreaFilled(false);
		DAL1.setBorderPainted(false);
		DAL1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DAL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		DAL1.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DAL", this);
		});
		DAL1.setVisible(true);
		label.add(DAL1);

		JButton DAL2 = new JButton();
		DAL2.setBounds(441, 362, 58, 58);
		DAL2.setContentAreaFilled(false);
		DAL2.setBorderPainted(false);
		DAL2.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "DAL";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		DAL2.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "DAL", this);
		});
		DAL2.setVisible(true);
		label.add(DAL2);

		JButton BKN = new JButton();
		BKN.setBounds(949, 208, 31, 42);
		BKN.setContentAreaFilled(false);
		BKN.setBorderPainted(false);
		BKN.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			//	teamChartPanel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				currentTeam = "BKN";
				currentTeamlbl.setIcon(new ImageIcon(new ImageIcon(
						"Image/wordmark_png/" + currentTeam + "_wordmark.png")
						.getImage().getScaledInstance(132, 46,
								Image.SCALE_SMOOTH)));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
		
			}
		});
		BKN.addActionListener(e->{
			
			selfClose();
			TypicalTeamAnalysisPanel ttap = new TypicalTeamAnalysisPanel(
					mainFrame, "BKN", this);
		});
		BKN.setVisible(true);
		label.add(BKN);

		this.add(currentTeamlbl);
		this.add(label);
		mainFrame.add(this);

	}

	public void selfClose() {
		this.setVisible(false);
	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame, MainFrame.analysisPanel,
				MainFrame.playerPanel, MainFrame.teamPanel, MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel = "StartPanel";
		// playerCriteriaPanel.setVisible(false);
	}
    /*
	public void addPicture(String team, String criteria) {
		JLabel bg = new JLabel();
		bg.setBounds(0, 0, 700, 432);
		ImageIcon pic = new ImageIcon(new ImageIcon("Image/sortPlayer.png")
				.getImage().getScaledInstance(700, 432, Image.SCALE_SMOOTH));
		bg.setIcon(pic);
		teamChartPanel.add(bg);

	}
	*/
}
