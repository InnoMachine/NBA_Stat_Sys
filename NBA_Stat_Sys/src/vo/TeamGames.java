package vo;

import java.util.ArrayList;

public class TeamGames {
	private String name;
	private ArrayList<TeamPerformanceInSingleGame> games;
	public TeamGames(String name){
		this.setName(name);
		games = new ArrayList<TeamPerformanceInSingleGame>();
	}
	public TeamGames(){
		games = new ArrayList<TeamPerformanceInSingleGame>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<TeamPerformanceInSingleGame> getGames() {
		return games;
	}
	public void setGames(ArrayList<TeamPerformanceInSingleGame> games) {
		this.games = games;
	}
	public void AddGames(TeamPerformanceInSingleGame newgame){
		this.games.add(newgame);
	}
}
