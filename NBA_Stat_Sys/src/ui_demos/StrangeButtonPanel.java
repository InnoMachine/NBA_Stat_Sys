package ui_demos;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StrangeButtonPanel extends JPanel {
	String currentTeam = "ATL";

	public StrangeButtonPanel() {
		this.setBounds(0, 0, 1366, 768);
		this.setVisible(true);
		this.setLayout(null);
		this.setBackground(Color.DARK_GRAY);
		JLabel label = new JLabel();
		label.setBounds(235, 132, 1131, 636);
		label.setVisible(true);
		ImageIcon mapIcon = new ImageIcon(new ImageIcon(
				"Image/nba-full-map.jpg").getImage().getScaledInstance(1131,
				636, Image.SCALE_SMOOTH));
		label.setIcon(mapIcon);
		this.add(label);

		JLabel currentTeamlbl = new JLabel();
		currentTeamlbl.setBounds(56, 154, 132, 46);
		// currentTeamlbl.setBackground(Color.yellow);
		ImageIcon wordmarkIcon = new ImageIcon(new ImageIcon(
				"Image/wordmark_png/ATL_wordmark.png").getImage()
				.getScaledInstance(132, 46, Image.SCALE_SMOOTH));
		currentTeamlbl.setIcon(wordmarkIcon);

		currentTeamlbl.setVisible(true);
		this.add(currentTeamlbl);

		this.addMouseListener(new MouseListener() {

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

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getX() + "   " + e.getY() + "\n");
			}
		});

		JButton MEM = new JButton();
		MEM.setBounds(140, 0, 80, 14);
		MEM.setContentAreaFilled(false);
		MEM.setBorderPainted(false);
		MEM.addActionListener(e -> {
			currentTeam = "MEM";
			currentTeamlbl
					.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
							+ currentTeam + "_wordmark.png").getImage()
							.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		MEM.setVisible(true);
		// MEM.setOpaque(false);
		label.add(MEM);

		JButton TOR1 = new JButton();
		TOR1.setBounds(234, 0, 831, 34);
		TOR1.setContentAreaFilled(false);
		TOR1.setBorderPainted(false);
		TOR1.addActionListener(e -> {
			currentTeam = "TOR";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));

		});
		TOR1.setVisible(true);
		label.add(TOR1);

		JButton TOR2 = new JButton();
		TOR2.setBounds(421, 35, 239, 24);
		TOR2.setContentAreaFilled(false);
		TOR2.setBorderPainted(false);
		TOR2.addActionListener(e -> {
			currentTeam = "TOR";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		TOR2.setVisible(true);
		label.add(TOR2);

		JButton TOR3 = new JButton();
		TOR3.setBounds(664, 34, 323, 75);
		TOR3.setContentAreaFilled(false);
		TOR3.setBorderPainted(false);
		TOR3.addActionListener(e -> {
			currentTeam = "TOR";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		TOR3.setVisible(true);
		label.add(TOR3);
		/*
		 * JButton OKC=new JButton(); OKC.setBounds(143, 41, 147, 38);
		 * OKC.setVisible(true); label.add(OKC);
		 */
		JButton MIN1 = new JButton();
		MIN1.setBounds(418, 73, 220, 113);
		MIN1.setVisible(true);
		MIN1.setContentAreaFilled(false);
		MIN1.setBorderPainted(false);
		MIN1.addActionListener(e -> {
			currentTeam = "MIN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		label.add(MIN1);

		JButton MIN2 = new JButton();
		MIN2.setBounds(462, 187, 159, 28);
		MIN2.setContentAreaFilled(false);
		MIN2.setBorderPainted(false);
		MIN2.addActionListener(e -> {
			currentTeam = "MIN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		MIN2.setVisible(true);
		label.add(MIN2);

		JButton POR = new JButton();
		POR.setBounds(122, 95, 200, 83);
		POR.setContentAreaFilled(false);
		POR.setBorderPainted(false);
		POR.addActionListener(e -> {
			currentTeam = "POR";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		POR.setVisible(true);
		label.add(POR);

		JButton MIL = new JButton();
		MIL.setBounds(660, 134, 54, 75);
		MIL.setContentAreaFilled(false);
		MIL.setBorderPainted(false);
		MIL.addActionListener(e -> {
			currentTeam = "MIL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		MIL.setVisible(true);
		label.add(MIL);

		JButton DET = new JButton();
		DET.setBounds(744, 159, 65, 63);
		DET.setContentAreaFilled(false);
		DET.setBorderPainted(false);
		DET.addActionListener(e -> {
			currentTeam = "DET";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DET.setVisible(true);
		label.add(DET);

		JButton NYK = new JButton();
		NYK.setBounds(870, 151, 96, 41);
		NYK.setContentAreaFilled(false);
		NYK.setBorderPainted(false);
		NYK.addActionListener(e -> {
			currentTeam = "NYK";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		NYK.setVisible(true);
		label.add(NYK);

		JButton BOS1 = new JButton();
		BOS1.setBounds(966, 123, 87, 58);
		BOS1.setContentAreaFilled(false);
		BOS1.setBorderPainted(false);
		BOS1.addActionListener(e -> {
			currentTeam = "BOS";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		BOS1.setVisible(true);
		label.add(BOS1);

		JButton BOS2 = new JButton();
		BOS2.setBounds(1003, 65, 45, 54);
		BOS2.setContentAreaFilled(false);
		BOS2.setBorderPainted(false);
		BOS2.addActionListener(e -> {
			currentTeam = "BOS";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		BOS2.setVisible(true);
		label.add(BOS2);

		JButton GSW = new JButton();
		GSW.setBounds(79, 167, 46, 118);
		GSW.setContentAreaFilled(false);
		GSW.setBorderPainted(false);
		GSW.addActionListener(e -> {
			currentTeam = "GSW";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		GSW.setVisible(true);
		label.add(GSW);

		JButton SAC = new JButton();
		SAC.setBounds(120, 190, 91, 62);
		SAC.setContentAreaFilled(false);
		SAC.setBorderPainted(false);
		SAC.addActionListener(e -> {
			currentTeam = "SAC";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		SAC.setVisible(true);
		label.add(SAC);

		JButton UTA = new JButton();
		UTA.setBounds(232, 211, 98, 104);
		UTA.setContentAreaFilled(false);
		UTA.setBorderPainted(false);
		UTA.addActionListener(e -> {
			currentTeam = "UTA";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		UTA.setVisible(true);
		label.add(UTA);

		JButton LAL1 = new JButton();
		LAL1.setBounds(100, 289, 132, 53);
		LAL1.setContentAreaFilled(false);
		LAL1.setBorderPainted(false);
		LAL1.addActionListener(e -> {
			currentTeam = "LAL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		LAL1.setVisible(true);
		label.add(LAL1);

		JButton LAL2 = new JButton();
		LAL2.setBounds(160, 332, 51, 69);
		LAL2.setContentAreaFilled(false);
		LAL2.setBorderPainted(false);
		LAL2.addActionListener(e -> {
			currentTeam = "LAL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		LAL2.setVisible(true);
		label.add(LAL2);

		JButton LAC = new JButton();
		LAC.setBounds(111, 343, 47, 46);
		LAC.setContentAreaFilled(false);
		LAC.setBorderPainted(false);
		LAC.addActionListener(e -> {
			currentTeam = "LAC";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		LAC.setVisible(true);
		label.add(LAC);

		JButton DEN1 = new JButton();
		DEN1.setBounds(330, 198, 131, 147);
		DEN1.setContentAreaFilled(false);
		DEN1.setBorderPainted(false);
		DEN1.addActionListener(e -> {
			currentTeam = "DEN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DEN1.setVisible(true);
		label.add(DEN1);

		JButton DEN2 = new JButton();
		DEN2.setBounds(328, 130, 88, 65);
		DEN2.setContentAreaFilled(false);
		DEN2.setBorderPainted(false);
		DEN2.addActionListener(e -> {
			currentTeam = "DEN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DEN2.setVisible(true);
		label.add(DEN2);

		JButton DEN3 = new JButton();
		DEN3.setBounds(359, 347, 83, 43);
		DEN3.setContentAreaFilled(false);
		DEN3.setBorderPainted(false);
		DEN3.addActionListener(e -> {
			currentTeam = "DEN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DEN3.setVisible(true);
		label.add(DEN3);

		JButton OKC = new JButton();
		OKC.setBounds(501, 255, 126, 158);
		OKC.setContentAreaFilled(false);
		OKC.setBorderPainted(false);
		OKC.addActionListener(e -> {
			currentTeam = "OKC";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		OKC.setVisible(true);
		label.add(OKC);

		JButton CHI = new JButton();
		CHI.setBounds(629, 225, 98, 99);
		CHI.setContentAreaFilled(false);
		CHI.setBorderPainted(false);
		CHI.addActionListener(e -> {
			currentTeam = "CHI";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		CHI.setVisible(true);
		label.add(CHI);

		JButton IND = new JButton();
		IND.setBounds(734, 242, 43, 62);
		IND.setContentAreaFilled(false);
		IND.setBorderPainted(false);
		IND.addActionListener(e -> {
			currentTeam = "IND";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		IND.setVisible(true);
		label.add(IND);

		JButton CLE = new JButton();
		CLE.setBounds(782, 232, 75, 85);
		CLE.setContentAreaFilled(false);
		CLE.setBorderPainted(false);
		CLE.addActionListener(e -> {
			currentTeam = "CLE";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		CLE.setVisible(true);
		label.add(CLE);

		JButton PHI = new JButton();
		PHI.setBounds(857, 209, 91, 36);
		PHI.setContentAreaFilled(false);
		PHI.setBorderPainted(false);
		PHI.addActionListener(e -> {
			currentTeam = "PHI";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		PHI.setVisible(true);
		label.add(PHI);

		JButton WAS = new JButton();
		WAS.setBounds(875, 257, 81, 52);
		WAS.setContentAreaFilled(false);
		WAS.setBorderPainted(false);
		WAS.addActionListener(e -> {
			currentTeam = "WAS";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		WAS.setVisible(true);
		label.add(WAS);

		JButton PHX1 = new JButton();
		PHX1.setBounds(218, 393, 217, 63);
		PHX1.setContentAreaFilled(false);
		PHX1.setBorderPainted(false);
		PHX1.addActionListener(e -> {
			currentTeam = "PHX";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		PHX1.setVisible(true);
		label.add(PHX1);

		JButton PHX2 = new JButton();
		PHX2.setBounds(225, 344, 126, 45);
		PHX2.setContentAreaFilled(false);
		PHX2.setBorderPainted(false);
		PHX2.addActionListener(e -> {
			currentTeam = "PHX";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		PHX2.setVisible(true);
		label.add(PHX2);

		JButton CHA = new JButton();
		CHA.setBounds(831, 324, 114, 69);
		CHA.setContentAreaFilled(false);
		CHA.setBorderPainted(false);
		CHA.addActionListener(e -> {
			currentTeam = "CHA";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		CHA.setVisible(true);
		label.add(CHA);

		JButton MEM2 = new JButton();
		MEM2.setBounds(666, 336, 116, 77);
		MEM2.setContentAreaFilled(false);
		MEM2.setBorderPainted(false);
		MEM2.addActionListener(e -> {
			currentTeam = "MEM";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		MEM2.setVisible(true);
		label.add(MEM2);

		JButton ATL = new JButton();
		ATL.setBounds(780, 414, 87, 61);
		ATL.setContentAreaFilled(false);
		ATL.setBorderPainted(false);
		ATL.addActionListener(e -> {
			currentTeam = "ATL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		ATL.setVisible(true);
		label.add(ATL);

		JButton NOH = new JButton();
		NOH.setBounds(622, 435, 121, 88);
		NOH.setContentAreaFilled(false);
		NOH.setBorderPainted(false);
		NOH.addActionListener(e -> {
			currentTeam = "NOH";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		NOH.setVisible(true);
		label.add(NOH);

		JButton HOU = new JButton();
		HOU.setBounds(562, 469, 61, 58);
		HOU.setContentAreaFilled(false);
		HOU.setBorderPainted(false);
		HOU.addActionListener(e -> {
			currentTeam = "HOU";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		HOU.setVisible(true);
		label.add(HOU);

		JButton SAS1 = new JButton();
		SAS1.setBounds(365, 491, 191, 89);
		SAS1.setContentAreaFilled(false);
		SAS1.setBorderPainted(false);
		SAS1.addActionListener(e -> {
			currentTeam = "SAS";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		SAS1.setVisible(true);
		label.add(SAS1);

		JButton SAS2 = new JButton();
		SAS2.setBounds(395, 471, 79, 17);
		SAS2.setContentAreaFilled(false);
		SAS2.setBorderPainted(false);
		SAS2.addActionListener(e -> {
			currentTeam = "SAS";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		SAS2.setVisible(true);
		label.add(SAS2);

		JButton ORL1 = new JButton();
		ORL1.setBounds(755, 483, 124, 20);
		ORL1.setContentAreaFilled(false);
		ORL1.setBorderPainted(false);
		ORL1.addActionListener(e -> {
			currentTeam = "ORL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		ORL1.setVisible(true);
		label.add(ORL1);

		JButton ORL2 = new JButton();
		ORL2.setBounds(866, 504, 23, 22);
		ORL2.setContentAreaFilled(false);
		ORL2.setBorderPainted(false);
		ORL2.addActionListener(e -> {
			currentTeam = "ORL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		ORL2.setVisible(true);
		label.add(ORL2);

		JButton MIA = new JButton();
		MIA.setBounds(860, 532, 56, 63);
		MIA.setContentAreaFilled(false);
		MIA.setBorderPainted(false);
		MIA.addActionListener(e -> {
			currentTeam = "MIA";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		MIA.setVisible(true);
		label.add(MIA);

		JButton DAL1 = new JButton();
		DAL1.setBounds(441, 425, 163, 37);
		DAL1.setContentAreaFilled(false);
		DAL1.setBorderPainted(false);
		DAL1.addActionListener(e -> {
			currentTeam = "DAL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DAL1.setVisible(true);
		label.add(DAL1);

		JButton DAL2 = new JButton();
		DAL2.setBounds(441, 362, 58, 58);
		DAL2.setContentAreaFilled(false);
		DAL2.setBorderPainted(false);
		DAL2.addActionListener(e -> {
			currentTeam = "DAL";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		DAL2.setVisible(true);
		label.add(DAL2);

		JButton BKN = new JButton();
		BKN.setBounds(949, 208, 31, 42);
		BKN.setContentAreaFilled(false);
		BKN.setBorderPainted(false);
		BKN.addActionListener(e -> {
			currentTeam = "BKN";
			currentTeamlbl
			.setIcon(new ImageIcon(new ImageIcon("Image/wordmark_png/"
					+ currentTeam + "_wordmark.png").getImage()
					.getScaledInstance(132, 46, Image.SCALE_SMOOTH)));
		});
		BKN.setVisible(true);
		label.add(BKN);

	}
}
