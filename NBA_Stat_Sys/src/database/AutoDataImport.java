package database;

import po.Conference;
import po.Division;
import po.GamePO;
import po.Scoreboard;
import po.TeamPO;
import po.TeamPerformance;

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
		game0.setGameLabel("gamelabeltest");
		game0.setGameDate("gamedatetest");
		game0.setVersus("CHA-LAC");
		game0.setGuestTeam("CHA");
		game0.setHomeTeam("LAC");
		game0.setScoreOverall(Scoreboard.makeSB("100-120"));
		game0.setScore1st(Scoreboard.makeSB("25-20"));
		game0.setScore2nd(Scoreboard.makeSB("26-40"));
		game0.setScore3rd(Scoreboard.makeSB("23-30"));
		game0.setScore4th(Scoreboard.makeSB("24-35"));
		
		String guesttp = "Anthony Tolliver;F;37:01;4;11;3;10;0;0;0;3;3;1;0;0;0;1;11;"+"\n"+
"Josh McRoberts;F;28:10;4;8;2;4;0;0;0;3;3;4;1;0;0;2;10;"+"\n"+
"Al Jefferson;C;30:00;7;15;0;0;0;0;1;11;12;4;1;0;3;0;14;"+"\n"+
"Gerald Henderson;G;32:19;3;11;0;1;6;6;0;0;0;1;0;0;0;3;12;"+"\n"+
"Kemba Walker;G;33:13;4;10;1;4;5;5;0;7;7;3;2;0;5;1;14;"+"\n"+
"Cody Zeller;;19:50;0;6;0;0;6;6;3;1;4;1;2;0;1;3;6;"+"\n"+
"Chris Douglas-Roberts;;17:26;1;1;0;0;0;0;1;1;2;0;0;0;2;0;2;"+"\n"+
"Ramon Sessions;;21:42;3;9;0;2;2;2;1;1;2;4;1;0;2;3;8;"+"\n"+
"Bismack Biyombo;;17:36;3;5;0;0;2;3;1;4;5;1;0;1;2;0;8;"+"\n"+
"Jannero Pargo;;2:43;0;0;0;0;0;0;0;0;0;0;0;0;1;0;0;";
		
		String hometp = "Jared Dudley;F;32:40;7;10;6;9;0;0;0;1;1;5;0;0;1;2;20;"+"\n"+
"Blake Griffin;F;38:07;14;20;1;2;2;4;2;10;12;2;0;0;4;4;31;"+"\n"+
"DeAndre Jordan;C;36:31;3;4;0;0;0;0;3;9;12;2;1;1;3;3;6;"+"\n"+
"Jamal Crawford;G;35:20;5;14;1;8;0;0;0;2;2;4;2;2;0;2;11;"+"\n"+
"Chris Paul;G;32:23;7;14;1;4;2;2;0;4;4;14;1;0;3;1;17;"+"\n"+
"Darren Collison;;16:08;3;3;0;0;2;2;1;2;3;5;5;0;0;2;8;"+"\n"+
"Matt Barnes;;19:32;2;10;0;6;0;0;1;4;5;2;0;0;0;2;4;"+"\n"+
"Antawn Jamison;;4:22;0;2;0;2;0;0;0;0;0;0;0;0;0;0;0;"+"\n"+
"Willie Green;;12:40;2;3;0;1;0;0;0;2;2;2;0;0;1;1;4;"+"\n"+
"Ryan Hollins;;10:55;2;3;0;0;1;2;1;2;3;0;0;0;1;3;5;"+"\n"+
"Byron Mullens;;1:22;2;2;2;2;0;0;0;0;0;0;0;0;0;0;6;";
		
		game0.setGuestTP(TeamPerformance.makeTP("CHA", guesttp));
		game0.setHomeTP(TeamPerformance.makeTP("LAC", hometp));
		GameDao gd = new GameDaoImpl();
		gd.add(game0);
		
		
	}

}
