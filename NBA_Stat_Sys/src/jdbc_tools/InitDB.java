/**
 * puppy
 * 2015年3月8日 上午0:30:55
 * TODO
 */
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
		
		String sql1 = "create table if not exists nba.teams"
				+ "( teamname varchar(20),"
				+ " abbreviation varchar(5),"
				+ " city varchar(20),"
				+ " conference varchar(2),"
				+ " division varchar(15),"
				+ " homefield varchar(40),"
				+ " birthyear varchar(10),"
				+ " imgPath varchar(40) )";
		
		String sql2 = "create table if not exists nba.players( name varchar(30))";
		String sql3 = "create table if not exists nba.games( hometeam varchar(30))";
		
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
