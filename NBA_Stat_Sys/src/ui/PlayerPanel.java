package ui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import businessLogic.Player_BL;
import businessLogic.Player_BS;
import vo.PlayerVo;

public class PlayerPanel extends JPanel{	

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		static SearchPanel searchPlayerPanel;
		static SortPanel sortPlayerPanel;
		static SearchPanel searchTeamPanel;
		static ScreeningPlayerPanel screeningPlayerPanel;
		
		JFrame mainFrame;
		private String[] positions;
		private String[] leagues;
		private JTable table;
		private JScrollPane scrollPane;
		JComboBox<String> positionjcb;
		JComboBox<String> leaguejcb;
	
		Player_BS player_BS = new Player_BL();
		private JButton screeningCriteriabtn;
		Vector<Vector<PlayerCardPanel>> rowData;
		static int X;
		static int Y;
		JLabel bgLabel;

		public PlayerPanel(JFrame mainFrame) {
			this.mainFrame = mainFrame;
//			X = mainFrame.getWidth();
//			Y = mainFrame.getHeight();
            X=800;
            Y=490;
			this.setBounds(0, 0, X, Y);
			this.setVisible(true);
			this.setLayout(null);
/*
			bgLabel = new JLabel();
			bgLabel.setBounds(10, -10, X, Y);
			ImageIcon bg = new ImageIcon(new ImageIcon("Image/screeningPlayer.png")
					.getImage().getScaledInstance(this.getWidth(),
							this.getHeight(), Image.SCALE_SMOOTH));
			bgLabel.setIcon(bg);
			this.add(bgLabel);
*/
			JButton home= new JButton();
			ImageIcon homeIcon=new ImageIcon(new ImageIcon("Image/homeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
			home.setBounds(17*X/20,Y/18, X/25,X/25);
			home.setIcon(homeIcon);
			home.setOpaque(false);
			home.setContentAreaFilled(false);
			home.setBorderPainted(false);
			home.addActionListener(e -> back());
//			bgLabel.add(home);
			this.add(home);
			
			JButton minimize = new JButton();
			ImageIcon minimizeIcon=new ImageIcon(new ImageIcon("Image/minimizeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
			minimize.setBounds(18*X/20,Y/18, X/25,X/25);
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
//			bgLabel.add(minimize);
            this.add(minimize);
			
			JButton close = new JButton();
			ImageIcon closeIcon=new ImageIcon(new ImageIcon("Image/closeIcon.png").getImage().getScaledInstance(X/25,X/25 , Image.SCALE_SMOOTH));
			close.setBounds(19*X/20,Y/18, X/25,X/25);
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
//			bgLabel.add(close);
			this.add(close);
			
			JButton searchPlayerbtn = new JButton("球员搜索");
			searchPlayerbtn.setBounds(670, 125, 93, 23);
			searchPlayerbtn.addActionListener(e -> toSearchPlayerPanel());
			add(searchPlayerbtn);
			
			JButton inquiryPlayerbtn = new JButton("球员查看");
			inquiryPlayerbtn.setBounds(670, 205, 93, 23);
			inquiryPlayerbtn.addActionListener(e -> toInquiryPlayerPanel());
			add(inquiryPlayerbtn);
			
			JButton sortPlayerbtn = new JButton("球员排序");
			sortPlayerbtn.setBounds(670, 285, 93, 23);
			sortPlayerbtn.addActionListener(e -> toSortPlayerPanel());
			add(sortPlayerbtn);
			
			JButton screeningPlayerbtn = new JButton("球员筛选");
			screeningPlayerbtn.setBounds(670, 365, 93, 23);
			screeningPlayerbtn.addActionListener(e -> toScreeningPlayerPanel());
			add(screeningPlayerbtn);		
			
			JLabel label = new JLabel("热点球员");
			label.setBounds(53, 75, 60, 15);
			add(label);
			
			JLabel label_1 = new JLabel("进步最快球员");
			label_1.setBounds(53, 269, 80, 15);
			add(label_1);
			
			JButton dailyDatabtn = new JButton("每日");
			dailyDatabtn.setFont(new Font("宋体", Font.PLAIN, 12));
			dailyDatabtn.setBounds(405, 71, 60, 23);
			add(dailyDatabtn);
			
			JButton seasonDatabtn = new JButton("赛季");
			seasonDatabtn.setBounds(465, 71, 60, 23);
			add(seasonDatabtn);
			
			JButton dailyData_Scorebtn = new JButton("得分");
			dailyData_Scorebtn.setBounds(40, 100, 120, 23);
			add(dailyData_Scorebtn);
			
			JButton dailyData_Reboundbtn = new JButton("篮板");
			dailyData_Reboundbtn.setBounds(159, 100, 120, 23);
			add(dailyData_Reboundbtn);
			
			JButton dailyData_Assistancebtn = new JButton("助攻");
			dailyData_Assistancebtn.setBounds(278, 100, 120, 23);
			add(dailyData_Assistancebtn);
			
			JButton dailyData_Blockbtn = new JButton("盖帽");
			dailyData_Blockbtn.setBounds(397, 100, 120, 23);
			add(dailyData_Blockbtn);
			
			JButton dailyData_Stealbtn = new JButton("抢断");
			dailyData_Stealbtn.setBounds(516, 100, 120, 23);
			add(dailyData_Stealbtn);
			
			JButton seasonData_ScoreFieldbtn = new JButton("场均得分");
			seasonData_ScoreFieldbtn.setBounds(40, 294, 200, 23);
			add(seasonData_ScoreFieldbtn);
			
			JButton seasonData_ReboundFieldbtn = new JButton("场均篮板");
			seasonData_ReboundFieldbtn.setBounds(239, 294, 200, 23);
			add(seasonData_ReboundFieldbtn);
			
			JButton seasonData_AssistanceFieldbtn = new JButton("场均助攻");
			seasonData_AssistanceFieldbtn.setBounds(438, 294, 200, 23);
			add(seasonData_AssistanceFieldbtn);
			
			
			
			
				
			
		}
	
		public void toSearchPlayerPanel() {
		

		}
			
		public void toInquiryPlayerPanel() {
			this.setVisible(false);
			searchPlayerPanel = new SearchPanel("player", mainFrame);

		}
		
		public void toSortPlayerPanel() {
			this.setVisible(false);
			sortPlayerPanel = new SortPanel("player", mainFrame);

		}

		public void toScreeningPlayerPanel() {
			this.setVisible(false);
			screeningPlayerPanel = new ScreeningPlayerPanel(mainFrame);

		}
	
		public void back() {
			this.setVisible(false);
			StartPanel sp = new StartPanel(mainFrame);
			mainFrame.getContentPane().add(sp);
//			playerCriteriaPanel.setVisible(false);
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
