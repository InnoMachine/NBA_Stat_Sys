package ui;

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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;
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
	JFrame mainFrame;
JPanel previousPanel;
	private JTable table;
	private JScrollPane scrollPane;

	Player_BS player_BS = new Player_BL_Stub();

	Vector<Vector<PlayerBasicInfoCardPanel>> rowData;

	public SearchPanel(JFrame mainFrame,JPanel previousPanel) {
		this.mainFrame=mainFrame;
		this.previousPanel=previousPanel;
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
		home.setBounds(16 * X / 20, Y * 10 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> home());
		bgLabel.add(home);

		JButton back = new JButton("返回");
		back.setForeground(Color.WHITE);
		/*
		 * ImageIcon backIcon = new ImageIcon(new
		 * ImageIcon("Image/homeIcon.png") .getImage().getScaledInstance(X / 25,
		 * X / 25, Image.SCALE_SMOOTH));
		 */
		back.setBounds(17 * X / 20, Y * 10 / 768, X / 25, X / 25);
		// back.setIcon(backIcon);
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.addActionListener(e -> back());
		bgLabel.add(back);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon(
				"Image/minimizeIcon.png").getImage().getScaledInstance(X / 25,
				X / 25, Image.SCALE_SMOOTH));
		minimize.setBounds(18 * X / 20, Y * 10 / 768, X / 25, X / 25);
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
		close.setBounds(19 * X / 20, Y * 10 / 768, X / 25, X / 25);
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

		JTextField keytF = new JTextField();
		keytF.setBounds(X * 650 / 1366, Y * 50 / 768, X * 400 / 1366,
				Y * 27 / 768);
		keytF.setVisible(true);
		bgLabel.add(keytF);

		JButton searchbtn = new JButton("搜索");
		searchbtn.setBounds(X * 1080 / 1366, Y * 50 / 768, X * 60 / 1366,
				Y * 27 / 768);
		searchbtn.addActionListener(e -> searchPlayer(keytF.getText(), "All"));
		searchbtn.setVisible(true);
		bgLabel.add(searchbtn);

		JButton AButton = new MyButton("A");
		AButton.setBounds(X * 215 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		AButton.addActionListener(e -> searchPlayer(keytF.getText(), "A"));
		AButton.setOpaque(false);
		AButton.setVisible(true);
		bgLabel.add(AButton);
		JButton BButton = new MyButton("B");
		BButton.setBounds(X * 248 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		BButton.addActionListener(e -> searchPlayer(keytF.getText(), "B"));
		BButton.setOpaque(false);
		BButton.setVisible(true);
		bgLabel.add(BButton);
		JButton CButton = new MyButton("C");
		CButton.setBounds(X * 281 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		CButton.addActionListener(e -> searchPlayer(keytF.getText(), "C"));
		CButton.setOpaque(false);
		CButton.setVisible(true);
		bgLabel.add(CButton);
		JButton DButton = new MyButton("D");
		DButton.setBounds(X * 314 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		DButton.addActionListener(e -> searchPlayer(keytF.getText(), "D"));
		DButton.setOpaque(false);
		DButton.setVisible(true);
		bgLabel.add(DButton);
		JButton EButton = new MyButton("E");
		EButton.setBounds(X * 347 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		EButton.addActionListener(e -> searchPlayer(keytF.getText(), "E"));
		EButton.setOpaque(false);
		EButton.setVisible(true);
		bgLabel.add(EButton);
		JButton FButton = new MyButton("F");
		FButton.setBounds(X * 380 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		FButton.addActionListener(e -> searchPlayer(keytF.getText(), "F"));
		FButton.setOpaque(false);
		FButton.setVisible(true);
		bgLabel.add(FButton);
		JButton GButton = new MyButton("G");
		GButton.setBounds(X * 413 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		GButton.addActionListener(e -> searchPlayer(keytF.getText(), "G"));
		GButton.setOpaque(false);
		GButton.setVisible(true);
		bgLabel.add(GButton);
		JButton HButton = new MyButton("H");
		HButton.setBounds(X * 446 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		HButton.addActionListener(e -> searchPlayer(keytF.getText(), "H"));
		HButton.setOpaque(false);
		HButton.setVisible(true);
		bgLabel.add(HButton);
		JButton IButton = new MyButton("I");
		IButton.setBounds(X * 479 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		IButton.addActionListener(e -> searchPlayer(keytF.getText(), "I"));
		IButton.setOpaque(false);
		IButton.setVisible(true);
		bgLabel.add(IButton);
		JButton JButton = new MyButton("G");
		JButton.setBounds(X * 512 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		JButton.addActionListener(e -> searchPlayer(keytF.getText(), "J"));
		JButton.setOpaque(false);
		JButton.setVisible(true);
		bgLabel.add(JButton);
		JButton KButton = new MyButton("K");
		KButton.setBounds(X * 545 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		KButton.addActionListener(e -> searchPlayer(keytF.getText(), "K"));
		KButton.setOpaque(false);
		KButton.setVisible(true);
		bgLabel.add(KButton);
		JButton LButton = new MyButton("L");
		LButton.setBounds(X * 578 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		LButton.addActionListener(e -> searchPlayer(keytF.getText(), "L"));
		LButton.setOpaque(false);
		LButton.setVisible(true);
		bgLabel.add(LButton);
		JButton MButton = new MyButton("M");
		MButton.setBounds(X * 611 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		MButton.addActionListener(e -> searchPlayer(keytF.getText(), "M"));
		MButton.setOpaque(false);
		MButton.setVisible(true);
		bgLabel.add(MButton);
		JButton NButton = new MyButton("N");
		NButton.setBounds(X * 644 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		NButton.addActionListener(e -> searchPlayer(keytF.getText(), "N"));
		NButton.setOpaque(false);
		NButton.setVisible(true);
		bgLabel.add(NButton);
		JButton OButton = new MyButton("O");
		OButton.setBounds(X * 677 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		OButton.addActionListener(e -> searchPlayer(keytF.getText(), "O"));
		OButton.setOpaque(false);
		OButton.setVisible(true);
		bgLabel.add(OButton);
		JButton PButton = new MyButton("P");
		PButton.setBounds(X * 710 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		PButton.addActionListener(e -> searchPlayer(keytF.getText(), "P"));
		PButton.setOpaque(false);
		PButton.setVisible(true);
		bgLabel.add(PButton);
		JButton QButton = new MyButton("Q");
		QButton.setBounds(X * 743 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		QButton.addActionListener(e -> searchPlayer(keytF.getText(), "Q"));
		QButton.setOpaque(false);
		QButton.setVisible(true);
		bgLabel.add(QButton);
		JButton RButton = new MyButton("R");
		RButton.setBounds(X * 776 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		RButton.addActionListener(e -> searchPlayer(keytF.getText(), "R"));
		RButton.setOpaque(false);
		RButton.setVisible(true);
		bgLabel.add(RButton);
		JButton SButton = new MyButton("S");
		SButton.setBounds(X * 809 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		SButton.addActionListener(e -> searchPlayer(keytF.getText(), "S"));
		SButton.setOpaque(false);
		SButton.setVisible(true);
		bgLabel.add(SButton);
		JButton TButton = new MyButton("T");
		TButton.setBounds(X * 842 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		TButton.addActionListener(e -> searchPlayer(keytF.getText(), "T"));
		TButton.setOpaque(false);
		TButton.setVisible(true);
		bgLabel.add(TButton);
		JButton UButton = new MyButton("U");
		UButton.setBounds(X * 875 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		UButton.addActionListener(e -> searchPlayer(keytF.getText(), "U"));
		UButton.setOpaque(false);
		UButton.setVisible(true);
		bgLabel.add(UButton);
		JButton VButton = new MyButton("V");
		VButton.setBounds(X * 908 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		VButton.addActionListener(e -> searchPlayer(keytF.getText(), "V"));
		VButton.setOpaque(false);
		VButton.setVisible(true);
		bgLabel.add(VButton);
		JButton WButton = new MyButton("W");
		WButton.setBounds(X * 941 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		WButton.addActionListener(e -> searchPlayer(keytF.getText(), "W"));
		WButton.setOpaque(false);
		WButton.setVisible(true);
		bgLabel.add(WButton);
		JButton XButton = new MyButton("X");
		XButton.setBounds(X * 974 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		XButton.addActionListener(e -> searchPlayer(keytF.getText(), "X"));
		XButton.setOpaque(false);
		XButton.setVisible(true);
		bgLabel.add(XButton);
		JButton YButton = new MyButton("Y");
		YButton.setBounds(X * 1007 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		YButton.addActionListener(e -> searchPlayer(keytF.getText(), "Y"));
		YButton.setOpaque(false);
		YButton.setVisible(true);
		bgLabel.add(YButton);
		JButton ZButton = new MyButton("Z");
		ZButton.setBounds(X * 1040 / 1366, Y * 87 / 768, X * 33 / 1366,
				Y * 33 / 768);
		ZButton.addActionListener(e -> searchPlayer(keytF.getText(), "Z"));
		ZButton.setOpaque(false);
		ZButton.setVisible(true);
		bgLabel.add(ZButton);
		JButton AllButton = new MyButton("All");
		AllButton.setBounds(X * 1073 / 1366, Y * 87 / 768, X * 70 / 1366,
				Y * 33 / 768);
		AllButton.addActionListener(e -> searchPlayer(keytF.getText(), "All"));
		AllButton.setOpaque(false);
		AllButton.setVisible(true);
		bgLabel.add(AllButton);

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		playerVos = player_BS.getAllPlayer();
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
		bgLabel.add(scrollPane);

	}
	public void home() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame);
		mainFrame.getContentPane().add(sp);
		// playerCriteriaPanel.setVisible(false);
	}

	public void back() {
		this.setVisible(false);
		previousPanel.setVisible(true);
		// playerCriteriaPanel.setVisible(false);
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
				PlayerInfoPanel a = new PlayerInfoPanel(renderer.getPlayerVo()
						.getName(), mainFrame);
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
			this.setFont(new Font("黑体", 1, 12));
			bgLabel.add(this);
		}
	}
}
