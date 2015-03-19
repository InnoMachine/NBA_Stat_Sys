/**
 * puppy
 * 2015年3月9日 上午10:32:45
 * TODO
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

import jdbc_tools.DBUtil;
import po.Conference;
import po.Division;
import po.GamePO;
import po.TeamPO;

public class GameDaoImpl implements GameDao {

	@Override
	public void add(GamePO game) {
		
		String sql = "insert into nba.game(gamelabel,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameLabel());
			pstmt.setString(2, game.getGameDate());
			pstmt.setString(3, game.getVersus());
			pstmt.setString(4, game.getGuestTeam());
			pstmt.setString(5, game.getHomeTeam());
			pstmt.setString(6, game.getScoreOverall().toString());
			pstmt.setString(7, game.getScore1st().toString());
			pstmt.setString(8, game.getScore2nd().toString());
			pstmt.setString(9, game.getScore3rd().toString());
			pstmt.setString(10, game.getScore4th().toString());
			pstmt.setString(11, game.getExtratime().toString());
			pstmt.setString(12, game.getGuestTP().toString());
			pstmt.setString(13, game.getHomeTP().toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void update(GamePO game) {

		String sql = "update nba.game set gamelabel=?,gamedate=?,versus=?,guestteam=?,hometeam=?,scoreoverall=?,score1st=?,score2nd=?,score3rd=?,score4th=?,extratime=?,guesttp=?,hometp=? where gamelabel=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, game.getGameLabel());
			pstmt.setString(2, game.getGameDate());
			pstmt.setString(3, game.getVersus());
			pstmt.setString(4, game.getGuestTeam());
			pstmt.setString(5, game.getHomeTeam());
			pstmt.setString(6, game.getScoreOverall().toString());
			pstmt.setString(7, game.getScore1st().toString());
			pstmt.setString(8, game.getScore2nd().toString());
			pstmt.setString(9, game.getScore3rd().toString());
			pstmt.setString(10, game.getScore4th().toString());
			pstmt.setString(11, game.getExtratime().toString());
			pstmt.setString(12, game.getGuestTP().toString());
			pstmt.setString(13, game.getHomeTP().toString());
			
			pstmt.setString(14, game.getGameLabel());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteGameByLabel(String label) {

		String sql = "delete from nba.game where gamelabel=?";
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
		String sql = "select gamelabel,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp from nba.game where gamelabel=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, label);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				game.setGameLabel(rs.getString("gamelabel"));
				game.setGameDate(rs.getString("gamedate"));
				game.setVersus(rs.getString("versus"));
				game.setGuestTeam(rs.getString("guestteam"));
				game.setHomeTeam(rs.getString("hometeam"));
				//sudo
				//game.setScoreOverall(rs.getString("scoreoverall"));
				//game.setScore1st(rs.getString("score1st"));
				//game.setScore2nd(rs.getString("score2nd"));
				//game.setScore3rd(rs.getString("score3rd"));
				//game.setScore4th(rs.getString("score4th"));
				//game.setExtratime(rs.getString("extratime"));
				//game.setGuestTP(rs.getString("guesttp"));
				//game.setHomeTP(rs.getString("hometp"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return game;
	}

	@Override
	public ArrayList<GamePO> getAllGames() {
		
		ArrayList<GamePO> gameList = new ArrayList<GamePO>();
		String sql = "select gamelabel,gamedate,versus,guestteam,hometeam,scoreoverall,score1st,score2nd,score3rd,score4th,extratime,guesttp,hometp from nba.game";
		Connection conn = DBUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				GamePO game = new GamePO();
				game.setGameLabel(rs.getString("gamelabel"));
				game.setGameDate(rs.getString("gamedate"));
				game.setVersus(rs.getString("versus"));
				game.setGuestTeam(rs.getString("guestteam"));
				game.setHomeTeam(rs.getString("hometeam"));
				//sudo
				//game.setScoreOverall(rs.getString("scoreoverall"));
				//game.setScore1st(rs.getString("score1st"));
				//game.setScore2nd(rs.getString("score2nd"));
				//game.setScore3rd(rs.getString("score3rd"));
				//game.setScore4th(rs.getString("score4th"));
				//game.setExtratime(rs.getString("extratime"));
				//game.setGuestTP(rs.getString("guesttp"));
				//game.setHomeTP(rs.getString("hometp"));
				//sudo
				//sudo
				
				gameList.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return gameList;
	}

}
