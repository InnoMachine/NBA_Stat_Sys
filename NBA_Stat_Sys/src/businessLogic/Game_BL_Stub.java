package businessLogic;

import java.util.ArrayList;

import po.Scoreboard;
import enums.Division;
import vo.GameVo;
import vo.PlayerVo;

public class Game_BL_Stub implements Game_BS {

	@Override
	public ArrayList<GameVo> getAllGames() {
		// TODO Auto-generated method stub

		Scoreboard scoreboard1 = new Scoreboard();
		scoreboard1.setGuestScore(19);
		scoreboard1.setHomeScore(21);
		Scoreboard scoreboard2 = new Scoreboard();
		scoreboard2.setGuestScore(76);
		scoreboard2.setHomeScore(84);

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		GameVo gameVo1 = new GameVo();
		gameVo1.setHomeTeam("BKN");
		gameVo1.setGuestTeam("CLE");
		gameVo1.setScore1st(scoreboard1);
		gameVo1.setScore2nd(scoreboard1);
		gameVo1.setScore3rd(scoreboard1);
		gameVo1.setScore4th(scoreboard1);
		gameVo1.setScoreOverall(scoreboard2);
		gameVos.add(gameVo1);
		GameVo gameVo2 = new GameVo();
		gameVo2.setHomeTeam("SAS");
		gameVo2.setGuestTeam("OKC");
		gameVo2.setScore1st(scoreboard1);
		gameVo2.setScore2nd(scoreboard1);
		gameVo2.setScore3rd(scoreboard1);
		gameVo2.setScore4th(scoreboard1);
		gameVo2.setScoreOverall(scoreboard2);
		gameVos.add(gameVo2);
		GameVo gameVo3 = new GameVo();
		gameVo3.setHomeTeam("MIA");
		gameVo3.setGuestTeam("CHI");
		gameVo3.setScore1st(scoreboard1);
		gameVo3.setScore2nd(scoreboard1);
		gameVo3.setScore3rd(scoreboard1);
		gameVo3.setScore4th(scoreboard1);
		gameVo3.setScoreOverall(scoreboard2);
		gameVos.add(gameVo3);
		GameVo gameVo4 = new GameVo();
		gameVo4.setHomeTeam("UTA");
		gameVo4.setGuestTeam("NYK");
		gameVo4.setScore1st(scoreboard1);
		gameVo4.setScore2nd(scoreboard1);
		gameVo4.setScore3rd(scoreboard1);
		gameVo4.setScore4th(scoreboard1);
		gameVo4.setScoreOverall(scoreboard2);
		gameVos.add(gameVo4);
		GameVo gameVo5 = new GameVo();
		gameVo5.setHomeTeam("LAL");
		gameVo5.setGuestTeam("MIL");
		gameVo5.setScore1st(scoreboard1);
		gameVo5.setScore2nd(scoreboard1);
		gameVo5.setScore3rd(scoreboard1);
		gameVo5.setScore4th(scoreboard1);
		gameVo5.setScoreOverall(scoreboard2);
		gameVos.add(gameVo5);
		GameVo gameVo6 = new GameVo();
		gameVo6.setHomeTeam("PHX");
		gameVo6.setGuestTeam("GSW");
		gameVo6.setScore1st(scoreboard1);
		gameVo6.setScore2nd(scoreboard1);
		gameVo6.setScore3rd(scoreboard1);
		gameVo6.setScore4th(scoreboard1);
		gameVo6.setScoreOverall(scoreboard2);
		gameVos.add(gameVo6);

		return gameVos;
	}

	@Override
	public ArrayList<GameVo> getGamesDaily() {
		// TODO Auto-generated method stub
		Scoreboard scoreboard1 = new Scoreboard();
		scoreboard1.setGuestScore(28);
		scoreboard1.setHomeScore(27);
		Scoreboard scoreboard2 = new Scoreboard();
		scoreboard2.setGuestScore(112);
		scoreboard2.setHomeScore(108);

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		GameVo gameVo1 = new GameVo();
		gameVo1.setHomeTeam("BKN");
		gameVo1.setGuestTeam("CLE");
		gameVo1.setScore1st(scoreboard1);
		gameVo1.setScore2nd(scoreboard1);
		gameVo1.setScore3rd(scoreboard1);
		gameVo1.setScore4th(scoreboard1);
		gameVo1.setScoreOverall(scoreboard2);
		gameVos.add(gameVo1);
		GameVo gameVo2 = new GameVo();
		gameVo2.setHomeTeam("SAS");
		gameVo2.setGuestTeam("OKC");
		gameVo2.setScore1st(scoreboard1);
		gameVo2.setScore2nd(scoreboard1);
		gameVo2.setScore3rd(scoreboard1);
		gameVo2.setScore4th(scoreboard1);
		gameVo2.setScoreOverall(scoreboard2);
		gameVos.add(gameVo2);
		return gameVos;
	}

	@Override
	public ArrayList<GameVo> getGamesByDate(String date) {
		// TODO Auto-generated method stub
		Scoreboard scoreboard1 = new Scoreboard();
		scoreboard1.setGuestScore(26);
		scoreboard1.setHomeScore(23);
		Scoreboard scoreboard2 = new Scoreboard();
		scoreboard2.setGuestScore(104);
		scoreboard2.setHomeScore(92);

		ArrayList<GameVo> gameVos = new ArrayList<GameVo>();
		GameVo gameVo1 = new GameVo();
		gameVo1.setHomeTeam("UTA");
		gameVo1.setGuestTeam("NYK");
		gameVo1.setScore1st(scoreboard1);
		gameVo1.setScore2nd(scoreboard1);
		gameVo1.setScore3rd(scoreboard1);
		gameVo1.setScore4th(scoreboard1);
		gameVo1.setScoreOverall(scoreboard2);
		gameVos.add(gameVo1);
		GameVo gameVo2 = new GameVo();
		gameVo2.setHomeTeam("LAL");
		gameVo2.setGuestTeam("MIL");
		gameVo2.setScore1st(scoreboard1);
		gameVo2.setScore2nd(scoreboard1);
		gameVo2.setScore3rd(scoreboard1);
		gameVo2.setScore4th(scoreboard1);
		gameVo2.setScoreOverall(scoreboard2);
		gameVos.add(gameVo2);
		GameVo gameVo3 = new GameVo();
		gameVo3.setHomeTeam("PHX");
		gameVo3.setGuestTeam("GSW");
		gameVo3.setScore1st(scoreboard1);
		gameVo3.setScore2nd(scoreboard1);
		gameVo3.setScore3rd(scoreboard1);
		gameVo3.setScore4th(scoreboard1);
		gameVo3.setScoreOverall(scoreboard2);
		gameVos.add(gameVo3);
		return gameVos;
	}

}
