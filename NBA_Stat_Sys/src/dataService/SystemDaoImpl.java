/**
 * puppy
 * Apr 8, 2015 9:43:03 PM
 * TODO
 */
package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import databaseMysqlUtility.DBUtil;
import po.GameDate;
import po.SeasonTracker;

public class SystemDaoImpl implements SystemDao {

	@Override
	public void add(SeasonTracker st) {

			String sql = "insert into nba.system(currentdate,seasonid)values(?,?)";
			Connection conn = DBUtil.open();
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, st.getCurrentDate().toString());
				pstmt.setString(2, st.getSeasonId());
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtil.close(conn);
			}
	}

	@Override
	public void update(SeasonTracker st) {

		String sql = "update nba.system set currentdate=? where seasonid=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,st.getCurrentDate().toString());
			pstmt.setString(2,st.getSeasonId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public void deleteSeasonById(String id) {
		String sql = "delete from nba.system where seasonid=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}

	@Override
	public SeasonTracker getStById(String id) {

		SeasonTracker st = new SeasonTracker();
		String sql = "select currentdate,seasonid from nba.system where seasonid=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				st.setCurrentDate(new GameDate(rs.getString("currentdate")));
				st.setSeasonId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return st;
		
	}

	@Override
	public ArrayList<SeasonTracker> getAllSeasons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUpdateGameList(ArrayList<String> gameList) {
		String sql = "update nba.system set updategamelist=? where seasonid=?";
		String result = new String();
		for(String game: gameList) {
			result += (game + ";");
		}
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,result);
			pstmt.setString(2,"12-13");
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public ArrayList<String> getUpdateGameList(String seasonID) {
		
		String sql = "select updategamelist from nba.system where seasonid=?";
		Connection conn = DBUtil.open();
		String got = new String();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seasonID);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				got = rs.getString("updategamelist");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		String[] array = got.split(";");
		
		ArrayList<String> result = new ArrayList<String>();
		for(String single: array) {
			result.add(single);
		}
		return result;
	}



}
