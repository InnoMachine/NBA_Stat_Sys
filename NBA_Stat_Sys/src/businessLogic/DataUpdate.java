package businessLogic;

import java.util.TimerTask;

import po.GameDate;

public class DataUpdate extends TimerTask{
	GameDate dateui;
	GameDate dateTrue;
	Data_Handler data_handler ;
	
	public DataUpdate(GameDate dateui){
		this.dateui = dateui;
		dateTrue = new GameDate();
		dateTrue.setDay(3);
		data_handler = Data_Handler.getInstance();
	}
	public void run() {
		//dateTrue = getDateNow()
		if(dateui.compareTo(dateTrue)!=0){
			data_handler.updateData();
			System.out.println(dateTrue.toString());
			this.cancel();
		}
		else 
			System.out.println(dateui.toString());
			
	}
	

}
