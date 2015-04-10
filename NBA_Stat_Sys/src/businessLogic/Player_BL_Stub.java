package businessLogic;

import java.util.ArrayList;

import enums.Conference;
import enums.Division;
import vo.PlayerCardVo;
import vo.PlayerRecentGames;
import vo.PlayerVo;

public class Player_BL_Stub implements Player_BS {
	Player_Handler player_handler;

	public PlayerVo getPlayerByName(String name) {
		PlayerVo playerVo = new PlayerVo();
		playerVo.setName(name);
		playerVo.setAge(25);
		playerVo.setDivision(Division.ATLANTIC);
		playerVo.setNumber("19");
		return playerVo;
	}

	public ArrayList<PlayerVo> getAllPlayer() {
		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		PlayerVo playerVo1 = new PlayerVo();
		playerVo1.setName("Andre Miller");
		playerVo1.setAge(25);
		playerVo1.setDivision(Division.ATLANTIC);
		playerVo1.setNumber("19");
		playerVos.add(playerVo1);
		PlayerVo playerVo2 = new PlayerVo();
		playerVo2.setName("David Lee");
		playerVo2.setAge(24);
		playerVo2.setDivision(Division.SOUTHEAST);
		playerVo2.setNumber("6");
		playerVos.add(playerVo2);

		return playerVos;
	}

	public ArrayList<PlayerVo> sortPlayerBy(String option) {

		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		PlayerVo playerVo1 = new PlayerVo();
		playerVo1.setName("Andre Miller");
		playerVo1.setAge(25);
		playerVo1.setDivision(Division.ATLANTIC);
		playerVo1.setNumber("19");
		playerVos.add(playerVo1);
		PlayerVo playerVo2 = new PlayerVo();
		playerVo2.setName("David Lee");
		playerVo2.setAge(24);
		playerVo2.setDivision(Division.SOUTHEAST);
		playerVo2.setNumber("6");
		playerVos.add(playerVo2);

		return playerVos;
	}

	public ArrayList<PlayerVo> filterPlayerBy(String position, String div,
			String option) {
		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		PlayerVo playerVo1 = new PlayerVo();
		playerVo1.setName("Andre Miller");
		playerVo1.setAge(25);
		playerVo1.setDivision(Division.ATLANTIC);
		playerVo1.setNumber("19");
		playerVos.add(playerVo1);
		PlayerVo playerVo2 = new PlayerVo();
		playerVo2.setName("David Lee");
		playerVo2.setAge(24);
		playerVo2.setDivision(Division.SOUTHEAST);
		playerVo2.setNumber("6");
		playerVos.add(playerVo2);

		return playerVos;
	}

	public ArrayList<PlayerVo> getPlayersByTeam(String abbr) {
		ArrayList<PlayerVo> playerVos = new ArrayList<PlayerVo>();
		PlayerVo playerVo1 = new PlayerVo();
		playerVo1.setName("Andre Miller");
		playerVo1.setAge(25);
		playerVo1.setTeam(abbr);
		playerVo1.setDivision(Division.ATLANTIC);
		playerVo1.setNumber("19");
		playerVos.add(playerVo1);
		PlayerVo playerVo2 = new PlayerVo();
		playerVo2.setName("David Lee");
		playerVo2.setAge(24);
		playerVo2.setTeam(abbr);
		playerVo2.setDivision(Division.SOUTHEAST);
		playerVo2.setNumber("6");
		playerVos.add(playerVo2);

		return playerVos;

	}

