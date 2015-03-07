package jdbc_tools;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import jdbc_tools.DBUtil;

public class InitDB {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.open();
		
		String sqlOld = "drop database if exists nba";
		String sqlNew = "create database if not exists nba";
		
		String sql1 = "create table if not exists nba.teams()";
		String sql2 = "create table if not exists nba.players()";
		String sql3 = "create table if not exists nba.games()";
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sqlOld);
			stmt.execute(sqlNew);
			
			stmt.execute(sql1);
			stmt.execute(sql2);
			stmt.execute(sql3);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);	
		
	}

}
