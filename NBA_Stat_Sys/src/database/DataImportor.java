/**
 * puppy
 * 2015年3月9日 上午00:35:19
 * TODO
 */
package database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc_tools.DBUtil;

public class DataImportor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.open();
		
		
		String sql1 = "create table if not exists nba.teams"
				+ "( teamname varchar(20),"
				+ " abbreviation varchar(5),"
				+ " city varchar(20),"
				+ " conference varchar(2),"
				+ " division varchar(15),"
				+ " homefield varchar(40),"
				+ " birthyear varchar(10),"
				+ " imgPath varchar(40) )";
		
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.execute(sql1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBUtil.close(conn);	
		
	}
	

}
