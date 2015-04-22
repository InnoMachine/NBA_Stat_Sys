/**
 * puppy
 * 2015年3月9日 上午10:26:13
 * TODO
 */
package dataService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Locale;

import databaseMysqlUtility.DBUtil;
import enums.Conference;
import enums.Division;
import po.TeamPO;
import po.TeamPerformance;

/*
 * String getString(int columnIndex)
                 throws SQLException
Retrieves the value of the designated column in the current row of this ResultSet object as a String in the Java programming language.
@Parameters:
columnIndex - the first column is 1, the second is 2, ...
#Returns:
the column value; if the value is SQL NULL, the value returned is null
@Throws:
SQLException - if the columnIndex is not valid; if a database access error occurs or this method is called on a closed result set
 */

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
			//pstmt.setString(9, team.getPlayers().toString());//no need to do this
			//pstmt.setString(10, team.getSeansonTeamPerformance().toString());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
	}

	@Override
	public void update(TeamPO team) {
		
		String sql = "update nba.teams set teamname=?,abbreviation=?,city=?,conference=?,division=?,homefield=?,birthyear=?,imgpath=?,currentplayers=?,seasontp=? where abbreviation=?";
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
			
			String playNameList = new String();
			for(String playerName: team.getCurrentPlayersNameList()){
				playNameList += (playerName+";");
			}
			pstmt.setString(9, playNameList);
			
			String seasontpList = new String();
			if(team.getSeansonTeamPerformance() != null){
				for(TeamPerformance tp: team.getSeansonTeamPerformance()){
					seasontpList += (tp.toString()+"$");//set $ as splitor
				}
			}
			pstmt.setString(10, seasontpList);
			
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
		String sql = "select teamname,abbreviation,city,conference,division,homefield,birthyear,imgpath,currentplayers,seasontp from nba.teams where abbreviation=?";
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
				
				//判断一个引用类型数据是否null。 用==来判断。
				
				if(rs.getString("currentplayers") != null){
					String playerListText = rs.getString("currentplayers");
					String[] splited = playerListText.split(";");
					ArrayList<String> playerNameList = new ArrayList<String>();
					for(String playerName:splited){
						playerNameList.add(playerName);
					}
					team.setCurrentPlayersNameList(playerNameList);
				}
				
				
				if(rs.getString("seasontp") != null){
					String seasontpText = rs.getString("seasontp");
					String[] splited = seasontpText.split("\\$");
					ArrayList<TeamPerformance> tpList = new ArrayList<TeamPerformance>();
					for(String tp:splited){
						tpList.add(TeamPerformance.makeTP(tp));
					}
					team.setSeansonTeamPerformance(tpList);
				}
				
				
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
		String sql = "select teamname,abbreviation,city,conference,division,homefield,birthyear,imgpath,currentplayers,seasontp from nba.teams";
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
				
				if(rs.getString("currentplayers") != null){
					String playerListText = rs.getString("currentplayers");
					String[] splited = playerListText.split(";");
					ArrayList<String> playerNameList = new ArrayList<String>();
					for(String playerName:splited){
						playerNameList.add(playerName);
					}
					team.setCurrentPlayersNameList(playerNameList);
				}
				
				if(rs.getString("seasontp") != null){
					String seasontpText = rs.getString("seasontp");
					String[] splited = seasontpText.split("\\$");
					ArrayList<TeamPerformance> tpList = new ArrayList<TeamPerformance>();
					for(String tp:splited){
						tpList.add(TeamPerformance.makeTP(rs.getString("abbreviation"), tp.split(";")[0], tp));
					}
					team.setSeansonTeamPerformance(tpList);
				}
				
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
