package database;

import po.Conference;
import po.Division;
import po.GamePO;
import po.PlayerPO;
import po.Scoreboard;
import po.TeamPO;
import po.TeamPerformance;

public class AutoDataImport {

	public static void main(String[] args) {

		PlayerDao pd = new PlayerDaoImpl();
		
		System.out.println(pd.getPlayerByName("Nate Wolters").getAge());
		
		
	}

}
