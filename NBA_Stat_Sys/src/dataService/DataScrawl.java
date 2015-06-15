package dataService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import po.GamePO;
import po.Scoreboard;
import po.SinglePerformance;
import po.TeamPerformance;

public class DataScrawl {

	public static void main(String[] args) {
<<<<<<< HEAD
		for(int i = 2000; i < 2015; i ++) {
			addGameList(i);
		}
		
=======

>>>>>>> origin/master
	}
	
	public static GamePO getGamePO(String year, String id) {
		
		//98-99 725 games in total
		//03-04 82*29/2 = 1189
		//11-12 66*15 = 990
		//1230
//		String year = "02";//89
//		String id = "1189";//1230
		String myfullgameid = "002"+year+"0"+id;
		String myseasonid;
		if(Integer.parseInt(year) > 40) {
			myseasonid = "19" + year + "-" + (year+1);
		}else {
			if (Integer.parseInt(year) < 9) {
				myseasonid = "20" + year + "-0" + (Integer.parseInt(year)+1);
			}else {
				myseasonid = "20" + year + "-" + (Integer.parseInt(year)+1);
			}
			
		}
		System.out.println("-----------------------------------");
		System.out.println("gameID: " + myfullgameid);
		String json1 = getJsonContent("http://stats.nba.com/stats/boxscoresummaryv2?GameID="+myfullgameid);
		String json2 = getJsonContent("http://stats.nba.com/stats/boxscoretraditionalv2?EndPeriod=10&EndRange=28800&GameID=" + myfullgameid + "&RangeType=2&Season=" + myseasonid + "&SeasonType=Regular+Season&StartPeriod=1&StartRange=0");
		if(json1.equals("")) {
			System.out.println("json1 empty");
			return null;
		}else {
			System.out.println(json1);
		}
		if(json2.equals("")) {
			System.out.println("json2 empty");
			return null;
		}else {
			System.out.println(json2);
		}
		JSONObject gameJsonObject =  JSON.parseObject(json1, JSONObject.class);
		JSONObject gameSummary = gameJsonObject.getJSONArray("resultSets").getJSONObject(0);
		int period = Integer.parseInt(gameSummary.getJSONArray("rowSet").getJSONArray(0).getString(9));
		JSONObject LineScore = gameJsonObject.getJSONArray("resultSets").getJSONObject(5);
		JSONArray homeArray = LineScore.getJSONArray("rowSet").getJSONArray(0);
		JSONArray visitorArray = LineScore.getJSONArray("rowSet").getJSONArray(1);
		JSONObject playsJsonObject =  JSON.parseObject(json2, JSONObject.class);
		JSONArray players = playsJsonObject.getJSONArray("resultSets").getJSONObject(0).getJSONArray("rowSet");
		GamePO game = new GamePO();
		String gameDate = gameSummary.getJSONArray("rowSet").getJSONArray(0).getString(0).substring(0, 10);
		String seasonId = myseasonid.substring(2, 7);
		String hometeam = homeArray.getString(4);
		String visitorteam = visitorArray.getString(4);
		String versus = visitorteam + "-" + hometeam;
		String gameLabel = seasonId + "_" + gameDate + "_" + versus;
		String score1st = visitorArray.getString(8) + "-" + homeArray.getString(8);
		String score2nd = visitorArray.getString(9) + "-" + homeArray.getString(9);
		String score3rd = visitorArray.getString(10) + "-" + homeArray.getString(10);
		String score4th = visitorArray.getString(11) + "-" + homeArray.getString(11);
		String totalScore = visitorArray.getString(22) + "-" + homeArray.getString(22);
		ArrayList<Scoreboard> extratime = new ArrayList<Scoreboard>();
		int plusNumber = period - 4;
		if(plusNumber > 0) {
			for(int i = 0; i < plusNumber; i ++) {
				extratime.add(Scoreboard.makeSB(visitorArray.getString(12+i) + "-" + homeArray.getString(12+i)));
			}
		}
		ArrayList<TeamPerformance> tps = getTPs(players, gameLabel, hometeam, visitorteam);
		game.setGameDate(gameDate);
		game.setSeasonId(seasonId);
		game.setHomeTeam(hometeam);
		game.setGuestTeam(visitorteam);
		game.setVersus(versus);
		game.setGameLabel(gameLabel);
		game.setScoreOverall(Scoreboard.makeSB(totalScore));
		game.setScore1st(Scoreboard.makeSB(score1st));
		game.setScore2nd(Scoreboard.makeSB(score2nd));
		game.setScore3rd(Scoreboard.makeSB(score3rd));
		game.setScore4th(Scoreboard.makeSB(score4th));
		game.setExtratime(extratime);
		game.setHomeTP(tps.get(0));
		game.setGuestTP(tps.get(1));
		return game;
	}
	
