package businessLogic;

import po.Division;
import vo.PlayerVo;

public interface Player_BS {
	public PlayerVo getPlayerByName(String name);
	public PlayerVo[] getAllPlayer();
	public PlayerVo[] sortPlayerBy(String option);
	public PlayerVo[] filterPlayerBy(String position,Division div,String option); 
}
