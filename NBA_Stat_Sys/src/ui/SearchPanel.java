package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;
import businessLogic.Player_BL;
import businessLogic.Player_BL_Stub;
import businessLogic.Player_BS;
import ui.GamePanel.GameCardRenderer;
import ui.GamePanel.MyLabel;
import vo.GameVo;
import vo.PlayerVo;

public class SearchPanel extends JPanel {

	int X;
	int Y;
	JLabel bgLabel;
	private JTable table;
	private JScrollPane scrollPane;
	JFrame mainFrame;
	JPanel previousPanel;

	Player_BS player_BS = new Player_BL_Stub();

	Vector<Vector<PlayerBasicInfoCardPanel>> rowData;

	public SearchPanel(JFrame mainFrame, JPanel previousPanel) {
		this.mainFrame = mainFrame;
		this.previousPanel = previousPanel;
		mainFrame.getContentPane().add(this);
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/sortPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(new ImageIcon("Image/homeIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));
		home.setBounds(16 * X / 20, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);

		JButton back = new JButton();
		back.setForeground(Color.WHITE);

		ImageIcon backIcon = new ImageIcon(new ImageIcon("Image/backIcon.png")
				.getImage().getScaledInstance(X / 25, X / 25,
						Image.SCALE_SMOOTH));

		back.setBounds(17 * X / 20, Y * 20 / 768, X / 25, X / 25);
		back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		bgLabel.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 20 / 768, X / 25, X / 25);
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
		close.setBounds(19 * X / 20, Y * 20 / 768, X / 25, X / 25);
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

		JLabel keylbl=new MyLabel(Color.WHITE,"排序依据");
		keylbl.setBounds(X * 540 / 1366, Y * 50 / 768, X * 60 / 1366,
				Y * 27 / 768);
		keylbl.setFont(new Font("微软雅黑", 1, 13));
		keylbl.setVisible(true);
		bgLabel.add(keylbl);
		
		JTextField keytF = new JTextField();
		keytF.setBounds(X * 620 / 1366, Y * 50 / 768, X * 200 / 1366,
				Y * 27 / 768);
		keytF.setVisible(true);
		keytF.setBackground(Color.GRAY);
		keytF.setForeground(Color.WHITE);
		keytF.setFont(new Font("微软雅黑", 1, 13));
		bgLabel.add(keytF);
/*
		JButton searchbtn = new JButton("搜索");
		searchbtn.setBounds(X * 700 / 1366, Y * 50 / 768, X * 100 / 1366,
				Y * 27 / 768);
		ImageIcon searchbtnIcon = new ImageIcon(new ImageIcon(
				"Image/mainButton.png").getImage().getScaledInstance(
				X * 100 / 1366, Y * 27 / 768, Image.SCALE_SMOOTH));
		searchbtn.setForeground(Color.WHITE);
		searchbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBorderPainted(false);
		searchbtn.setIcon(searchbtnIcon);
		searchbtn.addActionListener(e -> {
			searchPlayer(keytF.getText(), "All");
		});
		searchbtn.setVisible(true);
		bgLabel.add(searchbtn);
*/
		JButton AButton = new MyButton("A");
		AButton.setBounds(X * 215 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		AButton.addActionListener(e -> searchPlayer(keytF.getText(), "A"));
		AButton.setOpaque(true);
		AButton.setBackground(Color.DARK_GRAY);
		AButton.setBorderPainted(false);
		AButton.setFocusPainted(false);
		AButton.setVisible(true);
		bgLabel.add(AButton);
		JButton BButton = new MyButton("B");
		BButton.setBounds(X * 248 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		BButton.setOpaque(true);
		BButton.setBackground(Color.DARK_GRAY);
		BButton.setBorderPainted(false);
		BButton.setFocusPainted(false);
		BButton.setVisible(true);
		bgLabel.add(BButton);
		JButton CButton = new MyButton("C");
		CButton.setBounds(X * 281 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		CButton.addActionListener(e -> searchPlayer(keytF.getText(), "C"));
		CButton.setOpaque(true);
		CButton.setBackground(Color.DARK_GRAY);
		CButton.setBorderPainted(false);
		CButton.setFocusPainted(false);
		CButton.setVisible(true);
		bgLabel.add(CButton);
		JButton DButton = new MyButton("D");
		DButton.setBounds(X * 314 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
///		DButton.addActionListener(e -> searchPlayer(keytF.getText(), "D"));
		DButton.setOpaque(true);
		DButton.setBackground(Color.DARK_GRAY);
		DButton.setBorderPainted(false);
		DButton.setFocusPainted(false);
		DButton.setVisible(true);
		bgLabel.add(DButton);
		JButton EButton = new MyButton("E");
		EButton.setBounds(X * 347 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		EButton.addActionListener(e -> searchPlayer(keytF.getText(), "E"));
		EButton.setOpaque(true);
		EButton.setBackground(Color.DARK_GRAY);
		EButton.setBorderPainted(false);
		EButton.setFocusPainted(false);
		EButton.setVisible(true);
		bgLabel.add(EButton);
		JButton FButton = new MyButton("F");
		FButton.setBounds(X * 380 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		FButton.addActionListener(e -> searchPlayer(keytF.getText(), "F"));
		FButton.setOpaque(true);
		FButton.setBackground(Color.DARK_GRAY);
		FButton.setBorderPainted(false);
		FButton.setFocusPainted(false);
		FButton.setVisible(true);
		bgLabel.add(FButton);
		JButton GButton = new MyButton("G");
		GButton.setBounds(X * 413 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		GButton.addActionListener(e -> searchPlayer(keytF.getText(), "G"));
		GButton.setOpaque(true);
		GButton.setBackground(Color.DARK_GRAY);
		GButton.setBorderPainted(false);
		GButton.setFocusPainted(false);
		GButton.setVisible(true);
		bgLabel.add(GButton);
		JButton HButton = new MyButton("H");
		HButton.setBounds(X * 446 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		HButton.addActionListener(e -> searchPlayer(keytF.getText(), "H"));
		HButton.setOpaque(true);
		HButton.setBackground(Color.DARK_GRAY);
		HButton.setBorderPainted(false);
		HButton.setFocusPainted(false);
		HButton.setVisible(true);
		bgLabel.add(HButton);
		JButton IButton = new MyButton("I");
		IButton.setBounds(X * 479 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		IButton.addActionListener(e -> searchPlayer(keytF.getText(), "I"));
		IButton.setOpaque(true);
		IButton.setBackground(Color.DARK_GRAY);
		IButton.setBorderPainted(false);
		IButton.setFocusPainted(false);
		IButton.setVisible(true);
		bgLabel.add(IButton);
		JButton JButton = new MyButton("J");
		JButton.setBounds(X * 512 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		JButton.addActionListener(e -> searchPlayer(keytF.getText(), "J"));
		JButton.setOpaque(true);
		JButton.setBackground(Color.DARK_GRAY);
		JButton.setBorderPainted(false);
		JButton.setFocusPainted(false);
		JButton.setVisible(true);
		bgLabel.add(JButton);
		JButton KButton = new MyButton("K");
		KButton.setBounds(X * 545 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		KButton.addActionListener(e -> searchPlayer(keytF.getText(), "K"));
		KButton.setOpaque(true);
		KButton.setBackground(Color.DARK_GRAY);
		KButton.setBorderPainted(false);
		KButton.setFocusPainted(false);
		KButton.setVisible(true);
		bgLabel.add(KButton);
		JButton LButton = new MyButton("L");
		LButton.setBounds(X * 578 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		LButton.addActionListener(e -> searchPlayer(keytF.getText(), "L"));
		LButton.setOpaque(true);
		LButton.setBackground(Color.DARK_GRAY);
		LButton.setBorderPainted(false);
		LButton.setFocusPainted(false);
		LButton.setVisible(true);
		bgLabel.add(LButton);
		JButton MButton = new MyButton("M");
		MButton.setBounds(X * 611 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		MButton.addActionListener(e -> searchPlayer(keytF.getText(), "M"));
		MButton.setOpaque(true);
		MButton.setBackground(Color.DARK_GRAY);
		MButton.setBorderPainted(false);
		MButton.setFocusPainted(false);
		MButton.setVisible(true);
		bgLabel.add(MButton);
		JButton NButton = new MyButton("N");
		NButton.setBounds(X * 644 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		NButton.addActionListener(e -> searchPlayer(keytF.getText(), "N"));
		NButton.setOpaque(true);
		NButton.setBackground(Color.DARK_GRAY);
		NButton.setBorderPainted(false);
		NButton.setFocusPainted(false);
		NButton.setVisible(true);
		bgLabel.add(NButton);
		JButton OButton = new MyButton("O");
		OButton.setBounds(X * 677 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		OButton.addActionListener(e -> searchPlayer(keytF.getText(), "O"));
		OButton.setOpaque(true);
		OButton.setBackground(Color.DARK_GRAY);
		OButton.setBorderPainted(false);
		OButton.setFocusPainted(false);
		OButton.setVisible(true);
		bgLabel.add(OButton);
		JButton PButton = new MyButton("P");
		PButton.setBounds(X * 710 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		PButton.addActionListener(e -> searchPlayer(keytF.getText(), "P"));
		PButton.setOpaque(true);
		PButton.setBackground(Color.DARK_GRAY);
		PButton.setBorderPainted(false);
		PButton.setFocusPainted(false);
		PButton.setVisible(true);
		bgLabel.add(PButton);
		JButton QButton = new MyButton("Q");
		QButton.setBounds(X * 743 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		QButton.addActionListener(e -> searchPlayer(keytF.getText(), "Q"));
		QButton.setOpaque(true);
		QButton.setBackground(Color.DARK_GRAY);
		QButton.setBorderPainted(false);
		QButton.setFocusPainted(false);
		QButton.setVisible(true);
		bgLabel.add(QButton);
		JButton RButton = new MyButton("R");
		RButton.setBounds(X * 776 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		RButton.addActionListener(e -> searchPlayer(keytF.getText(), "R"));
		RButton.setOpaque(true);
		RButton.setBackground(Color.DARK_GRAY);
		RButton.setBorderPainted(false);
		RButton.setFocusPainted(false);
		RButton.setVisible(true);
		bgLabel.add(RButton);
		JButton SButton = new MyButton("S");
		SButton.setBounds(X * 809 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		SButton.addActionListener(e -> searchPlayer(keytF.getText(), "S"));
		SButton.setOpaque(true);
		SButton.setBackground(Color.DARK_GRAY);
		SButton.setBorderPainted(false);
		SButton.setFocusPainted(false);
		SButton.setVisible(true);
		bgLabel.add(SButton);
		JButton TButton = new MyButton("T");
		TButton.setBounds(X * 842 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		TButton.addActionListener(e -> searchPlayer(keytF.getText(), "T"));
		TButton.setOpaque(true);
		TButton.setBackground(Color.DARK_GRAY);
		TButton.setBorderPainted(false);
		TButton.setFocusPainted(false);
		TButton.setVisible(true);
		bgLabel.add(TButton);
		JButton UButton = new MyButton("U");
		UButton.setBounds(X * 875 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		UButton.addActionListener(e -> searchPlayer(keytF.getText(), "U"));
		UButton.setOpaque(true);
		UButton.setBackground(Color.DARK_GRAY);
		UButton.setBorderPainted(false);
		UButton.setFocusPainted(false);
		UButton.setVisible(true);
		bgLabel.add(UButton);
		JButton VButton = new MyButton("V");
		VButton.setBounds(X * 908 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		VButton.addActionListener(e -> searchPlayer(keytF.getText(), "V"));
		VButton.setOpaque(true);
		VButton.setBackground(Color.DARK_GRAY);
		VButton.setBorderPainted(false);
		VButton.setFocusPainted(false);
		VButton.setVisible(true);
		bgLabel.add(VButton);
		JButton WButton = new MyButton("W");
		WButton.setBounds(X * 941 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		WButton.addActionListener(e -> searchPlayer(keytF.getText(), "W"));
		WButton.setOpaque(true);
		WButton.setBackground(Color.DARK_GRAY);
		WButton.setBorderPainted(false);
		WButton.setFocusPainted(false);
		WButton.setVisible(true);
		bgLabel.add(WButton);
		JButton XButton = new MyButton("X");
		XButton.setBounds(X * 974 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		XButton.addActionListener(e -> searchPlayer(keytF.getText(), "X"));
		XButton.setOpaque(true);
		XButton.setBackground(Color.DARK_GRAY);
		XButton.setBorderPainted(false);
		XButton.setFocusPainted(false);
		XButton.setVisible(true);
		bgLabel.add(XButton);
		JButton YButton = new MyButton("Y");
		YButton.setBounds(X * 1007 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		YButton.addActionListener(e -> searchPlayer(keytF.getText(), "Y"));
		YButton.setOpaque(true);
		YButton.setBackground(Color.DARK_GRAY);
		YButton.setBorderPainted(false);
		YButton.setFocusPainted(false);
		YButton.setVisible(true);
		bgLabel.add(YButton);
		JButton ZButton = new MyButton("Z");
		ZButton.setBounds(X * 1040 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
//		ZButton.addActionListener(e -> searchPlayer(keytF.getText(), "Z"));
		ZButton.setOpaque(true);
		ZButton.setBackground(Color.DARK_GRAY);
		ZButton.setBorderPainted(false);
		ZButton.setFocusPainted(false);
		ZButton.setVisible(true);
		bgLabel.add(ZButton);
		JButton AllButton = new MyButton("All");
		AllButton.setBounds(X * 1073 / 1366, Y * 87 / 768, X * 73 / 1366,
				Y * 33 / 768);
//		AllButton.addActionListener(e -> searchPlayer(keytF.getText(), "All"));
		AllButton.setOpaque(true);
		AllButton.setBackground(Color.DARK_GRAY);
		AllButton.setBorderPainted(false);
		AllButton.setFocusPainted(false);
		AllButton.setVisible(true);
		bgLabel.add(AllButton);

		AButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "A");
			AButton.setBackground(Color.GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});
		BButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "B");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		CButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "C");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		DButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "DB");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		EButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "E");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		FButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "F");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});
		GButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "G");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		HButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "H");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});
		IButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "I");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		JButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "J");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		KButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "K");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});
		LButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "L");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		MButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "M");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		NButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "N");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		
		OButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "O");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});
		PButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "P");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		QButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "Q");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		RButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "R");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		SButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "S");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		TButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "T");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});
		UButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "U");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		VButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "V");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});
		WButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "W");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});

		XButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "X");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		YButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "Y");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.DARK_GRAY);
		});
		ZButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "Z");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.GRAY);
			AllButton.setBackground(Color.DARK_GRAY);

		});

		AllButton.addActionListener(e -> {
			searchPlayer(keytF.getText(), "All");
			AButton.setBackground(Color.DARK_GRAY);
			BButton.setBackground(Color.DARK_GRAY);
			CButton.setBackground(Color.DARK_GRAY);
			DButton.setBackground(Color.DARK_GRAY);
			EButton.setBackground(Color.DARK_GRAY);
			FButton.setBackground(Color.DARK_GRAY);
			GButton.setBackground(Color.DARK_GRAY);
			HButton.setBackground(Color.DARK_GRAY);
			IButton.setBackground(Color.DARK_GRAY);
			JButton.setBackground(Color.DARK_GRAY);
			KButton.setBackground(Color.DARK_GRAY);
			LButton.setBackground(Color.DARK_GRAY);
			MButton.setBackground(Color.DARK_GRAY);
			NButton.setBackground(Color.DARK_GRAY);
			OButton.setBackground(Color.DARK_GRAY);
			PButton.setBackground(Color.DARK_GRAY);
			QButton.setBackground(Color.DARK_GRAY);
			RButton.setBackground(Color.DARK_GRAY);
			SButton.setBackground(Color.DARK_GRAY);
			TButton.setBackground(Color.DARK_GRAY);
			UButton.setBackground(Color.DARK_GRAY);
			VButton.setBackground(Color.DARK_GRAY);
			WButton.setBackground(Color.DARK_GRAY);
			XButton.setBackground(Color.DARK_GRAY);
			YButton.setBackground(Color.DARK_GRAY);
			ZButton.setBackground(Color.DARK_GRAY);
			AllButton.setBackground(Color.GRAY);
		});
		
		
		
		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		for (int i = 0; i < playerVos.size(); i++) {
			playerVos.add(player_BS.getAllPlayer().get(i));
		}
		if (rowData == null) {
			rowData = new Vector<Vector<PlayerBasicInfoCardPanel>>();
		} else {
			rowData.clear();
		}
		for (int i = 0; i < playerVos.size(); i++) {
			Vector<PlayerBasicInfoCardPanel> a = new Vector<PlayerBasicInfoCardPanel>();
			a.add(new PlayerBasicInfoCardPanel(X, Y, playerVos.get(i)));
			rowData.add(a);
		}

		Vector<String> column = new Vector<String>();
		column.add("");
		DefaultTableModel dtm = new DefaultTableModel(rowData, column) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(dtm);
		DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
		tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		table.setRowHeight(Y * 120 / 768);
		table.setVisible(true);
		table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerBasicInfoCardRenderer());
