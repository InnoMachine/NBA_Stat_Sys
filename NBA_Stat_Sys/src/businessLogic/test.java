package businessLogic;

import java.util.Timer;

import po.GameDate;

public class test {

	public static void main(String args[]){
		Timer timer = new Timer();
		GameDate date = new GameDate();
		DataUpdate du = new DataUpdate(date);
		timer.schedule(du, 1000,6000);
	}
}