	public ArrayList<PlayerCardVo> hotPlayerDaily(String option) {
		ArrayList<PlayerCardVo> playerCardVos = new ArrayList<PlayerCardVo>();
		if (option == "score") {

			PlayerCardVo playerCardVo1 = new PlayerCardVo();
			playerCardVo1.setName("Andre Miller");
			playerCardVo1.setTeam("ATL");
			playerCardVo1.setPosition("前锋");
			playerCardVo1.setSortOption(option);
			playerCardVo1.setSortvalue(27.8);
			;
			playerCardVo1.setNumber("19");
			playerCardVos.add(playerCardVo1);
			PlayerCardVo playerCardVo2 = new PlayerCardVo();
			playerCardVo2.setName("David Lee");
			playerCardVo2.setTeam("LAC");
			playerCardVo2.setPosition("后卫");
			playerCardVo2.setSortOption(option);
			playerCardVo2.setSortvalue(19.6);
			playerCardVo2.setNumber("6");
			playerCardVos.add(playerCardVo2);
			PlayerCardVo playerCardVo3 = new PlayerCardVo();
			playerCardVo3.setName("testHotPlayerDaily3");
			playerCardVo3.setTeam("DAL");
			playerCardVo3.setPosition("前锋");
			playerCardVo3.setSortOption(option);
			playerCardVo3.setSortvalue(24.8);
			;
			playerCardVo3.setNumber("20");
			playerCardVos.add(playerCardVo3);
			PlayerCardVo playerCardVo4 = new PlayerCardVo();
			playerCardVo4.setName("testHotPlayerDaily4");
			playerCardVo4.setTeam("MIA");
			playerCardVo4.setPosition("中锋");
			playerCardVo4.setSortOption(option);
			playerCardVo4.setSortvalue(33.7);
			playerCardVo4.setNumber("9");
			playerCardVos.add(playerCardVo4);
			PlayerCardVo playerCardVo5 = new PlayerCardVo();
			playerCardVo5.setName("testHotPlayerDaily5");
			playerCardVo5.setTeam("MIA");
			playerCardVo5.setPosition("后卫");
			playerCardVo5.setSortOption(option);
			playerCardVo5.setSortvalue(32.8);
			playerCardVo5.setNumber("18");
			playerCardVos.add(playerCardVo5);
		} else {

			PlayerCardVo playerCardVo1 = new PlayerCardVo();
			playerCardVo1.setName("David Lee");
			playerCardVo1.setTeam("ATL");
			playerCardVo1.setPosition("前锋");
			playerCardVo1.setSortOption(option);
			playerCardVo1.setSortvalue(27.8);
			;
			playerCardVo1.setNumber("19");
			playerCardVos.add(playerCardVo1);
			PlayerCardVo playerCardVo2 = new PlayerCardVo();
			playerCardVo2.setName("Andre Miller");
			playerCardVo2.setTeam("LAC");
			playerCardVo2.setPosition("后卫");
			playerCardVo2.setSortOption(option);
			playerCardVo2.setSortvalue(19.6);
			playerCardVo2.setNumber("6");
			playerCardVos.add(playerCardVo2);
			PlayerCardVo playerCardVo3 = new PlayerCardVo();
			playerCardVo3.setName("testHotPlayerDaily3");
			playerCardVo3.setTeam("DAL");
			playerCardVo3.setPosition("前锋");
			playerCardVo3.setSortOption(option);
			playerCardVo3.setSortvalue(24.8);
			;
			playerCardVo3.setNumber("20");
			playerCardVos.add(playerCardVo3);
			PlayerCardVo playerCardVo4 = new PlayerCardVo();
			playerCardVo4.setName("testHotPlayerDaily4");
			playerCardVo4.setTeam("MIA");
			playerCardVo4.setPosition("中锋");
			playerCardVo4.setSortOption(option);
			playerCardVo4.setSortvalue(33.7);
			playerCardVo4.setNumber("9");
			playerCardVos.add(playerCardVo4);
			PlayerCardVo playerCardVo5 = new PlayerCardVo();
			playerCardVo5.setName("testHotPlayerDaily5");
			playerCardVo5.setTeam("MIA");
			playerCardVo5.setPosition("后卫");
			playerCardVo5.setSortOption(option);
			playerCardVo5.setSortvalue(32.8);
			playerCardVo5.setNumber("18");
			playerCardVos.add(playerCardVo5);

		}
		return playerCardVos;
	}

