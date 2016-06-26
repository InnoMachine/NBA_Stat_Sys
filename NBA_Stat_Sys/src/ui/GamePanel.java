package ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import vo.GameVo;
import businessLogic.Game_BL;
import businessLogic.Game_BL_Stub;
import businessLogic.Game_BS;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	JFrame mainFrame;

	private JTable table;
	private JScrollPane scrollPane;

	Game_BS game_BS = new Game_BL_Stub();

	Vector<Vector<GameCardPanel>> rowData;
	static int X;
	static int Y;

	JLabel bgLabel;

	// private JButton leftButton;
	// private JButton rightButton;

	public GamePanel(JFrame mainFrame) {
		this.mainFrame = mainFrame;
		X = mainFrame.getWidth();
		Y = mainFrame.getHeight();
		this.setBounds(0, 0, X, Y);
		this.setVisible(true);
		this.setLayout(null);

		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		/*
		 * ImageIcon bg = new ImageIcon(new
		 * ImageIcon("Image/screeningPlayer.png")
		 * .getImage().getScaledInstance(this.getWidth(), this.getHeight(),
		 * Image.SCALE_SMOOTH)); bgLabel.setIcon(bg);
		 */
		bgLabel.setOpaque(false);
		this.add(bgLabel);
		this.setBackground(Color.BLACK);

		JButton home = new JButton();
		ImageIcon homeIcon = new ImageIcon(
				new ImageIcon("Image/homeIcon.png").getImage().getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
		home.setBounds(X * 1180 / 1366, Y * 20 / 768, X / 25, X / 25);
		home.setIcon(homeIcon);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.addActionListener(e -> back());
		bgLabel.add(home);

		JButton minimize = new JButton();
		ImageIcon minimizeIcon = new ImageIcon(new ImageIcon("Image/minimizeIcon.png").getImage()
				.getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
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
		bgLabel.add(minimize);

		JButton close = new JButton();
		ImageIcon closeIcon = new ImageIcon(
				new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(X / 25, X / 25, Image.SCALE_SMOOTH));
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
		bgLabel.add(close);

		mainFrame.getContentPane().add(this);

		MyLabel label = new MyLabel(Color.WHITE, "起始日期:");
		label.setFont(new Font("黑体", 1, 15));
		label.setBounds(X * 680 / 1366, Y * 100 / 768, X * 80 / 1366, Y * 40 / 768);
		bgLabel.add(label);

		DateChooserJButton startDate = new DateChooserJButton(X, Y);
		startDate.setBounds(X * 770 / 1366, Y * 100 / 768, X * 150 / 1366, Y * 40 / 768);
		ImageIcon buttonIcon = new ImageIcon(new ImageIcon("Image/mainButton.png").getImage()
				.getScaledInstance(X * 150 / 1366, Y * 40 / 768, Image.SCALE_SMOOTH));

		startDate.setIcon(buttonIcon);
		startDate.setVisible(true);
		startDate.setOpaque(false);
		startDate.setContentAreaFilled(false);
		startDate.setBorderPainted(false);
		startDate.setHorizontalTextPosition(SwingConstants.CENTER);
		startDate.setForeground(Color.WHITE);
		bgLabel.add(startDate);

		MyLabel label_1 = new MyLabel(Color.white, "结束日期:");
		label_1.setFont(new Font("黑体", 1, 15));
		label_1.setBounds(X * 950 / 1366, Y * 100 / 768, X * 80 / 1366, Y * 40 / 768);
		bgLabel.add(label_1);

		DateChooserJButton endDate = new DateChooserJButton(X, Y);
		endDate.setBounds(X * 1040 / 1366, Y * 100 / 768, X * 150 / 1366, Y * 40 / 768);
		endDate.setVisible(true);
		endDate.setIcon(buttonIcon);
		endDate.setOpaque(false);
		endDate.setContentAreaFilled(false);
		endDate.setBorderPainted(false);
		endDate.setHorizontalTextPosition(SwingConstants.CENTER);
		endDate.setForeground(Color.WHITE);
		bgLabel.add(endDate);

		JButton searchbtn = new JButton("搜索");
		searchbtn.setFont(new Font("黑体", 1, 15));
		searchbtn.setBounds(X * 1220 / 1366, Y * 100 / 768, X * 80 / 1366, Y * 40 / 768);
		searchbtn.addActionListener(e -> searchGameByDate(startDate.getText(), endDate.getText()));
		searchbtn.setVisible(true);
		searchbtn.setIcon(buttonIcon);
		searchbtn.setOpaque(false);
		searchbtn.setContentAreaFilled(false);
		searchbtn.setBorderPainted(false);
		searchbtn.setHorizontalTextPosition(SwingConstants.CENTER);
		searchbtn.setForeground(Color.WHITE);
		bgLabel.add(searchbtn);
		/*
		 * leftButton=new JButton(); leftButton.setBounds(50, 500,100,100);
		 * ImageIcon leftButtonIcon=new ImageIcon(new ImageIcon(
		 * "Image/leftButtonIcon.png").getImage().getScaledInstance(100, 100,
		 * Image.SCALE_SMOOTH)); leftButton.setIcon(leftButtonIcon);
		 * leftButton.setBorderPainted(false); leftButton.setOpaque(false);
		 * leftButton.setContentAreaFilled(false);
		 * leftButton.addActionListener(e->{
		 * 
		 * }); bgLabel.add(leftButton);
		 * 
		 * rightButton=new JButton(); rightButton.setBounds(1200, 500, 100,100);
		 * ImageIcon rightButtonIcon=new ImageIcon(new ImageIcon(
		 * "Image/rightButtonIcon.png").getImage().getScaledInstance(100, 100,
		 * Image.SCALE_SMOOTH)); rightButton.setIcon(rightButtonIcon);
		 * rightButton.setBorderPainted(false); rightButton.setOpaque(false);
		 * rightButton.setContentAreaFilled(false);
		 * rightButton.addActionListener(e->{
		 * 
		 * }); bgLabel.add(rightButton);
		 */
		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		for (int i = 0; i < 10; i++) {
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
		table.getColumnModel().getColumn(0).setCellRenderer(new GameCardRenderer());
		table.setOpaque(false);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 630 / 1366, Y * 150 / 768, X * 700 / 1366, Y * 600 / 768);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		bgLabel.add(scrollPane);

		mainFrame.getContentPane().add(this);

		// for videos
		MyLabel news = new MyLabel(Color.WHITE, "最新赛事");
		news.setFont(new Font("黑体", 1, 30));
		news.setBounds(X * 50 / 1366, Y * 100 / 768, X * 120 / 1366, Y * 40 / 768);
		bgLabel.add(news);

		JLabel new1 = new JLabel("骑士vs勇士G7 詹皇三双获FMVP夺队史首冠");
		new1.setForeground(Color.LIGHT_GRAY);
		new1.setFont(new Font("黑体", 1, 20));
		new1.setBounds(X * 50 / 1366, Y * 150 / 768, X * 570 / 1366, Y * 25 / 768);
		new1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new1.setText("<HTML><U>骑士vs勇士G7 詹皇三双获FMVP夺队史首冠</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new1.setText("骑士vs勇士G7 詹皇三双获FMVP夺队史首冠");
			}

		});
		bgLabel.add(new1);
		
		
		
		JLabel new2 = new JLabel("热火89-116猛龙 韦德无力回天猛龙挺进东决");
		new2.setForeground(Color.LIGHT_GRAY);
		new2.setFont(new Font("黑体", 1, 20));
		new2.setBounds(X * 50 / 1366, Y * 180 / 768, X * 570 / 1366, Y * 25 / 768);
		new2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/023765.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new2.setText("<HTML><U>热火89-116猛龙 韦德无力回天猛龙挺进东决</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new2.setText("热火89-116猛龙 韦德无力回天猛龙挺进东决");
			}

		});
		bgLabel.add(new2);
		
		
		JLabel new3 = new JLabel("猛龙91-103热火 热火频送排球大帽双方大比分战平");
		new3.setForeground(Color.LIGHT_GRAY);
		new3.setFont(new Font("黑体", 1, 20));
		new3.setBounds(X * 50 / 1366, Y * 210 / 768, X * 570 / 1366, Y * 25 / 768);
		new3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160514/022187.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new3.setText("<HTML><U>猛龙91-103热火 热火频送排球大帽双方大比分战平</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new3.setText("猛龙91-103热火 热火频送排球大帽双方大比分战平");
			}

		});
		bgLabel.add(new3);
		
		
		
		
		JLabel new4 = new JLabel("勇士vs骑士G6 詹姆斯再砍41分库里6犯毕业");
		new4.setForeground(Color.LIGHT_GRAY);
		new4.setFont(new Font("黑体", 1, 20));
		new4.setBounds(X * 50 / 1366, Y * 240 / 768, X * 570 / 1366, Y * 25 / 768);
		new4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new4.setText("<HTML><U>勇士vs骑士G6 詹姆斯再砍41分库里6犯毕业</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new4.setText("勇士vs骑士G6 詹姆斯再砍41分库里6犯毕业");
			}

		});
		bgLabel.add(new4);
		
		
		
		JLabel new5 = new JLabel("骑士vs勇士G5 詹姆斯惊天追帽FMVP");
		new5.setForeground(Color.LIGHT_GRAY);
		new5.setFont(new Font("黑体", 1, 20));
		new5.setBounds(X * 50 / 1366, Y * 270 / 768, X * 570 / 1366, Y * 25 / 768);
		new5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new5.setText("<HTML><U>骑士vs勇士G5 詹姆斯惊天追帽FMVP</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new5.setText("骑士vs勇士G5 詹姆斯惊天追帽FMVP");
			}

		});
		bgLabel.add(new5);
		
		
		
		
		JLabel new6 = new JLabel("勇士vs骑士G4 格林遭胯下之辱库里詹皇对喷");
		new6.setForeground(Color.LIGHT_GRAY);
		new6.setFont(new Font("黑体", 1, 20));
		new6.setBounds(X * 50 / 1366, Y * 300 / 768, X * 570 / 1366, Y * 25 / 768);
		new6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new6.setText("<HTML><U>勇士vs骑士G4 格林遭胯下之辱库里詹皇对喷</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new6.setText("勇士vs骑士G4 格林遭胯下之辱库里詹皇对喷");
			}

		});
		bgLabel.add(new6);
		
		
		
		
		JLabel new7 = new JLabel("勇士vs骑士G3 詹姆斯平筐空接技惊四座");
		new7.setForeground(Color.LIGHT_GRAY);
		new7.setFont(new Font("黑体", 1, 20));
		new7.setBounds(X * 50 / 1366, Y * 330 / 768, X * 570 / 1366, Y * 25 / 768);
		new7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new7.setText("<HTML><U>勇士vs骑士G3 詹姆斯平筐空接技惊四座</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new7.setText("勇士vs骑士G3 詹姆斯平筐空接技惊四座");
			}

		});
		bgLabel.add(new7);
		
		
		
		
		JLabel new8 = new JLabel("骑士vs勇士G1 库里化身魔术师助攻一哥暴扣");
		new8.setForeground(Color.LIGHT_GRAY);
		new8.setFont(new Font("黑体", 1, 20));
		new8.setBounds(X * 50 / 1366, Y * 360 / 768, X * 570 / 1366, Y * 25 / 768);
		new8.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://sports.qq.com/nbavideo/cxmatch/");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                new8.setText("<HTML><U>骑士vs勇士G1 库里化身魔术师助攻一哥暴扣</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				new8.setText("骑士vs勇士G1 库里化身魔术师助攻一哥暴扣");
			}

		});
		bgLabel.add(new8);
		
		
		
		
		MyLabel classics = new MyLabel(Color.WHITE, "精彩集锦");
		classics.setFont(new Font("黑体", 1, 30));
		classics.setBounds(X * 50 / 1366, Y * 434 / 768, X * 120 / 1366, Y * 40 / 768);
		bgLabel.add(classics);

		
		

		JLabel classic1 = new JLabel("16日五佳球 比永博两度虐筐韦德无限变向");
		classic1.setForeground(Color.LIGHT_GRAY);
		classic1.setFont(new Font("黑体", 1, 20));
		classic1.setBounds(X * 50 / 1366, Y * 484 / 768, X * 570 / 1366, Y * 25 / 768);
		classic1.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/030461.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic1.setText("<HTML><U>16日五佳球 比永博两度虐筐韦德无限变向/U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic1.setText("16日五佳球 比永博两度虐筐韦德无限变向");
			}

		});
		bgLabel.add(classic1);
		
		
		
		JLabel classic2 = new JLabel("16日最佳扣篮 比永博飞身腾空挂筐怒扣");
		classic2.setForeground(Color.LIGHT_GRAY);
		classic2.setFont(new Font("黑体", 1, 20));
		classic2.setBounds(X * 50 / 1366, Y * 514 / 768, X * 570 / 1366, Y * 25 / 768);
		classic2.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/030219.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic2.setText("<HTML><U>16日最佳扣篮 比永博飞身腾空挂筐怒扣</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic2.setText("16日最佳扣篮 比永博飞身腾空挂筐怒扣");
			}

		});
		bgLabel.add(classic2);
		
		
		JLabel classic3 = new JLabel("16日最佳动作 韦德连续变向晃晕卡罗尔");
		classic3.setForeground(Color.LIGHT_GRAY);
		classic3.setFont(new Font("黑体", 1, 20));
		classic3.setBounds(X * 50 / 1366, Y * 544 / 768, X * 570 / 1366, Y * 25 / 768);
		classic3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/030219.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
                classic3.setText("<HTML><U>16日最佳动作 韦德连续变向晃晕卡罗尔</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic3.setText("16日最佳动作 韦德连续变向晃晕卡罗尔");
			}

		});
		bgLabel.add(classic3);
		
		
		
		
		JLabel classic4 = new JLabel("16日最佳快攻 洛瑞抢断快下助德罗赞拉杆");
		classic4.setForeground(Color.LIGHT_GRAY);
		classic4.setFont(new Font("黑体", 1, 20));
		classic4.setBounds(X * 50 / 1366, Y * 574 / 768, X * 570 / 1366, Y * 25 / 768);
		classic4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/029653.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic4.setText("<HTML><U>16日最佳快攻 洛瑞抢断快下助德罗赞拉杆</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic4.setText("16日最佳快攻 洛瑞抢断快下助德罗赞拉杆");
			}

		});
		bgLabel.add(classic4);
		
		
		
		JLabel classic5 = new JLabel("16日最佳助攻 约翰逊妙传温斯洛暴扣");
		classic5.setForeground(Color.LIGHT_GRAY);
		classic5.setFont(new Font("黑体", 1, 20));
		classic5.setBounds(X * 50 / 1366, Y * 604 / 768, X * 570 / 1366, Y * 25 / 768);
		classic5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160516/029142.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic5.setText("<HTML><U>16日最佳助攻 约翰逊妙传温斯洛暴扣</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic5.setText("16日最佳助攻 约翰逊妙传温斯洛暴扣");
			}

		});
		bgLabel.add(classic5);
		
		
		
		
		JLabel classic6 = new JLabel("14日五佳球 罗斯闪电劈扣&理查德森隔扣刚果悍将");
		classic6.setForeground(Color.LIGHT_GRAY);
		classic6.setFont(new Font("黑体", 1, 20));
		classic6.setBounds(X * 50 / 1366, Y * 634 / 768, X * 570 / 1366, Y * 25 / 768);
		classic6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160514/027639.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic6.setText("<HTML><U>14日五佳球 罗斯闪电劈扣&理查德森隔扣刚果悍将</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic6.setText("14日五佳球 罗斯闪电劈扣&理查德森隔扣刚果悍将");
			}

		});
		bgLabel.add(classic6);
		
		
		
		
		JLabel classic7 = new JLabel("14日最佳镜头 理查德森劈扣比永博震惊全场");
		classic7.setForeground(Color.LIGHT_GRAY);
		classic7.setFont(new Font("黑体", 1, 20));
		classic7.setBounds(X * 50 / 1366, Y * 664 / 768, X * 570 / 1366, Y * 25 / 768);
		classic7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160514/027569.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic7.setText("<HTML><U>14日最佳镜头 理查德森劈扣比永博震惊全场</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic7.setText("14日最佳镜头 理查德森劈扣比永博震惊全场");
			}

		});
		bgLabel.add(classic7);
		
		
		
		
		JLabel classic8 = new JLabel("14日最佳扣篮 T罗斯快下凶残战斧");
		classic8.setForeground(Color.LIGHT_GRAY);
		classic8.setFont(new Font("黑体", 1, 20));
		classic8.setBounds(X * 50 / 1366, Y * 694 / 768, X * 570 / 1366, Y * 25 / 768);
		classic8.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				URI uri;

				try {
					uri = new URI("http://nbachina.qq.com/a/20160514/027310.htm");

					Desktop dtp = Desktop.getDesktop();
					if (Desktop.isDesktopSupported() && dtp.isSupported(Desktop.Action.BROWSE)) {
						dtp.browse(uri);
					}
				} catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				classic8.setText("<HTML><U>14日最佳扣篮 T罗斯快下凶残战斧</U></HTML>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				classic8.setText("14日最佳扣篮 T罗斯快下凶残战斧");
			}

		});
		bgLabel.add(classic8);
		
		
		
		
		
		
	}

	public void searchGameByDate(String startDate, String endDate) {

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		gameVos = game_BS.getGamesByDate(startDate, endDate);
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
		table.getColumnModel().getColumn(0).setCellRenderer(new GameCardRenderer());
		table.setOpaque(false);
		if (scrollPane != null) {
			scrollPane.setVisible(false);
		}
		scrollPane = new JScrollPane(table);
		scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI(Color.LIGHT_GRAY, Color.GRAY));
		scrollPane.setBounds(X * 630 / 1366, Y * 150 / 768, X * 700 / 1366, Y * 600 / 768);
		scrollPane.setVisible(true);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setOpaque(false);
		bgLabel.add(scrollPane);

	}

	public void back() {
		this.setVisible(false);
		StartPanel sp = new StartPanel(mainFrame, MainFrame.analysisPanel, MainFrame.playerPanel, MainFrame.teamPanel,
				MainFrame.gamePanel);
		mainFrame.getContentPane().add(sp);
		MainFrame.currentPanel = "StartPanel";

	}

	public void refresh() {
		mainFrame.remove(this);
		MainFrame.gamePanel = new GamePanel(mainFrame);
		if (MainFrame.currentPanel.equals("GamePanel")) {
			MainFrame.gamePanel.setVisible(true);
		} else {
			MainFrame.gamePanel.setVisible(false);
		}
	}

	public void selfClose() {
		this.setVisible(false);
	}

	// class: TableRenderer
	class GameCardRenderer implements TableCellRenderer {

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// TODO Auto-generated method stub
			GameCardPanel renderer = new GameCardPanel(X, Y, ((GameCardPanel) value).getGameVo());
			renderer.setOpaque(false);

			if (hasFocus) {

				MainFrame.gameInfoPanel = new GameInfoPanel(renderer.getGameVo(), mainFrame, MainFrame.gamePanel,
						"GamePanel");
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
