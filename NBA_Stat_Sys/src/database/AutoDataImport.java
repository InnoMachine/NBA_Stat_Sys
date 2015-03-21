package database;

import po.Conference;
import po.Division;
import po.GamePO;
import po.TeamPO;

public class AutoDataImport {

	public static void main(String[] args) {
		
		TeamPO team0 = new TeamPO();
		team0.setTeamName("Hawks");
		team0.setAbbreviation("ATL");
		team0.setCity("Atlanta");
		Conference conf = Conference.valueOf("E".toUpperCase());
		team0.setConference(conf);
		Division div = Division.valueOf("Southeast".toUpperCase());
		team0.setDivision(div);
		team0.setHomeField("Philips Arena");
		team0.setBirthYear("1949");
		team0.setImgPath("CSEdata/teams/"+"ATL"+".svg");
		//team0.setPlayers("jack,mike,tom.steve");
		//team0.setSeansonTeamPerformance("so much to go");
		TeamDao td = new TeamDaoImpl();
		td.add(team0);
		
		GamePO game0 = new GamePO();
		
		
	}

}
