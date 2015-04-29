package businessLogic;

import java.util.TimerTask;

import po.GameDate;
import ui.MainFrame;

public class DataUpdate extends TimerTask{
	GameDate dateui;
	GameDate dateTrue;
	Data_Handler data_handler ;
	MainFrame mf;
	
	public DataUpdate(){
		dateTrue = new GameDate();
		mf = new MainFrame();
		data_handler = Data_Handler.getInstance();
		dateui = data_handler.getDateNow();
	}
	public void run() {
		dateTrue = data_handler.getDateNow();
		System.out.println(dateTrue.toString());
		if(dateui.compareTo(dateTrue)!=0){
			data_handler.updateData();
		}
			
	}
	

}