	public static ArrayList<TeamPerformance> getTPs(JSONArray players, String gamelabel, String homeTeam, String guestTeam) {
		
		TeamPerformance homeTP = new TeamPerformance();
		TeamPerformance guestTP = new TeamPerformance();
		ArrayList<TeamPerformance> result = new ArrayList<TeamPerformance>();
		homeTP.setGamelabel(gamelabel);
		guestTP.setGamelabel(gamelabel);
		homeTP.setTeamNameAbbr(homeTeam);
		guestTP.setTeamNameAbbr(guestTeam);
		SinglePerformance sp;
		for(int i = 0; i < players.size(); i ++) {
			sp = getSinglePerformanceFromJsonArray(players.getJSONArray(i), gamelabel);
			if(sp.getTeamThen().equals(homeTeam)) {
				homeTP.addSinglePerformance(sp);
			}else {
				guestTP.addSinglePerformance(sp);
			}
		}
		result.add(homeTP);
		result.add(guestTP);
		return result;
	}
	
	public static SinglePerformance getSinglePerformanceFromJsonArray(JSONArray playerJsonArray, String gamelabel) {
		
		SinglePerformance sp = new SinglePerformance();
		sp.setGamelabel(gamelabel);
		sp.setTeamThen(playerJsonArray.getString(2));
		sp.setName(playerJsonArray.getString(5));
		sp.setPosition(playerJsonArray.getString(6));
		sp.setTimeBySeconds(getTimeBySec(playerJsonArray.getString(8)));
		sp.setHitNum(playerJsonArray.getIntValue(9));
		sp.setShotNum(playerJsonArray.getIntValue(10));
		sp.setThreePointHitNum(playerJsonArray.getIntValue(12));
		sp.setThreePointShotNum(playerJsonArray.getIntValue(13));
		sp.setFreeThrowHitNum(playerJsonArray.getIntValue(15));
		sp.setFreeThrowShotNum(playerJsonArray.getIntValue(16));
		sp.setOffensiveRebound(playerJsonArray.getIntValue(18));
		sp.setDefensiveRebound(playerJsonArray.getIntValue(19));
		sp.setReboundOverall(playerJsonArray.getIntValue(20));
		sp.setAssistance(playerJsonArray.getIntValue(21));
		sp.setSteal(playerJsonArray.getIntValue(22));
		sp.setBlock(playerJsonArray.getIntValue(23));
		sp.setTurnover(playerJsonArray.getIntValue(24));
		sp.setFoul(playerJsonArray.getIntValue(25));
		sp.setScore(playerJsonArray.getIntValue(26));
		return sp;
		//"GAME_ID","TEAM_ID","TEAM_ABBREVIATION","TEAM_CITY","PLAYER_ID","PLAYER_NAME","START_POSITION","COMMENT","MIN","FGM","FGA","FG_PCT","FG3M","FG3A","FG3_PCT","FTM","FTA","FT_PCT","OREB","DREB","REB","AST","STL","BLK","TO","PF","PTS","PLUS_MINUS"
		//["0020000001",1610612755,"PHI","Philadelphia",238,"Tyrone Hill","F","","22:07",3,5,0.600,0,0,0.000,0,0,0.000,2,2,4,0,0,2,4,3,6,17.000]
	}
	
	public static int getTimeBySec(String timeText) {//12:24
		if(timeText == null || timeText.equals("")) {
			return 0;
		}
		String[] splitedTime = timeText.split(":");
		int timeBySec = Integer.parseInt(splitedTime[0]) * 60
				+ Integer.parseInt(splitedTime[1]);
		return timeBySec;
	}
	
	public static void addGameList(int yearFormat) {//2000
		
		String year = (yearFormat+"").substring(2, 4);
		int id;
		if(yearFormat >= 2000 && yearFormat <= 2003) {
			id = 1189;
		}else if(yearFormat == 2011) {
			id = 990;
		}else {
			id = 1230;
		}
		for(int i = 1; i <= id; i ++) {
			GamePO game = getGamePO(year, getFormat4bit(i));
			if(game == null) {
				System.out.println("error! this game will be ignored!");
			}else {
				DaoFactory.getGameDaoInstence().add(game);
			}
		}
	}
	
	public static String getSeasonidFromYear() {
		return null;
	}
	
	public static String getFormat4bit(int num) {//1 -> "0001"
		if(num <= 9 && num >= 1) {
			return "000" + num;
		}else if(num <= 99 && num >= 10) {
			return "00" + num;
		}else if(num <= 999 && num >= 100) {
			return "0" + num;
		}else {
			return "" + num;
		}
	}
	
	public static String getJsonContent(String urlStr) {
		
		try {// 获取HttpURLConnection连接对象
            URL url = new URL(urlStr);
            HttpURLConnection httpConn = (HttpURLConnection) url
                    .openConnection();
            // 设置连接属性
            httpConn.setConnectTimeout(3000);
            httpConn.setDoInput(true);
            httpConn.setRequestMethod("GET");
            // 获取相应码
            int respCode = httpConn.getResponseCode();
            if (respCode == 200) {
                return ConvertStream2Json(httpConn.getInputStream());
            }
        }
        catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return "";
	}
	
	public static String ConvertStream2Json(InputStream inputStream) {
		
        String jsonStr = "";
        // ByteArrayOutputStream相当于内存输出流
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        
        // 将输入流转移到内存输出流中
        try {
            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, len);
            }
            // 将内存流转换为字符串
            jsonStr = new String(out.toByteArray());
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return jsonStr;
    }

}
