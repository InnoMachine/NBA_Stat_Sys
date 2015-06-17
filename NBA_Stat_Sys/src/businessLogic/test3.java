package businessLogic;

import java.awt.Component;

import javax.swing.JFrame;

import vo.chiquareout;

public class test3 {
	public static void main(String args[]){
		JFrame frame = new JFrame();
		TableGet tg = new TableGet();
		chiquareout co = tg.getChiquareout(1, "LAL", "14-15", "40");
		frame.add(co.cp);
	}
}
