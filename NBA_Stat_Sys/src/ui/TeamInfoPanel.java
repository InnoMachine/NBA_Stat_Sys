package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TeamInfoPanel extends JPanel{
	
	static int X;
	static int Y;
	JLabel bgLabel;
	
	private JTextField textField_67;
	private JTextField textField_74;
	private JTextField textField_75;
	private JTextField textField_76;
	private JTextField textField_77;
	private JTextField textField_78;
	private JTextField textField_79;
	private JTextField textField_80;
	private JTextField textField_81;
	private JTextField textField_82;
	private JTextField textField_83;
	private JTextField textField_84;
	private JTextField textField_85;
	private JTextField textField_86;
	private JTextField textField_87;
	private JTextField textField_88;
	private JTextField textField_89;
	private JTextField textField_90;
	private JTextField textField_91;
	private JTextField textField_92;
	private JTextField textField_93;
	private JTextField textField_94;
	private JTextField textField_95;
	private JTextField textField_96;
	private JTextField textField_97;
	private JTextField textField_98;
	private JTextField textField_99;
	private JTextField textField_100;
	private JTextField textField_101;
	private JTextField textField_102;
	private JTextField textField_103;
	private JTextField textField_104;
	private JTextField textField_105;
	private JTextField textField_106;
	private JTextField textField_107;
	private JTextField textField_108;
	private JTextField textField_109;
	private JTextField textField_110;
	private JTextField textField_111;
	private JTextField textField_112;
	private JTextField textField_113;
	private JTextField textField_114;
	private JTextField textField_115;
	private JTextField textField_116;
	private JTextField textField_117;
	private JTextField textField_118;
	private JTextField textField_119;
	private JTextField textField_120;
	private JTextField textField_121;
	private JTextField textField_122;
	private JTextField textField_123;
	private JTextField textField_124;
	private JTextField textField_125;
	private JTextField textField_126;
	private JTextField textField_127;
	private JTextField textField_128;
	private JTextField textField_129;
	private JTextField textField_130;
	private JTextField textField_131;
	private JTextField textField_132;
	private JTextField textField_133;
	private JTextField textField_134;
	private JTextField textField_135;
	private JTextField textField_136;
	private JTextField textField_137;
	private JTextField textField_138;
	
	private JLabel TeamBadge;
	
	public TeamInfoPanel(String abbr){
		this.setSize(500, 500);
		this.setVisible(true);
		this.setLayout(null);
		X = this.getWidth();
		Y = this.getHeight();

		ImageIcon bg;
		bgLabel = new JLabel();
		bgLabel.setBounds(0, 0, X, Y);
		this.add(bgLabel, new Integer(Integer.MIN_VALUE));
		bg = new ImageIcon(new ImageIcon("Image/searchPlayer.png").getImage()
				.getScaledInstance(this.getWidth(), this.getHeight(),
						Image.SCALE_SMOOTH));
		bgLabel.setIcon(bg);
		
		TeamBadge=new JLabel();
		TeamBadge.setOpaque(false);
//		TeamBadge.setBounds(x, y, width, height);
		ImageIcon portrait=new ImageIcon(new ImageIcon().getImage().getScaledInstance(TeamBadge.getWidth(), TeamBadge.getHeight(), Image.SCALE_SMOOTH));
		TeamBadge.setIcon(portrait);
		bgLabel.add(TeamBadge);
	}
	
	private void addTeamInfo(){
		int tempX = X * 190 / 1366;
		int tempY = 3 * Y / 10;
		int spaceX = X / 8;
		int spaceY = Y / 17;
		textField_67 = new MyTextField();
		textField_67.setHorizontalAlignment(SwingConstants.CENTER);
		textField_67.setText("球队全名");
		textField_67.setEditable(false);

		textField_67.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_67);
		textField_67.setColumns(10);

		textField_74 = new MyTextField();
		textField_74.setHorizontalAlignment(SwingConstants.CENTER);
		textField_74.setEditable(false);

		textField_74.setColumns(10);
		textField_74.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_74);

		textField_75 = new MyTextField();
		textField_75.setHorizontalAlignment(SwingConstants.CENTER);
		textField_75.setText("缩写");
		textField_75.setEditable(false);

		textField_75.setColumns(10);
		textField_75.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_75);

		textField_79 = new MyTextField();
		textField_79.setHorizontalAlignment(SwingConstants.CENTER);
		textField_79.setEditable(false);

		textField_79.setColumns(10);
		textField_79.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_79);

		textField_78 = new MyTextField();
		textField_78.setHorizontalAlignment(SwingConstants.CENTER);
		textField_78.setText("所在地");
		textField_78.setEditable(false);
		textField_78.setOpaque(false);
		textField_78.setColumns(10);
		textField_78.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_78);

		textField_76 = new MyTextField();
		textField_76.setHorizontalAlignment(SwingConstants.CENTER);
		textField_76.setEditable(false);

		textField_76.setColumns(10);
		textField_76.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_76);

		textField_77 = new MyTextField();
		textField_77.setHorizontalAlignment(SwingConstants.CENTER);
		textField_77.setText("赛区");
		textField_77.setEditable(false);
		textField_77.setColumns(10);
		textField_77.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_77);

		textField_80 = new MyTextField();
		textField_80.setHorizontalAlignment(SwingConstants.CENTER);
		textField_80.setEditable(false);
		textField_80.setColumns(10);
		textField_80.setBounds(tempX + spaceX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_80);

		textField_81 = new MyTextField();
		textField_81.setText("分区");
		textField_81.setHorizontalAlignment(SwingConstants.CENTER);
		textField_81.setEditable(false);
		textField_81.setColumns(10);
		textField_81.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_81);

		textField_82 = new MyTextField();
		textField_82.setHorizontalAlignment(SwingConstants.CENTER);
		textField_82.setEditable(false);
		textField_82.setColumns(10);
		textField_82.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_82);

		textField_83 = new MyTextField();
		textField_83.setText("主场");
		textField_83.setHorizontalAlignment(SwingConstants.CENTER);
		textField_83.setEditable(false);
		textField_83.setColumns(10);
		textField_83.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_83);

		textField_84 = new MyTextField();
		textField_84.setHorizontalAlignment(SwingConstants.CENTER);
		textField_84.setEditable(false);
		textField_84.setColumns(10);
		textField_84.setFont(new Font("黑体", 1, 10));
		textField_84.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_84);

		textField_85 = new MyTextField();
		textField_85.setText("建立时间");
		textField_85.setHorizontalAlignment(SwingConstants.CENTER);
		textField_85.setEditable(false);
		textField_85.setColumns(10);
		textField_85.setBounds(tempX, tempY + 2 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_85);

		textField_86 = new MyTextField();
		textField_86.setHorizontalAlignment(SwingConstants.CENTER);
		textField_86.setEditable(false);
		textField_86.setColumns(10);
		textField_86.setBounds(tempX + spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_86);

		textField_87 = new MyTextField();
		textField_87.setText("比赛场数");
		textField_87.setHorizontalAlignment(SwingConstants.CENTER);
		textField_87.setEditable(false);
		textField_87.setColumns(10);
		textField_87.setBounds(tempX + 2 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_87);

		textField_88 = new MyTextField();
		textField_88.setHorizontalAlignment(SwingConstants.CENTER);
		textField_88.setEditable(false);
		textField_88.setColumns(10);
		textField_88.setBounds(tempX + 3 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_88);

		textField_89 = new MyTextField();
		textField_89.setText("投篮命中数/场均");
		textField_89.setHorizontalAlignment(SwingConstants.CENTER);
		textField_89.setEditable(false);
		textField_89.setColumns(10);
		textField_89.setBounds(tempX + 4 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_89);

		textField_90 = new MyTextField();
		textField_90.setHorizontalAlignment(SwingConstants.CENTER);
		textField_90.setEditable(false);
		textField_90.setColumns(10);
		textField_90.setBounds(tempX + 5 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_90);

		textField_91 = new MyTextField();
		textField_91.setText("投篮出手数/场均");
		textField_91.setHorizontalAlignment(SwingConstants.CENTER);
		textField_91.setEditable(false);
		textField_91.setColumns(10);
		textField_91.setBounds(tempX, tempY + 3 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_91);

		textField_93 = new MyTextField();
		textField_93.setHorizontalAlignment(SwingConstants.CENTER);
		textField_93.setEditable(false);
		textField_93.setColumns(10);
		textField_93.setBounds(tempX + spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_93);

		textField_92 = new MyTextField();
		textField_92.setText("三分命中数/场均");
		textField_92.setHorizontalAlignment(SwingConstants.CENTER);
		textField_92.setEditable(false);
		textField_92.setColumns(10);
		textField_92.setBounds(tempX + 2 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_92);

		textField_94 = new MyTextField();
		textField_94.setHorizontalAlignment(SwingConstants.CENTER);
		textField_94.setEditable(false);
		textField_94.setColumns(10);
		textField_94.setBounds(tempX + 3 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_94);

		textField_95 = new MyTextField();
		textField_95.setText("三分出手数/场均");
		textField_95.setHorizontalAlignment(SwingConstants.CENTER);
		textField_95.setEditable(false);
		textField_95.setColumns(10);
		textField_95.setBounds(tempX + 4 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_95);

		textField_96 = new MyTextField();
		textField_96.setHorizontalAlignment(SwingConstants.CENTER);
		textField_96.setEditable(false);
		textField_96.setColumns(10);
		textField_96.setBounds(tempX + 5 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_96);

		textField_97 = new MyTextField();
		textField_97.setText("罚球命中数/场均");
		textField_97.setHorizontalAlignment(SwingConstants.CENTER);
		textField_97.setEditable(false);
		textField_97.setColumns(10);
		textField_97.setBounds(tempX, tempY + 4 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_97);

		textField_98 = new MyTextField();
		textField_98.setHorizontalAlignment(SwingConstants.CENTER);
		textField_98.setEditable(false);
		textField_98.setColumns(10);
		textField_98.setBounds(tempX + spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_98);

		textField_99 = new MyTextField();
		textField_99.setText("罚球出手数/场均");
		textField_99.setHorizontalAlignment(SwingConstants.CENTER);
		textField_99.setEditable(false);
		textField_99.setColumns(10);
		textField_99.setBounds(tempX + 2 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_99);

		textField_100 = new MyTextField();
		textField_100.setHorizontalAlignment(SwingConstants.CENTER);
		textField_100.setEditable(false);
		textField_100.setColumns(10);
		textField_100.setBounds(tempX + 3 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_100);

		textField_101 = new MyTextField();
		textField_101.setText("进攻篮板数/场均");
		textField_101.setHorizontalAlignment(SwingConstants.CENTER);
		textField_101.setEditable(false);
		textField_101.setColumns(10);
		textField_101.setBounds(tempX + 4 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_101);

		textField_102 = new MyTextField();
		textField_102.setHorizontalAlignment(SwingConstants.CENTER);
		textField_102.setEditable(false);
		textField_102.setColumns(10);
		textField_102.setBounds(tempX + 5 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_102);

		textField_103 = new MyTextField();
		textField_103.setText("防守篮板数/场均");
		textField_103.setHorizontalAlignment(SwingConstants.CENTER);
		textField_103.setEditable(false);
		textField_103.setColumns(10);
		textField_103.setBounds(tempX, tempY + 5 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_103);

		textField_104 = new MyTextField();
		textField_104.setHorizontalAlignment(SwingConstants.CENTER);
		textField_104.setEditable(false);
		textField_104.setColumns(10);
		textField_104.setBounds(tempX + spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_104);

		textField_105 = new MyTextField();
		textField_105.setText("篮板数/场均");
		textField_105.setHorizontalAlignment(SwingConstants.CENTER);
		textField_105.setEditable(false);
		textField_105.setColumns(10);
		textField_105.setBounds(tempX + 2 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_105);

		textField_106 = new MyTextField();
		textField_106.setHorizontalAlignment(SwingConstants.CENTER);
		textField_106.setEditable(false);
		textField_106.setColumns(10);
		textField_106.setBounds(tempX + 3 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_106);

		textField_107 = new MyTextField();
		textField_107.setText("助攻数/场均");
		textField_107.setHorizontalAlignment(SwingConstants.CENTER);
		textField_107.setEditable(false);
		textField_107.setColumns(10);
		textField_107.setBounds(tempX + 4 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_107);

		textField_108 = new MyTextField();
		textField_108.setHorizontalAlignment(SwingConstants.CENTER);
		textField_108.setEditable(false);
		textField_108.setColumns(10);
		textField_108.setBounds(tempX + 5 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_108);

		textField_109 = new MyTextField();
		textField_109.setText("抢断数/场均");
		textField_109.setHorizontalAlignment(SwingConstants.CENTER);
		textField_109.setEditable(false);
		textField_109.setColumns(10);
		textField_109.setBounds(tempX, tempY + 6 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_109);

		textField_110 = new MyTextField();
		textField_110.setHorizontalAlignment(SwingConstants.CENTER);
		textField_110.setEditable(false);
		textField_110.setColumns(10);
		textField_110.setBounds(tempX + spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_110);

		textField_111 = new MyTextField();
		textField_111.setText("盖帽数/场均");
		textField_111.setHorizontalAlignment(SwingConstants.CENTER);
		textField_111.setEditable(false);
		textField_111.setColumns(10);
		textField_111.setBounds(tempX + 2 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_111);

		textField_112 = new MyTextField();
		textField_112.setHorizontalAlignment(SwingConstants.CENTER);
		textField_112.setEditable(false);
		textField_112.setColumns(10);
		textField_112.setBounds(tempX + 3 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_112);

		textField_113 = new MyTextField();
		textField_113.setText("失误数/场均");
		textField_113.setHorizontalAlignment(SwingConstants.CENTER);
		textField_113.setEditable(false);
		textField_113.setColumns(10);
		textField_113.setBounds(tempX + 4 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_113);

		textField_114 = new MyTextField();
		textField_114.setHorizontalAlignment(SwingConstants.CENTER);
		textField_114.setEditable(false);
		textField_114.setColumns(10);
		textField_114.setBounds(tempX + 5 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_114);

		textField_115 = new MyTextField();
		textField_115.setText("犯规数/场均");
		textField_115.setHorizontalAlignment(SwingConstants.CENTER);
		textField_115.setEditable(false);
		textField_115.setColumns(10);
		textField_115.setBounds(tempX, tempY + 7 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_115);

		textField_116 = new MyTextField();
		textField_116.setHorizontalAlignment(SwingConstants.CENTER);
		textField_116.setEditable(false);
		textField_116.setColumns(10);
		textField_116.setBounds(tempX + spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_116);

		textField_117 = new MyTextField();
		textField_117.setText("比赛得分/场均");
		textField_117.setHorizontalAlignment(SwingConstants.CENTER);
		textField_117.setEditable(false);
		textField_117.setColumns(10);
		textField_117.setBounds(tempX + 2 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_117);

		textField_118 = new MyTextField();
		textField_118.setHorizontalAlignment(SwingConstants.CENTER);
		textField_118.setEditable(false);
		textField_118.setColumns(10);
		textField_118.setBounds(tempX + 3 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_118);

		textField_119 = new MyTextField();
		textField_119.setText("投篮命中率");
		textField_119.setHorizontalAlignment(SwingConstants.CENTER);
		textField_119.setEditable(false);
		textField_119.setColumns(10);
		textField_119.setBounds(tempX + 4 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_119);

		textField_120 = new MyTextField();
		textField_120.setHorizontalAlignment(SwingConstants.CENTER);
		textField_120.setEditable(false);
		textField_120.setColumns(10);
		textField_120.setBounds(tempX + 5 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_120);

		textField_121 = new MyTextField();
		textField_121.setText("三分命中率");
		textField_121.setHorizontalAlignment(SwingConstants.CENTER);
		textField_121.setEditable(false);
		textField_121.setColumns(10);
		textField_121.setBounds(tempX, tempY + 8 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_121);

		textField_122 = new MyTextField();
		textField_122.setHorizontalAlignment(SwingConstants.CENTER);
		textField_122.setEditable(false);
		textField_122.setColumns(10);
		textField_122.setBounds(tempX + spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_122);

		textField_123 = new MyTextField();
		textField_123.setText("罚球命中率");
		textField_123.setHorizontalAlignment(SwingConstants.CENTER);
		textField_123.setEditable(false);
		textField_123.setColumns(10);
		textField_123.setBounds(tempX + 2 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_123);

		textField_124 = new MyTextField();
		textField_124.setHorizontalAlignment(SwingConstants.CENTER);
		textField_124.setEditable(false);
		textField_124.setColumns(10);
		textField_124.setBounds(tempX + 3 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_124);

		textField_125 = new MyTextField();
		textField_125.setText("胜率");
		textField_125.setHorizontalAlignment(SwingConstants.CENTER);
		textField_125.setEditable(false);
		textField_125.setColumns(10);
		textField_125.setBounds(tempX + 4 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_125);

		textField_126 = new MyTextField();
		textField_126.setHorizontalAlignment(SwingConstants.CENTER);
		textField_126.setEditable(false);
		textField_126.setColumns(10);
		textField_126.setBounds(tempX + 5 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_126);

		textField_127 = new MyTextField();
		textField_127.setText("进攻回合");
		textField_127.setHorizontalAlignment(SwingConstants.CENTER);
		textField_127.setEditable(false);
		textField_127.setColumns(10);
		textField_127.setBounds(tempX, tempY + 9 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_127);

		textField_128 = new MyTextField();
		textField_128.setHorizontalAlignment(SwingConstants.CENTER);
		textField_128.setEditable(false);
		textField_128.setColumns(10);
		textField_128.setBounds(tempX + spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_128);

		textField_129 = new MyTextField();
		textField_129.setText("进攻效率");
		textField_129.setHorizontalAlignment(SwingConstants.CENTER);
		textField_129.setEditable(false);
		textField_129.setColumns(10);
		textField_129.setBounds(tempX + 2 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_129);

		textField_130 = new MyTextField();
		textField_130.setHorizontalAlignment(SwingConstants.CENTER);
		textField_130.setEditable(false);
		textField_130.setColumns(10);
		textField_130.setBounds(tempX + 3 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_130);

		textField_131 = new MyTextField();
		textField_131.setText("防守效率");
		textField_131.setHorizontalAlignment(SwingConstants.CENTER);
		textField_131.setEditable(false);
		textField_131.setColumns(10);
		textField_131.setBounds(tempX + 4 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_131);

		textField_132 = new MyTextField();
		textField_132.setHorizontalAlignment(SwingConstants.CENTER);
		textField_132.setEditable(false);
		textField_132.setColumns(10);
		textField_132.setBounds(tempX + 5 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_132);

		textField_133 = new MyTextField();
		textField_133.setText("篮板效率");
		textField_133.setHorizontalAlignment(SwingConstants.CENTER);
		textField_133.setEditable(false);
		textField_133.setColumns(10);
		textField_133.setBounds(tempX, tempY + 10 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_133);

		textField_134 = new MyTextField();
		textField_134.setHorizontalAlignment(SwingConstants.CENTER);
		textField_134.setEditable(false);
		textField_134.setColumns(10);
		textField_134.setBounds(tempX + spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_134);

		textField_135 = new MyTextField();
		textField_135.setText("抢断效率");
		textField_135.setHorizontalAlignment(SwingConstants.CENTER);
		textField_135.setEditable(false);
		textField_135.setColumns(10);
		textField_135.setBounds(tempX + 2 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_135);

		textField_136 = new MyTextField();
		textField_136.setHorizontalAlignment(SwingConstants.CENTER);
		textField_136.setEditable(false);
		textField_136.setColumns(10);
		textField_136.setBounds(tempX + 3 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_136);

		textField_137 = new MyTextField();
		textField_137.setText("助攻率");
		textField_137.setHorizontalAlignment(SwingConstants.CENTER);
		textField_137.setEditable(false);
		textField_137.setColumns(10);
		textField_137.setBounds(tempX + 4 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_137);

		textField_138 = new MyTextField();
		textField_138.setHorizontalAlignment(SwingConstants.CENTER);
		textField_138.setEditable(false);
		textField_138.setColumns(10);
		textField_138.setBounds(tempX + 5 * spaceX, tempY + 10 * spaceY,
				spaceX, spaceY);
		bgLabel.add(textField_138);
	}
	
	class MyTextField extends JTextField {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MyTextField() {
			super();
			this.setOpaque(false);
			this.setForeground(Color.WHITE);
			this.setFont(new Font("黑体", 1, 15));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
			this.setColumns(10);
			this.setEditable(false);
			this.setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
}
