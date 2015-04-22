package businessLogic;

import java.util.TimerTask;

import po.GameDate;

public class DataUpdate extends TimerTask{
	GameDate dateui;
	GameDate dateTrue;
	Data_Handler data_handler ;
	
	public DataUpdate(){
		dateTrue = new GameDate();
		data_handler = Data_Handler.getInstance();
		dateui = data_handler.getDateNow();
	}
	public void run() {
		dateTrue = data_handler.getDateNow();
		if(dateui.compareTo(dateTrue)!=0){
			data_handler.updateData();
		}
			
	}
	

}
