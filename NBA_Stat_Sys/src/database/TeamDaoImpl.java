/**
 * puppy
 * 2015年3月9日 上午10:26:13
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
import po.TeamPO;

public class TeamDaoImpl implements TeamDao {

	@Override
	public void add(TeamPO team) {

		String sql = "insert into nba.teams(teamname,abbreviation,city,conference,division,homefield,birthyear,imgpath)values(?,?,?,?,?,?,?,?)";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team.getTeamName());
			pstmt.setString(2, team.getAbbreviation());
			pstmt.setString(3, team.getCity());
			pstmt.setString(4, team.getConference().toString());
			pstmt.setString(5, team.getDivision().toString());
			pstmt.setString(6, team.getHomeField());
			pstmt.setString(7, team.getBirthYear());
			pstmt.setString(8, team.getImgPath());
			//pstmt.setString(9, team.getPlayers().toString());//sudo
			//pstmt.setString(10, team.getSeansonTeamPerformance().toString());//sudo
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void update(TeamPO team) {
		
		String sql = "update nba.teams set teamname=?,abbreviation=?,city=?,conference=?,division=?,homefield=?,birthyear=?,imgpath=? where abbr=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team.getTeamName());
			pstmt.setString(2, team.getAbbreviation());
			pstmt.setString(3, team.getCity());
			pstmt.setString(4, team.getConference().toString());
			pstmt.setString(5, team.getDivision().toString());
			pstmt.setString(6, team.getHomeField());
			pstmt.setString(7, team.getBirthYear());
			pstmt.setString(8, team.getImgPath());
			//pstmt.setString(9, team.getPlayers().toString());
			//pstmt.setString(10, team.getSeansonTeamPerformance().toString());
			
			pstmt.setString(11, team.getAbbreviation());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void deleteTeamByAbbr(String abbr) {

		String sql = "delete from nba.teams where abbreviation=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, abbr);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public TeamPO getTeamByAbbr(String abbr) {
		
		TeamPO team = new TeamPO();
		String sql = "select teamname,abbreviation,city,conference,division,homefield,birthyear,imgpath from nba.teams where abbr=?";
		Connection conn = DBUtil.open();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, abbr);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				team.setTeamName(rs.getString("teamname"));
				team.setAbbreviation(rs.getString("abbreviation"));
				team.setCity(rs.getString("city"));
				Conference conf = Conference.valueOf(rs.getString("conference").toUpperCase(Locale.ENGLISH));
				team.setConference(conf);
				Division div = Division.valueOf(rs.getString("division").toUpperCase(Locale.ENGLISH));
				team.setDivision(div);
				team.setHomeField(rs.getString("homefield"));
				team.setBirthYear(rs.getString("birthyear"));
				team.setImgPath(rs.getString("imgpath"));
				//team.setPlayers(rs.getString("players"));//sudo
				//team.setSeasonTeamPerformance(rs.getString("seasontp"))//sudo
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return team;
		
	}

	@Override
	public ArrayList<TeamPO> getAllTeams() {
		
		ArrayList<TeamPO> teamList = new ArrayList<TeamPO>();
		String sql = "select teamname,abbreviation,city,conference,division,homefield,birthyear,imgpath from nba.teams";
		Connection conn = DBUtil.open();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				TeamPO team = new TeamPO();
				team.setTeamName(rs.getString("teamname"));
				team.setAbbreviation(rs.getString("abbreviation"));
				team.setCity(rs.getString("city"));
				Conference conf = Conference.valueOf(rs.getString("conference").toUpperCase(Locale.ENGLISH));
				team.setConference(conf);
				Division div = Division.valueOf(rs.getString("division").toUpperCase(Locale.ENGLISH));
				team.setDivision(div);
				team.setHomeField(rs.getString("homefield"));
				team.setBirthYear(rs.getString("birthyear"));
				team.setImgPath(rs.getString("imgpath"));
				//sudo
				//sudo
				
				teamList.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		return teamList;
		
	}

}
