package businessLogic;

import java.util.ArrayList;

import vo.PlayerVo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public ArrayList<PlayerVo> getAllPlayer();
	public ArrayList<PlayerVo> sortPlayerBy(String option);
	public ArrayList<PlayerVo> filterPlayerBy(String position,String div,String option); 
	//option用vo里的名字哦
}
