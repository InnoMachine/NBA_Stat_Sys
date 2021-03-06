/**
 * puppy
 * 2015年3月9日 上午10:32:45
 * TODO
 */
package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import databaseMysqlUtility.DBUtil;
import po.GamePO;
import po.Scoreboard;
import po.TeamPerformance;

public class GameDaoImpl implements GameDao {

	@Override
	public void add(GamePO game) {
		
		String sql = "insert into nba.games(gamelabel,seasonid,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameLabel());
			pstmt.setString(2, game.getSeasonId());
			pstmt.setString(3, game.getGameDate().toString());
			pstmt.setString(4, game.getVersus());
			pstmt.setString(5, game.getGuestTeam());
			pstmt.setString(6, game.getHomeTeam());
			pstmt.setString(7, game.getScoreOverall().toString());
			pstmt.setString(8, game.getScore1st().toString());
			pstmt.setString(9, game.getScore2nd().toString());
			pstmt.setString(10, game.getScore3rd().toString());
			pstmt.setString(11, game.getScore4th().toString());
			String extraText = "";
			for(int i =0; i < game.getExtratime().size(); i ++){
				extraText += (game.getExtratime().get(i).toString()+";");
			}
			pstmt.setString(12, extraText);
			pstmt.setString(13, game.getGuestTP().toString());
			pstmt.setString(14, game.getHomeTP().toString());
			
			pstmt.executeUpdate();
		} catch (MySQLIntegrityConstraintViolationException e) {
			System.out.println("this game already exists!");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void update(GamePO game) {
		
		String sql = "update nba.games set gamelabel=?,seasonid=?,gamedate=?,versus=?,guestteam=?,hometeam=?,scoreoverall=?,score1st=?,score2nd=?,score3rd=?,score4th=?,extratime=?,guesttp=?,hometp=? where gamelabel=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameLabel());
			pstmt.setString(2, game.getSeasonId());
			pstmt.setString(3, game.getGameDate().toString());
			pstmt.setString(4, game.getVersus());
			pstmt.setString(5, game.getGuestTeam());
			pstmt.setString(6, game.getHomeTeam());
			pstmt.setString(7, game.getScoreOverall().toString());
			pstmt.setString(8, game.getScore1st().toString());
			pstmt.setString(9, game.getScore2nd().toString());
			pstmt.setString(10, game.getScore3rd().toString());
			pstmt.setString(11, game.getScore4th().toString());
			String extraText = "";
			for(int i =0; i < game.getExtratime().size(); i ++){
				extraText += (game.getExtratime().get(i).toString()+";");
			}
			pstmt.setString(12, extraText);
			pstmt.setString(13, game.getGuestTP().toString());
			pstmt.setString(14, game.getHomeTP().toString());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteGameByLabel(String label) {

		String sql = "delete from nba.games where gamelabel=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, label);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public GamePO getGameByLabel(String label) {

		GamePO game = new GamePO();
		String sql = "select gamelabel,seasonid,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp from nba.games where gamelabel=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, label);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				game.setGameLabel(rs.getString("gamelabel"));
				game.setSeasonId(rs.getString("seasonid"));
				game.setGameDate(rs.getString("gamedate"));
				game.setVersus(rs.getString("versus"));
				game.setGuestTeam(rs.getString("guestteam"));
				game.setHomeTeam(rs.getString("hometeam"));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("scoreoverall")));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("score1st")));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("score2nd")));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("score3rd")));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("score4th")));
				ArrayList<Scoreboard> extraList = new ArrayList<Scoreboard>();
				String extraText = rs.getString("extratime");
				if(extraText.contains(";")){
					String[] splitedExtra = extraText.split(";");
					for(int j = 0; j < splitedExtra.length; j ++){
						extraList.add(Scoreboard.makeSB(splitedExtra[j]));
					}
				}
				game.setExtratime(extraList);
				game.setGuestTP(TeamPerformance.makeTP(rs.getString("guesttp")));
				game.setHomeTP(TeamPerformance.makeTP(rs.getString("hometp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return game;
	}

	@Override
	public ArrayList<GamePO> getAllGames(String season) {
		
		ArrayList<GamePO> gameList = new ArrayList<GamePO>();
		String seasonString = "'"+season+"'";
		String sql = "select gamelabel,seasonid,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp from nba.games where seasonid="+seasonString;
		Connection conn = DBUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			GamePO game;
			while(rs.next()){
				game = new GamePO();
				game.setGameLabel(rs.getString("gamelabel"));
				game.setSeasonId(rs.getString("seasonid"));
				game.setGameDate(rs.getString("gamedate"));
				game.setVersus(rs.getString("versus"));
				game.setGuestTeam(rs.getString("guestteam"));
				game.setHomeTeam(rs.getString("hometeam"));
				game.setScoreOverall(Scoreboard.makeSB(rs.getString("scoreoverall")));
				game.setScore1st(Scoreboard.makeSB(rs.getString("score1st")));
				game.setScore2nd(Scoreboard.makeSB(rs.getString("score2nd")));
				game.setScore3rd(Scoreboard.makeSB(rs.getString("score3rd")));
				game.setScore4th(Scoreboard.makeSB(rs.getString("score4th")));
				ArrayList<Scoreboard> extraList = new ArrayList<Scoreboard>();
				String extraText = rs.getString("extratime");
				if(extraText.contains(";")){
					String[] splitedExtra = extraText.split(";");
					for(int j = 0; j < splitedExtra.length; j ++){
						extraList.add(Scoreboard.makeSB(splitedExtra[j]));
					}
				}
				game.setExtratime(extraList);
				game.setGuestTP(TeamPerformance.makeTP(rs.getString("guesttp")));
				game.setHomeTP(TeamPerformance.makeTP(rs.getString("hometp")));
				
				gameList.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return gameList;
	}

	@Override
	public ArrayList<GamePO> getNewGamePOs() {
		
		return getGameByLabel(DaoFactory.getSystemDaoInstance().getUpdateGameList("12-13"));
	}

	@Override
	public ArrayList<GamePO> getGameByLabel(ArrayList<String> labels) {
		ArrayList<GamePO> result = new ArrayList<GamePO>();
		for(String label: labels) {
			result.add(getGameByLabel(label));
		}
		return result;
	}

}