//		table.setIntercellSpacing(new Dimension(2,2));
//		table.setShowGrid(false);
//		table.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		table.setOpaque(false);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
				Y * 600 / 768);
		scrollPane.setVisible(true);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));

		bgLabel.add(scrollPane);

		mainFrame.getContentPane().add(this);
	}

	public void searchPlayer(String key, String initial) {

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		playerVos = player_BS.searchPlayer(key, initial);
		if (rowData == null) {
			rowData = new Vector<Vector<PlayerBasicInfoCardPanel>>();
		} else {
			rowData.clear();
		}
		for (int i = 0; i < playerVos.size(); i++) {
			Vector<PlayerBasicInfoCardPanel> a = new Vector<PlayerBasicInfoCardPanel>();
			a.add(new PlayerBasicInfoCardPanel(X, Y, playerVos.get(i)));
			rowData.add(a);
		}

		Vector<String> column = new Vector<String>();
		column.add("");
		DefaultTableModel dtm = new DefaultTableModel(rowData, column) {
			/**
				 * 
				 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		if (table != null) {
			table.setVisible(false);
		}
		table = new JTable(dtm);
		DefaultTableCellRenderer tableHeaderRenderer = new DefaultTableCellRenderer();
		tableHeaderRenderer.setPreferredSize(new Dimension(0, 0));
		table.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		table.setRowHeight(Y * 120 / 768);
		table.setVisible(true);
		table.setCellSelectionEnabled(true);
		table.getColumnModel().getColumn(0)
				.setCellRenderer(new PlayerBasicInfoCardRenderer());
		table.setIntercellSpacing(new Dimension(2,2));
//		table.setShowGrid(false);
//		table.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
		table.setOpaque(false);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(
				new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 215 / 1366, Y * 120 / 768, X * 930 / 1366,
				Y * 600 / 768);
		scrollPane.setVisible(true);
		scrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
		bgLabel.add(scrollPane);

	}

	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		// playerCriteriaPanel.setVisible(false);
	}
	
	public void selfClose() {
		this.setVisible(false);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		MainFrame.currentPanel="PlayerPanel";
	}
	public void refresh(){
		mainFrame.remove(this);
		MainFrame.searchPanel=new SearchPanel(mainFrame, previousPanel);
		if(MainFrame.currentPanel=="SearchPanel"){
			MainFrame.searchPanel.setVisible(true);
		}else{
			MainFrame.searchPanel.setVisible(false);
		}
		
	}

	// class: TableRenderer
	class PlayerBasicInfoCardRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// TODO Auto-generated method stub
			PlayerBasicInfoCardPanel renderer = new PlayerBasicInfoCardPanel(X,
					Y, ((PlayerBasicInfoCardPanel) value).getPlayerVo());
			renderer.setOpaque(false);

			if (hasFocus) {
				MainFrame.playerPanel.setVisible(false);
				MainFrame.playerInfoPanel= new PlayerInfoPanel(renderer.getPlayerVo()
						.getName(), mainFrame, new SearchPanel(mainFrame,
						MainFrame.playerPanel),"SearchPanel");
				selfClose();
			}

			return renderer;

		}

	}

	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		}

	}

	class MyLabel extends JLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyLabel(Color textColor) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setFont(new Font("黑体", 1, 11));

		}

		public MyLabel(Color textColor, String text) {
			super();
			this.setOpaque(false);
			this.setForeground(textColor);
			this.setText(text);
			this.setFont(new Font("黑体", 1, 11));

		}
	}

	class MyButton extends JButton {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyButton(String text) {
			super();
			this.setText(text);
			this.setForeground(Color.WHITE);
			this.setMargin(new Insets(0, 0, 0, 0));
			this.setContentAreaFilled(false);
			this.setOpaque(false);
			// this.setBorderPainted(false);
			this.setFont(new Font("黑体", 0, 12));
			bgLabel.add(this);
		}
	}
}
