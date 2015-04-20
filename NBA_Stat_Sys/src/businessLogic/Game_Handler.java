package businessLogic;

import java.util.ArrayList;

import po.GameDate;
import vo.GameVo;
import vo.PlayerPerformanceInSingleGame;

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
		return null;
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

	public ArrayList<PlayerPerformanceInSingleGame> getGameByLabel(String label) {
		for(GameVo temp:listvo){
			if(temp.getGameLabel().equals(label)){
				ArrayList<PlayerPerformanceInSingleGame> list = new ArrayList<PlayerPerformanceInSingleGame>();
				for(PlayerPerformanceInSingleGame pp:temp.getGuestTP().getFirstList()){
					list.add(pp);
				}
				for(PlayerPerformanceInSingleGame pp:temp.getGuestTP().getOtherList()){
					list.add(pp);
				}
				for(PlayerPerformanceInSingleGame pp:temp.getHomeTP().getFirstList()){
					list.add(pp);
				}
				for(PlayerPerformanceInSingleGame pp:temp.getHomeTP().getOtherList()){
					list.add(pp);
				}
				return list;
			}
		}
		return null;
	}

	public PlayerPerformanceInSingleGame getPerformance(String label,
			String name) {
		ArrayList<PlayerPerformanceInSingleGame> list =getGameByLabel(label);
		for(PlayerPerformanceInSingleGame temp:list){
			if(temp.getName().equals(name)){
				return temp;
			}
		}
		return null;
	}
}

