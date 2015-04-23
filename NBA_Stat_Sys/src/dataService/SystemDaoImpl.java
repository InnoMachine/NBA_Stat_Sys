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
				System.out.println("addddddddddddddd");
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
				st.setCurrentDate(new GameDate(rs.getString("seasonrecord")));
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

}