	public ArrayList<PlayerCardVo> hotPlayerSeason(String option) {
		ArrayList<PlayerCardVo> playerCardVos = new ArrayList<PlayerCardVo>();
		if (option == "scoreField") {

			PlayerCardVo playerCardVo1 = new PlayerCardVo();
			playerCardVo1.setName("Raymond Felton");
			playerCardVo1.setTeam("ATL");
			playerCardVo1.setPosition("前锋");
			playerCardVo1.setSortOption(option);
			playerCardVo1.setSortvalue(27.8);
			;
			playerCardVo1.setNumber("19");
			playerCardVos.add(playerCardVo1);
			PlayerCardVo playerCardVo2 = new PlayerCardVo();
			playerCardVo2.setName("Kobe Bryant");
			playerCardVo2.setTeam("LAC");
			playerCardVo2.setPosition("后卫");
			playerCardVo2.setSortOption(option);
			playerCardVo2.setSortvalue(19.6);
			playerCardVo2.setNumber("6");
			playerCardVos.add(playerCardVo2);
			PlayerCardVo playerCardVo3 = new PlayerCardVo();
			playerCardVo3.setName("testHotPlayerDaily3");
			playerCardVo3.setTeam("DAL");
			playerCardVo3.setPosition("前锋");
			playerCardVo3.setSortOption(option);
			playerCardVo3.setSortvalue(24.8);
			;
			playerCardVo3.setNumber("20");
			playerCardVos.add(playerCardVo3);
			PlayerCardVo playerCardVo4 = new PlayerCardVo();
			playerCardVo4.setName("testHotPlayerDaily4");
			playerCardVo4.setTeam("MIA");
			playerCardVo4.setPosition("中锋");
			playerCardVo4.setSortOption(option);
			playerCardVo4.setSortvalue(33.7);
			playerCardVo4.setNumber("9");
			playerCardVos.add(playerCardVo4);
			PlayerCardVo playerCardVo5 = new PlayerCardVo();
			playerCardVo5.setName("testHotPlayerDaily5");
			playerCardVo5.setTeam("MIA");
			playerCardVo5.setPosition("后卫");
			playerCardVo5.setSortOption(option);
			playerCardVo5.setSortvalue(32.8);
			playerCardVo5.setNumber("18");
			playerCardVos.add(playerCardVo5);
		} else {

			PlayerCardVo playerCardVo1 = new PlayerCardVo();
			playerCardVo1.setName("Kobe Bryant");
			playerCardVo1.setTeam("ATL");
			playerCardVo1.setPosition("前锋");
			playerCardVo1.setSortOption(option);
			playerCardVo1.setSortvalue(27.8);
			;
			playerCardVo1.setNumber("19");
			playerCardVos.add(playerCardVo1);
			PlayerCardVo playerCardVo2 = new PlayerCardVo();
			playerCardVo2.setName("Raymond Felton");
			playerCardVo2.setTeam("LAC");
			playerCardVo2.setPosition("后卫");
			playerCardVo2.setSortOption(option);
			playerCardVo2.setSortvalue(19.6);
			playerCardVo2.setNumber("6");
			playerCardVos.add(playerCardVo2);
			PlayerCardVo playerCardVo3 = new PlayerCardVo();
			playerCardVo3.setName("testHotPlayerDaily3");
			playerCardVo3.setTeam("DAL");
			playerCardVo3.setPosition("前锋");
			playerCardVo3.setSortOption(option);
			playerCardVo3.setSortvalue(24.8);
			;
			playerCardVo3.setNumber("20");
			playerCardVos.add(playerCardVo3);
			PlayerCardVo playerCardVo4 = new PlayerCardVo();
			playerCardVo4.setName("testHotPlayerDaily4");
			playerCardVo4.setTeam("MIA");
			playerCardVo4.setPosition("中锋");
			playerCardVo4.setSortOption(option);
			playerCardVo4.setSortvalue(33.7);
			playerCardVo4.setNumber("9");
			playerCardVos.add(playerCardVo4);
			PlayerCardVo playerCardVo5 = new PlayerCardVo();
			playerCardVo5.setName("testHotPlayerDaily5");
			playerCardVo5.setTeam("MIA");
			playerCardVo5.setPosition("后卫");
			playerCardVo5.setSortOption(option);
			playerCardVo5.setSortvalue(32.8);
			playerCardVo5.setNumber("18");
			playerCardVos.add(playerCardVo5);

		}
		return playerCardVos;
	}

	@Override
	public ArrayList<PlayerCardVo> progressFastPlayer(String option) {
		ArrayList<PlayerCardVo> playerCardVos = new ArrayList<PlayerCardVo>();
		PlayerCardVo playerCardVo1 = new PlayerCardVo();
		playerCardVo1.setName("Andre Miller");
		playerCardVo1.setTeam("ATL");
		playerCardVo1.setPosition("前锋");
		playerCardVo1.setSortOption(option);
		playerCardVo1.setSortvalue(27.8);
		;
		playerCardVo1.setNumber("19");
		playerCardVos.add(playerCardVo1);
		PlayerCardVo playerCardVo2 = new PlayerCardVo();
		playerCardVo2.setName("David Lee");
		playerCardVo2.setTeam("LAC");
		playerCardVo2.setPosition("后卫");
		playerCardVo2.setSortOption(option);
		playerCardVo2.setSortvalue(22.2);
		playerCardVo2.setNumber("6");
		playerCardVos.add(playerCardVo2);
		PlayerCardVo playerCardVo3 = new PlayerCardVo();
		playerCardVo3.setName("testHotPlayerDaily3");
		playerCardVo3.setTeam("DAL");
		playerCardVo3.setPosition("前锋");
		playerCardVo3.setSortOption(option);
		playerCardVo3.setSortvalue(24.8);
		;
		playerCardVo3.setNumber("20");
		playerCardVos.add(playerCardVo3);
		PlayerCardVo playerCardVo4 = new PlayerCardVo();
		playerCardVo4.setName("testHotPlayerDaily4");
		playerCardVo4.setTeam("MIA");
		playerCardVo4.setPosition("中锋");
		playerCardVo4.setSortOption(option);
		playerCardVo4.setSortvalue(33.7);
		playerCardVo4.setNumber("9");
		playerCardVos.add(playerCardVo4);
		PlayerCardVo playerCardVo5 = new PlayerCardVo();
		playerCardVo5.setName("testHotPlayerDaily5");
		playerCardVo5.setTeam("MIA");
		playerCardVo5.setPosition("后卫");
		playerCardVo5.setSortOption(option);
		playerCardVo5.setSortvalue(32.8);
		playerCardVo5.setNumber("18");
		playerCardVos.add(playerCardVo5);
		return playerCardVos;
	}

	@Override
	public PlayerRecentGames getPlayerRecentPerformance(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}