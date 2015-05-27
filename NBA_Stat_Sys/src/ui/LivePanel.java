package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import vo.GameVo;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

public class LivePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	JFrame mainFrame;
	
	private JTable table;
	private JScrollPane scrollPane;

	Game_BS game_BS = new Game_BL_Stub();

	Vector<Vector<GameCardPanel>> rowData;
	static int X;
	static int Y;

	JLabel bgLabel; 
	
//	private JButton leftButton;
//	private JButton rightButton;

	public LivePanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
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
		
		
		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		for(int i=0;i<10;i++){
		gameVos.add(game_BS.getAllGames().get(i));
		}
		if (rowData == null) {
			rowData = new Vector<Vector<GameCardPanel>>();
		} else {
			rowData.clear();
		}
		for (int i = 0; i < gameVos.size(); i++) {
			Vector<GameCardPanel> a = new Vector<GameCardPanel>();
			System.out.println(gameVos.get(i).getGuestTeam());
			a.add(new GameCardPanel(X, Y, gameVos.get(i)));
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
				.setCellRenderer(new GameCardRenderer());
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

	public void searchGameByDate(String startDate, String endDate) {

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		gameVos = game_BS.getGamesByDate(startDate,endDate);
		if (rowData == null) {
			rowData = new Vector<Vector<GameCardPanel>>();
		} else {
			rowData.clear();
		}
		for (int i = 0; i < gameVos.size(); i++) {
			Vector<GameCardPanel> a = new Vector<GameCardPanel>();
			System.out.println(gameVos.get(i).getGuestTeam());
			a.add(new GameCardPanel(X, Y, gameVos.get(i)));
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
				.setCellRenderer(new GameCardRenderer());
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

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame,MainFrame.livePanel,MainFrame.playerPanel,MainFrame.teamPanel,MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel="StartPanel";

	}

	public void refresh(){
		mainFrame.remove(this);
		MainFrame.livePanel=new LivePanel(mainFrame);
		if(MainFrame.currentPanel.equals("LivePanel")){
			MainFrame.livePanel.setVisible(true);
		}else{
			MainFrame.livePanel.setVisible(false);
		}
	}
	
	
	public void selfClose(){
		this.setVisible(false);
	}
	// class: TableRenderer
	class GameCardRenderer implements TableCellRenderer {

			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus, int row,
					int column) {
				// TODO Auto-generated method stub
				GameCardPanel renderer = new GameCardPanel(X,
						Y, ((GameCardPanel) value).getGameVo());
				renderer.setOpaque(false);

				if (hasFocus) {
					
				MainFrame.liveInfoPanel= new LiveInfoPanel(renderer.getGameVo()
							,mainFrame,MainFrame.livePanel,"LivePanel");
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

}
