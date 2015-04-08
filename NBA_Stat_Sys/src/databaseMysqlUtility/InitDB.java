/**
 * puppy
 * 2015年3月8日 上午0:30:55
 * TODO
 */
package databaseMysqlUtility;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDB {

	public static void init() {
		
		Connection conn = DBUtil.open();
		
		String sqlOld = "drop database if exists nba";
		String sqlNew = "create database if not exists nba";
		
		String sql1 = "create table if not exists nba.teams("
				+ " teamname varchar(20) NOT NULL,"
				+ " abbreviation varchar(5) PRIMARY KEY,"
				+ " city varchar(20) NOT NULL,"
				+ " conference varchar(2) NOT NULL,"
				+ " division varchar(15) NOT NULL,"
				+ " homefield varchar(40) NOT NULL,"
				+ " birthyear varchar(10) NOT NULL,"
				+ " imgPath varchar(40) NOT NULL,"
				+ " players varchar(500),"
				+ " seasontp text)";//sudo
		
		String sql2 = "create table if not exists nba.players("
				+ " name varchar(30) PRIMARY KEY,"
				+ " number varchar(10),"
				+ " position varchar(5),"
				+ " height varchar(5),"
				+ " weight varchar(5),"
				+ " birth varchar(15),"
				+ " age int,"
				+ " exp int,"
				+ " school varchar(60),"
				+ " actionimgpath varchar(100),"
				+ " portraitimgpath varchar(100),"
				+ " seasonsp text )";//sudo
		
		String sql3 = "create table if not exists nba.games("
				+ " gamelabel varchar(40) PRIMARY KEY,"
				+ " gamedate varchar(30),"
				+ " versus varchar(10),"
				+ " guestteam varchar(5),"
				+ " hometeam varchar(5),"
				+ " scoreoverall varchar(10),"
				+ " score1st varchar(10),"
				+ " score2nd varchar(10),"
				+ " score3rd varchar(10),"
				+ " score4th varchar(10),"
				+ " extratime varchar(50),"
				+ " guesttp text,"
				+ " hometp text)";
		
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
		System.out.println("------------------------------");
		System.out.println("Database tables initialized!");
		System.out.println("------------------------------");
	}

}
