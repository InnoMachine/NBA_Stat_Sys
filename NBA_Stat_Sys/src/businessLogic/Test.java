package businessLogic;

import po.PlayerPO;
import database.PlayerDao;
import database.PlayerDaoImpl;
import vo.PlayerVo;

public class Test {

	public static void main(String[] args) {
		/*Player_BS player_bs = new Player_BL();
		PlayerVo vo = player_bs.getPlayerByName("Nate Wolters");
		System.out.println(vo.getAge());*/
		PlayerDao playerdao = new PlayerDaoImpl();
		PlayerPO po =playerdao.getPlayerByName("Nate Wolters");
		System.out.println(po.getAge());
	}

}
