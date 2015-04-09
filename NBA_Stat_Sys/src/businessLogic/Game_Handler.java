package businessLogic;

import java.util.ArrayList;

import po.GameDate;
import vo.GameVo;

public class Game_Handler {
	private Data_Handler data_handler;
	private ArrayList<GameVo> listvo;
	public Game_Handler()
	{
		data_handler=Data_Handler.getInstance();
		listvo=data_handler.getAllGames();
	}
	
	public ArrayList<GameVo> getAllGames(){
		return listvo;
	}
	
	public ArrayList<GameVo> getGameDaily(){
		return listvo;
	}
	public ArrayList<GameVo> getGameByDate(String date){
		GameDate gdate = new GameDate(date);
		ArrayList<GameVo> templist =new ArrayList<GameVo>();
		for(GameVo temp:listvo)
		{
			if(gdate.compareTo(temp.getGameDate())==0)
			{
				templist.add(temp);
			}
		}
		return templist;
	}
}

