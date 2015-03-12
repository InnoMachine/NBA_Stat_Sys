package businessLogic;

import po.Division;
import vo.PlayerVo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public PlayerVo[] getAllPlayer();
	public PlayerVo[] sortPlayerBy(int option);
	public PlayerVo[] filterPlayerBy(String position,Division div,int option); 
}
