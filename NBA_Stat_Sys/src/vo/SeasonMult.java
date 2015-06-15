package vo;

import java.util.ArrayList;

public class SeasonMult {

	private String season;
	public  ArrayList<PlayerVo> listvo;
	public ArrayList<TeamVo> teamlistvo;
	public ArrayList<GameVo> gamevo;
	public ArrayList<PlayerGames> listpg;
	public TotalInfo ti;
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
}
