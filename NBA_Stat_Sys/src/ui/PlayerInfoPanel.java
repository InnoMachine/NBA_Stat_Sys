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

import ui.ShowPanel.MyTextField;

public class PlayerInfoPanel extends JPanel {

	static int X;
	static int Y;
	JLabel bgLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_46;
	private JTextField textField_47;
	private JTextField textField_48;
	private JTextField textField_49;
	private JTextField textField_50;
	private JTextField textField_51;
	private JTextField textField_52;
	private JTextField textField_53;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_58;
	private JTextField textField_59;
	private JTextField textField_60;
	private JTextField textField_61;
	private JTextField textField_62;
	private JTextField textField_63;
	private JTextField textField_64;
	private JTextField textField_65;
	private JTextField textField_66;
	private JTextField textField_67;
	private JTextField textField_68;
	private JTextField textField_69;
	private JTextField textField_70;
	private JTextField textField_71;
	private JTextField textField_72;
	

	public PlayerInfoPanel(String PlayerName) {

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

	}

	private void addPlayerInfo() {
		
		int tempX = 2 * X / 11;
		int tempY = 27 * Y / 100;
		int spaceX = X / 10;
		int spaceY = Y / 18;

		textField_1 = new MyTextField();
		textField_1.setText("姓名");
		textField_1.setBounds(tempX, tempY, spaceX, spaceY);
		bgLabel.add(textField_1);

		textField_2 = new MyTextField();
		textField_2.setBounds(tempX + spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_2);

		textField_3 = new MyTextField();
		textField_3.setText("身高");
		textField_3.setBounds(tempX + 2 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_3);

		textField_4 = new MyTextField();
		textField_4.setBounds(tempX + 3 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_4);

		textField_5 = new MyTextField();
		textField_5.setText("生日");
		textField_5.setBounds(tempX + 4 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_5);

		textField_6 = new MyTextField();
		textField_6.setBounds(tempX + 5 * spaceX, tempY, spaceX, spaceY);
		bgLabel.add(textField_6);

		textField_7 = new MyTextField();
		textField_7.setText("位置");
		textField_7.setBounds(tempX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_7);

		textField_8 = new MyTextField();
		textField_8.setBounds(tempX + spaceX, tempY + spaceY, spaceX, spaceY);
		bgLabel.add(textField_8);

		textField_9 = new MyTextField();
		textField_9.setText("体重");
		textField_9.setBounds(tempX + 2 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_9);

		textField_10 = new MyTextField();
		textField_10.setBounds(tempX + 3 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_10);

		textField_11 = new MyTextField();
		textField_11.setText("球龄");
		textField_11.setBounds(tempX + 4 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_11);

		textField_12 = new MyTextField();
		textField_12.setBounds(tempX + 5 * spaceX, tempY + spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_12);

		textField_13 = new MyTextField();
		textField_13.setText("球衣号码");
		textField_13.setBounds(tempX, tempY + 2 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_13);

		textField_14 = new MyTextField();
		textField_14.setBounds(tempX + spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_14);

		textField_15 = new MyTextField();
		textField_15.setText("年龄");
		textField_15.setBounds(tempX + 2 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_15);

		textField_16 = new MyTextField();
		textField_16.setBounds(tempX + 3 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_16);

		textField_17 = new MyTextField();
		textField_17.setText("毕业院校");
		textField_17.setBounds(tempX + 4 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_17);

		textField_18 = new MyTextField();
		textField_18.setBounds(tempX + 5 * spaceX, tempY + 2 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_18);

		textField_19 = new MyTextField();
		textField_19.setText("参赛场数");
		textField_19.setBounds(tempX, tempY + 3 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_19);

		textField_20 = new MyTextField();
		textField_20.setBounds(tempX + spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_20);

		textField_21 = new MyTextField();
		textField_21.setText("先发场数");
		textField_21.setBounds(tempX + 2 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_21);

		textField_22 = new MyTextField();
		textField_22.setBounds(tempX + 3 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_22);

		textField_23 = new MyTextField();
		textField_23.setText("篮板数/场均");
		textField_23.setBounds(tempX + 4 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_23);

		textField_24 = new MyTextField();
		textField_24.setBounds(tempX + 5 * spaceX, tempY + 3 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_24);

		textField_25 = new MyTextField();
		textField_25.setText("助攻数/场均");
		textField_25.setBounds(tempX, tempY + 4 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_25);

		textField_26 = new MyTextField();
		textField_26.setBounds(tempX + spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_26);

		textField_27 = new MyTextField();
		textField_27.setText("在场时间/场均");
		textField_27.setBounds(tempX + 2 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_27);

		textField_28 = new MyTextField();
		textField_28.setBounds(tempX + 3 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_28);

		textField_29 = new MyTextField();
		textField_29.setText("投篮命中率");
		textField_29.setBounds(tempX + 4 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_29);

		textField_30 = new MyTextField();
		textField_30.setBounds(tempX + 5 * spaceX, tempY + 4 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_30);

		textField_31 = new MyTextField();
		textField_31.setText("三分命中率");
		textField_31.setBounds(tempX, tempY + 5 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_31);

		textField_32 = new MyTextField();
		textField_32.setBounds(tempX + spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_32);

		textField_33 = new MyTextField();
		textField_33.setText("罚球命中率");
		textField_33.setBounds(tempX + 2 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_33);

		textField_34 = new MyTextField();
		textField_34.setBounds(tempX + 3 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_34);

		textField_35 = new MyTextField();
		textField_35.setText("进攻数/场均");
		textField_35.setBounds(tempX + 4 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_35);

		textField_36 = new MyTextField();
		textField_36.setBounds(tempX + 5 * spaceX, tempY + 5 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_36);

		textField_37 = new MyTextField();
		textField_37.setText("防守数/场均");
		textField_37.setBounds(tempX, tempY + 6 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_37);

		textField_38 = new MyTextField();
		textField_38.setBounds(tempX + spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_38);

		textField_39 = new MyTextField();
		textField_39.setText("抢断数/场均");
		textField_39.setBounds(tempX + 2 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_39);

		textField_40 = new MyTextField();
		textField_40.setBounds(tempX + 3 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_40);

		textField_41 = new MyTextField();
		textField_41.setText("盖帽数/场均");
		textField_41.setBounds(tempX + 4 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_41);

		textField_42 = new MyTextField();
		textField_42.setBounds(tempX + 5 * spaceX, tempY + 6 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_42);

		textField_43 = new MyTextField();
		textField_43.setText("失误数/场均");
		textField_43.setBounds(tempX, tempY + 7 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_43);

		textField_44 = new MyTextField();
		textField_44.setBounds(tempX + spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_44);

		textField_45 = new MyTextField();
		textField_45.setText("犯规数/场均");
		textField_45.setBounds(tempX + 2 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_45);

		textField_46 = new MyTextField();
		textField_46.setBounds(tempX + 3 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_46);

		textField_47 = new MyTextField();
		textField_47.setText("得分/场均");
		textField_47.setBounds(tempX + 4 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_47);

		textField_48 = new MyTextField();
		textField_48.setBounds(tempX + 5 * spaceX, tempY + 7 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_48);

		textField_49 = new MyTextField();
		textField_49.setText("效率/场均");
		textField_49.setBounds(tempX, tempY + 8 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_49);

		textField_50 = new MyTextField();
		textField_50.setBounds(tempX + spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_50);

		textField_51 = new MyTextField();
		textField_51.setText("GmSc效率值/场均");
		textField_51.setBounds(tempX + 2 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_51);

		textField_52 = new MyTextField();
		textField_52.setBounds(tempX + 3 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_52);

		textField_53 = new MyTextField();
		textField_53.setText("真实命中率");
		textField_53.setBounds(tempX + 4 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_53);

		textField_54 = new MyTextField();
		textField_54.setBounds(tempX + 5 * spaceX, tempY + 8 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_54);

		textField_55 = new MyTextField();
		textField_55.setText("投篮效率");
		textField_55.setBounds(tempX, tempY + 9 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_55);

		textField_56 = new MyTextField();
		textField_56.setBounds(tempX + spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_56);

		textField_57 = new MyTextField();
		textField_57.setText("篮板率");
		textField_57.setBounds(tempX + 2 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_57);

		textField_58 = new MyTextField();
		textField_58.setBounds(tempX + 3 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_58);

		textField_59 = new MyTextField();
		textField_59.setText("进攻篮板率");
		textField_59.setBounds(tempX + 4 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_59);

		textField_60 = new MyTextField();
		textField_60.setBounds(tempX + 5 * spaceX, tempY + 9 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_60);

		textField_61 = new MyTextField();
		textField_61.setText("防守篮板率");
		textField_61.setBounds(tempX, tempY + 10 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_61);

		textField_62 = new MyTextField();
		textField_62.setBounds(tempX + spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_62);

		textField_63 = new MyTextField();
		textField_63.setText("助攻率");
		textField_63.setBounds(tempX + 2 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_63);

		textField_64 = new MyTextField();
		textField_64.setBounds(tempX + 3 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_64);

		textField_65 = new MyTextField();
		textField_65.setText("抢断率");
		textField_65.setBounds(tempX + 4 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_65);

		textField_66 = new MyTextField();
		textField_66.setBounds(tempX + 5 * spaceX, tempY + 10 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_66);

		textField_67 = new MyTextField();
		textField_67.setText("盖帽率");
		textField_67.setBounds(tempX, tempY + 11 * spaceY, spaceX, spaceY);
		bgLabel.add(textField_67);

		textField_68 = new MyTextField();
		textField_68.setBounds(tempX + spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_68);

		textField_69 = new MyTextField();
		textField_69.setText("失误率");
		textField_69.setBounds(tempX + 2 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_69);

		textField_70 = new MyTextField();
		textField_70.setBounds(tempX + 3 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_70);

		textField_71 = new MyTextField();
		textField_71.setText("使用率");
		textField_71.setBounds(tempX + 4 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_71);

		textField_72 = new MyTextField();
		textField_72.setBounds(tempX + 5 * spaceX, tempY + 11 * spaceY, spaceX,
				spaceY);
		bgLabel.add(textField_72);
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
